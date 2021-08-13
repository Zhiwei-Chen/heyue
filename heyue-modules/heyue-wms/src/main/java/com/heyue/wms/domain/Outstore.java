package com.heyue.wms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 出库单管理对象 wms_outstore
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class Outstore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 出库单 */
    @Excel(name = "出库单")
    private Long outOrderId;

    /** 仓库 */
    @Excel(name = "仓库")
    private Long warehouseId;

    /** 货架 */
    @Excel(name = "货架")
    private Long shelvesId;

    /** 货位 */
    @Excel(name = "货位")
    private Long locationId;

    /** 下货人 */
    @Excel(name = "下货人")
    private Long transportUserId;

    /** 验货人 */
    @Excel(name = "验货人")
    private Long checkUserId;

    /** 区域 */
    @Excel(name = "区域")
    private Long areaId;

    /** 下货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transportTime;

    /** 核验时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "核验时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOutOrderId(Long outOrderId) 
    {
        this.outOrderId = outOrderId;
    }

    public Long getOutOrderId() 
    {
        return outOrderId;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setShelvesId(Long shelvesId) 
    {
        this.shelvesId = shelvesId;
    }

    public Long getShelvesId() 
    {
        return shelvesId;
    }
    public void setLocationId(Long locationId) 
    {
        this.locationId = locationId;
    }

    public Long getLocationId() 
    {
        return locationId;
    }
    public void setTransportUserId(Long transportUserId) 
    {
        this.transportUserId = transportUserId;
    }

    public Long getTransportUserId() 
    {
        return transportUserId;
    }
    public void setCheckUserId(Long checkUserId) 
    {
        this.checkUserId = checkUserId;
    }

    public Long getCheckUserId() 
    {
        return checkUserId;
    }
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
    }
    public void setTransportTime(Date transportTime) 
    {
        this.transportTime = transportTime;
    }

    public Date getTransportTime() 
    {
        return transportTime;
    }
    public void setCheckTime(Date checkTime) 
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() 
    {
        return checkTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("outOrderId", getOutOrderId())
            .append("warehouseId", getWarehouseId())
            .append("shelvesId", getShelvesId())
            .append("locationId", getLocationId())
            .append("transportUserId", getTransportUserId())
            .append("checkUserId", getCheckUserId())
            .append("areaId", getAreaId())
            .append("createTime", getCreateTime())
            .append("transportTime", getTransportTime())
            .append("checkTime", getCheckTime())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
