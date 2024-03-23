package com.szsk.reservoir.manageSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.manageSystem.domain.SysClassType;
import com.szsk.reservoir.manageSystem.domain.SysManagement;
import com.szsk.reservoir.manageSystem.mapper.SysManagementMapper;
import com.szsk.reservoir.manageSystem.service.ISysClassTypeService;
import com.szsk.reservoir.manageSystem.service.ISysManagementService;

/**
 * 制度管理 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-12
 */
@Service
public class SysManagementServiceImpl implements ISysManagementService
{
    @Autowired
    private SysManagementMapper sysManagementMapper;
    @Autowired
    private ISysClassTypeService sysClassTypeService;

    /**
     * 查询制度管理 
     * 
     * @param fSystemId 制度管理 ID
     * @return 制度管理 
     */
    @Override
    public SysManagement selectSysManagementById(Long fSystemId)
    {
        return sysManagementMapper.selectSysManagementById(fSystemId);
    }

    /**
     * 查询制度管理 列表
     * 
     * @param sysManagement 制度管理 
     * @return 制度管理 
     */
    @Override
    @Reservoir
    public List<SysManagement> selectSysManagementList(SysManagement sysManagement)
    {
        return sysManagementMapper.selectSysManagementList(sysManagement);
    }

    /**
     * 新增制度管理 
     * 
     * @param sysManagement 制度管理 
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertSysManagement(SysManagement sysManagement)
    {
        return sysManagementMapper.insertSysManagement(sysManagement);
    }

    /**
     * 修改制度管理 
     * 
     * @param sysManagement 制度管理 
     * @return 结果
     */
    @Override
    public int updateSysManagement(SysManagement sysManagement)
    {
        return sysManagementMapper.updateSysManagement(sysManagement);
    }

    /**
     * 批量删除制度管理 
     * 
     * @param fSystemIds 需要删除的制度管理 ID
     * @return 结果
     */
    @Override
    public int deleteSysManagementByIds(Long[] fSystemIds)
    {
        return sysManagementMapper.deleteSysManagementByIds(fSystemIds);
    }

    /**
     * 删除制度管理 信息
     * 
     * @param fSystemId 制度管理 ID
     * @return 结果
     */
    @Override
    public int deleteSysManagementById(Long fSystemId)
    {
        return sysManagementMapper.deleteSysManagementById(fSystemId);
    }

    /**
     * 查询制度管理树 列表
     * 如果子节点多效率有可能不如用in高 后期可以考虑判断子节点个数增加in方法的分支
     *
     * @param sysManagement 制度管理
     * @return 制度管理
     */
    @Override
    @Reservoir
    public List<SysManagement> selectSysManagementTreeList(SysManagement sysManagement)
    {
        // 当前节点的数据
        List<SysManagement> sysManagementList = sysManagementMapper.selectSysManagementList(sysManagement);
        // 获取子节点
        SysClassType sysClassType = new SysClassType();
        sysClassType.setfParentId(sysManagement.getfTypeId());
        List<SysClassType> SysClassTypeList = sysClassTypeService.selectSysClassTypeList(sysClassType);
        
        // 子节点存在
        if(SysClassTypeList != null){
            for (SysClassType sct : SysClassTypeList) {
                // 递归
                sysManagement.setfTypeId(Integer.valueOf(sct.getfId().toString()));
                List<SysManagement> list = selectSysManagementTreeList(sysManagement);
                // List判空
                if(sysManagementList == null){
                    sysManagementList = list;
                }else if(list != null){
                    sysManagementList.addAll(list);
                }
            }
        }
        return sysManagementList;
    }
    /**
     * 档案制度、管理保障首页、两册一表等文章类查询使用
     * @param code 分类编码
     */
	public SysManagement getManagementInfoByCode(String code) {
		return sysManagementMapper.getManagementInfoByCode(code);
	}
}
