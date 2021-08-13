package com.heyue.wms.service;

import java.util.List;
import com.heyue.wms.domain.Shelves;

/**
 * 货架信息Service接口
 * 
 * @author wchu
 * @date 2021-08-09
 */
public interface IShelvesService 
{
    /**
     * 查询货架信息
     * 
     * @param id 货架信息ID
     * @return 货架信息
     */
    public Shelves selectShelvesById(Long id);

    /**
     * 查询货架信息列表
     * 
     * @param shelves 货架信息
     * @return 货架信息集合
     */
    public List<Shelves> selectShelvesList(Shelves shelves);

    /**
     * 新增货架信息
     * 
     * @param shelves 货架信息
     * @return 结果
     */
    public int insertShelves(Shelves shelves);

    /**
     * 修改货架信息
     * 
     * @param shelves 货架信息
     * @return 结果
     */
    public int updateShelves(Shelves shelves);

    /**
     * 批量删除货架信息
     * 
     * @param ids 需要删除的货架信息ID
     * @return 结果
     */
    public int deleteShelvesByIds(Long[] ids);

    /**
     * 删除货架信息信息
     * 
     * @param id 货架信息ID
     * @return 结果
     */
    public int deleteShelvesById(Long id);
}
