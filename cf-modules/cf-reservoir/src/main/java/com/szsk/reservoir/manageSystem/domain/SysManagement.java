package com.szsk.reservoir.manageSystem.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 制度管理 对象 sys_management
 * 
 * @author cangfeng
 * @date 2021-08-12
 */
public class SysManagement extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long fId;

    /** 制度名称 */
    @Excel(name = "制度名称")
    private String fSystemName;

    /** 分类ID */
    @Excel(name = "分类ID")
    private Integer fTypeId;

    /** 制度内容 */
    @Excel(name = "制度内容")
    private String fSystemContent;

    /** 备注 */
    @Excel(name = "备注")
    private String fRemark;

    /** 附件url */
    @Excel(name = "附件url")
    private String fInstitutionId;

    /** 状态 0:无效1：有效 */
    @Excel(name = "状态 0:无效1：有效")
    private Integer fStatus;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;

    /** 修改时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "修改时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fUpdateTime;

	public Long getfId() {
        return fId;
    }

    public void setfId(Long fId) {
        this.fId = fId;
    }

    public String getfInstitutionId() {
        return fInstitutionId;
    }

    public void setfInstitutionId(String fInstitutionId) {
        this.fInstitutionId = fInstitutionId;
    }

    public void setfSystemName(String fSystemName)
    {
        this.fSystemName = fSystemName;
    }

    public String getfSystemName() 
    {
        return fSystemName;
    }
    public void setfTypeId(Integer fTypeId) 
    {
        this.fTypeId = fTypeId;
    }

    public Integer getfTypeId() 
    {
        return fTypeId;
    }
    public void setfSystemContent(String fSystemContent) 
    {
        this.fSystemContent = fSystemContent;
    }

    public String getfSystemContent() 
    {
        return fSystemContent;
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
    public void setfUpdateTime(Date fUpdateTime) 
    {
        this.fUpdateTime = fUpdateTime;
    }

    public Date getfUpdateTime() 
    {
        return fUpdateTime;
    }
}
