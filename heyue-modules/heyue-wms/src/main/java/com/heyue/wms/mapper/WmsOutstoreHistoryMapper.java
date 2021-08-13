package com.heyue.wms.mapper;

import java.util.List;
import com.heyue.wms.domain.WmsOutstoreHistory;

/**
 * 出库单快照Mapper接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface WmsOutstoreHistoryMapper 
{
    /**
     * 查询出库单快照
     * 
     * @param id 出库单快照ID
     * @return 出库单快照
     */
    public WmsOutstoreHistory selectWmsOutstoreHistoryById(Long id);

    /**
     * 查询出库单快照列表
     * 
     * @param wmsOutstoreHistory 出库单快照
     * @return 出库单快照集合
     */
    public List<WmsOutstoreHistory> selectWmsOutstoreHistoryList(WmsOutstoreHistory wmsOutstoreHistory);

    /**
     * 新增出库单快照
     * 
     * @param wmsOutstoreHistory 出库单快照
     * @return 结果
     */
    public int insertWmsOutstoreHistory(WmsOutstoreHistory wmsOutstoreHistory);

    /**
     * 修改出库单快照
     * 
     * @param wmsOutstoreHistory 出库单快照
     * @return 结果
     */
    public int updateWmsOutstoreHistory(WmsOutstoreHistory wmsOutstoreHistory);

    /**
     * 删除出库单快照
     * 
     * @param id 出库单快照ID
     * @return 结果
     */
    public int deleteWmsOutstoreHistoryById(Long id);

    /**
     * 批量删除出库单快照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteWmsOutstoreHistoryByIds(Long[] ids);
}
