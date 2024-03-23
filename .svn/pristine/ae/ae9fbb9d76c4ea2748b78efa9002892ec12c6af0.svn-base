package com.szsk.reservoir.manageSystem.service;

import com.szsk.reservoir.manageSystem.domain.SysClassType;
import com.szsk.reservoir.manageSystem.domain.vo.SysClassTreeSelect;

import java.util.List;

/**
 * 制度分类 Service接口
 * 
 * @author cangfeng
 * @date 2021-07-21
 */
public interface ISysClassTypeService 
{
    /**
     * 查询制度分类 
     * 
     * @param fTypeId 制度分类 ID
     * @return 制度分类 
     */
    public SysClassType selectSysClassTypeById(Long fTypeId);

    /**
     * 查询制度分类 列表
     * 
     * @param sysClassType 制度分类 
     * @return 制度分类 集合
     */
    public List<SysClassType> selectSysClassTypeList(SysClassType sysClassType);

    /**
     * 新增制度分类 
     * 
     * @param sysClassType 制度分类 
     * @return 结果
     */
    public int insertSysClassType(SysClassType sysClassType);

    /**
     * 修改制度分类 
     * 
     * @param sysClassType 制度分类 
     * @return 结果
     */
    public int updateSysClassType(SysClassType sysClassType);

    /**
     * 批量删除制度分类 
     * 
     * @param fTypeIds 需要删除的制度分类 ID
     * @return 结果
     */
    public int deleteSysClassTypeByIds(Long[] fTypeIds);

    /**
     * 删除制度分类 信息
     * 
     * @param fTypeId 制度分类 ID
     * @return 结果
     */
    public int deleteSysClassTypeById(Long fTypeId);

    /**
     * 构建前端所需要树结构
     *
     * @param sysClassType
     * @return 树结构列表
     */
    public List<SysClassTreeSelect> buildArchivesTypeTreeSelect(List<SysClassType> sysClassType);
}
