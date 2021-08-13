package com.heyue.wms.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.heyue.common.log.annotation.Log;
import com.heyue.common.log.enums.BusinessType;
import com.heyue.common.security.annotation.PreAuthorize;
import com.heyue.wms.domain.StockHistory;
import com.heyue.wms.service.IStockHistoryService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 库存快照Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/stockHistory")
public class StockHistoryController extends BaseController
{
    @Autowired
    private IStockHistoryService stockHistoryService;

    /**
     * 查询库存快照列表
     */
    @PreAuthorize(hasPermi = "wms:stockHistory:list")
    @GetMapping("/list")
    public TableDataInfo list(StockHistory stockHistory)
    {
        startPage();
        List<StockHistory> list = stockHistoryService.selectStockHistoryList(stockHistory);
        return getDataTable(list);
    }

    /**
     * 导出库存快照列表
     */
    @PreAuthorize(hasPermi = "wms:stockHistory:export")
    @Log(title = "库存快照", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, StockHistory stockHistory) throws IOException
    {
        List<StockHistory> list = stockHistoryService.selectStockHistoryList(stockHistory);
        ExcelUtil<StockHistory> util = new ExcelUtil<StockHistory>(StockHistory.class);
        util.exportExcel(response, list, "库存快照数据");
    }

    /**
     * 获取库存快照详细信息
     */
    @PreAuthorize(hasPermi = "wms:stockHistory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(stockHistoryService.selectStockHistoryById(id));
    }

    /**
     * 新增库存快照
     */
    @PreAuthorize(hasPermi = "wms:stockHistory:add")
    @Log(title = "库存快照", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody StockHistory stockHistory)
    {
        return toAjax(stockHistoryService.insertStockHistory(stockHistory));
    }

    /**
     * 修改库存快照
     */
    @PreAuthorize(hasPermi = "wms:stockHistory:edit")
    @Log(title = "库存快照", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody StockHistory stockHistory)
    {
        return toAjax(stockHistoryService.updateStockHistory(stockHistory));
    }

    /**
     * 删除库存快照
     */
    @PreAuthorize(hasPermi = "wms:stockHistory:remove")
    @Log(title = "库存快照", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stockHistoryService.deleteStockHistoryByIds(ids));
    }
}
