package com.heyue.system.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 注册验证对象 qms_company
 * 
 * @author heyue
 * @date 2021-08-06
 */
public class SysCompany extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long qmsId;

    /** 公司编号 */
    @Excel(name = "公司编号")
    private String qmsCompanyId;

    /** 公司名称 */
    @Excel(name = "公司名称")
    private String qmsCompanyName;

    /** 公司注册地址 */
    @Excel(name = "公司注册地址")
    private String qmsCompanyAddress;

    /** 公司药品管理信息运营范围（药品分类） */
    @Excel(name = "公司药品管理信息运营范围", readConverterExp = "药=品分类")
    private String qmsCompanyBusinessScope;

    /** 公司法人编号 */
    @Excel(name = "公司法人编号")
    private String qmsCompanyLegalpersonUserId;

    /** 公司与平台签订的合同的存储地址 */
    @Excel(name = "公司与平台签订的合同的存储地址")
    private String qmsTransportContract;

    /** 公司联系人编号 */
    @Excel(name = "公司联系人编号")
    private String qmsContactsUserId;

    /** 质量文件地址 */
    @Excel(name = "质量文件地址")
    private String qmsQualityFilesUrl;

    /** 0，未审核，1，已审核 */
    @Excel(name = "0，未审核，1，已审核")
    private String qmsCompanyStatus;

    public void setQmsId(Long qmsId) 
    {
        this.qmsId = qmsId;
    }

    public Long getQmsId() 
    {
        return qmsId;
    }
    public void setQmsCompanyId(String qmsCompanyId) 
    {
        this.qmsCompanyId = qmsCompanyId;
    }

    public String getQmsCompanyId() 
    {
        return qmsCompanyId;
    }
    public void setQmsCompanyName(String qmsCompanyName) 
    {
        this.qmsCompanyName = qmsCompanyName;
    }

    public String getQmsCompanyName() 
    {
        return qmsCompanyName;
    }
    public void setQmsCompanyAddress(String qmsCompanyAddress) 
    {
        this.qmsCompanyAddress = qmsCompanyAddress;
    }

    public String getQmsCompanyAddress() 
    {
        return qmsCompanyAddress;
    }
    public void setQmsCompanyBusinessScope(String qmsCompanyBusinessScope) 
    {
        this.qmsCompanyBusinessScope = qmsCompanyBusinessScope;
    }

    public String getQmsCompanyBusinessScope() 
    {
        return qmsCompanyBusinessScope;
    }
    public void setQmsCompanyLegalpersonUserId(String qmsCompanyLegalpersonUserId) 
    {
        this.qmsCompanyLegalpersonUserId = qmsCompanyLegalpersonUserId;
    }

    public String getQmsCompanyLegalpersonUserId() 
    {
        return qmsCompanyLegalpersonUserId;
    }
    public void setQmsTransportContract(String qmsTransportContract) 
    {
        this.qmsTransportContract = qmsTransportContract;
    }

    public String getQmsTransportContract() 
    {
        return qmsTransportContract;
    }
    public void setQmsContactsUserId(String qmsContactsUserId) 
    {
        this.qmsContactsUserId = qmsContactsUserId;
    }

    public String getQmsContactsUserId() 
    {
        return qmsContactsUserId;
    }
    public void setQmsQualityFilesUrl(String qmsQualityFilesUrl) 
    {
        this.qmsQualityFilesUrl = qmsQualityFilesUrl;
    }

    public String getQmsQualityFilesUrl() 
    {
        return qmsQualityFilesUrl;
    }
    public void setQmsCompanyStatus(String qmsCompanyStatus) 
    {
        this.qmsCompanyStatus = qmsCompanyStatus;
    }

    public String getQmsCompanyStatus() 
    {
        return qmsCompanyStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("qmsId", getQmsId())
            .append("qmsCompanyId", getQmsCompanyId())
            .append("qmsCompanyName", getQmsCompanyName())
            .append("qmsCompanyAddress", getQmsCompanyAddress())
            .append("qmsCompanyBusinessScope", getQmsCompanyBusinessScope())
            .append("qmsCompanyLegalpersonUserId", getQmsCompanyLegalpersonUserId())
            .append("qmsTransportContract", getQmsTransportContract())
            .append("qmsContactsUserId", getQmsContactsUserId())
            .append("qmsQualityFilesUrl", getQmsQualityFilesUrl())
            .append("qmsCompanyStatus", getQmsCompanyStatus())
            .toString();
    }
}
