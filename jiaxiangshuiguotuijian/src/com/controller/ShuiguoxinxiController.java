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

import com.entity.Shuiguoxinxi;
import com.server.ShuiguoxinxiServer;
import com.util.PageBean;
import net.sf.json.JSONObject;
import com.util.db;
import java.sql.SQLException;
import java.sql.*;
@Controller
public class ShuiguoxinxiController {
	@Resource
	private ShuiguoxinxiServer shuiguoxinxiService;


   
	@RequestMapping("addShuiguoxinxi.do")
	public String addShuiguoxinxi(HttpServletRequest request,Shuiguoxinxi shuiguoxinxi,HttpSession session) throws SQLException{
		Timestamp time=new Timestamp(System.currentTimeMillis());
		
		shuiguoxinxi.setAddtime(time.toString().substring(0, 19));
		shuiguoxinxiService.add(shuiguoxinxi);
		session.setAttribute("backxx", "添加成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		
		//session.setAttribute("backurl", "shuiguoxinxiList.do");
		
		return "redirect:postback.jsp";
		//return "redirect:shuiguoxinxiList.do";
		
		
		
	}
 
//	处理编辑
	@RequestMapping("doUpdateShuiguoxinxi.do")
	public String doUpdateShuiguoxinxi(int id,ModelMap map,Shuiguoxinxi shuiguoxinxi){
		shuiguoxinxi=shuiguoxinxiService.getById(id);
		map.put("shuiguoxinxi", shuiguoxinxi);
		return "shuiguoxinxi_updt";
	}
	
	
	
	
	
//	后台详细
	@RequestMapping("shuiguoxinxiDetail.do")
	public String shuiguoxinxiDetail(int id,ModelMap map,Shuiguoxinxi shuiguoxinxi){
		shuiguoxinxi=shuiguoxinxiService.getById(id);
		map.put("shuiguoxinxi", shuiguoxinxi);
		return "shuiguoxinxi_detail";
	}
//	前台详细
	@RequestMapping("sgxxDetail.do")
	public String sgxxDetail(int id,ModelMap map,Shuiguoxinxi shuiguoxinxi){
		shuiguoxinxi=shuiguoxinxiService.getById(id);
		map.put("shuiguoxinxi", shuiguoxinxi);
		return "shuiguoxinxidetail";
	}
//	
	@RequestMapping("updateShuiguoxinxi.do")
	public String updateShuiguoxinxi(int id,ModelMap map,Shuiguoxinxi shuiguoxinxi,HttpServletRequest request,HttpSession session){
		shuiguoxinxiService.update(shuiguoxinxi);
		session.setAttribute("backxx", "修改成功");
		session.setAttribute("backurl", request.getHeader("Referer"));
		return "redirect:postback.jsp";
		//String url = request.getHeader("Referer");
		//return "redirect:"+url;
		//return "redirect:shuiguoxinxiList.do";
	}

//	分页查询
	@RequestMapping("shuiguoxinxiList.do")
	public String shuiguoxinxiList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shuiguoxinxi shuiguoxinxi, String bianhao, String mingcheng, String leibie, String zhutu, String danjia1,String danjia2, String qifashuliang1,String qifashuliang2, String suozaidi, String youxiaoqizhi1,String youxiaoqizhi2, String gengxinshijian1,String gengxinshijian2, String lianxidianhua, String lianxiQQ, String xiangqingmiaoshu, String yonghuming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}		if(qifashuliang1==null||qifashuliang1.equals("")){pmap.put("qifashuliang1", null);}else{pmap.put("qifashuliang1", qifashuliang1);}		if(qifashuliang2==null||qifashuliang2.equals("")){pmap.put("qifashuliang2", null);}else{pmap.put("qifashuliang2", qifashuliang2);}		if(suozaidi==null||suozaidi.equals("")){pmap.put("suozaidi", null);}else{pmap.put("suozaidi", suozaidi);}		if(youxiaoqizhi1==null||youxiaoqizhi1.equals("")){pmap.put("youxiaoqizhi1", null);}else{pmap.put("youxiaoqizhi1", youxiaoqizhi1);}		if(youxiaoqizhi2==null||youxiaoqizhi2.equals("")){pmap.put("youxiaoqizhi2", null);}else{pmap.put("youxiaoqizhi2", youxiaoqizhi2);}		if(gengxinshijian1==null||gengxinshijian1.equals("")){pmap.put("gengxinshijian1", null);}else{pmap.put("gengxinshijian1", gengxinshijian1);}		if(gengxinshijian2==null||gengxinshijian2.equals("")){pmap.put("gengxinshijian2", null);}else{pmap.put("gengxinshijian2", gengxinshijian2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(lianxiQQ==null||lianxiQQ.equals("")){pmap.put("lianxiQQ", null);}else{pmap.put("lianxiQQ", lianxiQQ);}		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=shuiguoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shuiguoxinxi> list=shuiguoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shuiguoxinxi_list";
	}
	
	@RequestMapping("shuiguoxinxiList2.do")
	public String shuiguoxinxiList2(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shuiguoxinxi shuiguoxinxi, String bianhao, String mingcheng, String leibie, String zhutu, String danjia1,String danjia2, String qifashuliang1,String qifashuliang2, String suozaidi, String youxiaoqizhi1,String youxiaoqizhi2, String gengxinshijian1,String gengxinshijian2, String lianxidianhua, String lianxiQQ, String xiangqingmiaoshu, String yonghuming,HttpServletRequest request){
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
		
		pmap.put("yonghuming", (String)request.getSession().getAttribute("username"));
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}		if(qifashuliang1==null||qifashuliang1.equals("")){pmap.put("qifashuliang1", null);}else{pmap.put("qifashuliang1", qifashuliang1);}		if(qifashuliang2==null||qifashuliang2.equals("")){pmap.put("qifashuliang2", null);}else{pmap.put("qifashuliang2", qifashuliang2);}		if(suozaidi==null||suozaidi.equals("")){pmap.put("suozaidi", null);}else{pmap.put("suozaidi", suozaidi);}		if(youxiaoqizhi1==null||youxiaoqizhi1.equals("")){pmap.put("youxiaoqizhi1", null);}else{pmap.put("youxiaoqizhi1", youxiaoqizhi1);}		if(youxiaoqizhi2==null||youxiaoqizhi2.equals("")){pmap.put("youxiaoqizhi2", null);}else{pmap.put("youxiaoqizhi2", youxiaoqizhi2);}		if(gengxinshijian1==null||gengxinshijian1.equals("")){pmap.put("gengxinshijian1", null);}else{pmap.put("gengxinshijian1", gengxinshijian1);}		if(gengxinshijian2==null||gengxinshijian2.equals("")){pmap.put("gengxinshijian2", null);}else{pmap.put("gengxinshijian2", gengxinshijian2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(lianxiQQ==null||lianxiQQ.equals("")){pmap.put("lianxiQQ", null);}else{pmap.put("lianxiQQ", lianxiQQ);}		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}		
		
		int total=shuiguoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shuiguoxinxi> list=shuiguoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shuiguoxinxi_list2";
	}	
	
	@RequestMapping("sgxxList.do")
	public String sgxxList(@RequestParam(value="page",required=false)String page,
			ModelMap map,HttpSession session,Shuiguoxinxi shuiguoxinxi, String bianhao, String mingcheng, String leibie, String zhutu, String danjia1,String danjia2, String qifashuliang1,String qifashuliang2, String suozaidi, String youxiaoqizhi1,String youxiaoqizhi2, String gengxinshijian1,String gengxinshijian2, String lianxidianhua, String lianxiQQ, String xiangqingmiaoshu, String yonghuming){
		if(page==null||page.equals("")){
			page="1";
		}
		PageBean pageBean=new PageBean(Integer.parseInt(page), 5);
		Map<String, Object> pmap=new HashMap<String,Object>();
		pmap.put("pageno", pageBean.getStart());
		pmap.put("pageSize", 5);
		
		
		if(bianhao==null||bianhao.equals("")){pmap.put("bianhao", null);}else{pmap.put("bianhao", bianhao);}		if(mingcheng==null||mingcheng.equals("")){pmap.put("mingcheng", null);}else{pmap.put("mingcheng", mingcheng);}		if(leibie==null||leibie.equals("")){pmap.put("leibie", null);}else{pmap.put("leibie", leibie);}		if(zhutu==null||zhutu.equals("")){pmap.put("zhutu", null);}else{pmap.put("zhutu", zhutu);}		if(danjia1==null||danjia1.equals("")){pmap.put("danjia1", null);}else{pmap.put("danjia1", danjia1);}		if(danjia2==null||danjia2.equals("")){pmap.put("danjia2", null);}else{pmap.put("danjia2", danjia2);}		if(qifashuliang1==null||qifashuliang1.equals("")){pmap.put("qifashuliang1", null);}else{pmap.put("qifashuliang1", qifashuliang1);}		if(qifashuliang2==null||qifashuliang2.equals("")){pmap.put("qifashuliang2", null);}else{pmap.put("qifashuliang2", qifashuliang2);}		if(suozaidi==null||suozaidi.equals("")){pmap.put("suozaidi", null);}else{pmap.put("suozaidi", suozaidi);}		if(youxiaoqizhi1==null||youxiaoqizhi1.equals("")){pmap.put("youxiaoqizhi1", null);}else{pmap.put("youxiaoqizhi1", youxiaoqizhi1);}		if(youxiaoqizhi2==null||youxiaoqizhi2.equals("")){pmap.put("youxiaoqizhi2", null);}else{pmap.put("youxiaoqizhi2", youxiaoqizhi2);}		if(gengxinshijian1==null||gengxinshijian1.equals("")){pmap.put("gengxinshijian1", null);}else{pmap.put("gengxinshijian1", gengxinshijian1);}		if(gengxinshijian2==null||gengxinshijian2.equals("")){pmap.put("gengxinshijian2", null);}else{pmap.put("gengxinshijian2", gengxinshijian2);}		if(lianxidianhua==null||lianxidianhua.equals("")){pmap.put("lianxidianhua", null);}else{pmap.put("lianxidianhua", lianxidianhua);}		if(lianxiQQ==null||lianxiQQ.equals("")){pmap.put("lianxiQQ", null);}else{pmap.put("lianxiQQ", lianxiQQ);}		if(xiangqingmiaoshu==null||xiangqingmiaoshu.equals("")){pmap.put("xiangqingmiaoshu", null);}else{pmap.put("xiangqingmiaoshu", xiangqingmiaoshu);}		if(yonghuming==null||yonghuming.equals("")){pmap.put("yonghuming", null);}else{pmap.put("yonghuming", yonghuming);}		
		int total=shuiguoxinxiService.getCount(pmap);
		pageBean.setTotal(total);
		List<Shuiguoxinxi> list=shuiguoxinxiService.getByPage(pmap);
		map.put("page", pageBean);
		map.put("list", list);
		session.setAttribute("p", 1);
		return "shuiguoxinxilist";
	}
	
	@RequestMapping("deleteShuiguoxinxi.do")
	public String deleteShuiguoxinxi(int id,HttpServletRequest request){
		shuiguoxinxiService.delete(id);
		String url = request.getHeader("Referer");
		return "redirect:"+url;
		//return "redirect:shuiguoxinxiList.do";
	}
	
	
}
