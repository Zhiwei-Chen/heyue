package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.OrderDetail;

/**
 * 用户订单详情：（最小单位）Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IOrderDetailService 
{
    /**
     * 查询用户订单详情：（最小单位）
     * 
     * @param id 用户订单详情：（最小单位）ID
     * @return 用户订单详情：（最小单位）
     */
    public OrderDetail selectOrderDetailById(Long id);

    /**
     * 查询用户订单详情：（最小单位）列表
     * 
     * @param orderDetail 用户订单详情：（最小单位）
     * @return 用户订单详情：（最小单位）集合
     */
    public List<OrderDetail> selectOrderDetailList(OrderDetail orderDetail);

    /**
     * 新增用户订单详情：（最小单位）
     * 
     * @param orderDetail 用户订单详情：（最小单位）
     * @return 结果
     */
    public int insertOrderDetail(OrderDetail orderDetail);

    /**
     * 修改用户订单详情：（最小单位）
     * 
     * @param orderDetail 用户订单详情：（最小单位）
     * @return 结果
     */
    public int updateOrderDetail(OrderDetail orderDetail);

    /**
     * 批量删除用户订单详情：（最小单位）
     * 
     * @param ids 需要删除的用户订单详情：（最小单位）ID
     * @return 结果
     */
    public int deleteOrderDetailByIds(Long[] ids);

    /**
     * 删除用户订单详情：（最小单位）信息
     * 
     * @param id 用户订单详情：（最小单位）ID
     * @return 结果
     */
    public int deleteOrderDetailById(Long id);
}
