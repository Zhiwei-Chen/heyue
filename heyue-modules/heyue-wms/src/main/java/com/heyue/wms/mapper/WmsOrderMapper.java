package com.heyue.wms.mapper;

import java.util.List;
import com.heyue.wms.domain.WmsOrder;

/**
 * 仓储信息Mapper接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface WmsOrderMapper 
{
    /**
     * 查询仓储信息
     * 
     * @param id 仓储信息ID
     * @return 仓储信息
     */
    public WmsOrder selectWmsOrderById(Long id);

    /**
     * 查询仓储信息列表
     * 
     * @param wmsOrder 仓储信息
     * @return 仓储信息集合
     */
    public List<WmsOrder> selectWmsOrderList(WmsOrder wmsOrder);

    /**
     * 新增仓储信息
     * 
     * @param wmsOrder 仓储信息
     * @return 结果
     */
    public int insertWmsOrder(WmsOrder wmsOrder);

    /**
     * 修改仓储信息
     * 
     * @param wmsOrder 仓储信息
     * @return 结果
     */
    public int updateWmsOrder(WmsOrder wmsOrder);

    /**
     * 删除仓储信息
     * 
     * @param id 仓储信息ID
     * @return 结果
     */
    public int deleteWmsOrderById(Long id);

    /**
     * 批量删除仓储信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsOrderByIds(Long[] ids);
}
