package com.szsk.reservoir.run.service.Impl;

import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szsk.reservoir.run.mapper.RDispatchRulesMapper;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.run.domain.RDispatchRules;
import com.szsk.reservoir.run.service.IRDispatchRulesService;

/**
 * 水库调度规程 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
@Service
public class RDispatchRulesServiceImpl implements IRDispatchRulesService 
{
    @Autowired
    private RDispatchRulesMapper rDispatchRulesMapper;

    /**
     * 查询水库调度规程 
     * 
     * @param fId 水库调度规程 ID
     * @return 水库调度规程 
     */
    @Override
    public RDispatchRules selectRDispatchRulesById(Long fId)
    {
        return rDispatchRulesMapper.selectRDispatchRulesById(fId);
    }

    /**
     * 查询水库调度规程 列表
     * 
     * @param rDispatchRules 水库调度规程 
     * @return 水库调度规程 
     */
    @Override
    @Reservoir
    public List<RDispatchRules> selectRDispatchRulesList(RDispatchRules rDispatchRules)
    {
        return rDispatchRulesMapper.selectRDispatchRulesList(rDispatchRules);
    }

    /**
     * 新增水库调度规程 
     * 
     * @param rDispatchRules 水库调度规程 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertRDispatchRules(RDispatchRules rDispatchRules)
    {
    	rDispatchRules.setfCreatePeople(SecurityUtils.getUserId());
    	rDispatchRules.setfCreateTime(new Date());
        return rDispatchRulesMapper.insertRDispatchRules(rDispatchRules);
    }

    /**
     * 修改水库调度规程 
     * 
     * @param rDispatchRules 水库调度规程 
     * @return 结果
     */
    @Override
    public int updateRDispatchRules(RDispatchRules rDispatchRules)
    {
        return rDispatchRulesMapper.updateRDispatchRules(rDispatchRules);
    }

    /**
     * 批量删除水库调度规程 
     * 
     * @param fIds 需要删除的水库调度规程 ID
     * @return 结果
     */
    @Override
    public int deleteRDispatchRulesByIds(Long[] fIds)
    {
        return rDispatchRulesMapper.deleteRDispatchRulesByIds(fIds);
    }

    /**
     * 删除水库调度规程 信息
     * 
     * @param fId 水库调度规程 ID
     * @return 结果
     */
    @Override
    public int deleteRDispatchRulesById(Long fId)
    {
        return rDispatchRulesMapper.deleteRDispatchRulesById(fId);
    }
}
