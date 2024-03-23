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
import com.szsk.reservoir.run.domain.REventRecord;
import com.szsk.reservoir.run.service.IREventRecordService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 事件记录 Controller
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
@RestController
@RequestMapping("/eventRecord")
public class REventRecordController extends BaseController
{
    @Autowired
    private IREventRecordService rEventRecordService;

    /**
     * 查询事件记录 列表
     */
//    @PreAuthorize(hasPermi = "run:eventRecord:list")
    @GetMapping("/list")
    public TableDataInfo list(REventRecord rEventRecord)
    {
        startPage();
        List<REventRecord> list = rEventRecordService.selectREventRecordList(rEventRecord);
        return getDataTable(list);
    }

    /**
     * 导出事件记录 列表
     */
//    @PreAuthorize(hasPermi = "run:eventRecord:export")
    @Log(title = "事件记录 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, REventRecord rEventRecord) throws IOException
    {
        List<REventRecord> list = rEventRecordService.selectREventRecordList(rEventRecord);
        ExcelUtil<REventRecord> util = new ExcelUtil<REventRecord>(REventRecord.class);
        util.exportExcel(response, list, "事件记录 数据");
    }

    /**
     * 获取事件记录 详细信息
     */
//    @PreAuthorize(hasPermi = "run:eventRecord:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rEventRecordService.selectREventRecordById(fId));
    }

    /**
     * 新增事件记录 
     */
//    @PreAuthorize(hasPermi = "run:eventRecord:add")
    @Log(title = "事件记录 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody REventRecord rEventRecord)
    {
        return toAjax(rEventRecordService.insertREventRecord(rEventRecord));
    }

    /**
     * 修改事件记录 
     */
//    @PreAuthorize(hasPermi = "run:eventRecord:edit")
    @Log(title = "事件记录 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody REventRecord rEventRecord)
    {
        return toAjax(rEventRecordService.updateREventRecord(rEventRecord));
    }

    /**
     * 删除事件记录 
     */
//    @PreAuthorize(hasPermi = "run:eventRecord:remove")
    @Log(title = "事件记录 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rEventRecordService.deleteREventRecordByIds(fIds));
    }
}
