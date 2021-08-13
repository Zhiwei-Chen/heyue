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
import com.heyue.wms.domain.WaitOutstore;
import com.heyue.wms.service.IWaitOutstoreService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 待出库区Controller
 * 
 * @author heyue
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/waitOutstore")
public class WaitOutstoreController extends BaseController
{
    @Autowired
    private IWaitOutstoreService waitOutstoreService;

    /**
     * 查询待出库区列表
     */
    @PreAuthorize(hasPermi = "wms:waitOutstore:list")
    @GetMapping("/list")
    public TableDataInfo list(WaitOutstore waitOutstore)
    {
        startPage();
        List<WaitOutstore> list = waitOutstoreService.selectWaitOutstoreList(waitOutstore);
        return getDataTable(list);
    }

    /**
     * 导出待出库区列表
     */
    @PreAuthorize(hasPermi = "wms:waitOutstore:export")
    @Log(title = "待出库区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WaitOutstore waitOutstore) throws IOException
    {
        List<WaitOutstore> list = waitOutstoreService.selectWaitOutstoreList(waitOutstore);
        ExcelUtil<WaitOutstore> util = new ExcelUtil<WaitOutstore>(WaitOutstore.class);
        util.exportExcel(response, list, "待出库区数据");
    }

    /**
     * 获取待出库区详细信息
     */
    @PreAuthorize(hasPermi = "wms:waitOutstore:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(waitOutstoreService.selectWaitOutstoreById(id));
    }

    /**
     * 新增待出库区
     */
    @PreAuthorize(hasPermi = "wms:waitOutstore:add")
    @Log(title = "待出库区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WaitOutstore waitOutstore)
    {
        return toAjax(waitOutstoreService.insertWaitOutstore(waitOutstore));
    }

    /**
     * 修改待出库区
     */
    @PreAuthorize(hasPermi = "wms:waitOutstore:edit")
    @Log(title = "待出库区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WaitOutstore waitOutstore)
    {
        return toAjax(waitOutstoreService.updateWaitOutstore(waitOutstore));
    }

    /**
     * 删除待出库区
     */
    @PreAuthorize(hasPermi = "wms:waitOutstore:remove")
    @Log(title = "待出库区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(waitOutstoreService.deleteWaitOutstoreByIds(ids));
    }
}
