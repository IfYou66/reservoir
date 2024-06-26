package com.szsk.reservoir.run.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.run.domain.RControl;
import com.szsk.reservoir.run.domain.RControlImpl;
import com.szsk.reservoir.run.mapper.RControlImplMapper;
import com.szsk.reservoir.run.service.IRControlImplService;
import com.szsk.reservoir.run.service.IRControlService;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 控制运行计划实施Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-26
 */
@Service
public class RControlImplServiceImpl implements IRControlImplService 
{
    @Resource
    private RControlImplMapper rControlImplMapper;
    @Autowired
    private WorkFlowService workFlowService;
    @Autowired
    private IRControlService rControlService;


    /**
     * 查询控制运行计划实施
     * 
     * @param fId 控制运行计划实施ID
     * @return 控制运行计划实施
     */
    @Override
    public RControlImpl selectRControlImplById(Long fId)
    {
        return rControlImplMapper.selectRControlImplById(fId);
    }

    /**
     * 查询控制运行计划实施列表
     * 
     * @param rControlImpl 控制运行计划实施
     * @return 控制运行计划实施
     */
    @Override
    @Reservoir
    public List<RControlImpl> selectRControlImplList(RControlImpl rControlImpl)
    {
        return rControlImplMapper.selectRControlImplList(rControlImpl);
    }

    /**
     * 新增控制运行计划实施
     * 
     * @param rControlImpl 控制运行计划实施
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertRControlImpl(RControlImpl rControlImpl)
    {
        rControlImpl.setfCreateTime(new Date(System.currentTimeMillis()));
        return rControlImplMapper.insertRControlImpl(rControlImpl);
    }

    /**
     * 修改控制运行计划实施
     * 
     * @param rControlImpl 控制运行计划实施
     * @return 结果
     */
    @Override
    public int updateRControlImpl(RControlImpl rControlImpl)
    {
        return rControlImplMapper.updateRControlImpl(rControlImpl);
    }

    /**
     * 批量删除控制运行计划实施
     * 
     * @param fIds 需要删除的控制运行计划实施ID
     * @return 结果
     */
    @Override
    public int deleteRControlImplByIds(Long[] fIds)
    {
        return rControlImplMapper.deleteRControlImplByIds(fIds);
    }

    /**
     * 删除控制运行计划实施信息
     * 
     * @param fId 控制运行计划实施ID
     * @return 结果
     */
    @Override
    public int deleteRControlImplById(Long fId)
    {
        return rControlImplMapper.deleteRControlImplById(fId);
    }

    /**
     * 获取最近
     * @return 结果
     */
    @Override
    public RControlImpl latelyControl()
    {
        return rControlImplMapper.latelyControl();
    }

    /**
     * 流程
     *
     * @param rControlImpl
     * @return 结果
     */
    @Override
    public AjaxResult startWorkFlow(RControlImpl rControlImpl)
    {
        if(rControlImpl.getfActId() != null){
            throw new RuntimeException("等待审核请不要修改");
        }
        if(rControlImpl.getfPreparedId() == null){
            throw new RuntimeException("请填写" + "计划编制");
        }
        if(rControlImpl.getfImplContent() == null || rControlImpl.getfImplContent().equals("")){
            throw new RuntimeException("请填写" + "实施内容");
        }
        if(rControlImpl.getfImplPeople() == null || rControlImpl.getfImplPeople().equals("")){
            throw new RuntimeException("请填写" + "实施人");
        }
        if(rControlImpl.getfImplTime() == null){
            throw new RuntimeException("请填写" + "实施时间");
        }
        if (rControlImpl.getfPreparedId() != null) {
            RControl rControl = rControlService.selectRControlById(rControlImpl.getfPreparedId());
            // 6实施待审核
            rControl.setfActStatus(6);
            rControl.setfActPersion(rControlImpl.getfActPersion());
            rControlService.update(rControl);
        } else {
            throw new RuntimeException("实施流程计划错误");
        }
        rControlImpl.setfReviewComments(null);
        rControlImpl.setfReviewResult(null);
        rControlImpl.setfReviewPeople(null);
        rControlImpl.setfReviewDate(null);
        if(rControlImpl.getfId() == null){
            insertRControlImpl(rControlImpl);
        }else{
            updateRControlImpl(rControlImpl);
        }
        return workFlowService.startWorkFlow(rControlImpl.getfId(), "controlimpl");
    }
    @Override
    public AjaxResult taskReview(RControlImpl rControlImpl)
    {
        AjaxResult reinforcement;
        RControlImpl update = new RControlImpl();
        update.setfId(rControlImpl.getfId());

        if(rControlImpl.getfReviewComments() == null || rControlImpl.getfReviewComments().equals("")){
            throw new RuntimeException("请填写" + "审核意见");
        }
        if(rControlImpl.getfReviewResult() == null){
            throw new RuntimeException("请填写" + "审核结果");
        }
        if(rControlImpl.getfReviewPeople() == null || rControlImpl.getfReviewPeople().equals("")){
            throw new RuntimeException("请填写" + "审核人");
        }
        if(rControlImpl.getfReviewDate() == null || rControlImpl.getfReviewDate().equals("")){
            throw new RuntimeException("请填写" + "审核时间");
        }

        reinforcement = workFlowService.taskReview(
                "controlimpl",
                rControlImpl.getfActId().toString(),
                String.valueOf(rControlImpl.getfReviewResult()),
                String.valueOf(rControlImpl.getfId())
        );

        if (rControlImpl.getfPreparedId() != null) {
            RControl rControl = rControlService.selectRControlById(rControlImpl.getfPreparedId());
            if (rControlImpl.getfReviewResult() == 1) {
                // 7实施完成
                rControl.setfActStatus(7);
            } else {
                // 5实施待提交
                rControl.setfActStatus(5);
            }
            rControl.setfActPersion(rControlImpl.getfActPersion());
            rControlService.update(rControl);
        } else {
            throw new RuntimeException("实施流程计划错误");
        }

        update.setfReviewDate(rControlImpl.getfReviewDate());
        update.setfReviewComments(rControlImpl.getfReviewComments());
        update.setfReviewResult(rControlImpl.getfReviewResult());
        update.setfReviewPeople(rControlImpl.getfReviewPeople());
        updateRControlImpl(update);
        return reinforcement;
    }

    public int setRControlImpl(RControlImpl rControlImpl){
        if(rControlImpl.getfActId() != null){
            throw new RuntimeException("等待审核请不要修改");
        }
        rControlImpl.setfReviewComments(null);
        rControlImpl.setfReviewResult(null);
        rControlImpl.setfReviewPeople(null);
        rControlImpl.setfReviewDate(null);
        if (rControlImpl.getfId() == null) {
            if (rControlImpl.getfPreparedId() != null) {
                RControl rControl = rControlService.selectRControlById(rControlImpl.getfPreparedId());
                rControl.setfActStatus(5);
                rControlService.update(rControl);
            } else {
                throw new RuntimeException("请选择实施流程");
            }
            return insertRControlImpl(rControlImpl);
        } else {
            rControlImpl.setfCreateTime(new Date(System.currentTimeMillis()));
            return updateRControlImpl(rControlImpl);
        }
    }
}
