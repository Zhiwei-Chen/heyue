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
import com.heyue.wms.domain.WaitInstore;
import com.heyue.wms.service.IWaitInstoreService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 待入库区Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/waitInstore")
public class WaitInstoreController extends BaseController
{
    @Autowired
    private IWaitInstoreService waitInstoreService;

    /**
     * 查询待入库区列表
     */
    @PreAuthorize(hasPermi = "wms:waitInstore:list")
    @GetMapping("/list")
    public TableDataInfo list(WaitInstore waitInstore)
    {
        startPage();
        List<WaitInstore> list = waitInstoreService.selectWaitInstoreList(waitInstore);
        return getDataTable(list);
    }

    /**
     * 导出待入库区列表
     */
    @PreAuthorize(hasPermi = "wms:waitInstore:export")
    @Log(title = "待入库区", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, WaitInstore waitInstore) throws IOException
    {
        List<WaitInstore> list = waitInstoreService.selectWaitInstoreList(waitInstore);
        ExcelUtil<WaitInstore> util = new ExcelUtil<WaitInstore>(WaitInstore.class);
        util.exportExcel(response, list, "待入库区数据");
    }

    /**
     * 获取待入库区详细信息
     */
    @PreAuthorize(hasPermi = "wms:waitInstore:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(waitInstoreService.selectWaitInstoreById(id));
    }

    /**
     * 新增待入库区
     */
    @PreAuthorize(hasPermi = "wms:waitInstore:add")
    @Log(title = "待入库区", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody WaitInstore waitInstore)
    {
        return toAjax(waitInstoreService.insertWaitInstore(waitInstore));
    }

    /**
     * 修改待入库区
     */
    @PreAuthorize(hasPermi = "wms:waitInstore:edit")
    @Log(title = "待入库区", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody WaitInstore waitInstore)
    {
        return toAjax(waitInstoreService.updateWaitInstore(waitInstore));
    }

    /**
     * 删除待入库区
     */
    @PreAuthorize(hasPermi = "wms:waitInstore:remove")
    @Log(title = "待入库区", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(waitInstoreService.deleteWaitInstoreByIds(ids));
    }
}
