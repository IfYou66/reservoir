package com.szsk.reservoir.run.mapper;

import java.util.List;

import com.szsk.reservoir.run.domain.RCheckRecord;
import com.szsk.reservoir.run.domain.REventRecord;

/**
 * 事件记录 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
public interface REventRecordMapper 
{
    /**
     * 查询事件记录 
     * 
     * @param fId 事件记录 ID
     * @return 事件记录 
     */
    public REventRecord selectREventRecordById(Long fId);

    /**
     * 根据安全检查实施表id获取时间记录集合
     * @param fSecuimpId
     * @return
     */
    public List<REventRecord> getListBySecuimpId(Long fSecuimpId);


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
     * 删除事件记录 
     * 
     * @param fId 事件记录 ID
     * @return 结果
     */
    public int deleteREventRecordById(Long fId);

    /**
     * 批量删除事件记录 
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteREventRecordByIds(Long[] fIds);
}
