<%@page import="java.text.SimpleDateFormat"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
   String path = request.getContextPath();
 %>

 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!-- <meta http-equiv="Content-Type" content="text/html; charset=utf-8" /> -->
<script type="text/javascript">
function showTime(){
    nowtime=new Date();
    year=nowtime.getFullYear();
    month=nowtime.getMonth()+1;
    date=nowtime.getDate();
    document.getElementById("mytime").innerText="系统时间"+year+"年"+month+"月"+date+"日"+" "+nowtime.toLocaleTimeString();
}

setInterval("showTime()",1000);
</script>



<div class="topbar-wrap white">
			<div class="topbar-inner clearfix">
				<div class="topbar-logo-wrap clearfix">
					<a class="on" href="#">停车场管理系统</a>
				</div>
				
				<!-- <div class="top-info-wrap">
					<div>
 -->				<!-- 	<ul class="top-info-list clearfix"> -->
 						<ul class="top-info-list clearfix">
						<div  style="position: fixed;left: 40%;">
							<%-- <li>
								<% 
									Date date = new Date();
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String time = sdf.format(date);
								%>
								<h6>当前时间：       <%=time %></h6>
						
							</li> --%>
							<!-- <span id="mytime" style="font-size:18px;font-weight:bold"></span> -->
							<!-- <span id="mytime" style=" width: 200px;height: 20px; border: 3px solid gray; "></span> -->
						</div>
						<div style="float:right" >
						<li>
							<c:if test="${type == '用户'}"> <h6>欢迎用户   ${username}  登陆</h6></c:if>
							<c:if test="${type == '管理员'}"> <h6>欢迎管理员   ${username}  登陆</h6></c:if>
						</li>
						
						<li>
							<a href="<%=path %>/loginout.jsp">退出</a>
						</li>
						
						</div>
					</ul>
				</div>
			</div>
		</div>