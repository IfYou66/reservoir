package com.szsk.reservoir.security.mapper;

import java.util.List;
import com.szsk.reservoir.security.domain.MEngineeringInformation;

public interface MEngineeringInformationMapper {
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
     * 删除水库大坝工程基本信息
     *
     * @param fId 水库大坝工程基本信息 ID
     * @return 结果
     */
    public int deleteMEngineeringInformationById(Long fId);

    /**
     * 批量删除水库大坝工程基本信息
     *
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMEngineeringInformationByIds(Long[] fIds);

}
