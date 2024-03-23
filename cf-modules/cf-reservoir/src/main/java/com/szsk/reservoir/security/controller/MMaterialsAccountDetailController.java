package com.szsk.reservoir.security.controller;

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
import com.szsk.reservoir.security.domain.MMaterialsAccountDetail;
import com.szsk.reservoir.security.service.IMMaterialsAccountDetailService;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.page.TableDataInfo;

/**
 * 物资台账信息 Controller
 *
 * @author cangfeng
 * @date 2021-08-19
 */
@RestController
@RequestMapping("/materialsDetail")
public class MMaterialsAccountDetailController extends BaseController
{
    @Autowired
    private IMMaterialsAccountDetailService mMaterialsAccountDetailService;

    /**
     * 查询物资台账信息 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(MMaterialsAccountDetail mMaterialsAccountDetail)
    {
        startPage();
        List<MMaterialsAccountDetail> list = mMaterialsAccountDetailService.selectMMaterialsAccountDetailList(mMaterialsAccountDetail);
        return getDataTable(list);
    }

    /**
     * 导出物资台账信息 列表
     */
    @Log(title = "物资台账信息 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, MMaterialsAccountDetail mMaterialsAccountDetail) throws IOException
    {
        List<MMaterialsAccountDetail> list = mMaterialsAccountDetailService.selectMMaterialsAccountDetailList(mMaterialsAccountDetail);
        ExcelUtil<MMaterialsAccountDetail> util = new ExcelUtil<MMaterialsAccountDetail>(MMaterialsAccountDetail.class);
        util.exportExcel(response, list, "物资台账信息 数据");
    }

    /**
     * 获取物资台账信息 详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(mMaterialsAccountDetailService.selectMMaterialsAccountDetailById(fId));
    }

    /**
     * 新增物资台账信息
     */
    @Log(title = "物资台账信息 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody MMaterialsAccountDetail mMaterialsAccountDetail)
    {
        return toAjax(mMaterialsAccountDetailService.insertMMaterialsAccountDetail(mMaterialsAccountDetail));
    }

    /**
     * 修改物资台账信息
     */
    @Log(title = "物资台账信息 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody MMaterialsAccountDetail mMaterialsAccountDetail)
    {
        return toAjax(mMaterialsAccountDetailService.updateMMaterialsAccountDetail(mMaterialsAccountDetail));
    }

    /**
     * 删除物资台账信息
     */
    @Log(title = "物资台账信息 ", businessType = BusinessType.DELETE)
    @DeleteMapping("/{fIds}")
    public AjaxResult remove(@PathVariable Long[] fIds)
    {
        return toAjax(mMaterialsAccountDetailService.deleteMMaterialsAccountDetailByIds(fIds));
    }

}
