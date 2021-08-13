package com.heyue.wms.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.wms.mapper.AreasMapper;
import com.heyue.wms.domain.Areas;
import com.heyue.wms.service.IAreasService;

/**
 * 仓库区域Service业务层处理
 * 
 * @author wchu
 * @date 2021-08-09
 */
@Service
public class AreasServiceImpl implements IAreasService 
{
    @Autowired
    private AreasMapper areasMapper;

    /**
     * 查询仓库区域
     * 
     * @param id 仓库区域ID
     * @return 仓库区域
     */
    @Override
    public Areas selectAreasById(Long id)
    {
        return areasMapper.selectAreasById(id);
    }

    /**
     * 查询仓库区域列表
     * 
     * @param areas 仓库区域
     * @return 仓库区域
     */
    @Override
    public List<Areas> selectAreasList(Areas areas)
    {
        return areasMapper.selectAreasList(areas);
    }

    /**
     * 新增仓库区域
     * 
     * @param areas 仓库区域
     * @return 结果
     */
    @Override
    public int insertAreas(Areas areas)
    {
        return areasMapper.insertAreas(areas);
    }

    /**
     * 修改仓库区域
     * 
     * @param areas 仓库区域
     * @return 结果
     */
    @Override
    public int updateAreas(Areas areas)
    {
        return areasMapper.updateAreas(areas);
    }

    /**
     * 批量删除仓库区域
     * 
     * @param ids 需要删除的仓库区域ID
     * @return 结果
     */
    @Override
    public int deleteAreasByIds(Long[] ids)
    {
        return areasMapper.deleteAreasByIds(ids);
    }

    /**
     * 删除仓库区域信息
     * 
     * @param id 仓库区域ID
     * @return 结果
     */
    @Override
    public int deleteAreasById(Long id)
    {
        return areasMapper.deleteAreasById(id);
    }
}
