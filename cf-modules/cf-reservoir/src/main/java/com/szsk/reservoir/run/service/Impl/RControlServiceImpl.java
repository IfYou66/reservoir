package com.szsk.reservoir.run.service.Impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.exception.CustomException;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.manageSystem.mapper.SysTrainingMapper;
import com.szsk.reservoir.run.domain.RControl;
import com.szsk.reservoir.run.mapper.RControlMapper;
import com.szsk.reservoir.run.service.IRControlService;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 控制运行计划 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
@Service
public class RControlServiceImpl implements IRControlService 
{
    @Resource
    private RControlMapper rControlMapper;
    @Autowired
    private WorkFlowService workFlowService;
    @Resource
    private SysTrainingMapper sysTrainingMapper;

    /**
     * 查询控制运行计划 
     * 
     * @param fId 控制运行计划 ID
     * @return 控制运行计划 
     */
    @Override
    public RControl selectRControlById(Long fId)
    {
        return rControlMapper.selectRControlById(fId);
    }

    /**
     * 查询控制运行计划 列表
     * 
     * @param rControl 控制运行计划 
     * @return 控制运行计划 
     */
    @Override
    @Reservoir
    public List<RControl> selectRControlList(RControl rControl)
    {
        return rControlMapper.selectRControlList(rControl);
    }

    /**
     * 新增控制运行计划 
     * 
     * @param rControl 控制运行计划 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertRControl(RControl rControl)
    {
        if(rControl.getfActId() != null){
            throw new RuntimeException("等待审核请不要修改");
        }
        // 暂存
        rControl.setfActStatus(1);
        rControl.setfReviewComments(null);
        rControl.setfReviewResult(null);
        rControl.setfReviewPeople(null);
        rControl.setfReviewDate(null);
        rControl.setfAuditComments(null);
        rControl.setfAuditResult(null);
        rControl.setfAuditPeople(null);
        rControl.setfAuditDate(null);
        if (rControl.getfId() == null) {
            return insert(rControl);
        } else {
            return update(rControl);
        }
    }

    /**
     * 修改控制运行计划 
     * 
     * @param rControl 控制运行计划 
     * @return 结果
     */
    @Override
    public int updateRControl(RControl rControl)
    {
        return update(rControl);
    }

    /**
     * 批量删除控制运行计划 
     * 
     * @param fIds 需要删除的控制运行计划 ID
     * @return 结果
     */
    @Override
    public int deleteRControlByIds(Long[] fIds)
    {
        return rControlMapper.deleteRControlByIds(fIds);
    }

    /**
     * 删除控制运行计划 信息
     * 
     * @param fId 控制运行计划 ID
     * @return 结果
     */
    @Override
    public int deleteRControlById(Long fId)
    {
        return rControlMapper.deleteRControlById(fId);
    }

    /**
     * 获取最近
     * @return 结果
     */
    @Override
    public RControl latelyControl()
    {
        return rControlMapper.latelyControl();
    }
    
    /**
     * 流程
     *
     * @param rControl
     * @return 结果
     */
    @Override
    @Reservoir
    public AjaxResult startWorkFlow(RControl rControl)
    {
        if(rControl.getfActId() != null){
            throw new RuntimeException("等待审核请不要修改");
        }
        if(rControl.getfPlanName() == null || rControl.getfPlanName().equals("")){
            throw new RuntimeException("请填写计划名称");
        }
        if(rControl.getfPlanType() == null){
            throw new RuntimeException("请填写计划类型");
        }
        if(rControl.getfBudget() == null){
            throw new RuntimeException("请填写预算");
        }
        if(rControl.getfPlanContent() == null || rControl.getfPlanContent().equals("")){
            throw new RuntimeException("请填写计划概述");
        }
        if(rControl.getfPreparedBy() == null || rControl.getfPreparedBy().equals("")){
            throw new RuntimeException("请填写编制人");
        }
        if(rControl.getfPreparationTime() == null){
            throw new RuntimeException("请填写编制时间");
        }
        // 待审核
        rControl.setfActStatus(2);
        rControl.setfReviewComments(null);
        rControl.setfReviewResult(null);
        rControl.setfReviewPeople(null);
        rControl.setfReviewDate(null);
        rControl.setfAuditComments(null);
        rControl.setfAuditResult(null);
        rControl.setfAuditPeople(null);
        rControl.setfAuditDate(null);
        if(rControl.getfId() == null){
            insert(rControl);
        }else{
            updateRControl(rControl);
        }
        return workFlowService.startWorkFlow(rControl.getfId(), "control");
    }
    @Override
    public AjaxResult taskReview(RControl rControl)
    {
        AjaxResult reinforcement;
        RControl update = new RControl();
        update.setfId(rControl.getfId());
        if (rControl.getfAuditResult() == null) {
            if(rControl.getfReviewComments() == null || rControl.getfReviewComments().equals("")){
                throw new RuntimeException("请填写审核意见");
            }
            if(rControl.getfReviewResult() == null){
                throw new RuntimeException("请填写审核结果");
            }
            if(rControl.getfReviewPeople() == null || rControl.getfReviewPeople().equals("")){
                throw new RuntimeException("请填写审核人");
            }
            if(rControl.getfReviewDate() == null){
                throw new RuntimeException("请填写审核时间");
            }
            reinforcement = workFlowService.taskReview(
                    "control",
                    rControl.getfActId().toString(),
                    String.valueOf(rControl.getfReviewResult()),
                    String.valueOf(rControl.getfId())
            );
            update.setfReviewDate(rControl.getfReviewDate());
            update.setfReviewComments(rControl.getfReviewComments());
            update.setfReviewResult(rControl.getfReviewResult());
            update.setfReviewPeople(rControl.getfReviewPeople());
            if (rControl.getfReviewResult() == 1) {
                // 待审批
                update.setfActStatus(3);
            }
            if (rControl.getfReviewResult() == 3) {
                // 驳回
                update.setfActStatus(0);
            }
        } else {
            if(rControl.getfAuditComments() == null || rControl.getfAuditComments().equals("")){
                throw new RuntimeException("请填写" + "审批意见");
            }
            if(rControl.getfAuditResult() == null){
                throw new RuntimeException("请填写" + "审批结果");
            }
            if(rControl.getfAuditPeople() == null || rControl.getfAuditPeople().equals("")){
                throw new RuntimeException("请填写" + "审批人");
            }
            if(rControl.getfAuditDate() == null){
                throw new RuntimeException("请填写" + "审批时间");
            }
            reinforcement = workFlowService.taskReview(
                    "control",
                    rControl.getfActId().toString(),
                    rControl.getfAuditResult().toString(),
                    rControl.getfId().toString()
            );
            update.setfAuditDate(rControl.getfAuditDate());
            update.setfAuditComments(rControl.getfAuditComments());
            update.setfAuditResult(rControl.getfAuditResult());
            update.setfAuditPeople(rControl.getfAuditPeople());
            if (rControl.getfAuditResult() == 1) {
                // 待实施
                update.setfActStatus(4);
            }
            if (rControl.getfAuditResult() == 3) {
                // 驳回
                update.setfActStatus(0);
            }
        }
        update(update);
        return reinforcement;
    }

    @Override
    public AjaxResult getDictByType()
    {
        {
            Map<String,Object> map = new HashMap<>();
            try {
                // 查询字典
                List<SysDictData> result;
                result = sysTrainingMapper.queryDict("sys_result");
                map.put("sysResult", result);
                result = sysTrainingMapper.queryDict("plan_type");
                map.put("planType", result);
                result = sysTrainingMapper.queryDict("control_status");
                map.put("controlStatus", result);
            }catch (Exception e){
                e.printStackTrace();
                throw new CustomException("数据初始化异常");
            }
            return AjaxResult.success(map);
        }
    }
    @Reservoir
    public int insert(RControl rControl){
        rControl.setfCreateTime(new Date(System.currentTimeMillis()));
        return rControlMapper.insertRControl(rControl);
    }
    @Reservoir
    public int update(RControl rControl){
        return rControlMapper.updateRControl(rControl);
    }
}