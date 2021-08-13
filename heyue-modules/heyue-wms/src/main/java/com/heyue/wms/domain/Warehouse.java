package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 仓库信息对象 wms_warehouse
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class Warehouse extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 分类 */
    @Excel(name = "分类")
    private String type;

    /** 仓储方式 */
    @Excel(name = "仓储方式")
    private String storeType;

    /** 负责人 */
    @Excel(name = "负责人")
    private Long userId;

    /** 传感器 */
    @Excel(name = "传感器")
    private String sensorIds;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setStoreType(String storeType) 
    {
        this.storeType = storeType;
    }

    public String getStoreType() 
    {
        return storeType;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setSensorIds(String sensorIds) 
    {
        this.sensorIds = sensorIds;
    }

    public String getSensorIds() 
    {
        return sensorIds;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("name", getName())
            .append("type", getType())
            .append("storeType", getStoreType())
            .append("remark", getRemark())
            .append("userId", getUserId())
            .append("sensorIds", getSensorIds())
            .append("status", getStatus())
            .toString();
    }
}
