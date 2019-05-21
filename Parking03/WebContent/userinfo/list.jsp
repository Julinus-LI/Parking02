<%@page import="pers.arrayli.domain.UserInfo"%>
<%@page import="pers.arrayli.service.impl.UserInfoServiceImpl"%>
<%@page import="pers.arrayli.service.UserInfoService"%>
<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="UTF-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
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
					<span class="crumb-name">用户管理</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="search-content">
					<form action="<%=path%>/userinfo/list.jsp" method="post">
						<table class="search-tab">
							<tr>

								<th width="150">
									请输入用户名称:
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
							<a href="<%=path%>/userinfo/addUserinfo.jsp"><i
								class="icon-font"></i>新增用户</a>

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
									年龄
								</th>

								<th>
									电话
								</th>
								
								<th>
									卡余额
								</th>

								<th>
									操作
								</th>
							</tr>

							<%
								// 获取查询条件
								String queryName = request.getParameter("queryName");
								
								// 在业务层查询用户信息
								UserInfoService service = new UserInfoServiceImpl();
							 	List<UserInfo> list = service.queryAllUserInfos(queryName);
								if(list != null){
									for(UserInfo user:list){
									
							%>
							
							
							<tr>


								<td>
									<%=user.getId()%>
								</td>
								<td title="">
									<%=user.getUsername()%>
								</td>

								<td title="">
									<%=user.getPwd()%>
								</td>

								<td title="">
									<%=user.getAge()%>
								</td>

								<td title="">
									<%=user.getTel()%>
								</td>
								
								<td title="">
									<%=user.getMoney()%>
								</td>

								<td>
									<a class="link-update"
										href="<%=path%>/userinfo/modUserinfo.jsp?id=<%=user.getId()%>">修改</a>
									<a class="link-update"
										href="<%=path%>/userinfo/chong.jsp?id=<%=user.getId()%>">充值</a>	
									<a class="link-del"
										href="<%=path%>/DelUserInfoServlet?id=<%=user.getId()%>">删除</a>
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
