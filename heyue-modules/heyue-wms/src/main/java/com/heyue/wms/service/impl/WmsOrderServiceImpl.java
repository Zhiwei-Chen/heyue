package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.WmsOrderMapper;
import com.heyue.wms.domain.WmsOrder;
import com.heyue.wms.service.IWmsOrderService;

/**
 * 仓储信息Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class WmsOrderServiceImpl implements IWmsOrderService 
{
    @Autowired
    private WmsOrderMapper wmsOrderMapper;

    /**
     * 查询仓储信息
     * 
     * @param id 仓储信息ID
     * @return 仓储信息
     */
    @Override
    public WmsOrder selectWmsOrderById(Long id)
    {
        return wmsOrderMapper.selectWmsOrderById(id);
    }

    /**
     * 查询仓储信息列表
     * 
     * @param wmsOrder 仓储信息
     * @return 仓储信息
     */
    @Override
    public List<WmsOrder> selectWmsOrderList(WmsOrder wmsOrder)
    {
        return wmsOrderMapper.selectWmsOrderList(wmsOrder);
    }

    /**
     * 新增仓储信息
     * 
     * @param wmsOrder 仓储信息
     * @return 结果
     */
    @Override
    public int insertWmsOrder(WmsOrder wmsOrder)
    {
        return wmsOrderMapper.insertWmsOrder(wmsOrder);
    }

    /**
     * 修改仓储信息
     * 
     * @param wmsOrder 仓储信息
     * @return 结果
     */
    @Override
    public int updateWmsOrder(WmsOrder wmsOrder)
    {
        wmsOrder.setUpdateTime(DateUtils.getNowDate());
        return wmsOrderMapper.updateWmsOrder(wmsOrder);
    }

    /**
     * 批量删除仓储信息
     * 
     * @param ids 需要删除的仓储信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsOrderByIds(Long[] ids)
    {
        return wmsOrderMapper.deleteWmsOrderByIds(ids);
    }

    /**
     * 删除仓储信息信息
     * 
     * @param id 仓储信息ID
     * @return 结果
     */
    @Override
    public int deleteWmsOrderById(Long id)
    {
        return wmsOrderMapper.deleteWmsOrderById(id);
    }
}
