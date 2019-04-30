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
									CheFeiPrice price = service.QueryFare();
									if (price != null) {
										request.getSession().setAttribute("pid", price.getId());
								%>

								<tr>



									<th><i class="require-red">*</i>车费：</th>
									<td><input class="common-text required" id="price"
										value='<%=price.getPrice()%>' name="price" size="5"
										type="text">元/小时</td>
								</tr>


								<%
									}
								%>
								<tr>
									<th></th>
									<td><input class="btn btn-primary btn6 mr10"
										onclick="save();" value="修改" type="button"> <input
										class="btn btn6" onclick="history.go(-1)" value="返回"
										type="button"></td>
								</tr>
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

function save() {
	if ($("#name").val() == "") {
		$.messager.alert('警告', '姓名不能为空！', 'warning');
		return;
	}
	if ($("#pwd").val() == "") {
		$.messager.alert('警告', '密码不能为空！', 'warning');
		return;
	}
		document.forms[0].action = "<%=path%>/ModCheFeiPriceServlet";
		document.forms[0].submit();

	}
</script>
