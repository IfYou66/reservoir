package com.szsk.reservoir.manageSystem.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.web.domain.TreeEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;

/**
 * 制度分类 对象 sys_class_type
 * 
 * @author cangfeng
 * @date 2021-07-21
 */
public class SysClassType extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long fId;

    /** 分类名称 */
    @Excel(name = "分类名称")
    private String fTypeName;

    /** 父级ID */
    @Excel(name = "父级ID")
    private Integer fParentId;

    /** 编号 */
    @Excel(name = "编号")
    private String fCode;

    /** 备注 */
    @Excel(name = "备注")
    private String fRemark;

    /** 状态 0：无效1：有效 */
    @Excel(name = "状态 0：无效1：有效")
    private Integer fStatus;

    /** 操作状态 0：可操作1：不可 */
    @Excel(name = "0：可操作1：不可")
    private Integer fOperationStatus;
    
    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;
    
    /** tab 默认0不显示1显示 */
    @Excel(name = "默认0不显示1显示")
    private Integer fIfTabShow;
    
    /**
     * 子分类
     */
    private List<SysClassType> sysClassChildren = new ArrayList<SysClassType>();

    /** 父级编号 查询使用 其他没用到 */
    private String fParentCode;
    
    public String getfParentCode() {
		return fParentCode;
	}

	public void setfParentCode(String fParentCode) {
		this.fParentCode = fParentCode;
	}

	public Integer getfIfTabShow() {
		return fIfTabShow;
	}

	public void setfIfTabShow(Integer fIfTabShow) {
		this.fIfTabShow = fIfTabShow;
	}

	public List<SysClassType> getSysClassChildren() {
        return sysClassChildren;
    }

    public void setSysClassChildren(List<SysClassType> sysClassChildren) {
        this.sysClassChildren = sysClassChildren;
    }


    public void setfTypeName(String fTypeName)
    {
        this.fTypeName = fTypeName;
    }

    public String getfTypeName() 
    {
        return fTypeName;
    }
    public void setfParentId(Integer fParentId) 
    {
        this.fParentId = fParentId;
    }

    public Integer getfParentId() 
    {
        return fParentId;
    }
    public void setParentId(Integer fParentId)
    {
        this.fParentId = fParentId;
    }

    public Long getParentId()
    {
        return Long.valueOf(fParentId);
    }
    public void setfCode(String fCode) 
    {
        this.fCode = fCode;
    }

    public String getfCode() 
    {
        return fCode;
    }
    public void setfRemark(String fRemark) 
    {
        this.fRemark = fRemark;
    }

    public String getfRemark() 
    {
        return fRemark;
    }
    public void setfStatus(Integer fStatus) 
    {
        this.fStatus = fStatus;
    }

    public Integer getfStatus() 
    {
        return fStatus;
    }
    public void setfCreateTime(Date fCreateTime) 
    {
        this.fCreateTime = fCreateTime;
    }

    public Date getfCreateTime() 
    {
        return fCreateTime;
    }

    public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public Integer getfOperationStatus() {
		return fOperationStatus;
	}

	public void setfOperationStatus(Integer fOperationStatus) {
		this.fOperationStatus = fOperationStatus;
	}

	@Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fTypeName", getfTypeName())
            .append("fParentId", getfParentId())
            .append("parentId", getParentId())
            .append("fCode", getfCode())
            .append("fRemark", getfRemark())
            .append("fStatus", getfStatus())
            .append("fCreateTime", getfCreateTime())
            .toString();
    }
}
