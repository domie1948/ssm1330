package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Shuiguoleibie;

public interface ShuiguoleibieMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Shuiguoleibie record);

    int insertSelective(Shuiguoleibie record);

    Shuiguoleibie selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Shuiguoleibie record);
	
    int updateByPrimaryKey(Shuiguoleibie record);
	public Shuiguoleibie quchongShuiguoleibie(Map<String, Object> leibie);
	public List<Shuiguoleibie> getAll(Map<String, Object> map);
	public List<Shuiguoleibie> getsyshuiguoleibie1(Map<String, Object> map);
	public List<Shuiguoleibie> getsyshuiguoleibie3(Map<String, Object> map);
	public List<Shuiguoleibie> getsyshuiguoleibie2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Shuiguoleibie> getByPage(Map<String, Object> map);
	public List<Shuiguoleibie> select(Map<String, Object> map);
//	所有List
}

