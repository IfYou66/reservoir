package com.szsk.archives.archivesManage.service.Impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.archives.archivesManage.domain.AStoreroom;
import com.szsk.archives.archivesManage.mapper.AStoreroomMapper;
import com.szsk.archives.archivesManage.service.IAStoreroomService;

/**
 * 库房Service业务层处理
 * 
 * @author wangcc
 * @date 2021-08-16
 */
@Service
public class AStoreroomServiceImpl implements IAStoreroomService
{
    @Resource
    private AStoreroomMapper aStoreroomMapper;

    /**
     * 查询库房
     * 
     * @param fStoreroomId 库房ID
     * @return 库房
     */
    @Override
    public AStoreroom selectAStoreroomById(Long fStoreroomId)
    {
        return aStoreroomMapper.selectAStoreroomById(fStoreroomId);
    }

    /**
     * 查询库房列表
     * 
     * @param aStoreroom 库房
     * @return 库房
     */
    @Override
    @Reservoir
    public List<AStoreroom> selectAStoreroomList(AStoreroom aStoreroom)
    {   // 水库id
        Long reservoirId = SecurityUtils.getReservoirId();
        aStoreroom.setfReservoirInfoId(reservoirId);
        return aStoreroomMapper.selectAStoreroomList(aStoreroom);
    }

    /**
     * 新增库房
     * 
     * @param aStoreroom 库房
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertAStoreroom(AStoreroom aStoreroom)
    {
        // 水库id
        Long reservoirId = SecurityUtils.getReservoirId();
        aStoreroom.setfReservoirInfoId(reservoirId);
        return aStoreroomMapper.insertAStoreroom(aStoreroom);
    }

    /**
     * 修改库房
     * 
     * @param aStoreroom 库房
     * @return 结果
     */
    @Override
    public int updateAStoreroom(AStoreroom aStoreroom)
    {
        return aStoreroomMapper.updateAStoreroom(aStoreroom);
    }

    /**
     * 批量删除库房
     * 
     * @param fStoreroomIds 需要删除的库房ID
     * @return 结果
     */
    @Override
    public int deleteAStoreroomByIds(Long[] fStoreroomIds)
    {
        return aStoreroomMapper.deleteAStoreroomByIds(fStoreroomIds);
    }

    /**
     * 删除库房信息
     * 
     * @param fStoreroomId 库房ID
     * @return 结果
     */
    @Override
    public int deleteAStoreroomById(Long fStoreroomId)
    {
        return aStoreroomMapper.deleteAStoreroomById(fStoreroomId);
    }
}
