package com.heyue.wms.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 用户订单详情：（最小单位）对象 user_order_detail
 * 
 * @author wchu
 * @date 2021-08-09
 */
public class OrderDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 精确编码 */
    private Long id;

    /** 订单编号 */
    @Excel(name = "订单编号")
    private Long userOrderId;

    /** 同行单编号 */
    @Excel(name = "同行单编号")
    private Long tmsOrderId;

    /** 物料编号 */
    @Excel(name = "物料编号")
    private Long materialId;

    /** 物料名称 */
    @Excel(name = "物料名称")
    private String materialName;

    /** 阳采编码 */
    @Excel(name = "阳采编码")
    private String yangcaiCode;

    /** 69码 */
    @Excel(name = "69码")
    private String code69;

    /** 品名 */
    @Excel(name = "品名")
    private String productName;

    /** 规格 */
    @Excel(name = "规格")
    private String specs;

    /** 生产厂商 */
    @Excel(name = "生产厂商")
    private String manufacturer;

    /** 数量 */
    @Excel(name = "数量")
    private String number;

    /** 单位 */
    @Excel(name = "单位")
    private String unit;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal unitPrice;

    /** 批号 */
    @Excel(name = "批号")
    private String batchNumber;

    /** 生产日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "生产日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date manufactureDate;

    /** 有效期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "有效期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date validityDate;

    /** 件数 */
    @Excel(name = "件数")
    private Long packagesNumber;

    /** 注册证号 */
    @Excel(name = "注册证号")
    private String registCertificateNo;

    /** 运输方式 */
    @Excel(name = "运输方式")
    private String transportType;

    /** 冷藏箱数量 */
    @Excel(name = "冷藏箱数量")
    private Long boxNumber;

    /** 仓储方式 */
    @Excel(name = "仓储方式")
    private String storageType;

    /** 物料分类名称 */
    @Excel(name = "物料分类名称")
    private String materialClassName;

    /** 相关质量文件 */
    @Excel(name = "相关质量文件")
    private String qualityFiles;

    /** 同行单子单编号 */
    @Excel(name = "同行单子单编号")
    private Long tmsOrderDetailId;

    /** 配送状态 */
    @Excel(name = "配送状态")
    private String tmsState;

    /** 入库状态 */
    @Excel(name = "入库状态")
    private Long wmsState;

    /** 二维码 */
    @Excel(name = "二维码")
    private String qrcode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setUserOrderId(Long userOrderId) 
    {
        this.userOrderId = userOrderId;
    }

    public Long getUserOrderId() 
    {
        return userOrderId;
    }
    public void setTmsOrderId(Long tmsOrderId) 
    {
        this.tmsOrderId = tmsOrderId;
    }

    public Long getTmsOrderId() 
    {
        return tmsOrderId;
    }
    public void setMaterialId(Long materialId) 
    {
        this.materialId = materialId;
    }

    public Long getMaterialId() 
    {
        return materialId;
    }
    public void setMaterialName(String materialName) 
    {
        this.materialName = materialName;
    }

    public String getMaterialName() 
    {
        return materialName;
    }
    public void setYangcaiCode(String yangcaiCode) 
    {
        this.yangcaiCode = yangcaiCode;
    }

    public String getYangcaiCode() 
    {
        return yangcaiCode;
    }
    public void setCode69(String code69) 
    {
        this.code69 = code69;
    }

    public String getCode69() 
    {
        return code69;
    }
    public void setProductName(String productName) 
    {
        this.productName = productName;
    }

    public String getProductName() 
    {
        return productName;
    }
    public void setSpecs(String specs) 
    {
        this.specs = specs;
    }

    public String getSpecs() 
    {
        return specs;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setNumber(String number) 
    {
        this.number = number;
    }

    public String getNumber() 
    {
        return number;
    }
    public void setUnit(String unit) 
    {
        this.unit = unit;
    }

    public String getUnit() 
    {
        return unit;
    }
    public void setUnitPrice(BigDecimal unitPrice) 
    {
        this.unitPrice = unitPrice;
    }

    public BigDecimal getUnitPrice() 
    {
        return unitPrice;
    }
    public void setBatchNumber(String batchNumber) 
    {
        this.batchNumber = batchNumber;
    }

    public String getBatchNumber() 
    {
        return batchNumber;
    }
    public void setManufactureDate(Date manufactureDate) 
    {
        this.manufactureDate = manufactureDate;
    }

    public Date getManufactureDate() 
    {
        return manufactureDate;
    }
    public void setValidityDate(Date validityDate) 
    {
        this.validityDate = validityDate;
    }

    public Date getValidityDate() 
    {
        return validityDate;
    }
    public void setPackagesNumber(Long packagesNumber) 
    {
        this.packagesNumber = packagesNumber;
    }

    public Long getPackagesNumber() 
    {
        return packagesNumber;
    }
    public void setRegistCertificateNo(String registCertificateNo) 
    {
        this.registCertificateNo = registCertificateNo;
    }

    public String getRegistCertificateNo() 
    {
        return registCertificateNo;
    }
    public void setTransportType(String transportType) 
    {
        this.transportType = transportType;
    }

    public String getTransportType() 
    {
        return transportType;
    }
    public void setBoxNumber(Long boxNumber) 
    {
        this.boxNumber = boxNumber;
    }

    public Long getBoxNumber() 
    {
        return boxNumber;
    }
    public void setStorageType(String storageType) 
    {
        this.storageType = storageType;
    }

    public String getStorageType() 
    {
        return storageType;
    }
    public void setMaterialClassName(String materialClassName) 
    {
        this.materialClassName = materialClassName;
    }

    public String getMaterialClassName() 
    {
        return materialClassName;
    }
    public void setQualityFiles(String qualityFiles) 
    {
        this.qualityFiles = qualityFiles;
    }

    public String getQualityFiles() 
    {
        return qualityFiles;
    }
    public void setTmsOrderDetailId(Long tmsOrderDetailId) 
    {
        this.tmsOrderDetailId = tmsOrderDetailId;
    }

    public Long getTmsOrderDetailId() 
    {
        return tmsOrderDetailId;
    }
    public void setTmsState(String tmsState) 
    {
        this.tmsState = tmsState;
    }

    public String getTmsState() 
    {
        return tmsState;
    }
    public void setWmsState(Long wmsState) 
    {
        this.wmsState = wmsState;
    }

    public Long getWmsState() 
    {
        return wmsState;
    }
    public void setQrcode(String qrcode) 
    {
        this.qrcode = qrcode;
    }

    public String getQrcode() 
    {
        return qrcode;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("userOrderId", getUserOrderId())
            .append("tmsOrderId", getTmsOrderId())
            .append("materialId", getMaterialId())
            .append("materialName", getMaterialName())
            .append("yangcaiCode", getYangcaiCode())
            .append("code69", getCode69())
            .append("productName", getProductName())
            .append("specs", getSpecs())
            .append("manufacturer", getManufacturer())
            .append("number", getNumber())
            .append("unit", getUnit())
            .append("unitPrice", getUnitPrice())
            .append("batchNumber", getBatchNumber())
            .append("manufactureDate", getManufactureDate())
            .append("validityDate", getValidityDate())
            .append("packagesNumber", getPackagesNumber())
            .append("registCertificateNo", getRegistCertificateNo())
            .append("transportType", getTransportType())
            .append("boxNumber", getBoxNumber())
            .append("storageType", getStorageType())
            .append("materialClassName", getMaterialClassName())
            .append("qualityFiles", getQualityFiles())
            .append("tmsOrderDetailId", getTmsOrderDetailId())
            .append("tmsState", getTmsState())
            .append("wmsState", getWmsState())
            .append("remark", getRemark())
            .append("qrcode", getQrcode())
            .toString();
    }
}
