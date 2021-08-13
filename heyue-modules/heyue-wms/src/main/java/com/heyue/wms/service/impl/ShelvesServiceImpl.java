package com.heyue.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.ShelvesMapper;
import com.heyue.wms.domain.Shelves;
import com.heyue.wms.service.IShelvesService;

/**
 * 货架信息Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class ShelvesServiceImpl implements IShelvesService 
{
    @Autowired
    private ShelvesMapper shelvesMapper;

    /**
     * 查询货架信息
     * 
     * @param id 货架信息ID
     * @return 货架信息
     */
    @Override
    public Shelves selectShelvesById(Long id)
    {
        return shelvesMapper.selectShelvesById(id);
    }

    /**
     * 查询货架信息列表
     * 
     * @param shelves 货架信息
     * @return 货架信息
     */
    @Override
    public List<Shelves> selectShelvesList(Shelves shelves)
    {
        return shelvesMapper.selectShelvesList(shelves);
    }

    /**
     * 新增货架信息
     * 
     * @param shelves 货架信息
     * @return 结果
     */
    @Override
    public int insertShelves(Shelves shelves)
    {
        return shelvesMapper.insertShelves(shelves);
    }

    /**
     * 修改货架信息
     * 
     * @param shelves 货架信息
     * @return 结果
     */
    @Override
    public int updateShelves(Shelves shelves)
    {
        return shelvesMapper.updateShelves(shelves);
    }

    /**
     * 批量删除货架信息
     * 
     * @param ids 需要删除的货架信息ID
     * @return 结果
     */
    @Override
    public int deleteShelvesByIds(Long[] ids)
    {
        return shelvesMapper.deleteShelvesByIds(ids);
    }

    /**
     * 删除货架信息信息
     * 
     * @param id 货架信息ID
     * @return 结果
     */
    @Override
    public int deleteShelvesById(Long id)
    {
        return shelvesMapper.deleteShelvesById(id);
    }
}
