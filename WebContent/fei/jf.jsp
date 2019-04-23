<%@page import="pers.arrayli.utils.CalculateTime"%>
<%@page import="java.util.Date"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="pers.arrayli.domain.CheWei"%>
<%@page import="pers.arrayli.service.impl.CheWeiServiceImpl"%>
<%@page import="pers.arrayli.service.CheWeiService"%>
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
					<i class="icon-font"></i><span>缴费</span>
				</div>
			</div>
			<div class="result-wrap">
				<div class="result-content">
					<form method="post" id="myform" name="myform">
						<table class="insert-tab" width="100%">
							<tbody>
								<%-- <%
										DBManager dbm = new DBManager();
										Connection conn = dbm.getConnection();
										

										String sql = "select * from chewei where id= "
												+ request.getParameter("id");
										PreparedStatement stat = conn.prepareStatement(sql);
										ResultSet rs = stat.executeQuery();
										rs.next();
										
										String bdate=rs.getString("adate");
										
										java.text.SimpleDateFormat format = new java.text.SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
										String ldate=format.format(new java.util.Date());
										long count=dbm.calcHour(bdate,ldate);
										String fei=(String)session.getAttribute("fei");
										
										long jine=count*Long.parseLong(fei);
										
										
										String yue=dbm.getYue(rs.getString("chepai"));
										
									    long yu=Long.parseLong(yue);
									    
									    boolean isNo=false;
									    if(jine>yu){
									       isNo=true;
									    }
										 
									%> --%>

								<%
									System.out.println("----------------------fei/jf.jsp Debug Start -----------------------");
									// 1.获取缴费的车辆id
									int id = Integer.parseInt(request.getParameter("id"));
									// 2.根据车位 Id 来获取车位信息
									CheWeiService service = new CheWeiServiceImpl();
									CheWei chewei = service.findCheWeiById(id);

									// 3.获取车辆入场信息
									String jdate = chewei.getAdate();
									System.out.println("入场时间 jdate: "+jdate);
									
									// 4.获取当前日期
									Date date = new Date();
									SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
									String ldate = sdf.format(date); // 离开时间
									System.out.println("离开时间 ldate: "+ldate);
									
									
									// 5.计算时间差
									int hours = CalculateTime.CalculateTime(jdate, ldate);
									System.out.println("停车时长 hours : "+hours);
									
									// 6.从session 中获取停车单价
									//int price = Integer.parseInt(request.getSession().getAttribute("fei").toString());
									int price = 3;
									System.out.println("车费标准 price : "+price);
									
									// 7.计算费用
									int cost = hours * price;
									System.out.println("停车费用  cost : "+cost);
									
									// 8.获取车牌号
									String chepai = chewei.getChepai();
									System.out.println("车牌号 chepai: "+chepai);
									
									// 9.根据车牌号来获取用户的余额
									int balance = service.GetUserMoney(chepai);
									System.out.println("余额 balance : "+balance);
									
									boolean isAlipy = false;
									//判断余额是否大于停车费用
									if (balance > cost) {
										isAlipy = true;
									}
									System.out.println("----------------------fei/jf.jsp Debug End -----------------------");
								%>


								<tr>
									<th><i class="require-red"></i>车牌：</th>
									<td><input class="common-text required" id="hao"
										value='<%=chewei.getChepai()%>' name="chepai" size="20"
										type="text" readonly="readonly"></td>
								</tr>

								<tr>
									<th><i class="require-red"></i>停车时间：</th>
									<td><input class="common-text required" id="jdate"
										value='<%=jdate%>' name="jdate" size="20" type="text"
										readonly="readonly"></td>
								</tr>
								<tr>
									<th><i class="require-red"></i>离开时间：</th>
									<td><input class="common-text required" id="ldate"
										value='<%=ldate%>' name="ldate" size="20" type="text"
										readonly="readonly"></td>
								</tr>
								<tr>
									<th><i class="require-red"></i>停车标准：</th>
									<td><input class="common-text required" id="biao"
										value='<%=price%>' name="biao" size="5" type="text"
										readonly="readonly"> 元/小时</td>
								</tr>
								<tr>
									<th><i class="require-red"></i>停车时长：</th>
									<td><input class="common-text required" id="shijian"
										value='<%=hours%>' name="shijian" size="5" type="text"
										readonly="readonly"> 小时</td>
								</tr>
								<tr>
									<th><i class="require-red"></i>费用：</th>
									<td><input class="common-text required" id="jine"
										value='<%=cost%>' name="cost" size="5" type="text"
										readonly="readonly"> (卡内余额:<%=balance%>)</td>
								</tr>

								<%-- 	<%
										if (rs != null)
											rs.close();
										if (stat != null)
											stat.close();
										if (conn != null)
											conn.close();
									%> --%>

								<tr>
									<th></th>
									<td><input class="btn btn-primary btn6 mr10"
										onclick="save();" value="提交" type="button"> <input
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
    var isNo="<%=isAlipy%>";
    if(isNo=='true'){
       $.messager.alert('警告', '开内余额不足，请充值！', 'warning');
		return;
    }
	if ($("#name").val() == "") {
		$.messager.alert('警告', '姓名不能为空！', 'warning');
		return;
	}
	if ($("#pwd").val() == "") {
		$.messager.alert('警告', '密码不能为空！', 'warning');
		return;
	}
	document.forms[0].action = "<%=path%>/AddCheFeiServlet";
	document.forms[0].submit();

	}
</script>
