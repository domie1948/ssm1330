package com.controller;

import java.io.File;
import java.io.IOException;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.entity.Qiugouxinxi;
import com.server.QiugouxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class QiugouxinxiController {
	@Resource
	private QiugouxinxiServer qiugouxinxiService;


   
	@RequestMapping("addQiugouxinxi.do")
	public String addQiugouxinxi(HttpServletRequest request,Qiugouxinxi qiugouxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		qiugouxinxi.setAddtime(time.toString().substring(0, 19));
		qiugouxinxiService.add(qiugouxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "qiugouxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:qiugouxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateQiugouxinxi.do")
	public String doUpdateQiugouxinxi(int id,ModelMap map,Qiugouxinxi qiugouxinxi){
		qiugouxinxi=qiugouxinxiService.getById(id);
		map.put("qiugouxinxi", qiugouxinxi);
		return "qiugouxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("qiugouxinxiDetail.do")
	public String qiugouxinxiDetail(int id,ModelMap map,Qiugouxinxi qiugouxinxi){
		qiugouxinxi=qiugouxinxiService.getById(id);
		map.put("qiugouxinxi", qiugouxinxi);
		return "qiugouxinxi_detail";
	}
//	前台详细
	@RequestMapping("qgxxDetail.do")
	public String qgxxDetail(int id,ModelMap map,Qiugouxinxi qiugouxinxi){
		qiugouxinxi=qiugouxinxiService.getById(id);
		map.put("qiugouxinxi", qiugouxinxi);
		return "qiugouxinxidetail";
	}
//	
	@RequestMapping("updateQiugouxinxi.do")
	public String updateQiugouxinxi(int id,ModelMap map,Qiugouxinxi qiugouxinxi,HttpServletRequest request,HttpSession session){
		qiugouxinxiService.update(qiugouxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:qiugouxinxiList.do";
	}

//	分页查询
	@RequestMapping("qiugouxinxiList.do")
	public String qiugouxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qiugouxinxi qiugouxinxi, String bianhao, String biaoti, String pinming, String shuliang, String zhuangtai, String jianjie, String lianxifangshi, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(pinming==null||pinming.equals("")){pmap.put("pinming", null);}else{pmap.put("pinming", pinming);}		if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=qiugouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qiugouxinxi> list=qiugouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qiugouxinxi_list";
	}
	
	@RequestMapping("qiugouxinxiList2.do")
	public String qiugouxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qiugouxinxi qiugouxinxi, String bianhao, String biaoti, String pinming, String shuliang, String zhuangtai, String jianjie, String lianxifangshi, String faburen,HttpServletRequest request){
		/*if(session.getAttribute("user")==null){
			return "login";
		}*/
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		pmap.put("faburen", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(pinming==null||pinming.equals("")){pmap.put("pinming", null);}else{pmap.put("pinming", pinming);}		if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		
		
		int total=qiugouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qiugouxinxi> list=qiugouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qiugouxinxi_list2";
	}	
	
	@RequestMapping("qgxxList.do")
	public String qgxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Qiugouxinxi qiugouxinxi, String bianhao, String biaoti, String pinming, String shuliang, String zhuangtai, String jianjie, String lianxifangshi, String faburen){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(biaoti==null||biaoti.equals("")){pmap.put("biaoti", null);}else{pmap.put("biaoti", biaoti);}		if(pinming==null||pinming.equals("")){pmap.put("pinming", null);}else{pmap.put("pinming", pinming);}		if(shuliang==null||shuliang.equals("")){pmap.put("shuliang", null);}else{pmap.put("shuliang", shuliang);}		if(zhuangtai==null||zhuangtai.equals("")){pmap.put("zhuangtai", null);}else{pmap.put("zhuangtai", zhuangtai);}		if(jianjie==null||jianjie.equals("")){pmap.put("jianjie", null);}else{pmap.put("jianjie", jianjie);}		if(lianxifangshi==null||lianxifangshi.equals("")){pmap.put("lianxifangshi", null);}else{pmap.put("lianxifangshi", lianxifangshi);}		if(faburen==null||faburen.equals("")){pmap.put("faburen", null);}else{pmap.put("faburen", faburen);}		
		int total=qiugouxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Qiugouxinxi> list=qiugouxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "qiugouxinxilist";
	}
	
	@RequestMapping("deleteQiugouxinxi.do")
	public String deleteQiugouxinxi(int id,HttpServletRequest request){
		qiugouxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:qiugouxinxiList.do";
	}
	
	
}
