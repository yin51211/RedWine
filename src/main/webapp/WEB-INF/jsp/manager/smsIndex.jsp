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
    <link href="<%=path%>/resources/css/style.css"
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
        #table_id tbody > tr > td {
            max-width: 70px;
            text-overflow: ellipsis;
            white-space: nowrap;
            overflow: hidden;
        }

        .right {
            padding-left: 5px;
            padding-right: 15px;
            padding-top: 15px;
            padding-bottom: 15px;
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

        .f-main {
            width: 800px;
            overflow: hidden;
        }

        .f-main .floor-line {
            float: left;
            border-top: 1px solid #E5E5E5;
            width: 800px;
        }

        .f-main .f-slide {
            float: left;
            height: 240px;
            orderInfo-bottom: 1px solid #E5E5E5;
            border-right: 1px solid #E5E5E5;
        }

        .floor-line .f-item {
            position: relative;
            float: left;
            width: 199px;
            height: 245px;
            border-right: 1px solid #F1F1F1;
            overflow: hidden;
        }

        .h300 {
            height: 240px !important;
        }

        .f-item .item-a {
            display: block;
            width: 200px;
        }

        .h300.f-item .item-a {
            height: 240px;
        }

        .f-item img {
            display: block;
            width: 200px;
        }

        .f-item2 {
            float: left;
            width: 180px;
            padding: 10px;
            position: relative;
            z-index: 1;
        }

        .nor_prud_b .f-item .floorTImg {
            margin-bottom: 5px;
            width: 170px;
            height: 170px;
            position: relative;
            padding-left: 5px;
        }

        .f-item .floorTle {
        }

        .nor_prud_b .f-item .floorTImg a {
            display: inline-block;
        }

        .floorTImg img {
            width: 170px;
            height: 170px;
        }

        .nor_prud_b .f-item .floorTle {
            height: 36px;
            line-height: 18px;
            overflow: hidden;
        }

        .nor_prud_b .f-item .sPri {
            margin-top: 5px;
            line-height: 20px;
            height: 20px;
            overflow: hidden;
            zoom: 1;
        }

        .nor_prud_b .f-item .sPri b {
            font-size: 16px;
            font-family: "微软雅黑";
            color: #ea5404;
            width: 80px;
            float: left;
        }

        .nor_prud_b .f-item .sPri s {
            overflow: hidden;
            zoom: 1;
            font-family: "微软雅黑";
        }

        .nor_prud_b .f-item.sPri a{
            background: #F22D00;
            border-color: #F22D00;
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
    <input id="cart" name="cart"
            type="button" value="购物车(0)" onclick="jumpCart()"
            class="btn btn-info btn_warning nostyle" style="float: right;margin-right:20px; ">

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
                        <div class="col-xs-6 col-sm-4">
                            价格： <select id="company" name="company" class="form-control"
                                        style="width: 100%">
                        </select>
                        </div>
                        <div class="col-xs-6 col-sm-4">
                            名称： <input id="ims" name="ims" class="form-control"
                                       style="width: 100%"/>
                        </div>
                    </div>
                    <div class="row">
                        <%----%>
                        <%--<div class="col-xs-6 col-sm-4">--%>
                        <%--key： <input id="key" name="key" class="form-control"--%>
                        <%--style="width: 100%" />--%>
                        <%--</div>--%>
                    </div>
                    <div class="row">
                        <div class="col-xs-6 col-sm-4">
                            <input type=button value="查询" onclick="search()"
                                   class="btn btn-info btn_blue nostyle"> <input
                                type="button" value="重置" onclick="reset()"
                                class="btn btn-info btn_warning nostyle">
                            <input
                                    type="button" value="新增" onclick="add()"
                                    class="btn btn-info btn_warning nostyle">
                        </div>
                    </div>
                </div>
                <div class="f-main">

                    <div class="floor-line">
                        <ul id="goods_id" class="nor_prud_b">

                        </ul>
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
        makeMenuActive(1);
        $('#company').select2({
            placeholder: "请选择价格"
        });
        cDayFunc();


    });

    function openMealPage(ims, imskey) {
        var i = $.layer({
            type: 2,
            title: false,
            border: false,
            area: ['860px', '555px'],
            iframe: {
                src: '<%=path%>/caas/manage/toMealPage?type=2&ims=' + ims + '&imskey=' + imskey
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
        var loadi = layer.load('正在加载企业数据…');
        $.ajax({
            type: 'POST',
            url: "<%=path%>/caas/manage/getAllGoods",
            data: {},
            success: function (data) {
                if (0 == data.result) {
                    layer.close(loadi);
                } else {
                    layer.msg(data.msg);
                }


                var companys = data.data.resObjs;
                $(companys).each(function (index) {
                    var val = companys[index];
                    $("#goods_id").append("<li class='f-item'>  <div class='f-item2'>" +
                            "<div class='floorTImg'><a href=''><img src='<%=path%>/resources/app/"+val[5]+"'>"
                            + "</a></div> <p class='floorTle'> <a href='javascript:;' title='商品名'>" + val[1] + "</a></p>" +
                            "<div class='sPri'><b>￥" + val[3] + "</b><a href='javascript:addShoppingCart("+val[0]+")' >加入购物车 " +
                            "</a></div>" +
                            "</div> </li>");
                });
            },
            error: function (data) {
                layer.msg('查询失败！');
            },
            dataType: 'json'
        });

    }

    function addShoppingCart(productID){
        $.ajax({
            type: 'POST',
            url: "<%=path%>/caas/manage/addShoppingCart",
            data: {productID:productID},
            success: function (data) {
                if (0 == data.result) {
                    layer.close(loadi);
                } else {
                    layer.msg(data.msg);
                }
                var companys = data;
                $("#cart").val("购物车("+data+")")
                layer.msg('数量'+data);

            },
            error: function (data) {
                layer.msg('查询失败！');
            },
            dataType: 'text'
        });
    }

    function add() {
        window.location.href = "<%=path%>/caas/manage/toGoods";
    }

    function jumpCart(){
        window.location.href = "<%=path%>/caas/manage/toShoppingCart";
    }


    function logout() {
        window.location.href = "<%=path%>/login/logout";
    }
</script>
</html>
