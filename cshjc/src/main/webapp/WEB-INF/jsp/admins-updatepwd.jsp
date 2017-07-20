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
        <input type="text" id="id" name="id" hidden="hidden" value="${adminId}">
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" autocomplete="off" value="" placeholder="密码" id="password" name="password">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>确认密码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="password" class="input-text" autocomplete="off" placeholder="确认新密码" id="password2" name="password2">
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
                password: {
                    required: true,
                },
                password2: {
                    required: true,
                    equalTo: "#password"
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                $(form).ajaxSubmit({
                    url: "<%=basePathAdmin%>/admins.do?method=doupdatepwd",
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
</body>

</html>
