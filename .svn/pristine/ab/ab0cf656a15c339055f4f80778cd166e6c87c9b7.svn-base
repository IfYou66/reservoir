package com.szsk.archives.archivesManage.mapper;


import com.szsk.archives.archivesManage.domain.ABorrow;

import java.util.List;

public interface ABorrowMapper {


    /**
     * 查询借阅记录
     *
     * @param fBorrowId 借阅记录 ID
     * @return 借阅记录
     */
    public ABorrow selectABorrowById(Long fBorrowId);

    /**
     * 查询借阅记录 列表
     *
     * @param aBorrow 借阅记录
     * @return 借阅记录 集合
     */
    public List<ABorrow> selectABorrowList(ABorrow aBorrow);

    /**
     * 新增借阅记录
     *
     * @param aBorrow 借阅记录
     * @return 结果
     */
    public int insertABorrow(ABorrow aBorrow);

    /**
     * 修改借阅记录
     *
     * @param aBorrow 借阅记录
     * @return 结果
     */
    public int updateABorrow(ABorrow aBorrow);

    /**
     * 删除借阅记录
     *
     * @param fBorrowId 借阅记录 ID
     * @return 结果
     */
    public int deleteABorrowById(Long fBorrowId);

    /**
     * 批量删除借阅记录
     *
     * @param fBorrowIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteABorrowByIds(Long[] fBorrowIds);
}
