package com.heyue.wms.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

/**
 * 用户订单对象 user_order
 * 
 * @author wchu
 * @date 2021-08-10
 */
public class UserOrder extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    @Excel(name = "${comment}", readConverterExp = "$column.readConverterExp()")
    private Long id;

    /** 编号 */
    @Excel(name = "编号")
    private String code;

    /** 类型 */
    @Excel(name = "类型")
    private String type;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 总金额 */
    @Excel(name = "总金额")
    private BigDecimal allPrice;

    /** 支付金额 */
    @Excel(name = "支付金额")
    private BigDecimal allPayPrice;

    /** 预约取货时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "预约取货时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date bookingPickupTime;

    /** 下单客户编号 */
    @Excel(name = "下单客户编号")
    private Long userId;

    /** 下单客户姓名 */
    @Excel(name = "下单客户姓名")
    private String userName;

    /** 下单客户电话 */
    @Excel(name = "下单客户电话")
    private String userPhone;

    /** 货主 */
    @Excel(name = "货主")
    private Long sendUserId;

    /** 发货公司编号 */
    @Excel(name = "发货公司编号")
    private Long sendCompanyId;

    /** 发货公司名称 */
    @Excel(name = "发货公司名称")
    private String sendCompanyName;

    /** 发货联系人地址 */
    @Excel(name = "发货联系人地址")
    private String sendAddress;

    /** 收货公司编号 */
    @Excel(name = "收货公司编号")
    private Long customerCompanyId;

    /** 收货人编号 */
    @Excel(name = "收货人编号")
    private Long customerUserId;

    /** 收货人公司名称 */
    @Excel(name = "收货人公司名称")
    private String customerCompanyName;

    /** 收货人地址 */
    @Excel(name = "收货人地址")
    private String customerAddress;

    /** 司机编号 */
    @Excel(name = "司机编号")
    private Long driverId;

    /** 司机电话 */
    @Excel(name = "司机电话")
    private String driverPhone;

    /** 司机姓名 */
    @Excel(name = "司机姓名")
    private String driverName;

    /** 车辆编号 */
    @Excel(name = "车辆编号")
    private Long vanId;

    /** 车辆车牌号 */
    @Excel(name = "车辆车牌号")
    private String vanNumber;

    /** 支付详情编号 */
    @Excel(name = "支付详情编号")
    private Long paymentId;

    /** 支付状态 */
    @Excel(name = "支付状态")
    private String paymentState;

    /** 支付类型 */
    @Excel(name = "支付类型")
    private String paymentClass;

    /** 支付完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "支付完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date paymentTime;

    /** 仓储价格 */
    @Excel(name = "仓储价格")
    private BigDecimal wmsPrice;

    /** 仓储成本 */
    @Excel(name = "仓储成本")
    private BigDecimal wmsCost;

    /** 仓储方式 */
    @Excel(name = "仓储方式")
    private String wmsType;

    /** 承运总价格 */
    @Excel(name = "承运总价格")
    private BigDecimal tmsPrice;

    /** 承运总成本 */
    @Excel(name = "承运总成本")
    private BigDecimal tmsCost;

    /** 配送方式 */
    @Excel(name = "配送方式")
    private String tmsType;

    /** 二维码编码 */
    @Excel(name = "二维码编码")
    private String qrcode;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setType(String type) 
    {
        this.type = type;
    }

    public String getType() 
    {
        return type;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }
    public void setAllPrice(BigDecimal allPrice) 
    {
        this.allPrice = allPrice;
    }

    public BigDecimal getAllPrice() 
    {
        return allPrice;
    }
    public void setAllPayPrice(BigDecimal allPayPrice) 
    {
        this.allPayPrice = allPayPrice;
    }

    public BigDecimal getAllPayPrice() 
    {
        return allPayPrice;
    }
    public void setBookingPickupTime(Date bookingPickupTime) 
    {
        this.bookingPickupTime = bookingPickupTime;
    }

    public Date getBookingPickupTime() 
    {
        return bookingPickupTime;
    }
    public void setUserId(Long userId) 
    {
        this.userId = userId;
    }

    public Long getUserId() 
    {
        return userId;
    }
    public void setUserName(String userName) 
    {
        this.userName = userName;
    }

    public String getUserName() 
    {
        return userName;
    }
    public void setUserPhone(String userPhone) 
    {
        this.userPhone = userPhone;
    }

    public String getUserPhone() 
    {
        return userPhone;
    }
    public void setSendUserId(Long sendUserId) 
    {
        this.sendUserId = sendUserId;
    }

    public Long getSendUserId() 
    {
        return sendUserId;
    }
    public void setSendCompanyId(Long sendCompanyId) 
    {
        this.sendCompanyId = sendCompanyId;
    }

    public Long getSendCompanyId() 
    {
        return sendCompanyId;
    }
    public void setSendCompanyName(String sendCompanyName) 
    {
        this.sendCompanyName = sendCompanyName;
    }

    public String getSendCompanyName() 
    {
        return sendCompanyName;
    }
    public void setSendAddress(String sendAddress) 
    {
        this.sendAddress = sendAddress;
    }

    public String getSendAddress() 
    {
        return sendAddress;
    }
    public void setCustomerCompanyId(Long customerCompanyId) 
    {
        this.customerCompanyId = customerCompanyId;
    }

    public Long getCustomerCompanyId() 
    {
        return customerCompanyId;
    }
    public void setCustomerUserId(Long customerUserId) 
    {
        this.customerUserId = customerUserId;
    }

    public Long getCustomerUserId() 
    {
        return customerUserId;
    }
    public void setCustomerCompanyName(String customerCompanyName) 
    {
        this.customerCompanyName = customerCompanyName;
    }

    public String getCustomerCompanyName() 
    {
        return customerCompanyName;
    }
    public void setCustomerAddress(String customerAddress) 
    {
        this.customerAddress = customerAddress;
    }

    public String getCustomerAddress() 
    {
        return customerAddress;
    }
    public void setDriverId(Long driverId) 
    {
        this.driverId = driverId;
    }

    public Long getDriverId() 
    {
        return driverId;
    }
    public void setDriverPhone(String driverPhone) 
    {
        this.driverPhone = driverPhone;
    }

    public String getDriverPhone() 
    {
        return driverPhone;
    }
    public void setDriverName(String driverName) 
    {
        this.driverName = driverName;
    }

    public String getDriverName() 
    {
        return driverName;
    }
    public void setVanId(Long vanId) 
    {
        this.vanId = vanId;
    }

    public Long getVanId() 
    {
        return vanId;
    }
    public void setVanNumber(String vanNumber) 
    {
        this.vanNumber = vanNumber;
    }

    public String getVanNumber() 
    {
        return vanNumber;
    }
    public void setPaymentId(Long paymentId) 
    {
        this.paymentId = paymentId;
    }

    public Long getPaymentId() 
    {
        return paymentId;
    }
    public void setPaymentState(String paymentState) 
    {
        this.paymentState = paymentState;
    }

    public String getPaymentState() 
    {
        return paymentState;
    }
    public void setPaymentClass(String paymentClass) 
    {
        this.paymentClass = paymentClass;
    }

    public String getPaymentClass() 
    {
        return paymentClass;
    }
    public void setPaymentTime(Date paymentTime) 
    {
        this.paymentTime = paymentTime;
    }

    public Date getPaymentTime() 
    {
        return paymentTime;
    }
    public void setWmsPrice(BigDecimal wmsPrice) 
    {
        this.wmsPrice = wmsPrice;
    }

    public BigDecimal getWmsPrice() 
    {
        return wmsPrice;
    }
    public void setWmsCost(BigDecimal wmsCost) 
    {
        this.wmsCost = wmsCost;
    }

    public BigDecimal getWmsCost() 
    {
        return wmsCost;
    }
    public void setWmsType(String wmsType) 
    {
        this.wmsType = wmsType;
    }

    public String getWmsType() 
    {
        return wmsType;
    }
    public void setTmsPrice(BigDecimal tmsPrice) 
    {
        this.tmsPrice = tmsPrice;
    }

    public BigDecimal getTmsPrice() 
    {
        return tmsPrice;
    }
    public void setTmsCost(BigDecimal tmsCost) 
    {
        this.tmsCost = tmsCost;
    }

    public BigDecimal getTmsCost() 
    {
        return tmsCost;
    }
    public void setTmsType(String tmsType) 
    {
        this.tmsType = tmsType;
    }

    public String getTmsType() 
    {
        return tmsType;
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
            .append("code", getCode())
            .append("type", getType())
            .append("status", getStatus())
            .append("allPrice", getAllPrice())
            .append("allPayPrice", getAllPayPrice())
            .append("updateBy", getUpdateBy())
            .append("createTime", getCreateTime())
            .append("updateTime", getUpdateTime())
            .append("bookingPickupTime", getBookingPickupTime())
            .append("userId", getUserId())
            .append("userName", getUserName())
            .append("userPhone", getUserPhone())
            .append("sendUserId", getSendUserId())
            .append("sendCompanyId", getSendCompanyId())
            .append("sendCompanyName", getSendCompanyName())
            .append("sendAddress", getSendAddress())
            .append("customerCompanyId", getCustomerCompanyId())
            .append("customerUserId", getCustomerUserId())
            .append("customerCompanyName", getCustomerCompanyName())
            .append("customerAddress", getCustomerAddress())
            .append("driverId", getDriverId())
            .append("driverPhone", getDriverPhone())
            .append("driverName", getDriverName())
            .append("vanId", getVanId())
            .append("vanNumber", getVanNumber())
            .append("paymentId", getPaymentId())
            .append("paymentState", getPaymentState())
            .append("paymentClass", getPaymentClass())
            .append("paymentTime", getPaymentTime())
            .append("wmsPrice", getWmsPrice())
            .append("wmsCost", getWmsCost())
            .append("wmsType", getWmsType())
            .append("tmsPrice", getTmsPrice())
            .append("tmsCost", getTmsCost())
            .append("tmsType", getTmsType())
            .append("remark", getRemark())
            .append("qrcode", getQrcode())
            .toString();
    }
}
