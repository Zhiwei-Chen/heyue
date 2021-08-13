package com.heyue.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.OrderDetailMapper;
import com.heyue.wms.domain.OrderDetail;
import com.heyue.wms.service.IOrderDetailService;

/**
 * 用户订单详情：（最小单位）Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class OrderDetailServiceImpl implements IOrderDetailService 
{
    @Autowired
    private OrderDetailMapper orderDetailMapper;

    /**
     * 查询用户订单详情：（最小单位）
     * 
     * @param id 用户订单详情：（最小单位）ID
     * @return 用户订单详情：（最小单位）
     */
    @Override
    public OrderDetail selectOrderDetailById(Long id)
    {
        return orderDetailMapper.selectOrderDetailById(id);
    }

    /**
     * 查询用户订单详情：（最小单位）列表
     * 
     * @param orderDetail 用户订单详情：（最小单位）
     * @return 用户订单详情：（最小单位）
     */
    @Override
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail)
    {
        return orderDetailMapper.selectOrderDetailList(orderDetail);
    }

    /**
     * 新增用户订单详情：（最小单位）
     * 
     * @param orderDetail 用户订单详情：（最小单位）
     * @return 结果
     */
    @Override
    public int insertOrderDetail(OrderDetail orderDetail)
    {
        return orderDetailMapper.insertOrderDetail(orderDetail);
    }

    /**
     * 修改用户订单详情：（最小单位）
     * 
     * @param orderDetail 用户订单详情：（最小单位）
     * @return 结果
     */
    @Override
    public int updateOrderDetail(OrderDetail orderDetail)
    {
        return orderDetailMapper.updateOrderDetail(orderDetail);
    }

    /**
     * 批量删除用户订单详情：（最小单位）
     * 
     * @param ids 需要删除的用户订单详情：（最小单位）ID
     * @return 结果
     */
    @Override
    public int deleteOrderDetailByIds(Long[] ids)
    {
        return orderDetailMapper.deleteOrderDetailByIds(ids);
    }

    /**
     * 删除用户订单详情：（最小单位）信息
     * 
     * @param id 用户订单详情：（最小单位）ID
     * @return 结果
     */
    @Override
    public int deleteOrderDetailById(Long id)
    {
        return orderDetailMapper.deleteOrderDetailById(id);
    }
}
