package com.heyue.wms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 库存快照对象 wms_stock_history
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class StockHistory extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 库存表 */
    @Excel(name = "库存表")
    private Long stockId;

    /** 入库单 */
    @Excel(name = "入库单")
    private Long inOrderId;

    /** 出库单 */
    @Excel(name = "出库单")
    private Long outOrderId;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setStockId(Long stockId) 
    {
        this.stockId = stockId;
    }

    public Long getStockId() 
    {
        return stockId;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("stockId", getStockId())
            .append("inOrderId", getInOrderId())
            .append("outOrderId", getOutOrderId())
            .append("updateTime", getUpdateTime())
            .toString();
    }
}
