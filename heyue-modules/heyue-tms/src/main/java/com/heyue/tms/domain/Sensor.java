package com.heyue.tms.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.BaseEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 传感器管理对象 tms_sensor
 * 
 * @author heyue
 * @date 2021-07-30
 */
public class Sensor extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 传感器类型 */
    @Excel(name = "传感器类型")
    private String sensorType;

    /** 冷藏车编号 */
    @Excel(name = "冷藏车编号")
    private Long vanId;

    /** 冷藏箱编号 */
    @Excel(name = "冷藏箱编号")
    private Long refrigeratorId;

    /** 传感器编号 */
    @Excel(name = "传感器编号")
    private String sensorCode;

    /** 生产商 */
    @Excel(name = "生产商")
    private String manufacturer;

    /** 电量 */
    @Excel(name = "电量")
    private Long electricity;

    /** 设备状态 */
    @Excel(name = "设备状态")
    private String status;

    private List<SensorDetail> sensorDetailList = new ArrayList<SensorDetail>();

    public List<SensorDetail> getSensorDetailList() {
        return sensorDetailList;
    }

    public void setSensorDetailList(List<SensorDetail> sensorDetailList) {
        this.sensorDetailList = sensorDetailList;
    }

    public void setId(Long id)
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setSensorType(String sensorType) 
    {
        this.sensorType = sensorType;
    }

    public String getSensorType() 
    {
        return sensorType;
    }
    public void setVanId(Long vanId) 
    {
        this.vanId = vanId;
    }

    public Long getVanId() 
    {
        return vanId;
    }
    public void setRefrigeratorId(Long refrigeratorId) 
    {
        this.refrigeratorId = refrigeratorId;
    }

    public Long getRefrigeratorId() 
    {
        return refrigeratorId;
    }
    public void setSensorCode(String sensorCode) 
    {
        this.sensorCode = sensorCode;
    }

    public String getSensorCode() 
    {
        return sensorCode;
    }
    public void setManufacturer(String manufacturer) 
    {
        this.manufacturer = manufacturer;
    }

    public String getManufacturer() 
    {
        return manufacturer;
    }
    public void setElectricity(Long electricity) 
    {
        this.electricity = electricity;
    }

    public Long getElectricity() 
    {
        return electricity;
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
            .append("sensorType", getSensorType())
            .append("vanId", getVanId())
            .append("refrigeratorId", getRefrigeratorId())
            .append("sensorCode", getSensorCode())
            .append("manufacturer", getManufacturer())
            .append("electricity", getElectricity())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("status", getStatus())
            .toString();
    }
}
