package com.heyue.wms.mapper;

import java.util.List;
import com.heyue.wms.domain.Location;

/**
 * 货位信息Mapper接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface LocationMapper 
{
    /**
     * 查询货位信息
     * 
     * @param id 货位信息ID
     * @return 货位信息
     */
    public Location selectLocationById(Long id);

    /**
     * 查询货位信息列表
     * 
     * @param location 货位信息
     * @return 货位信息集合
     */
    public List<Location> selectLocationList(Location location);

    /**
     * 新增货位信息
     * 
     * @param location 货位信息
     * @return 结果
     */
    public int insertLocation(Location location);

    /**
     * 修改货位信息
     * 
     * @param location 货位信息
     * @return 结果
     */
    public int updateLocation(Location location);

    /**
     * 删除货位信息
     * 
     * @param id 货位信息ID
     * @return 结果
     */
    public int deleteLocationById(Long id);

    /**
     * 批量删除货位信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteLocationByIds(Long[] ids);
}
