package com.szsk.reservoir.manageSystem.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.szsk.reservoir.manageSystem.domain.SysJoinTraining;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.szsk.reservoir.manageSystem.domain.SysTraining;
import com.szsk.reservoir.manageSystem.service.ISysTrainingService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 培训Controller
 * 
 * @author cangfeng
 * @date 2021-08-13
 */
@RestController
@RequestMapping("/training")
public class SysTrainingController extends BaseController
{
    @Autowired
    private ISysTrainingService sysTrainingService;

    /**
     * 查询培训列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysTraining sysTraining)
    {
        startPage();
        List<SysTraining> list = sysTrainingService.selectSysTrainingList(sysTraining);
        for (SysTraining training : list) {
            training.setLandingPersonId(SecurityUtils.getUserId());
        }
        return getDataTable(list);
    }

    /**
     * 导出培训列表
     */
    @Log(title = "培训", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysTraining sysTraining) throws IOException
    {
        List<SysTraining> list = sysTrainingService.selectSysTrainingList(sysTraining);
        ExcelUtil<SysTraining> util = new ExcelUtil<SysTraining>(SysTraining.class);
        util.exportExcel(response, list, "培训数据");
    }

    /**
     * 获取培训详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(sysTrainingService.selectSysTrainingById(fId));
    }

    /**
     * 新增培训
     */

    @Log(title = "培训", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysTraining sysTraining)
    {
        return toAjax(sysTrainingService.insertSysTraining(sysTraining));
    }

    /**
     * 修改培训
     */
    @Log(title = "培训", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysTraining sysTraining)
    {
        return sysTrainingService.updateSysTraining(sysTraining);
    }

    /**
     * 删除培训
     */
    @Log(title = "培训", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(sysTrainingService.deleteSysTrainingByIds(fIds));
    }

    @Log(title = "初始化培训编制表格数据")
    @GetMapping("/queryDataDictionary")
    public AjaxResult queryDataDictionary(){
        return sysTrainingService.queryDataDictionary();
    }

    @Log(title = "根据类型查询数据字典")
    @GetMapping("/dataQuery")
    public AjaxResult dataQuery(@RequestParam String dictType) {
        return sysTrainingService.dataQuery(dictType);
    }

}
