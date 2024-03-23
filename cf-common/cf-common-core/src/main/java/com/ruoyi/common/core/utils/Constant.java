package com.ruoyi.common.core.utils;

public class Constant {

    // security: 安全检查计划编制表
    // 安全检查计划编制表
    public static final String TABLENAME_A_PLAN_EDIT = "r_security";
    // 安全检查计划编制流程表ID
    public static final String WORKFLOW_INSTION_INSTRUCTIONS = "instruction";

    // training: 培训表
    // 培训表
    public static final String TABLENAME_SYS_TRAINING = "sys_training";
    // 培训表流程表ID
    public static final String WORKFLOW_INSTION_TRAINING = "training";

    //register
    // 注册表
    public static final String TABLENAME_M_ENGINEERING_INFORMATION = "m_engineering_information";

    // logout
    // 注销表
    public static final String TABLENAME_M_CANCELLATION = "m_cancellation";

    // apply
    // 经费申请
    public static final String TABLENAME_SYS_FUND_APPLY = "sys_fund_apply";

    // expend
    // 经费支出
    public static final String TABLENAME_SYS_FUND_EXPEND = "sys_fund_expend";

    // appraisal
    // 安全鉴定
    public static final String TABLENAME_M_SAFETY_APPRAISAL = "m_safety_appraisal";

    // reinforcement
    // 除险加固
    public static final String TABLENAME_M_REINFORCEMENT = "m_reinforcement";

    // secuimpl
    // 安全检查实施
    public static final String TABLENAME_R_SECU_IMPL = "r_secu_impl";
    // 安全检查实施流程表ID
    public static final String WORKFLOW_INSTION_SECURITYIMPL = "securityimpl";

    // instruction
    // 指令接收
    public static final String TABLENAME_R_INSTRUCTION = "r_instruction";

    // maintenance
    // 维修养护计划编制
    public static final String TABLENAME_R_MAINTENANCE = "r_maintenance";

    // mainimpl
    // 维修养护计划实施
    public static final String TABLENAME_R_MAIN_IMPL = "r_main_impl";
    // 维修养护实施流程表ID
    public static final String WORKFLOW_INSTION_MAINIMPL = "mainimpl";


    // proreport
    // 项目申报表
    public static final String TABLENAME_R_PRO_REPORT = "r_pro_report";
    // 项目申报
    public static final String WORKFLOW_INSTION_PROREPORT = "proreport";

    // control
    // 控制运行计划编制表
    public static final String TABLENAME_R_CONTROL = "r_control";

    // controlimpl
    // 控制运行计划实施表
    public static final String TABLENAME_R_CONTROL_IMPL = "r_control_impl";

    // 全局通用长量
    public static final int GLOBAL_NUM_ZEROR = 0;
    public static final int GLOBAL_NUM_ONE = 1;
    public static final int GLOBAL_NUM_TWO = 2;
    public static final int GLOBAL_NUM_THREE = 3;
    public static final int GLOBAL_NUM_FOUR  = 4;
    public static final int GLOBAL_NUM_FIVES = 5;
    public static final int GLOBAL_NUM_SIX = 6;
    public static final int GLOBAL_NUM_SEVEN = 7;
    public static final int GLOBAL_NUM_EIGHT = 8;
    public static final int GLOBAL_NUM_NINE = 9;
    
    /**
     * Reservoir 水库默认设置项
     */
    public static final String DEFAULT_RESERVOIR_ADMIN_PASSWORD = "123456";
    public static final Long[] DEFAULT_RESERVOIR_ADMIN_ROLE_IDS = {2L};//系统默认角色
    public static final Long[] DEFAULT_RESERVOIR_ADMIN_POST_IDS = {1L};//系统默认岗位
    public static final Long DEFAULT_RESERVOIR_ADMIN_DEPT_ID = 100L;//系统默认部门
    
    
}
