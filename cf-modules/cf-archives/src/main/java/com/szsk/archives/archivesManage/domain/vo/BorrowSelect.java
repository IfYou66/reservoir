package com.szsk.archives.archivesManage.domain.vo;

public class BorrowSelect {

    //档案编号
    private String number;

    //案卷名称
    private String fileName;

    //审核状态
    private Integer status;

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "BorrowSelect{" +
                "number='" + number + '\'' +
                ", fileName='" + fileName + '\'' +
                ", status=" + status +
                '}';
    }
}
