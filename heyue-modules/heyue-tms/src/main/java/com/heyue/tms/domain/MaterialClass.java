package com.heyue.tms.domain;

import com.heyue.common.core.web.domain.BaseEntity;
import com.heyue.system.api.domain.SysDept;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.heyue.common.core.annotation.Excel;
import com.heyue.common.core.web.domain.TreeEntity;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 物料分类对象 tms_material_class
 * 
 * @author heyue
 * @date 2021-08-04
 */
public class MaterialClass extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** $column.columnComment */
    private Long id;

    /** 父地区分类ID */
    private Long parentId;

    /** 物料分类编码 */
    @Excel(name = "物料分类编码")
    private Long code;

    /** 物料分类名称 */
    @Excel(name = "物料分类名称")
    private String name;

    /** 相关质量文件 */
    @Excel(name = "相关质量文件")
    private String qualityFiles;

    /** 状态 */
    @Excel(name = "状态")
    private String status;

    /** 子物料分类*/
    private List<MaterialClass> children = new ArrayList<MaterialClass>();

    /** 父物料分类 */
    private String parentName;

    public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setCode(Long code) 
    {
        this.code = code;
    }

    public Long getCode() 
    {
        return code;
    }
    public void setName(String name) 
    {
        this.name = name;
    }

    public String getName() 
    {
        return name;
    }
    public void setQualityFiles(String qualityFiles) 
    {
        this.qualityFiles = qualityFiles;
    }

    public String getQualityFiles() 
    {
        return qualityFiles;
    }
    public void setStatus(String status) 
    {
        this.status = status;
    }

    public String getStatus() 
    {
        return status;
    }

    public List<MaterialClass> getChildren() {
        return children;
    }

    public void setChildren(List<MaterialClass> children) {
        this.children = children;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Long getParentId() {
        return parentId;
    }

    public void setParentId(Long parentId) {
        this.parentId = parentId;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("parentId", getParentId())
            .append("code", getCode())
            .append("name", getName())
            .append("qualityFiles", getQualityFiles())
            .append("remark", getRemark())
            .append("createBy", getCreateBy())
            .append("createTime", getCreateTime())
            .append("updateBy", getUpdateBy())
            .append("updateTime", getUpdateTime())
            .append("status", getStatus())
            .toString();
    }


}
