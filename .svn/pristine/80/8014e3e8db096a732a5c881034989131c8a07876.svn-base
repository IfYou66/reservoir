package com.szsk.archives.archivesManage.domain;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import com.ruoyi.common.core.annotation.Excel;
import com.ruoyi.common.core.web.domain.TreeEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * 档案分类 对象 a_archives_type
 * 
 * @author cangfeng
 * @date 2021-08-10
 */
public class ArchivesType extends TreeEntity
{
    private static final long serialVersionUID = 1L;

    /** id */
    private Long archivesTypeId;

    /** 分类别名 */
    @Excel(name = "分类别名")
    private String typeName;

    /** 排序 */
    @Excel(name = "排序")
    private Integer sort;

    /** 分类编码 */
    @Excel(name = "分类编码")
    private String code;

    /** 层级 */
    @Excel(name = "层级")
    private Integer level;

    /** 状态 0:无效1：有效 */
    @Excel(name = "状态 0:无效1：有效")
    private Integer status;

    /**
     * 子分类
     */
    private List<ArchivesType> archivesChildren = new ArrayList<ArchivesType>();

    public List<ArchivesType> getArchivesChildren() {
        return archivesChildren;
    }

    public void setArchivesChildren(List<ArchivesType> archivesChildren) {
        this.archivesChildren = archivesChildren;
    }

    public void setArchivesTypeId(Long archivesTypeId)
    {
        this.archivesTypeId = archivesTypeId;
    }

    public Long getArchivesTypeId() 
    {
        return archivesTypeId;
    }
    public void setTypeName(String typeName) 
    {
        this.typeName = typeName;
    }

    public String getTypeName() 
    {
        return typeName;
    }
    public void setSort(Integer sort) 
    {
        this.sort = sort;
    }

    public Integer getSort() 
    {
        return sort;
    }
    public void setCode(String code) 
    {
        this.code = code;
    }

    public String getCode() 
    {
        return code;
    }
    public void setLevel(Integer level) 
    {
        this.level = level;
    }

    public Integer getLevel() 
    {
        return level;
    }
    public void setStatus(Integer status) 
    {
        this.status = status;
    }

    public Integer getStatus() 
    {
        return status;
    }

    @Override
    public String toString() {
        return new ToStringBuilder(this,ToStringStyle.MULTI_LINE_STYLE)
            .append("archivesTypeId", getArchivesTypeId())
            .append("typeName", getTypeName())
            .append("sort", getSort())
            .append("code", getCode())
            .append("parentId", getParentId())
            .append("level", getLevel())
            .append("status", getStatus())
            .toString();
    }
}
