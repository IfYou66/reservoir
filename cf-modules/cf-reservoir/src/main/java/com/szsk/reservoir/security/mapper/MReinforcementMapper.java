package com.szsk.reservoir.security.mapper;

import java.util.List;
import com.szsk.reservoir.security.domain.MReinforcement;
import com.szsk.reservoir.security.domain.MSafetyAppraisal;

/**
 * 水库大坝除险加固 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-17
 */
public interface MReinforcementMapper 
{
    /**
     * 查询水库大坝除险加固 
     * 
     * @param fId 水库大坝除险加固 ID
     * @return 水库大坝除险加固 
     */
    public MReinforcement selectMReinforcementById(Long fId);

    /**
     * 查询水库大坝除险加固 列表
     * 
     * @param mReinforcement 水库大坝除险加固 
     * @return 水库大坝除险加固 集合
     */
    public List<MReinforcement> selectMReinforcementList(MReinforcement mReinforcement);

    /**
     * 新增水库大坝除险加固 
     * 
     * @param mReinforcement 水库大坝除险加固 
     * @return 结果
     */
    public int insertMReinforcement(MReinforcement mReinforcement);

    /**
     * 修改水库大坝除险加固 
     * 
     * @param mReinforcement 水库大坝除险加固 
     * @return 结果
     */
    public int updateMReinforcement(MReinforcement mReinforcement);

    /**
     * 删除水库大坝除险加固 
     * 
     * @param fId 水库大坝除险加固 ID
     * @return 结果
     */
    public int deleteMReinforcementById(Long fId);

    /**
     * 批量删除水库大坝除险加固 
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMReinforcementByIds(Long[] fIds);

    /**
     * 获取最近
     * @return 结果
     */
    public MReinforcement latelyReinforcement(MReinforcement mReinforcement);
}
