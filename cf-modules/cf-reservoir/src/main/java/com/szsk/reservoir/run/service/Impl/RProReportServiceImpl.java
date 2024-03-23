package com.szsk.reservoir.run.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.run.domain.RProReport;
import com.szsk.reservoir.run.mapper.RProReportMapper;
import com.szsk.reservoir.run.service.IRProReportService;

/**
 * 项目申报 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-23
 */
@Service
public class RProReportServiceImpl implements IRProReportService {

    @Autowired
    private RProReportMapper rProReportMapper;

    /**
     * 查询项目申报
     *
     * @param fId 项目申报 ID
     * @return 项目申报
     */
    @Override
    public RProReport selectRProReportById(Long fId)
    {
        return rProReportMapper.selectRProReportById(fId);
    }

    /**
     * 查询项目申报 列表
     *
     * @param rProReport 项目申报
     * @return 项目申报
     */
    @Override
    @Reservoir
    public List<RProReport> selectRProReportList(RProReport rProReport)
    {
        return rProReportMapper.selectRProReportList(rProReport);
    }

    /**
     * 新增项目申报
     *
     * @param rProReport 项目申报
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertRProReport(RProReport rProReport)
    {
        return rProReportMapper.insertRProReport(rProReport);
    }

    /**
     * 修改项目申报
     *
     * @param rProReport 项目申报
     * @return 结果
     */
    @Override
    public int updateRProReport(RProReport rProReport)
    {
        return rProReportMapper.updateRProReport(rProReport);
    }

    /**
     * 批量删除项目申报
     *
     * @param fIds 需要删除的项目申报 ID
     * @return 结果
     */
    @Override
    public int deleteRProReportByIds(Long[] fIds)
    {
        return rProReportMapper.deleteRProReportByIds(fIds);
    }

    /**
     * 删除项目申报 信息
     *
     * @param fId 项目申报 ID
     * @return 结果
     */
    @Override
    public int deleteRProReportById(Long fId)
    {
        return rProReportMapper.deleteRProReportById(fId);
    }

}
