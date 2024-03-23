package com.szsk.reservoir.manageSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.manageSystem.domain.SysJoinTraining;
import com.szsk.reservoir.manageSystem.mapper.SysJoinTrainingMapper;
import com.szsk.reservoir.manageSystem.service.ISysJoinTrainingService;

/**
 * 参加培训人员Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-13
 */
@Service
public class SysJoinTrainingServiceImpl implements ISysJoinTrainingService 
{
    @Autowired
    private SysJoinTrainingMapper sysJoinTrainingMapper;

    /**
     * 查询参加培训人员
     * 
     * @param fId 参加培训人员ID
     * @return 参加培训人员
     */
    @Override
    public SysJoinTraining selectSysJoinTrainingById(Long fId)
    {
        return sysJoinTrainingMapper.selectSysJoinTrainingById(fId);
    }

    /**
     * 查询参加培训人员列表
     * 
     * @param sysJoinTraining 参加培训人员
     * @return 参加培训人员
     */
    @Override
    public List<SysJoinTraining> selectSysJoinTrainingList(SysJoinTraining sysJoinTraining)
    {
        return sysJoinTrainingMapper.selectSysJoinTrainingList(sysJoinTraining);
    }

    /**
     * 新增参加培训人员
     * 
     * @param sysJoinTraining 参加培训人员
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertSysJoinTraining(SysJoinTraining sysJoinTraining)
    {
        return sysJoinTrainingMapper.insertSysJoinTraining(sysJoinTraining);
    }

    /**
     * 修改参加培训人员
     * 
     * @param sysJoinTraining 参加培训人员
     * @return 结果
     */
    @Override
    public int updateSysJoinTraining(SysJoinTraining sysJoinTraining)
    {
        return sysJoinTrainingMapper.updateSysJoinTraining(sysJoinTraining);
    }

    /**
     * 批量删除参加培训人员
     * 
     * @param fIds 需要删除的参加培训人员ID
     * @return 结果
     */
    @Override
    public int deleteSysJoinTrainingByIds(Long[] fIds)
    {
        return sysJoinTrainingMapper.deleteSysJoinTrainingByIds(fIds);
    }

    /**
     * 删除参加培训人员信息
     * 
     * @param fId 参加培训人员ID
     * @return 结果
     */
    @Override
    public int deleteSysJoinTrainingById(Long fId)
    {
        return sysJoinTrainingMapper.deleteSysJoinTrainingById(fId);
    }
}
