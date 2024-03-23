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
import com.szsk.reservoir.security.domain.MCancellation;
import com.szsk.reservoir.security.mapper.MCancellationMapper;
import com.szsk.reservoir.security.service.IMCancellationService;
import com.szsk.reservoir.workflow.service.WorkFlowService;

/**
 * 水库大坝注销 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-14
 */
@Service
public class MCancellationServiceImpl implements IMCancellationService 
{
    @Resource
    private MCancellationMapper mCancellationMapper;
    @Autowired
    private WorkFlowService workFlowService;
    @Resource
    private SysTrainingMapper sysTrainingMapper;

    /**
     * 查询最近
     * 
     * @return 水库大坝注销
     */
    @Override
    @Reservoir
    public MCancellation getLatelyCancellation(MCancellation mCancellation)
    {
        return mCancellationMapper.getLatelyCancellation(mCancellation);
    }

    /**
     * 查询水库大坝注销
     *
     * @param fId 水库大坝注销 ID
     * @return 水库大坝注销
     */
    @Override
    public MCancellation selectMCancellationById(Long fId)
    {
        return mCancellationMapper.selectMCancellationById(fId);
    }

    /**
     * 查询水库大坝注销 列表
     * 
     * @param mCancellation 水库大坝注销 
     * @return 水库大坝注销 
     */
    @Override
    @Reservoir
    public List<MCancellation> selectMCancellationList(MCancellation mCancellation)
    {
        return mCancellationMapper.selectMCancellationList(mCancellation);
    }

    /**
     * 新增水库大坝注销 
     * 
     * @param mCancellation 水库大坝注销 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertMCancellation(MCancellation mCancellation)
    {
        return mCancellationMapper.insertMCancellation(mCancellation);
    }

    /**
     * 修改水库大坝注销 
     * 
     * @param mCancellation 水库大坝注销 
     * @return 结果
     */
    @Override
    public int updateMCancellation(MCancellation mCancellation)
    {
        return mCancellationMapper.updateMCancellation(mCancellation);
    }

    /**
     * 批量删除水库大坝注销 
     * 
     * @param fIds 需要删除的水库大坝注销 ID
     * @return 结果
     */
    @Override
    public int deleteMCancellationByIds(Long[] fIds)
    {
        return mCancellationMapper.deleteMCancellationByIds(fIds);
    }

    /**
     * 删除水库大坝注销 信息
     * 
     * @param fId 水库大坝注销 ID
     * @return 结果
     */
    @Override
    public int deleteMCancellationById(Long fId)
    {
        return mCancellationMapper.deleteMCancellationById(fId);
    }

    /**
     * 流程
     *
     * @param cancellation
     * @return 结果
     */
    @Override
    @Reservoir
    public AjaxResult nextCancellationInsert(MCancellation cancellation)
    {
        cancellation.setfReviewComments(null);
        cancellation.setfReviewResult(null);
        cancellation.setfReviewPeople(null);
        cancellation.setfReviewDate(null);
        cancellation.setfAuditComments(null);
        cancellation.setfAuditResult(null);
        cancellation.setfAuditPeople(null);
        cancellation.setfAuditDate(null);
        cancellation.setfActStatus(1);
        mCancellationMapper.insertMCancellation(cancellation);
        return workFlowService.startWorkFlow(cancellation.getfId(), "logout");
    }

    /**
     * 流程
     *
     * @param cancellation
     * @return 结果
     */
    @Override
    public AjaxResult nextCancellationUpdate(MCancellation cancellation)
    {
        MCancellation update = new MCancellation();
        update.setfId(cancellation.getfId());
        if (cancellation.getfActStatus() == 1) {
            AjaxResult logout = workFlowService.taskReview(
                    "logout",
                    cancellation.getfActId().toString(),
                    String.valueOf(cancellation.getfReviewResult()),
                    String.valueOf(cancellation.getfId())
            );
            update.setfReviewDate(cancellation.getfReviewDate());
            update.setfReviewComments(cancellation.getfReviewComments());
            update.setfReviewResult(cancellation.getfReviewResult());
            update.setfReviewPeople(cancellation.getfReviewPeople());
            if(cancellation.getfReviewResult() == 1){
                update.setfActStatus(2);
            }else{
                update.setfActStatus(0);
            }
            updateMCancellation(update);
            return logout;
        } else {
            AjaxResult logout = workFlowService.taskReview(
                    "logout",
                    cancellation.getfActId().toString(),
                    cancellation.getfAuditResult().toString(),
                    cancellation.getfId().toString()
            );
            update.setfAuditDate(cancellation.getfAuditDate());
            update.setfAuditComments(cancellation.getfAuditComments());
            update.setfAuditResult(cancellation.getfAuditResult());
            update.setfAuditPeople(cancellation.getfAuditPeople());
            if(cancellation.getfAuditResult() == 1){
                update.setfActStatus(3);
            }else{
                update.setfActStatus(0);
            }
            updateMCancellation(update);
            return logout;
        }
    }

    /**
     * dict
     *
     * @return 结果
     */
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
                result = sysTrainingMapper.queryDict("dam_material");
                map.put("dam_material", result);
                result = sysTrainingMapper.queryDict("dam_structure");
                map.put("dam_structure", result);

            }catch (Exception e){
                e.printStackTrace();
                throw new CustomException("数据初始化异常");
            }
            return AjaxResult.success(map);
        }
    }
}
