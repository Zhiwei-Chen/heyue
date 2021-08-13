package com.heyue.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.CheckMapper;
import com.heyue.wms.domain.Check;
import com.heyue.wms.service.ICheckService;

/**
 * 库存盘点Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class CheckServiceImpl implements ICheckService 
{
    @Autowired
    private CheckMapper checkMapper;

    /**
     * 查询库存盘点
     * 
     * @param id 库存盘点ID
     * @return 库存盘点
     */
    @Override
    public Check selectCheckById(Long id)
    {
        return checkMapper.selectCheckById(id);
    }

    /**
     * 查询库存盘点列表
     * 
     * @param check 库存盘点
     * @return 库存盘点
     */
    @Override
    public List<Check> selectCheckList(Check check)
    {
        return checkMapper.selectCheckList(check);
    }

    /**
     * 新增库存盘点
     * 
     * @param check 库存盘点
     * @return 结果
     */
    @Override
    public int insertCheck(Check check)
    {
        return checkMapper.insertCheck(check);
    }

    /**
     * 修改库存盘点
     * 
     * @param check 库存盘点
     * @return 结果
     */
    @Override
    public int updateCheck(Check check)
    {
        return checkMapper.updateCheck(check);
    }

    /**
     * 批量删除库存盘点
     * 
     * @param ids 需要删除的库存盘点ID
     * @return 结果
     */
    @Override
    public int deleteCheckByIds(Long[] ids)
    {
        return checkMapper.deleteCheckByIds(ids);
    }

    /**
     * 删除库存盘点信息
     * 
     * @param id 库存盘点ID
     * @return 结果
     */
    @Override
    public int deleteCheckById(Long id)
    {
        return checkMapper.deleteCheckById(id);
    }
}
