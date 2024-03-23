package com.szsk.reservoir.security.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.szsk.reservoir.security.domain.MBorder;
import com.szsk.reservoir.security.service.IMBorderService;

/**
 * 工程划界
 * 
 * @author wangcc
 * @date 2021-08-23
 */
@RestController
@RequestMapping("border")
public class MBorderController extends BaseController
{
    @Autowired
    private IMBorderService borderService;

    /**
     * 工程划界 获取坐标列表
     * @return
     */
    @PostMapping("/getLabelList")
    public AjaxResult getLabelList(MBorder mBorder){
        return borderService.getLabelList(mBorder);
    }
    /**
     * 获取工程划界  详细信息
     */
    @GetMapping(value = "/{fId}")
    public AjaxResult getInfo(@PathVariable("fId") Long fId)
    {
        return AjaxResult.success(borderService.selectMBorderById(fId));
    }
    /**
     * 新增/修改工程划界 
     */
    @Log(title = "工程划界 ", businessType = BusinessType.UPDATE)
    @PostMapping("/update")
    public AjaxResult edit(  @RequestBody MBorder mBorder)
    {
        return toAjax(borderService.updateMBorder(mBorder));
    }
    
}
