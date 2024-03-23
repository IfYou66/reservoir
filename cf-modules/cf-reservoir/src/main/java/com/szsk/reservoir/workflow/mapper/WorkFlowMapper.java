package com.szsk.reservoir.workflow.mapper;

import com.szsk.reservoir.workflow.domain.RoleVO;

import java.util.List;
import java.util.Map;

/**
 * @author: wangcc
 * @create: 2021/8/10 12:04
 * @description:
 **/
public interface WorkFlowMapper {

    /**
     * 删除流程
     */
     public int updateBusinessActiviti(Map<String, Object> params);

    /**
     * 查询用户角色
     * @return
     */
    public List<RoleVO> getRoles(Long userId);
}
