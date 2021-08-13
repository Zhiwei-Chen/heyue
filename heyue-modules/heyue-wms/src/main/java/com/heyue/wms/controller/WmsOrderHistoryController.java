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
import com.heyue.wms.domain.WmsOrderHistory;
import com.heyue.wms.service.IWmsOrderHistoryService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 仓储信息快照Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/wmsorderHistory")
public class WmsOrderHistoryController extends BaseController
{
    @Autowired
    private IWmsOrderHistoryService wmsOrderHistoryService;

    /**
     * 查询仓储信息快照列表
     */
    @PreAuthorize(hasPermi = "wms:wmsorderHistory:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsOrderHistory wmsOrderHistory)
    {
        startPage();
        List<WmsOrderHistory> list = wmsOrderHistoryService.selectWmsOrderHistoryList(wmsOrderHistory);
        return getDataTable(list);
    }

    /**
     * 导出仓储信息快照列表
     */
    @PreAuthorize(hasPermi = "wms:wmsorderHistory:export")
    @Log(title = "仓储信息快照", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsOrderHistory wmsOrderHistory) throws IOException
    {
        List<WmsOrderHistory> list = wmsOrderHistoryService.selectWmsOrderHistoryList(wmsOrderHistory);
        ExcelUtil<WmsOrderHistory> util = new ExcelUtil<WmsOrderHistory>(WmsOrderHistory.class);
        util.exportExcel(response, list, "仓储信息快照数据");
    }

    /**
     * 获取仓储信息快照详细信息
     */
    @PreAuthorize(hasPermi = "wms:wmsorderHistory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wmsOrderHistoryService.selectWmsOrderHistoryById(id));
    }

    /**
     * 新增仓储信息快照
     */
    @PreAuthorize(hasPermi = "wms:wmsorderHistory:add")
    @Log(title = "仓储信息快照", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsOrderHistory wmsOrderHistory)
    {
        return toAjax(wmsOrderHistoryService.insertWmsOrderHistory(wmsOrderHistory));
    }

    /**
     * 修改仓储信息快照
     */
    @PreAuthorize(hasPermi = "wms:wmsorderHistory:edit")
    @Log(title = "仓储信息快照", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsOrderHistory wmsOrderHistory)
    {
        return toAjax(wmsOrderHistoryService.updateWmsOrderHistory(wmsOrderHistory));
    }

    /**
     * 删除仓储信息快照
     */
    @PreAuthorize(hasPermi = "wms:wmsorderHistory:remove")
    @Log(title = "仓储信息快照", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsOrderHistoryService.deleteWmsOrderHistoryByIds(ids));
    }
}
