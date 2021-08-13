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
import com.heyue.wms.domain.WmsOutstoreHistory;
import com.heyue.wms.service.IWmsOutstoreHistoryService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 出库单快照Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/outstoreHistory")
public class WmsOutstoreHistoryController extends BaseController
{
    @Autowired
    private IWmsOutstoreHistoryService wmsOutstoreHistoryService;

    /**
     * 查询出库单快照列表
     */
    @PreAuthorize(hasPermi = "wms:outstoreHistory:list")
    @GetMapping("/list")
    public TableDataInfo list(WmsOutstoreHistory wmsOutstoreHistory)
    {
        startPage();
        List<WmsOutstoreHistory> list = wmsOutstoreHistoryService.selectWmsOutstoreHistoryList(wmsOutstoreHistory);
        return getDataTable(list);
    }

    /**
     * 导出出库单快照列表
     */
    @PreAuthorize(hasPermi = "wms:outstoreHistory:export")
    @Log(title = "出库单快照", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WmsOutstoreHistory wmsOutstoreHistory) throws IOException
    {
        List<WmsOutstoreHistory> list = wmsOutstoreHistoryService.selectWmsOutstoreHistoryList(wmsOutstoreHistory);
        ExcelUtil<WmsOutstoreHistory> util = new ExcelUtil<WmsOutstoreHistory>(WmsOutstoreHistory.class);
        util.exportExcel(response, list, "出库单快照数据");
    }

    /**
     * 获取出库单快照详细信息
     */
    @PreAuthorize(hasPermi = "wms:outstoreHistory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(wmsOutstoreHistoryService.selectWmsOutstoreHistoryById(id));
    }

    /**
     * 新增出库单快照
     */
    @PreAuthorize(hasPermi = "wms:outstoreHistory:add")
    @Log(title = "出库单快照", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WmsOutstoreHistory wmsOutstoreHistory)
    {
        return toAjax(wmsOutstoreHistoryService.insertWmsOutstoreHistory(wmsOutstoreHistory));
    }

    /**
     * 修改出库单快照
     */
    @PreAuthorize(hasPermi = "wms:outstoreHistory:edit")
    @Log(title = "出库单快照", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WmsOutstoreHistory wmsOutstoreHistory)
    {
        return toAjax(wmsOutstoreHistoryService.updateWmsOutstoreHistory(wmsOutstoreHistory));
    }

    /**
     * 删除出库单快照
     */
    @PreAuthorize(hasPermi = "wms:outstoreHistory:remove")
    @Log(title = "出库单快照", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(wmsOutstoreHistoryService.deleteWmsOutstoreHistoryByIds(ids));
    }
}
