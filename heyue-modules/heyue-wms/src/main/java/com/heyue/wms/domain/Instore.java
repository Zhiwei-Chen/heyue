package com.heyue.wms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 入库单对象 wms_instore
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class Instore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 入库单 */
    @Excel(name = "入库单")
    private Long inOrderId;

    /** 仓库 */
    @Excel(name = "仓库")
    private Long warehouseId;

    /** 区域 */
    @Excel(name = "区域")
    private Long areaId;

    /** 货架 */
    @Excel(name = "货架")
    private Long shelvesId;

    /** 货位 */
    @Excel(name = "货位")
    private Long locationId;

    /** 验货人 */
    @Excel(name = "验货人")
    private Long checkUserId;

    /** 核验时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "核验时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date checkTime;

    /** 上货人 */
    @Excel(name = "上货人")
    private Long transportUserId;

    /** 上货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transportTimeUp;

    /** 生成时间 */
    private Date creatTime;

    /** 下货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "下货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date transportTimeDown;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setInOrderId(Long inOrderId) 
    {
        this.inOrderId = inOrderId;
    }

    public Long getInOrderId() 
    {
        return inOrderId;
    }
    public void setWarehouseId(Long warehouseId) 
    {
        this.warehouseId = warehouseId;
    }

    public Long getWarehouseId() 
    {
        return warehouseId;
    }
    public void setAreaId(Long areaId) 
    {
        this.areaId = areaId;
    }

    public Long getAreaId() 
    {
        return areaId;
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
    public void setCheckUserId(Long checkUserId) 
    {
        this.checkUserId = checkUserId;
    }

    public Long getCheckUserId() 
    {
        return checkUserId;
    }
    public void setCheckTime(Date checkTime) 
    {
        this.checkTime = checkTime;
    }

    public Date getCheckTime() 
    {
        return checkTime;
    }
    public void setTransportUserId(Long transportUserId) 
    {
        this.transportUserId = transportUserId;
    }

    public Long getTransportUserId() 
    {
        return transportUserId;
    }
    public void setTransportTimeUp(Date transportTimeUp) 
    {
        this.transportTimeUp = transportTimeUp;
    }

    public Date getTransportTimeUp() 
    {
        return transportTimeUp;
    }
    public void setCreatTime(Date creatTime) 
    {
        this.creatTime = creatTime;
    }

    public Date getCreatTime() 
    {
        return creatTime;
    }
    public void setTransportTimeDown(Date transportTimeDown) 
    {
        this.transportTimeDown = transportTimeDown;
    }

    public Date getTransportTimeDown() 
    {
        return transportTimeDown;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("inOrderId", getInOrderId())
            .append("warehouseId", getWarehouseId())
            .append("areaId", getAreaId())
            .append("shelvesId", getShelvesId())
            .append("locationId", getLocationId())
            .append("checkUserId", getCheckUserId())
            .append("checkTime", getCheckTime())
            .append("transportUserId", getTransportUserId())
            .append("transportTimeUp", getTransportTimeUp())
            .append("creatTime", getCreatTime())
            .append("transportTimeDown", getTransportTimeDown())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
