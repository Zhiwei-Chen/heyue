package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.WaitInstoreMapper;
import com.heyue.wms.domain.WaitInstore;
import com.heyue.wms.service.IWaitInstoreService;

/**
 * 待入库区Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class WaitInstoreServiceImpl implements IWaitInstoreService 
{
    @Autowired
    private WaitInstoreMapper waitInstoreMapper;

    /**
     * 查询待入库区
     * 
     * @param id 待入库区ID
     * @return 待入库区
     */
    @Override
    public WaitInstore selectWaitInstoreById(Long id)
    {
        return waitInstoreMapper.selectWaitInstoreById(id);
    }

    /**
     * 查询待入库区列表
     * 
     * @param waitInstore 待入库区
     * @return 待入库区
     */
    @Override
    public List<WaitInstore> selectWaitInstoreList(WaitInstore waitInstore)
    {
        return waitInstoreMapper.selectWaitInstoreList(waitInstore);
    }

    /**
     * 新增待入库区
     * 
     * @param waitInstore 待入库区
     * @return 结果
     */
    @Override
    public int insertWaitInstore(WaitInstore waitInstore)
    {
        return waitInstoreMapper.insertWaitInstore(waitInstore);
    }

    /**
     * 修改待入库区
     * 
     * @param waitInstore 待入库区
     * @return 结果
     */
    @Override
    public int updateWaitInstore(WaitInstore waitInstore)
    {
        waitInstore.setUpdateTime(DateUtils.getNowDate());
        return waitInstoreMapper.updateWaitInstore(waitInstore);
    }

    /**
     * 批量删除待入库区
     * 
     * @param ids 需要删除的待入库区ID
     * @return 结果
     */
    @Override
    public int deleteWaitInstoreByIds(Long[] ids)
    {
        return waitInstoreMapper.deleteWaitInstoreByIds(ids);
    }

    /**
     * 删除待入库区信息
     * 
     * @param id 待入库区ID
     * @return 结果
     */
    @Override
    public int deleteWaitInstoreById(Long id)
    {
        return waitInstoreMapper.deleteWaitInstoreById(id);
    }
}
