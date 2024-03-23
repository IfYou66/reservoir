package com.szsk.reservoir.security.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 水库大坝注销 对象 m_cancellation
 *
 * @author cangfeng
 * @date 2021-08-16
 */
public class MCancellation extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 注销登记ID */
    private Long fId;

    /** 水库名称 */
    @Excel(name = "水库名称")
    private String fReservoirName;

    /** 注册登记号 */
    @Excel(name = "注册登记号")
    private String fCancellationNumber;

    /** 所在地址 */
    @Excel(name = "所在地址")
    private String fAddress;

    /** 坝型（材料划分 */
    @Excel(name = "坝型", readConverterExp = "坝型（材料划分")
    private Integer fDamTypeMaterial;

    /** 坝型（结构划分） */
    @Excel(name = "坝型", readConverterExp = "结=构划分")
    private Integer fDamTypeStructure;

    /** 所在河流 */
    @Excel(name = "所在河流")
    private String fRiver;

    /** 管理单位 */
    @Excel(name = "管理单位")
    private String fManagementUnit;

    /** 最大坝高 */
    @Excel(name = "最大坝高")
    private BigDecimal fMaximumDamHeight;

    /** 总库容 */
    @Excel(name = "总库容")
    private BigDecimal fTotalStorageCapacity;

    /** 开工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "开工日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fStartDate;

    /** 竣工日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "竣工日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCompletionDate;

    /** 废弃原因 */
    @Excel(name = "废弃原因")
    private String fDiscardReason;

    /** 废弃后果与相应原因 */
    @Excel(name = "废弃后果与相应原因")
    private String fReasonRemarks;

    /** 批准文号 */
    @Excel(name = "批准文号")
    private String fApprovalNumber;

    /** 内容摘要 */
    @Excel(name = "内容摘要")
    private String fContentAbstract;

    /** 批准单位 */
    @Excel(name = "批准单位")
    private String fApprovalUnit;

    /** 批准日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "批准日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fApprovalDate;

    /** 注销登记附件ID */
    @Excel(name = "注销登记附件ID")
    private Long fCancellationFileId;

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

    /** 流程状态 0驳回 1待审核 2：待审批 3：审批完成 */
    @Excel(name = "0驳回 1待审核 2：待审批 3：审批完成")
    private Integer fActStatus;

    /** 流程节点 */
    @Excel(name = "流程节点")
    private String fActNode;

    /** 注册登记机构 */
    @Excel(name = "注册登记机构")
    private String fRegistrationMechanism;

    /** 注册登记日期 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "注册登记日期", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fRegistrationDate;

    /** 申报单位 */
    @Excel(name = "申报单位")
    private String fDeclareUnit;

    /** 邮政编码 */
    @Excel(name = "邮政编码")
    private Integer fPostalCode;

    /** 主管部门 */
    @Excel(name = "主管部门")
    private String fCompetentDepartment;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateDate;

    /** 创建人 */
    @Excel(name = "创建人")
    private Long fCreateBy;

    /** 状态 */
    @Excel(name = "状态")
    private Integer fStatus;

    public void setfId(Long fId)
    {
        this.fId = fId;
    }

    public Long getfId()
    {
        return fId;
    }
    public void setfReservoirName(String fReservoirName)
    {
        this.fReservoirName = fReservoirName;
    }

    public String getfReservoirName()
    {
        return fReservoirName;
    }
    public void setfCancellationNumber(String fCancellationNumber)
    {
        this.fCancellationNumber = fCancellationNumber;
    }

    public String getfCancellationNumber()
    {
        return fCancellationNumber;
    }
    public void setfAddress(String fAddress)
    {
        this.fAddress = fAddress;
    }

    public String getfAddress()
    {
        return fAddress;
    }
    public void setfDamTypeMaterial(Integer fDamTypeMaterial)
    {
        this.fDamTypeMaterial = fDamTypeMaterial;
    }

    public Integer getfDamTypeMaterial()
    {
        return fDamTypeMaterial;
    }
    public void setfDamTypeStructure(Integer fDamTypeStructure)
    {
        this.fDamTypeStructure = fDamTypeStructure;
    }

    public Integer getfDamTypeStructure()
    {
        return fDamTypeStructure;
    }
    public void setfRiver(String fRiver)
    {
        this.fRiver = fRiver;
    }

    public String getfRiver()
    {
        return fRiver;
    }
    public void setfManagementUnit(String fManagementUnit)
    {
        this.fManagementUnit = fManagementUnit;
    }

    public String getfManagementUnit()
    {
        return fManagementUnit;
    }
    public void setfMaximumDamHeight(BigDecimal fMaximumDamHeight)
    {
        this.fMaximumDamHeight = fMaximumDamHeight;
    }

    public BigDecimal getfMaximumDamHeight()
    {
        return fMaximumDamHeight;
    }
    public void setfTotalStorageCapacity(BigDecimal fTotalStorageCapacity)
    {
        this.fTotalStorageCapacity = fTotalStorageCapacity;
    }

    public BigDecimal getfTotalStorageCapacity()
    {
        return fTotalStorageCapacity;
    }
    public void setfStartDate(Date fStartDate)
    {
        this.fStartDate = fStartDate;
    }

    public Date getfStartDate()
    {
        return fStartDate;
    }
    public void setfCompletionDate(Date fCompletionDate)
    {
        this.fCompletionDate = fCompletionDate;
    }

    public Date getfCompletionDate()
    {
        return fCompletionDate;
    }
    public void setfDiscardReason(String fDiscardReason)
    {
        this.fDiscardReason = fDiscardReason;
    }

    public String getfDiscardReason()
    {
        return fDiscardReason;
    }
    public void setfReasonRemarks(String fReasonRemarks)
    {
        this.fReasonRemarks = fReasonRemarks;
    }

    public String getfReasonRemarks()
    {
        return fReasonRemarks;
    }
    public void setfApprovalNumber(String fApprovalNumber)
    {
        this.fApprovalNumber = fApprovalNumber;
    }

    public String getfApprovalNumber()
    {
        return fApprovalNumber;
    }
    public void setfContentAbstract(String fContentAbstract)
    {
        this.fContentAbstract = fContentAbstract;
    }

    public String getfContentAbstract()
    {
        return fContentAbstract;
    }
    public void setfApprovalUnit(String fApprovalUnit)
    {
        this.fApprovalUnit = fApprovalUnit;
    }

    public String getfApprovalUnit()
    {
        return fApprovalUnit;
    }
    public void setfApprovalDate(Date fApprovalDate)
    {
        this.fApprovalDate = fApprovalDate;
    }

    public Date getfApprovalDate()
    {
        return fApprovalDate;
    }
    public void setfCancellationFileId(Long fCancellationFileId)
    {
        this.fCancellationFileId = fCancellationFileId;
    }

    public Long getfCancellationFileId()
    {
        return fCancellationFileId;
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
    public void setfActId(Long fActId)
    {
        this.fActId = fActId;
    }

    public Long getfActId()
    {
        return fActId;
    }

    public String getfActPersion() {
        return fActPersion;
    }

    public void setfActPersion(String fActPersion) {
        this.fActPersion = fActPersion;
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
    public void setfRegistrationMechanism(String fRegistrationMechanism)
    {
        this.fRegistrationMechanism = fRegistrationMechanism;
    }

    public String getfRegistrationMechanism()
    {
        return fRegistrationMechanism;
    }
    public void setfRegistrationDate(Date fRegistrationDate)
    {
        this.fRegistrationDate = fRegistrationDate;
    }

    public Date getfRegistrationDate()
    {
        return fRegistrationDate;
    }
    public void setfDeclareUnit(String fDeclareUnit)
    {
        this.fDeclareUnit = fDeclareUnit;
    }

    public String getfDeclareUnit()
    {
        return fDeclareUnit;
    }
    public void setfPostalCode(Integer fPostalCode)
    {
        this.fPostalCode = fPostalCode;
    }

    public Integer getfPostalCode()
    {
        return fPostalCode;
    }
    public void setfCompetentDepartment(String fCompetentDepartment)
    {
        this.fCompetentDepartment = fCompetentDepartment;
    }

    public String getfCompetentDepartment()
    {
        return fCompetentDepartment;
    }
    public void setfCreateDate(Date fCreateDate)
    {
        this.fCreateDate = fCreateDate;
    }

    public Date getfCreateDate()
    {
        return fCreateDate;
    }
    public void setfCreateBy(Long fCreateBy)
    {
        this.fCreateBy = fCreateBy;
    }

    public Long getfCreateBy()
    {
        return fCreateBy;
    }
    public void setfStatus(Integer fStatus)
    {
        this.fStatus = fStatus;
    }

    public Integer getfStatus()
    {
        return fStatus;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("fId", getfId())
                .append("fReservoirName", getfReservoirName())
                .append("fCancellationNumber", getfCancellationNumber())
                .append("fAddress", getfAddress())
                .append("fDamTypeMaterial", getfDamTypeMaterial())
                .append("fDamTypeStructure", getfDamTypeStructure())
                .append("fRiver", getfRiver())
                .append("fManagementUnit", getfManagementUnit())
                .append("fMaximumDamHeight", getfMaximumDamHeight())
                .append("fTotalStorageCapacity", getfTotalStorageCapacity())
                .append("fStartDate", getfStartDate())
                .append("fCompletionDate", getfCompletionDate())
                .append("fDiscardReason", getfDiscardReason())
                .append("fReasonRemarks", getfReasonRemarks())
                .append("fApprovalNumber", getfApprovalNumber())
                .append("fContentAbstract", getfContentAbstract())
                .append("fApprovalUnit", getfApprovalUnit())
                .append("fApprovalDate", getfApprovalDate())
                .append("fCancellationFileId", getfCancellationFileId())
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
                .append("fActId", getfActId())
                .append("fActPersion", getfActPersion())
                .append("fActStatus", getfActStatus())
                .append("fActNode", getfActNode())
                .append("fRegistrationMechanism", getfRegistrationMechanism())
                .append("fRegistrationDate", getfRegistrationDate())
                .append("fDeclareUnit", getfDeclareUnit())
                .append("fPostalCode", getfPostalCode())
                .append("fCompetentDepartment", getfCompetentDepartment())
                .append("fCreateDate", getfCreateDate())
                .append("fCreateBy", getfCreateBy())
                .append("fStatus", getfStatus())
                .toString();
    }
}