package cn.kgc.U3.service;

import java.util.List;
import java.util.Map;

public interface BaseService<T> {
    Map<String,Object> getAllInfoForLayUI(Integer page, Integer limit);

    Map<String,Object> getAllInfoByParamsForLayUI(Integer page, Integer limit, T t);

    T getOneInfoByParams(T t);

    List<T> getAllInfo();

    Boolean removeInfoById(Integer id);

    Boolean removeInfoByArray(Integer[] ids);

    Boolean addInfo(T t);

    Boolean editInfo(T t);

    List<T> getListByParam(T t);

    Integer getCountByParam(T t);
}
