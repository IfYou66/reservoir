package com.szsk.reservoir.run.service;

import java.util.List;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.run.domain.RControl;

/**
 * 控制运行计划 Service接口
 *
 * @author cangfeng
 * @date 2021-08-23
 */
public interface IRControlService
{
    /**
     * 查询控制运行计划
     *
     * @param fId 控制运行计划 ID
     * @return 控制运行计划
     */
    public RControl selectRControlById(Long fId);

    /**
     * 查询控制运行计划 列表
     *
     * @param rControl 控制运行计划
     * @return 控制运行计划 集合
     */
    public List<RControl> selectRControlList(RControl rControl);

    /**
     * 新增控制运行计划
     *
     * @param rControl 控制运行计划
     * @return 结果
     */
    int insertRControl(RControl rControl);

    /**
     * 修改控制运行计划
     *
     * @param rControl 控制运行计划
     * @return 结果
     */
    int updateRControl(RControl rControl);

    /**
     * 批量删除控制运行计划
     *
     * @param fIds 需要删除的控制运行计划 ID
     * @return 结果
     */
    public int deleteRControlByIds(Long[] fIds);

    /**
     * 删除控制运行计划 信息
     *
     * @param fId 控制运行计划 ID
     * @return 结果
     */
    public int deleteRControlById(Long fId);

    /**
     * 获取最近
     * @return 结果
     */
    RControl latelyControl();

    /**
     * 流程
     * @param rControl
     * @return 结果
     */
    AjaxResult startWorkFlow(RControl rControl);
    AjaxResult taskReview(RControl rControl);

    AjaxResult getDictByType();

    int insert(RControl rControl);
    int update(RControl rControl);
}
