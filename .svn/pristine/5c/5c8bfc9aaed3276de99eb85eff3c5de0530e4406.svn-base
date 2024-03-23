package com.szsk.reservoir.risk.service;

import com.szsk.reservoir.risk.domain.MRiskManagement;

import java.util.List;

/**
 * 险情管理 Service接口
 *
 * @author cangfeng
 * @date 2021-08-19
 */
public interface IMRiskManagementService {
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
     * 批量删除险情管理
     *
     * @param fIds 需要删除的险情管理 ID
     * @return 结果
     */
    public int deleteMRiskManagementByIds(Long[] fIds);

    /**
     * 删除险情管理 信息
     *
     * @param fId 险情管理 ID
     * @return 结果
     */
    public int deleteMRiskManagementById(Long fId);
}
