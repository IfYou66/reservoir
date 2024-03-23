package com.szsk.reservoir.workflow.service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.workflow.domain.RoleVO;
import org.activiti.engine.runtime.ProcessInstance;

import java.util.List;


/**
 * @author: wangcc
 * @create: 2021/8/9 17:59
 * @description: 工作流
 **/
public interface WorkFlowService {

    /**
     * 流程启动接口
     * @id 业务ID
     * assignee下一环节处理人
     * flag控制表状态
     * @return
     */
    public AjaxResult startWorkFlow(Long id,String flag);

    /**
     * 审核
     * processId 流程ID
     * auditStatus 1：同意 2：不同意 3：回退到发起的节点
     * businessKey ： 业务ID
     * flag:定义的表名
     * @param
     * @return
     */
    public AjaxResult taskReview(String flag,String processId,String auditStatus,String businessKey);

    /**
     * 查询审核任务
     * @param activitiId
     * @return
     */
    public ProcessInstance queryReviewTask(String activitiId,String processId);

    /**
     * 判断当前用户是否存在审核角色
     * @return
     */
    public boolean isAuditRole();

    /**
     * 获取角色列表
     * @return
     */
    public List<RoleVO> getRoles();
}
