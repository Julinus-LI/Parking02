<%@page import="pers.arrayli.domain.CheWei"%>
<%@page import="pers.arrayli.service.impl.CheWeiServiceImpl"%>
<%@page import="pers.arrayli.service.CheWeiService"%>
<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*,java.sql.*"
	pageEncoding="UTF-8"%>
	
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<link rel="stylesheet" type="text/css" href="css/common.css" />
<link rel="stylesheet" type="text/css" href="css/main.css" />
<script type="text/javascript" src="js/libs/modernizr.min.js"></script>
</head>
<body>
	<jsp:include page="/top.jsp"></jsp:include>
	<jsp:include page="/left.jsp"></jsp:include>
	<!--/sidebar-->
	<div class="main-wrap">

		<div class="crumb-wrap">
			<div class="crumb-list">
				<span class="crumb-name">车位管理</span>
			</div>
		</div>
		<div class="search-wrap">
			<div class="search-content">
				<%-- <form action="<%=path%>/chewei/list.jsp" method="post"> --%>
				<form action="<%=path%>/PageListServlet02?currentPage=1&type=CheWeiManagement" method="post">
					<table class="search-tab">
						<tr>

							<th width="150">请输入车位号:</th>
							<td><input class="common-text" placeholder="关键字"
								name="queryName" value="" id="" type="text"></td>
							<td><input class="btn btn-primary btn2" name="sub"
								value="查询" type="submit"></td>
						</tr>
					</table>
				</form>
			</div>
		</div>
		<div class="result-wrap">
			<form name="myform" id="myform" method="post">
				<div class="result-title">
					<div class="result-list">
						<a href="<%=path%>/chewei/addChewei.jsp"><i class="icon-font"></i>新增车位</a>

					</div>
				</div>
				<div class="result-content">
					<table class="result-tab" width="100%">
						<tr>


							<th>ID</th>
							<th>车位号</th>

							<th>区域</th>

							<th>备注</th>

							<th>操作</th>
						</tr>

						<c:forEach items="${pagebean.list}" var="chewei">
							<tr align="center">
								<td>${chewei.id}</td>
								<td>${chewei.hao}</td>
								<td>${chewei.quyu}</td>
								<td>${chewei.info}</td>
								<td>
									<a class="link-update" href="<%=path%>/chewei/modChewei.jsp?id=${chewei.id}">修改</a>
									<a class="link-del" href="<%=path%>/DelCheweiServlet?id=${chewei.id}">删除</a>
								</td>
								<%-- <td><a href="UpdateServlet?sid=${stu.sid }">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td> --%>
							</tr>
						</c:forEach>
						<%-- <%
							// 获取查询条件
							String queryName = request.getParameter("queryName");
							CheWeiService service = new CheWeiServiceImpl();
							List<CheWei> list = service.QueryCheWei(queryName, null);
							if (list != null) {
								for (CheWei chewei : list) {
						%> --%>

						<%-- <tr>


							<td><%=chewei.getId()%></td>
							<td title=""><%=chewei.getHao()%></td>

							<td title=""><%=chewei.getQuyu()%></td>

							<td title=""><%=chewei.getInfo()%></td>

							<td><a class="link-update"
								href="<%=path%>/chewei/modChewei.jsp?id=<%=chewei.getId()%>">修改</a>
								<a class="link-del"
								href="<%=path%>/DelCheweiServlet?id=<%=chewei.getId()%>">删除</a>
							</td>
						</tr>

						<%
							}
							}
						%> --%>
					</table>
					<div class="list-page">

						<%-- &nbsp; 共 ${pagebean.totalSize }个记录,分 ${pagebean.pageSize }页显示,当前页是: 第${pagebean.currentPage } 页
 --%>

						&nbsp; 共 ${pagebean.totalSize } 个记录,每页显示 ${pagebean.pageSize } 条记录
						,分 ${pagebean.totalPage } 页显示,当前页是: 第 ${pagebean.currentPage } 页


						<c:if test="${pagebean.totalPage == 1} ">
							<a href="PageListServlet02?currentPage=1&type=CheWeiManagement">首页</a>
						</c:if>

					<%-- 	<c:if test="${pagebean.totalPage > 1} "> --%>
						<c:if test="${pagebean.totalPage > 1}"> 
							<c:if test="${pagebean.currentPage != 1} ">
								<a href="<%=path%>/PageListServlet02?currentPage=1&type=CheWeiManagement">首页</a>
 								|   <a
									href="<%=path%>/PageListServlet02?currentPage=${pagebean.currentPage-1}&type=CheWeiManagement">上一页</a>
							</c:if>
 							&nbsp;&nbsp;
 							

 							<c:forEach begin="1" end="${pagebean.totalPage}" var="i">

								<c:if test="${pagebean.currentPage == i}">
									${i }
								</c:if>
								<c:if test="${pagebean.currentPage != i}">
									<a
										href="<%=path%>/PageListServlet02?currentPage=${i}&type=CheWeiManagement">${i }</a>
								</c:if>
							</c:forEach>	
							&nbsp;&nbsp;
							
						
 							
 							<c:if test="${pagebean.currentPage == pagebean.totalPage }">
								<a
									href="<%=path%>/PageListServlet02?currentPage=${pagebean.currentPage-1}&type=CheWeiManagement">上一页</a>
							     	|  <a
									href="<%=path%>/PageListServlet02?currentPage=1&type=CheWeiManagement">首页</a>
							</c:if>

							<c:if test="${pagebean.currentPage != pagebean.totalPage }">
								<a
									href="<%=path%>/PageListServlet02?currentPage=${pagebean.currentPage+1}&type=CheWeiManagement">下一页</a>
							     	|  <a
									href="<%=path%>/PageListServlet02?currentPage=${pagebean.totalPage}&type=CheWeiManagement">尾页</a>
							</c:if>
						</c:if>

					</div>
				</div>
			</form>
		</div>
	</div>
	<!--/main-->
	</div>
</body>
</html>
