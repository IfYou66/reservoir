package com.szsk.reservoir.run.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 事件处置对象 r_event_process
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
public class REventProcess extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long fId;

    /** 事件id */
    @Excel(name = "事件id")
    private Long fEventId;

    /** 实施id */
    @Excel(name = "实施id")
    private Long fImplId;

    /** 处置内容 */
    @Excel(name = "处置内容")
    private String fProcessContent;

    /** 处置人 */
    @Excel(name = "处置人")
    private String fProcessPeople;

    /** 处置时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "处置时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fProcessTime;

    /** 处置后图片 */
    @Excel(name = "处置后图片")
    private Long fProcessPhoto;

    private String imageUrl2;

    public void setfId(Long fId) 
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfEventId(Long fEventId) 
    {
        this.fEventId = fEventId;
    }

    public Long getfEventId() 
    {
        return fEventId;
    }
    public void setfImplId(Long fImplId) 
    {
        this.fImplId = fImplId;
    }

    public Long getfImplId() 
    {
        return fImplId;
    }
    public void setfProcessContent(String fProcessContent) 
    {
        this.fProcessContent = fProcessContent;
    }

    public String getfProcessContent() 
    {
        return fProcessContent;
    }
    public void setfProcessPeople(String fProcessPeople)
    {
        this.fProcessPeople = fProcessPeople;
    }

    public String getfProcessPeople()
    {
        return fProcessPeople;
    }
    public void setfProcessTime(Date fProcessTime) 
    {
        this.fProcessTime = fProcessTime;
    }

    public Date getfProcessTime() 
    {
        return fProcessTime;
    }
    public void setfProcessPhoto(Long fProcessPhoto) 
    {
        this.fProcessPhoto = fProcessPhoto;
    }

    public Long getfProcessPhoto() 
    {
        return fProcessPhoto;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getImageUrl2() {
        return imageUrl2;
    }

    public void setImageUrl2(String imageUrl2) {
        this.imageUrl2 = imageUrl2;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fEventId", getfEventId())
            .append("fImplId", getfImplId())
            .append("fProcessContent", getfProcessContent())
            .append("fProcessPeople", getfProcessPeople())
            .append("fProcessTime", getfProcessTime())
            .append("fProcessPhoto", getfProcessPhoto())
            .toString();
    }
}
