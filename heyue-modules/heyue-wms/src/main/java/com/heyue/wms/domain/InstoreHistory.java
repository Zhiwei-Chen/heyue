package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 入库单快照对象 wms_instore_history
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class InstoreHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 入库单编码 */
    @Excel(name = "入库单编码")
    private Long inOrderId;

    /** 内容 */
    @Excel(name = "内容")
    private String inOrderContent;

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
    public void setInOrderId(Long inOrderId) 
    {
        this.inOrderId = inOrderId;
    }

    public Long getInOrderId() 
    {
        return inOrderId;
    }
    public void setInOrderContent(String inOrderContent) 
    {
        this.inOrderContent = inOrderContent;
    }

    public String getInOrderContent() 
    {
        return inOrderContent;
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
            .append("inOrderId", getInOrderId())
            .append("inOrderContent", getInOrderContent())
            .append("updateTime", getUpdateTime())
            .append("orderStatus", getOrderStatus())
            .toString();
    }
}
