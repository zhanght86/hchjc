package cn.river.web;

import java.io.IOException;

import cn.river.constants.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Guide on 2017/4/23.
 */
@Controller
public class FrontMainAction {
    @RequestMapping({"","/","/index.html","/index.jsp","/index"})
    public void homePage(HttpServletRequest request,HttpServletResponse response, Model model) throws IOException{
        response.sendRedirect(Constants.HOST_REDIRECT_URL);
    }

}
