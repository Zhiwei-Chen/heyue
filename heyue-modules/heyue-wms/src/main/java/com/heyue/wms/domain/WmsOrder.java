package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 仓储信息对象 wms_order
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class WmsOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 精确编码 */
    @Excel(name = "精确编码")
    private Long userOrderDetailId;

    /** 入库单 */
    @Excel(name = "入库单")
    private Long inOrderId;

    /** 出库单 */
    @Excel(name = "出库单")
    private Long outOrderId;

    /** 调拨单 */
    @Excel(name = "调拨单")
    private Long moveOrderId;

    /** 货主 */
    @Excel(name = "货主")
    private Long cargoOwnerUserId;

    /** 仓储状态 */
    @Excel(name = "仓储状态")
    private String status;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserOrderDetailId(Long userOrderDetailId) 
    {
        this.userOrderDetailId = userOrderDetailId;
    }

    public Long getUserOrderDetailId() 
    {
        return userOrderDetailId;
    }
    public void setInOrderId(Long inOrderId) 
    {
        this.inOrderId = inOrderId;
    }

    public Long getInOrderId() 
    {
        return inOrderId;
    }
    public void setOutOrderId(Long outOrderId) 
    {
        this.outOrderId = outOrderId;
    }

    public Long getOutOrderId() 
    {
        return outOrderId;
    }
    public void setMoveOrderId(Long moveOrderId) 
    {
        this.moveOrderId = moveOrderId;
    }

    public Long getMoveOrderId() 
    {
        return moveOrderId;
    }
    public void setCargoOwnerUserId(Long cargoOwnerUserId) 
    {
        this.cargoOwnerUserId = cargoOwnerUserId;
    }

    public Long getCargoOwnerUserId() 
    {
        return cargoOwnerUserId;
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
            .append("userOrderDetailId", getUserOrderDetailId())
            .append("inOrderId", getInOrderId())
            .append("outOrderId", getOutOrderId())
            .append("moveOrderId", getMoveOrderId())
            .append("cargoOwnerUserId", getCargoOwnerUserId())
            .append("status", getStatus())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
