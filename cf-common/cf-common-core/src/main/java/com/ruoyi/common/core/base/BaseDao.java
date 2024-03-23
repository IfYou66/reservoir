package com.ruoyi.common.core.base;

import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Mapper;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 基础的Dao公用类
 * @author HanJian
 */
@Mapper
public interface BaseDao<T extends Serializable> {
	
	
	
	/**
	 * 保存对象
	 * @return
	 */
	 public Integer insert(T obj);
	 /**
		 * 保存对象
		 * @return
	*/
	 public Integer insert(String sqlId, Object obj);
	 
	 
	/**
	  * 更新对象
	*/
	public Integer update(T obj);
	/**
     * 更新对象
     */
    public Integer update(String sqlId, Object obj);
    /**
     * 删除对象
     */
    public Integer delete(T obj);
    /**
     * 删除对象
     */
    public Integer delete(String sqlId, Object obj);
    /**
     * 删除对象
     */    
    public Integer delete(Class<T> clazz, long id);
    /**
	 * 批量删除对象
	 * @param ids
	 * @return
	 */
	public Integer batchDelete(Class<T> clazz, Long[] ids);
    /**
     * 查询单条记录
     */
    public T load(Class<T> clazz, long id);
    /**
     * 查询单条记录
     */
    public T load(String sqlId, Object param);
    /**
     * List查询
     */
    public List<T> list(Class<T> clazz, Object params);
    /**
     * List查询
     */
    public List<T> list(String sqlId, Object obj) ;
    /**
     * 分页查询
     */	
	public PageInfo<T> pageList(String sqlId, Map<String, Object> params);
    
    /**
     * 统计，参数为Map
     */
    public Integer count(String sqlId, Map<String, Object> params);
    /**
     * 统计，参数为任意类型对象
     */
    public Integer count(String sqlId, Object parameter);
    /**
     * 查询任意单个数据
     */
    public Object obj(String sqlId, Map<String, Object> params);
    /**
     * 查询任意单个数据
     */
    public Object obj(String sqlId, Object parameter);
    
    /**
     * 查询任意多条数据
     */
    public List<Object> objList(String sqlId, Object parameter);
	
	
	
	
}