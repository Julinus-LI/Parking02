<%@page import="pers.arrayli.domain.PageBean"%>
<%@page import="pers.arrayli.domain.CheFei"%>
<%@page import="pers.arrayli.service.impl.CheFeiServiceImpl"%>
<%@page import="pers.arrayli.service.CheFeiService"%>
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
					<span class="crumb-name">缴费管理</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="search-content">
					<form action="<%=path%>/PageListServlet?currentPage=1" method="post">
						<table class="search-tab">
							<tr>	
								<th width="100">
									请输入车牌号:
								</th>
								<td>
									<input class="common-text" placeholder="关键字" name="chepai"
										value="" id="" type="text">
								</td>
								<th width="120">
									请输入停车日期:
								</th>
								<td>
									<input class="common-text" placeholder="关键字" name="jdate"
										value="" id="" type="text" class="Wdate"
										onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})">
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


						</div>
					</div>
					<div class="result-content">
						<table class="result-tab" width="100%">
							<tr>


								<th>
									ID
								</th>
								<th>
									车牌号
								</th>

								<th>
									停车时间
								</th>

								<th>
									离开时间
								</th>

								<th>
									金额
								</th>

								<th>
									时长
								</th>

								<th>
									停车标准
								</th>
							</tr>
						
							 
			<c:forEach items="${pagebean.list}" var="chefei">
				<tr align="center">
					<td>${chefei.id}</td>
					<td>${chefei.hao}</td>
					<td>${chefei.jdate}</td>
					<td>${chefei.ldate}</td>
					<td>${chefei.cost}</td>
					<td>${chefei.hours}</td>
					<td>${chefei.price}</td>
					<%-- <td><a href="UpdateServlet?sid=${stu.sid }">更新</a> <a href="#" onclick="doDelete(${stu.sid})">删除</a></td> --%>
				</tr>
			</c:forEach>
					
							
						</table>
						<div class="list-page">
							
							&nbsp; 共 ${pagebean.totalSize }个记录,分 ${pagebean.pageSize }页显示,当前页是: 第${pagebean.currentPage } 页

 							
 							<c:if test="${pagebean.currentPage != 1} ">	
 								<a href="<%=path%>/PageListServlet?currentPage=1">首页</a>
 								|   <a href="<%=path%>/PageListServlet?currentPage=${pagebean.currentPage-1}">上一页</a>
 							</c:if>
 							&nbsp;&nbsp;
 							

 							<c:forEach begin="1" end="${pagebean.totalPage}" var="i">
 								
								<c:if test="${pagebean.currentPage == i}">
									${i }
								</c:if>
								<c:if test="${pagebean.currentPage != i}">
									<a href="<%=path%>/PageListServlet?currentPage=${i}">${i }</a>
								</c:if>
							</c:forEach>	
							&nbsp;&nbsp;
							
						
 							
 							<c:if test="${pagebean.currentPage == pagebean.totalPage }">
								<a href="<%=path%>/PageListServlet?currentPage=${pagebean.currentPage-1}">上一页</a>
							     	|  <a href="<%=path%>/PageListServlet?currentPage=1">首页</a>
							</c:if>
							
 							<c:if test="${pagebean.currentPage != pagebean.totalPage }">
								<a href="<%=path%>/PageListServlet?currentPage=${pagebean.currentPage+1}">下一页</a>
							     	|  <a href="<%=path%>/PageListServlet?currentPage=${pagebean.totalPage}">尾页</a>
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
