<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Guide
  Date: 2016/12/14
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="_head.jsp" %>
</head>
<style>
    .headImage {
        width: 128px;
        height: 128px;
        border-radius: 128px;
        -webkit-box-shadow: 0px 0px 12px #7E7E7E;
        -moz-box-shadow: 0px 0px 12px #7E7E7E;
        -ms-box-shadow: 0px 0px 12px #7E7E7E;
        -o-box-shadow: 0px 0px 12px #7E7E7E;
        box-shadow: 0px 0px 12px #7E7E7E;
        cursor: pointer;
    }
</style>

<body>
<article class="page-container">
    <form class="form form-horizontal" id="form-slide-add" method="post" enctype="multipart/form-data">
        <input type="text" id="id" name="id" hidden="hidden" value="${admin.id}">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>头像：</label>
            <div class="formControls col-xs-6 col-sm-7">
                <img src="${admin.headImg}" alt="" style="display: block;max-width: 100%;" class="headImage">
                <input type="text" class="input-text" value="${admin.headImg}" placeholder="" id="headImg" name="headImg"
                       hidden>
            </div>
            <div class="formControls col-xs-2 col-sm-2">
                <button type="button" class="btn-danger btn" onclick="reloadImg(this)">重新上传</button>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>登录名：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${admin.username}" placeholder="登录名" id="username" name="username">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>邮箱：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" placeholder="@" name="email" id="email" value="${admin.email}">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>权限</label>
            <div class="formControls col-xs-8 col-sm-9">
                <select data-placeholder="选择管理员权限..." class="chosen-select" tabindex="2" style="width:100%;" name="authorityId">
                    <c:forEach items="${authoritiesList}" var="authority">
                        <option value="${authority.id}"  <c:if test="${admin.authorityId==authority.id}">selected</c:if>>${authority.title}</option>
                    </c:forEach>
                </select>
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">备注：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <textarea name="description" cols="" rows="" class="textarea" placeholder="说点什么...100个字符以内" dragonfly="true" onKeyUp="textarealength(this,100)">${admin.description}</textarea>
                <p class="textarea-numberbar"><em class="textarea-length">${fn:length(admin.description)}</em>/100</p>
            </div>
        </div>
        <br>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
                <button onClick="layer_close()" class="btn btn-default radius" type="button">
                    &nbsp;&nbsp;取消&nbsp;&nbsp;</button>
            </div>
        </div>
    </form>
</article>
<%@include file="_foot.jsp" %>
<script type="text/javascript">

    var config = {
        '.chosen-select': {},
        '.chosen-select-deselect': {allow_single_deselect: true},
        '.chosen-select-no-single': {disable_search_threshold: 10},
        '.chosen-select-no-results': {no_results_text: '找不到数据!'},
        '.chosen-select-width': {width: "95%"}
    }

    for (var selector in config) {
        $(selector).chosen(config[selector]);
    }

</script>
<script type="text/javascript">
    $(function () {

        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue',
            increaseArea: '20%'
        });

        $("#form-slide-add").validate({
            rules: {
                username: {
                    required: true,
                    minlength: 2,
                    maxlength: 16
                },
                headImg: {
                    required: true
                },
                password: {
                    minlength: 5,
                    maxlength: 20,
                    required: true
                },
                password2: {
                    minlength: 5,
                    maxlength: 20,
                    required: true,
                    equalTo: "#password"
                },
                email: {
                    required: true,
                    email: true
                },
                authorityId: {
                    required: true
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                var inputF = $("input.upfile");
                if (inputF != null && inputF.length != 0) {
                    layer.msg("头像未上传", {
                        icon: 5,
                        time: 1000
                    });
                    return;
                }
                $(form).ajaxSubmit({
                    url: "<%=basePathAdmin%>/admins.do?method=doupdate",
                    type: 'get',
                    dataType: 'json',
                    success: function (data) {
                        if (data.state == 200) {
                            layer.msg(data.message, {
                                icon: 1,
                                time: 1000
                            }, function () {
                                var index = parent.layer.getFrameIndex(window.name);
                                parent.location.reload();
                                parent.layer.close(index);
                            });
                        } else {
                            layer.msg(data.message, {
                                icon: 5,
                                time: 1000
                            }, function () {
                                //nothing
                            });
                        }
                    }
                });
            }
        });
    });

</script>
<script>

    function reloadImg(obj) {
        $(obj).closest("div.row").find("input").before('<input type="file" name="upfile" class="upfile"/>');
        $(obj).closest("div.row").find("input").attr("value", "");
        $(obj).closest("div.row").find("img").attr("src", "").css("display", "none");
        $(obj).attr("onclick", "uploadImage(this)");
        $(obj).attr("class", "btn-success btn");
        $(obj).html("上传");
    }


    function uploadImage(obj) {
        $("#form-slide-add").ajaxSubmit({
            url: "<%=basePath%>/util.do?method=ueditor&action=uploadimage",
            type: 'post',
            dataType: 'json',
            success: function (data) {
                if (data.state == "SUCCESS") {
                    $(obj).closest("div.row").find("input.upfile").remove();
                    $(obj).closest("div.row").find("input").attr("value", "<%=basePath%>" + data.url);
                    $(obj).closest("div.row").find("img").attr("src", "<%=basePath%>" + data.url).css("display", "block");
                    $(obj).attr("onclick", "reloadImg(this)");
                    $(obj).attr("class", "btn-danger btn");
                    $(obj).html("重新上传");
                } else {
                    layer.msg("失败，请重试", {
                        icon: 5,
                        time: 1000
                    });
                }
            }
        });
    }
</script>
<!--/请在上方写此页面业务相关的脚本-->
</body>

</html>
