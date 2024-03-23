package com.ruoyi.common.core.base;

import com.ruoyi.common.core.utils.CustomSnowflakeIdWorker;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


public interface BaseService<T extends Serializable> {
	/**
	 * 雪花算法获取id
	 * @return
	 */
	public CustomSnowflakeIdWorker getCustomSnowflakeIdWorker();
	/**
	 * 批量删除
	 * @param ids
	 * @return
	 */
	 public	Integer batchDelete(Class<T> clazz, Long[] ids);
    /**
     * 添加对象
     */
    public Integer insert(T obj) ;

    /**
     * 添加对象，自指定sqlId
     */
    public Integer insert(String sqlId, Object obj) ;

    /**
     * 更新对象
     */
    public Integer update(T obj);

    /**
     * 更新对象,自指定sqlId
     */
    public Integer update(String sqlId, Object obj) ;

    /**
     * 删除对象
     */
    public Integer delete(T obj) ;

    /**
     * 删除对象,自指定sqlId
     */
    public Integer delete(String sqlId, Object obj) ;

    /**
     * 删除对象,自指定Class/主键
     */
    public Integer delete(Class<T> clazz, long id);

    /**
     * 加载对象，自指定Id
     */
    public T load(Class<T> clazz, long id) ;

    /**
     * 加载对象，自指定sqlId
     */
    public T load(String sqlId, Object param) ;

    /**
     * 不带分页的查询
     */
    public List<T> list(Class<T> clazz, Map<String, Object> params);

    /**
     * 不带分页的查询,自指定sqlId/params
     */
    public List<T> list(String sqlId, Map<String, Object> params);

    /**
     * 不带分页的查询,自指定sqlId/Object
     */
    public List<T> list(String sqlId, Object obj) ;
    /**
     * 带分页的查询
     */
    public Map<String, Object> pageList(Class<T> clazz, Map<String, Object> params);
    /**
     * 带分页的查询，自指定sqlId
     */
    public Map<String, Object> pageList(String sqlId, Map<String, Object> params);
    /**
     * 统计
     */
    public Integer count(String sqlId, Map<String, Object> params);
    /**
     * 查询任意单个数据
     */
    public Object obj(String sqlId, Map<String, Object> params);
    /**
     * 查询任意多条数据
     */
    public List<Object> objList(String sqlId, Object params);
}
