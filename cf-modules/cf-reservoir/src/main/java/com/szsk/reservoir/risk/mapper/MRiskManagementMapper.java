package com.szsk.reservoir.risk.mapper;

import com.szsk.reservoir.risk.domain.MRiskManagement;

import java.util.List;

/**
 * 险情管理 Mapper接口
 *
 * @author cangfeng
 * @date 2021-08-19
 */
public interface MRiskManagementMapper {
    /**
     * 查询险情管理
     *
     * @param fId 险情管理 ID
     * @return 险情管理
     */
    public MRiskManagement selectMRiskManagementById(Long fId);

    /**
     * 查询险情管理 列表
     *
     * @param mRiskManagement 险情管理
     * @return 险情管理 集合
     */
    public List<MRiskManagement> selectMRiskManagementList(MRiskManagement mRiskManagement);

    /**
     * 新增险情管理
     *
     * @param mRiskManagement 险情管理
     * @return 结果
     */
    public int insertMRiskManagement(MRiskManagement mRiskManagement);

    /**
     * 修改险情管理
     *
     * @param mRiskManagement 险情管理
     * @return 结果
     */
    public int updateMRiskManagement(MRiskManagement mRiskManagement);

    /**
     * 删除险情管理
     *
     * @param fId 险情管理 ID
     * @return 结果
     */
    public int deleteMRiskManagementById(Long fId);

    /**
     * 批量删除险情管理
     *
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMRiskManagementByIds(Long[] fIds);
}
