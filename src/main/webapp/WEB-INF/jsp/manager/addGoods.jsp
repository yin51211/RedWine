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
                <div style="width: 103px;margin: 0 auto;"><span></span></div>
                <form method="post" id="addGoods" method="post" enctype="multipart/form-data"
                      action="<%=path%>/caas/manage/addGoods" onsubmit="return checkSubmit()">

                <div class="daily_release team_release">
                    <div class="row">
                        <table width="100%" border="0" cellspacing="0" cellpadding="0">
                            <tbody>
                            <tr>
                                <td height="60">商品名称：<input class="txt2" type="text"
                                                             name="pcName" id="pcName" value=""
                                                             style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">商品信息：<input class="txt2" type="text"
                                                              name="content" id="content" value=""
                                                              style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">上传图片：
                                    <input style="margin-left:2px;" id="uploadFile" name="uploadFile" type="file" multiple="true" ><font style="color: #b94a48">*</font>
                                    <a href="javascript:checkUpload();">上传文件</a>

                                    <input id="uploadFileRet" name="uploadFileRet" type="hidden" value="" >

                                    </td>
                            </tr>
                            <tr>
                                <td height="60">商品价格：<input class="txt2" type="text"
                                                             name="price" id="price" value=""
                                                             style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="60">优惠信息：<input class="txt2" type="text"
                                                              name="discount" id="discount" value=""
                                                              style="ime-mode: Disabled;"></td>
                            </tr>
                            <tr>
                                <td height="50">
                                    <button id="btn_login_portal" type="submit">确定</button>
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
        <%--$("#addGoods").ajaxForm({--%>
            <%--url:'<%=path%>/caas/manage/getUpLoadFile',--%>
            <%--success:function(data){--%>
                <%--$('#uploadFile').uploadify('cancel');--%>
                <%--$("#addApp").modal('hide');--%>
            <%--},--%>
            <%--error:function() {--%>

            <%--}--%>
        <%--});--%>
    });

    function checkUpload() {
        $('#uploadFile').uploadify('settings', 'formData', {'versionNo' : versionNo, 'type' : type});
        $('#uploadFile').uploadify('upload');
    }

    $(document).ready(function() {
        $("#uploadFile").uploadify({
            swf       : '<%=basePath%>resources/uploadify/uploadify.swf',
            uploader  : '<%=basePath%>caas/manage/getUpLoadFile',
            cancelImg : '<%=basePath%>resources/uploadify/uploadify-cancel.png',
            fileObjName : 'uploadFile',
            // formData    : {'versionNo' : 'versionNo', 'type' : 'type'},
            auto      : true,
            multi     : false,
            method    : 'post',
            fileTypeExts: '*.jpg;*.png;',
            buttonText: '选择图片',
            removeCompleted : false,
            fileSizeLimit : '500MB',
            removeCompleted : true,
            removeTimeout: 1,
            onUploadStart : function(file) {
                <%--if (file.name.substring(file.name.lastIndexOf(".") + 1, file.name.length) != $('#type').val()) {--%>
                    <%--$("#uploadFile").uploadify('cancel');--%>
                    <%--changeDisplayAlert("alertAddError1", "errorAddTip1", '<spring:message code="appVersion.upload.type.error"></spring:message>');--%>
                <%--}--%>
            },
            onUploadSuccess : function(file, data, response) {
                $('#' + file.id).find('.data').html('上传成功');
                layer.msg('上传成功！');
                $('#uploadFileRet').val(data);
            }
        });
    });

    function checkSubmit() {
        var pcName = $('#pcName').val();
        var content = $('#content').val();
        var file = $('#file').val();
        var price = $('#price').val();
        var discount = $('#discount').val();
        var uploadFileRet=$('#uploadFileRet').val();
    }
    function logout() {
        window.location.href = "<%=path%>/init/logout";
    }
</script>
</html>
