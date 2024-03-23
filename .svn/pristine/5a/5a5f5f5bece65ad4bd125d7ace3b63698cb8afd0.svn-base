package com.szsk.reservoir.run.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.utils.Constant;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.run.domain.RCheckRecord;
import com.szsk.reservoir.run.domain.REventProcess;
import com.szsk.reservoir.run.domain.REventRecord;
import com.szsk.reservoir.run.domain.RSecuImpl;
import com.szsk.reservoir.run.mapper.RCheckRecordMapper;
import com.szsk.reservoir.run.mapper.REventProcessMapper;
import com.szsk.reservoir.run.mapper.REventRecordMapper;
import com.szsk.reservoir.run.mapper.RSecuImplMapper;
import com.szsk.reservoir.run.mapper.RSecurityMapper;
import com.szsk.reservoir.run.service.IRSecuImplService;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 安检检查实施 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-25
 */
@Service
public class RSecuImplServiceImpl implements IRSecuImplService {
    @Resource
    private RSecuImplMapper rSecuImplMapper;

    @Resource
    private WorkFlowService workFlowService;

    @Resource
    private RCheckRecordMapper rCheckRecordMapper;

    @Resource
    private REventRecordMapper rEventRecordMapper;

    @Resource
    private REventProcessMapper rEventProcessMapper;

    @Resource
    private RSecurityMapper securityMapper;

    /**
     * 查询安检检查实施
     *
     * @param fId 安检检查实施 ID
     * @return 安检检查实施
     */
    @Override
    public RSecuImpl selectRSecuImplById(Long fId) {
        return rSecuImplMapper.selectRSecuImplById(fId);
    }

    /**
     * 根据计划编制id获取检查实施详情
     * @param fPlaneditId
     * @return
     */
    @Override
    public AjaxResult selectRSecuImplByfPlaneditId(Long fPlaneditId) {
        RSecuImpl rSecu = rSecuImplMapper.selectRSecuImplByfPlaneditId(fPlaneditId);
        if (rSecu != null) {
            // 获取当前登陆人
            rSecu.setLandingPersonId(SecurityUtils.getUserId());
            // 检查记录列表
            List<RCheckRecord> checkRecordList = rCheckRecordMapper.getMusterBy(rSecu.getfId());
            rSecu.setRecordList(checkRecordList);
            // 时间记录列表
            List<REventRecord> eventRecordList = rEventRecordMapper.getListBySecuimpId(rSecu.getfId());
            rSecu.setEventRecordList(eventRecordList);
            // 处置结果列表
            List<REventProcess> eventProcessList = rEventProcessMapper.getListByImplId(rSecu.getfId());
            rSecu.setEventProcessList(eventProcessList);

            return AjaxResult.success(rSecu);
        } else {
            return AjaxResult.error("该计划未被实施");
        }
    }

    /**
     * 查询安检检查实施 列表
     *
     * @param rSecuImpl 安检检查实施
     * @return 安检检查实施
     */
    @Override
    @Reservoir
    public List<RSecuImpl> selectRSecuImplList(RSecuImpl rSecuImpl) {
        return rSecuImplMapper.selectRSecuImplList(rSecuImpl);
    }

    /**
     * 新增安检检查实施
     *
     * @param rSecuImpl 安检检查实施
     * @return 结果
     */
    @Override
    @Transactional
    @Reservoir
    public AjaxResult insertRSecuImpl(RSecuImpl rSecuImpl) {
        // 根据编制id 查找是否已经有实施记录
        RSecuImpl rSecu = rSecuImplMapper.selectRSecuImplByfPlaneditId(rSecuImpl.getfPlaneditId());
        if (rSecu != null) {
            return AjaxResult.error("您选的计划正在实施中请勿重复实施");
        }
        rSecuImpl.setCreateTime(new Date());
        rSecuImpl.setfCreatePeople(String.valueOf(SecurityUtils.getUserId()));
        // 默认有效
        rSecuImpl.setfStatus(Constant.GLOBAL_NUM_ONE);
        // HoldOrSubmit = 1 时 启动流程 否则就只存数据不执行流程
        if (rSecuImpl.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            // 执行流程
            // 1:暂存 2：待审核 3：待审批 4：计划流程完成 5：待上报(暂存) 6：待上报 7：待处理 8：实施待审核 9：实施完成
            rSecuImpl.setfActStatus(Constant.GLOBAL_NUM_SIX);
        } else {
            // 暂存
            rSecuImpl.setfActStatus(Constant.GLOBAL_NUM_FIVES);
        }
        int i = rSecuImplMapper.insertRSecuImpl(rSecuImpl);
        for (RCheckRecord checkRecord : rSecuImpl.getRecordList()) {
            checkRecord.setfSecuimpId(String.valueOf(rSecuImpl.getfId()));
            checkRecord.setfStatus(Constant.GLOBAL_NUM_ONE);
        }
        // 保存检查列表集合
        rCheckRecordMapper.batchAdd(rSecuImpl.getRecordList());
        // 修改计划编制表下一节点审核人
        rSecuImpl.setfActPersion("audit");
        securityMapper.updateFActPersion(rSecuImpl);
        if (rSecuImpl.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            return workFlowService.startWorkFlow(rSecuImpl.getfId(), "secuimpl");
        }
        return i > 0 ? AjaxResult.success("安全检查实施暂存成功") : AjaxResult.error("安全检查实施暂存失败");
    }

    /**
     * 修改安检检查实施
     *
     * @param rSecuImpl 安检检查实施
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateRSecuImpl(RSecuImpl rSecuImpl) {
        if (StringUtils.isBlank(rSecuImpl.getfActNode())) {
            rSecuImpl.setfActStatus(Constant.GLOBAL_NUM_SIX);
            rSecuImplMapper.updateRSecuImpl(rSecuImpl);
            // 修改计划编制表下一节点审核人
            rSecuImpl.setfActPersion("audit");
            securityMapper.updateFActPersion(rSecuImpl);
            return workFlowService.startWorkFlow(Long.valueOf(rSecuImpl.getfId()), "secuimpl");
        } else if ("report".equals(rSecuImpl.getfActNode())) {
            rSecuImpl.setfActStatus(Constant.GLOBAL_NUM_SEVEN);
            rSecuImplMapper.updateRSecuImpl(rSecuImpl);
            // 修改计划编制表下一节点审核人
            securityMapper.updateFActPersion(rSecuImpl);
            return workFlowService.taskReview("secuimpl", String.valueOf(rSecuImpl.getfActId()), String.valueOf(Constant.GLOBAL_NUM_ONE), String.valueOf(rSecuImpl.getfId()));
        } else if ("handle".equals(rSecuImpl.getfActNode())) {
            // fActStatus = 8 实施待审核
            rSecuImpl.setfActStatus(Constant.GLOBAL_NUM_EIGHT);
            rSecuImplMapper.updateRSecuImpl(rSecuImpl);
            // 修改计划编制表下一节点审核人
            securityMapper.updateFActPersion(rSecuImpl);
            return workFlowService.taskReview("secuimpl", String.valueOf(rSecuImpl.getfActId()), String.valueOf(Constant.GLOBAL_NUM_ONE), String.valueOf(rSecuImpl.getfId()));
        } else if ("audit".equals(rSecuImpl.getfActNode())) {
            // 如果审核通过把fActStatus 改为4(完成) 如果审核驳回fActStatus改为1重新提交
            if (rSecuImpl.getfReviewResult() == Constant.GLOBAL_NUM_ONE) {
                // fActStatus = 9 实施完成
                rSecuImpl.setfActStatus(Constant.GLOBAL_NUM_NINE);
                // fReviewResult = 3 为驳回 驳回可重新提交
            } else if (rSecuImpl.getfReviewResult() == Constant.GLOBAL_NUM_THREE){
                // 驳回状态改为5 重新提交
                rSecuImpl.setfActStatus(Constant.GLOBAL_NUM_FIVES);
            }
            rSecuImplMapper.updateRSecuImpl(rSecuImpl);
            // 修改计划编制表下一节点审核人
            rSecuImpl.setfActPersion(null);
            securityMapper.updateFActPersion(rSecuImpl);
            return workFlowService.taskReview("secuimpl", String.valueOf(rSecuImpl.getfActId()), String.valueOf(rSecuImpl.getfReviewResult()), String.valueOf(rSecuImpl.getfId()));
        }
        return AjaxResult.error("流程出错");
    }

    /**
     * 批量删除安检检查实施
     *
     * @param fIds 需要删除的安检检查实施 ID
     * @return 结果
     */
    @Override
    public int deleteRSecuImplByIds(Long[] fIds) {
        return rSecuImplMapper.deleteRSecuImplByIds(fIds);
    }

    /**
     * 删除安检检查实施 信息
     *
     * @param fId 安检检查实施 ID
     * @return 结果
     */
    @Override
    public int deleteRSecuImplById(Long fId) {
        return rSecuImplMapper.deleteRSecuImplById(fId);
    }
}
