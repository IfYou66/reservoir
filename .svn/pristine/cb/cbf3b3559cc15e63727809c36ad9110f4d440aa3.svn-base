package com.szsk.reservoir.emergency.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 水库预案编制 对象 m_emergency_planning
 *
 * @author cangfeng
 * @date 2021-08-18
 */ 
public class MEmergencyPlanning  extends BaseEntity {
    private static final long serialVersionUID = 1L;

    /** 预案编制ID */
    private Long fId;
    /**  */ 
    @Excel(name = "预案分类 水库大坝管理运行预案、水库防汛抢险应急预案、水库防御洪水预案、其他预案")
    private Integer fPlanType;
    /** 预案名称 */
    @Excel(name = "预案名称")
    private String fPlanName;

    /** 预案编号 */
    @Excel(name = "预案编号")
    private String fPlanNumber;

    /** 发布开始时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布开始时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fPublishStartDate;

    /** 发布结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fPublishEndDate;

    /** 预案概述 */
    @Excel(name = "预案概述")
    private String fPlanSummary;

    /** 编制时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "编制时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fPreparationTime;

    /** 编制人 */
    @Excel(name = "编制人")
    private String fPreparedBy;

    /** 预案文件ID */
    @Excel(name = "预案文件ID")
    private Long fPlanFileId;

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
    /** 审批文件ID */
    @Excel(name = "审批文件ID")
    private Long fAuditFileId;
    /** 发布内容 */
    @Excel(name = "发布内容")
    private String fPublishContent;

    /** 发布人 */
    @Excel(name = "发布人")
    private String fPublishPeople;

    /** 发布确认时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "发布确认时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fPublishConfirmDate;
    
    
    /** 演练概要 */
    @Excel(name = "演练概要")
    private String fDrillOutline;
    /** 演练文件ID */
    @Excel(name = "演练文件ID")
    private Long fDrillFileId;
    /** 演练记录人 */
    @Excel(name = "演练记录人")
    private String fDrillPeople;
    /** 演练时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "演练时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fDrillDate;
    
    /** 执行启动记录 */
    @Excel(name = "执行启动记录")
    private String fExecutiveStartRecord;
    /** 执行过程*/
    @Excel(name = "执行过程")
    private String fExecutiveProcessRecord;
    /** 执行终止记录*/
    @Excel(name = "执行终止记录")
    private String fExecutiveEndRecord;
    /** 执行文件ID*/
    @Excel(name = "执行文件ID")
    private Long fExecutiveFileId;
    /** 执行记录人 */
    @Excel(name = "执行记录人")
    private String fExecutivePeople;
    /** 执行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "执行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fExecutiveDate;
    
    

    /** 流程实例ID */
    @Excel(name = "流程实例ID")
    private Long fActId;

    /** 下一节点审核人 */
    @Excel(name = "下一节点审核人")
    private Long fActPersion;

    /** 流程状态 1已提交启动 2：批准中 3：发布 4：发布完成 5：驳回 6：不同意删除 */
    @Excel(name = "流程状态 1已提交启动 2：批准中 3：发布 4：发布完成 5：驳回 6：不同意删除")
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
    public void setfPlanName(String fPlanName)
    {
        this.fPlanName = fPlanName;
    }

    public String getfPlanName()
    {
        return fPlanName;
    }
    public void setfPlanNumber(String fPlanNumber)
    {
        this.fPlanNumber = fPlanNumber;
    }

    public String getfPlanNumber()
    {
        return fPlanNumber;
    }
    public void setfPublishStartDate(Date fPublishStartDate)
    {
        this.fPublishStartDate = fPublishStartDate;
    }

    public Date getfPublishStartDate()
    {
        return fPublishStartDate;
    }
    public void setfPublishEndDate(Date fPublishEndDate)
    {
        this.fPublishEndDate = fPublishEndDate;
    }

    public Date getfPublishEndDate()
    {
        return fPublishEndDate;
    }
    public void setfPlanSummary(String fPlanSummary)
    {
        this.fPlanSummary = fPlanSummary;
    }

    public String getfPlanSummary()
    {
        return fPlanSummary;
    }
    public void setfPreparationTime(Date fPreparationTime)
    {
        this.fPreparationTime = fPreparationTime;
    }

    public Date getfPreparationTime()
    {
        return fPreparationTime;
    }
    public void setfPreparedBy(String fPreparedBy)
    {
        this.fPreparedBy = fPreparedBy;
    }

    public String getfPreparedBy()
    {
        return fPreparedBy;
    }
    public void setfPlanFileId(Long fPlanFileId)
    {
        this.fPlanFileId = fPlanFileId;
    }

    public Long getfPlanFileId()
    {
        return fPlanFileId;
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
    public void setfPublishContent(String fPublishContent)
    {
        this.fPublishContent = fPublishContent;
    }

    public String getfPublishContent()
    {
        return fPublishContent;
    }
    public void setfPublishPeople(String fPublishPeople)
    {
        this.fPublishPeople = fPublishPeople;
    }

    public String getfPublishPeople()
    {
        return fPublishPeople;
    }
    public void setfPublishConfirmDate(Date fPublishConfirmDate)
    {
        this.fPublishConfirmDate = fPublishConfirmDate;
    }

    public Date getfPublishConfirmDate()
    {
        return fPublishConfirmDate;
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

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getfPlanType() {
        return fPlanType;
    }

    public void setfPlanType(Integer fPlanType) {
        this.fPlanType = fPlanType;
    }

    public Long getfAuditFileId() {
        return fAuditFileId;
    }

    public void setfAuditFileId(Long fAuditFileId) {
        this.fAuditFileId = fAuditFileId;
    }

    public String getfDrillOutline() {
        return fDrillOutline;
    }

    public void setfDrillOutline(String fDrillOutline) {
        this.fDrillOutline = fDrillOutline;
    }

    public Long getfDrillFileId() {
        return fDrillFileId;
    }

    public void setfDrillFileId(Long fDrillFileId) {
        this.fDrillFileId = fDrillFileId;
    }

    public String getfDrillPeople() {
        return fDrillPeople;
    }

    public void setfDrillPeople(String fDrillPeople) {
        this.fDrillPeople = fDrillPeople;
    }

    public Date getfDrillDate() {
        return fDrillDate;
    }

    public void setfDrillDate(Date fDrillDate) {
        this.fDrillDate = fDrillDate;
    }

    public String getfExecutiveStartRecord() {
        return fExecutiveStartRecord;
    }

    public void setfExecutiveStartRecord(String fExecutiveStartRecord) {
        this.fExecutiveStartRecord = fExecutiveStartRecord;
    }

    public String getfExecutiveProcessRecord() {
        return fExecutiveProcessRecord;
    }

    public void setfExecutiveProcessRecord(String fExecutiveProcessRecord) {
        this.fExecutiveProcessRecord = fExecutiveProcessRecord;
    }

    public String getfExecutiveEndRecord() {
        return fExecutiveEndRecord;
    }

    public void setfExecutiveEndRecord(String fExecutiveEndRecord) {
        this.fExecutiveEndRecord = fExecutiveEndRecord;
    }

    public Long getfExecutiveFileId() {
        return fExecutiveFileId;
    }

    public void setfExecutiveFileId(Long fExecutiveFileId) {
        this.fExecutiveFileId = fExecutiveFileId;
    }

    public String getfExecutivePeople() {
        return fExecutivePeople;
    }

    public void setfExecutivePeople(String fExecutivePeople) {
        this.fExecutivePeople = fExecutivePeople;
    }

    public Date getfExecutiveDate() {
        return fExecutiveDate;
    }

    public void setfExecutiveDate(Date fExecutiveDate) {
        this.fExecutiveDate = fExecutiveDate;
    }

    @Override
    public String toString() {
        return "MEmergencyPlanning{" +
                "fId=" + fId +
                ", fPlanType=" + fPlanType +
                ", fPlanName='" + fPlanName + '\'' +
                ", fPlanNumber='" + fPlanNumber + '\'' +
                ", fPublishStartDate=" + fPublishStartDate +
                ", fPublishEndDate=" + fPublishEndDate +
                ", fPlanSummary='" + fPlanSummary + '\'' +
                ", fPreparationTime=" + fPreparationTime +
                ", fPreparedBy='" + fPreparedBy + '\'' +
                ", fPlanFileId=" + fPlanFileId +
                ", fReviewComments='" + fReviewComments + '\'' +
                ", fReviewResult=" + fReviewResult +
                ", fReviewPeople='" + fReviewPeople + '\'' +
                ", fReviewDate=" + fReviewDate +
                ", fAuditComments='" + fAuditComments + '\'' +
                ", fAuditResult=" + fAuditResult +
                ", fAuditPeople='" + fAuditPeople + '\'' +
                ", fAuditDate=" + fAuditDate +
                ", fAuditFileId=" + fAuditFileId +
                ", fPublishContent='" + fPublishContent + '\'' +
                ", fPublishPeople='" + fPublishPeople + '\'' +
                ", fPublishConfirmDate=" + fPublishConfirmDate +
                ", fDrillOutline='" + fDrillOutline + '\'' +
                ", fDrillFileId=" + fDrillFileId +
                ", fDrillPeople='" + fDrillPeople + '\'' +
                ", fDrillDate=" + fDrillDate +
                ", fExecutiveStartRecord='" + fExecutiveStartRecord + '\'' +
                ", fExecutiveProcessRecord='" + fExecutiveProcessRecord + '\'' +
                ", fExecutiveEndRecord='" + fExecutiveEndRecord + '\'' +
                ", fExecutiveFileId=" + fExecutiveFileId +
                ", fExecutivePeople='" + fExecutivePeople + '\'' +
                ", fExecutiveDate=" + fExecutiveDate +
                ", fActId=" + fActId +
                ", fActPersion=" + fActPersion +
                ", fActStatus=" + fActStatus +
                ", fActNode='" + fActNode + '\'' +
                ", fCreateBy=" + fCreateBy +
                ", fCreateTime=" + fCreateTime +
                '}';
    }
}
