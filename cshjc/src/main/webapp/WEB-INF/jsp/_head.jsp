<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+"/cshjc";
    String basePathAdmin = basePath+"/sysadmin";
%>
<meta charset="utf-8">
<meta name="renderer" content="webkit|ie-comp|ie-stand">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
      content="width=device-width,initial-scale=1,minimum-scale=1.0,maximum-scale=1.0,user-scalable=no"/>
<%--<meta http-equiv="Cache-Control" content="no-siteapp"/>--%>
<LINK rel="Bookmark" href="<%=basePath%>/assets/img/favicon.ico">
<LINK rel="Shortcut Icon" href="<%=basePath%>/assets/img/favicon.ico" />
<!--[if lt IE 9]>
<script type="text/javascript" src="<%=basePath%>/assets/lib/html5.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/respond.js/1.4.2/respond.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/assets/lib/PIE_IE678.js"></script>
<![endif]-->
<link rel="stylesheet" type="text/css" href="<%=basePath%>/assets/plugins/h-ui/css/H-ui.min.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/assets/plugins/h-ui.admin/css/H-ui.admin.css"/>
<link rel="stylesheet" type="text/css" href="<%=basePath%>/assets/lib/Hui-iconfont/1.0.7/iconfont.css"/>
<link href="http://cdn.bootcss.com/iCheck/1.0.2/skins/flat/blue.css" rel="stylesheet">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/assets/plugins/h-ui.admin/skin/default/skin.css" id="skin"/>
<link rel="stylesheet" href="http://cdn.bootcss.com/Dropify/0.2.1/css/dropify.min.css" type="text/css">
<link rel="stylesheet" href="http://apps.bdimg.com/libs/chosen/1.1.0/chosen.css" type="text/css">
<title>黑臭河监测后台管理系统 v1.0</title>
<meta name="keywords" content="">
<meta name="description" content="">