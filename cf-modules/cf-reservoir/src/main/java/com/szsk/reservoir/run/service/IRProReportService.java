package com.szsk.reservoir.run.service;

import com.szsk.reservoir.run.domain.RProReport;

import java.util.List;

/**
 * 项目申报 Service接口
 *
 * @author cangfeng
 * @date 2021-08-23
 */
public interface IRProReportService {

    /**
     * 查询项目申报
     *
     * @param fId 项目申报 ID
     * @return 项目申报
     */
    public RProReport selectRProReportById(Long fId);

    /**
     * 查询项目申报 列表
     *
     * @param rProReport 项目申报
     * @return 项目申报 集合
     */
    public List<RProReport> selectRProReportList(RProReport rProReport);

    /**
     * 新增项目申报
     *
     * @param rProReport 项目申报
     * @return 结果
     */
    public int insertRProReport(RProReport rProReport);

    /**
     * 修改项目申报
     *
     * @param rProReport 项目申报
     * @return 结果
     */
    public int updateRProReport(RProReport rProReport);

    /**
     * 批量删除项目申报
     *
     * @param fIds 需要删除的项目申报 ID
     * @return 结果
     */
    public int deleteRProReportByIds(Long[] fIds);

    /**
     * 删除项目申报 信息
     *
     * @param fId 项目申报 ID
     * @return 结果
     */
    public int deleteRProReportById(Long fId);

}
