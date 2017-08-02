<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>

<head>
    <%@include file="_head.jsp" %>
</head>

<body>
<nav class="breadcrumb"><i class="Hui-iconfont">&#xe67f;</i> 首页 <span class="c-gray en">&gt;</span> 设备管理 <span
        class="c-gray en">&gt;</span> 设备列表 <a class="btn btn-success radius r"
                                              style="line-height:1.6em;margin-top:3px"
                                              href="javascript:location.replace(location.href);" title="刷新"><i
        class="Hui-iconfont">&#xe68f;</i></a></nav>
<form id="formfordata" class="page-container" enctype="multipart/form-data">
	<div class="text-c">
        采集点: <select name="" id="spotName" class="input-text" style="width: 10em;display: inline-block">
        <option value="" selected="">采集点1</option>
        <option value="首页">采集点2</option>
    </select>
        使用状态: <select name="used" id="used" class="input-text" style="width: 10em;display: inline-block">
        <option value="100" selected="">全部</option>
		<option value="1">使用</option>
		<option value="0">下线</option>
    </select>
        <button type="button" style="margin-top:-6px" class="btn btn-success radius" id="subbutton" name=""><i class="Hui-iconfont"></i>
            搜索
        </button>
    </div>
    <div class="cl bg-1 bk-gray mt-20">
        <span class="l">
            <a href="javascript:;" onclick="datadel()"
               class="btn btn-danger radius">
                <i class="Hui-iconfont">&#xe6e2;</i> 批量删除
            </a>
            <a class="btn btn-primary radius" data-title="添加"
               onclick="slide_add('添加设备','<%=basePathAdmin%>/devices.do?method=create',0,0)" href="javascript:;">
                <i class="Hui-iconfont">&#xe600;</i> 添加设备
            </a>
        </span>
    </div>
    <div class="mt-20">
        <table class="table table-border table-bordered table-bg table-hover table-sort">
        </table>
    </div>
</form>
<%@include file="_foot.jsp" %>
<script type="text/javascript" src="http://cdn.bootcss.com/datatables/1.10.13/js/jquery.dataTables.min.js"></script>
<script type="text/javascript">
	
    var table = $('.table-sort').dataTable({
        "iDisplayLength":100,
        "oLanguage" : {
            "sLengthMenu": "每页显示 _MENU_ 条记录",
            "sInfo": "从 _START_ 到 _END_ ,共 _TOTAL_ 条数据",
            "sInfoEmpty": "没有数据",
            "sInfoFiltered": "(从 _MAX_ 条数据中检索)",
            "sZeroRecords": "没有检索到数据",
            "sLoadingRecords": "正在载入...",
            "sProcessing": "正在载入...",
            "sSearch": "搜索:",
            "oPaginate": {
                "sFirst": "首页",
                "sPrevious": "前一页",
                "sNext": "后一页",
                "sLast": "尾页"
            }

        },
        "bDeferRender": true,
        "bAutoWidth": true, //自动宽度
        "aaSorting": [
            [1, "desc"]
        ], //默认第几个排序
        "aoColumnDefs": [
            {
                "orderable": false,
                "aTargets": [0, 5,9]
            } // 不参与排序的列
        ],
        "processing": true,
        "serverSide": true,
        "sAjaxSource": "<%=basePathAdmin%>/devices.do?method=querylist",//这个是请求的地址
        "fnServerData": function (sSource, aoData, fnCallback) {
            var base = parseInt(aoData[1]["value"]) * 5;
            $("#formfordata").ajaxSubmit({
                url: sSource,//这个就是请求地址对应sAjaxSource
                data: {
                    "draw": aoData[0]["value"],
                    "colsNum": aoData[1]["value"],
                    "colums": aoData[2]["value"],
                    "start": aoData[3]["value"],
                    "length": aoData[4]["value"],
                    "searchWord": aoData[base + 5]["value"],
                    "sortingCol": aoData[base + 7]["value"],
                    "order": aoData[base + 8]["value"],
                    "searchCol": aoData[base + 9]["value"],
					"bannerType": $('#bannerType option:selected').val(),
                    "bannerState": $('#bannerState option:selected').val(),
                },//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
                type: 'get',
                dataType: "json",
                async: true,
                success: function (result) {
                    fnCallback(result);//把返回的数据传给这个方法就可以了,datatable会自动绑定数据的
                    var outerHeight = $("#DataTables_Table_0_next").outerHeight();
					var height = outerHeight-1;
					var innerHeight = $("#DataTables_Table_0_next").innerHeight();
					var top = outerHeight-innerHeight;
					var jumpinput = document.createElement("input");
					jumpinput.type="text";
					jumpinput.name="jumpinput";
					jumpinput.id="jumpinput";
					//添加属性
					$(jumpinput).css("margin-left","6px");
					$(jumpinput).css("border","1px solid #cacaca");
					$(jumpinput).css("position","relative");
					$(jumpinput).css("top","-"+top+"px");
					$(jumpinput).css("width","50px");
					$(jumpinput).css("height",height+"px");
					$(jumpinput).css("line-height",height+"px");
					//添加事件
					$(jumpinput).keypress(function(event){
						var keycode = (event.keyCode ? event.keyCode : event.which);
						if(keycode == '13'){
							//获取页码
							var pageIndex = $(jumpinput).val();
							pageIndex = parseInt(pageIndex)-1;
							if(!isNaN(pageIndex)){
								//跳转 
								$('#DataTables_Table_0').dataTable().fnPageChange(pageIndex);
							}else{
								layer.msg("请输入整数!",{
								icon: 5,
								time: 1000
								});
							}
						}
					});
					$("#DataTables_Table_0_next").after(jumpinput);
                },
                error: function (msg) {
                }
            });
        }, // 获取数据的处理函数
        "rowId": 'id',
        "columns": [
            {
                "data": "checkBoxforDel",
                "name": "checkBoxforDel",
                "title": "<input type='checkbox' name='' id='checkall' />",
                render: function (data, type, row, meta) {
                return '<input type="checkbox" name="checkBoxforDel" class="checkBoxforDel" value="' + row.id + '" />';
            }
            },
            {
                "data": "deviceId",
                "name": "deviceId",
                "title": "设备编号"
            },
            {
                "data": "deviceName",
                "name": "deviceName",
                "title": "设备名称"
            },
            {
                "data": "spotId",
                "name": "spotId",
                "title": "数据采集点"
            },
            {
                "data": "gps",
                "name": "gps",
                "title": "GPS"
            },
            {
                "data": "authorCode",
                "name": "authorCode",
                "title": "授权码"
            },
            {
                "data": "installTime",
                "name": "installTime",
                "title": "安装时间"
            },
            {
                "data": "updateTime",
                "name": "updateTime",
                "title": "修改日期",
                render: function (data, type, row, meta) {
                    if(row.updateTime==null){
                        return "未修改";
                    }else{
                        return row.updateTime;
                    }
                }
            },
            {
                "data": "used",
                "name": "used",
                "title": "状态",
                "class":"td-status ispush",
                render:function (data, type, row, meta) {
                    if (row.used==1) {
                        return '<span class="label label-success radius">使用</span>';
                    }
                    else if(row.used==0){
                        return '<span class="label label-default radius">下线</span>';
                    } else {
                        return "";
                    }
                }
            },
            {
                "data": "options",
                "name": "options",
                "title": "操作",
                "class": "f-14 td-manage",
                render: function (data, type, row, meta) {
                    var str = "";
                    if(row.bannerState=="使用"){
                        str='<a style=text-decoration:none onClick=\'slide_updown(this,"' + row.id + '","' + row.bannerState + '")\' href="javascript:;" title="下线"><i class=Hui-iconfont>&#xe6de;</i></a>';
                    }else if(row.bannerState=="下线"){
                        str='<a style=text-decoration:none onClick=\'slide_updown(this,"' + row.id + '","' + row.bannerState + '")\' href="javascript:;" title="使用"><i class=Hui-iconfont>&#xe603;</i></a>';
                    }

                    var uril = "'<%=basePathAdmin%>/devices.do?method=update'";

                    return str+'<a title="编辑" href="javascript:;" onclick="team_edit(\'编辑：' + row.deviceName + '\','+uril+',' + row.id + ')" style=text-decoration:none><i class=Hui-iconfont>&#xe6df;</i></a><a title="删除" href="javascript:;" onclick="team_del(this,' + row.id + ')" class=ml-5 style=text-decoration:none><i class=Hui-iconfont>&#xe6e2;</i></a>';
                }
            }
        ]
    });

    /*幻灯-添加*/
    function slide_add(title, url, w, h) {
        var index = layer.open({
            type: 2,
            title: title, 
            content: url
        });
        layer.full(index);
    }
    /*幻灯-编辑*/
    function team_edit(title, url, id, w, h) {
        var index = layer.open({
            type: 2,
            title: title,
            content: url + "&id=" + id
        });
        layer.full(index);
    }
    /*幻灯-删除*/
    function team_del(obj, id) {
        layer.confirm('确认要删除吗？', function (index) {
            $("#formfordata").ajaxSubmit({
                url: "<%=basePathAdmin%>/devices.do?method=delete",//这个就是请求地址对应sAjaxSource
                data: {
                    "id": id
                },//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
                type: 'get',
                dataType: "json",
                async: true,
                success: function (data) {
                    if (data.state == 200) {
                        layer.msg(data.message, {
                            icon: 1,
                            time: 1000
                        }, function () {
                            $(obj).parents("tr").remove();
                            history.go(0);
                        });
                    } else {
                        layer.msg(data.message, {
                            icon: 5,
                            time: 1000
                        });
                    }
                }
            });
        });
    }

    //    批量删除
    function datadel() {
        var list = $(".checkBoxforDel:checked");
        if (list === null || list.length === 0) {
            layer.msg('未勾选要删除的项目', function () {
            });
            return;
        }
        layer.confirm('确认要删除这' + list.length + '条吗？', function () {
            $("#formfordata").ajaxSubmit({
                url: "<%=basePathAdmin%>/devices.do?method=deletelist",//这个就是请求地址对应sAjaxSource
                type: 'get',
                dataType: "json",
                async: true,
                success: function (data) {
                    if (data.state == 200) {
                        layer.msg(data.message, {
                            icon: 1,
                            time: 1000
                        }, function () {
                            for (var i = 0, length = list.length; i < length; i++) {
                                $(list[i]).parents("tr").remove();
                            }
                            history.go(0);
                        });
                    } else {
                        layer.msg(data.message, {
                            icon: 5,
                            time: 1000
                        });
                    }
                }
            });
        });
    }
    function slide_updown(obj, id, status) {
        var strq = (status=="使用")?"确认要下线吗？":"确认要使用吗？";
        var strStatus = (status=="使用")?"下线":"使用";
        layer.confirm(strq, function (index) {
            $("#formfordata").ajaxSubmit({
                url: "<%=basePathAdmin%>/devices.do?method=change",//这个就是请求地址对应sAjaxSource
                data: {
                    "id": id,
                    "bannerState": strStatus
                },//这个是把datatable的一些基本数据传给后台,比如起始位置,每页显示的行数
                type: 'get',
                dataType: "json",
                async: true,
                success: function (data) {
                    if (data.state == 200) {
                        var str = (status=="使用")?"下线成功":"使用成功";
                        var str2 = (status=="使用")?"使用":"下线";
                        var str3 = (status=="使用")?"下线":"使用";
                        var className = (status=="使用")?"default":"success";
                        var icons = (status=="使用")?"&#xe603;":"&#xe6de;";
                        var status2= (status=="使用")?"下线？":"使用？";
                        layer.msg(str, {
                            icon: 1,
                            time: 1000
                        }, function () {
                            $(obj).parents("tr").find(".td-manage").prepend('<a style="text-decoration:none" onClick="slide_updown(this,'+id+','+status2+')" href="javascript:;" title="'+str2+'"><i class="Hui-iconfont">'+icons+'</i></a>');
                            $(obj).parents("tr").find(".ispush").html('<span class="label label-'+className+' radius">'+str3+'</span>');
                            $(obj).remove();
                            history.go(0);
                        });
                    } else {
                        layer.msg(data.message, {
                            icon: 5,
                            time: 1000
                        });
                    }
                }
            });
        });
    }
	$("#subbutton").bind("click", function () {
        table.fnDraw();
    });
</script>
</body>
</html>

