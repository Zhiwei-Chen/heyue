package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 调拨单对象 wms_move
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class Move extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 调拨单 */
    @Excel(name = "调拨单")
    private Long moveOrderId;

    /** 原仓库 */
    @Excel(name = "原仓库")
    private Long warehouseIdBg;

    /** 拨入仓库 */
    @Excel(name = "拨入仓库")
    private Long warehouseIdEnd;

    /** 原货架 */
    @Excel(name = "原货架")
    private Long shelvesIdBg;

    /** 拨入货架 */
    @Excel(name = "拨入货架")
    private Long shelvesIdEnd;

    /** 原货位 */
    @Excel(name = "原货位")
    private Long locationIdBg;

    /** 拨入货位 */
    @Excel(name = "拨入货位")
    private Long locationIdEnd;

    /** 原货主 */
    @Excel(name = "原货主")
    private Long cargoOwnerUserIdBg;

    /** 拨入货主 */
    @Excel(name = "拨入货主")
    private Long cargoOwnerUserIdEnd;

    /** 操作人 */
    @Excel(name = "操作人")
    private Long userId;

    /** 原区域 */
    @Excel(name = "原区域")
    private Long areaIdBg;

    /** 拨入区域 */
    @Excel(name = "拨入区域")
    private Long areaIdEnd;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setMoveOrderId(Long moveOrderId) 
    {
        this.moveOrderId = moveOrderId;
    }

    public Long getMoveOrderId() 
    {
        return moveOrderId;
    }
    public void setWarehouseIdBg(Long warehouseIdBg) 
    {
        this.warehouseIdBg = warehouseIdBg;
    }

    public Long getWarehouseIdBg() 
    {
        return warehouseIdBg;
    }
    public void setWarehouseIdEnd(Long warehouseIdEnd) 
    {
        this.warehouseIdEnd = warehouseIdEnd;
    }

    public Long getWarehouseIdEnd() 
    {
        return warehouseIdEnd;
    }
    public void setShelvesIdBg(Long shelvesIdBg) 
    {
        this.shelvesIdBg = shelvesIdBg;
    }

    public Long getShelvesIdBg() 
    {
        return shelvesIdBg;
    }
    public void setShelvesIdEnd(Long shelvesIdEnd) 
    {
        this.shelvesIdEnd = shelvesIdEnd;
    }

    public Long getShelvesIdEnd() 
    {
        return shelvesIdEnd;
    }
    public void setLocationIdBg(Long locationIdBg) 
    {
        this.locationIdBg = locationIdBg;
    }

    public Long getLocationIdBg() 
    {
        return locationIdBg;
    }
    public void setLocationIdEnd(Long locationIdEnd) 
    {
        this.locationIdEnd = locationIdEnd;
    }

    public Long getLocationIdEnd() 
    {
        return locationIdEnd;
    }
    public void setCargoOwnerUserIdBg(Long cargoOwnerUserIdBg) 
    {
        this.cargoOwnerUserIdBg = cargoOwnerUserIdBg;
    }

    public Long getCargoOwnerUserIdBg() 
    {
        return cargoOwnerUserIdBg;
    }
    public void setCargoOwnerUserIdEnd(Long cargoOwnerUserIdEnd) 
    {
        this.cargoOwnerUserIdEnd = cargoOwnerUserIdEnd;
    }

    public Long getCargoOwnerUserIdEnd() 
    {
        return cargoOwnerUserIdEnd;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setAreaIdBg(Long areaIdBg) 
    {
        this.areaIdBg = areaIdBg;
    }

    public Long getAreaIdBg() 
    {
        return areaIdBg;
    }
    public void setAreaIdEnd(Long areaIdEnd) 
    {
        this.areaIdEnd = areaIdEnd;
    }

    public Long getAreaIdEnd() 
    {
        return areaIdEnd;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("moveOrderId", getMoveOrderId())
            .append("warehouseIdBg", getWarehouseIdBg())
            .append("warehouseIdEnd", getWarehouseIdEnd())
            .append("shelvesIdBg", getShelvesIdBg())
            .append("shelvesIdEnd", getShelvesIdEnd())
            .append("locationIdBg", getLocationIdBg())
            .append("locationIdEnd", getLocationIdEnd())
            .append("cargoOwnerUserIdBg", getCargoOwnerUserIdBg())
            .append("cargoOwnerUserIdEnd", getCargoOwnerUserIdEnd())
            .append("userId", getUserId())
            .append("areaIdBg", getAreaIdBg())
            .append("areaIdEnd", getAreaIdEnd())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
