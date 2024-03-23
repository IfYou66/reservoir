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
import com.szsk.reservoir.fundManage.domain.SysFundExpend;
import com.szsk.reservoir.fundManage.service.ISysFundExpendService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 经费支出 Controller
 * 
 * @author cangfeng
 * @date 2021-08-18
 */
@RestController
@RequestMapping("/expend")
public class SysFundExpendController extends BaseController
{
    @Autowired
    private ISysFundExpendService sysFundExpendService;

    /**
     * 查询经费支出 列表
     */
//    @PreAuthorize(hasPermi = "fundManage:expend:list")
    @GetMapping("/list")
    public TableDataInfo list(SysFundExpend sysFundExpend)
    {
        startPage();
        List<SysFundExpend> list = sysFundExpendService.selectSysFundExpendList(sysFundExpend);
        for (SysFundExpend expend : list) {
            expend.setLandingPersonId(SecurityUtils.getUserId());
        }
        return getDataTable(list);
    }

    /**
     * 导出经费支出 列表
     */
//    @PreAuthorize(hasPermi = "fundManage:expend:export")
    @Log(title = "经费支出 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, SysFundExpend sysFundExpend) throws IOException
    {
        List<SysFundExpend> list = sysFundExpendService.selectSysFundExpendList(sysFundExpend);
        ExcelUtil<SysFundExpend> util = new ExcelUtil<SysFundExpend>(SysFundExpend.class);
        util.exportExcel(response, list, "经费支出 数据");
    }

    /**
     * 获取经费支出 详细信息
     */
//    @PreAuthorize(hasPermi = "fundManage:expend:query")
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(sysFundExpendService.selectSysFundExpendById(fId));
    }

    /**
     * 新增经费支出 
     */
//    @PreAuthorize(hasPermi = "fundManage:expend:add")
    @Log(title = "经费支出 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody SysFundExpend sysFundExpend)
    {
        return sysFundExpendService.insertSysFundExpend(sysFundExpend);
    }

    /**
     * 修改经费支出 
     */
//    @PreAuthorize(hasPermi = "fundManage:expend:edit")
    @Log(title = "经费支出 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody SysFundExpend sysFundExpend)
    {
        return sysFundExpendService.updateSysFundExpend(sysFundExpend);
    }

    /**
     * 删除经费支出 
     */
//    @PreAuthorize(hasPermi = "fundManage:expend:remove")
    @Log(title = "经费支出 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(sysFundExpendService.deleteSysFundExpendByIds(fIds));
    }
}
