package com.szsk.reservoir.run.domain;

import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 调度指令 对象 r_instruction
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
public class RInstruction extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer fId;

    /** 调度指令名称 */
    @Excel(name = "调度指令名称")
    private String fInstructionName;

    /** 调度指令下达时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "调度指令下达时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fInstructionTime;

    /** 调度指令说明 */
    @Excel(name = "调度指令说明")
    private String fInstructionContent;

    /** 调度单附件 */
    @Excel(name = "调度单附件")
    private String fSchedulingId;

    /** 操作票附件 */
    @Excel(name = "操作票附件")
    private String fOperateId;

    /** 编制人 */
    @Excel(name = "编制人")
    private String fPreparedBy;

    /** 编制时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "编制时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fPreparationTime;

    /** 执行结果 */
    @Excel(name = "执行结果")
    private String fRunResult;

    /** 执行结果附件 */
    @Excel(name = "执行结果附件")
    private String fResultUrl;

    /** 执行结果上报人 */
    @Excel(name = "执行结果上报人")
    private String fReportPersion;

    /** 上报时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "上报时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fReportTime;

    /** 指令执行状态 0:指令接收 1:指令执行2：指令上报 */
    @Excel(name = "指令执行状态 0:指令接收 1:指令执行2：指令上报")
    private Integer fInstructionStatus;

    /** 状态 0:无效1：有效 */
    @Excel(name = "状态 0:无效1：有效")
    private Integer fStatus;

    /** 创建人 */
    @Excel(name = "创建人")
    private String fCreatePeople;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd HH:mm:ss")
    private Date fCreateTime;

    /** 流程实例id */
    @Excel(name = "流程实例id")
    private Long fActId;

    /** 流程下一环节审核人 */
    @Excel(name = "流程下一环节审核人")
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
    
   

    public Integer getfId() {
        return fId;
    }

    public void setfId(Integer fId) {
        this.fId = fId;
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


    public void setfInstructionName(String fInstructionName) 
    {
        this.fInstructionName = fInstructionName;
    }

    public String getfInstructionName() 
    {
        return fInstructionName;
    }
    public void setfInstructionTime(Date fInstructionTime) 
    {
        this.fInstructionTime = fInstructionTime;
    }

    public Date getfInstructionTime() 
    {
        return fInstructionTime;
    }
    public void setfInstructionContent(String fInstructionContent) 
    {
        this.fInstructionContent = fInstructionContent;
    }

    public String getfInstructionContent() 
    {
        return fInstructionContent;
    }
    public void setfSchedulingId(String fSchedulingId) 
    {
        this.fSchedulingId = fSchedulingId;
    }

    public String getfSchedulingId() 
    {
        return fSchedulingId;
    }
    public void setfOperateId(String fOperateId) 
    {
        this.fOperateId = fOperateId;
    }

    public String getfOperateId() 
    {
        return fOperateId;
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
    public void setfRunResult(String fRunResult) 
    {
        this.fRunResult = fRunResult;
    }

    public String getfRunResult() 
    {
        return fRunResult;
    }
    public void setfResultUrl(String fResultUrl) 
    {
        this.fResultUrl = fResultUrl;
    }

    public String getfResultUrl() 
    {
        return fResultUrl;
    }
    public void setfReportPersion(String fReportPersion) 
    {
        this.fReportPersion = fReportPersion;
    }

    public String getfReportPersion() 
    {
        return fReportPersion;
    }
    public void setfReportTime(Date fReportTime) 
    {
        this.fReportTime = fReportTime;
    }

    public Date getfReportTime() 
    {
        return fReportTime;
    }
    public void setfInstructionStatus(Integer fInstructionStatus) 
    {
        this.fInstructionStatus = fInstructionStatus;
    }

    public Integer getfInstructionStatus() 
    {
        return fInstructionStatus;
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
            .append("fInstructionId", getfId())
            .append("fInstructionName", getfInstructionName())
            .append("fInstructionTime", getfInstructionTime())
            .append("fInstructionContent", getfInstructionContent())
            .append("fSchedulingId", getfSchedulingId())
            .append("fOperateId", getfOperateId())
            .append("fPreparedBy", getfPreparedBy())
            .append("fPreparationTime", getfPreparationTime())
            .append("fRunResult", getfRunResult())
            .append("fResultUrl", getfResultUrl())
            .append("fReportPersion", getfReportPersion())
            .append("fReportTime", getfReportTime())
            .append("fInstructionStatus", getfInstructionStatus())
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
