package com.heyue.tms.service;

import java.util.List;
import com.heyue.tms.domain.MaterialClass;
import com.heyue.tms.domain.vo.TreeSelect;

/**
 * 物料分类Service接口
 * 
 * @author heyue
 * @date 2021-08-04
 */
public interface IMaterialClassService 
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
     * 批量删除物料分类
     * 
     * @param ids 需要删除的物料分类ID
     * @return 结果
     */
    public int deleteMaterialClassByIds(Long[] ids);

    /**
     * 删除物料分类信息
     * 
     * @param id 物料分类ID
     * @return 结果
     */
    public int deleteMaterialClassById(Long id);

    /**
     * 构建前端所需要下拉树结构
     *
     * @param materialClasses 物料分类列表
     * @return 下拉树结构列表
     */
    List<TreeSelect> buildDeptTreeSelect(List<MaterialClass> materialClasses);
}
