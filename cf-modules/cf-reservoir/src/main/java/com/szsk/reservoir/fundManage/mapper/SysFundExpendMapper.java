package com.szsk.reservoir.fundManage.mapper;

import java.util.List;
import com.szsk.reservoir.fundManage.domain.SysFundExpend;

/**
 * 经费支出 Mapper接口
 * 
 * @author cangfeng
 * @date 2021-08-18
 */
public interface SysFundExpendMapper 
{
    /**
     * 查询经费支出 
     * 
     * @param fId 经费支出 ID
     * @return 经费支出 
     */
    public SysFundExpend selectSysFundExpendById(Long fId);

    /**
     * 查询经费支出 列表
     * 
     * @param sysFundExpend 经费支出 
     * @return 经费支出 集合
     */
    public List<SysFundExpend> selectSysFundExpendList(SysFundExpend sysFundExpend);


    /**
     * 查询经费支出 列表
     *
     * @param sysFundExpend 经费支出
     * @return 经费支出 集合
     */
    public List<SysFundExpend> search(SysFundExpend sysFundExpend);

    /**
     * 新增经费支出 
     * 
     * @param sysFundExpend 经费支出 
     * @return 结果
     */
    public int insertSysFundExpend(SysFundExpend sysFundExpend);

    /**
     * 修改经费支出 
     * 
     * @param sysFundExpend 经费支出 
     * @return 结果
     */
    public int updateSysFundExpend(SysFundExpend sysFundExpend);

    /**
     * 删除经费支出 
     * 
     * @param fId 经费支出 ID
     * @return 结果
     */
    public int deleteSysFundExpendById(Long fId);

    /**
     * 批量删除经费支出 
     * 
     * @param fIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteSysFundExpendByIds(Long[] fIds);
}
