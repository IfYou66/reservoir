package com.szsk.reservoir.run.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szsk.reservoir.run.mapper.REventProcessMapper;
import com.szsk.reservoir.run.domain.REventProcess;
import com.szsk.reservoir.run.service.IREventProcessService;

/**
 * 事件处置Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
@Service
public class REventProcessServiceImpl implements IREventProcessService 
{
    @Autowired
    private REventProcessMapper rEventProcessMapper;

    /**
     * 查询事件处置
     * 
     * @param fId 事件处置ID
     * @return 事件处置
     */
    @Override
    public REventProcess selectREventProcessById(Long fId)
    {
        return rEventProcessMapper.selectREventProcessById(fId);
    }

    /**
     * 查询事件处置列表
     * 
     * @param rEventProcess 事件处置
     * @return 事件处置
     */
    @Override
    public List<REventProcess> selectREventProcessList(REventProcess rEventProcess)
    {
        return rEventProcessMapper.getListByImplId(rEventProcess.getfImplId());
    }

    /**
     * 新增事件处置
     * 
     * @param rEventProcess 事件处置
     * @return 结果
     */
    @Override
    public int insertREventProcess(REventProcess rEventProcess)
    {
        return rEventProcessMapper.insertREventProcess(rEventProcess);
    }

    /**
     * 修改事件处置
     * 
     * @param rEventProcess 事件处置
     * @return 结果
     */
    @Override
    public int updateREventProcess(REventProcess rEventProcess)
    {
        return rEventProcessMapper.updateREventProcess(rEventProcess);
    }

    /**
     * 批量删除事件处置
     * 
     * @param fIds 需要删除的事件处置ID
     * @return 结果
     */
    @Override
    public int deleteREventProcessByIds(Long[] fIds)
    {
        return rEventProcessMapper.deleteREventProcessByIds(fIds);
    }

    /**
     * 删除事件处置信息
     * 
     * @param fId 事件处置ID
     * @return 结果
     */
    @Override
    public int deleteREventProcessById(Long fId)
    {
        return rEventProcessMapper.deleteREventProcessById(fId);
    }
}
