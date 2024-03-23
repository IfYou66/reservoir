package com.szsk.archives.archivesManage.service.Impl;

import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.archives.archivesManage.domain.ABorrow;
import com.szsk.archives.archivesManage.mapper.ABorrowMapper;
import com.szsk.archives.archivesManage.service.IABorrowService;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 借阅记录 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-12
 */
@Service
public class ABorrowServiceImpl implements IABorrowService {


    @Autowired
    private ABorrowMapper aBorrowMapper;

    /**
     * 查询借阅记录
     *
     * @param fBorrowId 借阅记录 ID
     * @return 借阅记录
     */
    @Override
    public ABorrow selectABorrowById(Long fBorrowId)
    {
        return aBorrowMapper.selectABorrowById(fBorrowId);
    }

    /**
     * 查询借阅记录 列表
     *
     * @param aBorrow 借阅记录
     * @return 借阅记录
     */
    @Override
    @Reservoir
    public List<ABorrow> selectABorrowList(ABorrow aBorrow)
    {
        return aBorrowMapper.selectABorrowList(aBorrow);
    }

    /**
     * 新增借阅记录
     *
     * @param aBorrow 借阅记录
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertABorrow(ABorrow aBorrow)
    {
        return aBorrowMapper.insertABorrow(aBorrow);
    }

    /**
     * 修改借阅记录
     *
     * @param aBorrow 借阅记录
     * @return 结果
     */
    @Override
    public int updateABorrow(ABorrow aBorrow)
    {
        return aBorrowMapper.updateABorrow(aBorrow);
    }

    /**
     * 批量删除借阅记录
     *
     * @param fBorrowIds 需要删除的借阅记录 ID
     * @return 结果
     */
    @Override
    public int deleteABorrowByIds(Long[] fBorrowIds)
    {
        return aBorrowMapper.deleteABorrowByIds(fBorrowIds);
    }

    /**
     * 删除借阅记录 信息
     *
     * @param fBorrowId 借阅记录 ID
     * @return 结果
     */
    @Override
    public int deleteABorrowById(Long fBorrowId)
    {
        return aBorrowMapper.deleteABorrowById(fBorrowId);
    }
}
