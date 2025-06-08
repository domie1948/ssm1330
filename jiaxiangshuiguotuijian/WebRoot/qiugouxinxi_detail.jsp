<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>求购信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  求购信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%'>编号：</td><td width='39%'>${qiugouxinxi.bianhao}</td>     <td width='11%'>标题：</td><td width='39%'>${qiugouxinxi.biaoti}</td></tr><tr>     <td width='11%'>品名：</td><td width='39%'>${qiugouxinxi.pinming}</td>     <td width='11%'>数量：</td><td width='39%'>${qiugouxinxi.shuliang}</td></tr><tr>     <td width='11%'>状态：</td><td width='39%'>${qiugouxinxi.zhuangtai}</td>     <td width='11%'>简介：</td><td width='39%'>${qiugouxinxi.jianjie}</td></tr><tr>     <td width='11%'>联系方式：</td><td width='39%'>${qiugouxinxi.lianxifangshi}</td>     <td width='11%'>发布人：</td><td width='39%'>${qiugouxinxi.faburen}</td>     </tr><tr><td colspan=4 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

