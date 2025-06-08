package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.ShuiguoleibieMapper;
import com.entity.Shuiguoleibie;
import com.server.ShuiguoleibieServer;
@Service
public class ShuiguoleibieServerImpi implements ShuiguoleibieServer {
   @Resource
   private ShuiguoleibieMapper gdao;
	@Override
	public int add(Shuiguoleibie po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Shuiguoleibie po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Shuiguoleibie> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Shuiguoleibie> getsyshuiguoleibie1(Map<String, Object> map) {
		return gdao.getsyshuiguoleibie1(map);
	}
	public List<Shuiguoleibie> getsyshuiguoleibie2(Map<String, Object> map) {
		return gdao.getsyshuiguoleibie2(map);
	}
	public List<Shuiguoleibie> getsyshuiguoleibie3(Map<String, Object> map) {
		return gdao.getsyshuiguoleibie3(map);
	}
	
	@Override
	public Shuiguoleibie quchongShuiguoleibie(Map<String, Object> account) {
		return gdao.quchongShuiguoleibie(account);
	}

	@Override
	public List<Shuiguoleibie> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Shuiguoleibie> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Shuiguoleibie getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

