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
import com.heyue.wms.domain.InstoreHistory;
import com.heyue.wms.service.IInstoreHistoryService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 入库单快照Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/instorehistory")
public class InstoreHistoryController extends BaseController
{
    @Autowired
    private IInstoreHistoryService instoreHistoryService;

    /**
     * 查询入库单快照列表
     */
    @PreAuthorize(hasPermi = "wms:instorehistory:list")
    @GetMapping("/list")
    public TableDataInfo list(InstoreHistory instoreHistory)
    {
        startPage();
        List<InstoreHistory> list = instoreHistoryService.selectInstoreHistoryList(instoreHistory);
        return getDataTable(list);
    }

    /**
     * 导出入库单快照列表
     */
    @PreAuthorize(hasPermi = "wms:instorehistory:export")
    @Log(title = "入库单快照", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, InstoreHistory instoreHistory) throws IOException
    {
        List<InstoreHistory> list = instoreHistoryService.selectInstoreHistoryList(instoreHistory);
        ExcelUtil<InstoreHistory> util = new ExcelUtil<InstoreHistory>(InstoreHistory.class);
        util.exportExcel(response, list, "入库单快照数据");
    }

    /**
     * 获取入库单快照详细信息
     */
    @PreAuthorize(hasPermi = "wms:instorehistory:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(instoreHistoryService.selectInstoreHistoryById(id));
    }

    /**
     * 新增入库单快照
     */
    @PreAuthorize(hasPermi = "wms:instorehistory:add")
    @Log(title = "入库单快照", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody InstoreHistory instoreHistory)
    {
        return toAjax(instoreHistoryService.insertInstoreHistory(instoreHistory));
    }

    /**
     * 修改入库单快照
     */
    @PreAuthorize(hasPermi = "wms:instorehistory:edit")
    @Log(title = "入库单快照", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody InstoreHistory instoreHistory)
    {
        return toAjax(instoreHistoryService.updateInstoreHistory(instoreHistory));
    }

    /**
     * 删除入库单快照
     */
    @PreAuthorize(hasPermi = "wms:instorehistory:remove")
    @Log(title = "入库单快照", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(instoreHistoryService.deleteInstoreHistoryByIds(ids));
    }
}
