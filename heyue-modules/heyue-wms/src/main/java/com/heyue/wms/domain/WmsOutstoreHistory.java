package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 出库单快照对象 wms_outstore_history
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class WmsOutstoreHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 出库单 */
    @Excel(name = "出库单")
    private Long outOrderId;

    /** 内容 */
    @Excel(name = "内容")
    private String outOrderContent;

    /** 状态 */
    @Excel(name = "状态")
    private String orderStatus;

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
    public void setOutOrderContent(String outOrderContent) 
    {
        this.outOrderContent = outOrderContent;
    }

    public String getOutOrderContent() 
    {
        return outOrderContent;
    }
    public void setOrderStatus(String orderStatus) 
    {
        this.orderStatus = orderStatus;
    }

    public String getOrderStatus() 
    {
        return orderStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("outOrderId", getOutOrderId())
            .append("outOrderContent", getOutOrderContent())
            .append("updateTime", getUpdateTime())
            .append("orderStatus", getOrderStatus())
            .toString();
    }
}
