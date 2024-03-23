package com.szsk.reservoir.run.service;

import com.szsk.reservoir.run.domain.RMaintenance;
import java.util.List;

/**
 * 维修养护编制 Service接口
 *
 * @author cangfeng
 * @date 2021-08-23
 */
public interface IRMaintenanceService {

    /**
     * 查询维修养护编制
     *
     * @param fId 维修养护编制 ID
     * @return 维修养护编制
     */
    public RMaintenance selectRMaintenanceById(Integer fId);

    /**
     * 查询维修养护编制 列表
     *
     * @param rMaintenance 维修养护编制
     * @return 维修养护编制 集合
     */
    public List<RMaintenance> selectRMaintenanceList(RMaintenance rMaintenance);

    /**
     * 新增维修养护编制
     *
     * @param rMaintenance 维修养护编制
     * @return 结果
     */
    public int insertRMaintenance(RMaintenance rMaintenance);

    /**
     * 修改维修养护编制
     *
     * @param rMaintenance 维修养护编制
     * @return 结果
     */
    public int updateRMaintenance(RMaintenance rMaintenance);

    /**
     * 批量删除维修养护编制
     *
     * @param fIds 需要删除的维修养护编制 ID
     * @return 结果
     */
    public int deleteRMaintenanceByIds(Integer[] fIds);

    /**
     * 删除维修养护编制 信息
     *
     * @param fId 维修养护编制 ID
     * @return 结果
     */
    public int deleteRMaintenanceById(Integer fId);

}
