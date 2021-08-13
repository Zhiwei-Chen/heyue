package com.heyue.wms.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 库存信息对象 wms_stock
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class StockInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 物料编码 */
    @Excel(name = "物料编码")
    private Long materialId;

    /** 批号 */
    @Excel(name = "批号")
    private String batchNumber;

    /** 规格 */
    @Excel(name = "规格")
    private String specifications;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manufactureDate;

    /** 所属人 */
    @Excel(name = "所属人")
    private Long userId;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

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
    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setSpecifications(String specifications) 
    {
        this.specifications = specifications;
    }

    public String getSpecifications() 
    {
        return specifications;
    }
    public void setManufactureDate(Date manufactureDate) 
    {
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() 
    {
        return manufactureDate;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("materialId", getMaterialId())
            .append("batchNumber", getBatchNumber())
            .append("specifications", getSpecifications())
            .append("manufactureDate", getManufactureDate())
            .append("userId", getUserId())
            .append("unit", getUnit())
            .append("number", getNumber())
            .append("warehouseId", getWarehouseId())
            .append("areaId", getAreaId())
            .append("shelvesId", getShelvesId())
            .append("locationId", getLocationId())
            .toString();
    }
}
