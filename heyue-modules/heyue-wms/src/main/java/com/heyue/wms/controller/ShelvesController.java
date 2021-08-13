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
import com.heyue.wms.domain.Shelves;
import com.heyue.wms.service.IShelvesService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 货架信息Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/shelves")
public class ShelvesController extends BaseController
{
    @Autowired
    private IShelvesService shelvesService;

    /**
     * 查询货架信息列表
     */
    @PreAuthorize(hasPermi = "wms:shelves:list")
    @GetMapping("/list")
    public TableDataInfo list(Shelves shelves)
    {
        startPage();
        List<Shelves> list = shelvesService.selectShelvesList(shelves);
        return getDataTable(list);
    }

    /**
     * 导出货架信息列表
     */
    @PreAuthorize(hasPermi = "wms:shelves:export")
    @Log(title = "货架信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Shelves shelves) throws IOException
    {
        List<Shelves> list = shelvesService.selectShelvesList(shelves);
        ExcelUtil<Shelves> util = new ExcelUtil<Shelves>(Shelves.class);
        util.exportExcel(response, list, "货架信息数据");
    }

    /**
     * 获取货架信息详细信息
     */
    @PreAuthorize(hasPermi = "wms:shelves:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(shelvesService.selectShelvesById(id));
    }

    /**
     * 新增货架信息
     */
    @PreAuthorize(hasPermi = "wms:shelves:add")
    @Log(title = "货架信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Shelves shelves)
    {
        return toAjax(shelvesService.insertShelves(shelves));
    }

    /**
     * 修改货架信息
     */
    @PreAuthorize(hasPermi = "wms:shelves:edit")
    @Log(title = "货架信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Shelves shelves)
    {
        return toAjax(shelvesService.updateShelves(shelves));
    }

    /**
     * 删除货架信息
     */
    @PreAuthorize(hasPermi = "wms:shelves:remove")
    @Log(title = "货架信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(shelvesService.deleteShelvesByIds(ids));
    }
}
