package com.szsk.reservoir.run.service;

import java.util.List;
import com.szsk.reservoir.run.domain.REventProcess;

/**
 * 事件处置Service接口
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
public interface IREventProcessService 
{
    /**
     * 查询事件处置
     * 
     * @param fId 事件处置ID
     * @return 事件处置
     */
    public REventProcess selectREventProcessById(Long fId);

    /**
     * 查询事件处置列表
     * 
     * @param rEventProcess 事件处置
     * @return 事件处置集合
     */
    public List<REventProcess> selectREventProcessList(REventProcess rEventProcess);

    /**
     * 新增事件处置
     * 
     * @param rEventProcess 事件处置
     * @return 结果
     */
    public int insertREventProcess(REventProcess rEventProcess);

    /**
     * 修改事件处置
     * 
     * @param rEventProcess 事件处置
     * @return 结果
     */
    public int updateREventProcess(REventProcess rEventProcess);

    /**
     * 批量删除事件处置
     * 
     * @param fIds 需要删除的事件处置ID
     * @return 结果
     */
    public int deleteREventProcessByIds(Long[] fIds);

    /**
     * 删除事件处置信息
     * 
     * @param fId 事件处置ID
     * @return 结果
     */
    public int deleteREventProcessById(Long fId);
}
