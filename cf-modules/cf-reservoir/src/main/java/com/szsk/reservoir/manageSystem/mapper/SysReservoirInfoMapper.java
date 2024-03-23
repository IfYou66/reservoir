package com.szsk.reservoir.manageSystem.mapper;

import java.util.List;
import com.szsk.reservoir.manageSystem.domain.SysReservoirInfo;

/**
 * 水库信息Mapper接口
 * 
 * @author cangfeng
 * @date 2021-11-12
 */
public interface SysReservoirInfoMapper 
{
    /**
     * 查询水库信息
     * 
     * @param id 水库信息ID
     * @return 水库信息
     */
    public SysReservoirInfo selectSysReservoirInfoById(Long id);

    /**
     * 查询水库信息列表
     * 
     * @param sysReservoirInfo 水库信息
     * @return 水库信息集合
     */
    public List<SysReservoirInfo> selectSysReservoirInfoList(SysReservoirInfo sysReservoirInfo);

    /**
     * 新增水库信息
     * 
     * @param sysReservoirInfo 水库信息
     * @return 结果
     */
    public int insertSysReservoirInfo(SysReservoirInfo sysReservoirInfo);

    /**
     * 修改水库信息
     * 
     * @param sysReservoirInfo 水库信息
     * @return 结果
     */
    public int updateSysReservoirInfo(SysReservoirInfo sysReservoirInfo);

    /**
     * 删除水库信息
     * 
     * @param id 水库信息ID
     * @return 结果
     */
    public int deleteSysReservoirInfoById(Long id);

    /**
     * 批量删除水库信息
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysReservoirInfoByIds(Long[] ids);
}
