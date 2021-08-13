package com.heyue.wms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 库存盘点对象 wms_check
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class Check extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private Long materialId;

    /** 数量 */
    @Excel(name = "数量")
    private String number;

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

    /** 实际数量 */
    @Excel(name = "实际数量")
    private String actNumber;

    /** 核验状态 */
    @Excel(name = "核验状态")
    private String checkStatus;

    /** 核对结果 */
    @Excel(name = "核对结果")
    private String result;

    /** 入库单 */
    @Excel(name = "入库单")
    private Long inOrderId;

    /** 出库单 */
    @Excel(name = "出库单")
    private Long outOrderId;

    /** 核验人 */
    @Excel(name = "核验人")
    private Long userId;

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
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
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
    public void setActNumber(String actNumber) 
    {
        this.actNumber = actNumber;
    }

    public String getActNumber() 
    {
        return actNumber;
    }
    public void setCheckStatus(String checkStatus) 
    {
        this.checkStatus = checkStatus;
    }

    public String getCheckStatus() 
    {
        return checkStatus;
    }
    public void setResult(String result) 
    {
        this.result = result;
    }

    public String getResult() 
    {
        return result;
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
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
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
            .append("materialId", getMaterialId())
            .append("number", getNumber())
            .append("warehouseId", getWarehouseId())
            .append("areaId", getAreaId())
            .append("shelvesId", getShelvesId())
            .append("locationId", getLocationId())
            .append("actNumber", getActNumber())
            .append("checkStatus", getCheckStatus())
            .append("result", getResult())
            .append("inOrderId", getInOrderId())
            .append("outOrderId", getOutOrderId())
            .append("userId", getUserId())
            .append("checkTime", getCheckTime())
            .toString();
    }
}
