<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>echarts测试</title>
<!-- 1.引入 echarts.js -->
<script type="text/javascript" src="<%=request.getContextPath() %>/js/echarts.js"></script>
<!-- 引入jquery.js -->
<script type="text/javascript" src="<%= request.getContextPath()%>/js/jquery-3.2.1.js"></script>
</head>
<body style="margin: 5% 26% 0% 29%;">


<%-- <%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%> --%>
	<div>Echarts4示例</div>
	<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
	<div id="main" style="width: 600px; height: 400px;"></div>
	<script type="text/javascript">
		// 基于准备好的dom，初始化echarts实例
		var myChart = echarts.init(document.getElementById('main'));
		var url = '/Parking03/EchartsServlet?type=Bar';//获得销量、营业额、x轴的数据
		$.getJSON(url).done(function(json) {//向url请求数据，如果成功，将数据放到json
			// 2.从json中获得数据
			listCost = json.listCost;//销量
			listNums = json.listNums;//营业额
			months = json.months;//月份

			// 3.配置option
			var option = {
				title : {
					text : 'ECharts 入门示例'
				},
				tooltip : {},
				legend : {
					data : [ '销量' ],
					data : [ '营业额' ]
				},
				xAxis : {
					data : months
				},
				yAxis : {},
				series : [ {
					name : '销量',
					type : 'bar',
					data : listCost
				}, {
					name : '营业额',
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
	</body>
</html>  