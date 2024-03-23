package com.szsk.reservoir.security.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 水库大坝安全鉴定一览 对象 m_safety_appraisal
 * 
 * @author cangfeng
 * @date 2021-08-17
 */
public class MSafetyAppraisal extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 安全鉴定表ID */
    private Long fId;

    /** 鉴定名称 */
    @Excel(name = "鉴定名称")
    private String fAppraisalName;

    /** 鉴定完成时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "鉴定完成时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fAppraisalFinishDate;

    /** 鉴定结论 */
    @Excel(name = "鉴定结论")
    private String fAppraisalResult;

    /** 编制人 */
    @Excel(name = "编制人")
    private String fPreparedBy;

    /** 编制时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "编制时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fPreparationTime;

    /** 结论附件ID */
    @Excel(name = "结论附件ID")
    private Long fResultFileId;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String fReviewComments;

    /** 审核结果 */
    @Excel(name = "审核结果")
    private Integer fReviewResult;

    /** 审核人 */
    @Excel(name = "审核人")
    private String fReviewPeople;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fReviewDate;

    /** 审批意见 */
    @Excel(name = "审批意见")
    private String fAuditComments;

    /** 审批结果 */
    @Excel(name = "审批结果")
    private Integer fAuditResult;

    /** 审批人 */
    @Excel(name = "审批人")
    private String fAuditPeople;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fAuditDate;

    /** 流程实例ID */
    @Excel(name = "流程实例ID")
    private Long fActId;

    /** 下一节点审核人 */
    @Excel(name = "下一节点审核人")
    private String fActPersion;

    /** 流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成 */
    @Excel(name = "流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成")
    private Integer fActStatus;

    /** 流程节点 */
    @Excel(name = "流程节点")
    private String fActNode;

    public void setfId(Long fId) 
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfAppraisalName(String fAppraisalName) 
    {
        this.fAppraisalName = fAppraisalName;
    }

    public String getfAppraisalName() 
    {
        return fAppraisalName;
    }
    public void setfAppraisalFinishDate(Date fAppraisalFinishDate) 
    {
        this.fAppraisalFinishDate = fAppraisalFinishDate;
    }

    public Date getfAppraisalFinishDate() 
    {
        return fAppraisalFinishDate;
    }
    public void setfAppraisalResult(String fAppraisalResult) 
    {
        this.fAppraisalResult = fAppraisalResult;
    }

    public String getfAppraisalResult() 
    {
        return fAppraisalResult;
    }
    public void setfPreparedBy(String fPreparedBy) 
    {
        this.fPreparedBy = fPreparedBy;
    }

    public String getfPreparedBy() 
    {
        return fPreparedBy;
    }
    public void setfPreparationTime(Date fPreparationTime) 
    {
        this.fPreparationTime = fPreparationTime;
    }

    public Date getfPreparationTime() 
    {
        return fPreparationTime;
    }
    public void setfResultFileId(Long fResultFileId) 
    {
        this.fResultFileId = fResultFileId;
    }

    public Long getfResultFileId() 
    {
        return fResultFileId;
    }
    public void setfReviewComments(String fReviewComments) 
    {
        this.fReviewComments = fReviewComments;
    }

    public String getfReviewComments() 
    {
        return fReviewComments;
    }
    public void setfReviewResult(Integer fReviewResult) 
    {
        this.fReviewResult = fReviewResult;
    }

    public Integer getfReviewResult() 
    {
        return fReviewResult;
    }
    public void setfReviewPeople(String fReviewPeople) 
    {
        this.fReviewPeople = fReviewPeople;
    }

    public String getfReviewPeople() 
    {
        return fReviewPeople;
    }
    public void setfReviewDate(Date fReviewDate) 
    {
        this.fReviewDate = fReviewDate;
    }

    public Date getfReviewDate() 
    {
        return fReviewDate;
    }
    public void setfAuditComments(String fAuditComments) 
    {
        this.fAuditComments = fAuditComments;
    }

    public String getfAuditComments() 
    {
        return fAuditComments;
    }
    public void setfAuditResult(Integer fAuditResult) 
    {
        this.fAuditResult = fAuditResult;
    }

    public Integer getfAuditResult() 
    {
        return fAuditResult;
    }
    public void setfAuditPeople(String fAuditPeople) 
    {
        this.fAuditPeople = fAuditPeople;
    }

    public String getfAuditPeople() 
    {
        return fAuditPeople;
    }
    public void setfAuditDate(Date fAuditDate) 
    {
        this.fAuditDate = fAuditDate;
    }

    public Date getfAuditDate() 
    {
        return fAuditDate;
    }
    public void setfActId(Long fActId) 
    {
        this.fActId = fActId;
    }

    public Long getfActId() 
    {
        return fActId;
    }
    public void setfActStatus(Integer fActStatus)
    {
        this.fActStatus = fActStatus;
    }

    public String getfActPersion() {
        return fActPersion;
    }

    public void setfActPersion(String fActPersion) {
        this.fActPersion = fActPersion;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fAppraisalName", getfAppraisalName())
            .append("fAppraisalFinishDate", getfAppraisalFinishDate())
            .append("fAppraisalResult", getfAppraisalResult())
            .append("fPreparedBy", getfPreparedBy())
            .append("fPreparationTime", getfPreparationTime())
            .append("fResultFileId", getfResultFileId())
            .append("fReviewComments", getfReviewComments())
            .append("fReviewResult", getfReviewResult())
            .append("fReviewPeople", getfReviewPeople())
            .append("fReviewDate", getfReviewDate())
            .append("fAuditComments", getfAuditComments())
            .append("fAuditResult", getfAuditResult())
            .append("fAuditPeople", getfAuditPeople())
            .append("fAuditDate", getfAuditDate())
            .append("fActId", getfActId())
            .append("fActPersion", getfActPersion())
            .append("fActStatus", getfActStatus())
            .append("fActNode", getfActNode())
            .toString();
    }
}
