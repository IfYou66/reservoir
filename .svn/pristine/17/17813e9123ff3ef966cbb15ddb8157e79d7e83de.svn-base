package com.szsk.reservoir.run.mapper;

import java.util.List;

import com.szsk.reservoir.run.domain.RControl;
import com.szsk.reservoir.run.domain.RControlImpl;

/**
 * 控制运行计划实施Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-26
 */
public interface RControlImplMapper 
{
    /**
     * 查询控制运行计划实施
     * 
     * @param fId 控制运行计划实施ID
     * @return 控制运行计划实施
     */
    public RControlImpl selectRControlImplById(Long fId);

    /**
     * 查询控制运行计划实施列表
     *
     * @param rControlImpl 控制运行计划实施
     * @return 控制运行计划实施集合
     */
    public List<RControlImpl> selectRControlImplList(RControlImpl rControlImpl);

    /**
     * 新增控制运行计划实施
     * 
     * @param rControlImpl 控制运行计划实施
     * @return 结果
     */
    public int insertRControlImpl(RControlImpl rControlImpl);

    /**
     * 修改控制运行计划实施
     * 
     * @param rControlImpl 控制运行计划实施
     * @return 结果
     */
    public int updateRControlImpl(RControlImpl rControlImpl);

    /**
     * 删除控制运行计划实施
     * 
     * @param fId 控制运行计划实施ID
     * @return 结果
     */
    public int deleteRControlImplById(Long fId);

    /**
     * 批量删除控制运行计划实施
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRControlImplByIds(Long[] fIds);

    /**
     * 获取最近
     * @return 结果
     */
    RControlImpl latelyControl();
}
