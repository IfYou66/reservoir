package com.szsk.reservoir.run.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 洪水调度考评 对象 r_flood_regulation_evaluation
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
public class RFloodRegulationEvaluation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 调度考评ID */
    private Long fId;

    /** 调度考评名称 */
    @Excel(name = "调度考评名称")
    private String fEvaluationName;

    /** 调度考评概要 */
    private String fEvaluationOnline;

    /** 调度考评时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "调度考评时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fEvaluationTime;

    /** 调度考评文件ID */
    private Long fEvaluationFileId;

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
    public void setfEvaluationName(String fEvaluationName) 
    {
        this.fEvaluationName = fEvaluationName;
    }

    public String getfEvaluationName() 
    {
        return fEvaluationName;
    }
    public void setfEvaluationOnline(String fEvaluationOnline) 
    {
        this.fEvaluationOnline = fEvaluationOnline;
    }

    public String getfEvaluationOnline() 
    {
        return fEvaluationOnline;
    }
    public void setfEvaluationTime(Date fEvaluationTime) 
    {
        this.fEvaluationTime = fEvaluationTime;
    }

    public Date getfEvaluationTime() 
    {
        return fEvaluationTime;
    }
    public void setfEvaluationFileId(Long fEvaluationFileId) 
    {
        this.fEvaluationFileId = fEvaluationFileId;
    }

    public Long getfEvaluationFileId() 
    {
        return fEvaluationFileId;
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
            .append("fEvaluationName", getfEvaluationName())
            .append("fEvaluationOnline", getfEvaluationOnline())
            .append("fEvaluationTime", getfEvaluationTime())
            .append("fEvaluationFileId", getfEvaluationFileId())
            .append("fCreatePeople", getfCreatePeople())
            .append("fCreateTime", getfCreateTime())
            .toString();
    }
}
