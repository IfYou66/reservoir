package com.szsk.reservoir.security.mapper;

import java.util.ArrayList;
import java.util.List;
import com.szsk.reservoir.security.domain.MFloodMaterials;

/**
 * 防汛物资 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-19
 */
public interface MFloodMaterialsMapper 
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
     * 新增防汛物资
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
     * 删除防汛物资 
     * 
     * @param fId 防汛物资 ID
     * @return 结果
     */
    public int deleteMFloodMaterialsById(Long fId);

    /**
     * 批量删除防汛物资 
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteMFloodMaterialsByIds(Long[] fIds);
}
