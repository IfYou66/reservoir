package com.szsk.reservoir.security.service.Impl;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ruoyi.common.core.utils.coordinates.CoordinatesUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.szsk.reservoir.security.domain.MBorder;
import com.szsk.reservoir.security.mapper.MBorderMapper;
import com.szsk.reservoir.security.service.IMBorderService;

/**
 * 工程划界 Service业务层处理
 * 
 * @author wangcc
 * @date 2021-08-23
 */
@Service
public class MBorderServiceImpl implements IMBorderService
{

    @Resource
    private MBorderMapper borderMapper;

    @Override
    @Reservoir
    public AjaxResult getLabelList(MBorder mBorder) {
    	List<MBorder> borderList = borderMapper.queryLabelList(mBorder);
    	for (MBorder border : borderList) {
    		border.setfChangeLabel(CoordinatesUtils.getCoordinates(border.getfLabel()));
		}
        return AjaxResult.success(borderList);
    }

	@Override
	public MBorder selectMBorderById(Long fId) {
		 return borderMapper.selectMBorderById(fId);
	}

	@Override
	@Reservoir
	public int updateMBorder(MBorder mBorder) {
		mBorder.setfUpdateTime(new Date());
		
		if(mBorder.getfId() == null) {//新增
			 mBorder.setfCreateTime(new Date());
			 return borderMapper.insertMBorder(mBorder);
		}else {//修改
			 return borderMapper.updateMBorder(mBorder);
		}
		 
	}
}
