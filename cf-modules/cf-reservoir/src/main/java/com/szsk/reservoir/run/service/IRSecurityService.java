package com.szsk.reservoir.run.service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.run.domain.RSecurity;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

/**
 * 安全检查计划编制 Service接口
 * 
 * @author wangcc
 * @date 2021-08-10
 */
public interface IRSecurityService 
{
    // 发起流程
   public AjaxResult planEditStartWorkFlow(RSecurity rSecurity);
    // 提交流程接口
   public AjaxResult submit(RSecurity rSecurity);
    // 流程审核
   public AjaxResult planEditTaskReview(RSecurity rSecurity);
    // 流程审批
   public AjaxResult planEditTaskApprove(RSecurity rSecurity);
    // 查询用户列表
   public AjaxResult queryUserList();
    // 查询业务表信息
   public AjaxResult queryBusiness(Long id);
    // 安检查询列表
   public List<RSecurity> queryPlanList(RSecurity rSecurity);
    // 查询流程完成的
   public List<RSecurity> processComplete();
   /**
    * 根据ID 查询 计划详情
    * @param getfId
    * @return
    */
   public RSecurity selectRSecurityById(Long fId);
   /**
    * 
    * @param response
    * @param rSecurity
    */
   public void detailExport(HttpServletResponse response, RSecurity rSecurity);
}
