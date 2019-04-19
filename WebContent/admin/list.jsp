<%@page import="pers.arrayli.domain.AdminUser"%>
<%@page import="pers.arrayli.service.impl.AdminUserServiceImpl"%>
<%@page import="pers.arrayli.service.AdminUserService"%>
<%@include file="/common/sub_header.jsp"%>
<%@ page language="java"
	import="java.util.*,java.sql.*"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>s
	<head>
		<base href="<%=basePath%>">

		<link rel="stylesheet" type="text/css" href="css/common.css" />
		<link rel="stylesheet" type="text/css" href="css/main.css" />
		<script type="text/javascript" src="js/libs/modernizr.min.js">
</script>
	</head>
	<body>
		<jsp:include page="/top.jsp"></jsp:include>
		<jsp:include page="/left.jsp"></jsp:include>
			<!--/sidebar-->
			<div class="main-wrap">

				<div class="crumb-wrap">
					<div class="crumb-list">
						<span class="crumb-name">管理员管理</span>
					</div>
				</div>
				<div class="search-wrap">
					<div class="search-content">
						<form action="<%=path %>/admin/list.jsp" method="post">
							<table class="search-tab">
								<tr>
									
									<th width="150">
										请输入管理员名称:
									</th>
									<td>
										<input class="common-text" placeholder="关键字" name="queryName"
											value="" id="" type="text">
									</td>
									<td>
										<input class="btn btn-primary btn2" name="sub" value="查询"
											type="submit">
									</td>
								</tr>
							</table>
						</form>
					</div>
				</div>
				<div class="result-wrap">
					<form name="myform" id="myform" method="post">
						<div class="result-title">
							<div class="result-list">
								<a href="<%=path %>/admin/addAdmin.jsp"><i class="icon-font"></i>新增管理员</a>
								
							</div>
						</div>
						<div class="result-content">
							<table class="result-tab" width="100%">
								<tr>
									
									
									<th>
										ID
									</th>
									<th>
										登录名
									</th>
									<th>
										密码
									</th>
								 
									<th>
										操作
									</th>
								</tr>
					
					<%
						//获取按条件查询的关键
						String queryName = request.getParameter("queryName");
						// 获取管理员信息列表
						AdminUserService service = new AdminUserServiceImpl();
						List<AdminUser>list = service.queryAdmins(queryName);
						if(list != null){
							for(AdminUser admin:list){	

					%>
					
								<tr>
									
									
									<td>
										<%=admin.getId()%>
									</td>
									<td title="">
										<%=admin.getUserName()%>
									</td>
									<td>
										<%=admin.getUserPassword()%>
									</td>
									 
									<td>
										<a class="link-update" href="<%=path %>/admin/modAdmin.jsp?id=<%=admin.getId() %>">修改</a>
										<a class="link-del" href="<%=path %>/DelAdminServlet?id=<%=admin.getId() %>">删除</a>
									</td>
								</tr>
								
					
					<%
							}
						}
					%>
							</table>
							<div class="list-page">
								 
							</div>
						</div>
					</form>
				</div>
			</div>
			<!--/main-->
		</div>
	</body>
</html>
