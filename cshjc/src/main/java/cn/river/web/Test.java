package cn.river.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import cn.river.utils.UtilMD5;

@Controller
@RequestMapping("/test.do")
public class Test {
	@RequestMapping(params = "method=test")
	public void test(HttpServletRequest request, HttpServletResponse response) {
		System.out.println(UtilMD5.getMD5Code("管理员密码："+"cshjc2017"));
	}
}
