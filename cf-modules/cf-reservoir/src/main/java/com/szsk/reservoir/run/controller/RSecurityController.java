package com.szsk.reservoir.run.controller;


import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.beanutils.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.szsk.reservoir.run.domain.RSecurity;
import com.szsk.reservoir.run.service.IRSecurityService;
import com.szsk.reservoir.workflow.service.WorkFlowService;


/**
 * @author: wangcc
 * @create: 2021/8/11 14:00
 * @description:
 **/
@RestController
@RequestMapping("planEdit")
public class RSecurityController extends BaseController {

    @Autowired
    private IRSecurityService iRSecurityService;

    @Autowired
    private WorkFlowService workFlowService;

    /**
     * 发起流程
     * @param rSecurity
     * @return
     */
    @PostMapping("/startWorkFlow")
    public AjaxResult startWorkFlow(@RequestBody RSecurity rSecurity){
        return iRSecurityService.planEditStartWorkFlow(rSecurity);
    }

    /**
     * 提交流程
     * @param rSecurity
     * @return
     */
    @PostMapping("/submit")
    public AjaxResult submit(@RequestBody RSecurity rSecurity){
        return iRSecurityService.submit(rSecurity);
    }


    /**
     * 流程审核
     * @param rSecurity
     * @return
     */
    @PostMapping("/taskReview")
    public AjaxResult taskReview(@RequestBody RSecurity rSecurity){
        return iRSecurityService.planEditTaskReview(rSecurity);
    }

    /**
     * 流程审批
     * @param rSecurity
     * @return
     */
    @PostMapping("/taskApprove")
    public AjaxResult taskApprove(@RequestBody RSecurity rSecurity){

        return iRSecurityService.planEditTaskApprove(rSecurity);
    }

    /**
     * 查询业务详情信息
     * @return
     */
    @PostMapping("/getReviewTask")
    public AjaxResult queryReviewTask(@RequestBody RSecurity rSecurity){
        return iRSecurityService.queryBusiness(Long.valueOf(rSecurity.getfId()));
    }

    /**
     * 获取用户列表
     * @return
     */
    @PostMapping("/getUserList")
    public AjaxResult queryUserList(){
        return iRSecurityService.queryUserList();
    }

    /**
     * 获取安检查询列表
     * @return
     */
    @GetMapping("/getPlanList")
    public TableDataInfo queryPlanList(RSecurity rSecurity){
        List<RSecurity> rSecuritys = iRSecurityService.queryPlanList(rSecurity);
        // 判断当前用户 是否是审核角色
        boolean auditRole = workFlowService.isAuditRole();
        if (auditRole) {
            for (RSecurity security : rSecuritys) {
                // 获取当前登陆人
                security.setLandingPersonId("audit");
            }
        }
        return getDataTable(rSecuritys);
    }

    @GetMapping("/processComplete")
    public AjaxResult processComplete() {
        List<RSecurity> rSecurities = iRSecurityService.processComplete();
        return AjaxResult.success(rSecurities);
    }

    /**
     * 导出安检检查计划
     */
    @SuppressWarnings("unchecked")
	@Log(title = "安检检查计划导出", businessType = BusinessType.EXPORT)
    @PostMapping("/detailExport")
    public void detailExport(HttpServletResponse response, RSecurity rSecurity) throws IOException
    {

    	iRSecurityService.detailExport(response,rSecurity);


    }

}
