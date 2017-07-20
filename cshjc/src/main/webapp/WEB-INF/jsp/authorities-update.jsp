<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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

<body>
<article class="page-container">
    <form class="form form-horizontal" id="form-admin-add" method="post" enctype="multipart/form-data">
        <input type="text" value="${authority.id}" placeholder="" name="id" hidden>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>权限名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${authority.title}" placeholder="" id="title" name="title">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2">权限列表：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <dl class="permission-list">
                    <dt>
                        <label>
                            <input type="checkbox" value="0" name="user-Character-0" id="user-Character-1">
                            所有权限</label>
                    </dt>
                    <dd>
                        <dl class="cl permission-list2">
                            <c:forEach items="${authorityList}" var="authority2" varStatus="index">
                                <dt style="width: 30%;margin-top: 1em">
                                    <label class="">
                                        <input type="checkbox" value="${authority2.toString()}" name="items"
                                            <c:if test="${authority.items.contains(authority2.toString())}" >
                                                checked
                                        </c:if> >
                                        ${authority2.toString()}</label>
                                </dt>
                                <c:if test="${(1+index.index)%3==0}">
                                    <br>
                                </c:if>
                            </c:forEach>
                        </dl>
                    </dd>
                </dl>
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
    $(function () {
        $(".permission-list dt input:checkbox").click(function () {
            $(this).closest("dl").find("dd input:checkbox").prop("checked", $(this).prop("checked"));
        });
        $(".permission-list2 dd input:checkbox").click(function () {
            var l = $(this).parent().parent().find("input:checked").length;
            var l2 = $(this).parents(".permission-list").find(".permission-list2 dd").find("input:checked").length;
            if ($(this).prop("checked")) {
                $(this).closest("dl").find("dt input:checkbox").prop("checked", true);
                $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked", true);
            }
            else {
                if (l == 0) {
                    $(this).closest("dl").find("dt input:checkbox").prop("checked", false);
                }
                if (l2 == 0) {
                    $(this).parents(".permission-list").find("dt").first().find("input:checkbox").prop("checked", false);
                }
            }
        });
        

        $("#form-admin-add").validate({
            rules: {
                title: {
                    required: true,
                    minlength: 1,
                    maxlength: 10
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                $(form).ajaxSubmit({
                    url: "<%=basePathAdmin%>/authorities.do?method=doupdate",
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
<!--/请在上方写此页面业务相关的脚本-->
</body>

</html>
