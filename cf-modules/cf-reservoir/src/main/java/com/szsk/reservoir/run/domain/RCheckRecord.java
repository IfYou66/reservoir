package com.szsk.reservoir.run.domain;

import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 安全检查记录 对象 r_check_record
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
public class RCheckRecord extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    @Excel(name = "id")
    private Long fId;

    /** 安全检查实施表id */
    @Excel(name = "安全检查实施表id")
    private String fSecuimpId;

    /** 检查内容 */
    @Excel(name = "检查内容")
    private String fCheckContent;

    /** 检查时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "检查时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fCheckTime;

    /** 检查人 */
    @Excel(name = "检查人")
    private String fCheckPersion;

    /** 图片 */
    @Excel(name = "图片")
    private Long fPhoto;

    /** 状态 0:无效1：有效 */
    @Excel(name = "状态 0:无效1：有效")
    private Integer fStatus;

    private String imageUrl;

    public void setfId(Long fId) 
    {
        this.fId = fId;
    }

    public Long getfId() 
    {
        return fId;
    }
    public void setfSecuimpId(String fSecuimpId) 
    {
        this.fSecuimpId = fSecuimpId;
    }

    public String getfSecuimpId() 
    {
        return fSecuimpId;
    }
    public void setfCheckContent(String fCheckContent) 
    {
        this.fCheckContent = fCheckContent;
    }

    public String getfCheckContent() 
    {
        return fCheckContent;
    }
    public void setfCheckTime(Date fCheckTime) 
    {
        this.fCheckTime = fCheckTime;
    }

    public Date getfCheckTime() 
    {
        return fCheckTime;
    }
    public void setfCheckPersion(String fCheckPersion) 
    {
        this.fCheckPersion = fCheckPersion;
    }

    public String getfCheckPersion() 
    {
        return fCheckPersion;
    }
    public void setfPhoto(Long fPhoto) 
    {
        this.fPhoto = fPhoto;
    }

    public Long getfPhoto() 
    {
        return fPhoto;
    }
    public void setfStatus(Integer fStatus) 
    {
        this.fStatus = fStatus;
    }

    public Integer getfStatus() 
    {
        return fStatus;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("fId", getfId())
            .append("fSecuimpId", getfSecuimpId())
            .append("fCheckContent", getfCheckContent())
            .append("fCheckTime", getfCheckTime())
            .append("fCheckPersion", getfCheckPersion())
            .append("fPhoto", getfPhoto())
            .append("fStatus", getfStatus())
            .toString();
    }
}
