package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.Areas;

/**
 * 仓库区域Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IAreasService 
{
    /**
     * 查询仓库区域
     * 
     * @param id 仓库区域ID
     * @return 仓库区域
     */
    public Areas selectAreasById(Long id);

    /**
     * 查询仓库区域列表
     * 
     * @param areas 仓库区域
     * @return 仓库区域集合
     */
    public List<Areas> selectAreasList(Areas areas);

    /**
     * 新增仓库区域
     * 
     * @param areas 仓库区域
     * @return 结果
     */
    public int insertAreas(Areas areas);

    /**
     * 修改仓库区域
     * 
     * @param areas 仓库区域
     * @return 结果
     */
    public int updateAreas(Areas areas);

    /**
     * 批量删除仓库区域
     * 
     * @param ids 需要删除的仓库区域ID
     * @return 结果
     */
    public int deleteAreasByIds(Long[] ids);

    /**
     * 删除仓库区域信息
     * 
     * @param id 仓库区域ID
     * @return 结果
     */
    public int deleteAreasById(Long id);
}
