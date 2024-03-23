package com.szsk.archives.archivesManage.controller;

import java.util.List;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.core.utils.ServletUtils;
import com.szsk.archives.archivesManage.domain.AStoreroom;
import com.szsk.archives.archivesManage.service.IAStoreroomService;
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
 * 库房Controller
 *
 * @author wangcc
 * @date 2021-08-16
 */
@RestController
@RequestMapping("/storeroom")
public class AStoreroomController extends BaseController
{
    @Autowired
    private IAStoreroomService aStoreroomService;

    /**
     * 查询库房列表
     */
    @PreAuthorize(hasPermi = "system:storeroom:list")
    @GetMapping("/list")
    public TableDataInfo list(AStoreroom aStoreroom)
    {
        startPage();
        List<AStoreroom> list = aStoreroomService.selectAStoreroomList(aStoreroom);
        return getDataTable(list);
    }

    /**
     * 导出库房列表
     */
    @PreAuthorize(hasPermi = "system:storeroom:export")
    @Log(title = "库房", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AStoreroom aStoreroom) throws IOException
    {
        List<AStoreroom> list = aStoreroomService.selectAStoreroomList(aStoreroom);
        ExcelUtil<AStoreroom> util = new ExcelUtil<AStoreroom>(AStoreroom.class);
        util.exportExcel(response, list, "库房数据");
    }

    /**
     * 获取库房详细信息
     */
    @PreAuthorize(hasPermi = "system:storeroom:query")
    @GetMapping(value = "/{fStoreroomId}")
    public AjaxResult getInfo(@PathVariable("fStoreroomId") Long fStoreroomId)
    {
        return AjaxResult.success(aStoreroomService.selectAStoreroomById(fStoreroomId));
    }

    /**
     * 新增库房
     */
    @PreAuthorize(hasPermi = "system:storeroom:add")
    @Log(title = "库房", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AStoreroom aStoreroom)
    {
        return toAjax(aStoreroomService.insertAStoreroom(aStoreroom));
    }

    /**
     * 修改库房
     */
    @PreAuthorize(hasPermi = "system:storeroom:edit")
    @Log(title = "库房", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AStoreroom aStoreroom)
    {
        return toAjax(aStoreroomService.updateAStoreroom(aStoreroom));
    }

    /**
     * 修改库房状态
     */
    @GetMapping("/updateStatus")
    public AjaxResult updateStatus(Long storeroomId)
    {
        AStoreroom aStoreroom = new AStoreroom();
        // 删除
        aStoreroom.setfStatus(0);
        aStoreroom.setfStoreroomId(storeroomId);
        return toAjax(aStoreroomService.updateAStoreroom(aStoreroom));
    }

    /**
     * 删除库房
     */
    @PreAuthorize(hasPermi = "system:storeroom:remove")
    @Log(title = "库房", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fStoreroomIds}")
    public AjaxResult remove(@PathVariable Long[] fStoreroomIds)
    {
        return toAjax(aStoreroomService.deleteAStoreroomByIds(fStoreroomIds));
    }
}
