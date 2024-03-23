package com.szsk.reservoir.manageSystem.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.szsk.reservoir.manageSystem.domain.SysClassType;
import com.szsk.reservoir.manageSystem.service.ISysClassTypeService;
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

import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 制度分类 Controller
 *
 * @author cangfeng
 * @date 2021-07-21
 */
@RestController
@RequestMapping("/type")
public class SysClassTypeController extends BaseController
{
    @Autowired
    private ISysClassTypeService sysClassTypeService;

    /**
     * 查询制度分类 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysClassType sysClassType)
    {
        startPage();
        List<SysClassType> list = sysClassTypeService.selectSysClassTypeList(sysClassType);
        return getDataTable(list);
    }

    /**
     * 导出制度分类 列表
     */
    @Log(title = "制度分类 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysClassType sysClassType) throws IOException
    {
        List<SysClassType> list = sysClassTypeService.selectSysClassTypeList(sysClassType);
        ExcelUtil<SysClassType> util = new ExcelUtil<SysClassType>(SysClassType.class);
        util.exportExcel(response, list, "制度分类 数据");
    }

    /**
     * 获取制度分类 详细信息
     */
    @GetMapping(value = "/{fTypeId}")
    public AjaxResult getInfo(@PathVariable("fTypeId") Long fTypeId)
    {
        return AjaxResult.success(sysClassTypeService.selectSysClassTypeById(fTypeId));
    }

    /**
     * 新增制度分类
     */
    @Log(title = "制度分类 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysClassType sysClassType)
    {
        return toAjax(sysClassTypeService.insertSysClassType(sysClassType));
    }

    /**
     * 修改制度分类
     */
    @Log(title = "制度分类 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysClassType sysClassType)
    {
        return toAjax(sysClassTypeService.updateSysClassType(sysClassType));
    }

    /**
     * 删除制度分类
     */
    @Log(title = "制度分类 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fTypeIds}")
    public AjaxResult remove(@PathVariable Long[] fTypeIds)
    {
            return toAjax(sysClassTypeService.deleteSysClassTypeByIds(fTypeIds));
    }

    /**
     * 获取档案分类下拉树列表
     */
    @GetMapping("/treeselect")
    public AjaxResult treeselect(SysClassType sysClassType)
    {
        List<SysClassType> archivesTypeList = sysClassTypeService.selectSysClassTypeList(sysClassType);
        return AjaxResult.success(sysClassTypeService.buildArchivesTypeTreeSelect(archivesTypeList));
    }
}