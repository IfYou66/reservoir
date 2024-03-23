package com.szsk.reservoir.security.mapper;

import java.util.List;

import com.szsk.reservoir.security.domain.MBorder;

/**
 * 工程划界 Mapper接口
 * 
 * @author wangcc
 * @date 2021-08-23
 */
public interface MBorderMapper
{
    // 查询地图坐标
    public List<MBorder> queryLabelList(MBorder mBorder);
    /**
     * 查询工程划界
     * 
     * @param fId 工程划界 ID
     * @return 工程划界
     */
    public MBorder selectMBorderById(Long fId);
    /**
     * 新增工程划界 
     * 
     * @param MBorder 工程划界 
     * @return 结果
     */
    public int insertMBorder(MBorder mBorder);

    /**
     * 修改工程划界 
     * 
     * @param MBorder 工程划界 
     * @return 结果
     */
    public int updateMBorder(MBorder mBorder);
}
