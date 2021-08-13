package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 仓储信息快照对象 wms_order_history
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class WmsOrderHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 精确编码 */
    @Excel(name = "精确编码")
    private Long userOrderDetailId;

    /** 仓储状态 */
    @Excel(name = "仓储状态")
    private String status;

    /** 内容 */
    @Excel(name = "内容")
    private String content;

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
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setContent(String content) 
    {
        this.content = content;
    }

    public String getContent() 
    {
        return content;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userOrderDetailId", getUserOrderDetailId())
            .append("status", getStatus())
            .append("content", getContent())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
