package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.GuonongxinxiMapper;
import com.entity.Guonongxinxi;
import com.server.GuonongxinxiServer;
@Service
public class GuonongxinxiServerImpi implements GuonongxinxiServer {
   @Resource
   private GuonongxinxiMapper gdao;
	@Override
	public int add(Guonongxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Guonongxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Guonongxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Guonongxinxi> getsyguonongxinxi1(Map<String, Object> map) {
		return gdao.getsyguonongxinxi1(map);
	}
	public List<Guonongxinxi> getsyguonongxinxi2(Map<String, Object> map) {
		return gdao.getsyguonongxinxi2(map);
	}
	public List<Guonongxinxi> getsyguonongxinxi3(Map<String, Object> map) {
		return gdao.getsyguonongxinxi3(map);
	}
	
	@Override
	public Guonongxinxi quchongGuonongxinxi(Map<String, Object> account) {
		return gdao.quchongGuonongxinxi(account);
	}

	@Override
	public List<Guonongxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Guonongxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Guonongxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

