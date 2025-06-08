package com.server.impl;

import java.util.List;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.dao.QiugouxinxiMapper;
import com.entity.Qiugouxinxi;
import com.server.QiugouxinxiServer;
@Service
public class QiugouxinxiServerImpi implements QiugouxinxiServer {
   @Resource
   private QiugouxinxiMapper gdao;
	@Override
	public int add(Qiugouxinxi po) {
		return gdao.insert(po);
	}

	@Override
	public int update(Qiugouxinxi po) {
		return gdao.updateByPrimaryKeySelective(po);
	}

	
	
	@Override
	public int delete(int id) {
		return gdao.deleteByPrimaryKey(id);
	}

	@Override
	public List<Qiugouxinxi> getAll(Map<String, Object> map) {
		return gdao.getAll(map);
	}
	
	public List<Qiugouxinxi> getsyqiugouxinxi1(Map<String, Object> map) {
		return gdao.getsyqiugouxinxi1(map);
	}
	public List<Qiugouxinxi> getsyqiugouxinxi2(Map<String, Object> map) {
		return gdao.getsyqiugouxinxi2(map);
	}
	public List<Qiugouxinxi> getsyqiugouxinxi3(Map<String, Object> map) {
		return gdao.getsyqiugouxinxi3(map);
	}
	
	@Override
	public Qiugouxinxi quchongQiugouxinxi(Map<String, Object> account) {
		return gdao.quchongQiugouxinxi(account);
	}

	@Override
	public List<Qiugouxinxi> getByPage(Map<String, Object> map) {
		return gdao.getByPage(map);
	}

	@Override
	public int getCount(Map<String, Object> map) {
		return gdao.getCount(map);
	}

	@Override
	public List<Qiugouxinxi> select(Map<String, Object> map) {
		return gdao.select(map);
	}

	@Override
	public Qiugouxinxi getById(int id) {
		return gdao.selectByPrimaryKey(id);
	}

}

