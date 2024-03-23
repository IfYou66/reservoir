package com.szsk.reservoir.security.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.szsk.reservoir.security.domain.MSafetyAppraisal;
import com.szsk.reservoir.security.service.IMSafetyAppraisalService;

/**
 * 水库大坝安全鉴定一览 Controller
 * 
 * @author cangfeng
 * @date 2021-08-17
 */
@RestController
@RequestMapping("/appraisal")
public class MSafetyAppraisalController extends BaseController
{
    @Autowired
    private IMSafetyAppraisalService mSafetyAppraisalService;

    /**
     * 查询水库大坝安全鉴定一览 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(MSafetyAppraisal mSafetyAppraisal)
    {
        startPage();
        List<MSafetyAppraisal> list = mSafetyAppraisalService.selectMSafetyAppraisalList(mSafetyAppraisal);
        return getDataTable(list);
    }

    /**
     * 导出水库大坝安全鉴定一览 列表
     */
    @Log(title = "水库大坝安全鉴定一览 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MSafetyAppraisal mSafetyAppraisal) throws IOException
    {
        List<MSafetyAppraisal> list = mSafetyAppraisalService.selectMSafetyAppraisalList(mSafetyAppraisal);
        ExcelUtil<MSafetyAppraisal> util = new ExcelUtil<MSafetyAppraisal>(MSafetyAppraisal.class);
        util.exportExcel(response, list, "水库大坝安全鉴定一览 数据");
    }

    /**
     * 获取水库大坝安全鉴定一览 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(mSafetyAppraisalService.selectMSafetyAppraisalById(fId));
    }

    /**
     * 新增水库大坝安全鉴定一览 
     */
    @Log(title = "水库大坝安全鉴定一览 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MSafetyAppraisal mSafetyAppraisal)
    {
        return toAjax(mSafetyAppraisalService.insertMSafetyAppraisal(mSafetyAppraisal));
    }

    /**
     * 修改水库大坝安全鉴定一览 
     */
    @Log(title = "水库大坝安全鉴定一览 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MSafetyAppraisal mSafetyAppraisal)
    {
        return toAjax(mSafetyAppraisalService.updateMSafetyAppraisal(mSafetyAppraisal));
    }

    /**
     * 删除水库大坝安全鉴定一览 
     */
    @Log(title = "水库大坝安全鉴定一览 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(mSafetyAppraisalService.deleteMSafetyAppraisalByIds(fIds));
    }

    /**
     * 查询水库大坝安全鉴定一览 列表
     */
    @GetMapping("/latelySafetyAppraisal")
    public AjaxResult latelySafetyAppraisal(MSafetyAppraisal mSafetyAppraisal)
    {
        return AjaxResult.success(mSafetyAppraisalService.latelySafetyAppraisal(mSafetyAppraisal));
    }

    /**
     * dict
     */
    @GetMapping("/getDictByType")
    public AjaxResult getDictByType()
    {
        return mSafetyAppraisalService.getDictByType();
    }

    /**
     * 流程
     */
    @Log(title = "安全鉴定流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/startWorkFlow")
    public AjaxResult startWorkFlow(@RequestBody MSafetyAppraisal mSafetyAppraisal)
    {
        return mSafetyAppraisalService.startWorkFlow(mSafetyAppraisal);
    }
    @Log(title = "安全鉴定流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/taskReview")
    public AjaxResult taskReview(@RequestBody MSafetyAppraisal mSafetyAppraisal)
    {
        return mSafetyAppraisalService.taskReview(mSafetyAppraisal);
    }
}
