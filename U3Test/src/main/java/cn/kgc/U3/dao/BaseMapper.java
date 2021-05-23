package cn.kgc.U3.dao;

import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface BaseMapper<T> {
    int insert(T t);

    int insertSelective(T t);

    int deleteByPrimaryKey(Integer id);

    int deleteInfoByArray(@Param("ids") Integer[] ids);

    int updateByPrimaryKeySelective(T t);

    int updateByPrimaryKey(T t);

    T selectByPrimaryKey(Integer id);

    List<T> selectInfo();

    List<T> selectInfoByParams(T t);

    T selectOneByParams(T t);

    List<T> selectInfoByParam(T t);

    Integer selectCountByParam(T t);
}
