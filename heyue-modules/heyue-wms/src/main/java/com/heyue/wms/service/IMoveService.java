package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.Move;

/**
 * 调拨单Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IMoveService 
{
    /**
     * 查询调拨单
     * 
     * @param id 调拨单ID
     * @return 调拨单
     */
    public Move selectMoveById(Long id);

    /**
     * 查询调拨单列表
     * 
     * @param move 调拨单
     * @return 调拨单集合
     */
    public List<Move> selectMoveList(Move move);

    /**
     * 新增调拨单
     * 
     * @param move 调拨单
     * @return 结果
     */
    public int insertMove(Move move);

    /**
     * 修改调拨单
     * 
     * @param move 调拨单
     * @return 结果
     */
    public int updateMove(Move move);

    /**
     * 批量删除调拨单
     * 
     * @param ids 需要删除的调拨单ID
     * @return 结果
     */
    public int deleteMoveByIds(Long[] ids);

    /**
     * 删除调拨单信息
     * 
     * @param id 调拨单ID
     * @return 结果
     */
    public int deleteMoveById(Long id);
}
