package com.szsk.archives.archivesManage.mapper;

import com.szsk.archives.archivesManage.domain.AStoreroom;

import java.util.List;


/**
 * 库房Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-16
 */
public interface AStoreroomMapper 
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
     * 删除库房
     * 
     * @param fStoreroomId 库房ID
     * @return 结果
     */
    public int deleteAStoreroomById(Long fStoreroomId);

    /**
     * 批量删除库房
     * 
     * @param fStoreroomIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAStoreroomByIds(Long[] fStoreroomIds);
}
