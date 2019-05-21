<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script type="text/javascript">
	function showTime() {
		nowtime = new Date();
		year = nowtime.getFullYear();
		month = nowtime.getMonth() + 1;
		date = nowtime.getDate();
		document.getElementById("mytime").innerHTML = "&nbsp;&nbsp;"
				+ year
				+ "年"
				+ month
				+ "月"
				+ date
				+ "日"
				+ "&nbsp;&nbsp;&nbsp;"
				+ nowtime.toLocaleTimeString()+"&nbsp;&nbsp;&nbsp;&nbsp;";
	}

	setInterval("showTime()", 1000);
</script>



<div class="topbar-wrap white">
	<div class="topbar-inner clearfix">
		<div class="topbar-logo-wrap clearfix">
			<a class="on" href="#">停车场管理系统</a>
		</div>
		<div class="top-info-wrap">
			<ul class="top-info-list clearfix">
			<li>
				<span id="mytime" style="font-size:16px;"></span>
			</li>
			<li style="font-size:16px;">
				<c:if test="${type == '用户'}">
					欢迎用户 ${username}
				</c:if> <c:if test="${type == '管理员'}">
					欢迎管理员 ${username}
				</c:if></li>

			<li><a style="font-size:16px;" href="<%=path%>/loginout.jsp">退出
			</a></li>
			</ul>
		</div>
	</div>
</div>