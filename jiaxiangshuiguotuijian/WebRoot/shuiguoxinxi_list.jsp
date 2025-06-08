<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page language="java" import="java.sql.*" %>
<jsp:useBean id="connDbBean" scope="page" class="com.util.db"/>


<script type="text/javascript" src="js/My97DatePicker/WdatePicker.js" charset="gb2312"></script>
<script type="text/javascript" src="js/popup.js"></script>
<script type="text/javascript" src="js/jquery-1.11.0.min.js"></script>


<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
	<TITLE>水果信息查询</TITLE>
	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
</style>
	</head>
	<body>
	<table width="100%" border="0" cellpadding="0" cellspacing="0">
			<tr valign="top">
				<td>
					<table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						<tr align="left" bgcolor="#F2FDFF">
							<td colspan="17" background="images/table_header.gif">水果信息列表</td>
						</tr>
					</table>
				</td>
			</tr>
			
			<tr valign="top">
			  <td bgcolor="#FFFFFF">
			  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#aec3de">
						
					<tr align="right" bgcolor="#ebf0f7">
					  <td colspan="21">
					  <table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" >
						<tr align="left" >
							<td colspan="17">
								<form action="shuiguoxinxiList.do" name="myform" method="post">
									查询   名称：<input name="mingcheng" type="text" id="mingcheng" style='border:solid 1px #000000; color:#666666' size="12" /> 类别：<select name='leibie' id='leibie' style='border:solid 1px #000000; color:#666666;'><option value="">所有</option><%=connDbBean.hsggetoption("shuiguoleibie","leibie")%></select>  单价：<input name="danjia" type="text" id="danjia" style='border:solid 1px #000000; color:#666666' size="12" />  所在地：<input name="suozaidi" type="text" id="suozaidi" style='border:solid 1px #000000; color:#666666' size="12" />
									<input type="submit" value="查询" />
								</form>								</td>
						</tr></table>
					  </td>
			    </tr>
					
						<tr align="center">
						<td style="padding-left:0px; padding-right:0px;"><table width="100%" border="0" align="center" cellpadding="4" cellspacing="1" bgcolor="#ebf0f7">
                          <tr>
                            <td align="center" bgcolor="#ebf0f7" width="30px">序号</td>
                            <%-- <td align='center'>编号</td> --%>
    <td align='center'>名称</td>
    <td align='center'>类别</td>
    <td  width='90' align='center'>主图</td>
    <td align='center'>单价</td>
    <td align='center'>起发数量</td>
    <td align='center'>所在地</td>
    <td  width='65' align='center'>有效期至</td>
    <td  width='95' align='center'>更新时间</td>
    <td align='center'>联系电话</td>
    <td align='center'>联系QQ</td>
    
    <td align='center'>用户名</td>
    
                            <%-- <td align="center" bgcolor="#ebf0f7" width="150px"> 添加时间 </td> --%>
                            <td align="center" bgcolor="#ebf0f7" width="150px"> 操作 </td>
                          </tr>
                          <%
					int i=0;
				%>
                          <c:forEach items="${list }" var="u">
                            <%
					i++;
				%>
                            <tr align="center" bgcolor="#FFFFFF">
                              <td align="center"><%=i%></td>
                             <%-- <td>${u.bianhao}</td> --%>
    <td>${u.mingcheng}</td>
    <td>${u.leibie}</td>
    <td width='90' align='center'><a href='${u.zhutu}' target='_blank'><img src='${u.zhutu}' width=88 height=99 border=0 /></a></td>
    <td>${u.danjia}</td>
    <td>${u.qifashuliang}</td>
    <td>${u.suozaidi}</td>
    <td>${u.youxiaoqizhi}</td>
    <td>${u.gengxinshijian}</td>
    <td>${u.lianxidianhua}</td>
    <td>${u.lianxiQQ}</td>
    
    <td>${u.yonghuming}</td>
    
                              <%-- <td align="center"> ${u.addtime } </td> --%>
                              <td align="center"><a href="doUpdateShuiguoxinxi.do?id=${u.id }">编辑</a>  <a href="deleteShuiguoxinxi.do?id=${u.id }"
										onclick="{if(confirm('确定要删除吗?')){return true;}return false;}">删除</a> <a href="sgxxDetail.do?id=${u.id}" target="_blank">详细</a></td>
                            </tr>
                          </c:forEach>
                        </table></td>
						</tr>
					</table>
					
					
			  </td>
	  </tr>
		</table>
		
		
		
			<p align="center"> <c:if test="${sessionScope.p==1 }">
		 <c:if test="${page.page>1}">
              <a href="shuiguoxinxiList.do?page=1" >首页</a>
             <a href="shuiguoxinxiList.do?page=${page.page-1 }"> 上一页</a>             </c:if>
    	     <c:if test="${page.page<page.totalPage}">
			<a href="shuiguoxinxiList.do?page=${page.page+1 }">下一页</a>
			<a href="shuiguoxinxiList.do?page=${page.totalPage }">末页</a>		    </c:if>		
	</c:if>
	</p>
			
			
			
			
			
	</body>
</html>
