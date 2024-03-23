package com.szsk.reservoir.run.controller;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.szsk.reservoir.run.domain.RSecuImpl;
import com.szsk.reservoir.run.service.IRSecuImplService;
import com.szsk.reservoir.util.EasypoiUtils;

import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.TemplateExportParams;

/**
 * 安检检查实施 Controller
 * 
 * @author cangfeng
 * @date 2021-08-25
 */
@RestController
@RequestMapping("/SecuImpl")
public class RSecuImplController extends BaseController
{
    @Autowired
    private IRSecuImplService rSecuImplService;

    /**
     * 查询安检检查实施 列表
     */
//    @PreAuthorize(hasPermi = "run:impl:list")
    @GetMapping("/list")
    public TableDataInfo list(RSecuImpl rSecuImpl)
    {
        startPage();
        List<RSecuImpl> list = rSecuImplService.selectRSecuImplList(rSecuImpl);
        return getDataTable(list);
    }

    /**
     * 导出安检检查实施 列表
     */
//    @PreAuthorize(hasPermi = "run:impl:export")
    @Log(title = "安检检查实施 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RSecuImpl rSecuImpl) throws IOException
    {
        List<RSecuImpl> list = rSecuImplService.selectRSecuImplList(rSecuImpl);
        ExcelUtil<RSecuImpl> util = new ExcelUtil<RSecuImpl>(RSecuImpl.class);
        util.exportExcel(response, list, "安检检查实施 数据");
    }

    /**
     * 获取安检检查实施 详细信息
     */
//    @PreAuthorize(hasPermi = "run:impl:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rSecuImplService.selectRSecuImplById(fId));
    }

    /**
     * 根据计划编制id获取检查实施详情
     */
    @GetMapping("/getEntity")
    public AjaxResult getEntity(@RequestParam  Long fPlaneditId)
    {
        return rSecuImplService.selectRSecuImplByfPlaneditId(fPlaneditId);
    }

    /**
     * 新增安检检查实施 
     */
//    @PreAuthorize(hasPermi = "run:impl:add")
    @Log(title = "安检检查实施 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RSecuImpl rSecuImpl)
    {
        return rSecuImplService.insertRSecuImpl(rSecuImpl);
    }

    /**
     * 修改安检检查实施 
     */
//    @PreAuthorize(hasPermi = "run:impl:edit")
    @Log(title = "安检检查实施 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RSecuImpl rSecuImpl)
    {
        return rSecuImplService.updateRSecuImpl(rSecuImpl);
    }

    /**
     * 删除安检检查实施 
     */
//    @PreAuthorize(hasPermi = "run:impl:remove")
    @Log(title = "安检检查实施 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rSecuImplService.deleteRSecuImplByIds(fIds));
    }
    
    /**
     * 导出安检检查实施
     */
    @Log(title = "安检检查实施导出", businessType = BusinessType.EXPORT)
    @PostMapping("/detailExport")
    public void detailExport(HttpServletResponse response, RSecuImpl rSecuImpl) throws IOException
    {
//    	AjaxResult result = rSecuImplService.selectRSecuImplByfPlaneditId(rSecuImpl.getfPlaneditId());
//    	EasypoiUtils.exportExcelByTemplate(response, (RSecuImpl)result.get("data"), "xlsTemplate/security/安检查询-安检实施.xls");
    }
    
}
