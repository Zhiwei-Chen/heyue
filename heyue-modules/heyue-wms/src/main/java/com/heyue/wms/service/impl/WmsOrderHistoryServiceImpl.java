package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.WmsOrderHistoryMapper;
import com.heyue.wms.domain.WmsOrderHistory;
import com.heyue.wms.service.IWmsOrderHistoryService;

/**
 * 仓储信息快照Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class WmsOrderHistoryServiceImpl implements IWmsOrderHistoryService 
{
    @Autowired
    private WmsOrderHistoryMapper wmsOrderHistoryMapper;

    /**
     * 查询仓储信息快照
     * 
     * @param id 仓储信息快照ID
     * @return 仓储信息快照
     */
    @Override
    public WmsOrderHistory selectWmsOrderHistoryById(Long id)
    {
        return wmsOrderHistoryMapper.selectWmsOrderHistoryById(id);
    }

    /**
     * 查询仓储信息快照列表
     * 
     * @param wmsOrderHistory 仓储信息快照
     * @return 仓储信息快照
     */
    @Override
    public List<WmsOrderHistory> selectWmsOrderHistoryList(WmsOrderHistory wmsOrderHistory)
    {
        return wmsOrderHistoryMapper.selectWmsOrderHistoryList(wmsOrderHistory);
    }

    /**
     * 新增仓储信息快照
     * 
     * @param wmsOrderHistory 仓储信息快照
     * @return 结果
     */
    @Override
    public int insertWmsOrderHistory(WmsOrderHistory wmsOrderHistory)
    {
        return wmsOrderHistoryMapper.insertWmsOrderHistory(wmsOrderHistory);
    }

    /**
     * 修改仓储信息快照
     * 
     * @param wmsOrderHistory 仓储信息快照
     * @return 结果
     */
    @Override
    public int updateWmsOrderHistory(WmsOrderHistory wmsOrderHistory)
    {
        wmsOrderHistory.setUpdateTime(DateUtils.getNowDate());
        return wmsOrderHistoryMapper.updateWmsOrderHistory(wmsOrderHistory);
    }

    /**
     * 批量删除仓储信息快照
     * 
     * @param ids 需要删除的仓储信息快照ID
     * @return 结果
     */
    @Override
    public int deleteWmsOrderHistoryByIds(Long[] ids)
    {
        return wmsOrderHistoryMapper.deleteWmsOrderHistoryByIds(ids);
    }

    /**
     * 删除仓储信息快照信息
     * 
     * @param id 仓储信息快照ID
     * @return 结果
     */
    @Override
    public int deleteWmsOrderHistoryById(Long id)
    {
        return wmsOrderHistoryMapper.deleteWmsOrderHistoryById(id);
    }
}
