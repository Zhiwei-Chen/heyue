package com.heyue.tms.mapper;

import java.util.List;

import com.heyue.system.api.domain.SysDept;
import com.heyue.tms.domain.MaterialClass;

/**
 * 物料分类Mapper接口
 * 
 * @author heyue
 * @date 2021-08-04
 */
public interface MaterialClassMapper 
{
    /**
     * 查询物料分类
     * 
     * @param id 物料分类ID
     * @return 物料分类
     */
    public MaterialClass selectMaterialClassById(Long id);

    /**
     * 查询物料分类列表
     * 
     * @param materialClass 物料分类
     * @return 物料分类集合
     */
    public List<MaterialClass> selectMaterialClassList(MaterialClass materialClass);
    /**
     * 根据ID查询所有子物料类型
     *
     * @param id 部门ID
     * @return 物料类型列表
     */
    public List<MaterialClass> selectChildrenDeptById(Long id);
    /**
     * 新增物料分类
     * 
     * @param materialClass 物料分类
     * @return 结果
     */
    public int insertMaterialClass(MaterialClass materialClass);

    /**
     * 修改物料分类
     * 
     * @param materialClass 物料分类
     * @return 结果
     */
    public int updateMaterialClass(MaterialClass materialClass);

    /**
     * 删除物料分类
     * 
     * @param id 物料分类ID
     * @return 结果
     */
    public int deleteMaterialClassById(Long id);

    /**
     * 批量删除物料分类
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteMaterialClassByIds(Long[] ids);
}
