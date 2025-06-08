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

import com.entity.Shuiguoleibie;
import com.server.ShuiguoleibieServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShuiguoleibieController {
	@Resource
	private ShuiguoleibieServer shuiguoleibieService;


   
	@RequestMapping("addShuiguoleibie.do")
	public String addShuiguoleibie(HttpServletRequest request,Shuiguoleibie shuiguoleibie,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shuiguoleibie.setAddtime(time.toString().substring(0, 19));
		shuiguoleibieService.add(shuiguoleibie);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shuiguoleibieList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shuiguoleibieList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShuiguoleibie.do")
	public String doUpdateShuiguoleibie(int id,ModelMap map,Shuiguoleibie shuiguoleibie){
		shuiguoleibie=shuiguoleibieService.getById(id);
		map.put("shuiguoleibie", shuiguoleibie);
		return "shuiguoleibie_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shuiguoleibieDetail.do")
	public String shuiguoleibieDetail(int id,ModelMap map,Shuiguoleibie shuiguoleibie){
		shuiguoleibie=shuiguoleibieService.getById(id);
		map.put("shuiguoleibie", shuiguoleibie);
		return "shuiguoleibie_detail";
	}
//	前台详细
	@RequestMapping("sglbDetail.do")
	public String sglbDetail(int id,ModelMap map,Shuiguoleibie shuiguoleibie){
		shuiguoleibie=shuiguoleibieService.getById(id);
		map.put("shuiguoleibie", shuiguoleibie);
		return "shuiguoleibiedetail";
	}
//	
	@RequestMapping("updateShuiguoleibie.do")
	public String updateShuiguoleibie(int id,ModelMap map,Shuiguoleibie shuiguoleibie,HttpServletRequest request,HttpSession session){
		shuiguoleibieService.update(shuiguoleibie);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shuiguoleibieList.do";
	}

//	分页查询
	@RequestMapping("shuiguoleibieList.do")
	public String shuiguoleibieList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shuiguoleibie shuiguoleibie, String leibie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		
		int total=shuiguoleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shuiguoleibie> list=shuiguoleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shuiguoleibie_list";
	}
	
	
	
	@RequestMapping("sglbList.do")
	public String sglbList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shuiguoleibie shuiguoleibie, String leibie){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		
		int total=shuiguoleibieService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shuiguoleibie> list=shuiguoleibieService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shuiguoleibielist";
	}
	
	@RequestMapping("deleteShuiguoleibie.do")
	public String deleteShuiguoleibie(int id,HttpServletRequest request){
		shuiguoleibieService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shuiguoleibieList.do";
	}
	
	
}
