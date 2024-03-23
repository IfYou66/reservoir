package com.szsk.reservoir.manageSystem.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.szsk.reservoir.manageSystem.domain.SysClassType;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ArchivesTreeSelect树结构实体类
 *
 * @author ruoyi
 */
public class SysClassTreeSelect implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<SysClassTreeSelect> children;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    public List<SysClassTreeSelect> getChildren() {
        return children;
    }

    public void setChildren(List<SysClassTreeSelect> children) {
        this.children = children;
    }

    public SysClassTreeSelect(SysClassType sysClassType)
    {
        this.id = sysClassType.getfId();
        this.label = sysClassType.getfTypeName();
        this.children = sysClassType.getSysClassChildren().stream().map(SysClassTreeSelect::new).collect(Collectors.toList());
    }

}
