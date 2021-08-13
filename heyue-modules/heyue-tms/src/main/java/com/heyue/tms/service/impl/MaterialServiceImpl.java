package com.heyue.tms.service.impl;

import java.util.List;
import com.heyue.common.core.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.tms.mapper.MaterialMapper;
import com.heyue.tms.domain.Material;
import com.heyue.tms.service.IMaterialService;

/**
 * 物料表单Service业务层处理
 * 
 * @author heyue
 * @date 2021-08-04
 */
@Service
public class MaterialServiceImpl implements IMaterialService 
{
    @Autowired
    private MaterialMapper materialMapper;

    /**
     * 查询物料表单
     * 
     * @param id 物料表单ID
     * @return 物料表单
     */
    @Override
    public Material selectMaterialById(Long id)
    {
        return materialMapper.selectMaterialById(id);
    }

    /**
     * 查询物料表单列表
     * 
     * @param material 物料表单
     * @return 物料表单
     */
    @Override
    public List<Material> selectMaterialList(Material material)
    {
        return materialMapper.selectMaterialList(material);
    }

    /**
     * 新增物料表单
     * 
     * @param material 物料表单
     * @return 结果
     */
    @Override
    public int insertMaterial(Material material)
    {
        material.setCreateTime(DateUtils.getNowDate());
        return materialMapper.insertMaterial(material);
    }

    /**
     * 修改物料表单
     * 
     * @param material 物料表单
     * @return 结果
     */
    @Override
    public int updateMaterial(Material material)
    {
        material.setUpdateTime(DateUtils.getNowDate());
        return materialMapper.updateMaterial(material);
    }

    /**
     * 批量删除物料表单
     * 
     * @param ids 需要删除的物料表单ID
     * @return 结果
     */
    @Override
    public int deleteMaterialByIds(Long[] ids)
    {
        return materialMapper.deleteMaterialByIds(ids);
    }

    /**
     * 删除物料表单信息
     * 
     * @param id 物料表单ID
     * @return 结果
     */
    @Override
    public int deleteMaterialById(Long id)
    {
        return materialMapper.deleteMaterialById(id);
    }
}
