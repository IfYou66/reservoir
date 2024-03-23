package com.szsk.reservoir.fundManage.service;

import java.util.List;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.fundManage.domain.SysFundApply;

/**
 * 经费申请 Service接口
 * 
 * @author cangfeng
 * @date 2021-08-18
 */
public interface ISysFundApplyService 
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
     * 新增经费申请 
     * 
     * @param sysFundApply 经费申请 
     * @return 结果
     */
    public AjaxResult insertSysFundApply(SysFundApply sysFundApply);

    /**
     * 修改经费申请 
     * 
     * @param sysFundApply 经费申请 
     * @return 结果
     */
    public AjaxResult updateSysFundApply(SysFundApply sysFundApply);

    /**
     * 批量删除经费申请 
     * 
     * @param fIds 需要删除的经费申请 ID
     * @return 结果
     */
    public int deleteSysFundApplyByIds(Long[] fIds);

    /**
     * 删除经费申请 信息
     * 
     * @param fId 经费申请 ID
     * @return 结果
     */
    public int deleteSysFundApplyById(Long fId);

    /**
     * 返回数据字典数据
     * @return
     */
    public AjaxResult inquiry();
}
