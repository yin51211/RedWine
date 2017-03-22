<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
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
<link href="<%=path%>/resources/css/select2.min.css" rel="stylesheet" />
<script src="<%=path%>/resources/js/jquery-1.11.1.min.js"></script>
<script src="<%=path%>/resources/js/bootstrap.min.js"></script>
<script type=text/javascript charset=utf8
	src="<%=path%>/resources/js/jquery.dataTables.min.js"></script>
<script type="text/javascript"
	src="<%=path%>/resources/third/My97DatePicker/WdatePicker.js"></script>
<script src="<%=path%>/resources/third/layer/layer.min.js"></script>
<script src="<%=path%>/resources/js/select2.min.js"></script>
<style type="text/css">
#table_id tbody>tr>td {
	max-width: 70px;
	text-overflow: ellipsis;
	white-space: nowrap;
	overflow: hidden;
}

.right {
	padding: 15px;
	margin: 5px;
}

.dataTables_info {
	display: none;
}

.dataTables_paginate {
	display: none;
}
</style>
</head>
<body>

	<div class="main">
		<div id="bd-timeline-wrapper" class="right">
			<table id="table_id" class="display">
				<thead>
					<tr>
						<!-- <th>ID</th> -->
						<th>ims</th>
						<!-- <th>套餐ID</th> -->
						<th>套餐名称</th>
						<th>结算点数</th>
						<th>不结算</th>
						<th>有效期（天）</th>
						<th>购买时间</th>
					</tr>
				</thead>
			</table>
			<div class="daily_release team_release">
				<div class="row" id="addMealButton">
					<div class="col-xs-6 col-sm-4">
						<input type=button value="增加套餐" onclick="showMeal()"
							class="btn btn-info btn_blue nostyle">
					</div>
				</div>

				<div id="addMealDiv" style="display: none;">
					<div class="row">
						<div class="col-xs-6 col-sm-4">
							套餐类型：<select id="meal" name="meal" class="form-control"
								style="width: 100%">
							</select>
						</div>
					</div>
					<div class="row">
						<div class="col-xs-6 col-sm-4">
							<input type=button value="增加" onclick="addMeal()"
								class="btn btn-info btn_blue nostyle">
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
<script type="text/javascript">
var oTable = null;
var lineNo = 0;
   $(document).ready( function () {
	    oTable = $('#table_id').DataTable( {    
        "aoColumns": [
                      //{ "data": "id","sWidth": "0%" },          
          			  { "data": "ims" ,"sWidth": "10%","bSortable": false},
                     // { "data": "pointId","sWidth": "10%","bSortable": false },
                      { "data": "pointName","sWidth": "13%" ,"bSortable": false},
                      { "data": "payoffpoint","sWidth": "10%" ,"bSortable": false},
                      { "data": "nopayoffpoint","sWidth": "10%" ,"bSortable": false},
                      { "data": "effective","sWidth": "13%" ,"bSortable": false},
                      { "data": "buyDate","sWidth": "20%" ,"bSortable": false,"mRender": function ( data, type, full ) {
                    	  lineNo++;
                    	  return full.buyDate;
                      }}
                       ],
                  "bLengthChange": false,
                  "bFilter": false,
                  "bAutoWidth": false,
                  "bSortable": false,
                  "sPaginationType": "full_numbers",
                  "bProcessing": true,
                  "bServerSide": true,
                  "iDisplayLength":100,
                  "bJQueryUI": false, 
                  "sAjaxSource":  "<%=path%>/caas/manage/getMealByConditions",
											"fnServerParams" : function(aoData) {
												aoData.push({
													"name" : "ims",
													"value" : "${ims}"
												}, {
													"name" : "imskey",
													"value" : "${imskey}"
												}, {
													"name" : "type",
													"value" : "${type}"
												});
											}
										});

					});

	//“检索”按钮的处理函数   
	function search() {
		oTable.draw();
	}
	
	function addMeal(){
		if(lineNo>2){
			layer.alert('对不起！您不能再添加更多套餐了！', {
		        skin: 'layui-layer-lan',
		        shift: 4 //动画类型
		    });
			return false;
		}
		var loadi = layer.load('正在添加套餐…');
		$.ajax({
			  type: 'POST',
			  url: "<%=path%>/caas/manage/addMeal",
			data : {
				"pointsspid" : $('#meal').val(),
				"imskey" : "${imskey}",
				"ims" : "${ims}",
				"type" : "${type}"
				},
			success : function(data) {
				if (0 == data.result) {
					layer.close(loadi);
					search();
				} else {
					layer.msg(data.msg);
				}
			},
			error : function(data) {
				layer.msg('添加套餐失败！');
			},
			dataType : 'json'
		});
		
	}
	function showMeal(){
		if(lineNo>2){
			layer.alert('对不起！您不能再添加更多套餐了！', {
		        skin: 'layui-layer-lan',
		        shift: 4 //动画类型
		    });
			return false;
		}
		var loadi = layer.load('正在加载套餐数据…');
		$.ajax({
			  type: 'POST',
			  url: "<%=path%>/caas/manage/getAllMeal",
			data : {},
			success : function(data) {
				if (0 == data.result) {
					layer.close(loadi);
				} else {
					layer.msg(data.msg);
				}
				$("#meal").empty();
				var meals = data.data.resObjs;
				$(meals).each(
						function(index) {
							var val = meals[index];
							$("#meal").append(
									"<option value='"+val.pointsspid+"'>"
											+ val.name + "</option>");
						});
				$("#addMealDiv").show();
				$("#addMealButton").hide();
			},
			error : function(data) {
				layer.msg('查询失败！');
			},
			dataType : 'json'
		});

	}
</script>
</html>
