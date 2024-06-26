package com.szsk.reservoir.security.service.Impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.exception.CustomException;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.manageSystem.mapper.SysTrainingMapper;
import com.szsk.reservoir.security.domain.MFloodMaterials;
import com.szsk.reservoir.security.mapper.MFloodMaterialsMapper;
import com.szsk.reservoir.security.service.IMFloodMaterialsService;

/**
 * 防汛物资 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-19
 */
@Service
public class MFloodMaterialsServiceImpl implements IMFloodMaterialsService 
{
    @Autowired
    private MFloodMaterialsMapper mFloodMaterialsMapper;
    @Resource
    private SysTrainingMapper sysTrainingMapper;

    /**
     * 查询防汛物资 
     * 
     * @param fId 防汛物资 ID
     * @return 防汛物资 
     */
    @Override
    public MFloodMaterials selectMFloodMaterialsById(Long fId)
    {
        return mFloodMaterialsMapper.selectMFloodMaterialsById(fId);
    }

    /**
     * 查询防汛物资 列表
     * 
     * @param mFloodMaterials 防汛物资 
     * @return 防汛物资 
     */
    @Override
    @Reservoir
    public List<MFloodMaterials> selectMFloodMaterialsList(MFloodMaterials mFloodMaterials)
    {
        return mFloodMaterialsMapper.selectMFloodMaterialsList(mFloodMaterials);
    }

    /**
     * 新增防汛物资 
     *
     * @param mFloodMaterials 防汛物资 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertMFloodMaterials(MFloodMaterials mFloodMaterials)
    {
        return mFloodMaterialsMapper.insertMFloodMaterials(mFloodMaterials);
    }

    /**
     * 新增防汛物资
     *
     * @param mFloodMaterials 防汛物资
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertAllMFloodMaterials(ArrayList<MFloodMaterials> mFloodMaterials)
    {
        return mFloodMaterialsMapper.insertAllMFloodMaterials(mFloodMaterials);
    }

    /**
     * 修改防汛物资 
     * 
     * @param mFloodMaterials 防汛物资 
     * @return 结果
     */
    @Override
    public int updateMFloodMaterials(MFloodMaterials mFloodMaterials)
    {
        return mFloodMaterialsMapper.updateMFloodMaterials(mFloodMaterials);
    }

    /**
     * 批量删除防汛物资 
     * 
     * @param fIds 需要删除的防汛物资 ID
     * @return 结果
     */
    @Override
    public int deleteMFloodMaterialsByIds(Long[] fIds)
    {
        return mFloodMaterialsMapper.deleteMFloodMaterialsByIds(fIds);
    }

    /**
     * 删除防汛物资 信息
     * 
     * @param fId 防汛物资 ID
     * @return 结果
     */
    @Override
    public int deleteMFloodMaterialsById(Long fId)
    {
        return mFloodMaterialsMapper.deleteMFloodMaterialsById(fId);
    }

    @Override
    public AjaxResult getDictByType()
    {
        {
            Map<String,Object> map = new HashMap<>();
            try {
                // 查询字典
                List<SysDictData> list;
                list = sysTrainingMapper.queryDict("flood_materials_type");
                map.put("floodMaterialsType", list);
            }catch (Exception e){
                e.printStackTrace();
                throw new CustomException("数据初始化异常");
            }
            return AjaxResult.success(map);
        }
    }
}
