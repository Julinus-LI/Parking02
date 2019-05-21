<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>


<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<script type="text/javascript" src="<%=path%>/js/echarts.js"></script>
		<!-- 引入jquery.js -->
		<script type="text/javascript" src="<%=path%>/js/jquery-3.2.1.js"></script>
	</head>

	<body>
		<jsp:include page="/top.jsp"></jsp:include>
		<div class="container clearfix">
			<jsp:include page="/left.jsp"></jsp:include>
		<div class="main-wrap" style="text-align:center;margin-left:300px">
					<div style="font-size:20px;font-weight:bold">停车记录图</div><br><br>
				<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
				<div id="main" style="width: 750px; height: 550px;style="text-align:center;"></div>
		</div>
	
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		var url = 'Parking03/EchartsServlet?type=Bar';//获得销量、营业额、x轴的数据
		$.getJSON(url).done(function(json) {//向url请求数据，如果成功，将数据放到json
			// 2.从json中获得数据
			listCost = json.listCost;//销量
			listNums = json.listNums;//营业额
			months = json.months;//月份

			// 3.配置option
			var option = {
				title : {
					text : '停车记录费用和车次图'
				},
				tooltip : {},
				legend : {
					data : [ '费用' ],
					data : [ '车次' ]
				},
				xAxis : {
					data : months
				},
				yAxis : {},
				series : [ {
					name : '费用',
					type : 'bar',
					data : listCost
				}, {
					name : '车次',
					type : 'line',
					data : listNums
				} ],
				toolbox : {
					show : true,
					feature : {
						mark : {
							show : true
						},
						dataView : {
							show : true,
							readOnly : false
						},
						magicType : {
							show : true,
							type : [ 'line', 'bar' ]
						},
						restore : {
							show : true
						},
						saveAsImage : {
							show : true
						}
					}
				}
			}
			myChart.setOption(option);
		});
		

		</script>
			
			<!--/main-->
		</div>
	</body>
</html>

