<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>
<head lang="en">
    <title>用户注册</title>
    <meta http-equiv="Cache-control" content="no-cache">
    <meta http-equiv="Content-Type" content="text/html;charset=utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1"/>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
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
<div class="main_portal">
    <div class="w970">
        <div class="login_form1" style="margin-top: 75px;margin-bottom: 50px;">
            <div id="message" class="alert alert-danger" role="alert"
                 style="display: none;"></div>
            <form method="post" id="taskPortal" method="post"
                  action="<%=path%>/init/initUser" onsubmit="return checkSubmit()">
                <ul class="nav nav-tabs" id="myTab">
                    <li class="active" id="userLogin"><a>管理员注册</a></li>
                </ul>
                <div class="tab-content">
                    <div class="tab-pane active" id="home">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <td height="60">用 户 名：<input class="txt2" type="text"
                                                       name="mobile" id="mobile" value=""
                                                       style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">密    码：<input class="txt2" type="password"
                                                           name="password" id="password" value=""
                                                           style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">重复密码：<input class="txt2" type="password"
                                                            name="repeatPassword" id="repeatPassword" value=""
                                                            style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">身 份 证：<input class="txt2" type="text"
                                                           name="idcard" id="idcard" value=""
                                                           style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">姓    名：<input class="txt2" type="text"
                                                           name="name" id="name" value=""
                                                           style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">电子邮箱：<input class="txt2" type="text"
                                                              name="email" id="email" value=""
                                                              style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">推 荐 人：<input class="txt2" type="text"
                                                           name="reference" id="reference" value=""
                                                           style="ime-mode: Disabled;"></td>
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
        </div>
    </div>
</div>
</body>
<script type="text/javascript">
    function checkSubmit() {
        var mobile = $('#mobile').val();
        var password = $('#password').val();
        var repeatPassword = $('#repeatPassword').val();
        var idcard = $('#idcard').val();
        var name = $('#name').val();
        var email = $('#email').val();
        var reference = $('#reference').val();
        if ('' == mobile) {
            $("#message").html("用户名不能为空！");
            $("#message").show();
            return false;
        }else if(!checkPhone(mobile)){
            $("#message").html("手机号输入有误！");
            $("#message").show();
            return false;
        }
        if ('' == password) {
            $("#message").html("密码不能为空！");
            $("#message").show();
            return false;
        }
        if(''==repeatPassword){
            $("#message").html("重复密码不能为空！");
            $("#message").show();
            return false;
        }
        if(repeatPassword!=password){
            $("#message").html("两次密码输入不一致！");
            $("#message").show();
            return false;
        }
        if(''==idcard){
            $("#message").html("身份证号不能为空！");
            $("#message").show();
            return false;
        }
//        if(IdentityCodeValid(idcard)){
//            $("#message").html("身份证输入有误！");
//            $("#message").show();
//            return false;
//        }
        if(''==name){
            $("#message").html("姓名不能为空！");
            $("#message").show();
            return false;
        }

        if(''==email){
            $("#message").html("电子邮箱不能为空！");
            $("#message").show();
            return false;
        }
        if(''==reference){
            $("#message").html("推荐人不能为空！");
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
    function checkPhone(mobile) {
        var reg=/^0?1[3|4|5|7|8][0-9]\d{8}$/;
        return reg.test(mobile);
    }
    function IdentityCodeValid(code) {
        var city={11:"北京",12:"天津",13:"河北",14:"山西",15:"内蒙古",21:"辽宁",22:"吉林",23:"黑龙江 ",31:"上海",32:"江苏",33:"浙江",34:"安徽",35:"福建",36:"江西",37:"山东",41:"河南",42:"湖北 ",43:"湖南",44:"广东",45:"广西",46:"海南",50:"重庆",51:"四川",52:"贵州",53:"云南",54:"西藏 ",61:"陕西",62:"甘肃",63:"青海",64:"宁夏",65:"新疆",71:"台湾",81:"香港",82:"澳门",91:"国外 "};
        var tip = "";
        var pass= true;

        if(!code || !/^\d{6}(18|19|20)?\d{2}(0[1-9]|1[12])(0[1-9]|[12]\d|3[01])\d{3}(\d|X)$/i.test(code)){
            tip = "身份证号格式错误";
            pass = false;
        }

        else if(!city[code.substr(0,2)]){
            tip = "地址编码错误";
            pass = false;
        }
        else{
            //18位身份证需要验证最后一位校验位
            if(code.length == 18){
                code = code.split('');
                //∑(ai×Wi)(mod 11)
                //加权因子
                var factor = [ 7, 9, 10, 5, 8, 4, 2, 1, 6, 3, 7, 9, 10, 5, 8, 4, 2 ];
                //校验位
                var parity = [ 1, 0, 'X', 9, 8, 7, 6, 5, 4, 3, 2 ];
                var sum = 0;
                var ai = 0;
                var wi = 0;
                for (var i = 0; i < 17; i++)
                {
                    ai = code[i];
                    wi = factor[i];
                    sum += ai * wi;
                }
                var last = parity[sum % 11];
                if(parity[sum % 11] != code[17]){
                    tip = "校验位错误";
                    pass =false;
                }
            }
        }
        if(!pass) alert(tip);
        return pass;
    }
    function emailCheck(name) {

        var pattern = /^([\.a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+(\.[a-zA-Z0-9_-])+/;
        if (!pattern.test(name)) {
            alert("请输入正确的邮箱地址。");
            return false;
        }
        return true;
    }
</script>
</html>
