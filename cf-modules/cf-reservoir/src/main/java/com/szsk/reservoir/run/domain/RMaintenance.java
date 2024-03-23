package com.szsk.reservoir.run.domain;

import java.math.BigDecimal;
import java.util.Date;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 维修养护编制 对象 r_maintenance
 *
 * @author cangfeng
 * @date 2021-08-23
 */
public class RMaintenance extends BaseEntity{

    private static final long serialVersionUID = 1L;

    //实施状态
    private Integer rMainImplStatus;

    //实施id
    private Long rMainImplId;

    public Integer getrMainImplStatus() {
        return rMainImplStatus;
    }

    public void setrMainImplStatus(Integer rMainImplStatus) {
        this.rMainImplStatus = rMainImplStatus;
    }

    public Long getrMainImplId() {
        return rMainImplId;
    }

    public void setrMainImplId(Long rMainImplId) {
        this.rMainImplId = rMainImplId;
    }

    /** id */
    private Integer fId;

    /** 计划名称 */
    @Excel(name = "计划名称")
    private String fPlanName;

    /** 计划类型 */
    @Excel(name = "计划类型")
    private Integer fPlanType;

    /** 预算 */
    @Excel(name = "预算")
    private BigDecimal fBudget;

    /** 计划概述 */
    @Excel(name = "计划概述")
    private String fPlanContent;

    /** 计划附件 */
    @Excel(name = "计划附件")
    private String fPlanId;

    /** 编制人 */
    @Excel(name = "编制人")
    private String fPreparedBy;

    /** 编制时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "编制时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fPreparationTime;

    /** 审核意见 */
    @Excel(name = "审核意见")
    private String fReviewComments;

    /** 审核结果 0:不同意1：同意 */
    @Excel(name = "审核结果 0:不同意1：同意")
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

    /** 创建人 */
    @Excel(name = "创建人")
    private String fCreatePeople;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;

    /** 状态 0:失效1：有效 */
    @Excel(name = "状态 0:失效1：有效")
    private Integer fStatus;

    /** 流程实例id */
    @Excel(name = "流程实例id")
    private Long fActId;

    /** 流程下一节点审核人 */
    @Excel(name = "流程下一节点审核人")
    private Long fActPersion;

    /** 流程状态 流程状态 1:待审核 2：待审批 3：审批完成 4：驳回 */
    @Excel(name = "流程状态 流程状态 1:待审核 2：待审批 3：审批完成 4：驳回")
    private Integer fActStatus;

    /** 流程节点 */
    @Excel(name = "流程节点")
    private String fActNode;

    public void setfId(Integer fId)
    {
        this.fId = fId;
    }

    public Integer getfId()
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
    public void setfPlanType(Integer fPlanType)
    {
        this.fPlanType = fPlanType;
    }

    public Integer getfPlanType()
    {
        return fPlanType;
    }
    public void setfBudget(BigDecimal fBudget)
    {
        this.fBudget = fBudget;
    }

    public BigDecimal getfBudget()
    {
        return fBudget;
    }
    public void setfPlanContent(String fPlanContent)
    {
        this.fPlanContent = fPlanContent;
    }

    public String getfPlanContent()
    {
        return fPlanContent;
    }
    public void setfPlanId(String fPlanId)
    {
        this.fPlanId = fPlanId;
    }

    public String getfPlanId()
    {
        return fPlanId;
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
    public void setfCreatePeople(String fCreatePeople)
    {
        this.fCreatePeople = fCreatePeople;
    }

    public String getfCreatePeople()
    {
        return fCreatePeople;
    }
    public void setfCreateTime(Date fCreateTime)
    {
        this.fCreateTime = fCreateTime;
    }

    public Date getfCreateTime()
    {
        return fCreateTime;
    }
    public void setfStatus(Integer fStatus)
    {
        this.fStatus = fStatus;
    }

    public Integer getfStatus()
    {
        return fStatus;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("fId", getfId())
                .append("fPlanName", getfPlanName())
                .append("fPlanType", getfPlanType())
                .append("fBudget", getfBudget())
                .append("fPlanContent", getfPlanContent())
                .append("fPlanId", getfPlanId())
                .append("fPreparedBy", getfPreparedBy())
                .append("fPreparationTime", getfPreparationTime())
                .append("fReviewComments", getfReviewComments())
                .append("fReviewResult", getfReviewResult())
                .append("fReviewPeople", getfReviewPeople())
                .append("fReviewDate", getfReviewDate())
                .append("fAuditComments", getfAuditComments())
                .append("fAuditResult", getfAuditResult())
                .append("fAuditPeople", getfAuditPeople())
                .append("fAuditDate", getfAuditDate())
                .append("fCreatePeople", getfCreatePeople())
                .append("fCreateTime", getfCreateTime())
                .append("fStatus", getfStatus())
                .append("fActId", getfActId())
                .append("fActPersion", getfActPersion())
                .append("fActStatus", getfActStatus())
                .append("fActNode", getfActNode())
                .toString();
    }

}
