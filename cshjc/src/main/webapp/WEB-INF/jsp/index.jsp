<%@ page import="cn.river.entity.AdminsEntity" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%--
  Created by IntelliJ IDEA.
  User: Guide
  Date: 2016/12/9
  Time: 16:10
  To change this template use File | Settings | File Templates.
--%>
<!--
//////////////////////////////////////////////
  ┏┓　　　┏┓
┏┛┻━━━┛┻┓
┃　　　　　　　┃ 　
┃　　　━　　　┃
┃　┳┛　┗┳　┃
┃　　　　　　　┃
┃　　　┻　　　┃
┃　　　　　　　┃
┗━┓　　　┏━┛
    ┃　　　┃ 神兽保佑　　　　　　　　
    ┃　　　┃ 代码无BUG！
    ┃　　　┗━━━┓
    ┃　　　　　　　┣┓
    ┃　　　　　　　┏┛
    ┗┓┓┏━┳┓┏┛
      ┃┫┫  ┃┫┫
      ┗┻┛　┗┻┛
//////////////////////////////////////////////
-->
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="_head.jsp" %>
    <%
        AdminsEntity admin = (AdminsEntity) request.getSession().getAttribute("adminInfo");
        if (admin==null || admin.getId()==null || admin.getId()<0){
            response.sendRedirect(basePath+"/sysadmin/main.do?method=login");
        }
    %>
    <style>
        /* 隐藏滚动条 */
        ::-webkit-scrollbar {
            width: 0
        }
    </style>
</head>
<body>
<header class="navbar-wrapper">
    <div class="navbar navbar-fixed-top">
        <div class="container-fluid cl"><a class="logo navbar-logo f-l mr-10 hidden-xs"
                                           href="javascript:history.go(0);">黑臭河监测后台管理系统</a><span
                class="logo navbar-slogan f-l mr-10 hidden-xs">V1.0</span> <a aria-hidden="false"
                                                                              class="nav-toggle Hui-iconfont visible-xs"
                                                                              href="javascript:;">&#xe667;</a>
            <nav id="Hui-userbar" class="nav navbar-nav navbar-userbar hidden-xs">
                <ul class="cl">
                    <li>${sessionScope.adminInfo.authority.title}</li>
                    <li class="dropDown dropDown_hover"><a href="#"
                                                           class="dropDown_A">${sessionScope.adminInfo.username} <i
                            class="Hui-iconfont">
                        &#xe6d5;</i></a>
                        <ul class="dropDown-menu menu radius box-shadow">
                            <li><a href="javascript:0;"
                                   onclick="window_open('个人信息','<%=basePathAdmin%>/admins.do?method=update&id=${sessionScope.adminInfo.id}')">个人信息</a>
                            </li>
                            <li><a href="javascript:0;"
                                   onclick="window_open('修改密码','<%=basePathAdmin%>/admins.do?method=updatepwd&id=${sessionScope.adminInfo.id}')">修改密码</a>
                            </li>
                            <li><a href="<%=basePathAdmin%>/main.do?method=logout">安全退出</a></li>
                        </ul>
                    </li>
                </ul>
            </nav>
        </div>
    </div>
</header>
<!-- todo 权限筛选显示-->
<aside class="Hui-aside">
    <div class="menu_dropdown bk_2">
        <c:if test="${sessionScope.adminInfo.authority.items.contains('采集点管理')}">
            <dl id="menu-slide">
                <dt><i class="Hui-iconfont">&#xe613;</i>
                    <a data-href="<%=basePathAdmin%>/spots.do?method=listpage" data-title="采集点管理"
                       href="javascript:void(0)">
                        采集点管理</a></dt>
            </dl>
        </c:if>
		<c:if test="${sessionScope.adminInfo.authority.items.contains('设备管理')}">
            <dl id="menu-slide">
                <dt><i class="Hui-iconfont">&#xe613;</i>
                    <a data-href="<%=basePathAdmin%>/devices.do?method=listpage" data-title="设备管理"
                       href="javascript:void(0)">
                        设备管理</a></dt>
            </dl>
        </c:if>
        <c:if test="${sessionScope.adminInfo.authority.items.contains('接口管理')}">
            <dl id="menu-slide">
                <dt><i class="Hui-iconfont">&#xe613;</i>
                    <a data-href="<%=basePathAdmin%>/interfaces.do?method=listpage" data-title="接口管理"
                       href="javascript:void(0)">
                        接口管理</a></dt>
            </dl>
        </c:if>
		<c:if test="${sessionScope.adminInfo.authority.items.contains('数据中心')}">
            <dl id="menu-slide">
                <dt><i class="Hui-iconfont">&#xe613;</i>
                    <a data-href="<%=basePathAdmin%>/data-center.do?method=listpage" data-title="数据中心"
                       href="javascript:void(0)">
                        数据中心</a></dt>
            </dl>
        </c:if>
		<dl id="menu-system">
            <dt><i class="Hui-iconfont">&#xe61a;</i> 数据库管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <c:if test="${sessionScope.adminInfo.authority.items.contains('数据备份')}">
                        <li>
                            <a data-href="<%=basePathAdmin%>/data-backup.do?method=listpage" data-title="数据备份"
                               href="javascript:void(0)">
                                数据备份</a>
                        </li>
                    </c:if>
					<c:if test="${sessionScope.adminInfo.authority.items.contains('数据备份')}">
                        <li>
                            <a data-href="<%=basePathAdmin%>/data-recovery.do?method=listpage" data-title="数据备份"
                               href="javascript:void(0)">
                                数据备份</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.adminInfo.authority.items.contains('数据清洗')}">
                        <li>
                            <a data-href="<%=basePathAdmin%>/data-clean.do?method=listpage" data-title="数据清洗"
                               href="javascript:void(0)">
                                数据清洗</a>
                        </li>
                    </c:if>
                </ul>
            </dd>
        </dl>
        <dl id="menu-system">
            <dt><i class="Hui-iconfont">&#xe61a;</i> 系统管理<i class="Hui-iconfont menu_dropdown-arrow">&#xe6d5;</i></dt>
            <dd>
                <ul>
                    <c:if test="${sessionScope.adminInfo.authority.items.contains('权限管理')}">
                        <li>
                            <a data-href="<%=basePathAdmin%>/authorities.do?method=listpage" data-title="权限管理"
                               href="javascript:void(0)">
                                权限管理</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.adminInfo.authority.items.contains('管理员管理')}">
                        <li>
                            <a data-href="<%=basePathAdmin%>/admins.do?method=listpage" data-title="管理员管理"
                               href="javascript:void(0)">
                                管理员管理</a>
                        </li>
                    </c:if>
                    <c:if test="${sessionScope.adminInfo.authority.items.contains('系统参数')}">
                        <li>
                            <a data-href="<%=basePathAdmin%>/sysparams.do?method=listpage" data-title="系统参数"
                               href="javascript:void(0)">
                                系统参数</a>
                        </li>
                    </c:if>
                </ul>
            </dd>
        </dl>
    </div>
</aside>
<div class="dislpayArrow hidden-xs">
    <a class="pngfix" href="javascript:void(0);" onClick="displaynavbar(this)"></a>
</div>
<section class="Hui-article-box">
    <div id="Hui-tabNav" class="Hui-tabNav hidden-xs">
        <div class="Hui-tabNav-wp">
            <ul id="min_title_list" class="acrossTab cl">
                <li class="active"><span title="综合信息" data-href="welcome.html">综合信息</span><em></em></li>
            </ul>
        </div>
        <div class="Hui-tabNav-more btn-group"><a id="js-tabNav-prev" class="btn radius btn-default size-S"
                                                  href="javascript:;"><i class="Hui-iconfont">&#xe6d4;</i></a><a
                id="js-tabNav-next" class="btn radius btn-default size-S" href="javascript:;"><i class="Hui-iconfont">
            &#xe6d7;</i></a></div>
    </div>
    <div id="iframe_box" class="Hui-article">
        <div class="show_iframe">
            <div class="loading"></div>
            <iframe scrolling="yes" frameborder="0" src="<%=basePathAdmin%>/main.do?method=welcome"></iframe>
        </div>
    </div>
</section>
<%@include file="_foot.jsp" %>
<script>
    /*打开窗口*/
    function window_open(title, url) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url
        });
        layer.full(index);
    }
</script>
</body>
</html>