package com.szsk.reservoir.emergency.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.szsk.reservoir.emergency.domain.MEmergencyPlanning;
import com.szsk.reservoir.emergency.service.IMEmergencyPlanningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 水库预案编制 Controller
 *
 * @author cangfeng
 * @date 2021-08-18
 */
@RestController
@RequestMapping("/planning")
public class MEmergencyPlanningController extends BaseController{

    @Autowired
    private IMEmergencyPlanningService mEmergencyPlanningService;

    /**
     * 查询水库预案编制 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(MEmergencyPlanning mEmergencyPlanning)
    {
        startPage();
        mEmergencyPlanning.setfCreateBy(SecurityUtils.getUserId());
        List<MEmergencyPlanning> list = mEmergencyPlanningService.selectMEmergencyPlanningList(mEmergencyPlanning);
        return getDataTable(list);
    }

    /**
     * 导出水库预案编制 列表
     */
    @Log(title = "水库预案编制 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MEmergencyPlanning mEmergencyPlanning) throws IOException
    {
        List<MEmergencyPlanning> list = mEmergencyPlanningService.selectMEmergencyPlanningList(mEmergencyPlanning);
        ExcelUtil<MEmergencyPlanning> util = new ExcelUtil<MEmergencyPlanning>(MEmergencyPlanning.class);
        util.exportExcel(response, list, "水库预案编制 数据");
    }

    /**
     * 获取水库预案编制 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(mEmergencyPlanningService.selectMEmergencyPlanningById(fId));
    }

    /**
     * 新增水库预案编制
     */
    @Log(title = "水库预案编制 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MEmergencyPlanning mEmergencyPlanning){
        //当前用户
        mEmergencyPlanning.setfCreateBy(SecurityUtils.getUserId());
        return toAjax(mEmergencyPlanningService.insertMEmergencyPlanning(mEmergencyPlanning));
    }

    /**
     * 修改水库预案编制
     */
    @Log(title = "水库预案编制 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MEmergencyPlanning mEmergencyPlanning){
        return toAjax(mEmergencyPlanningService.updateMEmergencyPlanning(mEmergencyPlanning));
    }

    /**
     * 删除水库预案编制
     */
    @Log(title = "水库预案编制 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(mEmergencyPlanningService.deleteMEmergencyPlanningByIds(fIds));
    }


    @Log(title = "根据类型查询数据字典")
    @GetMapping("/planDataQuery")
    public AjaxResult dataQuery(@RequestParam String dictType) {
        return mEmergencyPlanningService.dataQuery(dictType);
    }
}
