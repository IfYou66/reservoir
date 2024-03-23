package com.ruoyi.system.api.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cloud.openfeign.FallbackFactory;
import org.springframework.stereotype.Component;

import com.ruoyi.common.core.web.domain.AjaxResult;
import com.ruoyi.system.api.RemoteDictService;

/**
 * 数据字典服务降级处理
 * 
 * @author ruoyi
 */
@Component
public class RemoteDictFallbackFactory implements FallbackFactory<RemoteDictService>
{
    private static final Logger log = LoggerFactory.getLogger(RemoteDictFallbackFactory.class);

    @Override
    public RemoteDictService create(Throwable throwable)
    {
        log.error("数据字典服务调用失败:{}", throwable.getMessage());
        return new RemoteDictService()
        {
            @Override
            public AjaxResult getDictDataInfo(String dictType)
            {
                return AjaxResult.error("数据字典失败:" + throwable.getMessage()) ;
            }
            
        };
    }
}
