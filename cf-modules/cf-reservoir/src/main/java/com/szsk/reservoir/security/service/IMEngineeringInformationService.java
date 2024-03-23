package com.szsk.reservoir.security.service;

import com.szsk.reservoir.security.domain.MEngineeringInformation;

import java.util.List;

/**
 * 水库大坝工程基本信息 Service接口
 *
 * @author cangfeng
 * @date 2021-08-14
 */
public interface IMEngineeringInformationService {

    /**
     * 查询水库大坝工程基本信息
     *
     * @param fId 水库大坝工程基本信息 ID
     * @return 水库大坝工程基本信息
     */
    public MEngineeringInformation selectMEngineeringInformationById(Long fId);

    /**
     * 查询水库大坝工程基本信息 列表
     *
     * @param mEngineeringInformation 水库大坝工程基本信息
     * @return 水库大坝工程基本信息 集合
     */
    public List<MEngineeringInformation> selectMEngineeringInformationList(MEngineeringInformation mEngineeringInformation);

    /**
     * 新增水库大坝工程基本信息
     *
     * @param mEngineeringInformation 水库大坝工程基本信息
     * @return 结果
     */
    public int insertMEngineeringInformation(MEngineeringInformation mEngineeringInformation);

    /**
     * 修改水库大坝工程基本信息
     *
     * @param mEngineeringInformation 水库大坝工程基本信息
     * @return 结果
     */
    public int updateMEngineeringInformation(MEngineeringInformation mEngineeringInformation);

    /**
     * 批量删除水库大坝工程基本信息
     *
     * @param fIds 需要删除的水库大坝工程基本信息 ID
     * @return 结果
     */
    public int deleteMEngineeringInformationByIds(Long[] fIds);

    /**
     * 删除水库大坝工程基本信息 信息
     *
     * @param fId 水库大坝工程基本信息 ID
     * @return 结果
     */
    public int deleteMEngineeringInformationById(Long fId);
}
