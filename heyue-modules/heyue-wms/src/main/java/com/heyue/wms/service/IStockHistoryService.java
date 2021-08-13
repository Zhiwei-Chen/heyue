package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.StockHistory;

/**
 * 库存快照Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IStockHistoryService 
{
    /**
     * 查询库存快照
     * 
     * @param id 库存快照ID
     * @return 库存快照
     */
    public StockHistory selectStockHistoryById(Long id);

    /**
     * 查询库存快照列表
     * 
     * @param stockHistory 库存快照
     * @return 库存快照集合
     */
    public List<StockHistory> selectStockHistoryList(StockHistory stockHistory);

    /**
     * 新增库存快照
     * 
     * @param stockHistory 库存快照
     * @return 结果
     */
    public int insertStockHistory(StockHistory stockHistory);

    /**
     * 修改库存快照
     * 
     * @param stockHistory 库存快照
     * @return 结果
     */
    public int updateStockHistory(StockHistory stockHistory);

    /**
     * 批量删除库存快照
     * 
     * @param ids 需要删除的库存快照ID
     * @return 结果
     */
    public int deleteStockHistoryByIds(Long[] ids);

    /**
     * 删除库存快照信息
     * 
     * @param id 库存快照ID
     * @return 结果
     */
    public int deleteStockHistoryById(Long id);
}
