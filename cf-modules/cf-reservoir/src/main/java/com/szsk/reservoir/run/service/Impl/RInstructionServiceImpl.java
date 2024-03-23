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
import com.szsk.reservoir.run.domain.RInstruction;
import com.szsk.reservoir.run.mapper.RInstructionMapper;
import com.szsk.reservoir.run.mapper.RSecurityMapper;
import com.szsk.reservoir.run.service.IRInstructionService;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 调度指令 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-23
 */
@Service
public class RInstructionServiceImpl implements IRInstructionService {
    @Resource
    private RInstructionMapper rInstructionMapper;

    @Resource
    private WorkFlowService workFlowService;

    @Resource
    private RSecurityMapper rSecurityMapper;

    /**
     * 查询调度指令
     *
     * @param fInstructionId 调度指令 ID
     * @return 调度指令
     */
    @Override
    public RInstruction selectRInstructionById(Integer fInstructionId) {
        return rInstructionMapper.selectRInstructionById(fInstructionId);
    }

    /**
     * 查询调度指令 列表
     *
     * @param rInstruction 调度指令
     * @return 调度指令
     */
    @Override
    @Reservoir
    public List<RInstruction> selectRInstructionList(RInstruction rInstruction) {
        String userId = String.valueOf(SecurityUtils.getUserId());
        // 判断是否为管理员角色  管理员角色查询全部列表
        int ifAdmin = rSecurityMapper.ifAdmin(userId);
        // 查询是否存在审核角色
        boolean isRole = workFlowService.isAuditRole();
        // 超级管理员
        if (ifAdmin > 0) {
            rInstruction.setfActPersion("admin");
            // 当前用户存在审核角色
        }else if(isRole){
            rInstruction.setfActPersion("audit");
            // 当前用户没有审核角色
        }else{
            rInstruction.setfActPersion("com");
        }
        rInstruction.setfCreatePeople(userId);
        return rInstructionMapper.search(rInstruction);
    }

    /**
     * 新增调度指令
     *
     * @param rInstruction 调度指令
     * @return 结果
     */
    @Override
    @Transactional
    @Reservoir
    public AjaxResult insertRInstruction(RInstruction rInstruction) {
        int i = 0;
        rInstruction.setfCreateTime(new Date());
        rInstruction.setfCreatePeople(String.valueOf(SecurityUtils.getUserId()));
        // 默认有效
        rInstruction.setfStatus(Constant.GLOBAL_NUM_ONE);
        if (rInstruction.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            rInstruction.setfActStatus(Constant.GLOBAL_NUM_TWO);
            i = rInstructionMapper.insertRInstruction(rInstruction);
            return workFlowService.startWorkFlow(Long.valueOf(rInstruction.getfId()), "instruction");
        } else {
            rInstruction.setfActStatus(Constant.GLOBAL_NUM_ONE);
            i = rInstructionMapper.insertRInstruction(rInstruction);
        }
        return i > 0 ? AjaxResult.success("调度指令暂存成功") : AjaxResult.error("调度指令暂存失败");
    }

    /**
     * 修改调度指令
     *
     * @param rInstruction 调度指令
     * @return 结果
     */
    @Override
    public AjaxResult updateRInstruction(RInstruction rInstruction) {
        if (StringUtils.isBlank(rInstruction.getfActNode())) {
            rInstruction.setfActStatus(Constant.GLOBAL_NUM_TWO);
            rInstructionMapper.updateRInstruction(rInstruction);
            return workFlowService.startWorkFlow(Long.valueOf(rInstruction.getfId()), "instruction");
        } else if ("audit".equals(rInstruction.getfActNode())) {
            rInstruction.setfActStatus(Constant.GLOBAL_NUM_THREE);
            rInstructionMapper.updateRInstruction(rInstruction);
            return workFlowService.taskReview("instruction", String.valueOf(rInstruction.getfActId()), String.valueOf(Constant.GLOBAL_NUM_ONE), String.valueOf(rInstruction.getfId()));
        } else if ("approve".equals(rInstruction.getfActNode())) {
            rInstruction.setfActStatus(Constant.GLOBAL_NUM_FOUR);
            rInstruction.setfActPersion(null);
            rInstructionMapper.updateRInstruction(rInstruction);
            return workFlowService.taskReview("instruction", String.valueOf(rInstruction.getfActId()), String.valueOf(Constant.GLOBAL_NUM_ONE), String.valueOf(rInstruction.getfId()));
        }
        return AjaxResult.error("流程出错");
    }

    /**
     * 批量删除调度指令
     *
     * @param fInstructionIds 需要删除的调度指令 ID
     * @return 结果
     */
    @Override
    public int deleteRInstructionByIds(Integer[] fInstructionIds) {
        return rInstructionMapper.deleteRInstructionByIds(fInstructionIds);
    }

    /**
     * 删除调度指令 信息
     *
     * @param fInstructionId 调度指令 ID
     * @return 结果
     */
    @Override
    public int deleteRInstructionById(Integer fInstructionId) {
        return rInstructionMapper.deleteRInstructionById(fInstructionId);
    }
}
