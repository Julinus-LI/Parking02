<%@page import="pers.arrayli.domain.CheFei"%>
<%@page import="pers.arrayli.service.impl.CheFeiServiceImpl"%>
<%@page import="pers.arrayli.service.CheFeiService"%>
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
<script type="text/javascript">
	function method1(tableid) {

		varcurTbl = document.getElementById(tableid);

		varcurTbl.print();

	}
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
				<form action="<%=path%>/PageListServlet02?currentPage=1" method="post">
					<table class="search-tab">
						<tr>

							<th width="100">请输入车牌号:</th>
							<td><input class="common-text" placeholder="关键字"
								name="chepai" value="" id="" type="text"></td>
							<th width="120">请输入停车日期:</th>
							<td><input class="common-text" placeholder="关键字" name="date"
								value="" id="" type="text" class="Wdate"
								onfocus="WdatePicker({dateFmt:'yyyy-MM-dd',readOnly:true})">
							</td>
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
					<div class="result-list"></div>
				</div>
				<div class="result-content">
					<table class="result-tab" width="100%" id="tableExcel">
						<tr>


							<th>ID</th>
							<th>车牌号</th>

							<th>停车时间</th>

							<th>离开时间</th>

							<th>金额</th>

							<th>时长</th>

							<th>停车标准</th>
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


					<%
						System.out.println("------------cfei/list.jsp--------------");
						// 获取查询的关键字
						// 按车牌号查询
						String chepai = request.getParameter("chepai");
						// 按日期查询
						String date = request.getParameter("date");
						System.out.println("chepai: " + chepai + "\tdate: " + date);

						CheFeiService service = new CheFeiServiceImpl();
						List<CheFei> list = service.QueryCheFei(chepai, date);
						System.out.println("------------cfei/list.jsp--------------");
						// 总计停车费用
						int totalCost = 0;
						if (list != null) {
							for (CheFei chefei : list) {
								totalCost = totalCost + chefei.getCost();
							}
						}
					%>

					<%-- <tr>
								<td>
									<%=chefei.getId()%>
								</td>
								<td title="">
									<%=chefei.getHao()%>
								</td>

								<td title="">
									<%=chefei.getJdate()%>
								</td>

								<td title="">
									<%=chefei.getLdate()%>
								</td>

								<td title="">
									<%=chefei.getCost()%>
								</td>

								<td title="">
									<%=chefei.getHours()%>
								</td>

								<td title="">
									<%=chefei.getPrice()%>
								</td>

							</tr> --%>

					<%-- <%
									}
								}
							%> --%>


					<div class="list-page">

						<%-- &nbsp; 共 ${pagebean.totalSize }个记录,分 ${pagebean.pageSize }页显示,当前页是: 第${pagebean.currentPage } 页 --%>

						&nbsp; 共 ${pagebean.totalSize } 个记录,每页显示 ${pagebean.pageSize } 条记录
						,分 ${pagebean.totalPage } 页显示,当前页是: 第 ${pagebean.currentPage } 页


						<c:if test="${pagebean.totalPage == 1} ">
							<a href="PageListServlet02?currentPage=1&type=admin">首页</a>
						</c:if>

						<%-- <c:if test="${pagebean.totalPage > 1} "> --%>
						<c:if test="${pagebean.totalPage > 1}"> 
							<c:if test="${pagebean.currentPage != 1} ">
								<a href="<%=path%>/PageListServlet02?currentPage=1&type=admin">首页</a>
 								|   <a href="<%=path%>/PageListServlet02?currentPage=${pagebean.currentPage-1}&type=admin">上一页</a>
							</c:if>
 							&nbsp;&nbsp;
 							

 							<c:forEach begin="1" end="${pagebean.totalPage}" var="i">

								<c:if test="${pagebean.currentPage == i}">
									${i }
								</c:if>
								<c:if test="${pagebean.currentPage != i}">
									<a href="<%=path%>/PageListServlet02?currentPage=${i}&type=admin">${i }</a>
								</c:if>
							</c:forEach>	
							&nbsp;&nbsp;
							
						
 							
 							<c:if test="${pagebean.currentPage == pagebean.totalPage }">
								<a
									href="<%=path%>/PageListServlet02?currentPage=${pagebean.currentPage-1}&type=admin">上一页</a>
							     	|  <a
									href="<%=path%>/PageListServlet02?currentPage=1&type=admin">首页</a>
							</c:if>

							<c:if test="${pagebean.currentPage != pagebean.totalPage }">
								<a
									href="<%=path%>/PageListServlet02?currentPage=${pagebean.currentPage+1}&type=admin">下一页</a>
							     	|  <a
									href="<%=path%>/PageListServlet02?currentPage=${pagebean.totalPage}&type=admin">尾页</a>
							</c:if>
							<br>
							<br>
							<c:if test="${pagebean.totalSize != 0 }">
 								共计 <%=totalCost%> 元     <a href="<%=path%>/upload/export.jsp">导出</a>
							</c:if>
						</c:if>
					</div>
					<%-- <div class="list-page">
								共计 <%=totalCost%> 元     <a href="<%=path%>/upload/export.jsp">导出</a>
						</div> --%>

				</div>
			</form>
		</div>
	</div>
	<!--/main-->
	</div>
</body>
</html>