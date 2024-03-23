package com.szsk.reservoir.manageSystem.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 水库信息对象 sys_reservoir_info
 * 
 * @author cangfeng
 * @date 2021-11-12
 */
public class SysReservoirInfo extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long id;

    /** 名称 水库名称 */
    @Excel(name = "名称 水库名称")
    private String fName;

    /** 说明 */
    @Excel(name = "说明")
    private String fRemark;

    /** 创建人 */
    private Long createId;

    /** 更新人 */
    private Long updatedId;

    /** 更新时间 */
    private Date updatedTime;

    /** 超级管理员ID*/
    private Long fAdminUserId;
    /** 超级管理员用户名*/
    private String  fAdminUserName;
    
    /**权限字符 */
    private String  fReservoirKey;
    
    /** 顶部图片logo f_top_logo_img*/
    private Long fTopLogoImg;
    
    
    
    public Long getfTopLogoImg() {
		return fTopLogoImg;
	}

	public void setfTopLogoImg(Long fTopLogoImg) {
		this.fTopLogoImg = fTopLogoImg;
	}

	public Long getfAdminUserId() {
		return fAdminUserId;
	}

	public void setfAdminUserId(Long fAdminUserId) {
		this.fAdminUserId = fAdminUserId;
	}

	public String getfAdminUserName() {
		return fAdminUserName;
	}

	public void setfAdminUserName(String fAdminUserName) {
		this.fAdminUserName = fAdminUserName;
	}

	public String getfReservoirKey() {
		return fReservoirKey;
	}

	public void setfReservoirKey(String fReservoirKey) {
		this.fReservoirKey = fReservoirKey;
	}

	public void setId(Long id) 
    {
        this.id = id;
    }

    public Long getId() 
    {
        return id;
    }
    public void setfName(String fName) 
    {
        this.fName = fName;
    }

    public String getfName() 
    {
        return fName;
    }
    public void setfRemark(String fRemark) 
    {
        this.fRemark = fRemark;
    }

    public String getfRemark() 
    {
        return fRemark;
    }
    public void setCreateId(Long createId) 
    {
        this.createId = createId;
    }

    public Long getCreateId() 
    {
        return createId;
    }
    public void setUpdatedId(Long updatedId) 
    {
        this.updatedId = updatedId;
    }

    public Long getUpdatedId() 
    {
        return updatedId;
    }
    public void setUpdatedTime(Date updatedTime) 
    {
        this.updatedTime = updatedTime;
    }

    public Date getUpdatedTime() 
    {
        return updatedTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("id", getId())
            .append("fName", getfName())
            .append("fRemark", getfRemark())
            .append("createId", getCreateId())
            .append("createTime", getCreateTime())
            .append("updatedId", getUpdatedId())
            .append("updatedTime", getUpdatedTime())
            .toString();
    }
}
