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
import com.szsk.reservoir.run.domain.REventProcess;
import com.szsk.reservoir.run.service.IREventProcessService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 事件处置Controller
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
@RestController
@RequestMapping("/process")
public class REventProcessController extends BaseController
{
    @Autowired
    private IREventProcessService rEventProcessService;

    /**
     * 查询事件处置列表
     */
//    @PreAuthorize(hasPermi = "run:process:list")
    @GetMapping("/list")
    public TableDataInfo list(REventProcess rEventProcess)
    {
        startPage();
        List<REventProcess> list = rEventProcessService.selectREventProcessList(rEventProcess);
        return getDataTable(list);
    }

    /**
     * 导出事件处置列表
     */
//    @PreAuthorize(hasPermi = "run:process:export")
    @Log(title = "事件处置", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, REventProcess rEventProcess) throws IOException
    {
        List<REventProcess> list = rEventProcessService.selectREventProcessList(rEventProcess);
        ExcelUtil<REventProcess> util = new ExcelUtil<REventProcess>(REventProcess.class);
        util.exportExcel(response, list, "事件处置数据");
    }

    /**
     * 获取事件处置详细信息
     */
//    @PreAuthorize(hasPermi = "run:process:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rEventProcessService.selectREventProcessById(fId));
    }

    /**
     * 新增事件处置
     */
//    @PreAuthorize(hasPermi = "run:process:add")
    @Log(title = "事件处置", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody REventProcess rEventProcess)
    {
        return toAjax(rEventProcessService.insertREventProcess(rEventProcess));
    }

    /**
     * 修改事件处置
     */
//    @PreAuthorize(hasPermi = "run:process:edit")
    @Log(title = "事件处置", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody REventProcess rEventProcess)
    {
        return toAjax(rEventProcessService.updateREventProcess(rEventProcess));
    }

    /**
     * 删除事件处置
     */
//    @PreAuthorize(hasPermi = "run:process:remove")
    @Log(title = "事件处置", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rEventProcessService.deleteREventProcessByIds(fIds));
    }
}
