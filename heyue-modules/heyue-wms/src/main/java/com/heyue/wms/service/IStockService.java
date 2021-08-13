package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.Stock;

/**
 * 库存Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IStockService 
{
    /**
     * 查询库存
     * 
     * @param id 库存ID
     * @return 库存
     */
    public Stock selectStockById(Long id);

    /**
     * 查询库存列表
     * 
     * @param stock 库存
     * @return 库存集合
     */
    public List<Stock> selectStockList(Stock stock);

    /**
     * 新增库存
     * 
     * @param stock 库存
     * @return 结果
     */
    public int insertStock(Stock stock);

    /**
     * 修改库存
     * 
     * @param stock 库存
     * @return 结果
     */
    public int updateStock(Stock stock);

    /**
     * 批量删除库存
     * 
     * @param ids 需要删除的库存ID
     * @return 结果
     */
    public int deleteStockByIds(Long[] ids);

    /**
     * 删除库存信息
     * 
     * @param id 库存ID
     * @return 结果
     */
    public int deleteStockById(Long id);
}
