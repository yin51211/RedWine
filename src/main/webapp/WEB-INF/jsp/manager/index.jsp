<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml">
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head>
    <title>Caas管理端</title>
    <link rel="stylesheet" href="<%=path%>/resources/css/bootstrap.min.css">
    <link href="<%=path%>/resources/css/font-awesome.min.css"
          rel="stylesheet" media="screen">
    <link href="<%=path%>/resources/css/font-awesome-ie7.min.css"
          rel="stylesheet" type="text/css">
    <link rel="stylesheet"
          href="<%=path%>/resources/css/timepicker/bootstrap-responsive.css">
    <link rel="stylesheet" href="<%=path%>/resources/css/common.css">
    <link rel=stylesheet type=text/css
          href="<%=path%>/resources/css/jquery.dataTables.min.css">
    <link href="<%=path%>/resources/css/select2.min.css" rel="stylesheet"/>
    <script src="<%=path%>/resources/js/jquery-1.11.1.min.js"></script>
    <script src="<%=path%>/resources/js/bootstrap.min.js"></script>
    <script type=text/javascript charset=utf8
            src="<%=path%>/resources/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"
            src="<%=path%>/resources/third/My97DatePicker/WdatePicker.js"></script>
    <script src="<%=path%>/resources/third/layer/layer.min.js"></script>
    <script src="<%=path%>/resources/js/select2.min.js"></script>
    <style type="text/css">
        /* #table_id tbody>tr>td {
            max-width: 70px;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        } */

        .right {
            padding: 15px;
        }

        .btn_warning {
            background-color: #f0ad4e;
            border-color: #eea236;
            color: #fff;
            font-weight: bold;
            margin-top: 10px;
            padding: 7px 25px;
        }

        #openContent {
            padding: 15px;
            background-color: #fff;
            color: #555;
            width: 666px;
            height: 555px;
            display: none;
        }

        .select2-results__option {
            max-width: 94%;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }

        .select2-selection__rendered {
            max-width: 94%;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }
    </style>
</head>
<body>
<div id="header" class="header">
    <div class="container">
        <div class="logo pull-left">
        </div>
        <div class="dropdown pull-right account">
            <a aria-expanded="false" aria-haspopup="true" data-toggle="dropdown"
               class="dropdown-toggle" data-target="#" id="dLabel" href="#">管理员
                <span class="caret"></span>
            </a>
            <ul aria-labelledby="dLabel" role="menu"
                class="dropdown-menu dropdown-menu-right">
                <li role="presentation"><a id="logout" data-target="#userInfo"
                                           data-toggle="modal" href="#user" tabindex="-1" role="menuitem"
                                           onclick="logout()">退出</a></li>
            </ul>
        </div>
    </div>
</div>

<div class="main">
    <div class="container">
        <!--left menu-->
        <jsp:include page="left.jsp"/>
        <!--left menu  -->
        <div class=" pull-right">
            <div id="bd-timeline-wrapper" class="right">
                <div class="daily_release team_release">
                    <div class="row">
                        <table id="table_id" class="display" border="1px">
                            <tr id="template">
                                <td id="userId"style="width: 90px">用户名</td>
                                <td id="userName" style="width: 90px">姓 名</td>
                                <td id="mobile" style="width: 90px">手机号</td>
                                <td id="email" style="width: 200px">电子邮件</td>
                                <td id="idCard" style="width: 200px">身份证号</td>
                                <td id="ref" style="width: 90px">推荐人</td>
                                <td  id="level" style="width: 90px">等 级</td>
                            </tr>
                        </table>
                    </div>
                    <div class="row">
                    </div>
                    <div class="row">
                    </div>
                </div>
            </div>

        </div>
    </div>
</div>


<div id="openContent">
    <div class="col-xs-12">
        日报内容：
        <div id="open_Content"></div>
    </div>
</div>

</body>
<script type="text/javascript">
    var oTable = null;
    $(document).ready(function () {
        makeMenuActive(0);
        cDayFunc();
    });

    function openMealPage(ims, imskey) {
        var i = $.layer({
            type: 2,
            title: false,
            border: false,
            area: ['860px', '555px'],
            iframe: {
                src: '<%=path%>/caas/manage/toMealPage?type=1&ims=' + ims + '&imskey=' + imskey
            }
        });
    }
    //“检索”按钮的处理函数
    function search() {
        oTable.draw();
    }
    function reset() {
        $("#company").select2('val', '');
        cDayFunc();
    }

    function cDayFunc() {
        var loadi = layer.load('正在加载用户信息…');
        $.ajax({
            type: 'POST',
            url: "<%=path%>/caas/manage/getUserInfo",
            data: {},
            success: function (data) {
                if (0 == data.result) {
                    layer.close(loadi);
                } else {
                    layer.msg(data.msg);
                }

                var companys = data.data.resObj;
                var row = $("#template").clone();
                row.find("#userId").text("");
                row.find("#userName").text(companys.name);
                row.find("#mobile").text(companys.mobile);
                row.find("#email").text(companys.email);
                row.find("#idCard").text(companys.idCard);
                row.find("#ref").text(companys.reference);
                row.find("#level").text(companys.level);
                row.attr("id","ready");//改变绑定好数据的行的id
                row.appendTo("#table_id");//添加到模板的容器中
//                layer.msg(companys);
            },
            error: function (data) {
                layer.msg('查询失败！');
            },
            dataType: 'json'
        });
    }


    function logout() {
        window.location.href = "<%=path%>/init/logout";
    }
</script>
</html>
