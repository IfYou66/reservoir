package com.szsk.reservoir.security.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.security.domain.MEngineeringInformation;
import com.szsk.reservoir.security.mapper.MEngineeringInformationMapper;
import com.szsk.reservoir.security.service.IMEngineeringInformationService;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 水库大坝工程基本信息 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-14
 */
@Service
public class MEngineeringInformationServiceImpl implements IMEngineeringInformationService {

    @Autowired
    private MEngineeringInformationMapper mEngineeringInformationMapper;

    @Autowired
    private WorkFlowService workFlowService;
    /**
     * 查询水库大坝工程基本信息
     *
     * @param fId 水库大坝工程基本信息 ID
     * @return 水库大坝工程基本信息
     */
    @Override
    public MEngineeringInformation selectMEngineeringInformationById(Long fId)
    {
        return mEngineeringInformationMapper.selectMEngineeringInformationById(fId);
    }

    /**
     * 查询水库大坝工程基本信息 列表
     *
     * @param mEngineeringInformation 水库大坝工程基本信息
     * @return 水库大坝工程基本信息
     */
    @Reservoir
    public List<MEngineeringInformation> selectMEngineeringInformationList(MEngineeringInformation mEngineeringInformation)
    {
        return mEngineeringInformationMapper.selectMEngineeringInformationList(mEngineeringInformation);
    }

    /**
     * 新增水库大坝工程基本信息
     *
     * @param mEngineeringInformation 水库大坝工程基本信息
     * @return 结果
     */
    @Transactional
    @Reservoir
    public int insertMEngineeringInformation(MEngineeringInformation mEngineeringInformation)
    {
        int i = mEngineeringInformationMapper.insertMEngineeringInformation(mEngineeringInformation);
        Long aLong = mEngineeringInformation.getfId();
        //工作流节点 接口
        workFlowService.startWorkFlow(aLong,mEngineeringInformation.getNextParameter());
        return i;
    }

    /**
     * 修改水库大坝工程基本信息
     *
     * @param mEngineeringInformation 水库大坝工程基本信息
     * @return 结果
     */
    @Transactional
    @Override
    public int updateMEngineeringInformation(MEngineeringInformation mEngineeringInformation)
    {
        //根据提交状态 判断下一步的流程
        //若提交状态为 2 => 即通过审核
        if(mEngineeringInformation.getfActStatus() == 2) {
            // 指定字符  下一节点处理人  处理状态  业务的ID  流程的ID
            workFlowService.taskReview("register", mEngineeringInformation.getfActNode(),  "2",mEngineeringInformation.getfActId() + "");
        }
        //若提交状态为 3 => 即通过审批
        else if(mEngineeringInformation.getfActStatus() == 3) {
            workFlowService.taskReview("register", mEngineeringInformation.getfActNode(),"3",mEngineeringInformation.getfActId() + "");
        }
        //若提交状态为 4 => 即驳回修改
        else if(mEngineeringInformation.getfActStatus() == 4){
            workFlowService.taskReview("register", mEngineeringInformation.getfActNode(), "4",mEngineeringInformation.getfActId() + "");
        }

        return mEngineeringInformationMapper.updateMEngineeringInformation(mEngineeringInformation);
    }

    /**
     * 批量删除水库大坝工程基本信息
     *
     * @param fIds 需要删除的水库大坝工程基本信息 ID
     * @return 结果
     */
    @Override
    public int deleteMEngineeringInformationByIds(Long[] fIds)
    {
        return mEngineeringInformationMapper.deleteMEngineeringInformationByIds(fIds);
    }

    /**
     * 删除水库大坝工程基本信息 信息
     *
     * @param fId 水库大坝工程基本信息 ID
     * @return 结果
     */
    @Override
    public int deleteMEngineeringInformationById(Long fId)
    {
        return mEngineeringInformationMapper.deleteMEngineeringInformationById(fId);
    }
}
