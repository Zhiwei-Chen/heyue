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
import com.heyue.tms.domain.Sensor;
import com.heyue.tms.service.ISensorService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 传感器管理Controller
 * 
 * @author heyue
 * @date 2021-07-30
 */
@RestController
@RequestMapping("/sensor")
public class SensorController extends BaseController
{
    @Autowired
    private ISensorService sensorService;

    /**
     * 查询传感器管理列表
     */
    @PreAuthorize(hasPermi = "tms:sensor:list")
    @GetMapping("/list")
    public TableDataInfo list(Sensor sensor)
    {
        startPage();
        List<Sensor> list = sensorService.selectSensorList(sensor);
        return getDataTable(list);
    }

    /**
     * 导出传感器管理列表
     */
    @PreAuthorize(hasPermi = "tms:sensor:export")
    @Log(title = "传感器管理", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, Sensor sensor) throws IOException
    {
        List<Sensor> list = sensorService.selectSensorList(sensor);
        ExcelUtil<Sensor> util = new ExcelUtil<Sensor>(Sensor.class);
        util.exportExcel(response, list, "传感器管理数据");
    }

    /**
     * 获取传感器管理详细信息
     */
    @PreAuthorize(hasPermi = "tms:sensor:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sensorService.selectSensorById(id));
    }

    /**
     * 新增传感器管理
     */
    @PreAuthorize(hasPermi = "tms:sensor:add")
    @Log(title = "传感器管理", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody Sensor sensor)
    {
        return toAjax(sensorService.insertSensor(sensor));
    }

    /**
     * 修改传感器管理
     */
    @PreAuthorize(hasPermi = "tms:sensor:edit")
    @Log(title = "传感器管理", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody Sensor sensor)
    {
        return toAjax(sensorService.updateSensor(sensor));
    }

    /**
     * 删除传感器管理
     */
    @PreAuthorize(hasPermi = "tms:sensor:remove")
    @Log(title = "传感器管理", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sensorService.deleteSensorByIds(ids));
    }
}
