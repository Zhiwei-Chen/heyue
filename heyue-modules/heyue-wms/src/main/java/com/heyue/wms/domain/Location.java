package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 货位信息对象 wms_location
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class Location extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 货架 */
    @Excel(name = "货架")
    private Long shelvesId;

    /** 货位编码 */
    @Excel(name = "货位编码")
    private String code;

    /** 货位名称 */
    @Excel(name = "货位名称")
    private String name;

    /** 位置 */
    @Excel(name = "位置")
    private String position;

    /** 尺寸 */
    @Excel(name = "尺寸")
    private String space;

    /** 货位状态 */
    @Excel(name = "货位状态")
    private String status;

    /** 货位类型 */
    @Excel(name = "货位类型")
    private String type;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setShelvesId(Long shelvesId) 
    {
        this.shelvesId = shelvesId;
    }

    public Long getShelvesId() 
    {
        return shelvesId;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setPosition(String position) 
    {
        this.position = position;
    }

    public String getPosition() 
    {
        return position;
    }
    public void setSpace(String space) 
    {
        this.space = space;
    }

    public String getSpace() 
    {
        return space;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("shelvesId", getShelvesId())
            .append("code", getCode())
            .append("name", getName())
            .append("position", getPosition())
            .append("space", getSpace())
            .append("status", getStatus())
            .append("type", getType())
            .toString();
    }
}
