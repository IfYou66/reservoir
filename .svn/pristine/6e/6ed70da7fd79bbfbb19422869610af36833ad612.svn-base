package com.szsk.reservoir.fundManage.service.impl;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.exception.CustomException;
import com.ruoyi.common.core.utils.Constant;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.fundManage.domain.SysFundApply;
import com.szsk.reservoir.fundManage.mapper.SysFundApplyMapper;
import com.szsk.reservoir.fundManage.service.ISysFundApplyService;
import com.szsk.reservoir.manageSystem.mapper.SysTrainingMapper;
import com.szsk.reservoir.run.mapper.RSecurityMapper;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 经费申请 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-18
 */
@Service
public class SysFundApplyServiceImpl implements ISysFundApplyService {
    @Resource
    private SysFundApplyMapper sysFundApplyMapper;

    @Resource
    private WorkFlowService workFlowService;

    @Resource
    private SysTrainingMapper sysTrainingMapper;

    @Resource
    private RSecurityMapper rSecurityMapper;

    /**
     * 查询经费申请
     *
     * @param fId 经费申请 ID
     * @return 经费申请
     */
    @Override
    public SysFundApply selectSysFundApplyById(Long fId) {
        return sysFundApplyMapper.selectSysFundApplyById(fId);
    }

    /**
     * 查询经费申请 列表
     *
     * @param sysFundApply 经费申请
     * @return 经费申请
     */
    @Override
    @Reservoir
    public List<SysFundApply> selectSysFundApplyList(SysFundApply sysFundApply) {
        // 判断是否为管理员角色  管理员角色查询全部列表
        int ifAdmin = rSecurityMapper.ifAdmin(String.valueOf(SecurityUtils.getUserId()));
        // 查询是否存在审核角色
        boolean isRole = workFlowService.isAuditRole();
        // 超级管理员
        if (ifAdmin > 0) {
            sysFundApply.setfActPersion("admin");
            // 当前用户存在审核角色
        }else if(isRole){
            sysFundApply.setfActPersion("audit");
            // 当前用户没有审核角色
        }else{
            sysFundApply.setfActPersion("com");
        }
        sysFundApply.setfCreatePeople(SecurityUtils.getUserId());
        return sysFundApplyMapper.search(sysFundApply);
    }

    /**
     * 新增经费申请
     *
     * @param sysFundApply 经费申请
     * @return 结果
     */
    @Override
    @Transactional
    @Reservoir
    public AjaxResult insertSysFundApply(SysFundApply sysFundApply) {
        sysFundApply.setfCreatePeople(SecurityUtils.getUserId());
        sysFundApply.setfCreateTime(new Date());
        if (sysFundApply.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            sysFundApply.setfActStatus(Constant.GLOBAL_NUM_TWO);
        } else {
            sysFundApply.setfActStatus(Constant.GLOBAL_NUM_ONE);
        }
        int i = sysFundApplyMapper.insertSysFundApply(sysFundApply);
        if (sysFundApply.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            return workFlowService.startWorkFlow(sysFundApply.getfId(), "apply");
        }
        return i > 0 ? AjaxResult.success("经费申请暂存成功") : AjaxResult.error("经费申请暂存失败");
    }

    /**
     * 修改经费申请
     *
     * @param sysFundApply 经费申请
     * @return 结果
     */
    @Override
    @Transactional
    public AjaxResult updateSysFundApply(SysFundApply sysFundApply) {
        if (StringUtils.isBlank(sysFundApply.getfActNode())) {
            sysFundApply.setfActStatus(Constant.GLOBAL_NUM_TWO);
            sysFundApplyMapper.updateSysFundApply(sysFundApply);
            return workFlowService.startWorkFlow(sysFundApply.getfId(), "apply");
        } else if (sysFundApply.getfActNode().equals("audit")) {
            // 审核结果为通过时 继续流程
            if (sysFundApply.getfReviewResult() == Constant.GLOBAL_NUM_ONE) {
                sysFundApply.setfActStatus(Constant.GLOBAL_NUM_THREE);
            } else if (sysFundApply.getfReviewResult() == Constant.GLOBAL_NUM_THREE) {
                // 审核结果为驳回时(3) 状态改为待提交
                sysFundApply.setfActStatus(Constant.GLOBAL_NUM_ONE);
            }
            sysFundApplyMapper.updateSysFundApply(sysFundApply);
            return workFlowService.taskReview("apply", String.valueOf(sysFundApply.getfActId()), String.valueOf(sysFundApply.getfReviewResult()), String.valueOf(sysFundApply.getfId()));
        } else if (sysFundApply.getfActNode().equals("approve")) {
            // 审批结果为通过时继续走流程
            if (sysFundApply.getfAuditResult() == Constant.GLOBAL_NUM_ONE) {
                sysFundApply.setfActStatus(Constant.GLOBAL_NUM_FOUR);
            } else if (sysFundApply.getfAuditResult() == Constant.GLOBAL_NUM_THREE) {
                // 审批结果为驳回时 状态改为待提交
                sysFundApply.setfActStatus(Constant.GLOBAL_NUM_ONE);
            }
            // 最后流程把下节点人制空
            sysFundApply.setfActPersion(null);
            sysFundApplyMapper.updateSysFundApply(sysFundApply);
            return workFlowService.taskReview("apply", String.valueOf(sysFundApply.getfActId()), String.valueOf(sysFundApply.getfAuditResult()), String.valueOf(sysFundApply.getfId()));
        }
        return AjaxResult.error("流程出错");
    }

    /**
     * 批量删除经费申请
     *
     * @param fIds 需要删除的经费申请 ID
     * @return 结果
     */
    @Override
    public int deleteSysFundApplyByIds(Long[] fIds) {
        return sysFundApplyMapper.deleteSysFundApplyByIds(fIds);
    }

    /**
     * 删除经费申请 信息
     *
     * @param fId 经费申请 ID
     * @return 结果
     */
    @Override
    public int deleteSysFundApplyById(Long fId) {
        return sysFundApplyMapper.deleteSysFundApplyById(fId);
    }

    /**
     * 数据字典数据
     *
     * @return
     */
    public AjaxResult inquiry() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<SysDictData> result = sysTrainingMapper.queryDict("sys_result");
            map.put("result", result);
        } catch (Exception e) {
            e.printStackTrace();
            throw new CustomException("数据初始化异常");
        }
        return AjaxResult.success(map);
    }

}
