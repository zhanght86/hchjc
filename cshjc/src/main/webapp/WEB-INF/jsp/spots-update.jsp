<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%--
  Created by IntelliJ IDEA.
  User: Guide
  Date: 2016/12/12
  Time: 20:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <%@include file="_head.jsp" %>
</head>
<body>
<div class="page-container">
    <form class="form form-horizontal" id="form-slide-add" method="post" enctype="text/plain"><!-- enctype="multipart/form-data" -->
        <input id="spotId" type="text" value="${spot.spotId}" placeholder="" name="spotId" hidden>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>采集点名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${spot.spotName}" placeholder="" name="spotName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>GPS：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="${spot.gps}" placeholder="" name="gps">
            </div>
        </div>
        <br>
        <div class="row cl">
            <div class="col-xs-8 col-sm-9 col-xs-offset-4 col-sm-offset-2">
                <button class="btn btn-primary radius" type="submit"><i class="Hui-iconfont">&#xe632;</i> 提交</button>
                <button onClick="layer_close()" class="btn btn-default radius" type="button">
                    &nbsp;&nbsp;取消&nbsp;&nbsp;
                </button>
            </div>
        </div>
    </form>
    <form action="" id="formfordata"></form>
</div>
</div>
<%@include file="_foot.jsp" %>
<script type="text/javascript" src="<%=basePath%>/assets/plugins/My97DatePicker/WdatePicker.js"></script>

<script type="text/javascript">
    $(function () {
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue',
            increaseArea: '20%'
        });


        $("#form-slide-add").validate({
            rules: {
            	spotName: {
                    required: true,
                    minlength: 1,
                    maxlength: 50
                },
                gps: {
                    required: true,
                    minlength: 1,
                    maxlength: 50
                }
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                
                $(form).ajaxSubmit({
                	type: 'post',
                    url: "<%=basePathAdmin%>/spots.do?method=doupdate",
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
