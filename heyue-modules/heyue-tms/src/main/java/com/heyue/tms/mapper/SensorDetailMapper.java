package com.heyue.tms.mapper;

import java.util.List;
import com.heyue.tms.domain.SensorDetail;

/**
 * 传感器明细Mapper接口
 * 
 * @author heyue
 * @date 2021-08-01
 */
public interface SensorDetailMapper 
{
    /**
     * 查询传感器明细
     * 
     * @param id 传感器明细ID
     * @return 传感器明细
     */
    public SensorDetail selectSensorDetailById(Long id);

    /**
     * 查询传感器明细列表
     * 
     * @param sensorDetail 传感器明细
     * @return 传感器明细集合
     */
    public List<SensorDetail> selectSensorDetailList(SensorDetail sensorDetail);

    /**
     * 新增传感器明细
     * 
     * @param sensorDetail 传感器明细
     * @return 结果
     */
    public int insertSensorDetail(SensorDetail sensorDetail);

    /**
     * 修改传感器明细
     * 
     * @param sensorDetail 传感器明细
     * @return 结果
     */
    public int updateSensorDetail(SensorDetail sensorDetail);

    /**
     * 删除传感器明细
     * 
     * @param id 传感器明细ID
     * @return 结果
     */
    public int deleteSensorDetailById(Long id);

    /**
     * 批量删除传感器明细
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSensorDetailByIds(Long[] ids);
}
