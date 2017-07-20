package cn.river.web;

import cn.river.dto.AjaxResult;
import cn.river.service.AdminsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Guide on 2017/2/3.
 */
@Controller
@RequestMapping("/sysadmin/main.do")
public class BackLogin {

    private final AdminsService adminsService;

    @Autowired
    public BackLogin(AdminsService adminsService) {
        this.adminsService = adminsService;
    }

    //这里需要先搭建起管理员系统
    @RequestMapping(params = "method=login")
    public String login(){
        return "jsp/login";
    }

    @RequestMapping(params = "method=dologin")
    @ResponseBody
    public AjaxResult dologin(String nm, String pwd, HttpServletRequest request,String authorCode){
        return adminsService.validate(nm,pwd,request,authorCode);
    }

    @RequestMapping(params = "method=logout")
    public String logout(HttpServletRequest request){
        request.getSession().removeAttribute("adminInfo");
        return "jsp/login";
    }


    //后台首页
    @RequestMapping(params = "method=home")
    public String main(){
        return "jsp/index";
    }
    //后台首页 welcome
    @RequestMapping(params = "method=welcome")
    public String welcome(){
        return "jsp/welcome";
    }
}
