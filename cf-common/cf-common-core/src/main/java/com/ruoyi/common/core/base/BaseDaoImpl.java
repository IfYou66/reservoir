package com.ruoyi.common.core.base;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.io.Serializable;
import java.util.List;
import java.util.Map;


/**
 * 基础的Dao公用类
 * @author HanJian
 */
@Repository
public class BaseDaoImpl<T extends Serializable>  implements BaseDao<T>{
	
	@Autowired
	private SqlSession sqlSession;

	/**
     * 添加对象
     */
    public Integer insert(T obj) {
        try {
        	return sqlSession.insert(obj.getClass().getName() + ".insert", obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库添加失败");
        }
    }

    /**
     * 添加对象
     */
    public Integer insert(String sqlId, Object obj) {
        try {
        	return sqlSession.insert(sqlId, obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库添加失败");
        }
    }

    /**
     * 更新对象
     */
    public Integer update(T obj) {
        try {
            return sqlSession.update(obj.getClass().getName() + ".update", obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据更新失败");
        }
    }

    /**
     * 更新对象
     */
    public Integer update(String sqlId, Object obj) {
        try {
            return sqlSession.update(sqlId, obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库更新失败");
        }
    }

    /**
     * 删除对象
     */
    public Integer delete(T obj) {
        try {
        	return sqlSession.delete(obj.getClass().getName() + ".delete", obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库删除失败");
        }
    }

    /**
     * 删除对象
     */
    public Integer delete(String sqlId, Object obj) {
        try {
            return sqlSession.delete(sqlId, obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库删除失败");
        }
    }
    
    /**
     * 删除对象
     */    
    public Integer delete(Class<T> clazz, long id) {
        try {
            return sqlSession.delete(clazz.getName() + ".delete", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库删除失败");
        }
    }
    /**
     * 批量删除对象
     */
    public Integer batchDelete(Class<T> clazz, Long[] ids) {
        try {
            return sqlSession.delete(clazz.getName() + ".batchDelete", ids);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库删除失败");
        }
    }
    
    
    /**
     * 查询单条记录
     */
    public T load(Class<T> clazz, long id) {
        T obj = null;
        try {
        	obj = this.load(clazz.getName() + ".load", id);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return obj;
    }

    /**
     * 查询单条记录
     */
    public T load(String sqlId, Object param) {
        T obj = null;
        try {
            obj = sqlSession.selectOne(sqlId, param);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return obj;
    }
    
    /**
     * List查询
     */
    public List<T> list(Class<T> clazz, Object params) {
        List<T> list = null;
        try {
            list = sqlSession.selectList(clazz.getName() + ".list", params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return list;
    }
    

    /**
     * List查询
     */
    public List<T> list(String sqlId, Object obj) {
        List<T> list = null;
        try {
            list = sqlSession.selectList(sqlId , obj);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return list;
    }
    /**
     * 分页查询
     */	
	public PageInfo<T> pageList(String sqlId, Map<String,Object> params) {
        List<T> list = null;
        
        int pageNumber = 0;
        
        int pageSize = Integer.parseInt(params.get("pageSize")==null ?"1":params.get("pageSize").toString());
        
        if(params.get("pageNumber") != null) {
            pageNumber = Integer.parseInt(params.get("pageNumber").toString());
        } else {
            int start = Integer.parseInt(params.get("start")==null?"0":params.get("start").toString());
            pageNumber = start/pageSize + 1;
        }

        try {
            PageHelper.startPage(pageNumber, pageSize, true);
            list = sqlSession.selectList(sqlId, params);
            return new PageInfo<T>(list);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库分页查询失败");
        }
    } 
	
    
    /**
     * 统计，参数为Map
     */
    public Integer count(String sqlId, Map<String, Object> params) {
        Integer count = null;
        try {
            count = sqlSession.selectOne(sqlId, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return count;
    }
    
    /**
     * 统计，参数为任意类型对象
     */
    public Integer count(String sqlId, Object parameter) {
        Integer count = null;
        try {
            count = sqlSession.selectOne(sqlId, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return count;
    }
    
    /**
     * 查询任意单个数据
     */
    public Object obj(String sqlId, Map<String, Object> params) {
        Object obj = null;
        try {
        	obj = sqlSession.selectOne(sqlId, params);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return obj;
    }
    
    /**
     * 查询任意单个数据
     */
    public Object obj(String sqlId, Object parameter) {
        Object obj = null;
        try {
            obj = sqlSession.selectOne(sqlId, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return obj;
    }
    /**
     * 查询任意多条数据
     */
    public List<Object> objList(String sqlId, Object parameter) {
    	List<Object> objList = null;
        try {
        	objList = sqlSession.selectList(sqlId, parameter);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("数据库查询失败");
        }
        return objList;
    }
	
	
	
}