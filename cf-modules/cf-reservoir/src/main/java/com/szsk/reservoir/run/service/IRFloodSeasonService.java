package com.szsk.reservoir.run.service;

import java.util.List;
import com.szsk.reservoir.run.domain.RFloodSeason;

/**
 * 汛期调度运行计划 Service接口
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
public interface IRFloodSeasonService 
{
    /**
     * 查询汛期调度运行计划 
     * 
     * @param fId 汛期调度运行计划 ID
     * @return 汛期调度运行计划 
     */
    public RFloodSeason selectRFloodSeasonById(Long fId);

    /**
     * 查询汛期调度运行计划 列表
     * 
     * @param rFloodSeason 汛期调度运行计划 
     * @return 汛期调度运行计划 集合
     */
    public List<RFloodSeason> selectRFloodSeasonList(RFloodSeason rFloodSeason);

    /**
     * 新增汛期调度运行计划 
     * 
     * @param rFloodSeason 汛期调度运行计划 
     * @return 结果
     */
    public int insertRFloodSeason(RFloodSeason rFloodSeason);

    /**
     * 修改汛期调度运行计划 
     * 
     * @param rFloodSeason 汛期调度运行计划 
     * @return 结果
     */
    public int updateRFloodSeason(RFloodSeason rFloodSeason);

    /**
     * 批量删除汛期调度运行计划 
     * 
     * @param fIds 需要删除的汛期调度运行计划 ID
     * @return 结果
     */
    public int deleteRFloodSeasonByIds(Long[] fIds);

    /**
     * 删除汛期调度运行计划 信息
     * 
     * @param fId 汛期调度运行计划 ID
     * @return 结果
     */
    public int deleteRFloodSeasonById(Long fId);
}
