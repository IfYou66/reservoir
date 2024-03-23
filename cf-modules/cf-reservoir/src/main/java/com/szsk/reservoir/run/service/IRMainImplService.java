package com.szsk.reservoir.run.service;

import com.szsk.reservoir.run.domain.RMainImpl;

import java.util.List;

/**
 * 维修养护实施 Service接口
 *
 * @author cangfeng
 * @date 2021-08-23
 */
public interface IRMainImplService {

    /**
     * 查询维修养护实施
     *
     * @param fId 维修养护实施 ID
     * @return 维修养护实施
     */
    public RMainImpl selectRMainImplById(Long fId);

    /**
     * 查询维修养护实施 列表
     *
     * @param rMainImpl 维修养护实施
     * @return 维修养护实施 集合
     */
    public List<RMainImpl> selectRMainImplList(RMainImpl rMainImpl);

    /**
     * 新增维修养护实施
     *
     * @param rMainImpl 维修养护实施
     * @return 结果
     */
    public int insertRMainImpl(RMainImpl rMainImpl);

    /**
     * 修改维修养护实施
     *
     * @param rMainImpl 维修养护实施
     * @return 结果
     */
    public int updateRMainImpl(RMainImpl rMainImpl);

    /**
     * 批量删除维修养护实施
     *
     * @param fIds 需要删除的维修养护实施 ID
     * @return 结果
     */
    public int deleteRMainImplByIds(Long[] fIds);

    /**
     * 删除维修养护实施 信息
     *
     * @param fId 维修养护实施 ID
     * @return 结果
     */
    public int deleteRMainImplById(Long fId);

}
