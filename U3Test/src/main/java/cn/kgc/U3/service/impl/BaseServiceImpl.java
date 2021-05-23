package cn.kgc.U3.service.impl;




import cn.kgc.U3.dao.BaseMapper;
import cn.kgc.U3.service.BaseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BaseServiceImpl<T> implements BaseService<T> {

    @Autowired
    private BaseMapper<T> baseMapper;


    @Override
    public Map<String, Object> getAllInfoForLayUI(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        List<T> list = baseMapper.selectInfo();
        list.forEach(a-> System.out.println(a));
        PageInfo pageInfo=new PageInfo(list);
        return getLayUIMap(pageInfo);
    }

    @Override
    public List<T> getAllInfo() {
        return baseMapper.selectInfo();
    }

    @Override
    public List<T> getListByParam(T t) {
        return baseMapper.selectInfoByParam(t);
    }

    @Override
    public T getOneInfoByParams(T t) {
        System.out.println(baseMapper.selectOneByParams(t));
        return baseMapper.selectOneByParams(t);
    }

    @Override
    public Integer getCountByParam(T t) {
        //System.out.println("service:"+baseMapper.selectCountByParam(t));
        return baseMapper.selectCountByParam(t);
    }

    @Override
    public Map<String, Object> getAllInfoByParamsForLayUI(Integer page, Integer limit, T t) {
        PageHelper.startPage(page,limit);
        List<T> list = baseMapper.selectInfoByParams(t);
        PageInfo pageInfo=new PageInfo(list);
        return getLayUIMap(pageInfo);
    }

    @Override
    public Boolean removeInfoById(Integer id) {
        return baseMapper.deleteByPrimaryKey(id)>0;
    }

    @Override
    public Boolean removeInfoByArray(Integer[] ids) {
        if(baseMapper.deleteInfoByArray(ids)!=ids.length){
            int i=1/0;
        }
        return true;
    }

    @Override
    public Boolean addInfo(T t) {
        return baseMapper.insertSelective(t)>0;
    }

    @Override
    public Boolean editInfo(T t) {
        return baseMapper.updateByPrimaryKeySelective(t)>0;
    }

    private Map<String,Object> getLayUIMap(PageInfo pageInfo){
        Map<String,Object> map=new HashMap<>();
        map.put("data",pageInfo.getList());
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
