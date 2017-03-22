<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<div class="left pull-left bd-menu">
	<div class="account2">
		<img width="80" src="<%=path%>/resources/css/images/webmaster.png">
		<p>管理员</p>
	</div>
	<ul class="work_nav">
		<li class="nav_icon work_icon">后台管理</li>
	</ul>
	<ul class="work_subnav">
		<li id="menu-rp"><a
			href="<%=path%>/caas/manage/toCallIndex"
			id="work_subnav1" class="daily_icon"
			style="text-decoration: none;">用户中心</a></li>
		<li id="menu-rp"><a
			href="<%=path%>/caas/manage/toSmsIndex"
			id="work_subnav1" class="daily_icon"
			style="text-decoration: none;">产品信息</a></li>
	</ul>
	<script type="text/javascript">
		function makeMenuActive(index){
			$(".work_subnav li").removeClass("activeMenuCss");
			var li = $(".work_subnav li").eq(index);
		    $(li).addClass("activeMenuCss");
		}
	</script>
</div>
