package com.szsk.reservoir.manageSystem.service;

import java.util.List;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.manageSystem.domain.SysTraining;

/**
 * 培训Service接口
 * 
 * @author cangfeng
 * @date 2021-08-13
 */
public interface ISysTrainingService 
{
    /**
     * 查询培训
     * 
     * @param fId 培训ID
     * @return 培训
     */
    public SysTraining selectSysTrainingById(Long fId);

    /**
     * 查询培训列表
     * 
     * @param sysTraining 培训
     * @return 培训集合
     */
    public List<SysTraining> selectSysTrainingList(SysTraining sysTraining);

    /**
     * 新增培训
     * 
     * @param sysTraining 培训
     * @return 结果
     */
    public int insertSysTraining(SysTraining sysTraining);

    /**
     * 修改培训
     * 
     * @param sysTraining 培训
     * @return 结果
     */
    public AjaxResult updateSysTraining(SysTraining sysTraining);

    /**
     * 批量删除培训
     * 
     * @param fIds 需要删除的培训ID
     * @return 结果
     */
    public int deleteSysTrainingByIds(Long[] fIds);

    /**
     * 删除培训信息
     * 
     * @param fId 培训ID
     * @return 结果
     */
    public int deleteSysTrainingById(Long fId);

    /**
     * 初始化档案接收表格数据
     * @return
     */
    public AjaxResult queryDataDictionary();

    /**
     * 根据类型查询数据字典
     * @param dictType
     * @return
     */
    public AjaxResult dataQuery(String dictType);


}