package com.szsk.archives.archivesManage.service.Impl;


import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.exception.CustomException;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.archives.archivesManage.domain.AArchives;
import com.szsk.archives.archivesManage.domain.AStoreroom;
import com.szsk.archives.archivesManage.mapper.AArchivesMapper;
import com.szsk.archives.archivesManage.service.IAArchivesService;

/**
 * 档案 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-07-21
 */
@Service
public class AArchivesServiceImpl implements IAArchivesService
{
    @Resource
    private AArchivesMapper aArchivesMapper;

    /**
     * 查询档案 
     * 
     * @param fArchivesId 档案 ID
     * @return 档案 
     */
    @Override
    public AArchives selectAArchivesById(Long fArchivesId)
    {
        return aArchivesMapper.selectAArchivesById(fArchivesId);
    }

    /**
     * 查询档案 列表
     * 
     * @param aArchives 档案 
     * @return 档案 
     */
    @Override
    @Reservoir
    public List<AArchives> selectAArchivesList(AArchives aArchives)
    {
        return aArchivesMapper.selectAArchivesList(aArchives);
    }

    /**
     * 新增档案 
     * 
     * @param aArchives 档案 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertAArchives(AArchives aArchives)
    {
        return aArchivesMapper.insertAArchives(aArchives);
    }

    /**
     * 修改档案 
     * 
     * @param aArchives 档案 
     * @return 结果
     */
    @Override
    public int updateAArchives(AArchives aArchives)
    {
        if (aArchives.getLogOffOrModify() == 1) {
            aArchives.setfLogoutTime(new Date());
        }
        return aArchivesMapper.updateAArchives(aArchives);
    }

    /**
     * 批量删除档案 
     * 
     * @param fArchivesIds 需要删除的档案 ID
     * @return 结果
     */
    @Override
    public int deleteAArchivesByIds(Long[] fArchivesIds)
    {
        return aArchivesMapper.deleteAArchivesByIds(fArchivesIds);
    }

    /**
     * 删除档案 信息
     * 
     * @param fArchivesId 档案 ID
     * @return 结果
     */
    @Override
    public int deleteAArchivesById(Long fArchivesId)
    {
        return aArchivesMapper.deleteAArchivesById(fArchivesId);
    }

    /**
     * 初始化档案接收表格数据
     * @return
     */
    @Override
    public AjaxResult initArchivesForm() {
        Map<String,Object> map = new HashMap<>();
        try {
            // 查询字典
            List<SysDictData> sysDictData = aArchivesMapper.queryDict("sys_grade");
            // 查询库房
            List<AStoreroom> aStorerooms = aArchivesMapper.queryStoreroom();
            map.put("dictList",sysDictData);
            map.put("storeroomsList",aStorerooms);
        }catch (Exception e){
            e.printStackTrace();
            throw new CustomException("数据初始化异常");
        }
        return AjaxResult.success(map);
    }

    @Override
    public AjaxResult getDictByType(String dictType) {
        return AjaxResult.success(aArchivesMapper.queryDict(dictType));
    }
}
