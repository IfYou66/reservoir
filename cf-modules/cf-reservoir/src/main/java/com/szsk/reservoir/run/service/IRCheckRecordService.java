package com.szsk.reservoir.run.service;

import java.util.List;
import com.szsk.reservoir.run.domain.RCheckRecord;

/**
 * 安全检查记录 Service接口
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
public interface IRCheckRecordService 
{
    /**
     * 查询安全检查记录 
     * 
     * @param fId 安全检查记录 ID
     * @return 安全检查记录 
     */
    public RCheckRecord selectRCheckRecordById(Long fId);

    /**
     * 查询安全检查记录 列表
     * 
     * @param rCheckRecord 安全检查记录 
     * @return 安全检查记录 集合
     */
    public List<RCheckRecord> selectRCheckRecordList(RCheckRecord rCheckRecord);

    /**
     * 新增安全检查记录 
     * 
     * @param rCheckRecord 安全检查记录 
     * @return 结果
     */
    public int insertRCheckRecord(RCheckRecord rCheckRecord);

    /**
     * 批量新增安全检查记录
     * @param recordList
     * @return
     */
    public int batchAdd(List<RCheckRecord> recordList);

    /**
     * 修改安全检查记录 
     * 
     * @param rCheckRecord 安全检查记录 
     * @return 结果
     */
    public int updateRCheckRecord(RCheckRecord rCheckRecord);

    /**
     * 批量删除安全检查记录 
     * 
     * @param fIds 需要删除的安全检查记录 ID
     * @return 结果
     */
    public int deleteRCheckRecordByIds(Long[] fIds);

    /**
     * 删除安全检查记录 信息
     * 
     * @param fId 安全检查记录 ID
     * @return 结果
     */
    public int deleteRCheckRecordById(Long fId);


    /**
     * 根据安全检查实施表id获取安全检查记录集合
     * @param fSecuimpId
     * @return
     */
    public List<RCheckRecord> getMusterBySecuimpId(Long fSecuimpId);

}
