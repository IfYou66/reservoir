package com.szsk.reservoir.run.service;

import java.util.List;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.run.domain.RSecuImpl;

/**
 * 安检检查实施 Service接口
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
public interface IRSecuImplService 
{
    /**
     * 查询安检检查实施 
     * 
     * @param fId 安检检查实施 ID
     * @return 安检检查实施 
     */
    public RSecuImpl selectRSecuImplById(Long fId);

    /**
     * 根据计划编制id获取检查实施详情
     * @param fPlaneditId
     * @return
     */
    public AjaxResult selectRSecuImplByfPlaneditId(Long fPlaneditId);

    /**
     * 查询安检检查实施 列表
     * 
     * @param rSecuImpl 安检检查实施 
     * @return 安检检查实施 集合
     */
    public List<RSecuImpl> selectRSecuImplList(RSecuImpl rSecuImpl);

    /**
     * 新增安检检查实施 
     * 
     * @param rSecuImpl 安检检查实施 
     * @return 结果
     */
    public AjaxResult insertRSecuImpl(RSecuImpl rSecuImpl);

    /**
     * 修改安检检查实施 
     * 
     * @param rSecuImpl 安检检查实施 
     * @return 结果
     */
    public AjaxResult updateRSecuImpl(RSecuImpl rSecuImpl);

    /**
     * 批量删除安检检查实施 
     * 
     * @param fIds 需要删除的安检检查实施 ID
     * @return 结果
     */
    public int deleteRSecuImplByIds(Long[] fIds);

    /**
     * 删除安检检查实施 信息
     * 
     * @param fId 安检检查实施 ID
     * @return 结果
     */
    public int deleteRSecuImplById(Long fId);
}
