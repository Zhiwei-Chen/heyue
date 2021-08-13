package com.heyue.wms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.InstoreMapper;
import com.heyue.wms.domain.Instore;
import com.heyue.wms.service.IInstoreService;

/**
 * 入库单Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class InstoreServiceImpl implements IInstoreService 
{
    @Autowired
    private InstoreMapper instoreMapper;

    /**
     * 查询入库单
     * 
     * @param id 入库单ID
     * @return 入库单
     */
    @Override
    public Instore selectInstoreById(Long id)
    {
        return instoreMapper.selectInstoreById(id);
    }

    /**
     * 查询入库单列表
     * 
     * @param instore 入库单
     * @return 入库单
     */
    @Override
    public List<Instore> selectInstoreList(Instore instore)
    {
        return instoreMapper.selectInstoreList(instore);
    }

    /**
     * 新增入库单
     * 
     * @param instore 入库单
     * @return 结果
     */
    @Override
    public int insertInstore(Instore instore)
    {
        return instoreMapper.insertInstore(instore);
    }

    /**
     * 修改入库单
     * 
     * @param instore 入库单
     * @return 结果
     */
    @Override
    public int updateInstore(Instore instore)
    {
        instore.setUpdateTime(DateUtils.getNowDate());
        return instoreMapper.updateInstore(instore);
    }

    /**
     * 批量删除入库单
     * 
     * @param ids 需要删除的入库单ID
     * @return 结果
     */
    @Override
    public int deleteInstoreByIds(Long[] ids)
    {
        return instoreMapper.deleteInstoreByIds(ids);
    }

    /**
     * 删除入库单信息
     * 
     * @param id 入库单ID
     * @return 结果
     */
    @Override
    public int deleteInstoreById(Long id)
    {
        return instoreMapper.deleteInstoreById(id);
    }
}
