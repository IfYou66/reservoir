package com.szsk.reservoir.run.service;

import java.util.List;
import com.szsk.reservoir.run.domain.RInstructionRunLog;

import javax.swing.*;

/**
 * 调度指令执行记录 Service接口
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
public interface IRInstructionRunLogService 
{
    /**
     * 查询调度指令执行记录 
     * 
     * @param fLogId 调度指令执行记录 ID
     * @return 调度指令执行记录 
     */
    public RInstructionRunLog selectRInstructionRunLogById(Integer fLogId);

    /**
     * 查询调度指令执行记录 列表
     * 
     * @param rInstructionRunLog 调度指令执行记录 
     * @return 调度指令执行记录 集合
     */
    public List<RInstructionRunLog> selectRInstructionRunLogList(RInstructionRunLog rInstructionRunLog);

    /**
     * 新增调度指令执行记录 
     * 
     * @param rInstructionRunLog 调度指令执行记录 
     * @return 结果
     */
    public int insertRInstructionRunLog(RInstructionRunLog rInstructionRunLog);


    /**
     * 批量新增调度指令执行记录
     * @param rInstructionRunLog
     * @return
     */
    public int batchDeposit(List<RInstructionRunLog> rInstructionRunLog);

    /**
     * 修改调度指令执行记录 
     * 
     * @param rInstructionRunLog 调度指令执行记录 
     * @return 结果
     */
    public int updateRInstructionRunLog(RInstructionRunLog rInstructionRunLog);

    /**
     * 批量删除调度指令执行记录 
     * 
     * @param fLogIds 需要删除的调度指令执行记录 ID
     * @return 结果
     */
    public int deleteRInstructionRunLogByIds(Integer[] fLogIds);

    /**
     * 删除调度指令执行记录 信息
     * 
     * @param fLogId 调度指令执行记录 ID
     * @return 结果
     */
    public int deleteRInstructionRunLogById(Integer fLogId);
}
