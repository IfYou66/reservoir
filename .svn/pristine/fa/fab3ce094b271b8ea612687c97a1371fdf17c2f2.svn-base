package com.szsk.reservoir.run.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.szsk.reservoir.run.domain.RMainImpl;
import com.szsk.reservoir.run.domain.RMaintenance;
import com.szsk.reservoir.run.service.IRMainImplService;
import com.szsk.reservoir.run.service.IRMaintenanceService;
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
 * 维修养护编制 Controller
 *
 * @author cangfeng
 * @date 2021-08-23
 */
@RestController
@RequestMapping("/maintenance")
public class RMaintenanceController extends BaseController{

    @Autowired
    private IRMaintenanceService rMaintenanceService;

    /**
     * 查询维修养护编制 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(RMaintenance rMaintenance)
    {
        startPage();
        List<RMaintenance> list = rMaintenanceService.selectRMaintenanceList(rMaintenance);
        return getDataTable(list);
    }
    /**
     * 导出维修养护编制 列表
     */

    @Log(title = "维修养护编制 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RMaintenance rMaintenance) throws IOException
    {
        List<RMaintenance> list = rMaintenanceService.selectRMaintenanceList(rMaintenance);
        ExcelUtil<RMaintenance> util = new ExcelUtil<RMaintenance>(RMaintenance.class);
        util.exportExcel(response, list, "维修养护编制 数据");
    }

    /**
     * 获取维修养护编制 详细信息
     */

    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Integer fId)
    {
        return AjaxResult.success(rMaintenanceService.selectRMaintenanceById(fId));
    }

    /**
     * 新增维修养护编制
     */
    @Log(title = "维修养护编制 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RMaintenance rMaintenance)
    {
        rMaintenance.setfCreatePeople(SecurityUtils.getUserId().toString());
        rMaintenance.setfCreateTime(new Date());
        return toAjax(rMaintenanceService.insertRMaintenance(rMaintenance));
    }

    /**
     * 修改维修养护编制
     */
    @Log(title = "维修养护编制 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RMaintenance rMaintenance)
    {

        //System.out.println(rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfActPersion());
        //System.out.println(rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfActStatus());
        //System.out.println();
        //if(rMaintenance.getfStatus() == 6 && !rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfActPersion().equals(SecurityUtils.getUserId())  ) {
        //    return error("此用户非实施人员");
        //}
        //if( !rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfCreatePeople().equals(SecurityUtils.getUserId().toString())  && rMaintenance.getfStatus() == 0) {
        //    return error("此用户非修改人员");
        //}
        //if(rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfActPersion() != SecurityUtils.getUserId()
        //        && rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfStatus() == 1) {
        //    return error("当前用户非指定审核人员");
        //}
        //if(rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfActPersion() != SecurityUtils.getUserId()
        //        && rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfStatus() == 2) {
        //    return error("当前用户非指定批准人员");
        //}
        //if(rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfActPersion() != SecurityUtils.getUserId()
        //        && rMaintenanceService.selectRMaintenanceById(rMaintenance.getfId()).getfStatus() == 4) {
        //    return error("此用户非修改人员");
        //}
        return toAjax(rMaintenanceService.updateRMaintenance(rMaintenance));
    }

    /**
     * 删除维修养护编制
     */
    @Log(title = "维修养护编制 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Integer[] fIds)
    {
        return toAjax(rMaintenanceService.deleteRMaintenanceByIds(fIds));
    }

}
