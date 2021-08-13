package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 待入库区对象 wms_wait_instore
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class WaitInstore extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 精确编码 */
    @Excel(name = "精确编码")
    private Long orderDetailId;

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

    /** 状态 */
    @Excel(name = "状态")
    private Long status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setOrderDetailId(Long orderDetailId) 
    {
        this.orderDetailId = orderDetailId;
    }

    public Long getOrderDetailId() 
    {
        return orderDetailId;
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
    public void setStatus(Long status) 
    {
        this.status = status;
    }

    public Long getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("orderDetailId", getOrderDetailId())
            .append("warehouseId", getWarehouseId())
            .append("areaId", getAreaId())
            .append("shelvesId", getShelvesId())
            .append("locationId", getLocationId())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }
}
