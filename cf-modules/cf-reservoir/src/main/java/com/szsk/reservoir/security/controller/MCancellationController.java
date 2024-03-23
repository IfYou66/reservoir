package com.szsk.reservoir.security.controller;

import java.util.Date;
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
import com.szsk.reservoir.security.domain.MCancellation;
import com.szsk.reservoir.security.service.IMCancellationService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 水库大坝注销 Controller
 * 
 * @author cangfeng
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/cancellation")
public class MCancellationController extends BaseController
{
    @Autowired
    private IMCancellationService mCancellationService;

    /**
     * 查询最近
     */
//    @PreAuthorize(hasPermi = "security:cancellation:list")
    @GetMapping("/getLatelyCancellation")
    public MCancellation getLatelyCancellation(MCancellation mCancellation)
    {
        return mCancellationService.getLatelyCancellation(mCancellation);
    }

    /**
     * 查询水库大坝注销 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(MCancellation mCancellation)
    {
        startPage();
        List<MCancellation> list = mCancellationService.selectMCancellationList(mCancellation);
        return getDataTable(list);
    }

    /**
     * 导出水库大坝注销 列表
     */
    @Log(title = "水库大坝注销 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MCancellation mCancellation) throws IOException
    {
        List<MCancellation> list = mCancellationService.selectMCancellationList(mCancellation);
        ExcelUtil<MCancellation> util = new ExcelUtil<MCancellation>(MCancellation.class);
        util.exportExcel(response, list, "水库大坝注销 数据");
    }

    /**
     * 获取水库大坝注销 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(mCancellationService.selectMCancellationById(fId));
    }

    /**
     * 新增水库大坝注销 
     */
    @Log(title = "水库大坝注销 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MCancellation mCancellation)
    {
        return toAjax(mCancellationService.insertMCancellation(mCancellation));
    }

    /**
     * 修改水库大坝注销 
     */
    @Log(title = "水库大坝注销 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MCancellation mCancellation)
    {
        return toAjax(mCancellationService.updateMCancellation(mCancellation));
    }

    /**
     * 删除水库大坝注销 
     */
    @Log(title = "水库大坝注销 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(mCancellationService.deleteMCancellationByIds(fIds));
    }

    /**
     * 流程
     */
//    @PreAuthorize(hasPermi = "security:cancellation:add")
    @Log(title = "水库大坝流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/nextCancellationInsert")
    public AjaxResult nextCancellationInsert(@RequestBody MCancellation cancellation)
    {
        return mCancellationService.nextCancellationInsert(cancellation);
    }

    /**
     * 流程
     */
//    @PreAuthorize(hasPermi = "security:cancellation:add")
    @Log(title = "水库大坝流程 ", businessType = BusinessType.INSERT)
    @PostMapping("/nextCancellationUpdate")
    public AjaxResult nextCancellationUpdate(@RequestBody MCancellation cancellation)
    {
        return mCancellationService.nextCancellationUpdate(cancellation);
    }


    /**
     * dict
     */
//    @PreAuthorize(hasPermi = "security:cancellation:list")
    @GetMapping("/getDictByType")
    public AjaxResult getDictByType()
    {
        return mCancellationService.getDictByType();
    }
}
