package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.Check;

/**
 * 库存盘点Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface ICheckService 
{
    /**
     * 查询库存盘点
     * 
     * @param id 库存盘点ID
     * @return 库存盘点
     */
    public Check selectCheckById(Long id);

    /**
     * 查询库存盘点列表
     * 
     * @param check 库存盘点
     * @return 库存盘点集合
     */
    public List<Check> selectCheckList(Check check);

    /**
     * 新增库存盘点
     * 
     * @param check 库存盘点
     * @return 结果
     */
    public int insertCheck(Check check);

    /**
     * 修改库存盘点
     * 
     * @param check 库存盘点
     * @return 结果
     */
    public int updateCheck(Check check);

    /**
     * 批量删除库存盘点
     * 
     * @param ids 需要删除的库存盘点ID
     * @return 结果
     */
    public int deleteCheckByIds(Long[] ids);

    /**
     * 删除库存盘点信息
     * 
     * @param id 库存盘点ID
     * @return 结果
     */
    public int deleteCheckById(Long id);
}
