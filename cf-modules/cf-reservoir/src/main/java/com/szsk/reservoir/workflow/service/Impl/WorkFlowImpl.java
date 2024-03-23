package com.szsk.reservoir.workflow.service.Impl;

import com.ruoyi.common.core.utils.Constant;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.workflow.domain.RoleVO;
import com.szsk.reservoir.workflow.mapper.WorkFlowMapper;
import com.szsk.reservoir.workflow.service.WorkFlowService;
import org.activiti.engine.IdentityService;
import org.activiti.engine.RuntimeService;
import org.activiti.engine.TaskService;
import org.activiti.engine.impl.persistence.entity.ExecutionEntity;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

/**
 * @author: wangcc
 * @create: 2021/8/9 18:00
 * @description:
 **/
@Service
public class WorkFlowImpl implements WorkFlowService {

    public final static String ASSIGNEE_ROLE = "audit";


    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private IdentityService identityservice;

    @Autowired
    private TaskService taskService;

    @Resource
    private WorkFlowMapper workFlowMappper;

    public Map<String,Object> getTableAndFlow(Map<String,Object> params){
        String flag = String.valueOf(params.get("flag"));
            // 安全检查计划编制
        if ("security".equals(flag)) {
            params.put("tableName", Constant.TABLENAME_A_PLAN_EDIT);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
            // 培训
        }else if("training".equals(flag)){
            params.put("tableName", Constant.TABLENAME_SYS_TRAINING);
            params.put("activitiId",Constant.WORKFLOW_INSTION_TRAINING);
            // 注册
        }else if("register".equals(flag)){
            params.put("tableName", Constant.TABLENAME_M_ENGINEERING_INFORMATION);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
            // 注销
        }else if("logout".equals(flag)){
            params.put("tableName", Constant.TABLENAME_M_CANCELLATION);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
        }else if("apply".equals(flag)){
            params.put("tableName", Constant.TABLENAME_SYS_FUND_APPLY);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
        }else if("expend".equals(flag)){
            params.put("tableName", Constant.TABLENAME_SYS_FUND_EXPEND);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
            // 安全鉴定
        }else if ("appraisal".equals(flag)){
            params.put("tableName", Constant.TABLENAME_M_SAFETY_APPRAISAL);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
            // 除险加固
        }else if("reinforcement".equals(flag)){
            params.put("tableName", Constant.TABLENAME_M_REINFORCEMENT);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
            // 安全检查实施
        }else if("secuimpl".equals(flag)){
            params.put("tableName", Constant.TABLENAME_R_SECU_IMPL);
            params.put("activitiId",Constant.WORKFLOW_INSTION_SECURITYIMPL);
            // 指令接收
        }else if("instruction".equals(flag)){
            params.put("tableName", Constant.TABLENAME_R_INSTRUCTION);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
            // 维修养护计划编制
        }else if("maintenance".equals(flag)){
            params.put("tableName", Constant.TABLENAME_R_MAINTENANCE);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
            // 维修养护计划实施
        }else if("mainimpl".equals(flag)){
            params.put("tableName", Constant.TABLENAME_R_MAIN_IMPL);
            params.put("activitiId",Constant.WORKFLOW_INSTION_MAINIMPL);
            // 项目申报
        }else if ("proreport".equals(flag)) {
            params.put("tableName", Constant.TABLENAME_R_PRO_REPORT);
            params.put("activitiId",Constant.WORKFLOW_INSTION_PROREPORT);
            // 控制运行计划编制
        }else if ("control".equals(flag)) {
            params.put("tableName", Constant.TABLENAME_R_CONTROL);
            params.put("activitiId",Constant.WORKFLOW_INSTION_INSTRUCTIONS);
        }else if ("controlimpl".equals(flag)){
            params.put("tableName", Constant.TABLENAME_R_CONTROL_IMPL);
            params.put("activitiId",Constant.WORKFLOW_INSTION_MAINIMPL);
        }
        return params;
    }

    /**
     * 启动流程
     * flag : 控制流程表
     * actStatus 1：已提交 2：审核中 3：驳回 4：审核完成
     * activitiId :流程图ID
     * processId : 流程ID
     * businessKey ： 业务ID
     * actPersion : 当前节点处理人
     * @return
     */
    @Override
    public AjaxResult startWorkFlow(Long id,String flag) {
        // 业务表ID
        String businessKey = String.valueOf(id);
        if (StringUtils.isBlank(businessKey)) {
            return AjaxResult.error("业务ID不能为空！");
        }

        Map<String,Object> params = new HashMap<String,Object>();
        params.put("flag",flag);
        params.put("assignee",ASSIGNEE_ROLE);
        params.put("businessKey",id);
        getTableAndFlow(params);

        // 获取当前登录人的Id 说明是当前登陆人发起的流程
        Long userId = SecurityUtils.getUserId();
        // 为的是查询 act_hi_procinst 的 start_user_id不为空
        identityservice.setAuthenticatedUserId(String.valueOf(userId));
        // 流程图ID
        String activitiId = String.valueOf(params.get("activitiId"));
        if (StringUtils.isBlank(activitiId)) {
            return AjaxResult.error("工作流图ID不能为空！");
        }
        try {
            // 启动流程接口
            ProcessInstance process = this.runtimeService.startProcessInstanceByKey(activitiId,businessKey,params);
            params.put("processId",process.getId());
            params.put("actPersion",ASSIGNEE_ROLE);

            int update = updateBillTable(params);
            if (update > 0) {
                return AjaxResult.success("提交成功");
            }
            return AjaxResult.error("提交失败！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("流程提交异常！");
        }
    }


    /**
     * 流程审核
     * actStatus 1：已提交 2：审核中 3：驳回 4：审核完成
     * activitiId :流程图ID
     * userName : 当前登陆人用户名
     * processId : 流程ID
     * auditStatus : 审核状态 1：同意 2：不同意 3：驳回
     * actPersion : 当前节点处理人
     * status ： 0失效 1有效
     * @return
     */
    @Override
    public AjaxResult taskReview(String flag,String processId,String auditStatus,String businessKey) {
        if (StringUtils.isBlank(flag)) {
            return AjaxResult.error("flag表名定义参数不能为空！");
        }
        // 流程ID
        if (StringUtils.isBlank(processId)) {
            return AjaxResult.error("流程ID不能为空！");
        }
        // 审核状态 1：同意 2：不同意 3：驳回
        if (StringUtils.isBlank(auditStatus)) {
            return AjaxResult.error("审核状态不能为空！");
        }
        // 业务表ID
        if (StringUtils.isBlank(businessKey)) {
            return AjaxResult.error("业务ID不能为空！");
        }
        // 查询当前登录人否存在审核角色，如果有则返回true，没有返回false
        boolean isRole = isAuditRole();
        if (!isRole) {
            return AjaxResult.error("当前登录用户没有审核权限！");
        }
        Map<String,Object> params = new HashMap<String,Object>();
        // 下一环节处理人
        // params.put("assignee",ASSIGNEE_ROLE);
        params.put("flag",flag);
        params.put("businessKey",businessKey);
        params.put("processId",processId);
        // 流程图ID
        getTableAndFlow(params);

        try {
            // 查询当前用户的所有任务列表 查看是否有需要处理得任务
            Task task = taskService.createTaskQuery()
                    // 任务名称 流程图得ID
                    .processDefinitionKey(String.valueOf(params.get("activitiId")))
                    // 当前环节处理人的 角色key
                    .taskAssignee(ASSIGNEE_ROLE)
                    .processInstanceId(processId)
                    .singleResult();
            if (task == null) {
                return AjaxResult.error("用户："+ SecurityUtils.getUsername() +",当前没有要处理的任务！");
            }

            // 1：同意 2：不同意 3：回退到发起的节点
            if ("1".equals(auditStatus)) {
                //处理任务,结合当前用户任务列表的查询操作,任务ID:task.getId()
                taskService.complete(task.getId(),params);
                // params.put("actPersion",assignee);
                //System.out.println("当前任务处理成功：任务ID"+task.getId()+"审批结果以及下一环节处理人："+params);
            } else if ("2".equals(auditStatus)) {
                // 不同意 则删除流程
                runtimeService.deleteProcessInstance(processId,"删除流程");
                params.put("status",0);
            } else if ("3".equals(auditStatus)) {
                // 回退到流程发起的节点
                runtimeService.deleteProcessInstance(processId,"退回流程发起人");
                params.put("actPersion",null);
            }
            // 业务表更新
            int update = updateBillTable(params);
            if (update > 0) {
                return AjaxResult.success("任务处理成功！");
            }
            return AjaxResult.error("任务处理失败！");
        }catch (Exception e){
            e.printStackTrace();
            return AjaxResult.error("流程处理异常！");
        }
    }

    /**
     * 查询流程任务
     * @param activitiId 流程图片Id
     * @return
     */
    @Override
    public ProcessInstance queryReviewTask(String activitiId,String processId) {
        // 当前登陆人用户名
        Long userId = SecurityUtils.getUserId();
        try {
            // 查询当前用户的所有任务列表 查看是否有需要处理得任务
             Task task = taskService.createTaskQuery()
                    // 任务名称 流程图得ID
                    .processDefinitionKey(activitiId)
                     .processInstanceId(processId)
                    // 当前环节处理人的userName
                    // .taskAssignee(String.valueOf(userId))
                    .singleResult();
             if (task == null) {
                 return null;
             }
            return runtimeService.createProcessInstanceQuery().processInstanceId(task.getProcessInstanceId())
                    .singleResult();
        }catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }


    /**
     * 更新业务表 更新关于业务表中流程的字段信息
     * @param params
     * @return
     */
    public int updateBillTable(Map<String,Object> params){
        String actId = String.valueOf(params.get("processId"));
        // String auditStatus = String.valueOf(params.get("auditStatus"));
        // 查询当前用户的任务
        Task task = taskService.createTaskQuery()
                // 任务名称 流程图得ID
                .processDefinitionKey(String.valueOf(params.get("activitiId")))
                .processInstanceId(actId)
                .singleResult();
        // 如果没有任务 则把节点制空 回到编制的节点
        if (task == null) {
            params.put("actNode","");
        }else{
            ExecutionEntity execution = (ExecutionEntity) runtimeService.createExecutionQuery().executionId(task.getExecutionId()).singleResult();
            // 节点信息 控制前端页面显示
            String actNode = execution.getActivityId();
            params.put("actNode",actNode);
        }
        // 流程ID
        params.put("actId",actId);
        // 业务表更新
        return workFlowMappper.updateBusinessActiviti(params);
    }

    /**
     * 判断当前用户是否存在审核角色
     * @return
     */
    public boolean isAuditRole(){
        // 查询当前登录人否存在审核角色，如果有则返回true，没有返回false
        return workFlowMappper.getRoles(SecurityUtils.getUserId()).stream().anyMatch(item -> ASSIGNEE_ROLE.equals(item.getRoleKey()));
    }

    @Override
    public List<RoleVO> getRoles() {
        return workFlowMappper.getRoles(SecurityUtils.getUserId());
    }
}
