package com.example.generator.core;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * @author panzhi
 * @Description 服务类
 * @since 2020-11-11
 */
public interface BaseService<T> {

    /**
     * 新增
     * @param entity
     * @return boolean
     */
    boolean insert(T entity);

    /**
     * 批量新增
     * @param list
     * @return boolean
     */
    boolean insertList(List<T> list);

    /**
     * 通过ID修改记录（如果想全部更新，只需保证字段都不为NULL）
     * @param entity
     * @return boolean
     */
    boolean updateById(T entity);

    /**
     * 通过ID批量修改记录（如果想全部更新，只需保证字段都不为NULL）
     * @param list
     * @return boolean
     */
    boolean updateBatchByIds(List<T> list);

    /**
     * 根据ID删除
     * @param id 主键ID
     * @return boolean
     */
    boolean deleteById(Serializable id);

    /**
     * 根据ID查询
     * @param id 主键ID
     * @return
     */
    T selectById(Serializable id);

    /**
     * 按需查询
     * @param entity
     * @return
     */
    List<T> selectByPrimaryKeySelective(T entity);

    /**
     * 批量查询
     * @param ids
     * @return
     */
    List<T> selectByIds(List<? extends Serializable> ids);

    /**
     * 根据条件查询
     * @param columnMap
     * @return
     */
    List<T> selectByMap(Map<String, Object> columnMap);

}
