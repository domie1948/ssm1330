<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>
<html>
  <head>
    <title>水果信息详细</title>
<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>

  </head>

  <body >

  水果信息详细:
  <br><br>
  
   <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1" bordercolor="#CBD8AC" style="border-collapse:collapse">  
   <tr>
     <td width='11%' height=44>编号：</td><td width='39%'>${shuiguoxinxi.bianhao}</td><td  rowspan=11 align=center><a href=${shuiguoxinxi.zhutu} target=_blank><img src=${shuiguoxinxi.zhutu} width=228 height=215 border=0></a></td></tr><tr><td width='11%' height=44>名称：</td><td width='39%'>${shuiguoxinxi.mingcheng}</td></tr><tr><td width='11%' height=44>类别：</td><td width='39%'>${shuiguoxinxi.leibie}</td></tr><tr><td width='11%' height=44>单价：</td><td width='39%'>${shuiguoxinxi.danjia}</td></tr><tr><td width='11%' height=44>起发数量：</td><td width='39%'>${shuiguoxinxi.qifashuliang}</td></tr><tr><td width='11%' height=44>所在地：</td><td width='39%'>${shuiguoxinxi.suozaidi}</td></tr><tr><td width='11%' height=44>有效期至：</td><td width='39%'>${shuiguoxinxi.youxiaoqizhi}</td></tr><tr><td width='11%' height=44>更新时间：</td><td width='39%'>${shuiguoxinxi.gengxinshijian}</td></tr><tr><td width='11%' height=44>联系电话：</td><td width='39%'>${shuiguoxinxi.lianxidianhua}</td></tr><tr><td width='11%' height=44>联系QQ：</td><td width='39%'>${shuiguoxinxi.lianxiQQ}</td></tr><tr><td width='11%' height=44>用户名：</td><td width='39%'>${shuiguoxinxi.yonghuming}</td></tr><tr><td width='11%' height=100  >详情描述：</td><td width='39%' colspan=2 height=100 >${shuiguoxinxi.xiangqingmiaoshu}</td></tr><tr><td colspan=3 align=center><input type=button name=Submit5 value=返回 onClick="javascript:history.back()" />&nbsp;<input type=button name=Submit5 value=打印 onClick="javascript:window.print()" /></td></tr>
    
  </table>

  </body>
</html>

