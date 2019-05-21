<%@page import="pers.arrayli.service.impl.UserInfoServiceImpl"%>
<%@page import="pers.arrayli.service.UserInfoService"%>
<%@include file="/common/sub_header.jsp"%>
<%@ page contentType="text/html;charset=UTF-8"
	import="java.util.*,java.sql.*,pers.arrayli.db.*" pageEncoding="UTF-8"%>


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
					<i class="icon-font"></i><span>卡余额查看</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-content">
					<form method="post" id="myform" name="myform">
						<table class="insert-tab" width="100%">
							<tbody>

								<%
									// 获取到用户 id
									int uid = Integer.parseInt(request.getSession().getAttribute("uid").toString());
									UserInfoService service = new UserInfoServiceImpl();
									int money = service.QueryMoneyById(uid);
								%>
								<tr>
									<th><i class="require-red"></i>卡余额：</th>
									<td><input class="common-text required" value="<%=money%>"
										id="jine" name="jine" size="50" readonly="readonly"
										type="text"></td>
								</tr>


								<tr>
									<th></th>
									<td><input class="btn btn6" onclick="history.go(-1)"
										value="返回" type="button"></td>
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
		document.forms[0].action = "<%=path%>/ModUserInfoServlet";
		document.forms[0].submit();

	}
</script>
