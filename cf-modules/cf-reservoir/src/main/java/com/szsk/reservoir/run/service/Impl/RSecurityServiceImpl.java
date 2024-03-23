package com.szsk.reservoir.run.service.Impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.system.api.RemoteDictService;
import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.core.utils.Constant;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.ruoyi.system.api.domain.SysFile;
import com.ruoyi.system.api.domain.SysUser;
import com.szsk.reservoir.run.domain.RSecurity;
import com.szsk.reservoir.run.mapper.RSecurityMapper;
import com.szsk.reservoir.run.service.IRSecurityService;
import com.szsk.reservoir.util.EasypoiUtils;
import com.szsk.reservoir.workflow.mapper.WorkFlowMapper;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 安全检查计划编制 Service业务层处理
 *
 * @author wangcc
 * @date 2021-08-10
 */
@Service
public class RSecurityServiceImpl  implements IRSecurityService
{
    @Resource
    private RSecurityMapper rSecurityMapper;

    @Autowired
    private WorkFlowService workFlowService;

    @Resource
    private WorkFlowMapper workFlowMappper;

    @Autowired
    private RemoteDictService remoteDictService;

    @Override
    @Transactional
    @Reservoir
    public AjaxResult planEditStartWorkFlow(RSecurity rSecurity) {
        rSecurity.setfStartPersion(String.valueOf(SecurityUtils.getUserId()));
        // 创建时间
        rSecurity.setCreateTime(new Date());
        // 默认为1：有效
        rSecurity.setfStatus(Constant.GLOBAL_NUM_ONE);
        // 1:暂存 2：待审核 3：待审批 4：计划流程完成 5：待上报 6：待上报 7：待处理 8：实施待审核 9：实施完成
        // HoldOrSubmit ！= 1时 暂存 存库 不走流程
        if (rSecurity.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            rSecurity.setfActStatus(Constant.GLOBAL_NUM_TWO);
        } else {
            rSecurity.setfActStatus(Constant.GLOBAL_NUM_ONE);
        }
        int i = rSecurityMapper.insertRSecurity(rSecurity);
        if (rSecurity.getHoldOrSubmit() == Constant.GLOBAL_NUM_ONE) {
            return workFlowService.startWorkFlow(Long.valueOf(rSecurity.getfId()),"security");
        }
        return i > 0 ? AjaxResult.success("计划编制暂存成功") : AjaxResult.error("计划编制暂存失败");
    }

    @Override
    @Reservoir
    public AjaxResult submit(RSecurity rSecurity) {
        // 提交流程fActStatus 改为2
        rSecurity.setfActStatus(Constant.GLOBAL_NUM_TWO);
        rSecurityMapper.updatePlanEdit(rSecurity);
        return workFlowService.startWorkFlow(Long.valueOf(rSecurity.getfId()),"security");
    }

    @Override
    @Transactional
    public AjaxResult planEditTaskReview(RSecurity rSecurity) {
        // 1:暂存 2：待审核 3：待审批 4：计划流程完成 5：待上报 6：待上报 7：待处理 8：实施待审核 9：实施完成
        if ("1".equals(rSecurity.getAuditStatus())) {
            rSecurity.setfActStatus(Constant.GLOBAL_NUM_THREE);
        }else if ("3".equals(rSecurity.getAuditStatus())) {
            rSecurity.setfActStatus(Constant.GLOBAL_NUM_ONE);
        }
        rSecurityMapper.updatePlanEdit(rSecurity);
        return workFlowService.taskReview("security",rSecurity.getfActId(),rSecurity.getAuditStatus(),String.valueOf(rSecurity.getfId()));
    }

    @Override
    @Transactional
    public AjaxResult planEditTaskApprove(RSecurity rSecurity) {
        //  1:暂存 2：待审核 3：待审批 4：计划流程完成 5：待上报 6：待上报 7：待处理 8：实施待审核 9：实施完成
        if ("1".equals(rSecurity.getAuditStatus())) {
            rSecurity.setfActStatus(Constant.GLOBAL_NUM_FOUR);
        }else if ("3".equals(rSecurity.getAuditStatus())) {
            rSecurity.setfActStatus(Constant.GLOBAL_NUM_ONE);
        }
        rSecurity.setfActPersion(null);
        rSecurityMapper.updatePlanEdit(rSecurity);
        return workFlowService.taskReview("security",rSecurity.getfActId(),rSecurity.getAuditStatus(),String.valueOf(rSecurity.getfId()));
    }

    @Override
    public AjaxResult queryUserList() {
        Long userId = SecurityUtils.getUserId();
        List<SysUser> sysUsers = rSecurityMapper.queryUserList(String.valueOf(userId));
        return AjaxResult.success(sysUsers);
    }

    @Override
    public AjaxResult queryBusiness(Long id) {
        // 业务信息
        RSecurity rSecurity = rSecurityMapper.queryPlanEdit(id);
        if (rSecurity != null) {
            SysFile fileInfo = rSecurityMapper.getFileInfo(Long.valueOf(rSecurity.getfPlanId()));
            rSecurity.setSysFile(fileInfo);
        }
        // 判断当前用户 是否是审核角色
        boolean auditRole = workFlowService.isAuditRole();
        if (auditRole) {
            // 获取当前登陆人角色
            rSecurity.setLandingPersonId("audit");
        }
        return AjaxResult.success(rSecurity);
    }

    @Override
    @Reservoir
    public List<RSecurity> queryPlanList(RSecurity rSecurity) {
        return rSecurityMapper.queryPlanList(rSecurity);
    }

    @Override
    public List<RSecurity> processComplete() {
        return rSecurityMapper.processComplete();
    }
    /**
     * 根据ID 查询 计划详情
     * @param getfId
     * @return
     */
	@Override
	public RSecurity selectRSecurityById(Long fId) {

		return rSecurityMapper.queryPlanEdit(fId);
	}

	/**
	 *
	 * @param response
	 * @param rSecurity
	 */
	@SuppressWarnings("unchecked")
	public void detailExport(HttpServletResponse response, RSecurity rSecurity) {


		final RSecurity objInfo = this.selectRSecurityById(rSecurity.getfId());
    	try {
			Map<String,Object> map = BeanUtils.describe(objInfo);

			//是否同意
			AjaxResult result  = remoteDictService.getDictDataInfo("sys_result");
			List<Map> yesNoResultList = (List<Map>)result.get("data");

			//计划类型
			result  = remoteDictService.getDictDataInfo("plan_type");
			List<Map>  planTypeList = (List<Map>)result.get("data");

			Map resultData = planTypeList.stream()
	        .filter(item -> item.get("dictValue").equals(objInfo.getfPlanType().toString()))
	        .findAny().orElse(null);
			map.put("fPlanType",resultData == null ?"":resultData.get("dictLabel") );

			//fEditTime
			map.put("fEditTime", DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD,objInfo.getfEditTime()));
			//fEditTime
			map.put("fAuditTime", DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD,objInfo.getfAuditTime()));
			//fApproveTime
			map.put("fApproveTime", DateUtils.parseDateToStr(DateUtils.YYYY_MM_DD,objInfo.getfApproveTime()));
			//fAuditResult
			resultData = yesNoResultList.stream()
			        .filter(item -> item.get("dictValue").equals(objInfo.getfAuditResult().toString()))
			        .findAny().orElse(null);
			map.put("fAuditResult",resultData == null ?"":resultData.get("dictLabel") );
			//fApproveResult
			resultData = yesNoResultList.stream()
			        .filter(item -> item.get("dictValue").equals(objInfo.getfApproveResult().toString()))
			        .findAny().orElse(null);
			map.put("fApproveResult",resultData == null ?"":resultData.get("dictLabel") );
			EasypoiUtils.exportExcelByTemplate(response, map, "xlsTemplate/security/安检查询-检修计划.xls");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
