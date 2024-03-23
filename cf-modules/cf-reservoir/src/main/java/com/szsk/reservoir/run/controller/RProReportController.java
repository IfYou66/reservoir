package com.szsk.reservoir.run.controller;

import java.util.Date;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.szsk.reservoir.run.domain.RProReport;
import com.szsk.reservoir.run.service.IRProReportService;
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
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 项目申报 Controller
 *
 * @author cangfeng
 * @date 2021-08-23
 */
@RestController
@RequestMapping("/report")
public class RProReportController extends BaseController{

    @Autowired
    private IRProReportService rProReportService;

    /**
     * 查询项目申报 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RProReport rProReport)
    {
        startPage();
        List<RProReport> list = rProReportService.selectRProReportList(rProReport);
        return getDataTable(list);
    }

    /**
     * 导出项目申报 列表
     */
    @Log(title = "项目申报 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RProReport rProReport) throws IOException
    {
        List<RProReport> list = rProReportService.selectRProReportList(rProReport);
        ExcelUtil<RProReport> util = new ExcelUtil<RProReport>(RProReport.class);
        util.exportExcel(response, list, "项目申报 数据");
    }

    /**
     * 获取项目申报 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rProReportService.selectRProReportById(fId));
    }

    /**
     * 新增项目申报
     */
    @Log(title = "项目申报 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RProReport rProReport)
    {
        rProReport.setfCreatePeople(SecurityUtils.getUserId().toString());
        rProReport.setfCreateTime(new Date());
        return toAjax(rProReportService.insertRProReport(rProReport));
    }

    /**
     * 修改项目申报
     */
    @Log(title = "项目申报 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RProReport rProReport)
    {
        //System.out.println(SecurityUtils.getUserId().toString());
        //System.out.println(rProReport.getfCreatePeople());
        //System.out.println(rProReportService.selectRProReportById(rProReport.getfId()).getfStatus());
        //if( !rProReport.getfCreatePeople().equals(SecurityUtils.getUserId().toString())  && rProReportService.selectRProReportById(rProReport.getfId()).getfStatus() == 0) {
        //    return error("此用户非提交人员");
        //}
        //if( rProReportService.selectRProReportById(rProReport.getfId()).getfActPersion() != SecurityUtils.getUserId() && rProReportService.selectRProReportById(rProReport.getfId()).getfStatus() == 1) {
        //    //System.out.println(rProReportService.selectRProReportById(rProReport.getfId()).getfActPersion());
        //    //System.out.println(SecurityUtils.getUserId());
        //    return error("此用户非指定审批人员");
        //}
        //if( rProReportService.selectRProReportById(rProReport.getfId()).getfActPersion() != SecurityUtils.getUserId() && rProReportService.selectRProReportById(rProReport.getfId()).getfStatus() == 2) {
        //    return error("此用户非指定勘察人员");
        //}
        //if( rProReportService.selectRProReportById(rProReport.getfId()).getfActPersion() != SecurityUtils.getUserId() && rProReportService.selectRProReportById(rProReport.getfId()).getfStatus() == 3) {
        //    return error("此用户非指定招标人员");
        //}
        //if( rProReportService.selectRProReportById(rProReport.getfId()).getfActPersion() != SecurityUtils.getUserId() && rProReportService.selectRProReportById(rProReport.getfId()).getfStatus() == 4) {
        //    return error("此用户非指定实施人员");
        //}
        //if( rProReportService.selectRProReportById(rProReport.getfId()).getfActPersion() != SecurityUtils.getUserId() && rProReportService.selectRProReportById(rProReport.getfId()).getfStatus() == 5) {
        //    return error("此用户非指定验收人员");
        //}
        //if( !rProReportService.selectRProReportById(rProReport.getfId()).getfCreatePeople().equals(SecurityUtils.getUserId().toString())  && rProReportService.selectRProReportById(rProReport.getfId()).getfStatus() == 4) {
        //    return error("此用户非指定修改人员");
        //}
        return toAjax(rProReportService.updateRProReport(rProReport));
    }

    /**
     * 删除项目申报
     */
    @Log(title = "项目申报 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rProReportService.deleteRProReportByIds(fIds));
    }

}
