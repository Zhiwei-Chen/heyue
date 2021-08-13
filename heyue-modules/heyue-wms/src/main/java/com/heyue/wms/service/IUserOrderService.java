package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.UserOrder;

/**
 * 用户订单Service接口
 * 
 * @author wchu
 * @date 2021-08-10
 */
public interface IUserOrderService 
{
    /**
     * 查询用户订单
     * 
     * @param id 用户订单ID
     * @return 用户订单
     */
    public UserOrder selectUserOrderById(Long id);

    /**
     * 查询用户订单列表
     * 
     * @param userOrder 用户订单
     * @return 用户订单集合
     */
    public List<UserOrder> selectUserOrderList(UserOrder userOrder);

    /**
     * 新增用户订单
     * 
     * @param userOrder 用户订单
     * @return 结果
     */
    public int insertUserOrder(UserOrder userOrder);

    /**
     * 修改用户订单
     * 
     * @param userOrder 用户订单
     * @return 结果
     */
    public int updateUserOrder(UserOrder userOrder);

    /**
     * 批量删除用户订单
     * 
     * @param ids 需要删除的用户订单ID
     * @return 结果
     */
    public int deleteUserOrderByIds(Long[] ids);

    /**
     * 删除用户订单信息
     * 
     * @param id 用户订单ID
     * @return 结果
     */
    public int deleteUserOrderById(Long id);
}
