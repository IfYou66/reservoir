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
import com.szsk.reservoir.run.domain.RFloodSeason;
import com.szsk.reservoir.run.service.IRFloodSeasonService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 汛期调度运行计划 Controller
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
@RestController
@RequestMapping("/season")
public class RFloodSeasonController extends BaseController
{
    @Autowired
    private IRFloodSeasonService rFloodSeasonService;

    /**
     * 查询汛期调度运行计划 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RFloodSeason rFloodSeason)
    {
        startPage();
        List<RFloodSeason> list = rFloodSeasonService.selectRFloodSeasonList(rFloodSeason);
        return getDataTable(list);
    }

    /**
     * 导出汛期调度运行计划 列表
     */
    @Log(title = "汛期调度运行计划 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RFloodSeason rFloodSeason) throws IOException
    {
        List<RFloodSeason> list = rFloodSeasonService.selectRFloodSeasonList(rFloodSeason);
        ExcelUtil<RFloodSeason> util = new ExcelUtil<RFloodSeason>(RFloodSeason.class);
        util.exportExcel(response, list, "汛期调度运行计划 数据");
    }

    /**
     * 获取汛期调度运行计划 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rFloodSeasonService.selectRFloodSeasonById(fId));
    }

    /**
     * 新增汛期调度运行计划 
     */
    @Log(title = "汛期调度运行计划 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RFloodSeason rFloodSeason)
    {
        return toAjax(rFloodSeasonService.insertRFloodSeason(rFloodSeason));
    }

    /**
     * 修改汛期调度运行计划 
     */
    @Log(title = "汛期调度运行计划 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RFloodSeason rFloodSeason)
    {
        return toAjax(rFloodSeasonService.updateRFloodSeason(rFloodSeason));
    }

    /**
     * 删除汛期调度运行计划 
     */
    @Log(title = "汛期调度运行计划 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rFloodSeasonService.deleteRFloodSeasonByIds(fIds));
    }
}
