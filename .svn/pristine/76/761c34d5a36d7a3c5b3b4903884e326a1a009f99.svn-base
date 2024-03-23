package com.szsk.reservoir.manageSystem.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.exception.CustomException;
import com.ruoyi.common.core.utils.Constant;
import com.ruoyi.common.core.utils.DateUtils;
import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.ruoyi.system.api.RemoteUserService;
import com.ruoyi.system.api.domain.SysUser;
import com.szsk.reservoir.manageSystem.domain.SysReservoirInfo;
import com.szsk.reservoir.manageSystem.mapper.SysReservoirInfoMapper;
import com.szsk.reservoir.manageSystem.service.ISysReservoirInfoService;

/**
 * 水库信息Service业务层处理
 * 
 * @author cangfeng
 * @date 2021-11-12
 */
@Service
public class SysReservoirInfoServiceImpl implements ISysReservoirInfoService 
{
    @Autowired
    private SysReservoirInfoMapper sysReservoirInfoMapper;
    @Autowired
    private RemoteUserService remoteUserService;

    /**
     * 查询水库信息
     * 
     * @param id 水库信息ID
     * @return 水库信息
     */
    @Override
    public SysReservoirInfo selectSysReservoirInfoById(Long id)
    {
        return sysReservoirInfoMapper.selectSysReservoirInfoById(id);
    }

    /**
     * 查询水库信息列表
     * 
     * @param sysReservoirInfo 水库信息
     * @return 水库信息
     */
    @Override
    public List<SysReservoirInfo> selectSysReservoirInfoList(SysReservoirInfo sysReservoirInfo)
    {
        return sysReservoirInfoMapper.selectSysReservoirInfoList(sysReservoirInfo);
    }

    /**
     * 新增水库信息
     * 
     * @param sysReservoirInfo 水库信息
     * @return 结果
     */
    @Override
	public int insertSysReservoirInfo(SysReservoirInfo sysReservoirInfo) {
		sysReservoirInfo.setCreateTime(DateUtils.getNowDate());
		sysReservoirInfo.setCreateId(SecurityUtils.getUserId());
		sysReservoirInfo.setUpdatedTime(DateUtils.getNowDate());
		sysReservoirInfo.setUpdatedId(SecurityUtils.getUserId());

		int rows = sysReservoirInfoMapper.insertSysReservoirInfo(sysReservoirInfo);

		// 调用系统管理服务-保存水库超级管理员信息
		R<SysUser> r = remoteUserService.addDefaultUser(this.initSysUser(sysReservoirInfo));

		// 更新水库表超级管理员信息
		if (r.getCode() == R.SUCCESS) {
			sysReservoirInfo.setfAdminUserId(r.getData().getUserId());
			sysReservoirInfo.setfAdminUserName(r.getData().getUserName());
			sysReservoirInfoMapper.updateSysReservoirInfo(sysReservoirInfo);
		} else {
			throw new CustomException("创建水库超级管理员失败："+ r.getMsg());
		}

		return rows;
	}
    /**
     * 初始化水库超级管理员用户
     * @param sysReservoirInfo
     * @return
     */
    public SysUser initSysUser(SysReservoirInfo sysReservoirInfo) {
    	
    	SysUser user = new SysUser();
    	user.setfReservoirInfoId(sysReservoirInfo.getId());
    	user.setNickName(sysReservoirInfo.getfName()+"超级管理员");
    	user.setUserName(sysReservoirInfo.getfReservoirKey()+"admin");
    	user.setPassword(Constant.DEFAULT_RESERVOIR_ADMIN_PASSWORD);
    	
    	//设置 默认岗位
    	user.setPostIds(Constant.DEFAULT_RESERVOIR_ADMIN_POST_IDS);
    	//设置默认角色
    	user.setRoleIds(Constant.DEFAULT_RESERVOIR_ADMIN_ROLE_IDS);
    	//设置默认部门
    	user.setDeptId(Constant.DEFAULT_RESERVOIR_ADMIN_DEPT_ID);
    	
    	return user;
    }

    /**
     * 修改水库信息
     * 
     * @param sysReservoirInfo 水库信息
     * @return 结果
     */
    @Override
    public int updateSysReservoirInfo(SysReservoirInfo sysReservoirInfo)
    {
    	 sysReservoirInfo.setUpdatedTime(DateUtils.getNowDate());
         sysReservoirInfo.setUpdatedId(SecurityUtils.getUserId());
         
        return sysReservoirInfoMapper.updateSysReservoirInfo(sysReservoirInfo);
    }

    /**
     * 批量删除水库信息
     * 
     * @param ids 需要删除的水库信息ID
     * @return 结果
     */
    @Override
    public int deleteSysReservoirInfoByIds(Long[] ids)
    {
        return sysReservoirInfoMapper.deleteSysReservoirInfoByIds(ids);
    }

    /**
     * 删除水库信息信息
     * 
     * @param id 水库信息ID
     * @return 结果
     */
    @Override
    public int deleteSysReservoirInfoById(Long id)
    {
        return sysReservoirInfoMapper.deleteSysReservoirInfoById(id);
    }
    /**
     * 查询到登录人所属的水库信息
     * @param sysReservoirInfo
     * @return
     */
    @Reservoir
	public SysReservoirInfo getCurrentInfo(SysReservoirInfo sysReservoirInfo) {
    	
    	return   sysReservoirInfoMapper.selectSysReservoirInfoById(sysReservoirInfo.getfReservoirInfoId());
    	
	}
}
