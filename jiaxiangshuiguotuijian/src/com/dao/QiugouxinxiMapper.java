package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Qiugouxinxi;

public interface QiugouxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Qiugouxinxi record);

    int insertSelective(Qiugouxinxi record);

    Qiugouxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Qiugouxinxi record);
	
    int updateByPrimaryKey(Qiugouxinxi record);
	public Qiugouxinxi quchongQiugouxinxi(Map<String, Object> faburen);
	public List<Qiugouxinxi> getAll(Map<String, Object> map);
	public List<Qiugouxinxi> getsyqiugouxinxi1(Map<String, Object> map);
	public List<Qiugouxinxi> getsyqiugouxinxi3(Map<String, Object> map);
	public List<Qiugouxinxi> getsyqiugouxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Qiugouxinxi> getByPage(Map<String, Object> map);
	public List<Qiugouxinxi> select(Map<String, Object> map);
//	所有List
}

