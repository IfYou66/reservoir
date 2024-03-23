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
import com.szsk.reservoir.run.domain.RFloodRegulationEvaluation;
import com.szsk.reservoir.run.service.IRFloodRegulationEvaluationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 洪水调度考评 Controller
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
@RestController
@RequestMapping("/evaluation")
public class RFloodRegulationEvaluationController extends BaseController
{
    @Autowired
    private IRFloodRegulationEvaluationService rFloodRegulationEvaluationService;

    /**
     * 查询洪水调度考评 列表
     */
    @PreAuthorize(hasPermi = "run:evaluation:list")
    @GetMapping("/list")
    public TableDataInfo list(RFloodRegulationEvaluation rFloodRegulationEvaluation)
    {
        startPage();
        List<RFloodRegulationEvaluation> list = rFloodRegulationEvaluationService.selectRFloodRegulationEvaluationList(rFloodRegulationEvaluation);
        return getDataTable(list);
    }

    /**
     * 导出洪水调度考评 列表
     */
    @PreAuthorize(hasPermi = "run:evaluation:export")
    @Log(title = "洪水调度考评 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RFloodRegulationEvaluation rFloodRegulationEvaluation) throws IOException
    {
        List<RFloodRegulationEvaluation> list = rFloodRegulationEvaluationService.selectRFloodRegulationEvaluationList(rFloodRegulationEvaluation);
        ExcelUtil<RFloodRegulationEvaluation> util = new ExcelUtil<RFloodRegulationEvaluation>(RFloodRegulationEvaluation.class);
        util.exportExcel(response, list, "洪水调度考评 数据");
    }

    /**
     * 获取洪水调度考评 详细信息
     */
    @PreAuthorize(hasPermi = "run:evaluation:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rFloodRegulationEvaluationService.selectRFloodRegulationEvaluationById(fId));
    }

    /**
     * 新增洪水调度考评 
     */
    @PreAuthorize(hasPermi = "run:evaluation:add")
    @Log(title = "洪水调度考评 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RFloodRegulationEvaluation rFloodRegulationEvaluation)
    {
        return toAjax(rFloodRegulationEvaluationService.insertRFloodRegulationEvaluation(rFloodRegulationEvaluation));
    }

    /**
     * 修改洪水调度考评 
     */
    @PreAuthorize(hasPermi = "run:evaluation:edit")
    @Log(title = "洪水调度考评 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RFloodRegulationEvaluation rFloodRegulationEvaluation)
    {
        return toAjax(rFloodRegulationEvaluationService.updateRFloodRegulationEvaluation(rFloodRegulationEvaluation));
    }

    /**
     * 删除洪水调度考评 
     */
    @PreAuthorize(hasPermi = "run:evaluation:remove")
    @Log(title = "洪水调度考评 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rFloodRegulationEvaluationService.deleteRFloodRegulationEvaluationByIds(fIds));
    }
}
