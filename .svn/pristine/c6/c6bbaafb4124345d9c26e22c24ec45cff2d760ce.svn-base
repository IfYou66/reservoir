package com.szsk.archives.archivesManage.mapper;

import com.ruoyi.common.core.domain.SysDictData;
import com.szsk.archives.archivesManage.domain.AArchives;
import com.szsk.archives.archivesManage.domain.AStoreroom;

import java.util.List;

/**
 * 档案 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-07-21
 */
public interface AArchivesMapper 
{
    /**
     * 查询档案 
     * 
     * @param fArchivesId 档案 ID
     * @return 档案 
     */
    public AArchives selectAArchivesById(Long fArchivesId);

    /**
     * 查询档案 列表
     * 
     * @param aArchives 档案 
     * @return 档案 集合
     */
    public List<AArchives> selectAArchivesList(AArchives aArchives);

    /**
     * 新增档案 
     * 
     * @param aArchives 档案 
     * @return 结果
     */
    public int insertAArchives(AArchives aArchives);

    /**
     * 修改档案 
     * 
     * @param aArchives 档案 
     * @return 结果
     */
    public int updateAArchives(AArchives aArchives);

    /**
     * 删除档案 
     * 
     * @param fArchivesId 档案 ID
     * @return 结果
     */
    public int deleteAArchivesById(Long fArchivesId);

    /**
     * 批量删除档案 
     * 
     * @param fArchivesIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteAArchivesByIds(Long[] fArchivesIds);

    /**
     * 查询字典列表
     * @return
     */
    public List<SysDictData> queryDict(String dictType);

    /**
     * 查询库房
     * @return
     */
    public List<AStoreroom> queryStoreroom();
}
