package com.szsk.reservoir.risk.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.szsk.reservoir.risk.domain.MRiskManagement;
import com.szsk.reservoir.risk.service.IMRiskManagementService;
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
 * 险情管理 Controller
 *
 * @author cangfeng
 * @date 2021-08-19
 */
@RestController
@RequestMapping("/management")
public class MRiskManagementController extends BaseController{


    @Autowired
    private IMRiskManagementService mRiskManagementService;

    /**
     * 查询险情管理 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(MRiskManagement mRiskManagement)
    {
        startPage();
        List<MRiskManagement> list = mRiskManagementService.selectMRiskManagementList(mRiskManagement);
        return getDataTable(list);
    }

    /**
     * 导出险情管理 列表
     */
    @Log(title = "险情管理 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MRiskManagement mRiskManagement) throws IOException
    {
        List<MRiskManagement> list = mRiskManagementService.selectMRiskManagementList(mRiskManagement);
        ExcelUtil<MRiskManagement> util = new ExcelUtil<MRiskManagement>(MRiskManagement.class);
        util.exportExcel(response, list, "险情管理 数据");
    }

    /**
     * 获取险情管理 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(mRiskManagementService.selectMRiskManagementById(fId));
    }

    /**
     * 新增险情管理
     */
    @Log(title = "险情管理 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MRiskManagement mRiskManagement)
    {
        mRiskManagement.setfCreateBy(SecurityUtils.getUserId());
        return toAjax(mRiskManagementService.insertMRiskManagement(mRiskManagement));
    }

    /**
     * 修改险情管理
     */
    @Log(title = "险情管理 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MRiskManagement mRiskManagement)
    {
//        if(mRiskManagement.getfCreateBy() != SecurityUtils.getUserId() && mRiskManagement.getfActStatus() == 1) {
//            return error("此用户非修改人员");
//        }
//        if(mRiskManagementService.selectMRiskManagementById(mRiskManagement.getfId()).getfActPersion() != SecurityUtils.getUserId()
//                && mRiskManagementService.selectMRiskManagementById(mRiskManagement.getfId()).getfActStatus() == 1) {
//            return error("当前用户非指定响应人员");
//        }
//        if(mRiskManagementService.selectMRiskManagementById(mRiskManagement.getfId()).getfActPersion() != SecurityUtils.getUserId()
//                && mRiskManagementService.selectMRiskManagementById(mRiskManagement.getfId()).getfActStatus() == 2) {
//            return error("当前用户非指定排除人员");
//        }
//        if(mRiskManagementService.selectMRiskManagementById(mRiskManagement.getfId()).getfActPersion() != SecurityUtils.getUserId()
//                && mRiskManagementService.selectMRiskManagementById(mRiskManagement.getfId()).getfActStatus() == 3) {
//            return error("当前用户非指定检查人员");
//        }
        return toAjax(mRiskManagementService.updateMRiskManagement(mRiskManagement));
    }

    /**
     * 删除险情管理
     */
    @Log(title = "险情管理 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(mRiskManagementService.deleteMRiskManagementByIds(fIds));
    }
}
