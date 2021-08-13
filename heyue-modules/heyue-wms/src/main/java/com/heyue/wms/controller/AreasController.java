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
import com.heyue.wms.domain.Areas;
import com.heyue.wms.service.IAreasService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 仓库区域Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/areas")
public class AreasController extends BaseController
{
    @Autowired
    private IAreasService areasService;

    /**
     * 查询仓库区域列表
     */
    @PreAuthorize(hasPermi = "wms:areas:list")
    @GetMapping("/list")
    public TableDataInfo list(Areas areas)
    {
        startPage();
        List<Areas> list = areasService.selectAreasList(areas);
        return getDataTable(list);
    }

    /**
     * 导出仓库区域列表
     */
    @PreAuthorize(hasPermi = "wms:areas:export")
    @Log(title = "仓库区域", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Areas areas) throws IOException
    {
        List<Areas> list = areasService.selectAreasList(areas);
        ExcelUtil<Areas> util = new ExcelUtil<Areas>(Areas.class);
        util.exportExcel(response, list, "仓库区域数据");
    }

    /**
     * 获取仓库区域详细信息
     */
    @PreAuthorize(hasPermi = "wms:areas:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(areasService.selectAreasById(id));
    }

    /**
     * 新增仓库区域
     */
    @PreAuthorize(hasPermi = "wms:areas:add")
    @Log(title = "仓库区域", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Areas areas)
    {
        return toAjax(areasService.insertAreas(areas));
    }

    /**
     * 修改仓库区域
     */
    @PreAuthorize(hasPermi = "wms:areas:edit")
    @Log(title = "仓库区域", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Areas areas)
    {
        return toAjax(areasService.updateAreas(areas));
    }

    /**
     * 删除仓库区域
     */
    @PreAuthorize(hasPermi = "wms:areas:remove")
    @Log(title = "仓库区域", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(areasService.deleteAreasByIds(ids));
    }
}
