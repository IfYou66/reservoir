package com.szsk.reservoir.fundManage.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
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
import com.szsk.reservoir.fundManage.domain.SysFundApply;
import com.szsk.reservoir.fundManage.service.ISysFundApplyService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 经费申请 Controller
 * 
 * @author cangfeng
 * @date 2021-08-18
 */
@RestController
@RequestMapping("/apply")
public class SysFundApplyController extends BaseController
{
    @Autowired
    private ISysFundApplyService sysFundApplyService;

    /**
     * 查询经费申请 列表
     */
//    @PreAuthorize(hasPermi = "fundManage:apply:list")
    @GetMapping("/list")
    public TableDataInfo list(SysFundApply sysFundApply)
    {
        startPage();
        List<SysFundApply> list = sysFundApplyService.selectSysFundApplyList(sysFundApply);
        for (SysFundApply fundApply : list) {
            fundApply.setLandingPersonId(SecurityUtils.getUserId());
        }
        return getDataTable(list);
    }

    /**
     * 导出经费申请 列表
     */
//    @PreAuthorize(hasPermi = "fundManage:apply:export")
    @Log(title = "经费申请 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFundApply sysFundApply) throws IOException
    {
        List<SysFundApply> list = sysFundApplyService.selectSysFundApplyList(sysFundApply);
        ExcelUtil<SysFundApply> util = new ExcelUtil<SysFundApply>(SysFundApply.class);
        util.exportExcel(response, list, "经费申请 数据");
    }

    /**
     * 获取经费申请 详细信息
     */
//    @PreAuthorize(hasPermi = "fundManage:apply:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(sysFundApplyService.selectSysFundApplyById(fId));
    }

    /**
     * 新增经费申请 
     */
//    @PreAuthorize(hasPermi = "fundManage:apply:add")
    @Log(title = "经费申请 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFundApply sysFundApply)
    {
        return sysFundApplyService.insertSysFundApply(sysFundApply);
    }

    /**
     * 修改经费申请 
     */
//    @PreAuthorize(hasPermi = "fundManage:apply:edit")
    @Log(title = "经费申请 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFundApply sysFundApply)
    {
        return sysFundApplyService.updateSysFundApply(sysFundApply);
    }

    /**
     * 删除经费申请 
     */
//    @PreAuthorize(hasPermi = "fundManage:apply:remove")
    @Log(title = "经费申请 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(sysFundApplyService.deleteSysFundApplyByIds(fIds));
    }

    @Log(title = "初始化培训申请表格数据")
    @GetMapping("/inquiry")
    public AjaxResult inquiry(){
        return sysFundApplyService.inquiry();
    }

}
