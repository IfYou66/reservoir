package com.szsk.reservoir.run.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 安检检查实施 对象 r_secu_impl
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
public class RSecuImpl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long fId;

    /** 计划编制id */
    @Excel(name = "计划编制id")
    private Long fPlaneditId;

    /** 实施内容 */
    @Excel(name = "实施内容")
    private String fImplContent;

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

    /** 状态 */
    @Excel(name = "状态")
    private Integer fStatus;

    /** 创建人 */
    @Excel(name = "创建人")
    private String fCreatePeople;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;

    /** 流程实例id */
    @Excel(name = "流程实例id")
    private String fActId;

    /** 流程下一节点审核人 */
    @Excel(name = "流程下一节点审核人")
    private String fActPersion;

    /** 流程状态 流程状态 1:待审核 2：待审批 3：审批完成 4：驳回 */
    @Excel(name = "流程状态 流程状态 1:待审核 2：待审批 3：审批完成 4：驳回")
    private Integer fActStatus;

    /**
     * 编制状态
     */
    private Integer editStatus;

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
    

    /**
     * 检查记录集合
     */
    private List<RCheckRecord> recordList;

    /**
     * 事件记录列表
     */
    private List<REventRecord> eventRecordList;

    /**
     * 处置结果列表
     */
    private List<REventProcess> eventProcessList;

    public Integer getEditStatus() {
        return editStatus;
    }

    public void setEditStatus(Integer editStatus) {
        this.editStatus = editStatus;
    }

    public List<REventRecord> getEventRecordList() {
        return eventRecordList;
    }

    public void setEventRecordList(List<REventRecord> eventRecordList) {
        this.eventRecordList = eventRecordList;
    }

    public List<REventProcess> getEventProcessList() {
        return eventProcessList;
    }

    public void setEventProcessList(List<REventProcess> eventProcessList) {
        this.eventProcessList = eventProcessList;
    }

    public List<RCheckRecord> getRecordList() {
        return recordList;
    }

    public void setRecordList(List<RCheckRecord> recordList) {
        this.recordList = recordList;
    }

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
    public void setfPlaneditId(Long fPlaneditId) 
    {
        this.fPlaneditId = fPlaneditId;
    }

    public Long getfPlaneditId() 
    {
        return fPlaneditId;
    }
    public void setfImplContent(String fImplContent) 
    {
        this.fImplContent = fImplContent;
    }

    public String getfImplContent() 
    {
        return fImplContent;
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
    public void setfStatus(Integer fStatus) 
    {
        this.fStatus = fStatus;
    }

    public Integer getfStatus() 
    {
        return fStatus;
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
    public void setfActId(String fActId) 
    {
        this.fActId = fActId;
    }

    public String getfActId() 
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
            .append("fPlaneditId", getfPlaneditId())
            .append("fImplContent", getfImplContent())
            .append("fReviewComments", getfReviewComments())
            .append("fReviewResult", getfReviewResult())
            .append("fReviewPeople", getfReviewPeople())
            .append("fReviewDate", getfReviewDate())
            .append("fStatus", getfStatus())
            .append("fCreatePeople", getfCreatePeople())
            .append("fCreateTime", getfCreateTime())
            .append("fActId", getfActId())
            .append("fActPersion", getfActPersion())
            .append("fActStatus", getfActStatus())
            .append("fActNode", getfActNode())
            .toString();
    }
}
