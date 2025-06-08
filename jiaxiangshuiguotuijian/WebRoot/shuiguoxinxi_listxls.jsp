<%@ page language="java" import="java.util.*" pageEncoding="gb2312"%>
<jsp:useBean id="sn" scope="page" class="com.bean.SystemBean" />
<jsp:useBean id="shuiguoxinxihsgb" scope="page" class="com.bean.ShuiguoxinxiBean" /> 

<%
response.setContentType("application/vnd.ms-excel");
response.addHeader("Content-Disposition", "attachment;filename=shuiguoxinxi.xls");
%>
<html>
  <head>
    <title>水果信息</title>
  </head>

  <body >
 <%
			String sql="select * from shuiguoxinxi  order by id desc";

			
			%>
<table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="00FFFF" style="border-collapse:collapse">  
  <tr>
    <td width="30" align="center" bgcolor="CCFFFF">序号</td>
    <td align='center'>编号</td>    <td align='center'>名称</td>    <td align='center'>类别</td>    <td  width='90' align='center'>主图</td>    <td align='center'>单价</td>    <td align='center'>起发数量</td>    <td align='center'>所在地</td>    <td  width='65' align='center'>有效期至</td>    <td  width='95' align='center'>更新时间</td>    <td align='center'>联系电话</td>    <td align='center'>联系QQ</td>        <td align='center'>用户名</td>    
	
    <td width="120" align="center" bgcolor="CCFFFF">添加时间</td>
    
  </tr>
   <%		
				List pagelist3=shuiguoxinxihsgb.getAllShuiguoxinxi(15);
			if(!pagelist3.isEmpty()){
				for(int i=0;i<pagelist3.size();i++){
					List pagelist2 =(ArrayList)pagelist3.get(i);
			%>
  <tr>
    <td  align="center"><%=i+1 %></td>
    <td>${u.bianhao}</td>    <td>${u.mingcheng}</td>    <td>${u.leibie}</td>    <td width='90' align='center'><a href='${u.zhutu}' target='_blank'><img src='${u.zhutu}' width=88 height=99 border=0 /></a></td>    <td>${u.danjia}</td>    <td>${u.qifashuliang}</td>    <td>${u.suozaidi}</td>    <td>${u.youxiaoqizhi}</td>    <td>${u.gengxinshijian}</td>    <td>${u.lianxidianhua}</td>    <td>${u.lianxiQQ}</td>        <td>${u.yonghuming}</td>    
	
	
   
  </tr>
  	<%
  }}
   %>
   
</table>
<br>
  </body>
</html>

