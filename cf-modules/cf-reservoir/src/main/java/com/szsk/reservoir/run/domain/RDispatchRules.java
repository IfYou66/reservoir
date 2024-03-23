package com.szsk.reservoir.run.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 水库调度规程 对象 r_dispatch_rules
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
public class RDispatchRules extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 水库调度规程ID */
    private Long fId;

    /** 调度规程名称 */
    @Excel(name = "调度规程名称")
    private String fRulesName;

    /** 调度规程概要 */
    private String fRulesOutline;

    /** 规程时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "规程时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fRulesTime;

    /** 规程文件ID */
    private Long fRulesFileId;

    /** 录入人 */
    @Excel(name = "录入人")
    private long fCreatePeople;

    /** 录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;

    public void setfId(Long fId) 
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfRulesName(String fRulesName) 
    {
        this.fRulesName = fRulesName;
    }

    public String getfRulesName() 
    {
        return fRulesName;
    }
    public void setfRulesOutline(String fRulesOutline) 
    {
        this.fRulesOutline = fRulesOutline;
    }

    public String getfRulesOutline() 
    {
        return fRulesOutline;
    }
    public void setfRulesTime(Date fRulesTime) 
    {
        this.fRulesTime = fRulesTime;
    }

    public Date getfRulesTime() 
    {
        return fRulesTime;
    }
    public void setfRulesFileId(Long fRulesFileId) 
    {
        this.fRulesFileId = fRulesFileId;
    }

    public Long getfRulesFileId() 
    {
        return fRulesFileId;
    }
   
    public long getfCreatePeople() {
		return fCreatePeople;
	}

	public void setfCreatePeople(long fCreatePeople) {
		this.fCreatePeople = fCreatePeople;
	}

	public void setfCreateTime(Date fCreateTime) 
    {
        this.fCreateTime = fCreateTime;
    }

    public Date getfCreateTime() 
    {
        return fCreateTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fRulesName", getfRulesName())
            .append("fRulesOutline", getfRulesOutline())
            .append("fRulesTime", getfRulesTime())
            .append("fRulesFileId", getfRulesFileId())
            .append("fCreatePeople", getfCreatePeople())
            .append("fCreateTime", getfCreateTime())
            .toString();
    }
}
