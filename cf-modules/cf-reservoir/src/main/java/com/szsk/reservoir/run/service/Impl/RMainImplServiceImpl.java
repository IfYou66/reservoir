package com.szsk.reservoir.run.service.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.run.domain.RMainImpl;
import com.szsk.reservoir.run.mapper.RMainImplMapper;
import com.szsk.reservoir.run.service.IRMainImplService;

/**
 * 维修养护实施 Service业务层处理
 *
 * @author cangfeng
 * @date 2021-08-23
 */
@Service
public class RMainImplServiceImpl implements IRMainImplService {

    @Autowired
    private RMainImplMapper rMainImplMapper;

    /**
     * 查询维修养护实施
     *
     * @param fId 维修养护实施 ID
     * @return 维修养护实施
     */
    @Override
    public RMainImpl selectRMainImplById(Long fId)
    {
        return rMainImplMapper.selectRMainImplById(fId);
    }

    /**
     * 查询维修养护实施 列表
     *
     * @param rMainImpl 维修养护实施
     * @return 维修养护实施
     */
    @Override
    @Reservoir
    public List<RMainImpl> selectRMainImplList(RMainImpl rMainImpl)
    {
        return rMainImplMapper.selectRMainImplList(rMainImpl);
    }

    /**
     * 新增维修养护实施
     *
     * @param rMainImpl 维修养护实施
     * @return 结果
     */
    @Override
    @Reservoir
    public int insertRMainImpl(RMainImpl rMainImpl)
    {
        return rMainImplMapper.insertRMainImpl(rMainImpl);
    }

    /**
     * 修改维修养护实施
     *
     * @param rMainImpl 维修养护实施
     * @return 结果
     */
    @Override
    public int updateRMainImpl(RMainImpl rMainImpl)
    {
        return rMainImplMapper.updateRMainImpl(rMainImpl);
    }

    /**
     * 批量删除维修养护实施
     *
     * @param fIds 需要删除的维修养护实施 ID
     * @return 结果
     */
    @Override
    public int deleteRMainImplByIds(Long[] fIds)
    {
        return rMainImplMapper.deleteRMainImplByIds(fIds);
    }

    /**
     * 删除维修养护实施 信息
     *
     * @param fId 维修养护实施 ID
     * @return 结果
     */
    @Override
    public int deleteRMainImplById(Long fId)
    {
        return rMainImplMapper.deleteRMainImplById(fId);
    }

}
