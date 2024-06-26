package com.ruoyi.file.controller;

import com.ruoyi.common.core.utils.SecurityUtils;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.file.mapper.SysFileMapper;
import com.ruoyi.file.service.FileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.utils.file.FileUtils;
import com.ruoyi.file.service.ISysFileService;
import com.ruoyi.system.api.domain.SysFile;

import javax.annotation.Resource;

/**
 * 文件请求处理
 *
 * @author wangcc
 */

@RestController
public class SysFileController {
    private static final Logger log = LoggerFactory.getLogger(SysFileController.class);

    @Autowired
    private ISysFileService sysFileService;

    @Autowired
    private FileService fileService;

    /**
     * 文件上传请求
     */
    @PostMapping("upload")
    public R<SysFile> upload(MultipartFile file) {
        try {
            Long userId = SecurityUtils.getUserId();
            // 上传并返回访问地址
            String url = sysFileService.uploadFile(file);
            SysFile sysFile = new SysFile();
            sysFile.setfOldFileName(file.getOriginalFilename());
            sysFile.setfNewFileName(FileUtils.getName(url));
            sysFile.setfFilePath(url);
            sysFile.setfCreateBy(String.valueOf(userId));
            fileService.insertSysFile(sysFile);
            return R.ok(sysFile);
        } catch (Exception e) {
            log.error("上传文件失败", e);
            return R.fail(e.getMessage());
        }
    }

    /**
     * 根据id获取文件实体
     * @param id
     * @return
     */
    @GetMapping("getFileById")
    public R<SysFile> getFileById(@RequestParam(value = "id") String id) {
        SysFile sysFile = fileService.getFileById(id);
        return R.ok(sysFile);
    }

    /**
     * 删除文件
     * @param id
     * @return
     */
    @GetMapping("delFile")
    public AjaxResult delFile(@RequestParam(value = "id") Long id){
        return  fileService.delFile(id);
    }

}