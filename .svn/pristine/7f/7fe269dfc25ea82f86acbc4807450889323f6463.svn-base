package com.szsk.reservoir.run.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 年度调度总结 对象 r_annual_scheduling
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
public class RAnnualScheduling extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long fId;

    /** 年度调度名称 */
    @Excel(name = "年度调度名称")
    private String fDispatchName;

    /** 年度调度类型 */
    @Excel(name = "年度调度类型")
    private Integer fDispatchType;

    /** 预算 */
    private BigDecimal fBudget;

    /** 年度调度概述 */
    private String fDispatchContent;

    /** 年度调度附件 */
    private String fDispatchId;

    /** 编制人 */
    private String fEditPersion;

    /** 编制时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "编制时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fEditTime;

    /** 审核意见 */
    private String fAuditContent;

    /** 审核结果 0:不同意1：同意 */
    private Integer fAuditResult;

    /** 审核人 */
    private String fAuditPersion;

    /** 审核时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审核时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fAuditTime;

    /** 审批意见 */
    private String fApproveContent;

    /** 审批结果 */
    private Integer fApproveResult;

    /** 审批人 */
    private String fApprovePersion;

    /** 审批时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "审批时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fApproveTime;

    /** 状态 0:失效1：有效 */
    private Integer fStatus;

    /** 流程发起人 */
    private String fStartPersion;

    /** 创建时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "创建时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCreateTime;

    /** 流程实例id */
    private String fActId;

    /** 流程下一节点审核人 */
    private Long fActPersion;

    /** 流程状态 流程状态 1:待审核 2：待审批 3：审批完成 4：驳回 */
    private Integer fActStatus;

    /** 流程节点 */
    private String fActNode;

    /**创建人*/
    private Long fCreateBy;

    @Override
    public String toString() {
        return "RAnnualScheduling{" +
                "fId=" + fId +
                ", fDispatchName='" + fDispatchName + '\'' +
                ", fDispatchType=" + fDispatchType +
                ", fBudget=" + fBudget +
                ", fDispatchContent='" + fDispatchContent + '\'' +
                ", fDispatchId='" + fDispatchId + '\'' +
                ", fEditPersion='" + fEditPersion + '\'' +
                ", fEditTime=" + fEditTime +
                ", fAuditContent='" + fAuditContent + '\'' +
                ", fAuditResult=" + fAuditResult +
                ", fAuditPersion='" + fAuditPersion + '\'' +
                ", fAuditTime=" + fAuditTime +
                ", fApproveContent='" + fApproveContent + '\'' +
                ", fApproveResult=" + fApproveResult +
                ", fApprovePersion='" + fApprovePersion + '\'' +
                ", fApproveTime=" + fApproveTime +
                ", fStatus=" + fStatus +
                ", fStartPersion='" + fStartPersion + '\'' +
                ", fCreateTime=" + fCreateTime +
                ", fActId='" + fActId + '\'' +
                ", fActPersion=" + fActPersion +
                ", fActStatus=" + fActStatus +
                ", fActNode='" + fActNode + '\'' +
                ", fCreateBy=" + fCreateBy +
                '}';
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Long getfCreateBy() {
        return fCreateBy;
    }

    public void setfCreateBy(Long fCreateBy) {
        this.fCreateBy = fCreateBy;
    }

    public void setfId(Long fId)
    {
        this.fId = fId;
    }

    public Long getfId()
    {
        return fId;
    }
    public void setfDispatchName(String fDispatchName) 
    {
        this.fDispatchName = fDispatchName;
    }

    public String getfDispatchName() 
    {
        return fDispatchName;
    }
    public void setfDispatchType(Integer fDispatchType) 
    {
        this.fDispatchType = fDispatchType;
    }

    public Integer getfDispatchType() 
    {
        return fDispatchType;
    }
    public void setfBudget(BigDecimal fBudget) 
    {
        this.fBudget = fBudget;
    }

    public BigDecimal getfBudget() 
    {
        return fBudget;
    }
    public void setfDispatchContent(String fDispatchContent) 
    {
        this.fDispatchContent = fDispatchContent;
    }

    public String getfDispatchContent() 
    {
        return fDispatchContent;
    }
    public void setfDispatchId(String fDispatchId) 
    {
        this.fDispatchId = fDispatchId;
    }

    public String getfDispatchId() 
    {
        return fDispatchId;
    }
    public void setfEditPersion(String fEditPersion) 
    {
        this.fEditPersion = fEditPersion;
    }

    public String getfEditPersion() 
    {
        return fEditPersion;
    }
    public void setfEditTime(Date fEditTime) 
    {
        this.fEditTime = fEditTime;
    }

    public Date getfEditTime() 
    {
        return fEditTime;
    }
    public void setfAuditContent(String fAuditContent) 
    {
        this.fAuditContent = fAuditContent;
    }

    public String getfAuditContent() 
    {
        return fAuditContent;
    }
    public void setfAuditResult(Integer fAuditResult) 
    {
        this.fAuditResult = fAuditResult;
    }

    public Integer getfAuditResult() 
    {
        return fAuditResult;
    }
    public void setfAuditPersion(String fAuditPersion) 
    {
        this.fAuditPersion = fAuditPersion;
    }

    public String getfAuditPersion() 
    {
        return fAuditPersion;
    }
    public void setfAuditTime(Date fAuditTime) 
    {
        this.fAuditTime = fAuditTime;
    }

    public Date getfAuditTime() 
    {
        return fAuditTime;
    }
    public void setfApproveContent(String fApproveContent) 
    {
        this.fApproveContent = fApproveContent;
    }

    public String getfApproveContent() 
    {
        return fApproveContent;
    }
    public void setfApproveResult(Integer fApproveResult) 
    {
        this.fApproveResult = fApproveResult;
    }

    public Integer getfApproveResult() 
    {
        return fApproveResult;
    }
    public void setfApprovePersion(String fApprovePersion) 
    {
        this.fApprovePersion = fApprovePersion;
    }

    public String getfApprovePersion() 
    {
        return fApprovePersion;
    }
    public void setfApproveTime(Date fApproveTime) 
    {
        this.fApproveTime = fApproveTime;
    }

    public Date getfApproveTime() 
    {
        return fApproveTime;
    }
    public void setfStatus(Integer fStatus) 
    {
        this.fStatus = fStatus;
    }

    public Integer getfStatus() 
    {
        return fStatus;
    }
    public void setfStartPersion(String fStartPersion) 
    {
        this.fStartPersion = fStartPersion;
    }

    public String getfStartPersion() 
    {
        return fStartPersion;
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

}
