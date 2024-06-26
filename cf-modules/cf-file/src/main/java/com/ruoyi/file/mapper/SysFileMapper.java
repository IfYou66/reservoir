package com.ruoyi.file.mapper;

import com.ruoyi.system.api.domain.SysFile;

import java.util.List;

/**
 * @author: Xia
 * @create: 2021/8/11 16:34
 * @description:
 **/
public interface SysFileMapper {
    /**
     * 查询文件
     * @param id
     * @return
     */
    public SysFile queryFile(String id);

    /**
     * 保存上传文件
     * @param file
     * @return
     */
    public int insertSysFile(SysFile file);

    /**
     * 删除文件
     * @param id
     * @return
     */
    public int delFile(Long id);
}
