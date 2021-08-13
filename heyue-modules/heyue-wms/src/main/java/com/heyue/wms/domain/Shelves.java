package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 货架信息对象 wms_shelves
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class Shelves extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 区域 */
    @Excel(name = "区域")
    private Long areaId;

    /** 名称 */
    @Excel(name = "名称")
    private String name;

    /** 分类 */
    @Excel(name = "分类")
    private String type;

    /** 货架状态 */
    @Excel(name = "货架状态")
    private String shelvesState;

    /** 描述 */
    @Excel(name = "描述")
    private String describe;

    /** 可用状态 */
    @Excel(name = "可用状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
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
    public void setShelvesState(String shelvesState) 
    {
        this.shelvesState = shelvesState;
    }

    public String getShelvesState() 
    {
        return shelvesState;
    }
    public void setDescribe(String describe) 
    {
        this.describe = describe;
    }

    public String getDescribe() 
    {
        return describe;
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
            .append("areaId", getAreaId())
            .append("name", getName())
            .append("type", getType())
            .append("shelvesState", getShelvesState())
            .append("describe", getDescribe())
            .append("remark", getRemark())
            .append("status", getStatus())
            .toString();
    }
}
