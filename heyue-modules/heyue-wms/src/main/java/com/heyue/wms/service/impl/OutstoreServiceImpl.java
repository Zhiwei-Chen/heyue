package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.OutstoreMapper;
import com.heyue.wms.domain.Outstore;
import com.heyue.wms.service.IOutstoreService;

/**
 * 出库单管理Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class OutstoreServiceImpl implements IOutstoreService 
{
    @Autowired
    private OutstoreMapper outstoreMapper;

    /**
     * 查询出库单管理
     * 
     * @param id 出库单管理ID
     * @return 出库单管理
     */
    @Override
    public Outstore selectOutstoreById(Long id)
    {
        return outstoreMapper.selectOutstoreById(id);
    }

    /**
     * 查询出库单管理列表
     * 
     * @param outstore 出库单管理
     * @return 出库单管理
     */
    @Override
    public List<Outstore> selectOutstoreList(Outstore outstore)
    {
        return outstoreMapper.selectOutstoreList(outstore);
    }

    /**
     * 新增出库单管理
     * 
     * @param outstore 出库单管理
     * @return 结果
     */
    @Override
    public int insertOutstore(Outstore outstore)
    {
        outstore.setCreateTime(DateUtils.getNowDate());
        return outstoreMapper.insertOutstore(outstore);
    }

    /**
     * 修改出库单管理
     * 
     * @param outstore 出库单管理
     * @return 结果
     */
    @Override
    public int updateOutstore(Outstore outstore)
    {
        outstore.setUpdateTime(DateUtils.getNowDate());
        return outstoreMapper.updateOutstore(outstore);
    }

    /**
     * 批量删除出库单管理
     * 
     * @param ids 需要删除的出库单管理ID
     * @return 结果
     */
    @Override
    public int deleteOutstoreByIds(Long[] ids)
    {
        return outstoreMapper.deleteOutstoreByIds(ids);
    }

    /**
     * 删除出库单管理信息
     * 
     * @param id 出库单管理ID
     * @return 结果
     */
    @Override
    public int deleteOutstoreById(Long id)
    {
        return outstoreMapper.deleteOutstoreById(id);
    }
}
