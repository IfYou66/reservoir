package com.szsk.reservoir.security.domain;

import java.math.BigDecimal;
import java.util.Date;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.BaseEntity;

/**
 * 物资台账信息 对象 m_materials_account_detail
 *
 * @author cangfeng
 * @date 2021-08-20
 */
public class MMaterialsAccountDetail extends BaseEntity
{
    private static final long serialVersionUID = 1L;

    /** 物资台账表ID */
    private Long fId;

    /** 防汛物资表ID */
    @Excel(name = "防汛物资表ID")
    private Long fFloodMaterialsId;

    /** 台账类型 */
    @Excel(name = "台账类型")
    private Integer fAccountType;

    /** 单号 */
    @Excel(name = "单号")
    private String fAccountCode;

    /** 数量 */
    @Excel(name = "数量")
    private BigDecimal fAccountNum;

    /** 单位 */
    @Excel(name = "单位")
    private String fUnit;

    /** 单价 */
    @Excel(name = "单价")
    private BigDecimal fPrice;

    /** 总价 */
    @Excel(name = "总价")
    private BigDecimal fTotalPrice;

    /** 台账时间 */
    @JsonFormat(pattern = "yyyy-MM-dd")
    @Excel(name = "台账时间", width = 30, dateFormat = "yyyy-MM-dd")
    private Date fAccountDate;

    /** 台账人 */
    @Excel(name = "台账人")
    private String fAccountPeople;

    /** 保管人 */
    @Excel(name = "保管人")
    private String fSafekeepingPeople;

    /** 审核人 */
    @Excel(name = "审核人")
    private String fReviewPeople;

    /** 审批人 */
    @Excel(name = "审批人")
    private String fAuditPeople;

    /** 备注 */
    @Excel(name = "备注")
    private String fRemarks;

    /** 流程实例ID */
    @Excel(name = "流程实例ID")
    private Long fActId;

    /** 下一节点审核人 */
    @Excel(name = "下一节点审核人")
    private Long fActPersion;

    /** 流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成 */
    @Excel(name = "流程状态 1已提交启动 2：审核中 3：驳回 4：审核完成")
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
    private Date fCreateDate;

    // 开始结束时间 查询用
    private Date startTime;
    private Date endTime;

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public void setfId(Long fId)
    {
        this.fId = fId;
    }

    public Long getfId()
    {
        return fId;
    }
    public void setfFloodMaterialsId(Long fFloodMaterialsId)
    {
        this.fFloodMaterialsId = fFloodMaterialsId;
    }

    public Long getfFloodMaterialsId()
    {
        return fFloodMaterialsId;
    }
    public void setfAccountType(Integer fAccountType)
    {
        this.fAccountType = fAccountType;
    }

    public Integer getfAccountType()
    {
        return fAccountType;
    }
    public void setfAccountCode(String fAccountCode)
    {
        this.fAccountCode = fAccountCode;
    }

    public String getfAccountCode()
    {
        return fAccountCode;
    }
    public void setfAccountNum(BigDecimal fAccountNum)
    {
        this.fAccountNum = fAccountNum;
    }

    public BigDecimal getfAccountNum()
    {
        return fAccountNum;
    }
    public void setfUnit(String fUnit)
    {
        this.fUnit = fUnit;
    }

    public String getfUnit()
    {
        return fUnit;
    }
    public void setfPrice(BigDecimal fPrice)
    {
        this.fPrice = fPrice;
    }

    public BigDecimal getfPrice()
    {
        return fPrice;
    }
    public void setfTotalPrice(BigDecimal fTotalPrice)
    {
        this.fTotalPrice = fTotalPrice;
    }

    public BigDecimal getfTotalPrice()
    {
        return fTotalPrice;
    }
    public void setfAccountDate(Date fAccountDate)
    {
        this.fAccountDate = fAccountDate;
    }

    public Date getfAccountDate()
    {
        return fAccountDate;
    }
    public void setfAccountPeople(String fAccountPeople)
    {
        this.fAccountPeople = fAccountPeople;
    }

    public String getfAccountPeople()
    {
        return fAccountPeople;
    }
    public void setfSafekeepingPeople(String fSafekeepingPeople)
    {
        this.fSafekeepingPeople = fSafekeepingPeople;
    }

    public String getfSafekeepingPeople()
    {
        return fSafekeepingPeople;
    }
    public void setfReviewPeople(String fReviewPeople)
    {
        this.fReviewPeople = fReviewPeople;
    }

    public String getfReviewPeople()
    {
        return fReviewPeople;
    }
    public void setfAuditPeople(String fAuditPeople)
    {
        this.fAuditPeople = fAuditPeople;
    }

    public String getfAuditPeople()
    {
        return fAuditPeople;
    }
    public void setfRemarks(String fRemarks)
    {
        this.fRemarks = fRemarks;
    }

    public String getfRemarks()
    {
        return fRemarks;
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
    public void setfCreateDate(Date fCreateDate)
    {
        this.fCreateDate = fCreateDate;
    }

    public Date getfCreateDate()
    {
        return fCreateDate;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
                .append("fId", getfId())
                .append("fFloodMaterialsId", getfFloodMaterialsId())
                .append("fAccountType", getfAccountType())
                .append("fAccountCode", getfAccountCode())
                .append("fAccountNum", getfAccountNum())
                .append("fUnit", getfUnit())
                .append("fPrice", getfPrice())
                .append("fTotalPrice", getfTotalPrice())
                .append("fAccountDate", getfAccountDate())
                .append("fAccountPeople", getfAccountPeople())
                .append("fSafekeepingPeople", getfSafekeepingPeople())
                .append("fReviewPeople", getfReviewPeople())
                .append("fAuditPeople", getfAuditPeople())
                .append("fRemarks", getfRemarks())
                .append("fActId", getfActId())
                .append("fActPersion", getfActPersion())
                .append("fActStatus", getfActStatus())
                .append("fActNode", getfActNode())
                .append("fCreateBy", getfCreateBy())
                .append("fCreateDate", getfCreateDate())
                .toString();
    }
}