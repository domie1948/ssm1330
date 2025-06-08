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
		<TITLE>添加水果信息</TITLE>
	    <link rel="stylesheet" href="kindeditor_a5/themes/default/default.css" />
	<link rel="stylesheet" href="kindeditor_a5/plugins/code/prettify.css" />
	<script charset="gb2312" src="kindeditor_a5/kindeditor.js"></script>
	<script charset="gb2312" src="kindeditor_a5/lang/zh_CN.js"></script>
	<script charset="gb2312" src="kindeditor_a5/plugins/code/prettify.js"></script>
	<script>
		KindEditor.ready(function(K) {
			var editor1 = K.create('textarea[name="xiangqingmiaoshu"]', {
				cssPath : 'kindeditor_a5/plugins/code/prettify.css',
				uploadJson : 'kindeditor_a5/jsp/upload_json.jsp',
				fileManagerJson : 'kindeditor_a5/jsp/file_manager_json.jsp',
				allowFileManager : true,
				afterCreate : function() {
					var self = this;
					K.ctrl(document, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
					K.ctrl(self.edit.doc, 13, function() {
						self.sync();
						document.forms['example'].submit();
					});
				}
			});
			prettyPrint();
		});
	</script>

 	<style type="text/css">
<!--
body,td,th {
	font-size: 12px;
}
-->
</style>      
	</head>
<%
  String id="";
   %>

<script language="javascript">

function gows()
{
	document.location.href="shuiguoxinxi_add.jsp?id=<%=id%>";
}
function hsgxia2shxurxu(nstr,nwbk)
{
	if (eval("form1."+nwbk).value.indexOf(nstr)>=0)
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value.replace(nstr+"；", "");
	}
	else
	{
		eval("form1."+nwbk).value=eval("form1."+nwbk).value+nstr+"；";
	}
}
</script>
	<body>
			<form action="addShuiguoxinxi.do" name="form1" method="post">
				      <table width="100%" border="1" align="center" cellpadding="3" cellspacing="1"  style="border-collapse:collapse" bgcolor="#F2FDFF">
						<tr bgcolor="#E7E7E7">
							<td height="20" colspan="2" background="images/table_header.gif">添加水果信息</td>
						</tr>
						<tr ><td width="200">编号：</td><td><input name='bianhao' type='text' id='bianhao' value='<%=connDbBean.getID()%>' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr ><td width="200">名称：</td><td><input name='mingcheng' type='text' id='mingcheng' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelmingcheng' /></td></tr>
		<tr ><td width="200">类别：</td><td><select name='leibie' id='leibie' style=' height:19px; border:solid 1px #000000; color:#666666'><%=connDbBean.hsggetoption("shuiguoleibie","leibie")%></select></td></tr>
		<tr ><td width="200">主图：</td><td><input name='zhutu' type='text' id='zhutu' size='50' value='' onblur='' style='border:solid 1px #000000; color:#666666' />&nbsp;<input type='button' value='上传' onClick="up('zhutu')" style='border:solid 1px #000000; color:#666666'/></td></tr>
		<tr ><td width="200">单价：</td><td><input name='danjia' type='text' id='danjia' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabeldanjia' /></td></tr>
		<tr ><td width="200">起发数量：</td><td><input name='qifashuliang' type='text' id='qifashuliang' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelqifashuliang' /></td></tr>
		<tr ><td width="200">所在地：</td><td><input name='suozaidi' type='text' id='suozaidi' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabelsuozaidi' /></td></tr>
		<tr ><td width="200">有效期至：</td><td><input name='youxiaoqizhi' type='text' id='youxiaoqizhi' value='<%=connDbBean.getdate()%>' onblur='checkform()' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd'})" style='width:100px; height:16px; border:solid 1px #000000; color:#666666'/>&nbsp;*<label id='clabelyouxiaoqizhi' /></td></tr>
		<tr ><td width="200">更新时间：</td><td><input name='gengxinshijian' type='text' id='gengxinshijian' value='<%=connDbBean.gettime()%>' onblur='' readonly='readonly' onClick="WdatePicker({'dateFmt':'yyyy-MM-dd HH:mm:ss'})" style='width:120px; height:16px; border:solid 1px #000000; color:#666666'/></td></tr>
		<tr 0><td width="200">联系电话：</td><td><input name='lianxidianhua' type='text' id='lianxidianhua' value='' onblur='checkform()' style='border:solid 1px #000000; color:#666666' />&nbsp;*<label id='clabellianxidianhua' /></td></tr>
		<tr 1><td width="200">联系QQ：</td><td><input name='lianxiQQ' type='text' id='lianxiQQ' value='' onblur='' style='border:solid 1px #000000; color:#666666' /></td></tr>
		<tr 2><td width="200">详情描述：</td><td><textarea name="xiangqingmiaoshu" cols="100" rows="8" style="width:700px;height:200px;visibility:hidden;"></textarea></td></tr>
		<tr 3><td width="200">用户名：</td><td><input name='yonghuming' type='text' id='yonghuming' onblur='' style='border:solid 1px #000000; color:#666666' value='<%=(String)request.getSession().getAttribute("username")%>' readonly="readonly" /></td></tr>
		
		
						<tr align='center'   height="22">
						    <td width="25%"  align="right">&nbsp;
						        
						    </td>
						    <td width="75%"  align="left">
						       <input type="submit" name="querenzhuce" id="querenzhuce" value="提交" onClick="return checkform();"/>
						       <input type="reset" value="重置"/>&nbsp;
						    </td>
						</tr>
					 </table>
			</form>
   </body>
</html>






<script language=javascript >  
 
 function checkform(){  
 
	var mingchengobj = document.getElementById("mingcheng"); if(mingchengobj.value==""){document.getElementById("clabelmingcheng").innerHTML="&nbsp;&nbsp;<font color=red>请输入名称</font>";return false;}else{document.getElementById("clabelmingcheng").innerHTML="  "; } 
	var danjiaobj = document.getElementById("danjia"); if(danjiaobj.value==""){document.getElementById("clabeldanjia").innerHTML="&nbsp;&nbsp;<font color=red>请输入单价</font>";return false;}else{document.getElementById("clabeldanjia").innerHTML="  "; } 
	var danjiaobj = document.getElementById("danjia"); if(danjiaobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(danjiaobj.value)){document.getElementById("clabeldanjia").innerHTML=""; }else{document.getElementById("clabeldanjia").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var qifashuliangobj = document.getElementById("qifashuliang"); if(qifashuliangobj.value==""){document.getElementById("clabelqifashuliang").innerHTML="&nbsp;&nbsp;<font color=red>请输入起发数量</font>";return false;}else{document.getElementById("clabelqifashuliang").innerHTML="  "; } 
	var qifashuliangobj = document.getElementById("qifashuliang"); if(qifashuliangobj.value!=""){ if(/^[0-9]+.?[0-9]*$/.test(qifashuliangobj.value)){document.getElementById("clabelqifashuliang").innerHTML=""; }else{document.getElementById("clabelqifashuliang").innerHTML="&nbsp;&nbsp;<font color=red>必需数字型</font>"; return false;}}  
    var suozaidiobj = document.getElementById("suozaidi"); if(suozaidiobj.value==""){document.getElementById("clabelsuozaidi").innerHTML="&nbsp;&nbsp;<font color=red>请输入所在地</font>";return false;}else{document.getElementById("clabelsuozaidi").innerHTML="  "; } 
	var youxiaoqizhiobj = document.getElementById("youxiaoqizhi"); if(youxiaoqizhiobj.value==""){document.getElementById("clabelyouxiaoqizhi").innerHTML="&nbsp;&nbsp;<font color=red>请输入有效期至</font>";return false;}else{document.getElementById("clabelyouxiaoqizhi").innerHTML="  "; } 
	var lianxidianhuaobj = document.getElementById("lianxidianhua"); if(lianxidianhuaobj.value==""){document.getElementById("clabellianxidianhua").innerHTML="&nbsp;&nbsp;<font color=red>请输入联系电话</font>";return false;}else{document.getElementById("clabellianxidianhua").innerHTML="  "; } 
	


return true;   
}   
popheight=450;
</script>  
