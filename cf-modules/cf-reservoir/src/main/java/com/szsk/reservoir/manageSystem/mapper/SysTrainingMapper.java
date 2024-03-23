package com.szsk.reservoir.manageSystem.mapper;

import java.util.List;

import com.ruoyi.common.core.domain.SysDictData;
import com.szsk.reservoir.manageSystem.domain.SysTraining;

/**
 * 培训Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-13
 */
public interface SysTrainingMapper 
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
     * 查询培训列表
     * @param sysTraining
     * @return
     */
    public List<SysTraining> search(SysTraining sysTraining);

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
    public int updateSysTraining(SysTraining sysTraining);

    /**
     * 删除培训
     * 
     * @param fId 培训ID
     * @return 结果
     */
    public int deleteSysTrainingById(Long fId);

    /**
     * 批量删除培训
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysTrainingByIds(Long[] fIds);

    /**
     * 查询字典列表
     * @return
     */
    public List<SysDictData> queryDict(String dictType);

}
