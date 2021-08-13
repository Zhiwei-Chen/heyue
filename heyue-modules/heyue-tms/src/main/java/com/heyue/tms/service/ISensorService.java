package com.heyue.tms.service;

import java.util.List;
import com.heyue.tms.domain.Sensor;

/**
 * 传感器管理Service接口
 * 
 * @author heyue
 * @date 2021-07-30
 */
public interface ISensorService 
{
    /**
     * 查询传感器管理
     * 
     * @param id 传感器管理ID
     * @return 传感器管理
     */
    public Sensor selectSensorById(Long id);

    /**
     * 查询传感器管理列表
     * 
     * @param sensor 传感器管理
     * @return 传感器管理集合
     */
    public List<Sensor> selectSensorList(Sensor sensor);

    /**
     * 新增传感器管理
     * 
     * @param sensor 传感器管理
     * @return 结果
     */
    public int insertSensor(Sensor sensor);

    /**
     * 修改传感器管理
     * 
     * @param sensor 传感器管理
     * @return 结果
     */
    public int updateSensor(Sensor sensor);

    /**
     * 批量删除传感器管理
     * 
     * @param ids 需要删除的传感器管理ID
     * @return 结果
     */
    public int deleteSensorByIds(Long[] ids);

    /**
     * 删除传感器管理信息
     * 
     * @param id 传感器管理ID
     * @return 结果
     */
    public int deleteSensorById(Long id);
}
