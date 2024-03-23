package com.szsk.reservoir.run.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.szsk.reservoir.security.domain.MReinforcement;
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
import com.szsk.reservoir.run.domain.RControl;
import com.szsk.reservoir.run.service.IRControlService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 控制运行计划 Controller
 * 
 * @author cangfeng
 * @date 2021-08-23
 */
@RestController
@RequestMapping("/control")
public class RControlController extends BaseController
{
    @Autowired
    private IRControlService rControlService;

    /**
     * 查询控制运行计划 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RControl rControl)
    {
        startPage();
        List<RControl> list = rControlService.selectRControlList(rControl);
        return getDataTable(list);
    }

    /**
     * 导出控制运行计划 列表
     */
    @Log(title = "控制运行计划 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RControl rControl) throws IOException
    {
        List<RControl> list = rControlService.selectRControlList(rControl);
        ExcelUtil<RControl> util = new ExcelUtil<RControl>(RControl.class);
        util.exportExcel(response, list, "控制运行计划 数据");
    }

    /**
     * 获取控制运行计划 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rControlService.selectRControlById(fId));
    }

    /**
     * 新增控制运行计划 
     */
    @Log(title = "控制运行计划 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RControl rControl)
    {
        return toAjax(rControlService.insertRControl(rControl));
    }

    /**
     * 修改控制运行计划 
     */
    @Log(title = "控制运行计划 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RControl rControl)
    {
        return toAjax(rControlService.updateRControl(rControl));
    }

    /**
     * 删除控制运行计划 
     */
    @Log(title = "控制运行计划 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rControlService.deleteRControlByIds(fIds));
    }

    /**
     * 获取最近
     */
    @GetMapping("/latelyControl")
    public AjaxResult latelyControl()
    {
        return AjaxResult.success(rControlService.latelyControl());
    }

    /**
     * 流程
     */
    @Log(title = "start流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/startWorkFlow")
    public AjaxResult startWorkFlow(@RequestBody RControl rControl)
    {
        return rControlService.startWorkFlow(rControl);
    }
    @Log(title = "流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/taskReview")
    public AjaxResult taskReview(@RequestBody RControl rControl)
    {
        return rControlService.taskReview(rControl);
    }


    /**
     * dict
     */
    @GetMapping("/getDictByType")
    public AjaxResult getDictByType()
    {
        return rControlService.getDictByType();
    }
}
