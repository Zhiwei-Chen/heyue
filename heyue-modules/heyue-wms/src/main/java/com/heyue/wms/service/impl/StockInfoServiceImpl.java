package com.heyue.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.StockInfoMapper;
import com.heyue.wms.domain.StockInfo;
import com.heyue.wms.service.IStockInfoService;

/**
 * 库存信息Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class StockInfoServiceImpl implements IStockInfoService 
{
    @Autowired
    private StockInfoMapper stockInfoMapper;

    /**
     * 查询库存信息
     * 
     * @param id 库存信息ID
     * @return 库存信息
     */
    @Override
    public StockInfo selectStockInfoById(Long id)
    {
        return stockInfoMapper.selectStockInfoById(id);
    }

    /**
     * 查询库存信息列表
     * 
     * @param stockInfo 库存信息
     * @return 库存信息
     */
    @Override
    public List<StockInfo> selectStockInfoList(StockInfo stockInfo)
    {
        return stockInfoMapper.selectStockInfoList(stockInfo);
    }

    /**
     * 新增库存信息
     * 
     * @param stockInfo 库存信息
     * @return 结果
     */
    @Override
    public int insertStockInfo(StockInfo stockInfo)
    {
        return stockInfoMapper.insertStockInfo(stockInfo);
    }

    /**
     * 修改库存信息
     * 
     * @param stockInfo 库存信息
     * @return 结果
     */
    @Override
    public int updateStockInfo(StockInfo stockInfo)
    {
        return stockInfoMapper.updateStockInfo(stockInfo);
    }

    /**
     * 批量删除库存信息
     * 
     * @param ids 需要删除的库存信息ID
     * @return 结果
     */
    @Override
    public int deleteStockInfoByIds(Long[] ids)
    {
        return stockInfoMapper.deleteStockInfoByIds(ids);
    }

    /**
     * 删除库存信息信息
     * 
     * @param id 库存信息ID
     * @return 结果
     */
    @Override
    public int deleteStockInfoById(Long id)
    {
        return stockInfoMapper.deleteStockInfoById(id);
    }
}
