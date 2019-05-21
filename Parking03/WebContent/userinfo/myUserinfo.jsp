<%@page import="pers.arrayli.domain.UserInfo"%>
<%@page import="pers.arrayli.service.impl.UserInfoServiceImpl"%>
<%@page import="pers.arrayli.service.UserInfoService"%>
<%@include file="/common/sub_header.jsp"%>	
<%@ page contentType="text/html;charset=UTF-8" import="java.util.*,java.sql.*,pers.arrayli.db.*" pageEncoding="UTF-8"%>	
	
	
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
						<i class="icon-font"></i><span>修改用户</span>	
					</div>	
				</div>	
				<div class="result-wrap">	
					<div class="result-content">	
						<form method="post" id="myform"	
							name="myform" >	
							<table class="insert-tab" width="100%">	
								<tbody>	
						 <%	
					
							String uid = request.getSession().getAttribute("uid").toString();
							int id = Integer.parseInt(uid);
							UserInfoService service = new UserInfoServiceImpl();
							UserInfo user = service.QueryById(id);
						%>	
			 <input name="id" type="hidden" id="name" value='<%=id%>'>	
			 <input name="type" type="hidden" id="type" value='type'>	
									<tr>
	<th>
		<i class="require-red"></i>登录名：
	</th>
	<td>
		<input class="common-text required"  value="<%=user.getUsername()%>" id="name" name="username"
			size="50" value="" type="text">
	</td>
</tr>

<tr>
	<th>
		<i class="require-red"></i>密码：
	</th>
	<td>
		<input class="common-text required"  value="<%=user.getPwd()%>" id="pwd" name="password"
			size="50" value="" type="text">
	</td>
</tr>

<tr>
	<th>
		<i class="require-red"></i>年龄：
	</th>
	<td>
		<input class="common-text required"  value="<%=user.getAge()%>" id="age" name="age"
			size="50" value="" type="text">
	</td>
</tr>

<tr>
	<th>
		<i class="require-red"></i>电话：
	</th>
	<td>
		<input class="common-text required"  value="<%=user.getTel()%>" id="tel" name="tel"
			size="50" value="" type="text">
	</td>
</tr>
										
	<%-- 								 <%	
				if (rs != null)	
					rs.close();	
				if (stat != null)	
					stat.close();	
				if (conn != null)	
					conn.close();	
			%>		 --%>
									<tr>	
										<th></th>	
										<td>	
											<input class="btn btn-primary btn6 mr10" onclick="save();" value="提交"	
												type="button">	
											<input class="btn btn6" onclick="history.go(-1)" value="返回"	
												type="button">	
										</td>	
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
