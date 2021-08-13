package com.heyue.tms.controller;

import com.heyue.common.core.utils.poi.ExcelUtil;
import com.heyue.common.core.web.controller.BaseController;
import com.heyue.common.core.web.domain.AjaxResult;
import com.heyue.common.core.web.page.TableDataInfo;
import com.heyue.common.log.annotation.Log;
import com.heyue.common.log.enums.BusinessType;
import com.heyue.common.security.annotation.PreAuthorize;
import com.heyue.tms.domain.Sensor;
import com.heyue.tms.domain.SensorDetail;
import com.heyue.tms.service.ISensorDetailService;
import com.heyue.tms.service.ISensorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * 提供传感器温度远程调用
 * 
 * @author heyue
 * @date 2021-07-30
 */
@RestController
@RequestMapping("/device/api")
public class SensorApiController extends BaseController
{
    @Autowired
    private ISensorDetailService sensorDetailService;

    @PostMapping("/ins")
    public AjaxResult insert(@RequestBody List<SensorDetail> sensorDetailList)
    {
        try {
            for (SensorDetail item:sensorDetailList) {
                sensorDetailService.insertSensorDetail(item);
            }
        }catch (Exception e){
            return AjaxResult.error(e.getMessage());
        }
        return AjaxResult.success();
    }

    @GetMapping("/test")
    public AjaxResult test(@RequestParam(value = "name") String name)
    {
        return AjaxResult.success(name);
    }
}
