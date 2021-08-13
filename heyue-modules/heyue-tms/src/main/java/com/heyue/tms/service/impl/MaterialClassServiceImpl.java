package com.heyue.tms.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import com.heyue.common.core.utils.DateUtils;
import com.heyue.common.core.utils.StringUtils;
import com.heyue.system.api.domain.SysDept;
import com.heyue.system.api.domain.SysRole;
import com.heyue.tms.domain.vo.TreeSelect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.tms.mapper.MaterialClassMapper;
import com.heyue.tms.domain.MaterialClass;
import com.heyue.tms.service.IMaterialClassService;

/**
 * 物料分类Service业务层处理
 * 
 * @author heyue
 * @date 2021-08-04
 */
@Service
public class MaterialClassServiceImpl implements IMaterialClassService 
{
    @Autowired
    private MaterialClassMapper materialClassMapper;

    /**
     * 查询物料分类
     * 
     * @param id 物料分类ID
     * @return 物料分类
     */
    @Override
    public MaterialClass selectMaterialClassById(Long id)
    {
        return materialClassMapper.selectMaterialClassById(id);
    }

    /**
     * 查询物料分类列表
     * 
     * @param materialClass 物料分类
     * @return 物料分类
     */
    @Override
    public List<MaterialClass> selectMaterialClassList(MaterialClass materialClass)
    {
        return materialClassMapper.selectMaterialClassList(materialClass);
    }

    /**
     * 新增物料分类
     * 
     * @param materialClass 物料分类
     * @return 结果
     */
    @Override
    public int insertMaterialClass(MaterialClass materialClass)
    {
        materialClass.setCreateTime(DateUtils.getNowDate());
        return materialClassMapper.insertMaterialClass(materialClass);
    }

    /**
     * 修改物料分类
     * 
     * @param materialClass 物料分类
     * @return 结果
     */
    @Override
    public int updateMaterialClass(MaterialClass materialClass)
    {
        materialClass.setUpdateTime(DateUtils.getNowDate());
        return materialClassMapper.updateMaterialClass(materialClass);
    }

    /**
     * 批量删除物料分类
     * 
     * @param ids 需要删除的物料分类ID
     * @return 结果
     */
    @Override
    public int deleteMaterialClassByIds(Long[] ids)
    {
        return materialClassMapper.deleteMaterialClassByIds(ids);
    }

    /**
     * 删除物料分类信息
     * 
     * @param id 物料分类ID
     * @return 结果
     */
    @Override
    public int deleteMaterialClassById(Long id)
    {
        return materialClassMapper.deleteMaterialClassById(id);
    }

    @Override
    public List<TreeSelect> buildDeptTreeSelect(List<MaterialClass> materialClasses) {
        List<MaterialClass> materialClassTrees = buildDeptTree(materialClasses);
        return materialClassTrees.stream().map(TreeSelect::new).collect(Collectors.toList());
    }

    private List<MaterialClass> buildDeptTree(List<MaterialClass> materialClasses) {
        List<MaterialClass> returnList = new ArrayList<MaterialClass>();
        List<Long> tempList = new ArrayList<Long>();
        for (MaterialClass materialClass : materialClasses)
        {
            tempList.add(materialClass.getId());
        }
        for (Iterator<MaterialClass> iterator = materialClasses.iterator(); iterator.hasNext();)
        {
            MaterialClass materialClass = (MaterialClass) iterator.next();
            // 如果是顶级节点, 遍历该父节点的所有子节点
            if (!tempList.contains(materialClass.getParentId()))
            {
                recursionFn(materialClasses, materialClass);
                returnList.add(materialClass);
            }
        }
        if (returnList.isEmpty())
        {
            returnList = materialClasses;
        }
        return returnList;
    }

    private void recursionFn(List<MaterialClass> list, MaterialClass t) {
        // 得到子节点列表
        List<MaterialClass> childList = getChildList(list, t);
        t.setChildren(childList);
        for (MaterialClass tChild : childList)
        {
            if (hasChild(list, tChild))
            {
                recursionFn(list, tChild);
            }
        }
    }
    /**
     * 得到子节点列表
     */
    private List<MaterialClass> getChildList(List<MaterialClass> list, MaterialClass t)
    {
        List<MaterialClass> tlist = new ArrayList<MaterialClass>();
        Iterator<MaterialClass> it = list.iterator();
        while (it.hasNext())
        {
            MaterialClass n = (MaterialClass) it.next();
            if (StringUtils.isNotNull(n.getParentId()) && n.getParentId().longValue() == t.getId().longValue())
            {
                tlist.add(n);
            }
        }
        return tlist;
    }

    /**
     * 判断是否有子节点
     */
    private boolean hasChild(List<MaterialClass> list, MaterialClass t)
    {
        return getChildList(list, t).size() > 0 ? true : false;
    }
}
