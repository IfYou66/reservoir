package com.szsk.archives.archivesManage.service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.szsk.archives.archivesManage.domain.AArchives;

import java.util.List;

/**
 * 档案 Service接口
 * 
 * @author cangfeng
 * @date 2021-07-21
 */
public interface IAArchivesService 
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
     * 批量删除档案 
     * 
     * @param fArchivesIds 需要删除的档案 ID
     * @return 结果
     */
    public int deleteAArchivesByIds(Long[] fArchivesIds);

    /**
     * 删除档案 信息
     * 
     * @param fArchivesId 档案 ID
     * @return 结果
     */
    public int deleteAArchivesById(Long fArchivesId);

    /**
     * 初始化档案接收表格数据
     * @return
     */
    public AjaxResult initArchivesForm();

    /**
     * 获取字典列表信息
     * @param dictType
     * @return
     */
    public AjaxResult getDictByType(String dictType);
}
