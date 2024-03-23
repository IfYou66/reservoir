package com.ruoyi.common.core.base;

import com.github.pagehelper.PageInfo;
import com.ruoyi.common.core.utils.CustomSnowflakeIdWorker;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 基础的Service
 */
@Service
public abstract class BaseServiceImpl<T extends Serializable> implements BaseService<T>{
    @Resource
    protected BaseDao<T> dao;
    @Autowired
    CustomSnowflakeIdWorker customSnowflakeIdWorker;
    
    public CustomSnowflakeIdWorker getCustomSnowflakeIdWorker() {
		return customSnowflakeIdWorker;
	}

	/**
     * 添加对象
     */
    public Integer insert(T obj) {
        return dao.insert(obj);
    }

    /**
     * 添加对象，自指定sqlId
     */
    public Integer insert(String sqlId, Object obj) {
        return dao.insert(sqlId, obj);
    }

    /**
     * 更新对象
     */
    public Integer update(T obj) {
        return dao.update(obj);
    }

    /**
     * 更新对象,自指定sqlId
     */
    public Integer update(String sqlId, Object obj) {
        return dao.update(sqlId, obj);
    }
    
    /**
     * 删除对象
     */
    public Integer delete(T obj) {
        return dao.delete(obj);
    }

    /**
     * 删除对象,自指定sqlId
     */
    public Integer delete(String sqlId, Object obj) {
        return dao.delete(sqlId, obj);
    }
    
    /**
     * 删除对象,自指定Class/主键
     */    
    public Integer delete(Class<T> clazz, long id){
    	return dao.delete(clazz, id);
    }
    /**
     * 批量删除对象,自指定Class/主键
     */
    public	Integer batchDelete(Class<T> clazz,Long[] ids) {
    	return dao.batchDelete(clazz, ids);
    }
    /**
     * 加载对象，自指定Id
     */
    public T load(Class<T> clazz, long id) {
        return dao.load(clazz, id);
    }

    /**
     * 加载对象，自指定sqlId
     */
    public T load(String sqlId, Object param) {
        return dao.load(sqlId, param);
    }

    /**
     * 不带分页的查询
     */
    public List<T> list(Class<T> clazz, Map<String, Object> params) {
        return dao.list(clazz, params);
    }
    
    /**
     * 不带分页的查询,自指定sqlId/params
     */
    public List<T> list(String sqlId, Map<String, Object> params) {
        return dao.list(sqlId, params);
    }

    /**
     * 不带分页的查询,自指定sqlId/Object
     */
    public List<T> list(String sqlId, Object obj) {
        return dao.list(sqlId, obj);
    }
    /**
     * 带分页的查询
     */
    public Map<String, Object> pageList(Class<T> clazz, Map<String, Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageInfo<T> info = dao.pageList(clazz.getName()+".list", params);
        map.put("data", info.getList());
        map.put("total", info.getTotal());
        return map;
    }
    
    /**
     * 带分页的查询，自指定sqlId
     */
    public Map<String, Object> pageList(String sqlId, Map<String,Object> params) {
        Map<String, Object> map = new HashMap<String, Object>();
        PageInfo<T> info = dao.pageList(sqlId, params);
        map.put("data", info.getList());
        map.put("total", info.getTotal());
        return map;
    }
    /**
     * 统计
     */
    public Integer count(String sqlId, Map<String, Object> params) {
        return dao.count(sqlId, params);
    }
 
    /**
     * 查询任意单个数据
     */
    public Object obj(String sqlId, Map<String, Object> params) {
        return dao.obj(sqlId, params);
    }
    /**
     * 查询任意多条数据
     */
    public List<Object> objList(String sqlId, Object params){
    	 return dao.objList(sqlId, params);
    }
    
    

}
