package com.heyue.system.service;

import java.util.List;
import com.heyue.system.domain.SysCompany;

/**
 * 注册验证Service接口
 * 
 * @author heyue
 * @date 2021-08-06
 */
public interface ISysCompanyService 
{
    /**
     * 查询注册验证
     * 
     * @param qmsId 注册验证ID
     * @return 注册验证
     */
    public SysCompany selectSysCompanyById(Long qmsId);

    /**
     * 查询注册验证列表
     * 
     * @param sysCompany 注册验证
     * @return 注册验证集合
     */
    public List<SysCompany> selectSysCompanyList(SysCompany sysCompany);

    /**
     * 新增注册验证
     * 
     * @param sysCompany 注册验证
     * @return 结果
     */
    public int insertSysCompany(SysCompany sysCompany);

    /**
     * 修改注册验证
     * 
     * @param sysCompany 注册验证
     * @return 结果
     */
    public int updateSysCompany(SysCompany sysCompany);

    /**
     * 批量删除注册验证
     * 
     * @param qmsIds 需要删除的注册验证ID
     * @return 结果
     */
    public int deleteSysCompanyByIds(Long[] qmsIds);

    /**
     * 删除注册验证信息
     * 
     * @param qmsId 注册验证ID
     * @return 结果
     */
    public int deleteSysCompanyById(Long qmsId);
}
