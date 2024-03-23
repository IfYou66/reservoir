package com.szsk.reservoir.run.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 汛期调度运行计划 对象 r_flood_season
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
public class RFloodSeason extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 汛期调度运行计划ID */
    private Long fId;

    /** 调度计划名称 */
    @Excel(name = "调度计划名称")
    private String fPlanName;

    /** 调度计划文件 */
    private Long fPlanFileId;

    /** 调度计划概要 */
    @Excel(name = "调度计划概要")
    private String fPlanOutline;

    /** 调度计划时间 */
    @Excel(name = "调度计划时间")
    private String fPlanDate;

    /** 录入人 */
    @Excel(name = "录入人")
    private long fCreatePeople;

    /** 录入时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "录入时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;

    private String fPlanDateStart;
    private String fPlanDateEnd;

    public String getfPlanDateStart() {
        return fPlanDateStart;
    }

    public void setfPlanDateStart(String fPlanDateStart) {
        this.fPlanDateStart = fPlanDateStart;
    }

    public String getfPlanDateEnd() {
        return fPlanDateEnd;
    }

    public void setfPlanDateEnd(String fPlanDateEnd) {
        this.fPlanDateEnd = fPlanDateEnd;
    }

    public void setfId(Long fId)
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfPlanName(String fPlanName) 
    {
        this.fPlanName = fPlanName;
    }

    public String getfPlanName() 
    {
        return fPlanName;
    }
    public void setfPlanFileId(Long fPlanFileId) 
    {
        this.fPlanFileId = fPlanFileId;
    }

    public Long getfPlanFileId() 
    {
        return fPlanFileId;
    }
    public void setfPlanOutline(String fPlanOutline) 
    {
        this.fPlanOutline = fPlanOutline;
    }

    public String getfPlanOutline() 
    {
        return fPlanOutline;
    }
    public void setfPlanDate(String fPlanDate) 
    {
        this.fPlanDate = fPlanDate;
    }

    public String getfPlanDate() 
    {
        return fPlanDate;
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
            .append("fPlanName", getfPlanName())
            .append("fPlanFileId", getfPlanFileId())
            .append("fPlanOutline", getfPlanOutline())
            .append("fPlanDate", getfPlanDate())
            .append("fCreatePeople", getfCreatePeople())
            .append("fCreateTime", getfCreateTime())
            .toString();
    }
}
