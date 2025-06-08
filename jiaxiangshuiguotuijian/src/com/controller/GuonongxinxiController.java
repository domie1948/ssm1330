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

import com.entity.Guonongxinxi;
import com.server.GuonongxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class GuonongxinxiController {
	@Resource
	private GuonongxinxiServer guonongxinxiService;


   
	@RequestMapping("addGuonongxinxi.do")
	public String addGuonongxinxi(HttpServletRequest request,Guonongxinxi guonongxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		guonongxinxi.setAddtime(time.toString().substring(0, 19));
		guonongxinxiService.add(guonongxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "guonongxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:guonongxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateGuonongxinxi.do")
	public String doUpdateGuonongxinxi(int id,ModelMap map,Guonongxinxi guonongxinxi){
		guonongxinxi=guonongxinxiService.getById(id);
		map.put("guonongxinxi", guonongxinxi);
		return "guonongxinxi_updt";
	}
	
	@RequestMapping("doUpdateGuonongxinxi2.do")
	public String doUpdateGuonongxinxi2(ModelMap map,Guonongxinxi guonongxinxi,HttpServletRequest request){
		guonongxinxi=guonongxinxiService.getById(Integer.parseInt((String)request.getSession().getAttribute("uid")));
		map.put("guonongxinxi", guonongxinxi);
		return "guonongxinxi_updt2";
	}
	
@RequestMapping("updateGuonongxinxi2.do")
	public String updateGuonongxinxi2(int id,ModelMap map,Guonongxinxi guonongxinxi){
		guonongxinxiService.update(guonongxinxi);
		return "redirect:doUpdateGuonongxinxi2.do";
	}
	
	
	
//	后台详细
	@RequestMapping("guonongxinxiDetail.do")
	public String guonongxinxiDetail(int id,ModelMap map,Guonongxinxi guonongxinxi){
		guonongxinxi=guonongxinxiService.getById(id);
		map.put("guonongxinxi", guonongxinxi);
		return "guonongxinxi_detail";
	}
//	前台详细
	@RequestMapping("gnxxDetail.do")
	public String gnxxDetail(int id,ModelMap map,Guonongxinxi guonongxinxi){
		guonongxinxi=guonongxinxiService.getById(id);
		map.put("guonongxinxi", guonongxinxi);
		return "guonongxinxidetail";
	}
//	
	@RequestMapping("updateGuonongxinxi.do")
	public String updateGuonongxinxi(int id,ModelMap map,Guonongxinxi guonongxinxi,HttpServletRequest request,HttpSession session){
		guonongxinxiService.update(guonongxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:guonongxinxiList.do";
	}

//	分页查询
	@RequestMapping("guonongxinxiList.do")
	public String guonongxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Guonongxinxi guonongxinxi, String yonghuming, String mima, String xingming, String xingbie, String shouji, String zhongzhizhonglei, String zhongzhiguimo, String zhongzhidizhi, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(zhongzhizhonglei==null||zhongzhizhonglei.equals("")){pmap.put("zhongzhizhonglei", null);}else{pmap.put("zhongzhizhonglei", zhongzhizhonglei);}		if(zhongzhiguimo==null||zhongzhiguimo.equals("")){pmap.put("zhongzhiguimo", null);}else{pmap.put("zhongzhiguimo", zhongzhiguimo);}		if(zhongzhidizhi==null||zhongzhidizhi.equals("")){pmap.put("zhongzhidizhi", null);}else{pmap.put("zhongzhidizhi", zhongzhidizhi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=guonongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Guonongxinxi> list=guonongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "guonongxinxi_list";
	}
	
	
	
	@RequestMapping("gnxxList.do")
	public String gnxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Guonongxinxi guonongxinxi, String yonghuming, String mima, String xingming, String xingbie, String shouji, String zhongzhizhonglei, String zhongzhiguimo, String zhongzhidizhi, String beizhu, String issh){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 15);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 15);
		
		
		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		if(mima==null||mima.equals("")){pmap.put("mima", null);}else{pmap.put("mima", mima);}		if(xingming==null||xingming.equals("")){pmap.put("xingming", null);}else{pmap.put("xingming", xingming);}		if(xingbie==null||xingbie.equals("")){pmap.put("xingbie", null);}else{pmap.put("xingbie", xingbie);}		if(shouji==null||shouji.equals("")){pmap.put("shouji", null);}else{pmap.put("shouji", shouji);}		if(zhongzhizhonglei==null||zhongzhizhonglei.equals("")){pmap.put("zhongzhizhonglei", null);}else{pmap.put("zhongzhizhonglei", zhongzhizhonglei);}		if(zhongzhiguimo==null||zhongzhiguimo.equals("")){pmap.put("zhongzhiguimo", null);}else{pmap.put("zhongzhiguimo", zhongzhiguimo);}		if(zhongzhidizhi==null||zhongzhidizhi.equals("")){pmap.put("zhongzhidizhi", null);}else{pmap.put("zhongzhidizhi", zhongzhidizhi);}		if(beizhu==null||beizhu.equals("")){pmap.put("beizhu", null);}else{pmap.put("beizhu", beizhu);}		
		int total=guonongxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Guonongxinxi> list=guonongxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "guonongxinxilist";
	}
	
	@RequestMapping("deleteGuonongxinxi.do")
	public String deleteGuonongxinxi(int id,HttpServletRequest request){
		guonongxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:guonongxinxiList.do";
	}
	
	@RequestMapping("quchongGuonongxinxi.do")
	public void quchongGuonongxinxi(Guonongxinxi guonongxinxi,HttpServletResponse response){
		   Map<String,Object> map=new HashMap<String,Object>();
		   map.put("yonghuming", guonongxinxi.getYonghuming());
		   System.out.println("yonghuming==="+guonongxinxi.getYonghuming());
		   System.out.println("yonghuming222==="+guonongxinxiService.quchongGuonongxinxi(map));
		   JSONObject obj=new JSONObject();
		   if(guonongxinxiService.quchongGuonongxinxi(map)!=null){
				 obj.put("info", "ng");
			   }else{
				   obj.put("info", "用户名可以用！");
				  
			   }
		   response.setContentType("text/html;charset=utf-8");
		   PrintWriter out=null;
		   try {
			out=response.getWriter();
			out.print(obj);
			out.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}finally{
			out.close();
		}
	}
}
