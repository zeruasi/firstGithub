package cn.kgc.U3.controller;


import cn.kgc.U3.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

public class BaseController<T>{

    @Autowired
    private BaseService<T> baseService;

    @RequestMapping("getList")
    @ResponseBody
    public List<T> getList(){
        return baseService.getAllInfo();
    }

    @RequestMapping("getListByParams")
    @ResponseBody
    public List<T> getListByParam(T t){
        return baseService.getListByParam(t);
    }

    @RequestMapping("getCountByParams")
    @ResponseBody
    public Integer getCountByParam(T t){
        //System.out.println("controller:"+baseService.getCountByParam(t));
        return baseService.getCountByParam(t);
    }

    @RequestMapping("getMapList")
    @ResponseBody
    public Map<String,Object> getList(Integer page, Integer limit){
        Map<String, Object> map = null;
        try {
            map = baseService.getAllInfoForLayUI(page, limit);
            map.put("code",0);
            map.put("msg","服务器数据加载成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",200);
            map.put("msg","服务器数据加载失败");
        }
        return map;
    }

    @RequestMapping("getMapListByParams")
    @ResponseBody
    public Map<String,Object> getList(Integer page, Integer limit, T t){
        Map<String, Object> map = null;
        try {
            map = baseService.getAllInfoByParamsForLayUI(page, limit,t);
            map.put("code",0);
            map.put("msg","服务器数据加载成功");
        } catch (Exception e) {
            e.printStackTrace();
            map.put("code",200);
            map.put("msg","服务器数据加载失败");
        }
        System.out.println(map);
        return map;
    }

    @RequestMapping("getOne")
    @ResponseBody
    public T getOne(T t){
        //System.out.println(baseService.getOneInfoByParams(t));
        return baseService.getOneInfoByParams(t);
    }

    /**
     * 根据id删除
     * @param id 主键
     * @return 0 删除成功；1 删除失败 ；
     */
    @RequestMapping("remove")
    @ResponseBody
    public String removeEmp(Integer id){
        //Boolean flag = empService.removeEmpByEmpNo(empno);
        if(baseService.removeInfoById(id)){
            return "0";
        }
        return "1";
    }

    /**
     * 根据id数组删除
     * @param ids 编号数组
     * @return 0 删除成功；1 删除失败 ；
     */
    @RequestMapping("removeList")
    @ResponseBody
    public String removeEmp(Integer[] ids){
        //Boolean flag = empService.removeEmpByEmpNo(empno);
        //System.out.println(ids);
        if(baseService.removeInfoByArray(ids)){
            return "0";
        }
        return "1";
    }

    @RequestMapping("add")
    @ResponseBody
    public String addEmp(T t){
        //Boolean flag = empService.removeEmpByEmpNo(empno);
        //System.out.println(emp.getEname());
        if(baseService.addInfo(t)){
            return "0";
        }
        return "1";
    }

    @RequestMapping("edit")
    @ResponseBody
    public String editEmp(T t){
        if(baseService.editInfo(t)){
            return "0";
        }
        return "1";
    }
}
