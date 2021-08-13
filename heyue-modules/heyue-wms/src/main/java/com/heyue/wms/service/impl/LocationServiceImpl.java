package com.heyue.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.LocationMapper;
import com.heyue.wms.domain.Location;
import com.heyue.wms.service.ILocationService;

/**
 * 货位信息Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class LocationServiceImpl implements ILocationService 
{
    @Autowired
    private LocationMapper locationMapper;

    /**
     * 查询货位信息
     * 
     * @param id 货位信息ID
     * @return 货位信息
     */
    @Override
    public Location selectLocationById(Long id)
    {
        return locationMapper.selectLocationById(id);
    }

    /**
     * 查询货位信息列表
     * 
     * @param location 货位信息
     * @return 货位信息
     */
    @Override
    public List<Location> selectLocationList(Location location)
    {
        return locationMapper.selectLocationList(location);
    }

    /**
     * 新增货位信息
     * 
     * @param location 货位信息
     * @return 结果
     */
    @Override
    public int insertLocation(Location location)
    {
        return locationMapper.insertLocation(location);
    }

    /**
     * 修改货位信息
     * 
     * @param location 货位信息
     * @return 结果
     */
    @Override
    public int updateLocation(Location location)
    {
        return locationMapper.updateLocation(location);
    }

    /**
     * 批量删除货位信息
     * 
     * @param ids 需要删除的货位信息ID
     * @return 结果
     */
    @Override
    public int deleteLocationByIds(Long[] ids)
    {
        return locationMapper.deleteLocationByIds(ids);
    }

    /**
     * 删除货位信息信息
     * 
     * @param id 货位信息ID
     * @return 结果
     */
    @Override
    public int deleteLocationById(Long id)
    {
        return locationMapper.deleteLocationById(id);
    }
}
