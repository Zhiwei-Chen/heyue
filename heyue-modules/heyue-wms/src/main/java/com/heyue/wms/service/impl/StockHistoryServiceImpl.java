package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.StockHistoryMapper;
import com.heyue.wms.domain.StockHistory;
import com.heyue.wms.service.IStockHistoryService;

/**
 * 库存快照Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class StockHistoryServiceImpl implements IStockHistoryService 
{
    @Autowired
    private StockHistoryMapper stockHistoryMapper;

    /**
     * 查询库存快照
     * 
     * @param id 库存快照ID
     * @return 库存快照
     */
    @Override
    public StockHistory selectStockHistoryById(Long id)
    {
        return stockHistoryMapper.selectStockHistoryById(id);
    }

    /**
     * 查询库存快照列表
     * 
     * @param stockHistory 库存快照
     * @return 库存快照
     */
    @Override
    public List<StockHistory> selectStockHistoryList(StockHistory stockHistory)
    {
        return stockHistoryMapper.selectStockHistoryList(stockHistory);
    }

    /**
     * 新增库存快照
     * 
     * @param stockHistory 库存快照
     * @return 结果
     */
    @Override
    public int insertStockHistory(StockHistory stockHistory)
    {
        return stockHistoryMapper.insertStockHistory(stockHistory);
    }

    /**
     * 修改库存快照
     * 
     * @param stockHistory 库存快照
     * @return 结果
     */
    @Override
    public int updateStockHistory(StockHistory stockHistory)
    {
        stockHistory.setUpdateTime(DateUtils.getNowDate());
        return stockHistoryMapper.updateStockHistory(stockHistory);
    }

    /**
     * 批量删除库存快照
     * 
     * @param ids 需要删除的库存快照ID
     * @return 结果
     */
    @Override
    public int deleteStockHistoryByIds(Long[] ids)
    {
        return stockHistoryMapper.deleteStockHistoryByIds(ids);
    }

    /**
     * 删除库存快照信息
     * 
     * @param id 库存快照ID
     * @return 结果
     */
    @Override
    public int deleteStockHistoryById(Long id)
    {
        return stockHistoryMapper.deleteStockHistoryById(id);
    }
}
