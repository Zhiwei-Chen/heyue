package com.heyue.tms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.tms.mapper.SensorDetailMapper;
import com.heyue.tms.domain.SensorDetail;
import com.heyue.tms.service.ISensorDetailService;

/**
 * 传感器明细Service业务层处理
 * 
 * @author heyue
 * @date 2021-08-01
 */
@Service
public class SensorDetailServiceImpl implements ISensorDetailService 
{
    @Autowired
    private SensorDetailMapper sensorDetailMapper;

    /**
     * 查询传感器明细
     * 
     * @param id 传感器明细ID
     * @return 传感器明细
     */
    @Override
    public SensorDetail selectSensorDetailById(Long id)
    {
        return sensorDetailMapper.selectSensorDetailById(id);
    }

    /**
     * 查询传感器明细列表
     * 
     * @param sensorDetail 传感器明细
     * @return 传感器明细
     */
    @Override
    public List<SensorDetail> selectSensorDetailList(SensorDetail sensorDetail)
    {
        return sensorDetailMapper.selectSensorDetailList(sensorDetail);
    }

    /**
     * 新增传感器明细
     * 
     * @param sensorDetail 传感器明细
     * @return 结果
     */
    @Override
    public int insertSensorDetail(SensorDetail sensorDetail)
    {
        return sensorDetailMapper.insertSensorDetail(sensorDetail);
    }

    /**
     * 修改传感器明细
     * 
     * @param sensorDetail 传感器明细
     * @return 结果
     */
    @Override
    public int updateSensorDetail(SensorDetail sensorDetail)
    {
        return sensorDetailMapper.updateSensorDetail(sensorDetail);
    }

    /**
     * 批量删除传感器明细
     * 
     * @param ids 需要删除的传感器明细ID
     * @return 结果
     */
    @Override
    public int deleteSensorDetailByIds(Long[] ids)
    {
        return sensorDetailMapper.deleteSensorDetailByIds(ids);
    }

    /**
     * 删除传感器明细信息
     * 
     * @param id 传感器明细ID
     * @return 结果
     */
    @Override
    public int deleteSensorDetailById(Long id)
    {
        return sensorDetailMapper.deleteSensorDetailById(id);
    }
}
