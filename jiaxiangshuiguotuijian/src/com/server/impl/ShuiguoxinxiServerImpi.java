package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShuiguoxinxiMapper;
import com.entity.Shuiguoxinxi;
import com.server.ShuiguoxinxiServer;
@Service
public class ShuiguoxinxiServerImpi implements ShuiguoxinxiServer {
   @Resource
   private ShuiguoxinxiMapper gdao;
	@Override
	public int add(Shuiguoxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shuiguoxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shuiguoxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shuiguoxinxi> getsyshuiguoxinxi1(Map<String, Object> map) {
		return gdao.getsyshuiguoxinxi1(map);
	}
	public List<Shuiguoxinxi> getsyshuiguoxinxi2(Map<String, Object> map) {
		return gdao.getsyshuiguoxinxi2(map);
	}
	public List<Shuiguoxinxi> getsyshuiguoxinxi3(Map<String, Object> map) {
		return gdao.getsyshuiguoxinxi3(map);
	}
	
	@Override
	public Shuiguoxinxi quchongShuiguoxinxi(Map<String, Object> account) {
		return gdao.quchongShuiguoxinxi(account);
	}

	@Override
	public List<Shuiguoxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shuiguoxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shuiguoxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

