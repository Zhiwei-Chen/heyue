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
import com.heyue.tms.domain.SensorDetail;
import com.heyue.tms.service.ISensorDetailService;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.page.TableDataInfo;

/**
 * 传感器明细Controller
 * 
 * @author heyue
 * @date 2021-08-01
 */
@RestController
@RequestMapping("/sensordetail")
public class SensorDetailController extends BaseController
{
    @Autowired
    private ISensorDetailService sensorDetailService;

    /**
     * 查询传感器明细列表
     */
    @PreAuthorize(hasPermi = "tms:sensordetail:list")
    @GetMapping("/list")
    public TableDataInfo list(SensorDetail sensorDetail)
    {
        startPage();
        List<SensorDetail> list = sensorDetailService.selectSensorDetailList(sensorDetail);
        return getDataTable(list);
    }

    /**
     * 导出传感器明细列表
     */
    @PreAuthorize(hasPermi = "tms:sensordetail:export")
    @Log(title = "传感器明细", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SensorDetail sensorDetail) throws IOException
    {
        List<SensorDetail> list = sensorDetailService.selectSensorDetailList(sensorDetail);
        ExcelUtil<SensorDetail> util = new ExcelUtil<SensorDetail>(SensorDetail.class);
        util.exportExcel(response, list, "传感器明细数据");
    }

    /**
     * 获取传感器明细详细信息
     */
    @PreAuthorize(hasPermi = "tms:sensordetail:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sensorDetailService.selectSensorDetailById(id));
    }

    /**
     * 新增传感器明细
     */
    @PreAuthorize(hasPermi = "tms:sensordetail:add")
    @Log(title = "传感器明细", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SensorDetail sensorDetail)
    {
        return toAjax(sensorDetailService.insertSensorDetail(sensorDetail));
    }

    /**
     * 修改传感器明细
     */
    @PreAuthorize(hasPermi = "tms:sensordetail:edit")
    @Log(title = "传感器明细", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SensorDetail sensorDetail)
    {
        return toAjax(sensorDetailService.updateSensorDetail(sensorDetail));
    }

    /**
     * 删除传感器明细
     */
    @PreAuthorize(hasPermi = "tms:sensordetail:remove")
    @Log(title = "传感器明细", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sensorDetailService.deleteSensorDetailByIds(ids));
    }
}
