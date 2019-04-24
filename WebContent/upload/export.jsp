<%@ page language="java"
	import="java.util.*,java.io.*,pers.arrayli.utils.ExportExcelUtil,java.sql.*"
	pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<%
	
	ExportExcelUtil export = new ExportExcelUtil();
	String filename = "D:\\停车信息.xls";
	export.createTableHeader();

	try {

		String sql = "select* from t_chefei";
		ResultSet rs = export.selectAllDataFromDB(sql);
		int rowIndex = 1;
		while (rs.next()) {
			List<String> list = new ArrayList<String>();
			for (int i = 1; i <= ExportExcelUtil.columNumber; i++) {
				list.add(rs.getString(i));
			}
			export.createTableRow(list, (short) rowIndex);
			rowIndex++;
			System.out.println("11");
		}

		export.expord(new FileOutputStream(filename));
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

	File file = new File(filename);
	if (!file.exists()) {
		file.createNewFile();
	}
	// 取得文件名。

	// 取得文件的后缀名。
	//String ext = filename.substring(filename.lastIndexOf(".") + 1).toUpperCase();

	// 以流的形式下载文件。
	InputStream fis = new BufferedInputStream(new FileInputStream(file));
	byte[] buffer = new byte[fis.available()];
	fis.read(buffer);
	fis.close();

	response.reset();

	response.addHeader("Content-Disposition", "attachment;filename="
			+ new String("tingche.xls".getBytes("utf-8"), "ISO-8859-1"));
	response.addHeader("Content-Length", "" + file.length());
 
	OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
	response.setContentType("application/octet-stream");
	toClient.write(buffer);
	toClient.flush();
	toClient.close();
	
	out.clear();
out = pageContext.pushBody();
%>