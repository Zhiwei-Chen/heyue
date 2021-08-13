package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.UserOrderMapper;
import com.heyue.wms.domain.UserOrder;
import com.heyue.wms.service.IUserOrderService;

/**
 * 用户订单Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-10
 */
@Service
public class UserOrderServiceImpl implements IUserOrderService 
{
    @Autowired
    private UserOrderMapper userOrderMapper;

    /**
     * 查询用户订单
     * 
     * @param id 用户订单ID
     * @return 用户订单
     */
    @Override
    public UserOrder selectUserOrderById(Long id)
    {
        return userOrderMapper.selectUserOrderById(id);
    }

    /**
     * 查询用户订单列表
     * 
     * @param userOrder 用户订单
     * @return 用户订单
     */
    @Override
    public List<UserOrder> selectUserOrderList(UserOrder userOrder)
    {
        return userOrderMapper.selectUserOrderList(userOrder);
    }

    /**
     * 新增用户订单
     * 
     * @param userOrder 用户订单
     * @return 结果
     */
    @Override
    public int insertUserOrder(UserOrder userOrder)
    {
        userOrder.setCreateTime(DateUtils.getNowDate());
        return userOrderMapper.insertUserOrder(userOrder);
    }

    /**
     * 修改用户订单
     * 
     * @param userOrder 用户订单
     * @return 结果
     */
    @Override
    public int updateUserOrder(UserOrder userOrder)
    {
        userOrder.setUpdateTime(DateUtils.getNowDate());
        return userOrderMapper.updateUserOrder(userOrder);
    }

    /**
     * 批量删除用户订单
     * 
     * @param ids 需要删除的用户订单ID
     * @return 结果
     */
    @Override
    public int deleteUserOrderByIds(Long[] ids)
    {
        return userOrderMapper.deleteUserOrderByIds(ids);
    }

    /**
     * 删除用户订单信息
     * 
     * @param id 用户订单ID
     * @return 结果
     */
    @Override
    public int deleteUserOrderById(Long id)
    {
        return userOrderMapper.deleteUserOrderById(id);
    }
}
