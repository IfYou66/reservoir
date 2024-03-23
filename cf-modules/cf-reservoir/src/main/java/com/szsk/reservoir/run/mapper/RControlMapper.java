package com.szsk.reservoir.run.mapper;

import java.util.List;
import com.szsk.reservoir.run.domain.RControl;
import com.szsk.reservoir.security.domain.MReinforcement;

/**
 * 控制运行计划 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
public interface RControlMapper 
{
    /**
     * 查询控制运行计划 
     * 
     * @param fId 控制运行计划 ID
     * @return 控制运行计划 
     */
    public RControl selectRControlById(Long fId);

    /**
     * 查询控制运行计划 列表
     * 
     * @param rControl 控制运行计划 
     * @return 控制运行计划 集合
     */
    public List<RControl> selectRControlList(RControl rControl);

    /**
     * 新增控制运行计划 
     * 
     * @param rControl 控制运行计划 
     * @return 结果
     */
    public int insertRControl(RControl rControl);

    /**
     * 修改控制运行计划 
     * 
     * @param rControl 控制运行计划 
     * @return 结果
     */
    public int updateRControl(RControl rControl);

    /**
     * 删除控制运行计划 
     * 
     * @param fId 控制运行计划 ID
     * @return 结果
     */
    public int deleteRControlById(Long fId);

    /**
     * 批量删除控制运行计划 
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRControlByIds(Long[] fIds);

    /**
     * 获取最近
     * @return 结果
     */
    public RControl latelyControl();
}
