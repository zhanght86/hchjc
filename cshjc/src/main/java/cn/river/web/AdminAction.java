package cn.river.web;

import cn.river.dto.AjaxResult;
import cn.river.dto.DataTables;
import cn.river.dto.DataTablesResult;
import cn.river.entity.AdminsEntity;
import cn.river.service.AdminsService;
import cn.river.service.AuthoritiesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by Guide on 2017/2/4.
 */
@Controller
@RequestMapping("sysadmin/admins.do")
public class AdminAction {
    private final AdminsService adminsService;
    private final AuthoritiesService authorityesService;

    @Autowired
    public AdminAction(AdminsService adminsService, AuthoritiesService authorityesService) {
        this.adminsService = adminsService;
        this.authorityesService = authorityesService;
    }


    //列表页面
    @RequestMapping(params = "method=listpage")
    public String listpage(){
        return "jsp/admins-list";
    }
    //获取列表ajax
    @RequestMapping(params = "method=querylist")
    @ResponseBody
    public DataTablesResult querylist(DataTables dataTables){
        return adminsService.queryList(dataTables);
    }
    //新增页面
    @RequestMapping(params = "method=create")
    public String create(Model model){
        model.addAttribute("authoritiesList",authorityesService.queryAll());
        return "jsp/admins-add";
    }
    //添加操作
    @RequestMapping(params = "method=insert")
    @ResponseBody
    public AjaxResult insert(AdminsEntity adminsEntity){
        return adminsService.insert(adminsEntity);
    }
    //更新页面
    @RequestMapping(params = "method=update")
    public String update(Model model, int id){
        model.addAttribute("authoritiesList",authorityesService.queryAll());
        model.addAttribute("admin",adminsService.queryId(id));
        return "jsp/admins-update";
    }
    //执行更新
    @RequestMapping(params = "method=doupdate")
    @ResponseBody
    public AjaxResult doupdate(AdminsEntity adminsEntity){
        return adminsService.update(adminsEntity);
    }
    //更新密码页面
    @RequestMapping(params = "method=updatepwd")
    public String updatepwd(int id,Model model){
        model.addAttribute("adminId",id);
        return "jsp/admins-updatepwd";
    }
    //执行更新密码
    @RequestMapping(params = "method=doupdatepwd")
    @ResponseBody
    public AjaxResult doupdatepwd(AdminsEntity adminsEntity){
        return adminsService.updatepwd(adminsEntity);
    }

    //删除id
    @RequestMapping(params = "method=delete")
    @ResponseBody
    public AjaxResult delete(int id){
        return adminsService.delete(id);
    }
    //批量删除
    @RequestMapping(params = "method=deletelist")
    @ResponseBody
    public AjaxResult deletelist(@RequestParam("checkBoxforDel")String checkBoxforDel){
        return adminsService.deleteList(checkBoxforDel);
    }

}
