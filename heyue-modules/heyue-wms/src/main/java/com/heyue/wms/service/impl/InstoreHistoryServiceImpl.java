package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.InstoreHistoryMapper;
import com.heyue.wms.domain.InstoreHistory;
import com.heyue.wms.service.IInstoreHistoryService;

/**
 * 入库单快照Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class InstoreHistoryServiceImpl implements IInstoreHistoryService 
{
    @Autowired
    private InstoreHistoryMapper instoreHistoryMapper;

    /**
     * 查询入库单快照
     * 
     * @param id 入库单快照ID
     * @return 入库单快照
     */
    @Override
    public InstoreHistory selectInstoreHistoryById(Long id)
    {
        return instoreHistoryMapper.selectInstoreHistoryById(id);
    }

    /**
     * 查询入库单快照列表
     * 
     * @param instoreHistory 入库单快照
     * @return 入库单快照
     */
    @Override
    public List<InstoreHistory> selectInstoreHistoryList(InstoreHistory instoreHistory)
    {
        return instoreHistoryMapper.selectInstoreHistoryList(instoreHistory);
    }

    /**
     * 新增入库单快照
     * 
     * @param instoreHistory 入库单快照
     * @return 结果
     */
    @Override
    public int insertInstoreHistory(InstoreHistory instoreHistory)
    {
        return instoreHistoryMapper.insertInstoreHistory(instoreHistory);
    }

    /**
     * 修改入库单快照
     * 
     * @param instoreHistory 入库单快照
     * @return 结果
     */
    @Override
    public int updateInstoreHistory(InstoreHistory instoreHistory)
    {
        instoreHistory.setUpdateTime(DateUtils.getNowDate());
        return instoreHistoryMapper.updateInstoreHistory(instoreHistory);
    }

    /**
     * 批量删除入库单快照
     * 
     * @param ids 需要删除的入库单快照ID
     * @return 结果
     */
    @Override
    public int deleteInstoreHistoryByIds(Long[] ids)
    {
        return instoreHistoryMapper.deleteInstoreHistoryByIds(ids);
    }

    /**
     * 删除入库单快照信息
     * 
     * @param id 入库单快照ID
     * @return 结果
     */
    @Override
    public int deleteInstoreHistoryById(Long id)
    {
        return instoreHistoryMapper.deleteInstoreHistoryById(id);
    }
}
