<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="qiugouxinxihsgb" scope="page" class="com.bean.QiugouxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=qiugouxinxi.xls");
%>
<html>
  <head>
    <title>求购信息</title>
  </head>

  <body >
 <%
			String sql="select * from qiugouxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>标题</td>    <td align='center'>品名</td>    <td align='center'>数量</td>    <td align='center'>状态</td>        <td align='center'>联系方式</td>    <td align='center'>发布人</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=qiugouxinxihsgb.getAllQiugouxinxi(10);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.biaoti}</td>    <td>${u.pinming}</td>    <td>${u.shuliang}</td>    <td>${u.zhuangtai}</td>        <td>${u.lianxifangshi}</td>    <td>${u.faburen}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

