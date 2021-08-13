package com.heyue.system.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.heyue.system.utils.SnowFlake;
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
import com.heyue.system.domain.SysCompany;
import com.heyue.system.service.ISysCompanyService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 注册验证Controller
 * 
 * @author heyue
 * @date 2021-08-06
 */
@RestController
@RequestMapping("/company")
public class SysCompanyController extends BaseController
{
    @Autowired
    private ISysCompanyService sysCompanyService;

    /**
     * 查询注册验证列表
     */
    @PreAuthorize(hasPermi = "system:company:list")
    @GetMapping("/list")
    public TableDataInfo list(SysCompany sysCompany)
    {
        startPage();
        List<SysCompany> list = sysCompanyService.selectSysCompanyList(sysCompany);
        System.out.print(list);
        return getDataTable(list);
    }

    /**
     * 导出注册验证列表
     */
    @PreAuthorize(hasPermi = "system:company:export")
    @Log(title = "注册验证", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysCompany sysCompany) throws IOException
    {
        List<SysCompany> list = sysCompanyService.selectSysCompanyList(sysCompany);
        ExcelUtil<SysCompany> util = new ExcelUtil<SysCompany>(SysCompany.class);
        util.exportExcel(response, list, "注册验证数据");
    }

    /**
     * 获取注册验证详细信息
     */
    @PreAuthorize(hasPermi = "system:company:query")
    @GetMapping(value = "/{qmsId}")
    public AjaxResult getInfo(@PathVariable("qmsId") Long qmsId)
    {
        System.out.print(qmsId);
        return AjaxResult.success(sysCompanyService.selectSysCompanyById(qmsId));
    }

    /**
     * 新增注册验证
     */
    @PreAuthorize(hasPermi = "system:company:add")
    @Log(title = "注册验证", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysCompany sysCompany)
    {
        sysCompany.setQmsId(SnowFlake.generateId());
        return toAjax(sysCompanyService.insertSysCompany(sysCompany));
    }

    /**
     * 修改注册验证
     */
    @PreAuthorize(hasPermi = "system:company:edit")
    @Log(title = "注册验证", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysCompany sysCompany)
    {

        return toAjax(sysCompanyService.updateSysCompany(sysCompany));
    }

    /**
     * 删除注册验证
     */
    @PreAuthorize(hasPermi = "system:company:remove")
    @Log(title = "注册验证", businessType = BusinessType.DELETE)
	@DeleteMapping("/{qmsIds}")
    public AjaxResult remove(@PathVariable Long[] qmsIds)
    {
        return toAjax(sysCompanyService.deleteSysCompanyByIds(qmsIds));
    }
}
