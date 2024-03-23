package com.szsk.reservoir.run.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.run.domain.RAnnualScheduling;
import com.szsk.reservoir.run.mapper.RAnnualSchedulingMapper;
import com.szsk.reservoir.run.service.IRAnnualSchedulingService;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 年度调度总结 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
@Service
public class RAnnualSchedulingServiceImpl implements IRAnnualSchedulingService 
{
    @Autowired
    private RAnnualSchedulingMapper rAnnualSchedulingMapper;
    @Autowired
    private WorkFlowService workFlowService;

    /**
     * 查询年度调度总结 
     * 
     * @param fId 年度调度总结 ID
     * @return 年度调度总结 
     */
    @Override
    public RAnnualScheduling selectRAnnualSchedulingById(Integer fId)
    {
        return rAnnualSchedulingMapper.selectRAnnualSchedulingById(fId);
    }

    /**
     * 查询年度调度总结 列表
     * 
     * @param rAnnualScheduling 年度调度总结 
     * @return 年度调度总结 
     */
    @Override
    @Reservoir
    public List<RAnnualScheduling> selectRAnnualSchedulingList(RAnnualScheduling rAnnualScheduling)
    {
        return rAnnualSchedulingMapper.selectRAnnualSchedulingList(rAnnualScheduling);
    }

    /**
     * 新增年度调度总结 
     * 
     * @param rAnnualScheduling 年度调度总结 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertRAnnualScheduling(RAnnualScheduling rAnnualScheduling)
    {
        int i = rAnnualSchedulingMapper.insertRAnnualScheduling(rAnnualScheduling);
        //当流的状态 为 提交时 使用流
        if (rAnnualScheduling.getfActStatus()==1) {
            //工作流节点 接口
            // 业务ID 下节点处理人 “register”
            workFlowService.startWorkFlow(rAnnualScheduling.getfId(),"register");
        }
        return i;
    }

    /**
     * 修改年度调度总结 
     * 
     * @param rAnnualScheduling 年度调度总结 
     * @return 结果
     */
    @Override
    public int updateRAnnualScheduling(RAnnualScheduling rAnnualScheduling)
    {
        //根据提交状态 判断下一步的流程
        //若提交状态为 2 => 即通过审核
        if(rAnnualScheduling.getfActStatus() == 1) {
            // 指定字符  下一节点处理人  处理状态  业务的ID  流程的ID
            workFlowService.taskReview("register", rAnnualScheduling.getfActNode(), "1",rAnnualScheduling.getfId().toString());
        }
        //若提交状态为 2 => 即通过审批
        else if(rAnnualScheduling.getfActStatus() == 2) {
            workFlowService.taskReview("register", rAnnualScheduling.getfActNode(),"2",rAnnualScheduling.getfId().toString());
        }
        //若提交状态为 4 => 即驳回修改
        else if(rAnnualScheduling.getfActStatus() == 4){
            workFlowService.taskReview("register", rAnnualScheduling.getfActNode(),"4",rAnnualScheduling.getfId().toString());
        }
        //若提交状态为 5 => 审核 未通过
        else if(rAnnualScheduling.getfActStatus() == 5){
            workFlowService.taskReview("register", rAnnualScheduling.getfActNode(),"5",rAnnualScheduling.getfId().toString());
        }
        return rAnnualSchedulingMapper.updateRAnnualScheduling(rAnnualScheduling);
    }

    /**
     * 批量删除年度调度总结 
     * 
     * @param fIds 需要删除的年度调度总结 ID
     * @return 结果
     */
    @Override
    public int deleteRAnnualSchedulingByIds(Integer[] fIds)
    {
        return rAnnualSchedulingMapper.deleteRAnnualSchedulingByIds(fIds);
    }

    /**
     * 删除年度调度总结 信息
     * 
     * @param fId 年度调度总结 ID
     * @return 结果
     */
    @Override
    public int deleteRAnnualSchedulingById(Integer fId)
    {
        return rAnnualSchedulingMapper.deleteRAnnualSchedulingById(fId);
    }

    @Override
    public AjaxResult startWorkFlow(RAnnualScheduling rAnnualScheduling) {
        return workFlowService.startWorkFlow(Long.valueOf(rAnnualScheduling.getfId()), "instruction");
    }

    @Override
    public AjaxResult taskReview(RAnnualScheduling rAnnualScheduling) {
        AjaxResult reinforcement;

        reinforcement = workFlowService.taskReview(
                "instruction",
                rAnnualScheduling.getfActId().toString(),
                rAnnualScheduling.getfAuditResult().toString(),
                rAnnualScheduling.getfId().toString()
        );
        return reinforcement;
    }
}
