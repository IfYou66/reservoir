package com.szsk.reservoir.run.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.szsk.reservoir.run.domain.RControl;
import com.szsk.reservoir.run.service.IRControlService;
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
import com.szsk.reservoir.run.domain.RAnnualScheduling;
import com.szsk.reservoir.run.service.IRAnnualSchedulingService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 年度调度总结 Controller
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
@RestController
@RequestMapping("/scheduling")
public class RAnnualSchedulingController extends BaseController
{
    @Autowired
    private IRAnnualSchedulingService rAnnualSchedulingService;
    @Autowired
    private IRControlService rControlService;

    /**
     * 查询年度调度总结 列表
     */
    @PreAuthorize(hasPermi = "run:scheduling:list")
    @GetMapping("/list")
    public TableDataInfo list(RAnnualScheduling rAnnualScheduling)
    {
        startPage();
        rAnnualScheduling.setfCreateBy(SecurityUtils.getUserId());
        List<RAnnualScheduling> list = rAnnualSchedulingService.selectRAnnualSchedulingList(rAnnualScheduling);
        return getDataTable(list);
    }

    /**
     * 导出年度调度总结 列表
     */
    @PreAuthorize(hasPermi = "run:scheduling:export")
    @Log(title = "年度调度总结 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RAnnualScheduling rAnnualScheduling) throws IOException
    {
        List<RAnnualScheduling> list = rAnnualSchedulingService.selectRAnnualSchedulingList(rAnnualScheduling);
        ExcelUtil<RAnnualScheduling> util = new ExcelUtil<RAnnualScheduling>(RAnnualScheduling.class);
        util.exportExcel(response, list, "年度调度总结 数据");
    }

    /**
     * 获取年度调度总结 详细信息
     */
    @PreAuthorize(hasPermi = "run:scheduling:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Integer fId)
    {
        return AjaxResult.success(rAnnualSchedulingService.selectRAnnualSchedulingById(fId));
    }

    /**
     * 新增年度调度总结 
     */
    @PreAuthorize(hasPermi = "run:scheduling:add")
    @Log(title = "年度调度总结 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RAnnualScheduling rAnnualScheduling)
    {
        return toAjax(rAnnualSchedulingService.insertRAnnualScheduling(rAnnualScheduling));
    }

    /**
     * 修改年度调度总结 
     */
    @PreAuthorize(hasPermi = "run:scheduling:edit")
    @Log(title = "年度调度总结 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RAnnualScheduling rAnnualScheduling)
    {
        return toAjax(rAnnualSchedulingService.updateRAnnualScheduling(rAnnualScheduling));
    }

    /**
     * 删除年度调度总结 
     */
    @PreAuthorize(hasPermi = "run:scheduling:remove")
    @Log(title = "年度调度总结 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Integer[] fIds)
    {
        return toAjax(rAnnualSchedulingService.deleteRAnnualSchedulingByIds(fIds));
    }

    /**
     * 流程
     */
    @Log(title = "start流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/startWorkFlow")
    public AjaxResult startWorkFlow(@RequestBody RAnnualScheduling rAnnualScheduling)
    {
        return rAnnualSchedulingService.startWorkFlow(rAnnualScheduling);
    }
    @Log(title = "流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/taskReview")
    public AjaxResult taskReview(@RequestBody RAnnualScheduling rAnnualScheduling)
    {
        return rAnnualSchedulingService.taskReview(rAnnualScheduling);
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