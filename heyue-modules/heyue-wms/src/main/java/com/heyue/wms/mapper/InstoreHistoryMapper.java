package com.heyue.wms.mapper;

import java.util.List;
import com.heyue.wms.domain.InstoreHistory;

/**
 * 入库单快照Mapper接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface InstoreHistoryMapper 
{
    /**
     * 查询入库单快照
     * 
     * @param id 入库单快照ID
     * @return 入库单快照
     */
    public InstoreHistory selectInstoreHistoryById(Long id);

    /**
     * 查询入库单快照列表
     * 
     * @param instoreHistory 入库单快照
     * @return 入库单快照集合
     */
    public List<InstoreHistory> selectInstoreHistoryList(InstoreHistory instoreHistory);

    /**
     * 新增入库单快照
     * 
     * @param instoreHistory 入库单快照
     * @return 结果
     */
    public int insertInstoreHistory(InstoreHistory instoreHistory);

    /**
     * 修改入库单快照
     * 
     * @param instoreHistory 入库单快照
     * @return 结果
     */
    public int updateInstoreHistory(InstoreHistory instoreHistory);

    /**
     * 删除入库单快照
     * 
     * @param id 入库单快照ID
     * @return 结果
     */
    public int deleteInstoreHistoryById(Long id);

    /**
     * 批量删除入库单快照
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteInstoreHistoryByIds(Long[] ids);
}
