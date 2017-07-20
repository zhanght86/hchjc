<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Guide
  Date: 2016/12/27
  Time: 18:33
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+"/h5";
    String basePath2 = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
%>

<html>

<head>
    <meta charset="utf-8"/>
    <title>Face H5</title>
</head>

<body>
    <c:if test="${sessionScope.userInfo!=null}" >
        欢迎您，${sessionScope.userInfo.nickname}
    </c:if>
    <c:if test="${sessionScope.userInfo==null}">
        <a href="https://open.weixin.qq.com/connect/qrconnect?appid=wxa272e955324337be&redirect_uri=http%3A%2F%2Fwww.faceh5.com%2Fuser.do%3Fmethod%3Dwechatreg&response_type=code&scope=snsapi_login&state=STATE#wechat_redirect">请登录</a>
    </c:if>


</body>

</html>