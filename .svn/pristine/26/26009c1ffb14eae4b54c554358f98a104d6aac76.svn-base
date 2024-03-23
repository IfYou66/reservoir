package com.szsk.reservoir.run.mapper;

import java.util.List;
import com.szsk.reservoir.run.domain.RInstruction;

/**
 * 调度指令 Mapper接口
 *
 * @author cangfeng
 * @date 2021-08-23
 */
public interface RInstructionMapper
{
    /**
     * 查询调度指令
     *
     * @param fInstructionId 调度指令 ID
     * @return 调度指令
     */
    public RInstruction selectRInstructionById(Integer fInstructionId);

    /**
     * 查询调度指令 列表
     *
     * @param rInstruction 调度指令
     * @return 调度指令 集合
     */
    public List<RInstruction> selectRInstructionList(RInstruction rInstruction);

    /**
     * 查询调度指令 列表
     *
     * @param rInstruction 调度指令
     * @return 调度指令 集合
     */
    public List<RInstruction> search(RInstruction rInstruction);

    /**
     * 新增调度指令
     *
     * @param rInstruction 调度指令
     * @return 结果
     */
    public int insertRInstruction(RInstruction rInstruction);

    /**
     * 修改调度指令
     *
     * @param rInstruction 调度指令
     * @return 结果
     */
    public int updateRInstruction(RInstruction rInstruction);

    /**
     * 删除调度指令
     *
     * @param fInstructionId 调度指令 ID
     * @return 结果
     */
    public int deleteRInstructionById(Integer fInstructionId);

    /**
     * 批量删除调度指令
     *
     * @param fInstructionIds 需要删除的数据ID
     * @return 结果
     */
    public int deleteRInstructionByIds(Integer[] fInstructionIds);
}
