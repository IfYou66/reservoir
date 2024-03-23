package com.szsk.reservoir.security.service.Impl;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.szsk.reservoir.security.domain.MFloodMaterials;
import com.szsk.reservoir.security.service.IMFloodMaterialsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.szsk.reservoir.security.mapper.MMaterialsAccountDetailMapper;
import com.szsk.reservoir.security.domain.MMaterialsAccountDetail;
import com.szsk.reservoir.security.service.IMMaterialsAccountDetailService;

import javax.annotation.Resource;

/**
 * 物资台账信息 Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-08-19
 */
@Service
public class MMaterialsAccountDetailServiceImpl implements IMMaterialsAccountDetailService 
{
    @Resource
    private MMaterialsAccountDetailMapper mMaterialsAccountDetailMapper;
    @Autowired
    private IMFloodMaterialsService iMFloodMaterialsService;

    /**
     * 查询物资台账信息 
     * 
     * @param fId 物资台账信息 ID
     * @return 物资台账信息 
     */
    @Override
    public MMaterialsAccountDetail selectMMaterialsAccountDetailById(Long fId)
    {
        return mMaterialsAccountDetailMapper.selectMMaterialsAccountDetailById(fId);
    }

    /**
     * 查询物资台账信息 列表
     * 
     * @param mMaterialsAccountDetail 物资台账信息 
     * @return 物资台账信息 
     */
    @Override
    public List<MMaterialsAccountDetail> selectMMaterialsAccountDetailList(MMaterialsAccountDetail mMaterialsAccountDetail)
    {
        return mMaterialsAccountDetailMapper.selectMMaterialsAccountDetailList(mMaterialsAccountDetail);
    }

    /**
     * 新增物资台账信息 
     * 
     * @param mMaterialsAccountDetail 物资台账信息 
     * @return 结果
     */
    @Override
    public int insertMMaterialsAccountDetail(MMaterialsAccountDetail mMaterialsAccountDetail)
    {
        if(mMaterialsAccountDetail.getfFloodMaterialsId() == null){
            throw new RuntimeException("没有主表主键");
        }
        MFloodMaterials mFloodMaterials = iMFloodMaterialsService.selectMFloodMaterialsById(mMaterialsAccountDetail.getfFloodMaterialsId());
        if(mFloodMaterials.getfNum() == null){
            mFloodMaterials.setfNum(BigDecimal.ZERO);
        }
        if(mMaterialsAccountDetail.getfAccountType() == 2){
            // 如果是出库
            if(mMaterialsAccountDetail.getfAccountNum().compareTo(mFloodMaterials.getfNum()) > 0){
                throw new RuntimeException("出库数量大于库存！");
            }
            // 减法
            mFloodMaterials.setfNum(mFloodMaterials.getfNum().subtract(mMaterialsAccountDetail.getfAccountNum()));
        }else{
            // 加法
            mFloodMaterials.setfNum(mFloodMaterials.getfNum().add(mMaterialsAccountDetail.getfAccountNum()));
        }
        mMaterialsAccountDetail.setfTotalPrice(mMaterialsAccountDetail.getfAccountNum().multiply(mFloodMaterials.getfPrice()));
        mMaterialsAccountDetail.setfCreateDate(new Date(System.currentTimeMillis()));
        mMaterialsAccountDetail.setfCreateBy(SecurityUtils.getUserId());
        iMFloodMaterialsService.updateMFloodMaterials(mFloodMaterials);
        return mMaterialsAccountDetailMapper.insertMMaterialsAccountDetail(mMaterialsAccountDetail);
    }

    /**
     * 修改物资台账信息 
     * 
     * @param mMaterialsAccountDetail 物资台账信息 
     * @return 结果
     */
    @Override
    public int updateMMaterialsAccountDetail(MMaterialsAccountDetail mMaterialsAccountDetail)
    {
        return mMaterialsAccountDetailMapper.updateMMaterialsAccountDetail(mMaterialsAccountDetail);
    }

    /**
     * 批量删除物资台账信息 
     * 
     * @param fIds 需要删除的物资台账信息 ID
     * @return 结果
     */
    @Override
    public int deleteMMaterialsAccountDetailByIds(Long[] fIds)
    {
        return mMaterialsAccountDetailMapper.deleteMMaterialsAccountDetailByIds(fIds);
    }

    /**
     * 删除物资台账信息 信息
     * 
     * @param fId 物资台账信息 ID
     * @return 结果
     */
    @Override
    public int deleteMMaterialsAccountDetailById(Long fId)
    {
        return mMaterialsAccountDetailMapper.deleteMMaterialsAccountDetailById(fId);
    }
}
