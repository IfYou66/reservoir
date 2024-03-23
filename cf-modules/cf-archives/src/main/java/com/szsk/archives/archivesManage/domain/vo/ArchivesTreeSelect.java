package com.szsk.archives.archivesManage.domain.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.szsk.archives.archivesManage.domain.ArchivesType;

import java.io.Serializable;
import java.util.List;
import java.util.stream.Collectors;

/**
 * ArchivesTreeSelect树结构实体类
 *
 * @author ruoyi
 */
public class ArchivesTreeSelect implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 节点ID */
    private Long id;

    /** 节点名称 */
    private String label;

    /** 子节点 */
    @JsonInclude(JsonInclude.Include.NON_EMPTY)
    private List<ArchivesTreeSelect> children;


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

    public List<ArchivesTreeSelect> getChildren() {
        return children;
    }

    public void setChildren(List<ArchivesTreeSelect> children) {
        this.children = children;
    }

    public ArchivesTreeSelect(ArchivesType archivesType)
    {
        this.id = archivesType.getArchivesTypeId();
        this.label = archivesType.getTypeName();
        this.children = archivesType.getArchivesChildren().stream().map(ArchivesTreeSelect::new).collect(Collectors.toList());
    }

}
