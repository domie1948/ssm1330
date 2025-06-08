package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shuiguoxinxi;

public interface ShuiguoxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shuiguoxinxi record);

    int insertSelective(Shuiguoxinxi record);

    Shuiguoxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shuiguoxinxi record);
	
    int updateByPrimaryKey(Shuiguoxinxi record);
	public Shuiguoxinxi quchongShuiguoxinxi(Map<String, Object> yonghuming);
	public List<Shuiguoxinxi> getAll(Map<String, Object> map);
	public List<Shuiguoxinxi> getsyshuiguoxinxi1(Map<String, Object> map);
	public List<Shuiguoxinxi> getsyshuiguoxinxi3(Map<String, Object> map);
	public List<Shuiguoxinxi> getsyshuiguoxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shuiguoxinxi> getByPage(Map<String, Object> map);
	public List<Shuiguoxinxi> select(Map<String, Object> map);
//	所有List
}

