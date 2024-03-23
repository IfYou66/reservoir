package com.szsk.reservoir.run.service.Impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szsk.reservoir.run.mapper.RCheckRecordMapper;
import com.szsk.reservoir.run.domain.RCheckRecord;
import com.szsk.reservoir.run.service.IRCheckRecordService;

/**
 * 安全检查记录 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
@Service
public class RCheckRecordServiceImpl implements IRCheckRecordService 
{
    @Autowired
    private RCheckRecordMapper rCheckRecordMapper;

    /**
     * 查询安全检查记录 
     * 
     * @param fId 安全检查记录 ID
     * @return 安全检查记录 
     */
    @Override
    public RCheckRecord selectRCheckRecordById(Long fId)
    {
        return rCheckRecordMapper.selectRCheckRecordById(fId);
    }

    /**
     * 查询安全检查记录 列表
     * 
     * @param rCheckRecord 安全检查记录 
     * @return 安全检查记录 
     */
    @Override
    public List<RCheckRecord> selectRCheckRecordList(RCheckRecord rCheckRecord)
    {
        return rCheckRecordMapper.selectRCheckRecordList(rCheckRecord);
    }

    /**
     * 新增安全检查记录 
     * 
     * @param rCheckRecord 安全检查记录 
     * @return 结果
     */
    @Override
    public int insertRCheckRecord(RCheckRecord rCheckRecord)
    {
        return rCheckRecordMapper.insertRCheckRecord(rCheckRecord);
    }

    @Override
    /**
     * 批量新增安全检查记录
     * @param recordList
     * @return
     */
    public int batchAdd(List<RCheckRecord> recordList) {
        return rCheckRecordMapper.batchAdd(recordList);
    }

    /**
     * 修改安全检查记录 
     * 
     * @param rCheckRecord 安全检查记录 
     * @return 结果
     */
    @Override
    public int updateRCheckRecord(RCheckRecord rCheckRecord)
    {
        return rCheckRecordMapper.updateRCheckRecord(rCheckRecord);
    }

    /**
     * 批量删除安全检查记录 
     * 
     * @param fIds 需要删除的安全检查记录 ID
     * @return 结果
     */
    @Override
    public int deleteRCheckRecordByIds(Long[] fIds)
    {
        return rCheckRecordMapper.deleteRCheckRecordByIds(fIds);
    }

    /**
     * 删除安全检查记录 信息
     * 
     * @param fId 安全检查记录 ID
     * @return 结果
     */
    @Override
    public int deleteRCheckRecordById(Long fId)
    {
        return rCheckRecordMapper.deleteRCheckRecordById(fId);
    }

    @Override
    public List<RCheckRecord> getMusterBySecuimpId(Long fSecuimpId) {
        return rCheckRecordMapper.getMusterBy(fSecuimpId);
    }
}
