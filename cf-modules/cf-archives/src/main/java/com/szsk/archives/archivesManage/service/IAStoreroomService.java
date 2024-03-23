package com.szsk.archives.archivesManage.service;

import com.szsk.archives.archivesManage.domain.AStoreroom;

import java.util.List;

/**
 * 库房Service接口
 * 
 * @author wangcc
 * @date 2021-08-16
 */
public interface IAStoreroomService 
{
    /**
     * 查询库房
     * 
     * @param fStoreroomId 库房ID
     * @return 库房
     */
    public AStoreroom selectAStoreroomById(Long fStoreroomId);

    /**
     * 查询库房列表
     * 
     * @param aStoreroom 库房
     * @return 库房集合
     */
    public List<AStoreroom> selectAStoreroomList(AStoreroom aStoreroom);

    /**
     * 新增库房
     * 
     * @param aStoreroom 库房
     * @return 结果
     */
    public int insertAStoreroom(AStoreroom aStoreroom);

    /**
     * 修改库房
     * 
     * @param aStoreroom 库房
     * @return 结果
     */
    public int updateAStoreroom(AStoreroom aStoreroom);

    /**
     * 批量删除库房
     * 
     * @param fStoreroomIds 需要删除的库房ID
     * @return 结果
     */
    public int deleteAStoreroomByIds(Long[] fStoreroomIds);

    /**
     * 删除库房信息
     * 
     * @param fStoreroomId 库房ID
     * @return 结果
     */
    public int deleteAStoreroomById(Long fStoreroomId);
}
