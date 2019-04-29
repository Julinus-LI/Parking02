<%@page import="pers.arrayli.service.impl.CheServiceImpl"%>
<%@page import="pers.arrayli.service.CheService"%>
<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*,java.sql.*,pers.arrayli.db.*"
	pageEncoding="UTF-8"%>

<%@page import="pers.arrayli.domain.Che"%>

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
					<span class="crumb-name">车辆信息</span>
				</div>
			</div>
			<div class="search-wrap">
				<div class="search-content">
					<form action="<%=path%>/che/list.jsp" method="post">
						<table class="search-tab">
							
						</table>
					</form>
				</div>
			</div>
			<div class="result-wrap">
				<form name="myform" id="myform" method="post">
					<div class="result-title">
						<div class="result-list" id="result-list">
							<a href="<%=path%>/che/addChe.jsp"><i class="icon-font"></i>添加车辆信息</a>

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
									车辆品牌
								</th>

								<th>
									照片
								</th>

								<th>
									备注
								</th>

								<th>
									操作
								</th>
							</tr>
		
							<%
								// 从session中获取用户id 
								int uid = Integer.parseInt(request.getSession().getAttribute("uid").toString());
								/* String queryName = request.getParameter("queryName");
								if(queryName != null){
							
								} */
								String picPath = "D:\\PakringResources";
								CheService service = new CheServiceImpl();
								Che che = service.findByUid(uid);
								if(che != null){
									System.out.println("==============显示车图片绝对路径==================");
									
									System.out.println("picPath: "+picPath);
									System.out.println("che.getPicture(): "+che.getPicture());
									System.out.println("src: "+ picPath+che.getPicture());
									System.out.println("==============显示车图片绝对路径==================");
							%>
							
							<tr>

								<%-- alert("<%=che.toString() %>"); --%>
								<td>
									<%=che.getId()%>
									<script type="text/javascript">
									   document.getElementById("result-list").style.display="none";
									</script>
								</td>
								<td title="">
									<%=che.getHao()%>
								</td>

								<td title="">
									<%=che.getLeixing()%>
								</td>

								<td title="">
									<%-- <img src="<%=path%>/<%=che.getPicture()%>" height="100px" width="200px"/> --%>
									<img src="<%=che.getPicture()%>" height="100px" width="200px"/>
								</td>

								<td title="">
									<%=che.getInfo()%>
								</td>

								<td>
									<a class="link-update"
										href="<%=path%>/che/modChe.jsp?id=<%=che.getId()%>">修改</a>
									<a class="link-del" href="<%=path%>/DelCheServlet?id=<%=che.getId()%>">删除</a>
								</td>
							</tr>
							<%
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
