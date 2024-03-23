package com.szsk.reservoir.run.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.run.domain.RFloodRegulationEvaluation;
import com.szsk.reservoir.run.mapper.RFloodRegulationEvaluationMapper;
import com.szsk.reservoir.run.service.IRFloodRegulationEvaluationService;

/**
 * 洪水调度考评 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
@Service
public class RFloodRegulationEvaluationServiceImpl implements IRFloodRegulationEvaluationService 
{
    @Autowired
    private RFloodRegulationEvaluationMapper rFloodRegulationEvaluationMapper;

    /**
     * 查询洪水调度考评 
     * 
     * @param fId 洪水调度考评 ID
     * @return 洪水调度考评 
     */
    @Override
    public RFloodRegulationEvaluation selectRFloodRegulationEvaluationById(Long fId)
    {
        return rFloodRegulationEvaluationMapper.selectRFloodRegulationEvaluationById(fId);
    }

    /**
     * 查询洪水调度考评 列表
     * 
     * @param rFloodRegulationEvaluation 洪水调度考评 
     * @return 洪水调度考评 
     */
    @Override
    @Reservoir
    public List<RFloodRegulationEvaluation> selectRFloodRegulationEvaluationList(RFloodRegulationEvaluation rFloodRegulationEvaluation)
    {
        return rFloodRegulationEvaluationMapper.selectRFloodRegulationEvaluationList(rFloodRegulationEvaluation);
    }

    /**
     * 新增洪水调度考评 
     * 
     * @param rFloodRegulationEvaluation 洪水调度考评 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertRFloodRegulationEvaluation(RFloodRegulationEvaluation rFloodRegulationEvaluation)
    {
    	rFloodRegulationEvaluation.setfCreatePeople(SecurityUtils.getUserId());
    	rFloodRegulationEvaluation.setfCreateTime(new Date());
        return rFloodRegulationEvaluationMapper.insertRFloodRegulationEvaluation(rFloodRegulationEvaluation);
    }

    /**
     * 修改洪水调度考评 
     * 
     * @param rFloodRegulationEvaluation 洪水调度考评 
     * @return 结果
     */
    @Override
    public int updateRFloodRegulationEvaluation(RFloodRegulationEvaluation rFloodRegulationEvaluation)
    {
        return rFloodRegulationEvaluationMapper.updateRFloodRegulationEvaluation(rFloodRegulationEvaluation);
    }

    /**
     * 批量删除洪水调度考评 
     * 
     * @param fIds 需要删除的洪水调度考评 ID
     * @return 结果
     */
    @Override
    public int deleteRFloodRegulationEvaluationByIds(Long[] fIds)
    {
        return rFloodRegulationEvaluationMapper.deleteRFloodRegulationEvaluationByIds(fIds);
    }

    /**
     * 删除洪水调度考评 信息
     * 
     * @param fId 洪水调度考评 ID
     * @return 结果
     */
    @Override
    public int deleteRFloodRegulationEvaluationById(Long fId)
    {
        return rFloodRegulationEvaluationMapper.deleteRFloodRegulationEvaluationById(fId);
    }
}
