package com.heyue.tms.mapper;

import java.util.List;
import com.heyue.tms.domain.Order;
import com.heyue.tms.domain.OrderDetail;

/**
 * 客户下单Mapper接口
 * 
 * @author heyue
 * @date 2021-08-06
 */
public interface OrderMapper 
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
     * 删除客户下单
     * 
     * @param id 客户下单ID
     * @return 结果
     */
    public int deleteOrderById(Long id);

    /**
     * 批量删除客户下单
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderByIds(Long[] ids);

    /**
     * 批量删除用户订单详情：（最小单位）
     * 
     * @param customerIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteOrderDetailByUserOrderIds(Long[] ids);
    
    /**
     * 批量新增用户订单详情：（最小单位）
     * 
     * @param orderDetailList 用户订单详情：（最小单位）列表
     * @return 结果
     */
    public int batchOrderDetail(List<OrderDetail> orderDetailList);
    

    /**
     * 通过客户下单ID删除用户订单详情：（最小单位）信息
     * 
     * @param roleId 角色ID
     * @return 结果
     */
    public int deleteOrderDetailByUserOrderId(Long id);
}
