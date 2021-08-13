package com.heyue.system.service.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.heyue.system.mapper.SysCompanyMapper;
import com.heyue.system.domain.SysCompany;
import com.heyue.system.service.ISysCompanyService;

/**
 * 注册验证Service业务层处理
 * 
 * @author heyue
 * @date 2021-08-06
 */
@Service
public class SysCompanyServiceImpl implements ISysCompanyService 
{
    @Autowired
    private SysCompanyMapper sysCompanyMapper;

    /**
     * 查询注册验证
     * 
     * @param qmsId 注册验证ID
     * @return 注册验证
     */
    @Override
    public SysCompany selectSysCompanyById(Long qmsId)
    {
        return sysCompanyMapper.selectSysCompanyById(qmsId);
    }

    /**
     * 查询注册验证列表
     * 
     * @param sysCompany 注册验证
     * @return 注册验证
     */
    @Override
    public List<SysCompany> selectSysCompanyList(SysCompany sysCompany)
    {
        return sysCompanyMapper.selectSysCompanyList(sysCompany);
    }

    /**
     * 新增注册验证
     * 
     * @param sysCompany 注册验证
     * @return 结果
     */
    @Override
    public int insertSysCompany(SysCompany sysCompany)
    {
        return sysCompanyMapper.insertSysCompany(sysCompany);
    }

    /**
     * 修改注册验证
     * 
     * @param sysCompany 注册验证
     * @return 结果
     */
    @Override
    public int updateSysCompany(SysCompany sysCompany)
    {
        return sysCompanyMapper.updateSysCompany(sysCompany);
    }

    /**
     * 批量删除注册验证
     * 
     * @param qmsIds 需要删除的注册验证ID
     * @return 结果
     */
    @Override
    public int deleteSysCompanyByIds(Long[] qmsIds)
    {
        return sysCompanyMapper.deleteSysCompanyByIds(qmsIds);
    }

    /**
     * 删除注册验证信息
     * 
     * @param qmsId 注册验证ID
     * @return 结果
     */
    @Override
    public int deleteSysCompanyById(Long qmsId)
    {
        return sysCompanyMapper.deleteSysCompanyById(qmsId);
    }
}
