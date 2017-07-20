package cn.river.interceptors;

import cn.river.datas.DataEnums;
import cn.river.datas.AuthorityEnums;
import cn.river.entity.AdminsEntity;
import cn.river.entity.AuthoritiesEntity;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * Created by Guide on 2016/12/10.
 */
public class AdminLoginCheck implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o) throws Exception {

        String url = httpServletRequest.getRequestURI();

        if (url.contains("main.do")) {
            return true;
        }

        //todo 权限筛选url链接 检查是否齐全
        String[] uris = {"spots.do","devices.do","interfaces.do","data-center.do","data-backup.do","data-recovery.do","data-clean.do","authorities.do","admins.do","sysparams.do"};

        String[] authority = {AuthorityEnums.SPOTS.toString(),AuthorityEnums.DEVICES.toString(),AuthorityEnums.INTERFACES.toString(),AuthorityEnums.DATA_CENTER.toString(),AuthorityEnums.DATA_BACKUP.toString(),
        		AuthorityEnums.DATA_RECOVERY.toString(),AuthorityEnums.DATA_CLEAN.toString(),AuthorityEnums.AUTHORITIES.toString(),AuthorityEnums.ADMINS.toString(),AuthorityEnums.SYSPARAMs.toString()};

        AdminsEntity admin = (AdminsEntity) httpServletRequest.getSession().getAttribute("adminInfo");

        if(admin==null || admin.getAuthority() == null || admin.getAuthority().getItems() == null){
           httpServletRequest.getRequestDispatcher(DataEnums.PATH_BASE.toString()).forward(httpServletRequest,httpServletResponse);
            return false;
        }
        for (int i=0 ;i<uris.length;i++){
            if(url.contains(uris[i])){
                return admin.getAuthority().getItems().contains(authority[i]);
            }
        }
        httpServletRequest.getRequestDispatcher(DataEnums.PATH_BASE.toString()).forward(httpServletRequest,httpServletResponse);
        return false;
    }

    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//        System.out.println("#########################");
    }

    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}
