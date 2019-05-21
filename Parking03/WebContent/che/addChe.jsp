<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">

<script language="javascript">
function up() {

	var pop = new Popup( {
		contentType : 1,
		isReloadOnClose : false,
		width : 400,
		height : 200
	});
	
	pop.setContent("contentUrl", "<%=path%>/upload/upload.jsp");
	pop.setContent("title", "文件上传");
	pop.build();
	pop.show();
}
</script>
</head>

	<body>
		<jsp:include page="/top.jsp"></jsp:include>
		<div class="container clearfix">
			<jsp:include page="/left.jsp"></jsp:include>
			<!--/sidebar-->
			<div class="main-wrap">

				<div class="crumb-wrap">
					<div class="crumb-list">
						<i class="icon-font"></i><span>新增车辆信息</span>
					</div>
				</div>
				<div class="result-wrap">
					<div class="result-content">
						<form method="post" id="myform" name="myform">
							<table class="insert-tab" width="100%">
								<tbody>

									<tr>
										<th>
											<i class="require-red"></i>车牌号：
										</th>
										<td>
											<input class="common-text required" id="hao" name="hao"
												size="50" type="text">
										</td>
									</tr>

									<tr>
										<th>
											<i class="require-red"></i>车辆品牌：
										</th>
										<td>
											<input class="common-text required" id="leixing"
												name="leixing" size="50" type="text">
										</td>
									</tr>

									<tr>
										<th>
											<i class="require-red"></i>照片：
										</th>
										<td>
											<input type="text" name=fujian id="fujian" size="30"
												readonly="readonly" />
											<input type="button" value="上传" onclick="up()" />
											<input type="hidden" name="fujian" id="fujian" />
										</td>
									</tr>

									<tr>
										<th>
											<i class="require-red"></i>备注：
										</th>
										<td>
											<input class="common-text required" id="info" name="info"
												size="50" type="text">
										</td>
									</tr>
									
				<!-- 					<tr>
										<th>
											<i class="require-red"></i>白天停车(6:00-18:00)：
										</th>
										<td>
											<select  id="qu" name="type" >
												 <option value="0">--请选择--</option>
												 <option value="A类">2小时（含2小时）每辆每次收费5元</option>
												 <option value="A类">2小时（含2小时）每辆每次收费5元</option>
												 <option value="B类">2小时以上至4小时以内（含4小时）每辆每次收费10元</option>
												 <option value="C类">4小时以上每辆每次收费15元</option>
											</select>	
										</td>
									</tr>
									<tr>
										<th>
											<i class="require-red"></i>夜晚停车(18:00-6:00)：
										</th>
										<td>
											<select  id="qu" name="type1" >
												 <option value="0">--请选择--</option>
												 <option value="D类">4小时以内（含4小时）每辆每次收费8元</option>
												 <option value="E类">4小时以上收费10元</option>
											</select>	
										</td>
									</tr>
									<tr>
										<th>
											<i class="require-red"></i>24小时停车：
										</th>
										<td>
											<select  id="qu" name="type2" >
											     <option value="0">--请选择--</option>
												 <option value="D类">4小时以内（含4小时）每辆每次收费8元</option>
												 <option value="E类">4小时以上收费10元</option>
											</select>	
										</td>
									</tr>
									<tr>
										<th>
											<i class="require-red"></i>长期固定车位停车：
										</th>
										<td>
											<select  id="qu" name="qu" >
												 <option value="0">--请选择--</option>
												 <option value="F类">长期固定停放的车辆，按每月收费，每月300元</option>
											</select>	
										</td>
									</tr> -->

									<tr>
										<th></th>
										<td>
											<input class="btn btn-primary btn6 mr10" onclick="save();"
												value="提交" type="button">
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
	if ($("#hao").val() == "") {
		$.messager.alert('警告', '车牌号不能为空！', 'warning');
		return;
	}
	if ($("#pwd").val() == "") {
		$.messager.alert('警告', '密码不能为空！', 'warning');
		return;
	}
	document.forms[0].action = "<%=path%>/AddCheServlet";
	document.forms[0].submit();

}
</script>
