package com.heyue.wms.mapper;

import java.util.List;
import com.heyue.wms.domain.WmsOrderHistory;

/**
 * 仓储信息快照Mapper接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface WmsOrderHistoryMapper 
{
    /**
     * 查询仓储信息快照
     * 
     * @param id 仓储信息快照ID
     * @return 仓储信息快照
     */
    public WmsOrderHistory selectWmsOrderHistoryById(Long id);

    /**
     * 查询仓储信息快照列表
     * 
     * @param wmsOrderHistory 仓储信息快照
     * @return 仓储信息快照集合
     */
    public List<WmsOrderHistory> selectWmsOrderHistoryList(WmsOrderHistory wmsOrderHistory);

    /**
     * 新增仓储信息快照
     * 
     * @param wmsOrderHistory 仓储信息快照
     * @return 结果
     */
    public int insertWmsOrderHistory(WmsOrderHistory wmsOrderHistory);

    /**
     * 修改仓储信息快照
     * 
     * @param wmsOrderHistory 仓储信息快照
     * @return 结果
     */
    public int updateWmsOrderHistory(WmsOrderHistory wmsOrderHistory);

    /**
     * 删除仓储信息快照
     * 
     * @param id 仓储信息快照ID
     * @return 结果
     */
    public int deleteWmsOrderHistoryById(Long id);

    /**
     * 批量删除仓储信息快照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsOrderHistoryByIds(Long[] ids);
}
