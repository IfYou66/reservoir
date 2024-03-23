package com.szsk.reservoir.run.mapper;

import java.util.List;
import com.szsk.reservoir.run.domain.RDispatchRules;

/**
 * 水库调度规程 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
public interface RDispatchRulesMapper 
{
    /**
     * 查询水库调度规程 
     * 
     * @param fId 水库调度规程 ID
     * @return 水库调度规程 
     */
    public RDispatchRules selectRDispatchRulesById(Long fId);

    /**
     * 查询水库调度规程 列表
     * 
     * @param rDispatchRules 水库调度规程 
     * @return 水库调度规程 集合
     */
    public List<RDispatchRules> selectRDispatchRulesList(RDispatchRules rDispatchRules);

    /**
     * 新增水库调度规程 
     * 
     * @param rDispatchRules 水库调度规程 
     * @return 结果
     */
    public int insertRDispatchRules(RDispatchRules rDispatchRules);

    /**
     * 修改水库调度规程 
     * 
     * @param rDispatchRules 水库调度规程 
     * @return 结果
     */
    public int updateRDispatchRules(RDispatchRules rDispatchRules);

    /**
     * 删除水库调度规程 
     * 
     * @param fId 水库调度规程 ID
     * @return 结果
     */
    public int deleteRDispatchRulesById(Long fId);

    /**
     * 批量删除水库调度规程 
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRDispatchRulesByIds(Long[] fIds);
}
