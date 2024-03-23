package com.szsk.reservoir.fundManage.mapper;

import java.util.List;
import com.szsk.reservoir.fundManage.domain.SysFundApply;

/**
 * 经费申请 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-18
 */
public interface SysFundApplyMapper 
{
    /**
     * 查询经费申请 
     * 
     * @param fId 经费申请 ID
     * @return 经费申请 
     */
    public SysFundApply selectSysFundApplyById(Long fId);

    /**
     * 查询经费申请 列表
     * 
     * @param sysFundApply 经费申请 
     * @return 经费申请 集合
     */
    public List<SysFundApply> selectSysFundApplyList(SysFundApply sysFundApply);

    /**
     * 查询集合列表
     * @param sysFundApply
     * @return
     */
    public List<SysFundApply> search(SysFundApply sysFundApply);



    /**
     * 新增经费申请 
     * 
     * @param sysFundApply 经费申请 
     * @return 结果
     */
    public int insertSysFundApply(SysFundApply sysFundApply);

    /**
     * 修改经费申请 
     * 
     * @param sysFundApply 经费申请 
     * @return 结果
     */
    public int updateSysFundApply(SysFundApply sysFundApply);

    /**
     * 删除经费申请 
     * 
     * @param fId 经费申请 ID
     * @return 结果
     */
    public int deleteSysFundApplyById(Long fId);

    /**
     * 批量删除经费申请 
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysFundApplyByIds(Long[] fIds);
}
