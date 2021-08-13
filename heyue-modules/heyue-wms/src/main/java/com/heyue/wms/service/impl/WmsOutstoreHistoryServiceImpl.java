package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.WmsOutstoreHistoryMapper;
import com.heyue.wms.domain.WmsOutstoreHistory;
import com.heyue.wms.service.IWmsOutstoreHistoryService;

/**
 * 出库单快照Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class WmsOutstoreHistoryServiceImpl implements IWmsOutstoreHistoryService 
{
    @Autowired
    private WmsOutstoreHistoryMapper wmsOutstoreHistoryMapper;

    /**
     * 查询出库单快照
     * 
     * @param id 出库单快照ID
     * @return 出库单快照
     */
    @Override
    public WmsOutstoreHistory selectWmsOutstoreHistoryById(Long id)
    {
        return wmsOutstoreHistoryMapper.selectWmsOutstoreHistoryById(id);
    }

    /**
     * 查询出库单快照列表
     * 
     * @param wmsOutstoreHistory 出库单快照
     * @return 出库单快照
     */
    @Override
    public List<WmsOutstoreHistory> selectWmsOutstoreHistoryList(WmsOutstoreHistory wmsOutstoreHistory)
    {
        return wmsOutstoreHistoryMapper.selectWmsOutstoreHistoryList(wmsOutstoreHistory);
    }

    /**
     * 新增出库单快照
     * 
     * @param wmsOutstoreHistory 出库单快照
     * @return 结果
     */
    @Override
    public int insertWmsOutstoreHistory(WmsOutstoreHistory wmsOutstoreHistory)
    {
        return wmsOutstoreHistoryMapper.insertWmsOutstoreHistory(wmsOutstoreHistory);
    }

    /**
     * 修改出库单快照
     * 
     * @param wmsOutstoreHistory 出库单快照
     * @return 结果
     */
    @Override
    public int updateWmsOutstoreHistory(WmsOutstoreHistory wmsOutstoreHistory)
    {
        wmsOutstoreHistory.setUpdateTime(DateUtils.getNowDate());
        return wmsOutstoreHistoryMapper.updateWmsOutstoreHistory(wmsOutstoreHistory);
    }

    /**
     * 批量删除出库单快照
     * 
     * @param ids 需要删除的出库单快照ID
     * @return 结果
     */
    @Override
    public int deleteWmsOutstoreHistoryByIds(Long[] ids)
    {
        return wmsOutstoreHistoryMapper.deleteWmsOutstoreHistoryByIds(ids);
    }

    /**
     * 删除出库单快照信息
     * 
     * @param id 出库单快照ID
     * @return 结果
     */
    @Override
    public int deleteWmsOutstoreHistoryById(Long id)
    {
        return wmsOutstoreHistoryMapper.deleteWmsOutstoreHistoryById(id);
    }
}
