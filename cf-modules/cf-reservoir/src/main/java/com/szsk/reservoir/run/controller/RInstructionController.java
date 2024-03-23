package com.szsk.reservoir.run.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.szsk.reservoir.run.domain.RInstruction;
import com.szsk.reservoir.run.service.IRInstructionService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 调度指令 Controller
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
@RestController
@RequestMapping("/instruction")
public class RInstructionController extends BaseController
{
    @Autowired
    private IRInstructionService rInstructionService;

    /**
     * 查询调度指令 列表
     */
//    @PreAuthorize(hasPermi = "run:instruction:list")
    @GetMapping("/list")
    public TableDataInfo list(RInstruction rInstruction)
    {
        startPage();
        List<RInstruction> list = rInstructionService.selectRInstructionList(rInstruction);
        for (RInstruction instruction : list) {
            instruction.setLandingPersonId(SecurityUtils.getUserId());
        }
        return getDataTable(list);
    }

    /**
     * 导出调度指令 列表
     */
//    @PreAuthorize(hasPermi = "run:instruction:export")
    @Log(title = "调度指令 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RInstruction rInstruction) throws IOException
    {
        List<RInstruction> list = rInstructionService.selectRInstructionList(rInstruction);
        ExcelUtil<RInstruction> util = new ExcelUtil<RInstruction>(RInstruction.class);
        util.exportExcel(response, list, "调度指令 数据");
    }

    /**
     * 获取调度指令 详细信息
     */
//    @PreAuthorize(hasPermi = "run:instruction:query")
    @GetMapping(value = "/{fInstructionId}")
    public AjaxResult getInfo(@PathVariable("fInstructionId") Integer fInstructionId)
    {
        return AjaxResult.success(rInstructionService.selectRInstructionById(fInstructionId));
    }

    /**
     * 新增调度指令 
     */
//    @PreAuthorize(hasPermi = "run:instruction:add")
    @Log(title = "调度指令 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RInstruction rInstruction)
    {
        return rInstructionService.insertRInstruction(rInstruction);
    }

    /**
     * 修改调度指令 
     */
//    @PreAuthorize(hasPermi = "run:instruction:edit")
    @Log(title = "调度指令 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RInstruction rInstruction)
    {
        return rInstructionService.updateRInstruction(rInstruction);
    }

    /**
     * 删除调度指令 
     */
//    @PreAuthorize(hasPermi = "run:instruction:remove")
    @Log(title = "调度指令 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fInstructionIds}")
    public AjaxResult remove(@PathVariable Integer[] fInstructionIds)
    {
        return toAjax(rInstructionService.deleteRInstructionByIds(fInstructionIds));
    }
}
