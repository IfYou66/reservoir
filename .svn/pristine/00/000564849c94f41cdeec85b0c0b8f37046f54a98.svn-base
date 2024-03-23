package com.ruoyi.common.datascope.aspect;

import java.lang.reflect.Method;
import java.util.ArrayList;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ruoyi.common.core.utils.StringUtils;
import com.ruoyi.common.core.web.domain.BaseEntity;
import com.ruoyi.common.datascope.annotation.Reservoir;
import com.ruoyi.common.security.service.TokenService;
import com.ruoyi.system.api.domain.SysUser;
import com.ruoyi.system.api.model.LoginUser;

/**
 * 数据过滤处理
 * 
 * @author ruoyi
 */
@Aspect
@Component
public class ReservoirAspect
{
   

    @Autowired
    private TokenService tokenService;

    // 配置织入点
    @Pointcut("@annotation(com.ruoyi.common.datascope.annotation.Reservoir)")
    public void reservoirPointCut()
    {
    }

    @Before("reservoirPointCut()")
    public void doBefore(JoinPoint point) throws Throwable
    {
        clearReservoir(point);
        handleReservoir(point);
    }

    protected void handleReservoir(final JoinPoint joinPoint)
    {
        // 获得注解
    	Reservoir controllerDataScope = getAnnotationLog(joinPoint);
        if (controllerDataScope == null)
        {
            return;
        }
        // 获取当前的用户
        LoginUser loginUser = tokenService.getLoginUser();
        if (StringUtils.isNotNull(loginUser))
        {
            SysUser currentUser = loginUser.getSysUser();
            // 如果是超级管理员，则不过滤数据
            if (StringUtils.isNotNull(currentUser) && !currentUser.isAdmin())
            {
            	reservoirFilter(joinPoint, currentUser);
            }
        }
    }

    /**
     * 数据库信息获取
     * 
     * @param joinPoint 切点
     * @param user 用户
     */
    @SuppressWarnings("unchecked")
    public static void reservoirFilter(JoinPoint joinPoint, SysUser user)
    {
        

        if (user.getfReservoirInfoId() != null )
        {
            Object params = joinPoint.getArgs()[0];
            if (StringUtils.isNotNull(params) && params instanceof BaseEntity)
            {
                BaseEntity baseEntity = (BaseEntity) params;
                baseEntity.setfReservoirInfoId(user.getfReservoirInfoId());
            }else if (StringUtils.isNotNull(params) && params instanceof ArrayList)
            {
				ArrayList<BaseEntity> list  = (ArrayList<BaseEntity>) params;
            	for(BaseEntity obj : list) {
            		obj.setfReservoirInfoId(user.getfReservoirInfoId());;
            	}
            	
            }
        }
    }

    /**
     * 是否存在注解，如果存在就获取
     */
    private Reservoir getAnnotationLog(JoinPoint joinPoint)
    {
        Signature signature = joinPoint.getSignature();
        MethodSignature methodSignature = (MethodSignature) signature;
        Method method = methodSignature.getMethod();

        if (method != null)
        {
            return method.getAnnotation(Reservoir.class);
        }
        return null;
    }

    /**
     * 先清空params 数据库参数防止注入
     */
    private void clearReservoir(final JoinPoint joinPoint)
    {
        Object params = joinPoint.getArgs()[0];
        if (StringUtils.isNotNull(params) && params instanceof BaseEntity)
        {
            BaseEntity baseEntity = (BaseEntity) params;
            baseEntity.setfReservoirInfoId(null);
            
        }
    }
}
