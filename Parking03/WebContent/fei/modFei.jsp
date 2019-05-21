<%@page import="pers.arrayli.domain.CheFeiPrice"%>
<%@page import="pers.arrayli.service.impl.CheFeiPriceServiceImpl"%>
<%@page import="pers.arrayli.service.CheFeiPriceService"%>
<%@include file="/common/sub_header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.util.*,java.sql.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

</head>

<body>
	<jsp:include page="/top.jsp"></jsp:include>
	<div class="container clearfix">
		<jsp:include page="/left.jsp"></jsp:include>
		<!--/sidebar-->
		<div class="main-wrap">

			<div class="crumb-wrap">
				<div class="crumb-list">
					<i class="icon-font"></i><span>停车费标准</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-content">
					<form method="post" id="myform" name="myform">
						<table class="insert-tab" width="100%">
							<tbody>
								<%
									// 获取车费价格
									CheFeiPriceService service = new CheFeiPriceServiceImpl();
									List<CheFeiPrice> priceList = service.findFare();
									if (priceList != null) {
										for(CheFeiPrice cheFeiPrice:priceList){
										//request.getSession().setAttribute("pid", price.getId());
								%>

								<tr>

								<%-- 	<th><i class="require-red">*</i><%=cheFeiPrice.getInfo() %>：</th> --%>
									<td width="40%"><i class="require-red">*</i><%=cheFeiPrice.getInfo() %>：</td>
									<td>
											<input class="common-text required" id="price<%= cheFeiPrice.getId()  %>" value='<%=cheFeiPrice.getPrice()%>' name="price" size="5" type="text"> 元/次
											&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
											
											<%-- <a hfre="<%=path%>/ModCheFeiPriceServlet?id=<%=cheFeiPrice.getId()%>">修改</a> --%>
											
											<input class="btn btn-primary btn6 mr10" onclick="save(<%= cheFeiPrice.getId() %>);" value="修改" type="button"> 
											<input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
									</td>					
									
								</tr>


								<%
										}
									}
								%>
								<!-- <tr>
									<th></th>
									<td>
										<input class="btn btn-primary btn6 mr10" onclick="save();" value="修改" type="button"> 
										<input class="btn btn6" onclick="history.go(-1)" value="返回" type="button">
									</td>
								</tr> -->
							</tbody>
						</table>
					</form>
				</div>
			</div>

		</div>
		<!--/main-->
	</div>
</body>
</html>
<script>

function save(priceId) {
	if ($("#name").val() == "") {
		$.messager.alert('警告', '姓名不能为空！', 'warning');
		return;
	}
	if ($("#pwd").val() == "") {
		$.messager.alert('警告', '密码不能为空！', 'warning');
		return;
	}
<%-- 		document.forms[0].action = "<%=path%>/ModCheFeiPriceServlet";
		document.forms[0].submit();
 --%>
 	$.post("<%=path%>/ModCheFeiPriceServlet", {
 		id:priceId,
 		val:$("#price"+priceId).val()
 	},function(data,status){
 		/* alert(data); */
 		if(data == "0"){
 			window.location = "<%=path%>/fei/modFei.jsp";
 		}else{
 			alert("修改失败!");
 		}
 	},"text")
 
	}
</script>
