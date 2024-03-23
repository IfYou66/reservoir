package com.szsk.reservoir.manageSystem.mapper;

import java.util.List;
import com.szsk.reservoir.manageSystem.domain.SysJoinTraining;

/**
 * 参加培训人员Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-13
 */
public interface SysJoinTrainingMapper 
{
    /**
     * 查询参加培训人员
     * 
     * @param fId 参加培训人员ID
     * @return 参加培训人员
     */
    public SysJoinTraining selectSysJoinTrainingById(Long fId);

    /**
     * 查询参加培训人员列表
     * 
     * @param sysJoinTraining 参加培训人员
     * @return 参加培训人员集合
     */
    public List<SysJoinTraining> selectSysJoinTrainingList(SysJoinTraining sysJoinTraining);

    /**
     * 批量添加培训人员
     * @param sysJoinTrainings
     * @return
     */
    public int bulkInsert(List<SysJoinTraining> sysJoinTrainings);

    /**
     * 新增参加培训人员
     * 
     * @param sysJoinTraining 参加培训人员
     * @return 结果
     */
    public int insertSysJoinTraining(SysJoinTraining sysJoinTraining);

    /**
     * 修改参加培训人员
     * 
     * @param sysJoinTraining 参加培训人员
     * @return 结果
     */
    public int updateSysJoinTraining(SysJoinTraining sysJoinTraining);

    /**
     * 删除参加培训人员
     * 
     * @param fId 参加培训人员ID
     * @return 结果
     */
    public int deleteSysJoinTrainingById(Long fId);

    /**
     * 批量删除参加培训人员
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysJoinTrainingByIds(Long[] fIds);
}
