package com.szsk.reservoir.manageSystem.service;

import java.util.List;
import com.szsk.reservoir.manageSystem.domain.SysManagement;

/**
 * 制度管理 Service接口
 * 
 * @author cangfeng
 * @date 2021-08-12
 */
public interface ISysManagementService 
{
    /**
     * 查询制度管理 
     * 
     * @param fSystemId 制度管理 ID
     * @return 制度管理 
     */
    public SysManagement selectSysManagementById(Long fSystemId);

    /**
     * 查询制度管理 列表
     * 
     * @param sysManagement 制度管理 
     * @return 制度管理 集合
     */
    public List<SysManagement> selectSysManagementList(SysManagement sysManagement);

    /**
     * 查询制度管理树 列表
     *
     * @param sysManagement 制度管理
     * @return 制度管理 集合
     */
    public List<SysManagement> selectSysManagementTreeList(SysManagement sysManagement);

    /**
     * 新增制度管理 
     * 
     * @param sysManagement 制度管理 
     * @return 结果
     */
    public int insertSysManagement(SysManagement sysManagement);

    /**
     * 修改制度管理 
     * 
     * @param sysManagement 制度管理 
     * @return 结果
     */
    public int updateSysManagement(SysManagement sysManagement);

    /**
     * 批量删除制度管理 
     * 
     * @param fSystemIds 需要删除的制度管理 ID
     * @return 结果
     */
    public int deleteSysManagementByIds(Long[] fSystemIds);

    /**
     * 删除制度管理 信息
     * 
     * @param fSystemId 制度管理 ID
     * @return 结果
     */
    public int deleteSysManagementById(Long fSystemId);
    /**
     * 档案制度、管理保障首页、两册一表等文章类查询使用
     * @param code 分类编码
     */
	public SysManagement getManagementInfoByCode(String code);
}
