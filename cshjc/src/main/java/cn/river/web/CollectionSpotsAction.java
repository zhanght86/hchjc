package cn.river.web;

import java.util.ArrayList;
import java.util.List;

import cn.river.dto.AjaxResult;
import cn.river.dto.AjaxResult2;
import cn.river.dto.DataTables;
import cn.river.dto.DataTablesResult;
import cn.river.entity.CollectionSpotsEntity;
import cn.river.service.CollectionSpotsService;
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
@RequestMapping("sysadmin/spots.do")
public class CollectionSpotsAction {
	
    private final CollectionSpotsService spotsService;
    @Autowired
    public CollectionSpotsAction(CollectionSpotsService spotsService) {
        this.spotsService = spotsService;
    }
    
  //列表页面
    @RequestMapping(params = "method=listpage")
    public String listpage(){
        return "jsp/spots-list";
    }
  //获取列表ajax
    @RequestMapping(params = "method=querylist")
    @ResponseBody
    public DataTablesResult querylist(DataTables dataTables){
        return spotsService.queryList(dataTables);
    }
    //新增页面
    @RequestMapping(params = "method=create")
    public String create(Model model){

        return "jsp/spots-add";
    }
    //添加操作
    @RequestMapping(params = "method=insert")
    @ResponseBody
    public AjaxResult insert(CollectionSpotsEntity spotsEntity){
        System.out.println(spotsEntity.toString());
        return spotsService.insert(spotsEntity);
    }
    //更新页面
    @RequestMapping(params = "method=update")
    public String update(Model model, Integer spotId){
        model.addAttribute("spot",spotsService.queryId(spotId));
        return "jsp/spots-update";
    }
    //执行更新
    @RequestMapping(params = "method=doupdate")
    @ResponseBody
    public AjaxResult doupdate(CollectionSpotsEntity spotsEntity){
        return spotsService.update(spotsEntity);
    }
  
    //删除id
    @RequestMapping(params = "method=delete")
    @ResponseBody
    public AjaxResult delete(Integer spotId){
        return spotsService.delete(spotId);
    }
    //批量删除
    @RequestMapping(params = "method=deletelist")
    @ResponseBody
    public AjaxResult deletelist(@RequestParam("checkBoxforDel")String checkBoxforDel){
        return spotsService.deleteList(checkBoxforDel);
    }
}
