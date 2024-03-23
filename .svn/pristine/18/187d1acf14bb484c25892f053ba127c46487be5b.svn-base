package com.szsk.reservoir.manageSystem.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.alibaba.nacos.shaded.io.grpc.netty.shaded.io.netty.util.internal.ObjectUtil;
import com.mysql.cj.protocol.Security;
import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.exception.CustomException;
import com.ruoyi.common.core.utils.Constant;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.manageSystem.domain.SysJoinTraining;
import com.szsk.reservoir.manageSystem.mapper.SysJoinTrainingMapper;
import com.szsk.reservoir.run.mapper.RSecurityMapper;
import com.szsk.reservoir.workflow.service.WorkFlowService;
import org.springframework.stereotype.Service;
import com.szsk.reservoir.manageSystem.mapper.SysTrainingMapper;
import com.szsk.reservoir.manageSystem.domain.SysTraining;
import com.szsk.reservoir.manageSystem.service.ISysTrainingService;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * 培训Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-13
 */
@Service
@Transactional
public class SysTrainingServiceImpl implements ISysTrainingService {
    @Resource
    private SysTrainingMapper sysTrainingMapper;

    @Resource
    private SysJoinTrainingMapper sysJoinTrainingMapper;

    @Resource
    private WorkFlowService workFlowService;

    @Resource
    private RSecurityMapper rSecurityMapper;

    /**
     * 查询培训
     *
     * @param fId 培训ID
     * @return 培训
     */
    @Override
    public SysTraining selectSysTrainingById(Long fId) {
        return sysTrainingMapper.selectSysTrainingById(fId);
    }

    /**
     * 查询培训列表
     *
     * @param sysTraining 培训
     * @return 培训
     */
    @Override
    @Reservoir
    public List<SysTraining> selectSysTrainingList(SysTraining sysTraining) {
        String userId = String.valueOf(SecurityUtils.getUserId());
        // 判断是否为管理员角色  管理员角色查询全部列表
        int ifAdmin = rSecurityMapper.ifAdmin(userId);
        // 查询是否存在审核角色
        boolean isRole = workFlowService.isAuditRole();
        // 超级管理员
        if (ifAdmin > 0) {
            sysTraining.setfActPersion("admin");
            // 当前用户存在审核角色
        }else if(isRole){
            sysTraining.setfActPersion("audit");
            // 当前用户没有审核角色
        }else{
            sysTraining.setfActPersion("com");
        }
        sysTraining.setfCreatePeople(userId);
        return sysTrainingMapper.search(sysTraining);
    }

    /**
     * 新增培训
     *
     * @param sysTraining 培训
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertSysTraining(SysTraining sysTraining) {
        // getHoldOrSubmit 如果getHoldOrSubmit是0 只存数据 如果为1 存入数据启动流程
        sysTraining.setfCreateTime(new Date());
        sysTraining.setfCreatePeople(String.valueOf(SecurityUtils.getUserId()));
        sysTraining.setfStatus(Constant.GLOBAL_NUM_ONE);
        if (sysTraining.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            sysTraining.setfActStatus(Constant.GLOBAL_NUM_TWO);
        } else {
            sysTraining.setfActStatus(Constant.GLOBAL_NUM_ONE);
        }
        sysTrainingMapper.insertSysTraining(sysTraining);
        for (SysJoinTraining joinTraining : sysTraining.getJoinTrainingList()) {
            joinTraining.setfTrainingId(sysTraining.getfId());
            joinTraining.setfTarTime(sysTraining.getfTraTime());
        }
        if (sysTraining.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            workFlowService.startWorkFlow(sysTraining.getfId(), "training");
        }
        return sysJoinTrainingMapper.bulkInsert(sysTraining.getJoinTrainingList());
    }

    /**
     * 修改培训
     *
     * @param sysTraining 培训
     * @return 结果
     */
    @Override
    public AjaxResult updateSysTraining(SysTraining sysTraining) {
        if (StringUtils.isBlank(sysTraining.getfActNode())) {
            // 启动流程fActStatus改为2
            sysTraining.setfActStatus(Constant.GLOBAL_NUM_TWO);
            sysTrainingMapper.updateSysTraining(sysTraining);
            return workFlowService.startWorkFlow(sysTraining.getfId(), "training");
        } else if (sysTraining.getfActNode().equals("audit")) {
            if (sysTraining.getfReviewResult() == Constant.GLOBAL_NUM_ONE) {
                sysTraining.setfActStatus(Constant.GLOBAL_NUM_THREE);
            } else if (sysTraining.getfReviewResult() == Constant.GLOBAL_NUM_THREE){
                // 审核驳回状态改为待提交
                sysTraining.setfActStatus(Constant.GLOBAL_NUM_ONE);
            }
            sysTrainingMapper.updateSysTraining(sysTraining);
            return workFlowService.taskReview("training", String.valueOf(sysTraining.getfActId()), String.valueOf(sysTraining.getfReviewResult()), String.valueOf(sysTraining.getfId()));
        } else if (sysTraining.getfActNode().equals("approve")) {
            if (sysTraining.getfAuditResult() == Constant.GLOBAL_NUM_ONE) {
                sysTraining.setfActStatus(Constant.GLOBAL_NUM_FOUR);
            } else if (sysTraining.getfAuditResult() == Constant.GLOBAL_NUM_THREE){
                // 审批驳回时状态改为待提交
                sysTraining.setfActStatus(Constant.GLOBAL_NUM_ONE);
            }
            sysTrainingMapper.updateSysTraining(sysTraining);
            return workFlowService.taskReview("training", String.valueOf(sysTraining.getfActId()), String.valueOf(sysTraining.getfAuditResult()), String.valueOf(sysTraining.getfId()));
        } else if (sysTraining.getfActNode().equals("impl")) {
            sysTraining.setfActStatus(Constant.GLOBAL_NUM_FIVES);
            sysTrainingMapper.updateSysTraining(sysTraining);
            return workFlowService.taskReview("training", String.valueOf(sysTraining.getfActId()), "1", String.valueOf(sysTraining.getfId()));
        } else if (sysTraining.getfActNode().equals("score")) {
            sysTraining.setfActStatus(Constant.GLOBAL_NUM_SIX);
            // 最后流程把下节点人制空
            sysTraining.setfActPersion(null);
            sysTrainingMapper.updateSysTraining(sysTraining);
            return workFlowService.taskReview("training", String.valueOf(sysTraining.getfActId()),"1", String.valueOf(sysTraining.getfId()));
        }
        return AjaxResult.error("流程出错");
    }

    /**
     * 批量删除培训
     *
     * @param fIds 需要删除的培训ID
     * @return 结果
     */
    @Override
    public int deleteSysTrainingByIds(Long[] fIds) {
        return sysTrainingMapper.deleteSysTrainingByIds(fIds);
    }

    /**
     * 删除培训信息
     *
     * @param fId 培训ID
     * @return 结果
     */
    @Override
    public int deleteSysTrainingById(Long fId) {
        return sysTrainingMapper.deleteSysTrainingById(fId);
    }

    @Override
    public AjaxResult queryDataDictionary() {
        Map<String, Object> map = new HashMap<>();
        try {
            // 查询字典
            List<SysDictData> gender = sysTrainingMapper.queryDict("sys_user_sex");
            map.put("gender", gender);

            List<SysDictData> politicalStatus = sysTrainingMapper.queryDict("sys_political_outlook");
            map.put("politicalStatus", politicalStatus);

            List<SysDictData> education = sysTrainingMapper.queryDict("sys_education");
            map.put("education", education);

            List<SysDictData> assessMode = sysTrainingMapper.queryDict("sys_assess_mode");
            map.put("assessMode", assessMode);

            List<SysDictData> result = sysTrainingMapper.queryDict("sys_result");
            map.put("result", result);

        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("数据初始化异常");
        }
        return AjaxResult.success(map);
    }

    @Override
    public AjaxResult dataQuery(String dictType) {
        List<SysDictData> list = sysTrainingMapper.queryDict(dictType);
        return AjaxResult.success(list);
    }

}
