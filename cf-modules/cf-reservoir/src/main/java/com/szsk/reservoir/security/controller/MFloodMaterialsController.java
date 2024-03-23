package com.szsk.reservoir.security.controller;

import java.util.ArrayList;
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
import com.szsk.reservoir.security.domain.MFloodMaterials;
import com.szsk.reservoir.security.service.IMFloodMaterialsService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 防汛物资 Controller
 * 
 * @author cangfeng
 * @date 2021-08-19
 */
@RestController
@RequestMapping("/materials")
public class MFloodMaterialsController extends BaseController
{
    @Autowired
    private IMFloodMaterialsService mFloodMaterialsService;

    /**
     * 查询防汛物资 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(MFloodMaterials mFloodMaterials)
    {
        startPage();
        List<MFloodMaterials> list = mFloodMaterialsService.selectMFloodMaterialsList(mFloodMaterials);
        return getDataTable(list);
    }

    /**
     * 导出防汛物资 列表
     */
    @Log(title = "防汛物资 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MFloodMaterials mFloodMaterials) throws IOException
    {
        List<MFloodMaterials> list = mFloodMaterialsService.selectMFloodMaterialsList(mFloodMaterials);
        ExcelUtil<MFloodMaterials> util = new ExcelUtil<MFloodMaterials>(MFloodMaterials.class);
        util.exportExcel(response, list, "防汛物资 数据");
    }

    /**
     * 获取防汛物资 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(mFloodMaterialsService.selectMFloodMaterialsById(fId));
    }

    /**
     * 新增防汛物资 
     */
    @Log(title = "防汛物资 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MFloodMaterials mFloodMaterials)
    {
        return toAjax(mFloodMaterialsService.insertMFloodMaterials(mFloodMaterials));
    }

    /**
     * 批量新增
     */
    @PostMapping("/insertAllMFloodMaterials")
    public AjaxResult insertAllMFloodMaterials(@RequestBody ArrayList<MFloodMaterials> mFloodMaterials)
    {
        return toAjax(mFloodMaterialsService.insertAllMFloodMaterials(mFloodMaterials));
    }

    /**
     * 修改防汛物资 
     */
    @Log(title = "防汛物资 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MFloodMaterials mFloodMaterials)
    {
        return toAjax(mFloodMaterialsService.updateMFloodMaterials(mFloodMaterials));
    }

    /**
     * 删除防汛物资 
     */
    @Log(title = "防汛物资 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(mFloodMaterialsService.deleteMFloodMaterialsByIds(fIds));
    }

    /**
     * dict
     */
    @GetMapping("/getDictByType")
    public AjaxResult getDictByType()
    {
        return mFloodMaterialsService.getDictByType();
    }
}
