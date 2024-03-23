package com.szsk.reservoir.risk.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 险情管理 对象 m_risk_management
 *
 * @author cangfeng
 * @date 2021-08-19
 */
public class MRiskManagement extends BaseEntity{
    private static final long serialVersionUID = 1L;

    /** 险情管理ID */
    private Long fId;

    /** 险情名称 */
    @Excel(name = "险情名称")
    private String fRiskName;

    /** 险情类别 */
    @Excel(name = "险情类别")
    private Integer fRiskType;

    /** 险情编号 */
    @Excel(name = "险情编号")
    private String fRiskNumber;

    /** 险情发现时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "险情发现时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fRiskFindDate;

    /** 险情概述 */
    @Excel(name = "险情概述")
    private String fRiskSummary;

    /** 记录人 */
    @Excel(name = "记录人")
    private String fRecordPeople;

    /** 记录时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "记录时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fRecordDate;

    /** 险情信息附件ID */
    @Excel(name = "险情信息附件ID")
    private Long fRiskInfoFileId;

    /** 响应情况 */
    @Excel(name = "响应情况")
    private String fResponseSituation;

    /** 响应人 */
    @Excel(name = "响应人")
    private String fResponsePeople;

    /** 响应时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "响应时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fResponseDate;

    /** 响应信息附件ID */
    @Excel(name = "响应信息附件ID")
    private Long fResponseInfoFileId;

    /** 处置结果 */
    @Excel(name = "处置结果")
    private String fDisposalResults;

    /** 处置人 */
    @Excel(name = "处置人")
    private String fDisposalPeople;

    /** 处置时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处置时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fDisposalDate;

    /** 处置信息附件ID */
    @Excel(name = "处置信息附件ID")
    private Long fDisposalInfoFileId;

    /** 检查意见 */
    @Excel(name = "检查意见")
    private String fInspectionOpinions;

    /** 检查结果 */
    @Excel(name = "检查结果")
    private Integer fInspectionResults;

    /** 检查人 */
    @Excel(name = "检查人")
    private String fInspectionPeople;

    /** 检查时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fInspectionDate;

    /** 流程实例ID */
    @Excel(name = "流程实例ID")
    private Long fActId;

    /** 下一节点审核人 */
    @Excel(name = "下一节点审核人")
    private Long fActPersion;

    /** 流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成 */
    @Excel(name = "流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成")
    private Integer fActStatus;

    /** 流程节点 */
    @Excel(name = "流程节点")
    private String fActNode;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long fCreateBy;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;

    public void setfId(Long fId)
    {
        this.fId = fId;
    }

    public Long getfId()
    {
        return fId;
    }
    public void setfRiskName(String fRiskName)
    {
        this.fRiskName = fRiskName;
    }

    public String getfRiskName()
    {
        return fRiskName;
    }
    public void setfRiskType(Integer fRiskType)
    {
        this.fRiskType = fRiskType;
    }

    public Integer getfRiskType()
    {
        return fRiskType;
    }
    public void setfRiskNumber(String fRiskNumber)
    {
        this.fRiskNumber = fRiskNumber;
    }

    public String getfRiskNumber()
    {
        return fRiskNumber;
    }
    public void setfRiskFindDate(Date fRiskFindDate)
    {
        this.fRiskFindDate = fRiskFindDate;
    }

    public Date getfRiskFindDate()
    {
        return fRiskFindDate;
    }
    public void setfRiskSummary(String fRiskSummary)
    {
        this.fRiskSummary = fRiskSummary;
    }

    public String getfRiskSummary()
    {
        return fRiskSummary;
    }
    public void setfRecordPeople(String fRecordPeople)
    {
        this.fRecordPeople = fRecordPeople;
    }

    public String getfRecordPeople()
    {
        return fRecordPeople;
    }
    public void setfRecordDate(Date fRecordDate)
    {
        this.fRecordDate = fRecordDate;
    }

    public Date getfRecordDate()
    {
        return fRecordDate;
    }
    public void setfRiskInfoFileId(Long fRiskInfoFileId)
    {
        this.fRiskInfoFileId = fRiskInfoFileId;
    }

    public Long getfRiskInfoFileId()
    {
        return fRiskInfoFileId;
    }
    public void setfResponseSituation(String fResponseSituation)
    {
        this.fResponseSituation = fResponseSituation;
    }

    public String getfResponseSituation()
    {
        return fResponseSituation;
    }
    public void setfResponsePeople(String fResponsePeople)
    {
        this.fResponsePeople = fResponsePeople;
    }

    public String getfResponsePeople()
    {
        return fResponsePeople;
    }
    public void setfResponseDate(Date fResponseDate)
    {
        this.fResponseDate = fResponseDate;
    }

    public Date getfResponseDate()
    {
        return fResponseDate;
    }
    public void setfResponseInfoFileId(Long fResponseInfoFileId)
    {
        this.fResponseInfoFileId = fResponseInfoFileId;
    }

    public Long getfResponseInfoFileId()
    {
        return fResponseInfoFileId;
    }
    public void setfDisposalResults(String fDisposalResults)
    {
        this.fDisposalResults = fDisposalResults;
    }

    public String getfDisposalResults()
    {
        return fDisposalResults;
    }
    public void setfDisposalPeople(String fDisposalPeople)
    {
        this.fDisposalPeople = fDisposalPeople;
    }

    public String getfDisposalPeople()
    {
        return fDisposalPeople;
    }
    public void setfDisposalDate(Date fDisposalDate)
    {
        this.fDisposalDate = fDisposalDate;
    }

    public Date getfDisposalDate()
    {
        return fDisposalDate;
    }
    public void setfDisposalInfoFileId(Long fDisposalInfoFileId)
    {
        this.fDisposalInfoFileId = fDisposalInfoFileId;
    }

    public Long getfDisposalInfoFileId()
    {
        return fDisposalInfoFileId;
    }
    public void setfInspectionOpinions(String fInspectionOpinions)
    {
        this.fInspectionOpinions = fInspectionOpinions;
    }

    public String getfInspectionOpinions()
    {
        return fInspectionOpinions;
    }
    public void setfInspectionResults(Integer fInspectionResults)
    {
        this.fInspectionResults = fInspectionResults;
    }

    public Integer getfInspectionResults()
    {
        return fInspectionResults;
    }
    public void setfInspectionPeople(String fInspectionPeople)
    {
        this.fInspectionPeople = fInspectionPeople;
    }

    public String getfInspectionPeople()
    {
        return fInspectionPeople;
    }
    public void setfInspectionDate(Date fInspectionDate)
    {
        this.fInspectionDate = fInspectionDate;
    }

    public Date getfInspectionDate()
    {
        return fInspectionDate;
    }
    public void setfActId(Long fActId)
    {
        this.fActId = fActId;
    }

    public Long getfActId()
    {
        return fActId;
    }
    public void setfActPersion(Long fActPersion)
    {
        this.fActPersion = fActPersion;
    }

    public Long getfActPersion()
    {
        return fActPersion;
    }
    public void setfActStatus(Integer fActStatus)
    {
        this.fActStatus = fActStatus;
    }

    public Integer getfActStatus()
    {
        return fActStatus;
    }
    public void setfActNode(String fActNode)
    {
        this.fActNode = fActNode;
    }

    public String getfActNode()
    {
        return fActNode;
    }
    public void setfCreateBy(Long fCreateBy)
    {
        this.fCreateBy = fCreateBy;
    }

    public Long getfCreateBy()
    {
        return fCreateBy;
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
                .append("fRiskName", getfRiskName())
                .append("fRiskType", getfRiskType())
                .append("fRiskNumber", getfRiskNumber())
                .append("fRiskFindDate", getfRiskFindDate())
                .append("fRiskSummary", getfRiskSummary())
                .append("fRecordPeople", getfRecordPeople())
                .append("fRecordDate", getfRecordDate())
                .append("fRiskInfoFileId", getfRiskInfoFileId())
                .append("fResponseSituation", getfResponseSituation())
                .append("fResponsePeople", getfResponsePeople())
                .append("fResponseDate", getfResponseDate())
                .append("fResponseInfoFileId", getfResponseInfoFileId())
                .append("fDisposalResults", getfDisposalResults())
                .append("fDisposalPeople", getfDisposalPeople())
                .append("fDisposalDate", getfDisposalDate())
                .append("fDisposalInfoFileId", getfDisposalInfoFileId())
                .append("fInspectionOpinions", getfInspectionOpinions())
                .append("fInspectionResults", getfInspectionResults())
                .append("fInspectionPeople", getfInspectionPeople())
                .append("fInspectionDate", getfInspectionDate())
                .append("fActId", getfActId())
                .append("fActPersion", getfActPersion())
                .append("fActStatus", getfActStatus())
                .append("fActNode", getfActNode())
                .append("fCreateBy", getfCreateBy())
                .append("fCreateTime", getfCreateTime())
                .toString();
    }
}
