package com.szsk.reservoir.run.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 控制运行计划实施对象 r_control_impl
 * 
 * @author cangfeng
 * @date 2021-08-26
 */
public class RControlImpl extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long fId;

    /** 计划编制id */
    @Excel(name = "计划编制id")
    private Long fPreparedId;

    /** 实施内容 */
    @Excel(name = "实施内容")
    private String fImplContent;

    /** 实施内容附件id */
    @Excel(name = "实施内容附件id")
    private Long fImplId;

    /** 实施人 */
    @Excel(name = "实施人")
    private String fImplPeople;

    /** 实施时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "实施时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fImplTime;

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

    /** 状态 1准备 2实施 3已实施 */
    @Excel(name = "状态" )
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
    private Long fActId;

    /** 流程下一节点审核人 */
    @Excel(name = "流程下一节点审核人")
    private String fActPersion;

    /** 流程状态 流程状态 1:待审核 2：待审批 3：审批完成 4：驳回 */
    @Excel(name = "流程状态 流程状态 1:待审核 2：待审批 3：审批完成 4：驳回")
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
    public void setfPreparedId(Long fPreparedId) 
    {
        this.fPreparedId = fPreparedId;
    }

    public Long getfPreparedId() 
    {
        return fPreparedId;
    }
    public void setfImplContent(String fImplContent) 
    {
        this.fImplContent = fImplContent;
    }

    public String getfImplContent() 
    {
        return fImplContent;
    }
    public void setfImplId(Long fImplId) 
    {
        this.fImplId = fImplId;
    }

    public Long getfImplId() 
    {
        return fImplId;
    }
    public void setfImplPeople(String fImplPeople) 
    {
        this.fImplPeople = fImplPeople;
    }

    public String getfImplPeople() 
    {
        return fImplPeople;
    }
    public void setfImplTime(Date fImplTime) 
    {
        this.fImplTime = fImplTime;
    }

    public Date getfImplTime() 
    {
        return fImplTime;
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

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fPreparedId", getfPreparedId())
            .append("fImplContent", getfImplContent())
            .append("fImplId", getfImplId())
            .append("fImplPeople", getfImplPeople())
            .append("fImplTime", getfImplTime())
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
