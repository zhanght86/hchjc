package cn.river.interceptors;

/**
 * Created by Guide on 2016/12/9.
 */

import cn.river.utils.UtilMedia;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 这是一个类
 */
public class UserAgentCheck implements HandlerInterceptor {


    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {
//        String s1 = httpServletRequest.getHeader("user-agent");
//        if(s1.contains("Android")) {
//            System.out.println("Android移动客户端");
//        } else if(s1.contains("iPhone")) {
//            System.out.println("iPhone移动客户端");
//        }  else if(s1.contains("iPad")) {
//            System.out.println("iPad客户端");
//        }  else {
//            System.out.println("其他客户端");
//        }
        boolean isMobileDevice = UtilMedia.isMobileDevice(httpServletRequest);
//        httpServletRequest.setAttribute("isMobileDevice",isMobileDevice);
        String prefix = "templates/pc/";
        if(isMobileDevice){
            prefix = "templates/phone/";
        }
        httpServletRequest.setAttribute("prefix",prefix);
        return true;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
