<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    <form class="form form-horizontal" id="form-slide-add" method="post"><!-- enctype="multipart/form-data" -->
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>设备编号：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" name="deviceId">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>设备名称：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" name="deviceName">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red">*</span>数据采集点：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" name="spotId">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red"></span>安装时间：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',maxDate:'2100-%M-%d'})" id="dll"
                       class="input-text Wdate" style="width:180px;" name="installTime" placeholder="请选择安装时间">
            </div>
        </div>
        <div class="row cl">
            <label class="form-label col-xs-4 col-sm-2"><span class="c-red"></span>授权码：</label>
            <div class="formControls col-xs-8 col-sm-9">
                <input type="text" class="input-text" value="" placeholder="" name="authorCode">
            </div>
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
<!-- 配置文件 -->
<script type="text/javascript" src="<%=basePath%>/assets/plugins/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript" src="http://apps.bdimg.com/libs/ueditor/1.4.3.1/ueditor.all.js"></script>
<script type="text/javascript">
    $(function () {
        $('.skin-minimal input').iCheck({
            checkboxClass: 'icheckbox_flat-blue',
            radioClass: 'iradio_flat-blue',
            increaseArea: '20%'
        });

        $("#form-slide-add").validate({
            rules: {
                deviceId: {
                    required: true,
                    minlength: 1,
                    maxlength: 50
                },
                deviceName: {
                    required: true,
                    minlength: 1,
                    maxlength: 50
                },
				spotId:{
					required:true
				}
            },
            onkeyup: false,
            focusCleanup: true,
            success: "valid",
            submitHandler: function (form) {
                $(form).ajaxSubmit({
                	
                    url: "<%=basePathAdmin%>/devices.do?method=insert",
                    type: 'post',
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
