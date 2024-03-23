package com.szsk.reservoir.run.service;

import java.util.List;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.run.domain.RAnnualScheduling;
import com.szsk.reservoir.run.domain.RControl;

/**
 * 年度调度总结 Service接口
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
public interface IRAnnualSchedulingService 
{
    /**
     * 查询年度调度总结 
     * 
     * @param fId 年度调度总结 ID
     * @return 年度调度总结 
     */
    public RAnnualScheduling selectRAnnualSchedulingById(Integer fId);

    /**
     * 查询年度调度总结 列表
     * 
     * @param rAnnualScheduling 年度调度总结 
     * @return 年度调度总结 集合
     */
    public List<RAnnualScheduling> selectRAnnualSchedulingList(RAnnualScheduling rAnnualScheduling);

    /**
     * 新增年度调度总结 
     * 
     * @param rAnnualScheduling 年度调度总结 
     * @return 结果
     */
    public int insertRAnnualScheduling(RAnnualScheduling rAnnualScheduling);

    /**
     * 修改年度调度总结 
     * 
     * @param rAnnualScheduling 年度调度总结 
     * @return 结果
     */
    public int updateRAnnualScheduling(RAnnualScheduling rAnnualScheduling);

    /**
     * 批量删除年度调度总结 
     * 
     * @param fIds 需要删除的年度调度总结 ID
     * @return 结果
     */
    public int deleteRAnnualSchedulingByIds(Integer[] fIds);

    /**
     * 删除年度调度总结 信息
     * 
     * @param fId 年度调度总结 ID
     * @return 结果
     */
    public int deleteRAnnualSchedulingById(Integer fId);

    /**
     * 流程
     * @param rAnnualScheduling
     * @return 结果
     */
    AjaxResult startWorkFlow(RAnnualScheduling rAnnualScheduling);
    AjaxResult taskReview(RAnnualScheduling rAnnualScheduling);
}
