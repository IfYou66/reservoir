package com.szsk.reservoir.run.controller;

import java.util.Date;
import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.szsk.reservoir.run.domain.RMainImpl;
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
 * 维修养护实施 Controller
 *
 * @author cangfeng
 * @date 2021-08-23
 */
@RestController
@RequestMapping("/impl")
public class RMainImplController extends BaseController{

    @Autowired
    private IRMainImplService rMainImplService;


    @Autowired
    private IRMaintenanceService rMaintenanceService;
    /**
     * 查询维修养护实施 列表
     */

    @GetMapping("/list")
    public TableDataInfo list(RMainImpl rMainImpl)
    {
        startPage();
        List<RMainImpl> list = rMainImplService.selectRMainImplList(rMainImpl);
        return getDataTable(list);
    }

    /**
     * 导出维修养护实施 列表
     */

    @Log(title = "维修养护实施 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, RMainImpl rMainImpl) throws IOException
    {
        List<RMainImpl> list = rMainImplService.selectRMainImplList(rMainImpl);
        ExcelUtil<RMainImpl> util = new ExcelUtil<RMainImpl>(RMainImpl.class);
        util.exportExcel(response, list, "维修养护实施 数据");
    }

    /**
     * 获取维修养护实施 详细信息
     */

    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(rMainImplService.selectRMainImplById(fId));
    }

    /**
     * 新增维修养护实施
     */

    @Log(title = "维修养护实施 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody RMainImpl rMainImpl)
    {
        rMainImpl.setfCreatePeople(SecurityUtils.getUserId().toString());
        rMainImpl.setfCreateTime(new Date());

        //if(rMaintenanceService.selectRMaintenanceById(Integer.valueOf(rMainImpl.getfPreparedId().toString())).getfActPersion() != SecurityUtils.getUserId()
        //        && rMainImpl.getfStatus() == 0) {
        //    return error("此用户非修改人员");
        //}
        //if( !rMaintenanceService.selectRMaintenanceById(Integer.valueOf(rMainImpl.getfPreparedId().toString())).getfCreatePeople().equals(SecurityUtils.getUserId())
        //        && rMainImpl.getfStatus() == 1) {
        //    System.out.println(rMaintenanceService.selectRMaintenanceById(Integer.valueOf(rMainImpl.getfPreparedId().toString())).getfCreatePeople().equals(SecurityUtils.getUserId()));
        //    System.out.println();
        //    return error("此用户非修改人员");
        //}
        return toAjax(rMainImplService.insertRMainImpl(rMainImpl));
    }

    /**
     * 修改维修养护实施
     */

    @Log(title = "维修养护实施 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody RMainImpl rMainImpl)
    {
        //if( rMainImplService.selectRMainImplById(rMainImpl.getfId()).getfActPersion() == SecurityUtils.getUserId()
        //        && rMainImpl.getfStatus() == 2) {
        //    System.out.println(rMainImplService.selectRMainImplById(rMainImpl.getfId()).getfActPersion() != SecurityUtils.getUserId());
        //    return error("此用户非审核人员");
        //}
        //if( rMainImplService.selectRMainImplById(rMainImpl.getfId()).getfCreatePeople().equals(SecurityUtils.getUserId())
        //        && rMainImpl.getfStatus() == 1) {
        //    System.out.println(rMainImplService.selectRMainImplById(rMainImpl.getfId()).getfCreatePeople().equals(SecurityUtils.getUserId()));
        //    System.out.println(SecurityUtils.getUserId());
        //    return error("此用户非修改人员");
        //}
        return toAjax(rMainImplService.updateRMainImpl(rMainImpl));
    }

    /**
     * 删除维修养护实施
     */

    @Log(title = "维修养护实施 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(rMainImplService.deleteRMainImplByIds(fIds));
    }

}
