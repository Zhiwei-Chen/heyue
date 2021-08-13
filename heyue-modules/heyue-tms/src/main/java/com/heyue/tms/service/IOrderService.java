package com.heyue.tms.service;

import java.util.List;
import com.heyue.tms.domain.Order;

/**
 * 客户下单Service接口
 * 
 * @author heyue
 * @date 2021-08-06
 */
public interface IOrderService 
{
    /**
     * 查询客户下单
     * 
     * @param id 客户下单ID
     * @return 客户下单
     */
    public Order selectOrderById(Long id);

    /**
     * 查询客户下单列表
     * 
     * @param order 客户下单
     * @return 客户下单集合
     */
    public List<Order> selectOrderList(Order order);

    /**
     * 新增客户下单
     * 
     * @param order 客户下单
     * @return 结果
     */
    public int insertOrder(Order order);

    /**
     * 修改客户下单
     * 
     * @param order 客户下单
     * @return 结果
     */
    public int updateOrder(Order order);

    /**
     * 批量删除客户下单
     * 
     * @param ids 需要删除的客户下单ID
     * @return 结果
     */
    public int deleteOrderByIds(Long[] ids);

    /**
     * 删除客户下单信息
     * 
     * @param id 客户下单ID
     * @return 结果
     */
    public int deleteOrderById(Long id);
}
