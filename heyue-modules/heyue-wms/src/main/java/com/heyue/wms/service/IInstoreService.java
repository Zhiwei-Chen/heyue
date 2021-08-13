package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.Instore;

/**
 * 入库单Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IInstoreService 
{
    /**
     * 查询入库单
     * 
     * @param id 入库单ID
     * @return 入库单
     */
    public Instore selectInstoreById(Long id);

    /**
     * 查询入库单列表
     * 
     * @param instore 入库单
     * @return 入库单集合
     */
    public List<Instore> selectInstoreList(Instore instore);

    /**
     * 新增入库单
     * 
     * @param instore 入库单
     * @return 结果
     */
    public int insertInstore(Instore instore);

    /**
     * 修改入库单
     * 
     * @param instore 入库单
     * @return 结果
     */
    public int updateInstore(Instore instore);

    /**
     * 批量删除入库单
     * 
     * @param ids 需要删除的入库单ID
     * @return 结果
     */
    public int deleteInstoreByIds(Long[] ids);

    /**
     * 删除入库单信息
     * 
     * @param id 入库单ID
     * @return 结果
     */
    public int deleteInstoreById(Long id);
}
