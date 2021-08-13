package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.StockInfo;

/**
 * 库存信息Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IStockInfoService 
{
    /**
     * 查询库存信息
     * 
     * @param id 库存信息ID
     * @return 库存信息
     */
    public StockInfo selectStockInfoById(Long id);

    /**
     * 查询库存信息列表
     * 
     * @param stockInfo 库存信息
     * @return 库存信息集合
     */
    public List<StockInfo> selectStockInfoList(StockInfo stockInfo);

    /**
     * 新增库存信息
     * 
     * @param stockInfo 库存信息
     * @return 结果
     */
    public int insertStockInfo(StockInfo stockInfo);

    /**
     * 修改库存信息
     * 
     * @param stockInfo 库存信息
     * @return 结果
     */
    public int updateStockInfo(StockInfo stockInfo);

    /**
     * 批量删除库存信息
     * 
     * @param ids 需要删除的库存信息ID
     * @return 结果
     */
    public int deleteStockInfoByIds(Long[] ids);

    /**
     * 删除库存信息信息
     * 
     * @param id 库存信息ID
     * @return 结果
     */
    public int deleteStockInfoById(Long id);
}
