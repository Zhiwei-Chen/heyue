package com.heyue.tms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import com.heyue.common.core.utils.StringUtils;
import org.springframework.transaction.annotation.Transactional;
import com.heyue.tms.domain.OrderDetail;
import com.heyue.tms.mapper.OrderMapper;
import com.heyue.tms.domain.Order;
import com.heyue.tms.service.IOrderService;

/**
 * 客户下单Service业务层处理
 * 
 * @author heyue
 * @date 2021-08-06
 */
@Service
public class OrderServiceImpl implements IOrderService 
{
    @Autowired
    private OrderMapper orderMapper;

    /**
     * 查询客户下单
     * 
     * @param id 客户下单ID
     * @return 客户下单
     */
    @Override
    public Order selectOrderById(Long id)
    {
        return orderMapper.selectOrderById(id);
    }

    /**
     * 查询客户下单列表
     * 
     * @param order 客户下单
     * @return 客户下单
     */
    @Override
    public List<Order> selectOrderList(Order order)
    {
        return orderMapper.selectOrderList(order);
    }

    /**
     * 新增客户下单
     * 
     * @param order 客户下单
     * @return 结果
     */
    @Transactional
    @Override
    public int insertOrder(Order order)
    {
        order.setCreateTime(DateUtils.getNowDate());
        int rows = orderMapper.insertOrder(order);
        insertOrderDetail(order);
        return rows;
    }

    /**
     * 修改客户下单
     * 
     * @param order 客户下单
     * @return 结果
     */
    @Transactional
    @Override
    public int updateOrder(Order order)
    {
        order.setUpdateTime(DateUtils.getNowDate());
        orderMapper.deleteOrderDetailByUserOrderId(order.getId());
        insertOrderDetail(order);
        return orderMapper.updateOrder(order);
    }

    /**
     * 批量删除客户下单
     * 
     * @param ids 需要删除的客户下单ID
     * @return 结果
     */
    @Transactional
    @Override
    public int deleteOrderByIds(Long[] ids)
    {
        orderMapper.deleteOrderDetailByUserOrderIds(ids);
        return orderMapper.deleteOrderByIds(ids);
    }

    /**
     * 删除客户下单信息
     * 
     * @param id 客户下单ID
     * @return 结果
     */
    @Override
    public int deleteOrderById(Long id)
    {
        orderMapper.deleteOrderDetailByUserOrderId(id);
        return orderMapper.deleteOrderById(id);
    }

    /**
     * 新增用户订单详情：（最小单位）信息
     * 
     * @param order 客户下单对象
     */
    public void insertOrderDetail(Order order)
    {
        List<OrderDetail> orderDetailList = order.getOrderDetailList();
        Long id = order.getId();
        if (StringUtils.isNotNull(orderDetailList))
        {
            List<OrderDetail> list = new ArrayList<OrderDetail>();
            for (OrderDetail orderDetail : orderDetailList)
            {
                orderDetail.setUserOrderId(id);
                list.add(orderDetail);
            }
            if (list.size() > 0)
            {
                orderMapper.batchOrderDetail(list);
            }
        }
    }
}
