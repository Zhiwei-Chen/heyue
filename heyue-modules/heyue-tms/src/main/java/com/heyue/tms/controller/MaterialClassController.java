package com.heyue.tms.controller;

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
import com.heyue.tms.domain.MaterialClass;
import com.heyue.tms.service.IMaterialClassService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;

/**
 * 物料分类Controller
 * 
 * @author heyue
 * @date 2021-08-04
 */
@RestController
@RequestMapping("/materialClass")
public class MaterialClassController extends BaseController
{
    @Autowired
    private IMaterialClassService materialClassService;

    /**
     * 查询物料分类列表
     */
    @PreAuthorize(hasPermi = "tms:materialClass:list")
    @GetMapping("/list")
    public AjaxResult list(MaterialClass materialClass)
    {
        System.out.print(materialClass);
        List<MaterialClass> list = materialClassService.selectMaterialClassList(materialClass);
        return AjaxResult.success(list);
    }

    /**
     * 获取物料分类下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(MaterialClass materialClass)
    {
        List<MaterialClass> materialClasses = materialClassService.selectMaterialClassList(materialClass);
        return AjaxResult.success(materialClassService.buildDeptTreeSelect(materialClasses));
    }


    /**
     * 导出物料分类列表
     */
    @PreAuthorize(hasPermi = "tms:materialClass:export")
    @Log(title = "物料分类", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MaterialClass materialClass) throws IOException
    {
        List<MaterialClass> list = materialClassService.selectMaterialClassList(materialClass);
        ExcelUtil<MaterialClass> util = new ExcelUtil<MaterialClass>(MaterialClass.class);
        util.exportExcel(response, list, "物料分类数据");
    }

    /**
     * 获取物料分类详细信息
     */
    @PreAuthorize(hasPermi = "tms:materialClass:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(materialClassService.selectMaterialClassById(id));
    }

    /**
     * 新增物料分类
     */
    @PreAuthorize(hasPermi = "tms:materialClass:add")
    @Log(title = "物料分类", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MaterialClass materialClass)
    {
        return toAjax(materialClassService.insertMaterialClass(materialClass));
    }

    /**
     * 修改物料分类
     */
    @PreAuthorize(hasPermi = "tms:materialClass:edit")
    @Log(title = "物料分类", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MaterialClass materialClass)
    {
        return toAjax(materialClassService.updateMaterialClass(materialClass));
    }

    /**
     * 删除物料分类
     */
    @PreAuthorize(hasPermi = "tms:materialClass:remove")
    @Log(title = "物料分类", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(materialClassService.deleteMaterialClassByIds(ids));
    }
}
