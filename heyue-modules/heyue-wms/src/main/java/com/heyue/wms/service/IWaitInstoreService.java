package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.WaitInstore;

/**
 * 待入库区Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IWaitInstoreService 
{
    /**
     * 查询待入库区
     * 
     * @param id 待入库区ID
     * @return 待入库区
     */
    public WaitInstore selectWaitInstoreById(Long id);

    /**
     * 查询待入库区列表
     * 
     * @param waitInstore 待入库区
     * @return 待入库区集合
     */
    public List<WaitInstore> selectWaitInstoreList(WaitInstore waitInstore);

    /**
     * 新增待入库区
     * 
     * @param waitInstore 待入库区
     * @return 结果
     */
    public int insertWaitInstore(WaitInstore waitInstore);

    /**
     * 修改待入库区
     * 
     * @param waitInstore 待入库区
     * @return 结果
     */
    public int updateWaitInstore(WaitInstore waitInstore);

    /**
     * 批量删除待入库区
     * 
     * @param ids 需要删除的待入库区ID
     * @return 结果
     */
    public int deleteWaitInstoreByIds(Long[] ids);

    /**
     * 删除待入库区信息
     * 
     * @param id 待入库区ID
     * @return 结果
     */
    public int deleteWaitInstoreById(Long id);
}
