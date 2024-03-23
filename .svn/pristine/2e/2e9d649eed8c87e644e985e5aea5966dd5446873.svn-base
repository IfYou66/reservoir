package com.szsk.reservoir.run.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 调度指令执行记录 对象 r_instruction_run_log
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
public class RInstructionRunLog extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Integer fLogId;

    /** 调度指令表ID */
    @Excel(name = "调度指令表ID")
    private Integer fInstructionId;

    /** 执行情况描述 */
    @Excel(name = "执行情况描述")
    private String fRunContent;

    /** 存在问题 */
    @Excel(name = "存在问题")
    private String fProblem;

    /** 问题处置 */
    @Excel(name = "问题处置")
    private String fProblemHandle;

    /** 执行人 */
    @Excel(name = "执行人")
    private String fRunPersion;

    /** 执行时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "执行时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fRunTime;

    /** 结束时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "结束时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fEndTime;

    public void setfLogId(Integer fLogId) 
    {
        this.fLogId = fLogId;
    }

    public Integer getfLogId() 
    {
        return fLogId;
    }
    public void setfInstructionId(Integer fInstructionId) 
    {
        this.fInstructionId = fInstructionId;
    }

    public Integer getfInstructionId() 
    {
        return fInstructionId;
    }
    public void setfRunContent(String fRunContent) 
    {
        this.fRunContent = fRunContent;
    }

    public String getfRunContent() 
    {
        return fRunContent;
    }
    public void setfProblem(String fProblem) 
    {
        this.fProblem = fProblem;
    }

    public String getfProblem() 
    {
        return fProblem;
    }
    public void setfProblemHandle(String fProblemHandle) 
    {
        this.fProblemHandle = fProblemHandle;
    }

    public String getfProblemHandle() 
    {
        return fProblemHandle;
    }
    public void setfRunPersion(String fRunPersion) 
    {
        this.fRunPersion = fRunPersion;
    }

    public String getfRunPersion() 
    {
        return fRunPersion;
    }
    public void setfRunTime(Date fRunTime) 
    {
        this.fRunTime = fRunTime;
    }

    public Date getfRunTime() 
    {
        return fRunTime;
    }
    public void setfEndTime(Date fEndTime) 
    {
        this.fEndTime = fEndTime;
    }

    public Date getfEndTime() 
    {
        return fEndTime;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fLogId", getfLogId())
            .append("fInstructionId", getfInstructionId())
            .append("fRunContent", getfRunContent())
            .append("fProblem", getfProblem())
            .append("fProblemHandle", getfProblemHandle())
            .append("fRunPersion", getfRunPersion())
            .append("fRunTime", getfRunTime())
            .append("fEndTime", getfEndTime())
            .toString();
    }
}
