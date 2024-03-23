package com.ruoyi.file.service;

import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.domain.SysFile;

public interface FileService {

    /**
     * 保存文件对象
     * @param sysFile
     * @return
     */
    int insertSysFile(SysFile sysFile);

    /**
     * 根据id 获取文件详情
     * @param id
     * @return
     */
    SysFile getFileById(String id);

    /**
     * 删除文件
     * @param id
     * @return
     */
    AjaxResult delFile(Long id);

}
