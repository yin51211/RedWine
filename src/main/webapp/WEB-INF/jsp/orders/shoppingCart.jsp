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
    <link rel=stylesheet type=text/css
          href="<%=path%>/resources/css/index.css">
    <link href="<%=path%>/resources/css/select2.min.css" rel="stylesheet"/>
    <script src="<%=path%>/resources/js/Calculation.js"></script>
    <script src="<%=path%>/resources/js/jquery-1.11.1.min.js"></script>
    <script src="<%=path%>/resources/js/bootstrap.min.js"></script>
    <script type=text/javascript charset=utf8
            src="<%=path%>/resources/js/jquery.dataTables.min.js"></script>
    <script type="text/javascript"
            src="<%=path%>/resources/third/My97DatePicker/WdatePicker.js"></script>
    <script src="<%=path%>/resources/third/layer/layer.min.js"></script>
    <script src="<%=path%>/resources/js/ajaxfileupload.js"></script>
    <script src="<%=path%>/resources/js/select2.min.js"></script>

    <script type="text/javascript" src="<%=path%>/resources/uploadify/jquery.uploadify.js"></script>
    <link href="<%=path%>/resources/uploadify/uploadify.css" rel="stylesheet"/>
    <style type="text/css">
        /* #table_id tbody>tr>td {
            max-width: 70px;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        } */


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
        <jsp:include page="../manager/left.jsp"/>
        <!--left menu  -->
        <div class=" pull-right">
            <div id="bd-timeline-wrapper" class="right">
                <div class="gwc" style=" margin:auto;">
                    <table cellpadding="0" cellspacing="0" class="gwc_tb1">
                        <tr>
                            <td class="tb1_td1"><input id="Checkbox1" type="checkbox"  class="allselect"/></td>
                            <td class="tb1_td1">全选</td>
                            <td class="tb1_td3">商品</td>
                            <td class="tb1_td4">商品信息</td>
                            <td class="tb1_td5">数量</td>
                            <td class="tb1_td6">单价</td>
                            <td class="tb1_td7">操作</td>
                        </tr>
                    </table>
                    <table cellpadding="0" cellspacing="0" class="gwc_tb2">
                        <tr>
                            <td class="tb2_td1"><input type="checkbox" value="1" name="newslist" id="newslist-1" /></td>
                            <td class="tb2_td2"><a href="#"><img src="images/img1.jpg"/></a></td>
                            <td class="tb1_td4"><a href="#">产品标题</a></td>
                            <td class="tb1_td5">
                                <input id="min1" name=""  style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="-" />
                                <input id="text_box1" name="" type="text" value="1" style=" width:30px; text-align:center; border:1px solid #ccc;" />
                                <input id="add1" name="" style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="+" />
                            </td>
                            <td class="tb1_td6"><label id="total1" class="tot" style="color:#ff5500;font-size:14px; font-weight:bold;">60</label></td>
                            <td class="tb1_td7"><a href="#">删除</a></td>
                        </tr>
                    </table>
                    <table cellpadding="0" cellspacing="0" class="gwc_tb2">
                        <tr>
                            <td class="tb2_td1"><input type="checkbox" value="1" name="newslist" id="newslist-2" /></td>
                            <td class="tb2_td2"><a href="#"><img src="images/img2.jpg"/></a></td>
                            <td class="tb2_td3"><a href="#">产品标题</a></td>
                            <td class="tb1_td4">一件</td>
                            <td class="tb1_td5">
                                <input id="min2" name=""  style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="-" />
                                <input id="text_box2" name="" type="text" value="1" style=" width:30px; text-align:center; border:1px solid #ccc;" />
                                <input id="add2" name="" style=" width:20px; height:18px;border:1px solid #ccc;" type="button" value="+" />
                            </td>
                            <td class="tb1_td6"><label id="total2" class="tot" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></td>
                            <td class="tb1_td7"><a href="#">删除</a></td>
                        </tr>
                    </table>
                    <table cellpadding="0" cellspacing="0" class="gwc_tb3">
                        <tr>
                            <td class="tb1_td1"><input id="checkAll" class="allselect" type="checkbox" /></td>
                            <td class="tb1_td1">全选</td>
                            <td class="tb3_td1">
                                <input id="invert" type="checkbox" />反选
                                <input id="cancel" type="checkbox" />取消
                            </td>
                            <td class="tb3_td2">已选商品 <label id="shuliang" style="color:#ff5500;font-size:14px; font-weight:bold;">0</label> 件</td>
                            <td class="tb3_td3">合计(不含运费):<span>￥</span><span style=" color:#ff5500;"><label id="zong1" style="color:#ff5500;font-size:14px; font-weight:bold;"></label></span></td>
                            <td class="tb3_td4"><span id="jz1">结算</span><a href="#" style=" display:none;"  class="jz2" id="jz2">结算</a></td>
                        </tr>
                    </table>
                </div>
            </div>

        </div>
    </div>
</div>


</body>
<script type="text/javascript">
    $(document).ready(function () {

        //jquery特效制作复选框全选反选取消(无插件)
        // 全选
        $(".allselect").click(function () {
            $(".gwc_tb2 input[name=newslist]").each(function () {
                $(this).attr("checked", true);
                // $(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
            });
            GetCount();
        });

        //反选
        $("#invert").click(function () {
            $(".gwc_tb2 input[name=newslist]").each(function () {
                if ($(this).attr("checked")) {
                    $(this).attr("checked", false);
                    //$(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
                } else {
                    $(this).attr("checked", true);
                    //$(this).next().css({ "background-color": "#3366cc", "color": "#000000" });
                }
            });
            GetCount();
        });

        //取消
        $("#cancel").click(function () {
            $(".gwc_tb2 input[name=newslist]").each(function () {
                $(this).attr("checked", false);
                // $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
            });
            GetCount();
        });

        // 所有复选(:checkbox)框点击事件
        $(".gwc_tb2 input[name=newslist]").click(function () {
            if ($(this).attr("checked")) {
                //$(this).next().css({ "background-color": "#3366cc", "color": "#ffffff" });
            } else {
                // $(this).next().css({ "background-color": "#ffffff", "color": "#000000" });
            }
        });

        // 输出
        $(".gwc_tb2 input[name=newslist]").click(function () {
            // $("#total2").html() = GetCount($(this));
            GetCount();
            //alert(conts);
        });
    });
    //******************
    function GetCount() {
        var conts = 0;
        var aa = 0;
        $(".gwc_tb2 input[name=newslist]").each(function () {
            if ($(this).attr("checked")) {
                for (var i = 0; i < $(this).length; i++) {
                    conts += parseInt($(this).val());
                    aa += 1;
                }
            }
        });
        $("#shuliang").text(aa);
        $("#zong1").html((conts).toFixed(2));
        $("#jz1").css("display", "none");
        $("#jz2").css("display", "block");
    }
    function logout() {
        window.location.href = "<%=path%>/init/logout";
    }
</script>
</html>
