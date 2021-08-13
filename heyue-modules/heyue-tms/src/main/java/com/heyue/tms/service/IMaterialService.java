package com.heyue.tms.service;

import java.util.List;
import com.heyue.tms.domain.Material;
import com.heyue.tms.domain.MaterialClass;

/**
 * 物料表单Service接口
 * 
 * @author heyue
 * @date 2021-08-04
 */
public interface IMaterialService 
{
    /**
     * 查询物料表单
     * 
     * @param id 物料表单ID
     * @return 物料表单
     */
    public Material selectMaterialById(Long id);

    /**
     * 查询物料表单列表
     * 
     * @param material 物料表单
     * @return 物料表单集合
     */
    public List<Material> selectMaterialList(Material material);

    /**
     * 新增物料表单
     * 
     * @param material 物料表单
     * @return 结果
     */
    public int insertMaterial(Material material);

    /**
     * 修改物料表单
     * 
     * @param material 物料表单
     * @return 结果
     */
    public int updateMaterial(Material material);

    /**
     * 批量删除物料表单
     * 
     * @param ids 需要删除的物料表单ID
     * @return 结果
     */
    public int deleteMaterialByIds(Long[] ids);

    /**
     * 删除物料表单信息
     * 
     * @param id 物料表单ID
     * @return 结果
     */
    public int deleteMaterialById(Long id);

}
