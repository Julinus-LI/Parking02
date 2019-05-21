<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>

	
<!DOCTYPE HTML>
<html>
  <head>
    <title>文件上传</title>
  		<base href="<%=basePath%>">	
  </head>
  
  <body>
  	<jsp:include page="/top.jsp"></jsp:include>
		<div class="container clearfix">
			<jsp:include page="/left.jsp"></jsp:include>
			<!--/sidebar-->
			<div class="main-wrap">

				<div class="result-wrap" >
					<div class="result-content" style="margin-top:100px;">
						<form action="UploadHandleServlet" enctype="multipart/form-data" method="post" id="myform" name="myform">
							
							<div style="margin-left:150px;">
								<div >
									<input class="common-text required" id="info" name="info"
												size="50" value="导入文件" type="file">
								</div>
								
								<div style="margin-top:30px;">
									<input class="btn btn-primary btn6 mr10" onclick="save();"
												value="提交" type="button">
											<input class="btn btn6" onclick="history.go(-1)" value="返回"
												type="button">
								</div>
							
							</div>
							
							<!-- <table class="insert-tab" width="100%" align="center">
								<tbody>
				
									<tr>
										<td>
											<input class="common-text required" id="info" name="info"
												size="50" value="导入文件" type="file">
										</td>
									</tr>


									<tr>
										<td>
											<input class="btn btn-primary btn6 mr10" onclick="save();"
												value="提交" type="button">
											<input class="btn btn6" onclick="history.go(-1)" value="返回"
												type="button">
										</td>
									</tr>
								</tbody>
							</table> -->
						</form>
					</div>
				</div>

			</div>
			<!--/main-->
		</div>
  
  <%--   <form action="<%=path%>ImportExcelServlet" enctype="multipart/form-data" method="post">
   <!--      上传用户：<input type="text" name="username"><br/> -->
         导入文件：<input type="file" name="file1"><br/>
       <!--  上传文件2：<input type="file" name="file2"><br/> -->
        <input type="submit" value="提交">
    </form> --%>
  </body>
</html>
<script>

function save() {
	if ($("#hao").val() == "") {
		$.messager.alert('警告', '车位号不能为空！', 'warning');
		return;
	}
	if ($("#pwd").val() == "") {
		$.messager.alert('警告', '密码不能为空！', 'warning');
		return;
	}
	document.forms[0].action = "<%=path%>/ImportExcelServlet";
	document.forms[0].submit();

}
</script>
