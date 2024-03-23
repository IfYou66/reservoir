package com.szsk.reservoir.security.service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.reservoir.security.domain.MFloodMaterials;

import java.util.ArrayList;
import java.util.List;

/**
 * 防汛物资 Service接口
 * 
 * @author cangfeng
 * @date 2021-08-19
 */
public interface IMFloodMaterialsService 
{
    /**
     * 查询防汛物资 
     * 
     * @param fId 防汛物资 ID
     * @return 防汛物资 
     */
    public MFloodMaterials selectMFloodMaterialsById(Long fId);

    /**
     * 查询防汛物资 列表
     * 
     * @param mFloodMaterials 防汛物资 
     * @return 防汛物资 集合
     */
    public List<MFloodMaterials> selectMFloodMaterialsList(MFloodMaterials mFloodMaterials);

    /**
     * 新增防汛物资 
     *
     * @param mFloodMaterials 防汛物资 
     * @return 结果
     */
    public int insertMFloodMaterials(MFloodMaterials mFloodMaterials);

    /**
     * 批量新增防汛物资
     *
     * @param mFloodMaterials 防汛物资
     * @return 结果
     */
    public int insertAllMFloodMaterials(ArrayList<MFloodMaterials> mFloodMaterials);

    /**
     * 修改防汛物资 
     * 
     * @param mFloodMaterials 防汛物资 
     * @return 结果
     */
    public int updateMFloodMaterials(MFloodMaterials mFloodMaterials);

    /**
     * 批量删除防汛物资 
     * 
     * @param fIds 需要删除的防汛物资 ID
     * @return 结果
     */
    public int deleteMFloodMaterialsByIds(Long[] fIds);

    /**
     * 删除防汛物资 信息
     * 
     * @param fId 防汛物资 ID
     * @return 结果
     */
    public int deleteMFloodMaterialsById(Long fId);

    AjaxResult getDictByType();
}
