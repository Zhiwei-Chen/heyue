package com.heyue.tms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.tms.mapper.SensorMapper;
import com.heyue.tms.domain.Sensor;
import com.heyue.tms.service.ISensorService;

/**
 * 传感器管理Service业务层处理
 * 
 * @author heyue
 * @date 2021-07-30
 */
@Service
public class SensorServiceImpl implements ISensorService 
{
    @Autowired
    private SensorMapper sensorMapper;

    /**
     * 查询传感器管理
     * 
     * @param id 传感器管理ID
     * @return 传感器管理
     */
    @Override
    public Sensor selectSensorById(Long id)
    {
        return sensorMapper.selectSensorById(id);
    }

    /**
     * 查询传感器管理列表
     * 
     * @param sensor 传感器管理
     * @return 传感器管理
     */
    @Override
    public List<Sensor> selectSensorList(Sensor sensor)
    {
        return sensorMapper.selectSensorList(sensor);
    }

    /**
     * 新增传感器管理
     * 
     * @param sensor 传感器管理
     * @return 结果
     */
    @Override
    public int insertSensor(Sensor sensor)
    {
        sensor.setCreateTime(DateUtils.getNowDate());
        return sensorMapper.insertSensor(sensor);
    }

    /**
     * 修改传感器管理
     * 
     * @param sensor 传感器管理
     * @return 结果
     */
    @Override
    public int updateSensor(Sensor sensor)
    {
        return sensorMapper.updateSensor(sensor);
    }

    /**
     * 批量删除传感器管理
     * 
     * @param ids 需要删除的传感器管理ID
     * @return 结果
     */
    @Override
    public int deleteSensorByIds(Long[] ids)
    {
        return sensorMapper.deleteSensorByIds(ids);
    }

    /**
     * 删除传感器管理信息
     * 
     * @param id 传感器管理ID
     * @return 结果
     */
    @Override
    public int deleteSensorById(Long id)
    {
        return sensorMapper.deleteSensorById(id);
    }
}
