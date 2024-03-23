package com.szsk.archives.archivesManage.controller;

import com.ruoyi.common.core.utils.poi.ExcelUtil;
import com.ruoyi.common.core.web.controller.BaseController;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.core.web.page.TableDataInfo;
import com.ruoyi.common.log.annotation.Log;
import com.ruoyi.common.log.enums.BusinessType;
import com.ruoyi.common.security.annotation.PreAuthorize;
import com.szsk.archives.archivesManage.domain.AArchives;
import com.szsk.archives.archivesManage.domain.ABorrow;
import com.szsk.archives.archivesManage.service.IAArchivesService;
import com.szsk.archives.archivesManage.service.IABorrowService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 档案 Controller
 * 
 * @author cangfeng
 * @date 2021-07-21
 */
@RestController
@RequestMapping("/archives")
public class AArchivesController extends BaseController
{
    @Autowired
    private IAArchivesService aArchivesService;

    @Autowired
    private IABorrowService iaBorrowService;

    /**
     * 查询档案 列表
     */
    @GetMapping("/list")
    public TableDataInfo list(AArchives aArchives)
    {
        startPage();
        List<AArchives> list = aArchivesService.selectAArchivesList(aArchives);
        List<AArchives> newList = new ArrayList<>();
        for(AArchives aArchives1 : list) {
            ABorrow aBorrow = new ABorrow();
            aBorrow.setfArchivesId( aArchives1.getfArchivesId());
            aBorrow.setfState(0);
            int audit = iaBorrowService.selectABorrowList(aBorrow).size();
            aBorrow.setfState(1);
            int borrow = iaBorrowService.selectABorrowList(aBorrow).size();
            if((audit + borrow) > 0){
                aArchives1.setIfBorrow(1);
            }else{
                aArchives1.setIfBorrow(0);
            }
            newList.add(aArchives1);

        }
        return getDataTable(newList);
    }

    /**
     * 导出档案 列表
     */
    @Log(title = "档案 ", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, AArchives aArchives) throws IOException
    {
        List<AArchives> list = aArchivesService.selectAArchivesList(aArchives);
        ExcelUtil<AArchives> util = new ExcelUtil<AArchives>(AArchives.class);
        util.exportExcel(response, list, "档案 数据");
    }

    /**
     * 获取档案 详细信息
     */
    @GetMapping(value = "/{fArchivesId}")
    public AjaxResult getInfo(@PathVariable("fArchivesId") Long fArchivesId)
    {
        return AjaxResult.success(aArchivesService.selectAArchivesById(fArchivesId));
    }

    /**
     * 新增档案 
     */
    @Log(title = "档案 ", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody AArchives aArchives)
    {
        return toAjax(aArchivesService.insertAArchives(aArchives));
    }

    /**
     * 修改档案 
     */
    @Log(title = "档案 ", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody AArchives aArchives)
    {
        return toAjax(aArchivesService.updateAArchives(aArchives));
    }

    /**
     * 删除档案 
     */
    @Log(title = "档案 ", businessType = BusinessType.DELETE)
	@DeleteMapping("/{fArchivesIds}")
    public AjaxResult remove(@PathVariable Long[] fArchivesIds)
    {
        return toAjax(aArchivesService.deleteAArchivesByIds(fArchivesIds));
    }

    @Log(title = "初始化档案接收表格数据")
    @GetMapping("/initArchivesForm")
    public AjaxResult initArchivesForm(){
        return aArchivesService.initArchivesForm();
    }
}