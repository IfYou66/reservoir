package com.szsk.reservoir.emergency.mapper;

import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.emergency.domain.MEmergencyPlanning;

import java.util.List;

/**
 * 水库预案编制 Mapper接口
 *
 * @author cangfeng
 * @date 2021-08-18
 */
public interface MEmergencyPlanningMapper {
    /**
     * 查询水库预案编制
     *
     * @param fId 水库预案编制 ID
     * @return 水库预案编制
     */
    public MEmergencyPlanning selectMEmergencyPlanningById(Long fId);

    /**
     * 查询水库预案编制 列表
     *
     * @param mEmergencyPlanning 水库预案编制
     * @return 水库预案编制 集合
     */
    public List<MEmergencyPlanning> selectMEmergencyPlanningList(MEmergencyPlanning mEmergencyPlanning);

    /**
     * 新增水库预案编制
     *
     * @param mEmergencyPlanning 水库预案编制
     * @return 结果
     */
    public int insertMEmergencyPlanning(MEmergencyPlanning mEmergencyPlanning);

    /**
     * 修改水库预案编制
     *
     * @param mEmergencyPlanning 水库预案编制
     * @return 结果
     */
    public int updateMEmergencyPlanning(MEmergencyPlanning mEmergencyPlanning);

    /**
     * 删除水库预案编制
     *
     * @param fId 水库预案编制 ID
     * @return 结果
     */
    public int deleteMEmergencyPlanningById(Long fId);

    /**
     * 批量删除水库预案编制
     *
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMEmergencyPlanningByIds(Long[] fIds);

    /**
     * 根据预案编制类型查询数据字典
     * @param dictType
     * @return
     */
    List<SysDictData> dataQuery(String dictType);
}