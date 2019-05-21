<%@include file="/common/sub_header.jsp"%>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="path" value="${pageContext.request.contextPath}"></c:set>
<c:set var="scheme" value="${pageContext.request.scheme}"></c:set>
<c:set var="serverName" value="${pageContext.request.serverName}"></c:set>
<c:set var="serverPort" value="${pageContext.request.serverPort}"></c:set>
<c:set var="basePath" value="${scheme}://${serverName }:${serverPort }${path }/">
</c:set>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<script type="text/javascript" src="<%=path%>/js/echarts.js"></script>
		<!-- 引入jquery.js -->
		
	</head>

	<body>
		<jsp:include page="/top.jsp"></jsp:include>
		<div class="container clearfix">
			<jsp:include page="/left.jsp"></jsp:include>
			<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
		
		<div class="main-wrap" style="text-align:center;">
			<!-- 为 ECharts 准备一个具备大小（宽高）的 DOM -->
			<div id="main" style="width: 750px;height:550px; border:2px solid ;"></div>
		</div>
		<script type="text/javascript">
		    // 基于准备好的dom，初始化echarts实例
		    var myChart = echarts.init(document.getElementById('main'));
			
			var url = '/Parking03/EchartsServlet?type=Pip';//获得销量、营业额、x轴的数据
		
			$.getJSON(url).done(function(json) {//向url请求数据，如果成功，将数据放到json
				// 2.从json中获得数据
				freeNums = json.freeNums;
				busyNums = json.busyNums;
				    // 指定图表的配置项和数据
				    var option = {
				        title : {
				        text: '车位占用情况',    //标题
				        subtext: '扇形统计图',        //父标题
				        x:'center'
				        },
				    tooltip : {
				        trigger: 'item',
				        //折线（区域）图、柱状（条形）图、K线图 : {a}（系列名称），{b}（类目值），{c}（数值）, {d}（无）
				        //饼图、仪表盘、漏斗图: {a}（系列名称），{b}（数据项名称），{c}（数值）, {d}（百分比）
				        formatter: "{a} <br/>{b} : {c} ({d}%)"
				    },
				    legend: {
				        orient: 'vertical',
				        left: 'left',
				     //   data: ['直接访问','邮件营销','联盟广告','视频广告','搜索引擎']
				        data: ['已经停车状态','空闲状态']
				    },
				    series : [
				        {
				            name: '访问来源',
				            type: 'pie',
				            //饼图的半径，数组的第一项是内半径，第二项是外半径(相对于容器)。
				            radius : '55%',  //[0, '75%'] 
				            //饼图的中心（圆心）坐标，数组的第一项是横坐标，第二项是纵坐标。
							//支持设置成百分比，设置成百分比时第一项是相对于容器宽度，第二项是相对于容器高度。
				            center: ['50%', '60%'],//[400, 300]
				            data:[
				                {value:busyNums, name:'已经停车状态'},
				                {value:freeNums, name:'空闲状态'},
				               /*  {value:234, name:'联盟广告'},
				                {value:135, name:'视频广告'},
				                {value:1548, name:'搜索引擎'} */
				            ]
				        }
				    ]
				  }
		    // 使用刚指定的配置项和数据显示图表。
		  		  myChart.setOption(option);
			});
		</script>
	</body>
</html>
<script>

