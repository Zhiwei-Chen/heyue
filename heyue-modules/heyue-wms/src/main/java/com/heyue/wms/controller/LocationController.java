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
import com.heyue.wms.domain.Location;
import com.heyue.wms.service.ILocationService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 货位信息Controller
 * 
 * @author wchu
 * @date 2021-08-09
 */
@RestController
@RequestMapping("/location")
public class LocationController extends BaseController
{
    @Autowired
    private ILocationService locationService;

    /**
     * 查询货位信息列表
     */
    @PreAuthorize(hasPermi = "wms:location:list")
    @GetMapping("/list")
    public TableDataInfo list(Location location)
    {
        startPage();
        List<Location> list = locationService.selectLocationList(location);
        return getDataTable(list);
    }

    /**
     * 导出货位信息列表
     */
    @PreAuthorize(hasPermi = "wms:location:export")
    @Log(title = "货位信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Location location) throws IOException
    {
        List<Location> list = locationService.selectLocationList(location);
        ExcelUtil<Location> util = new ExcelUtil<Location>(Location.class);
        util.exportExcel(response, list, "货位信息数据");
    }

    /**
     * 获取货位信息详细信息
     */
    @PreAuthorize(hasPermi = "wms:location:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(locationService.selectLocationById(id));
    }

    /**
     * 新增货位信息
     */
    @PreAuthorize(hasPermi = "wms:location:add")
    @Log(title = "货位信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Location location)
    {
        return toAjax(locationService.insertLocation(location));
    }

    /**
     * 修改货位信息
     */
    @PreAuthorize(hasPermi = "wms:location:edit")
    @Log(title = "货位信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Location location)
    {
        return toAjax(locationService.updateLocation(location));
    }

    /**
     * 删除货位信息
     */
    @PreAuthorize(hasPermi = "wms:location:remove")
    @Log(title = "货位信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(locationService.deleteLocationByIds(ids));
    }
}
