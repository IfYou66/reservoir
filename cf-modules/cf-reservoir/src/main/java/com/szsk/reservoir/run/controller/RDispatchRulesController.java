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
import com.szsk.reservoir.run.domain.RDispatchRules;
import com.szsk.reservoir.run.service.IRDispatchRulesService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 水库调度规程 Controller
 * 
 * @author cangfeng
 * @date 2021-11-09
 */
@RestController
@RequestMapping("/rules")
public class RDispatchRulesController extends BaseController
{
    @Autowired
    private IRDispatchRulesService rDispatchRulesService;

    /**
     * 查询水库调度规程 列表
     */
    @PreAuthorize(hasPermi = "run:rules:list")
    @GetMapping("/list")
    public TableDataInfo list(RDispatchRules rDispatchRules)
    {
        startPage();
        List<RDispatchRules> list = rDispatchRulesService.selectRDispatchRulesList(rDispatchRules);
        return getDataTable(list);
    }

    /**
     * 导出水库调度规程 列表
     */
    @PreAuthorize(hasPermi = "run:rules:export")
    @Log(title = "水库调度规程 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RDispatchRules rDispatchRules) throws IOException
    {
        List<RDispatchRules> list = rDispatchRulesService.selectRDispatchRulesList(rDispatchRules);
        ExcelUtil<RDispatchRules> util = new ExcelUtil<RDispatchRules>(RDispatchRules.class);
        util.exportExcel(response, list, "水库调度规程 数据");
    }

    /**
     * 获取水库调度规程 详细信息
     */
    @PreAuthorize(hasPermi = "run:rules:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rDispatchRulesService.selectRDispatchRulesById(fId));
    }

    /**
     * 新增水库调度规程 
     */
    @PreAuthorize(hasPermi = "run:rules:add")
    @Log(title = "水库调度规程 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RDispatchRules rDispatchRules)
    {
        return toAjax(rDispatchRulesService.insertRDispatchRules(rDispatchRules));
    }

    /**
     * 修改水库调度规程 
     */
    @PreAuthorize(hasPermi = "run:rules:edit")
    @Log(title = "水库调度规程 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RDispatchRules rDispatchRules)
    {
        return toAjax(rDispatchRulesService.updateRDispatchRules(rDispatchRules));
    }

    /**
     * 删除水库调度规程 
     */
    @PreAuthorize(hasPermi = "run:rules:remove")
    @Log(title = "水库调度规程 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rDispatchRulesService.deleteRDispatchRulesByIds(fIds));
    }
}
