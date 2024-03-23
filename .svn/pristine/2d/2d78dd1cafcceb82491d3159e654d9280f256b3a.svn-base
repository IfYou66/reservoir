package com.szsk.reservoir.run.service.Impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.run.domain.RFloodSeason;
import com.szsk.reservoir.run.mapper.RFloodSeasonMapper;
import com.szsk.reservoir.run.service.IRFloodSeasonService;

/**
 * 汛期调度运行计划 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
@Service
public class RFloodSeasonServiceImpl implements IRFloodSeasonService 
{
    @Autowired
    private RFloodSeasonMapper rFloodSeasonMapper;

    /**
     * 查询汛期调度运行计划 
     * 
     * @param fId 汛期调度运行计划 ID
     * @return 汛期调度运行计划 
     */
    @Override
    public RFloodSeason selectRFloodSeasonById(Long fId)
    {
        return rFloodSeasonMapper.selectRFloodSeasonById(fId);
    }

    /**
     * 查询汛期调度运行计划 列表
     * 
     * @param rFloodSeason 汛期调度运行计划 
     * @return 汛期调度运行计划 
     */
    @Override
    @Reservoir
    public List<RFloodSeason> selectRFloodSeasonList(RFloodSeason rFloodSeason)
    {
        return rFloodSeasonMapper.selectRFloodSeasonList(rFloodSeason);
    }

    /**
     * 新增汛期调度运行计划 
     * 
     * @param rFloodSeason 汛期调度运行计划 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertRFloodSeason(RFloodSeason rFloodSeason)
    {
    	rFloodSeason.setfCreatePeople(SecurityUtils.getUserId());
    	rFloodSeason.setfCreateTime(new Date());
        return rFloodSeasonMapper.insertRFloodSeason(rFloodSeason);
    }

    /**
     * 修改汛期调度运行计划 
     * 
     * @param rFloodSeason 汛期调度运行计划 
     * @return 结果
     */
    @Override
    public int updateRFloodSeason(RFloodSeason rFloodSeason)
    {
        return rFloodSeasonMapper.updateRFloodSeason(rFloodSeason);
    }

    /**
     * 批量删除汛期调度运行计划 
     * 
     * @param fIds 需要删除的汛期调度运行计划 ID
     * @return 结果
     */
    @Override
    public int deleteRFloodSeasonByIds(Long[] fIds)
    {
        return rFloodSeasonMapper.deleteRFloodSeasonByIds(fIds);
    }

    /**
     * 删除汛期调度运行计划 信息
     * 
     * @param fId 汛期调度运行计划 ID
     * @return 结果
     */
    @Override
    public int deleteRFloodSeasonById(Long fId)
    {
        return rFloodSeasonMapper.deleteRFloodSeasonById(fId);
    }
}
