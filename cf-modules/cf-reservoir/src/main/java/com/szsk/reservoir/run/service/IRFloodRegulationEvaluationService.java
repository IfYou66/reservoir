package com.szsk.reservoir.run.service;

import java.util.List;
import com.szsk.reservoir.run.domain.RFloodRegulationEvaluation;

/**
 * 洪水调度考评 Service接口
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
public interface IRFloodRegulationEvaluationService 
{
    /**
     * 查询洪水调度考评 
     * 
     * @param fId 洪水调度考评 ID
     * @return 洪水调度考评 
     */
    public RFloodRegulationEvaluation selectRFloodRegulationEvaluationById(Long fId);

    /**
     * 查询洪水调度考评 列表
     * 
     * @param rFloodRegulationEvaluation 洪水调度考评 
     * @return 洪水调度考评 集合
     */
    public List<RFloodRegulationEvaluation> selectRFloodRegulationEvaluationList(RFloodRegulationEvaluation rFloodRegulationEvaluation);

    /**
     * 新增洪水调度考评 
     * 
     * @param rFloodRegulationEvaluation 洪水调度考评 
     * @return 结果
     */
    public int insertRFloodRegulationEvaluation(RFloodRegulationEvaluation rFloodRegulationEvaluation);

    /**
     * 修改洪水调度考评 
     * 
     * @param rFloodRegulationEvaluation 洪水调度考评 
     * @return 结果
     */
    public int updateRFloodRegulationEvaluation(RFloodRegulationEvaluation rFloodRegulationEvaluation);

    /**
     * 批量删除洪水调度考评 
     * 
     * @param fIds 需要删除的洪水调度考评 ID
     * @return 结果
     */
    public int deleteRFloodRegulationEvaluationByIds(Long[] fIds);

    /**
     * 删除洪水调度考评 信息
     * 
     * @param fId 洪水调度考评 ID
     * @return 结果
     */
    public int deleteRFloodRegulationEvaluationById(Long fId);
}
