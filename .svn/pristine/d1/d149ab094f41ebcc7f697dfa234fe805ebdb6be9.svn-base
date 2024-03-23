package com.szsk.reservoir.manageSystem.controller;

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
import com.szsk.reservoir.manageSystem.domain.SysReservoirInfo;
import com.szsk.reservoir.manageSystem.service.ISysReservoirInfoService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 水库信息Controller
 * 
 * @author cangfeng
 * @date 2021-11-12
 */
@RestController
@RequestMapping("/reservoirInfo")
public class SysReservoirInfoController extends BaseController
{
    @Autowired
    private ISysReservoirInfoService sysReservoirInfoService;

    /**
     * 查询水库信息列表
     */
    @PreAuthorize(hasPermi = "reservoirInfo:reservoirInfo:list")
    @GetMapping("/list")
    public TableDataInfo list(SysReservoirInfo sysReservoirInfo)
    {
        startPage();
        List<SysReservoirInfo> list = sysReservoirInfoService.selectSysReservoirInfoList(sysReservoirInfo);
        return getDataTable(list);
    }

    /**
     * 导出水库信息列表
     */
    @PreAuthorize(hasPermi = "reservoirInfo:reservoirInfo:export")
    @Log(title = "水库信息", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysReservoirInfo sysReservoirInfo) throws IOException
    {
        List<SysReservoirInfo> list = sysReservoirInfoService.selectSysReservoirInfoList(sysReservoirInfo);
        ExcelUtil<SysReservoirInfo> util = new ExcelUtil<SysReservoirInfo>(SysReservoirInfo.class);
        util.exportExcel(response, list, "水库信息数据");
    }

    /**
     * 获取水库信息详细信息
     */
    @PreAuthorize(hasPermi = "reservoirInfo:reservoirInfo:query")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id)
    {
        return AjaxResult.success(sysReservoirInfoService.selectSysReservoirInfoById(id));
    }
    /**
     * 获取当前登录人水库信息详细信息
     */
    @GetMapping("/getCurrentInfo")
    public AjaxResult getCurrentInfo(SysReservoirInfo sysReservoirInfo)
    {
        return AjaxResult.success(sysReservoirInfoService.getCurrentInfo(sysReservoirInfo));
    }

    /**
     * 新增水库信息
     */
    @PreAuthorize(hasPermi = "reservoirInfo:reservoirInfo:add")
    @Log(title = "水库信息", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysReservoirInfo sysReservoirInfo)
    {
        return toAjax(sysReservoirInfoService.insertSysReservoirInfo(sysReservoirInfo));
    }

    /**
     * 修改水库信息
     */
    @PreAuthorize(hasPermi = "reservoirInfo:reservoirInfo:edit")
    @Log(title = "水库信息", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysReservoirInfo sysReservoirInfo)
    {
        return toAjax(sysReservoirInfoService.updateSysReservoirInfo(sysReservoirInfo));
    }

    /**
     * 删除水库信息
     */
    @PreAuthorize(hasPermi = "reservoirInfo:reservoirInfo:remove")
    @Log(title = "水库信息", businessType = BusinessType.DELETE)
	@DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids)
    {
        return toAjax(sysReservoirInfoService.deleteSysReservoirInfoByIds(ids));
    }
}
