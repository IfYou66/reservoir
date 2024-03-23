package com.szsk.reservoir.fundManage.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 经费支出 对象 sys_fund_expend
 * 
 * @author cangfeng
 * @date 2021-08-18
 */
public class SysFundExpend extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 经费支出表ID */
    @Excel(name = "经费支出表ID")
    private Long fId;

    /** 经费申请名称 */
    @Excel(name = "经费申请名称")
    private String fApplyName;

    /** 申请类别 */
    @Excel(name = "申请类别")
    private Integer fApplyType;

    /** 申请金额 */
    @Excel(name = "申请金额")
    private BigDecimal fApplyMoney;

    /** 批准金额 */
    @Excel(name = "批准金额")
    private BigDecimal fApprovalMoney;

    /** 支出金额 */
    @Excel(name = "支出金额")
    private BigDecimal fExpendMoney;

    /** 结余金额 */
    @Excel(name = "结余金额")
    private BigDecimal fSurplusMoney;

    /** 用途 */
    @Excel(name = "用途")
    private String fPurpose;

    /** 经费清单 */
    @Excel(name = "经费清单")
    private String fFundListing;

    /** 编制人 */
    @Excel(name = "编制人")
    private String fPreparedBy;

    /** 编制时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "编制时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fPreparationTime;

    /** 经费清单附件ID */
    @Excel(name = "经费清单附件ID")
    private Long fExpendFileId;

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

    /** 创建人 */
    @Excel(name = "创建人")
    private Long fCreatePeople;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date fCreateTime;

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

    /**
     * 暂存或提交 1提交 0暂存
     */
    private int holdOrSubmit;

    /**
     * 当前登陆人
     */
    private Long landingPersonId;

    public int getHoldOrSubmit() {
        return holdOrSubmit;
    }

    public void setHoldOrSubmit(int holdOrSubmit) {
        this.holdOrSubmit = holdOrSubmit;
    }

    public Long getLandingPersonId() {
        return landingPersonId;
    }

    public void setLandingPersonId(Long landingPersonId) {
        this.landingPersonId = landingPersonId;
    }

    public void setfId(Long fId)
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfApplyName(String fApplyName) 
    {
        this.fApplyName = fApplyName;
    }

    public String getfApplyName() 
    {
        return fApplyName;
    }
    public void setfApplyType(Integer fApplyType) 
    {
        this.fApplyType = fApplyType;
    }

    public Integer getfApplyType() 
    {
        return fApplyType;
    }
    public void setfApplyMoney(BigDecimal fApplyMoney) 
    {
        this.fApplyMoney = fApplyMoney;
    }

    public BigDecimal getfApplyMoney() 
    {
        return fApplyMoney;
    }
    public void setfApprovalMoney(BigDecimal fApprovalMoney) 
    {
        this.fApprovalMoney = fApprovalMoney;
    }

    public BigDecimal getfApprovalMoney() 
    {
        return fApprovalMoney;
    }
    public void setfExpendMoney(BigDecimal fExpendMoney) 
    {
        this.fExpendMoney = fExpendMoney;
    }

    public BigDecimal getfExpendMoney() 
    {
        return fExpendMoney;
    }
    public void setfSurplusMoney(BigDecimal fSurplusMoney) 
    {
        this.fSurplusMoney = fSurplusMoney;
    }

    public BigDecimal getfSurplusMoney() 
    {
        return fSurplusMoney;
    }
    public void setfPurpose(String fPurpose) 
    {
        this.fPurpose = fPurpose;
    }

    public String getfPurpose() 
    {
        return fPurpose;
    }
    public void setfFundListing(String fFundListing) 
    {
        this.fFundListing = fFundListing;
    }

    public String getfFundListing() 
    {
        return fFundListing;
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
    public void setfExpendFileId(Long fExpendFileId) 
    {
        this.fExpendFileId = fExpendFileId;
    }

    public Long getfExpendFileId() 
    {
        return fExpendFileId;
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
    public void setfCreatePeople(Long fCreatePeople) 
    {
        this.fCreatePeople = fCreatePeople;
    }

    public Long getfCreatePeople() 
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
    public void setfActId(Long fActId) 
    {
        this.fActId = fActId;
    }

    public Long getfActId() 
    {
        return fActId;
    }
    public void setfActPersion(String fActPersion)
    {
        this.fActPersion = fActPersion;
    }

    public String getfActPersion()
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
            .append("fApplyName", getfApplyName())
            .append("fApplyType", getfApplyType())
            .append("fApplyMoney", getfApplyMoney())
            .append("fApprovalMoney", getfApprovalMoney())
            .append("fExpendMoney", getfExpendMoney())
            .append("fSurplusMoney", getfSurplusMoney())
            .append("fPurpose", getfPurpose())
            .append("fFundListing", getfFundListing())
            .append("fPreparedBy", getfPreparedBy())
            .append("fPreparationTime", getfPreparationTime())
            .append("fExpendFileId", getfExpendFileId())
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
            .append("fActId", getfActId())
            .append("fActPersion", getfActPersion())
            .append("fActStatus", getfActStatus())
            .append("fActNode", getfActNode())
            .toString();
    }
}
