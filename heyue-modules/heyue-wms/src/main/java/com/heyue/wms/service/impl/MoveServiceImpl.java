package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.MoveMapper;
import com.heyue.wms.domain.Move;
import com.heyue.wms.service.IMoveService;

/**
 * 调拨单Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class MoveServiceImpl implements IMoveService 
{
    @Autowired
    private MoveMapper moveMapper;

    /**
     * 查询调拨单
     * 
     * @param id 调拨单ID
     * @return 调拨单
     */
    @Override
    public Move selectMoveById(Long id)
    {
        return moveMapper.selectMoveById(id);
    }

    /**
     * 查询调拨单列表
     * 
     * @param move 调拨单
     * @return 调拨单
     */
    @Override
    public List<Move> selectMoveList(Move move)
    {
        return moveMapper.selectMoveList(move);
    }

    /**
     * 新增调拨单
     * 
     * @param move 调拨单
     * @return 结果
     */
    @Override
    public int insertMove(Move move)
    {
        return moveMapper.insertMove(move);
    }

    /**
     * 修改调拨单
     * 
     * @param move 调拨单
     * @return 结果
     */
    @Override
    public int updateMove(Move move)
    {
        move.setUpdateTime(DateUtils.getNowDate());
        return moveMapper.updateMove(move);
    }

    /**
     * 批量删除调拨单
     * 
     * @param ids 需要删除的调拨单ID
     * @return 结果
     */
    @Override
    public int deleteMoveByIds(Long[] ids)
    {
        return moveMapper.deleteMoveByIds(ids);
    }

    /**
     * 删除调拨单信息
     * 
     * @param id 调拨单ID
     * @return 结果
     */
    @Override
    public int deleteMoveById(Long id)
    {
        return moveMapper.deleteMoveById(id);
    }
}
