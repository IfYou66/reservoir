package com.szsk.reservoir.run.service;

import java.util.List;
import com.szsk.reservoir.run.domain.REventRecord;

/**
 * 事件记录 Service接口
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
public interface IREventRecordService 
{
    /**
     * 查询事件记录 
     * 
     * @param fId 事件记录 ID
     * @return 事件记录 
     */
    public REventRecord selectREventRecordById(Long fId);

    /**
     * 查询事件记录 列表
     * 
     * @param rEventRecord 事件记录 
     * @return 事件记录 集合
     */
    public List<REventRecord> selectREventRecordList(REventRecord rEventRecord);

    /**
     * 新增事件记录 
     * 
     * @param rEventRecord 事件记录 
     * @return 结果
     */
    public int insertREventRecord(REventRecord rEventRecord);

    /**
     * 修改事件记录 
     * 
     * @param rEventRecord 事件记录 
     * @return 结果
     */
    public int updateREventRecord(REventRecord rEventRecord);

    /**
     * 批量删除事件记录 
     * 
     * @param fIds 需要删除的事件记录 ID
     * @return 结果
     */
    public int deleteREventRecordByIds(Long[] fIds);

    /**
     * 删除事件记录 信息
     * 
     * @param fId 事件记录 ID
     * @return 结果
     */
    public int deleteREventRecordById(Long fId);
}
