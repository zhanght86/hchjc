package cn.river.web;

import cn.river.datas.AuthorityEnums;
import cn.river.dto.AjaxResult;
import cn.river.dto.DataTables;
import cn.river.dto.DataTablesResult;
import cn.river.entity.AuthoritiesEntity;
import cn.river.entity.AuthoritiesEntity;
import cn.river.service.AuthoritiesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Iterator;

/**
 * Created by Guide on 2017/3/20.
 */
@Controller
@RequestMapping("sysadmin/authorities.do")
public class AuthoritiesAction {
    private final AuthoritiesService authoritiesService;
    @Autowired
    public AuthoritiesAction(AuthoritiesService authoritiesService) {
        this.authoritiesService = authoritiesService;
    }

    //列表页面
    @RequestMapping(params = "method=listpage")
    public String listpage(){
        return "jsp/authorities-list";
    }
    //获取列表ajax
    @RequestMapping(params = "method=querylist")
    @ResponseBody
    public DataTablesResult querylist(DataTables dataTables){
        return authoritiesService.queryList(dataTables);
    }
    //新增页面
    @RequestMapping(params = "method=create")
    public String create(Model model){
        model.addAttribute("authorityList", AuthorityEnums.values());
        return "jsp/authorities-add";
    }
    //添加操作
    @RequestMapping(params = "method=insert")
    @ResponseBody
    public AjaxResult insert(AuthoritiesEntity authoritiesEntity){
        return authoritiesService.insert(authoritiesEntity);
    }
    //更新页面
    @RequestMapping(params = "method=update")
    public String update(Model model, int id){
        model.addAttribute("authorityList", AuthorityEnums.values());
        model.addAttribute("authority",authoritiesService.queryId(id));
        return "jsp/authorities-update";
    }
    //执行更新
    @RequestMapping(params = "method=doupdate")
    @ResponseBody
    public AjaxResult doupdate(AuthoritiesEntity authoritiesEntity){
        return authoritiesService.update(authoritiesEntity);
    }

    //删除id
    @RequestMapping(params = "method=delete")
    @ResponseBody
    public AjaxResult delete(int id){
        return authoritiesService.delete(id);
    }
    //批量删除
    @RequestMapping(params = "method=deletelist")
    @ResponseBody
    public AjaxResult deletelist(@RequestParam("checkBoxforDel")String checkBoxforDel){
        return authoritiesService.deleteList(checkBoxforDel);
    }

}
