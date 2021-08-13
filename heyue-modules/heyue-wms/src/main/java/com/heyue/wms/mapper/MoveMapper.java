package com.heyue.wms.mapper;

import java.util.List;
import com.heyue.wms.domain.Move;

/**
 * 调拨单Mapper接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface MoveMapper 
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
     * 删除调拨单
     * 
     * @param id 调拨单ID
     * @return 结果
     */
    public int deleteMoveById(Long id);

    /**
     * 批量删除调拨单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMoveByIds(Long[] ids);
}
