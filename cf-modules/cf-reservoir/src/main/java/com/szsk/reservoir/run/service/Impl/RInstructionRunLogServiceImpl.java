package com.szsk.reservoir.run.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szsk.reservoir.run.mapper.RInstructionRunLogMapper;
import com.szsk.reservoir.run.domain.RInstructionRunLog;
import com.szsk.reservoir.run.service.IRInstructionRunLogService;

/**
 * 调度指令执行记录 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
@Service
public class RInstructionRunLogServiceImpl implements IRInstructionRunLogService 
{
    @Autowired
    private RInstructionRunLogMapper rInstructionRunLogMapper;

    /**
     * 查询调度指令执行记录 
     * 
     * @param fLogId 调度指令执行记录 ID
     * @return 调度指令执行记录 
     */
    @Override
    public RInstructionRunLog selectRInstructionRunLogById(Integer fLogId)
    {
        return rInstructionRunLogMapper.selectRInstructionRunLogById(fLogId);
    }

    /**
     * 查询调度指令执行记录 列表
     * 
     * @param rInstructionRunLog 调度指令执行记录 
     * @return 调度指令执行记录 
     */
    @Override
    public List<RInstructionRunLog> selectRInstructionRunLogList(RInstructionRunLog rInstructionRunLog)
    {
        return rInstructionRunLogMapper.selectRInstructionRunLogList(rInstructionRunLog);
    }

    /**
     * 新增调度指令执行记录 
     * 
     * @param rInstructionRunLog 调度指令执行记录 
     * @return 结果
     */
    @Override
    public int insertRInstructionRunLog(RInstructionRunLog rInstructionRunLog)
    {
        return rInstructionRunLogMapper.insertRInstructionRunLog(rInstructionRunLog);
    }

    @Override
    public int batchDeposit(List<RInstructionRunLog> rInstructionRunLog) {
        return rInstructionRunLogMapper.batchDeposit(rInstructionRunLog);
    }

    /**
     * 修改调度指令执行记录 
     * 
     * @param rInstructionRunLog 调度指令执行记录 
     * @return 结果
     */
    @Override
    public int updateRInstructionRunLog(RInstructionRunLog rInstructionRunLog)
    {
        return rInstructionRunLogMapper.updateRInstructionRunLog(rInstructionRunLog);
    }

    /**
     * 批量删除调度指令执行记录 
     * 
     * @param fLogIds 需要删除的调度指令执行记录 ID
     * @return 结果
     */
    @Override
    public int deleteRInstructionRunLogByIds(Integer[] fLogIds)
    {
        return rInstructionRunLogMapper.deleteRInstructionRunLogByIds(fLogIds);
    }

    /**
     * 删除调度指令执行记录 信息
     * 
     * @param fLogId 调度指令执行记录 ID
     * @return 结果
     */
    @Override
    public int deleteRInstructionRunLogById(Integer fLogId)
    {
        return rInstructionRunLogMapper.deleteRInstructionRunLogById(fLogId);
    }
}
