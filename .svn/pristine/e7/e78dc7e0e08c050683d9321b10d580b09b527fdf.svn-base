package com.szsk.reservoir.security.service.Impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.exception.CustomException;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.manageSystem.mapper.SysTrainingMapper;
import com.szsk.reservoir.security.domain.MSafetyAppraisal;
import com.szsk.reservoir.security.mapper.MSafetyAppraisalMapper;
import com.szsk.reservoir.security.service.IMSafetyAppraisalService;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 水库大坝安全鉴定一览 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-17
 */
@Service
public class MSafetyAppraisalServiceImpl implements IMSafetyAppraisalService 
{
    @Resource
    private MSafetyAppraisalMapper mSafetyAppraisalMapper;
    @Resource
    private SysTrainingMapper sysTrainingMapper;
    @Autowired
    private WorkFlowService workFlowService;

    /**
     * 查询水库大坝安全鉴定一览 
     * 
     * @param fId 水库大坝安全鉴定一览 ID
     * @return 水库大坝安全鉴定一览 
     */
    @Override
    public MSafetyAppraisal selectMSafetyAppraisalById(Long fId)
    {
        return mSafetyAppraisalMapper.selectMSafetyAppraisalById(fId);
    }

    /**
     * 查询水库大坝安全鉴定一览 列表
     * 
     * @param mSafetyAppraisal 水库大坝安全鉴定一览 
     * @return 水库大坝安全鉴定一览 
     */
    @Override
    @Reservoir
    public List<MSafetyAppraisal> selectMSafetyAppraisalList(MSafetyAppraisal mSafetyAppraisal)
    {
        return mSafetyAppraisalMapper.selectMSafetyAppraisalList(mSafetyAppraisal);
    }

    /**
     * 新增水库大坝安全鉴定一览 
     * 
     * @param mSafetyAppraisal 水库大坝安全鉴定一览 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertMSafetyAppraisal(MSafetyAppraisal mSafetyAppraisal)
    {
        return mSafetyAppraisalMapper.insertMSafetyAppraisal(mSafetyAppraisal);
    }

    /**
     * 修改水库大坝安全鉴定一览 
     * 
     * @param mSafetyAppraisal 水库大坝安全鉴定一览 
     * @return 结果
     */
    @Override
    public int updateMSafetyAppraisal(MSafetyAppraisal mSafetyAppraisal)
    {
        return mSafetyAppraisalMapper.updateMSafetyAppraisal(mSafetyAppraisal);
    }

    /**
     * 批量删除水库大坝安全鉴定一览 
     * 
     * @param fIds 需要删除的水库大坝安全鉴定一览 ID
     * @return 结果
     */
    @Override
    public int deleteMSafetyAppraisalByIds(Long[] fIds)
    {
        return mSafetyAppraisalMapper.deleteMSafetyAppraisalByIds(fIds);
    }

    /**
     * 删除水库大坝安全鉴定一览 信息
     * 
     * @param fId 水库大坝安全鉴定一览 ID
     * @return 结果
     */
    @Override
    public int deleteMSafetyAppraisalById(Long fId)
    {
        return mSafetyAppraisalMapper.deleteMSafetyAppraisalById(fId);
    }

    /**
     * 获取最近
     *
     * @return 结果
     */
    @Override
    @Reservoir
    public MSafetyAppraisal latelySafetyAppraisal(MSafetyAppraisal mSafetyAppraisal)
    {
        return mSafetyAppraisalMapper.latelySafetyAppraisal(mSafetyAppraisal);
    }

    @Override
    public AjaxResult getDictByType()
    {
        {
            Map<String,Object> map = new HashMap<>();
            try {
                // 查询字典
                List<SysDictData> result;
                result = sysTrainingMapper.queryDict("sys_result");
                map.put("result", result);
            }catch (Exception e){
                e.printStackTrace();
                throw new CustomException("数据初始化异常");
            }
            return AjaxResult.success(map);
        }
    }

    /**
     * 流程
     *
     * @param mSafetyAppraisal
     * @return 结果
     */
    @Override
    @Reservoir
    public AjaxResult startWorkFlow(MSafetyAppraisal mSafetyAppraisal)
    {
        mSafetyAppraisal.setfReviewComments(null);
        mSafetyAppraisal.setfReviewResult(null);
        mSafetyAppraisal.setfReviewPeople(null);
        mSafetyAppraisal.setfReviewDate(null);
        mSafetyAppraisal.setfAuditComments(null);
        mSafetyAppraisal.setfAuditResult(null);
        mSafetyAppraisal.setfAuditPeople(null);
        mSafetyAppraisal.setfAuditDate(null);
        mSafetyAppraisal.setfActStatus(1);
        mSafetyAppraisalMapper.insertMSafetyAppraisal(mSafetyAppraisal);
        return workFlowService.startWorkFlow(mSafetyAppraisal.getfId(), "appraisal");
    }
    @Override
    public AjaxResult taskReview(MSafetyAppraisal mSafetyAppraisal)
    {
        AjaxResult appraisal;
        MSafetyAppraisal update = new MSafetyAppraisal();
        update.setfId(mSafetyAppraisal.getfId());
        if (mSafetyAppraisal.getfActStatus() == 1) {
            appraisal = workFlowService.taskReview(
                    "appraisal",
                    mSafetyAppraisal.getfActId().toString(),
                    String.valueOf(mSafetyAppraisal.getfReviewResult()),
                    String.valueOf(mSafetyAppraisal.getfId())
            );
            if(mSafetyAppraisal.getfReviewResult() == 1){
                update.setfActStatus(2);
            }else{
                update.setfActStatus(0);
            }
            update.setfReviewDate(mSafetyAppraisal.getfReviewDate());
            update.setfReviewComments(mSafetyAppraisal.getfReviewComments());
            update.setfReviewResult(mSafetyAppraisal.getfReviewResult());
            update.setfReviewPeople(mSafetyAppraisal.getfReviewPeople());
            updateMSafetyAppraisal(update);
            return appraisal;
        } else {
            appraisal = workFlowService.taskReview(
                    "appraisal",
                    mSafetyAppraisal.getfActId().toString(),
                    mSafetyAppraisal.getfAuditResult().toString(),
                    mSafetyAppraisal.getfId().toString()
            );
            if(mSafetyAppraisal.getfAuditResult() == 1){
                update.setfActStatus(3);
            }else{
                update.setfActStatus(0);
            }
            update.setfAuditDate(mSafetyAppraisal.getfAuditDate());
            update.setfAuditComments(mSafetyAppraisal.getfAuditComments());
            update.setfAuditResult(mSafetyAppraisal.getfAuditResult());
            update.setfAuditPeople(mSafetyAppraisal.getfAuditPeople());
            updateMSafetyAppraisal(update);
            return appraisal;
        }
    }
}
