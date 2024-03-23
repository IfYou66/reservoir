package com.szsk.reservoir.run.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
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
import com.szsk.reservoir.run.domain.RInstructionRunLog;
import com.szsk.reservoir.run.service.IRInstructionRunLogService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 调度指令执行记录 Controller
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
@RestController
@RequestMapping("/log")
public class RInstructionRunLogController extends BaseController
{
    @Autowired
    private IRInstructionRunLogService rInstructionRunLogService;

    /**
     * 查询调度指令执行记录 列表
     */
//    @PreAuthorize(hasPermi = "run:log:list")
    @GetMapping("/list")
    public TableDataInfo list(RInstructionRunLog rInstructionRunLog)
    {
        startPage();
        List<RInstructionRunLog> list = rInstructionRunLogService.selectRInstructionRunLogList(rInstructionRunLog);
        return getDataTable(list);
    }

    /**
     * 导出调度指令执行记录 列表
     */
//    @PreAuthorize(hasPermi = "run:log:export")
    @Log(title = "调度指令执行记录 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RInstructionRunLog rInstructionRunLog) throws IOException
    {
        List<RInstructionRunLog> list = rInstructionRunLogService.selectRInstructionRunLogList(rInstructionRunLog);
        ExcelUtil<RInstructionRunLog> util = new ExcelUtil<RInstructionRunLog>(RInstructionRunLog.class);
        util.exportExcel(response, list, "调度指令执行记录 数据");
    }

    /**
     * 获取调度指令执行记录 详细信息
     */
//    @PreAuthorize(hasPermi = "run:log:query")
    @GetMapping(value = "/{fLogId}")
    public AjaxResult getInfo(@PathVariable("fLogId") Integer fLogId)
    {
        return AjaxResult.success(rInstructionRunLogService.selectRInstructionRunLogById(fLogId));
    }

    /**
     * 新增调度指令执行记录 
     */
//    @PreAuthorize(hasPermi = "run:log:add")
    @Log(title = "调度指令执行记录 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RInstructionRunLog rInstructionRunLog)
    {
        return toAjax(rInstructionRunLogService.insertRInstructionRunLog(rInstructionRunLog));
    }

    /**
     * 修改调度指令执行记录 
     */
//    @PreAuthorize(hasPermi = "run:log:edit")
    @Log(title = "调度指令执行记录 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RInstructionRunLog rInstructionRunLog)
    {
        return toAjax(rInstructionRunLogService.updateRInstructionRunLog(rInstructionRunLog));
    }

    /**
     * 删除调度指令执行记录 
     */
//    @PreAuthorize(hasPermi = "run:log:remove")
    @Log(title = "调度指令执行记录 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fLogIds}")
    public AjaxResult remove(@PathVariable Integer[] fLogIds)
    {
        return toAjax(rInstructionRunLogService.deleteRInstructionRunLogByIds(fLogIds));
    }
}
