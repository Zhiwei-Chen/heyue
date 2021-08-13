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
import com.heyue.wms.domain.Stock;
import com.heyue.wms.service.IStockService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 库存Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/stock")
public class StockController extends BaseController
{
    @Autowired
    private IStockService stockService;

    /**
     * 查询库存列表
     */
    @PreAuthorize(hasPermi = "wms:stock:list")
    @GetMapping("/list")
    public TableDataInfo list(Stock stock)
    {
        startPage();
        List<Stock> list = stockService.selectStockList(stock);
        return getDataTable(list);
    }

    /**
     * 导出库存列表
     */
    @PreAuthorize(hasPermi = "wms:stock:export")
    @Log(title = "库存", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Stock stock) throws IOException
    {
        List<Stock> list = stockService.selectStockList(stock);
        ExcelUtil<Stock> util = new ExcelUtil<Stock>(Stock.class);
        util.exportExcel(response, list, "库存数据");
    }

    /**
     * 获取库存详细信息
     */
    @PreAuthorize(hasPermi = "wms:stock:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(stockService.selectStockById(id));
    }

    /**
     * 新增库存
     */
    @PreAuthorize(hasPermi = "wms:stock:add")
    @Log(title = "库存", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Stock stock)
    {
        return toAjax(stockService.insertStock(stock));
    }

    /**
     * 修改库存
     */
    @PreAuthorize(hasPermi = "wms:stock:edit")
    @Log(title = "库存", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Stock stock)
    {
        return toAjax(stockService.updateStock(stock));
    }

    /**
     * 删除库存
     */
    @PreAuthorize(hasPermi = "wms:stock:remove")
    @Log(title = "库存", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(stockService.deleteStockByIds(ids));
    }
}
