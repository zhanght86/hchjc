package cn.river.web;

import java.util.ArrayList;
import java.util.List;

import cn.river.dto.AjaxResult;
import cn.river.dto.AjaxResult2;
import cn.river.dto.DataTables;
import cn.river.dto.DataTablesResult;
import cn.river.entity.DevicesEntity;
import cn.river.service.DevicesService;
import cn.river.service.SensorDataService;
import cn.river.utils.UtilDate;
import cn.river.utils.UtilLog;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by Guide on 2017/3/20.
 */
@Controller
@RequestMapping("sysadmin/devices.do")
public class DevicesAction {
	
	
    private final DevicesService devicesService;
    @Autowired
    public DevicesAction(DevicesService devicesService) {
        this.devicesService = devicesService;
    }
    
  //列表页面
    @RequestMapping(params = "method=listpage")
    public String listpage(){
        return "jsp/devices-list";
    }
  //获取列表ajax
    @RequestMapping(params = "method=querylist")
    @ResponseBody
    public DataTablesResult querylist(DataTables dataTables){
        return devicesService.queryList(dataTables);
    }
    //新增页面
    @RequestMapping(params = "method=create")
    public String create(Model model){

        return "jsp/devices-add";
    }
    //添加操作
    @RequestMapping(params = "method=insert")
    @ResponseBody
    public AjaxResult insert(DevicesEntity devicesEntity){
        System.out.println(devicesEntity.toString());
        return devicesService.insert(devicesEntity);
    }
    //更新页面
    @RequestMapping(params = "method=update")
    public String update(Model model, int id){
        model.addAttribute("device",devicesService.queryId(id));
        return "jsp/devices-update";
    }
    //执行更新
    @RequestMapping(params = "method=doupdate")
    @ResponseBody
    public AjaxResult doupdate(DevicesEntity devicesEntity){
        return devicesService.update(devicesEntity);
    }
  
    //删除id
    @RequestMapping(params = "method=delete")
    @ResponseBody
    public AjaxResult delete(int id){
        return devicesService.delete(id);
    }
    //批量删除
    @RequestMapping(params = "method=deletelist")
    @ResponseBody
    public AjaxResult deletelist(@RequestParam("checkBoxforDel")String checkBoxforDel){
        return devicesService.deleteList(checkBoxforDel);
    }
}
