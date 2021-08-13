package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.WaitOutstore;

/**
 * 待出库区Service接口
 * 
 * @author heyue
 * @date 2021-08-09
 */
public interface IWaitOutstoreService 
{
    /**
     * 查询待出库区
     * 
     * @param id 待出库区ID
     * @return 待出库区
     */
    public WaitOutstore selectWaitOutstoreById(Long id);

    /**
     * 查询待出库区列表
     * 
     * @param waitOutstore 待出库区
     * @return 待出库区集合
     */
    public List<WaitOutstore> selectWaitOutstoreList(WaitOutstore waitOutstore);

    /**
     * 新增待出库区
     * 
     * @param waitOutstore 待出库区
     * @return 结果
     */
    public int insertWaitOutstore(WaitOutstore waitOutstore);

    /**
     * 修改待出库区
     * 
     * @param waitOutstore 待出库区
     * @return 结果
     */
    public int updateWaitOutstore(WaitOutstore waitOutstore);

    /**
     * 批量删除待出库区
     * 
     * @param ids 需要删除的待出库区ID
     * @return 结果
     */
    public int deleteWaitOutstoreByIds(Long[] ids);

    /**
     * 删除待出库区信息
     * 
     * @param id 待出库区ID
     * @return 结果
     */
    public int deleteWaitOutstoreById(Long id);
}
