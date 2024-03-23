package com.szsk.reservoir.run.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.security.service.TokenService;
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
import com.szsk.reservoir.run.domain.RControlImpl;
import com.szsk.reservoir.run.service.IRControlImplService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 控制运行计划实施Controller
 * 
 * @author cangfeng
 * @date 2021-08-26
 */
@RestController
@RequestMapping("/controlImpl")
public class RControlImplController extends BaseController
{
    @Autowired
    private IRControlImplService rControlImplService;

    /**
     * 查询控制运行计划实施列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RControlImpl rControlImpl)
    {
        startPage();
        Long reservoirId = SecurityUtils.getReservoirId();
        rControlImpl.setfReservoirInfoId(reservoirId);
        List<RControlImpl> list = rControlImplService.selectRControlImplList(rControlImpl);
        return getDataTable(list);
    }
    /**
     * 导出控制运行计划实施列表
     */
    @Log(title = "控制运行计划实施", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RControlImpl rControlImpl) throws IOException
    {
        List<RControlImpl> list = rControlImplService.selectRControlImplList(rControlImpl);
        ExcelUtil<RControlImpl> util = new ExcelUtil<RControlImpl>(RControlImpl.class);
        util.exportExcel(response, list, "控制运行计划实施数据");
    }

    /**
     * 获取控制运行计划实施详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rControlImplService.selectRControlImplById(fId));
    }

    /**
     * 新增控制运行计划实施
     */
    @Log(title = "控制运行计划实施", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RControlImpl rControlImpl)
    {
        return toAjax(rControlImplService.setRControlImpl(rControlImpl));
    }

    /**
     * 修改控制运行计划实施
     */
    @Log(title = "控制运行计划实施", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RControlImpl rControlImpl)
    {
        return toAjax(rControlImplService.updateRControlImpl(rControlImpl));
    }

    /**
     * 删除控制运行计划实施
     */
    @Log(title = "控制运行计划实施", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rControlImplService.deleteRControlImplByIds(fIds));
    }

    /**
     * 流程
     */
    @Log(title = "start流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/startWorkFlow")
    public AjaxResult startWorkFlow(@RequestBody RControlImpl rControlImpl)
    {
        return rControlImplService.startWorkFlow(rControlImpl);
    }
    @Log(title = "流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/taskReview")
    public AjaxResult taskReview(@RequestBody RControlImpl rControlImpl)
    {
        return rControlImplService.taskReview(rControlImpl);
    }

    /**
     * 获取最近
     */
    @GetMapping("/latelyControl")
    public AjaxResult latelyControl()
    {
        return AjaxResult.success(rControlImplService.latelyControl());
    }

}
