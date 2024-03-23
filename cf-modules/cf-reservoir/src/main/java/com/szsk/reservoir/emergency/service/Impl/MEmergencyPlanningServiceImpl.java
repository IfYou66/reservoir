package com.szsk.reservoir.emergency.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.emergency.domain.MEmergencyPlanning;
import com.szsk.reservoir.emergency.mapper.MEmergencyPlanningMapper;
import com.szsk.reservoir.emergency.service.IMEmergencyPlanningService;
import com.szsk.reservoir.workflow.service.WorkFlowService;


/**
 * 水库预案编制 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-18
 */
@Service
public class MEmergencyPlanningServiceImpl implements IMEmergencyPlanningService {

    @Resource
    private MEmergencyPlanningMapper mEmergencyPlanningMapper;

    @Autowired
    private WorkFlowService workFlowService;

    /**
     * 查询水库预案编制
     *
     * @param fId 水库预案编制 ID
     * @return 水库预案编制
     */
    @Override
    public MEmergencyPlanning selectMEmergencyPlanningById(Long fId)
    {
        return mEmergencyPlanningMapper.selectMEmergencyPlanningById(fId);
    }

    /**
     * 查询水库预案编制 列表
     *
     * @param mEmergencyPlanning 水库预案编制
     * @return 水库预案编制
     */
    @Override
    @Reservoir
    public List<MEmergencyPlanning> selectMEmergencyPlanningList(MEmergencyPlanning mEmergencyPlanning)
    {
        return mEmergencyPlanningMapper.selectMEmergencyPlanningList(mEmergencyPlanning);
    }

    /**
     * 新增水库预案编制
     *
     * @param mEmergencyPlanning 水库预案编制
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertMEmergencyPlanning(MEmergencyPlanning mEmergencyPlanning)
    {
        int i= mEmergencyPlanningMapper.insertMEmergencyPlanning(mEmergencyPlanning);
        //当流的状态 为 提交时 使用流
        if(mEmergencyPlanning.getfActStatus() == 1) {
            //工作流节点 接口
            // 业务ID 下节点处理人 “register”
            workFlowService.startWorkFlow(mEmergencyPlanning.getfId(),"register");
        }
        return i;
    }

    /**
     * 修改水库预案编制
     *
     * @param mEmergencyPlanning 水库预案编制
     * @return 结果
     */
    @Override
    public int updateMEmergencyPlanning(MEmergencyPlanning mEmergencyPlanning)
    {
        //根据提交状态 判断下一步的流程
        //若提交状态为 2 => 即通过审核
        if(mEmergencyPlanning.getfActStatus() == 1) {
            // 指定字符  下一节点处理人  处理状态  业务的ID  流程的ID
            workFlowService.taskReview("register", mEmergencyPlanning.getfActNode(), "1",mEmergencyPlanning.getfId().toString());
        }
        //若提交状态为 2 => 即通过审批
        else if(mEmergencyPlanning.getfActStatus() == 2) {
            workFlowService.taskReview("register", mEmergencyPlanning.getfActNode(),"2",mEmergencyPlanning.getfId().toString());
        }
        //若提交状态为3 => 即通过发布
        else if(mEmergencyPlanning.getfActStatus() == 3) {
            workFlowService.taskReview("register", mEmergencyPlanning.getfActNode(),"3",mEmergencyPlanning.getfId().toString());
        }
        //若提交状态为4 => 即通过演练
        else if(mEmergencyPlanning.getfActStatus() == 4) {
            workFlowService.taskReview("register", mEmergencyPlanning.getfActNode(),"4",mEmergencyPlanning.getfId().toString());
        }
        //若提交状态为5 => 即通过执行
        else if(mEmergencyPlanning.getfActStatus() == 5) {
            workFlowService.taskReview("register", mEmergencyPlanning.getfActNode(),"5",mEmergencyPlanning.getfId().toString());
        }
        //若提交状态为 7 => 即驳回修改
        else if(mEmergencyPlanning.getfActStatus() == 7){
            workFlowService.taskReview("register", mEmergencyPlanning.getfActNode(),"7",mEmergencyPlanning.getfId().toString());
        }
        //若提交状态为 8 => 审核 未通过
        else if(mEmergencyPlanning.getfActStatus() == 8){
            workFlowService.taskReview("register", mEmergencyPlanning.getfActNode(),"8",mEmergencyPlanning.getfId().toString());
        }

        return mEmergencyPlanningMapper.updateMEmergencyPlanning(mEmergencyPlanning);
    }

    /**
     * 批量删除水库预案编制
     *
     * @param fIds 需要删除的水库预案编制 ID
     * @return 结果
     */
    @Override
    public int deleteMEmergencyPlanningByIds(Long[] fIds)
    {
        return mEmergencyPlanningMapper.deleteMEmergencyPlanningByIds(fIds);
    }

    /**
     * 删除水库预案编制 信息
     *
     * @param fId 水库预案编制 ID
     * @return 结果
     */
    @Override
    public int deleteMEmergencyPlanningById(Long fId)
    {
        return mEmergencyPlanningMapper.deleteMEmergencyPlanningById(fId);
    }

    /**
     * 根据预案编制类型查询数据字典
     * @param dictType
     * @return
     */
    @Override
    public AjaxResult dataQuery(String dictType) {
        List<SysDictData> sysDictData = mEmergencyPlanningMapper.dataQuery(dictType);
        return AjaxResult.success(sysDictData);
    }
}
