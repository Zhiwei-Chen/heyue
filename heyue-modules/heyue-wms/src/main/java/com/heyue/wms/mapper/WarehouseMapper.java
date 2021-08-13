package com.heyue.wms.mapper;

import java.util.List;
import com.heyue.wms.domain.Warehouse;

/**
 * 仓库信息Mapper接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface WarehouseMapper 
{
    /**
     * 查询仓库信息
     * 
     * @param id 仓库信息ID
     * @return 仓库信息
     */
    public Warehouse selectWarehouseById(Long id);

    /**
     * 查询仓库信息列表
     * 
     * @param warehouse 仓库信息
     * @return 仓库信息集合
     */
    public List<Warehouse> selectWarehouseList(Warehouse warehouse);

    /**
     * 新增仓库信息
     * 
     * @param warehouse 仓库信息
     * @return 结果
     */
    public int insertWarehouse(Warehouse warehouse);

    /**
     * 修改仓库信息
     * 
     * @param warehouse 仓库信息
     * @return 结果
     */
    public int updateWarehouse(Warehouse warehouse);

    /**
     * 删除仓库信息
     * 
     * @param id 仓库信息ID
     * @return 结果
     */
    public int deleteWarehouseById(Long id);

    /**
     * 批量删除仓库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWarehouseByIds(Long[] ids);
}
