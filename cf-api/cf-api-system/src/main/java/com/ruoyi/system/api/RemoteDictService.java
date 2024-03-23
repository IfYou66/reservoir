package com.ruoyi.system.api;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.ruoyi.common.core.constant.ServiceNameConstants;
import com.ruoyi.common.core.domain.R;
import com.ruoyi.common.core.domain.SysDictData;
import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.factory.RemoteDictFallbackFactory;

/**
 * 数据字典服务
 * 
 * @author ruoyi
 */
@FeignClient(contextId = "remoteDictService", value = ServiceNameConstants.SYSTEM_SERVICE, fallbackFactory = RemoteDictFallbackFactory.class)
public interface RemoteDictService
{	
    /**
     * 根据字典类型查询字典数据信息
     *
     * @param dictType 字典类型
     * @return 结果
     */
    @GetMapping(value = "/dict/data/type/{dictType}")
    public AjaxResult getDictDataInfo(@PathVariable("dictType") String dictType);
}
