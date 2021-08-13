package com.heyue.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.WaitOutstoreMapper;
import com.heyue.wms.domain.WaitOutstore;
import com.heyue.wms.service.IWaitOutstoreService;

/**
 * 待出库区Service业务层处理
 * 
 * @author heyue
 * @date 2021-08-09
 */
@Service
public class WaitOutstoreServiceImpl implements IWaitOutstoreService 
{
    @Autowired
    private WaitOutstoreMapper waitOutstoreMapper;

    /**
     * 查询待出库区
     * 
     * @param id 待出库区ID
     * @return 待出库区
     */
    @Override
    public WaitOutstore selectWaitOutstoreById(Long id)
    {
        return waitOutstoreMapper.selectWaitOutstoreById(id);
    }

    /**
     * 查询待出库区列表
     * 
     * @param waitOutstore 待出库区
     * @return 待出库区
     */
    @Override
    public List<WaitOutstore> selectWaitOutstoreList(WaitOutstore waitOutstore)
    {
        return waitOutstoreMapper.selectWaitOutstoreList(waitOutstore);
    }

    /**
     * 新增待出库区
     * 
     * @param waitOutstore 待出库区
     * @return 结果
     */
    @Override
    public int insertWaitOutstore(WaitOutstore waitOutstore)
    {
        return waitOutstoreMapper.insertWaitOutstore(waitOutstore);
    }

    /**
     * 修改待出库区
     * 
     * @param waitOutstore 待出库区
     * @return 结果
     */
    @Override
    public int updateWaitOutstore(WaitOutstore waitOutstore)
    {
        return waitOutstoreMapper.updateWaitOutstore(waitOutstore);
    }

    /**
     * 批量删除待出库区
     * 
     * @param ids 需要删除的待出库区ID
     * @return 结果
     */
    @Override
    public int deleteWaitOutstoreByIds(Long[] ids)
    {
        return waitOutstoreMapper.deleteWaitOutstoreByIds(ids);
    }

    /**
     * 删除待出库区信息
     * 
     * @param id 待出库区ID
     * @return 结果
     */
    @Override
    public int deleteWaitOutstoreById(Long id)
    {
        return waitOutstoreMapper.deleteWaitOutstoreById(id);
    }
}
