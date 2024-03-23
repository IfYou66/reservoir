package com.szsk.reservoir.run.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.szsk.reservoir.run.domain.RCheckRecord;
import com.szsk.reservoir.run.service.IRCheckRecordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 安全检查记录 Controller
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
@RestController
@RequestMapping("/checkRecord")
public class RCheckRecordController extends BaseController
{
    @Autowired
    private IRCheckRecordService rCheckRecordService;

    /**
     * 查询安全检查记录 列表
     */
//    @PreAuthorize(hasPermi = "run:checkRecord:list")
    @GetMapping("/list")
    public TableDataInfo list(RCheckRecord rCheckRecord)
    {
        startPage();
        List<RCheckRecord> list = rCheckRecordService.selectRCheckRecordList(rCheckRecord);
        return getDataTable(list);
    }

    /**
     * 导出安全检查记录 列表
     */
//    @PreAuthorize(hasPermi = "run:checkRecord:export")
    @Log(title = "安全检查记录 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RCheckRecord rCheckRecord) throws IOException
    {
        List<RCheckRecord> list = rCheckRecordService.selectRCheckRecordList(rCheckRecord);
        ExcelUtil<RCheckRecord> util = new ExcelUtil<RCheckRecord>(RCheckRecord.class);
        util.exportExcel(response, list, "安全检查记录 数据");
    }

    /**
     * 获取安全检查记录 详细信息
     */
//    @PreAuthorize(hasPermi = "run:checkRecord:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rCheckRecordService.selectRCheckRecordById(fId));
    }

    /**
     * 根据安全检查实施表id获取安全检查记录集合
     */
    @GetMapping("/getMuster")
    public AjaxResult getMuster(@RequestParam Long fSecuimpId)
    {
        return AjaxResult.success(rCheckRecordService.getMusterBySecuimpId(fSecuimpId));
    }

    /**
     * 新增安全检查记录 
     */
//    @PreAuthorize(hasPermi = "run:checkRecord:add")
    @Log(title = "安全检查记录 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RCheckRecord rCheckRecord)
    {
        return toAjax(rCheckRecordService.insertRCheckRecord(rCheckRecord));
    }

    /**
     * 修改安全检查记录 
     */
//    @PreAuthorize(hasPermi = "run:checkRecord:edit")
    @Log(title = "安全检查记录 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RCheckRecord rCheckRecord)
    {
        return toAjax(rCheckRecordService.updateRCheckRecord(rCheckRecord));
    }

    /**
     * 删除安全检查记录 
     */
//    @PreAuthorize(hasPermi = "run:checkRecord:remove")
    @Log(title = "安全检查记录 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rCheckRecordService.deleteRCheckRecordByIds(fIds));
    }
}
