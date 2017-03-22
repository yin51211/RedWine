<%@ page language="java" import="java.util.*" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head lang="en">
    <title>云办公-工作管理登录</title>
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <!--<meta http-equiv="cache-control" content="private">-->
    <meta name="viewport" content="width=device-width, initial-scale=1.0">

    <link href="<%=path%>/resources/css/colpick.css" rel="stylesheet">
    <link href="<%=path%>/resources/css/datepicker/datepicker3.css"
          rel="stylesheet" type="text/css">
    <link
            href="<%=path%>/resources/css/timepicker/bootstrap-timepicker.min.css"
            rel="stylesheet" type="text/css">
    <link href="<%=path%>/resources/css/timepicker/bootstrap-responsive.css"
          rel="stylesheet" type="text/css">

    <!-- Bootstrap -->
    <link href="<%=path%>/resources/css/bootstrap.min.css" rel="stylesheet">
    <link href="<%=path%>/resources/css/login.css" rel="stylesheet"
          type="text/css">
    <script src="<%=path%>/resources/js/jquery-1.11.1.min.js"></script>
</head>
<body>
<div class="header_cloud">
    <div class="w970">
        <div id="logo_portal">

            <div id="logo_text_cloud">管理平台</div>
        </div>
    </div>
</div>
<div class="main_portal">
    <div class="w970">
        <div class="pic_portal carousel slide" id="myCarousel">
        </div>
        <div class="login_form" style="margin-top: 25px;">
            <div id="message" class="alert alert-danger" role="alert"
                 style="display: none;"></div>
            <form method="post" id="taskPortal" method="post"
                  action="<%=path%>/init/login" onsubmit="return checkSubmit()">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active" id="userLogin"><a>管理员登录</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="home">

                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <td height="50"><input class="txt1" type="text"
                                                       name="userId" id="userId" value=""
                                                       style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="50"><input class="txt1" type="password"
                                                       name="password" id="password" value=""
                                                       style="ime-mode: Disabled;">
                                </td>
                            </tr>
                            <tr>
                                <td height="50">
                                    <button id="btn_login_portal" type="submit">登录</button>
                                </td>
                            </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
            </form>
            <div class="col-xs-6 col-sm-4">
                <a href="<%=path%>/init/regist" class="btn btn-info btn_blue nostyle" >注册</a>
            </div>
        </div>
    </div>
</div>

<a href="http://www.miibeian.gov.cn/" target="_blank"> </a>
</body>

<script type="text/javascript">
    function checkSubmit() {
        var userId = $('#userId').val();
        var password = $('#password').val();
        var rememberme = $("#rememberme").prop("checked");
        if ('' == userId) {
            $("#message").html("用户名不能为空！");
            $("#message").show();
            return false;
        }
        if ('' == userId) {
            $("#message").html("密码不能为空！");
            $("#message").show();
            return false;
        }
        return true;
    }
    $(document).ready(function () {
        var message = '${message}';
        if (message && '' != message) {
            $("#message").html(message);
            $("#message").show();
        }
    });
    function registPage() {

    }
</script>
</html>