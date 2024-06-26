package com.szsk.reservoir.fundManage.service.impl;

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
import com.szsk.reservoir.fundManage.domain.SysFundExpend;
import com.szsk.reservoir.fundManage.mapper.SysFundExpendMapper;
import com.szsk.reservoir.fundManage.service.ISysFundExpendService;
import com.szsk.reservoir.run.mapper.RSecurityMapper;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 经费支出 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-18
 */
@Service
public class SysFundExpendServiceImpl implements ISysFundExpendService {
    @Resource
    private SysFundExpendMapper sysFundExpendMapper;

    @Resource
    private WorkFlowService workFlowService;

    @Resource
    private RSecurityMapper rSecurityMapper;

    /**
     * 查询经费支出
     *
     * @param fId 经费支出 ID
     * @return 经费支出
     */
    @Override
    public SysFundExpend selectSysFundExpendById(Long fId) {
        return sysFundExpendMapper.selectSysFundExpendById(fId);
    }

    /**
     * 查询经费支出 列表
     *
     * @param sysFundExpend 经费支出
     * @return 经费支出
     */
    @Override
    @Reservoir
    public List<SysFundExpend> selectSysFundExpendList(SysFundExpend sysFundExpend) {
        // 判断是否为管理员角色  管理员角色查询全部列表
        int ifAdmin = rSecurityMapper.ifAdmin(String.valueOf(SecurityUtils.getUserId()));
        // 查询是否存在审核角色
        boolean isRole = workFlowService.isAuditRole();
        // 超级管理员
        if (ifAdmin > 0) {
            sysFundExpend.setfActPersion("admin");
            // 当前用户存在审核角色
        }else if(isRole){
            sysFundExpend.setfActPersion("audit");
            // 当前用户没有审核角色
        }else{
            sysFundExpend.setfActPersion("com");
        }
        sysFundExpend.setfCreatePeople(SecurityUtils.getUserId());
        return sysFundExpendMapper.search(sysFundExpend);
    }

    /**
     * 新增经费支出
     *
     * @param sysFundExpend 经费支出
     * @return 结果
     */
    @Override
    @Transactional
    @Reservoir
    public AjaxResult insertSysFundExpend(SysFundExpend sysFundExpend) {
        sysFundExpend.setfCreateTime(new Date());
        sysFundExpend.setfCreatePeople(SecurityUtils.getUserId());
        // getHoldOrSubmit == 1 执行流程
        if (sysFundExpend.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            sysFundExpend.setfActStatus(Constant.GLOBAL_NUM_TWO);
        } else {
            sysFundExpend.setfActStatus(Constant.GLOBAL_NUM_ONE);
        }
        int i = sysFundExpendMapper.insertSysFundExpend(sysFundExpend);
        if (sysFundExpend.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            return workFlowService.startWorkFlow(sysFundExpend.getfId(), "expend");
        }
        return i > 0 ? AjaxResult.success("经费指出申请暂存成功") : AjaxResult.error("经费支出申请暂存失败");
    }

    /**
     * 修改经费支出
     *
     * @param sysFundExpend 经费支出
     * @return 结果
     */
    @Override
    public AjaxResult updateSysFundExpend(SysFundExpend sysFundExpend) {
        if (StringUtils.isBlank(sysFundExpend.getfActNode())) {
            sysFundExpend.setfActStatus(Constant.GLOBAL_NUM_TWO);
            sysFundExpendMapper.updateSysFundExpend(sysFundExpend);
            return workFlowService.startWorkFlow(sysFundExpend.getfId(), "expend");
        } else if (sysFundExpend.getfActNode().equals("audit")) {
            // 审核结果为通过时 继续流程
            if (sysFundExpend.getfReviewResult() == Constant.GLOBAL_NUM_ONE) {
                sysFundExpend.setfActStatus(Constant.GLOBAL_NUM_THREE);
            } else if (sysFundExpend.getfReviewResult() == Constant.GLOBAL_NUM_THREE) {
                // 审核结果为驳回时(3) 状态改为待提交
                sysFundExpend.setfActStatus(Constant.GLOBAL_NUM_ONE);
            }
            sysFundExpendMapper.updateSysFundExpend(sysFundExpend);
            return workFlowService.taskReview("expend", String.valueOf(sysFundExpend.getfActId()), String.valueOf(sysFundExpend.getfReviewResult()), String.valueOf(sysFundExpend.getfId()));
        } else if (sysFundExpend.getfActNode().equals("approve")) {
            // 审批结果为通过时继续走流程
            if (sysFundExpend.getfAuditResult() == Constant.GLOBAL_NUM_ONE) {
                sysFundExpend.setfActStatus(Constant.GLOBAL_NUM_FOUR);
            } else if (sysFundExpend.getfAuditResult() == Constant.GLOBAL_NUM_THREE) {
                // 审批结果为驳回时 状态改为待提交
                sysFundExpend.setfActStatus(Constant.GLOBAL_NUM_ONE);
            }
            // 最后流程把下节点人制空
            sysFundExpend.setfActPersion(null);
            sysFundExpendMapper.updateSysFundExpend(sysFundExpend);
            return workFlowService.taskReview("expend", String.valueOf(sysFundExpend.getfActId()), String.valueOf(sysFundExpend.getfReviewResult()), String.valueOf(sysFundExpend.getfId()));
        }
        return AjaxResult.error("流程出错");
    }

    /**
     * 批量删除经费支出
     *
     * @param fIds 需要删除的经费支出 ID
     * @return 结果
     */
    @Override
    public int deleteSysFundExpendByIds(Long[] fIds) {
        return sysFundExpendMapper.deleteSysFundExpendByIds(fIds);
    }

    /**
     * 删除经费支出 信息
     *
     * @param fId 经费支出 ID
     * @return 结果
     */
    @Override
    public int deleteSysFundExpendById(Long fId) {
        return sysFundExpendMapper.deleteSysFundExpendById(fId);
    }
}
