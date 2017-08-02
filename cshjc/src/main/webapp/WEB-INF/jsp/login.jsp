<%--
  Created by IntelliJ IDEA.
  User: Guide
  Date: 2016/12/12
  Time: 21:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    // 获得项目完全路径（假设你的项目叫MyApp，那么获得到的地址就是 http://localhost:8080/MyApp）:
    //todo 修改项目目录
    String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()+"/cshjc";

    String basePathAdmin = basePath+"/sysadmin";
%>
<html>
<head>
    <meta charset="UTF-8">
    <title>黑臭河监测后台管理系统 v1.0</title>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/bsLogin.css" />
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/font/iconfont.css"/>
</head>

<body>
<input type="hidden" id="TenantId" name="TenantId" value="" />
<div class="content-box">
    <div class="img-box">
        <img src="<%=basePath%>/img/bsimg.png"/>
    </div>
    <div class="login-box">
        <div class="login-content">
            <div class="logo">
                <img src="<%=basePath%>/img/logo.png"/>
            </div>
            <form  method="post" id="log-form">
                <div class="admin-box">
                    <i class="iconfont">&#xe606;</i>
                    <input type="text" name="nm" id="name" value="admin" placeholder="请输入登录名" autocomplete="off"/>
                </div>
                <div class="pass-box">
                    <i class="iconfont">&#xe601;</i>
                    <input type="password" name="pwd" id="password" value="admin" placeholder="请输入密码" autocomplete="off"/>
                </div>
                <div class="verification-box">
                    <input type="text" name="verification" id="authorCode" value="" autocomplete="off" onclick="if(this.value!=''){this.value='';}" />
                    <img src="<%=basePath%>/util.do?method=authorcode" id="codeImage"/>
                    <span  onclick="changeCode();">看不清，换一张</span>
                </div>
                <div class="pass-line">
                    <div class="remem-pass" id="remem-pass">
                        <input type="checkbox" name="remen-pass" id="online"  /> 记住密码
                    </div>
                </div>
                <div class="log-btn">
                    <button type="button"  onclick="login();">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
<div class="nav">
    <ul class="nav-box">
        <li>FaceH5  专注品牌营销 尽享创意饕餮</li>
        <li><a href="http://www.faceh5.com">官方网站</a></li>
        <li><a href="http://www.weibo.com/faceh5">官方微博</a></li>
        <li><a href="http://mp.weixin.qq.com">微信后台</a></li>
        <li>Copyright © 2017 匠心科技</li>
    </ul>
</div>
<script type="text/javascript" src="http://apps.bdimg.com/libs/jquery/2.1.4/jquery.min.js"></script>
<script type="text/javascript" src="http://apps.bdimg.com/libs/layer/2.1/layer.js"></script>
<script>
    $("#remem-pass").on('click', function() {
        changeBg();
    });

    function changeCode() {
        $("#codeImage").attr("src","<%=basePath%>/util.do?method=authorcode&d="+Math.random());
    }

    function changeBg(){
        if($("#online").is(":checked")){
            $('#online').prop("checked", false);
            $("#remem-pass").css("background-image","url(<%=basePath%>/img/logincf.png)");
        }
        else{
            $('#online').prop("checked", true);
            $("#remem-pass").css("background-image","url(<%=basePath%>/img/loginct.png)");
        }
    }
</script>
<script >
    <%--cookie缓存--%>
    $(document).keydown(function(event){
        if(event.keyCode==13){ login();}
    });

    if (localStorage.getItem('Face_h5_name')) {
        $("#name").val(localStorage.getItem('Face_h5_name'));
        $("#password").val(localStorage.getItem('Face_h5_password'));
        $('#online').prop("checked", true);
        $("#remem-pass").css("background-image","url(<%=basePath%>/img/loginct.png)");
    }

    function login(){

        var name = $("#name").val();
        var password = $("#password").val();
        var authorCode = $("#authorCode").val();
        var flag = true;
        if(name=="" || name.length==0){
            layer.msg('请输入用户名!', {
                icon: 5,
                time: 1000
            });
            return;
        }
        if(password=="" || password.length==0){
            layer.msg('请输入密码!', {
                icon: 5,
                time: 1000
            });
            return;
        }
        if(authorCode=="" || authorCode.length==0){
            layer.msg('请输入验证码!', {
                icon: 5,
                time: 1000
            });
            return;
        }
        $.ajax({
            url:"<%=basePathAdmin%>/main.do?method=dologin",
            type: "get",
            dataType: "json",
            data:{
                nm:name,
                pwd:password,
                authorCode:authorCode
            },
            success:function (data) {
                if(data.state==200){
                    if($("#online").is(":checked")){
                        localStorage.setItem('Face_h5_name', $("#name").val());
                        localStorage.setItem('Face_h5_password',$("#password").val());
                    }else{
                        localStorage.removeItem('Face_h5_name');
                        localStorage.removeItem('Face_h5_password');
                    }
                    layer.msg(data.message, {
                        icon: 1,
                        time: 2000
                    });
                    window.location.href="<%=basePathAdmin%>/main.do?method=home";
                }else{
                    localStorage.removeItem('Face_h5_name');
                    localStorage.removeItem('Face_h5_password');
                    layer.msg(data.message,{
                        icon: 5,
                        time: 1000
                    }, function(){
                        //nothing
                        $("#password").val("");
                    });

                }
            }
        })

    }
</script>
</body>
</html>
