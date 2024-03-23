package com.ruoyi.file.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.ruoyi.file.mapper.SysFileMapper;
import com.ruoyi.file.service.FileService;
import com.ruoyi.system.api.domain.SysFile;

@Service
public class FileServiceImpl implements FileService {

    @Autowired
    SysFileMapper sysFileMapper;

    @Override
    @Reservoir
    public int insertSysFile(SysFile sysFile) {
       return sysFileMapper.insertSysFile(sysFile);
    }

    @Override
    public SysFile getFileById(String id) {
        SysFile sysFile = sysFileMapper.queryFile(id);
        return sysFile;
    }

    @Override
    public  AjaxResult delFile(Long id) {
        return sysFileMapper.delFile(id) > 0 ? AjaxResult.success("删除成功") : AjaxResult.error("删除失败");
    }

}
