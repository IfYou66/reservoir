package com.szsk.reservoir.manageSystem.mapper;

import com.szsk.reservoir.manageSystem.domain.SysClassType;

import java.util.List;

/**
 * 制度分类 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-07-21
 */
public interface SysClassTypeMapper
{
    /**
     * 查询制度分类
     *
     * @param typeId 制度分类ID
     * @return 制度分类
     */
    public SysClassType selectSysClassTypeById(Long typeId);

    /**
     * 查询制度分类列表
     *
     * @param sysClassType 制度分类
     * @return 制度分类集合
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
     * 删除制度分类
     *
     * @param typeId 制度分类ID
     * @return 结果
     */
    public int deleteSysClassTypeById(Long typeId);

    /**
     * 批量删除制度分类
     *
     * @param typeIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysClassTypeByIds(Long[] typeIds);
}
