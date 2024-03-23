package com.szsk.reservoir.manageSystem.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.szsk.reservoir.manageSystem.domain.SysManagement;
import com.szsk.reservoir.manageSystem.service.ISysManagementService;

import io.swagger.annotations.ApiParam;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 制度管理 Controller
 * 
 * @author cangfeng
 * @date 2021-08-12
 */
@RestController
@RequestMapping("/manageSystem")
public class SysManagementController extends BaseController
{
    @Autowired
    private ISysManagementService sysManagementService;

    /**
     * 档案制度、管理保障首页、两册一表等文章类查询使用
     * @param code 分类编码
     */
    @GetMapping("/getManagementInfoByCode")
    public AjaxResult getManagementInfoByCode(@ApiParam(value = "code", required = true) @RequestParam String code)
    {
        return AjaxResult.success(sysManagementService.getManagementInfoByCode(code));
    }
    /**
     * 查询制度管理 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(SysManagement sysManagement)
    {
        startPage();
        List<SysManagement> list;
        if (sysManagement.getfTypeId() == null || sysManagement.getfTypeId() == 0) {
            list = sysManagementService.selectSysManagementList(sysManagement);
        } else {
            list = sysManagementService.selectSysManagementTreeList(sysManagement);
        }
        return getDataTable(list);
    }

    /**
     * 导出制度管理 列表
     */
    @Log(title = "制度管理 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysManagement sysManagement) throws IOException
    {
        List<SysManagement> list = sysManagementService.selectSysManagementList(sysManagement);
        ExcelUtil<SysManagement> util = new ExcelUtil<SysManagement>(SysManagement.class);
        util.exportExcel(response, list, "制度管理 数据");
    }

    /**
     * 获取制度管理 详细信息
     */
    @GetMapping(value = "/{fSystemId}")
    public AjaxResult getInfo(@PathVariable("fSystemId") Long fSystemId)
    {
        return AjaxResult.success(sysManagementService.selectSysManagementById(fSystemId));
    }

    /**
     * 新增制度管理 
     */
    @Log(title = "制度管理 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysManagement sysManagement)
    {
        return toAjax(sysManagementService.insertSysManagement(sysManagement));
    }

    /**
     * 修改制度管理 
     */
    @Log(title = "制度管理 ", businessType = BusinessType.UPDATE)
    @PostMapping(value = "/update")
    public AjaxResult edit(@RequestBody SysManagement sysManagement)
    {
        return toAjax(sysManagementService.updateSysManagement(sysManagement));
    }

    /**
     * 删除制度管理 
     */
    @Log(title = "制度管理 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fSystemIds}")
    public AjaxResult remove(@PathVariable Long[] fSystemIds)
    {
        return toAjax(sysManagementService.deleteSysManagementByIds(fSystemIds));
    }
}
