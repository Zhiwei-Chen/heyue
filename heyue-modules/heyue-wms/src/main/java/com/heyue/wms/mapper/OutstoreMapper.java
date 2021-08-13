package com.heyue.wms.mapper;

import java.util.List;
import com.heyue.wms.domain.Outstore;

/**
 * 出库单管理Mapper接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface OutstoreMapper 
{
    /**
     * 查询出库单管理
     * 
     * @param id 出库单管理ID
     * @return 出库单管理
     */
    public Outstore selectOutstoreById(Long id);

    /**
     * 查询出库单管理列表
     * 
     * @param outstore 出库单管理
     * @return 出库单管理集合
     */
    public List<Outstore> selectOutstoreList(Outstore outstore);

    /**
     * 新增出库单管理
     * 
     * @param outstore 出库单管理
     * @return 结果
     */
    public int insertOutstore(Outstore outstore);

    /**
     * 修改出库单管理
     * 
     * @param outstore 出库单管理
     * @return 结果
     */
    public int updateOutstore(Outstore outstore);

    /**
     * 删除出库单管理
     * 
     * @param id 出库单管理ID
     * @return 结果
     */
    public int deleteOutstoreById(Long id);

    /**
     * 批量删除出库单管理
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOutstoreByIds(Long[] ids);
}
