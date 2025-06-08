package com.dao;

import java.util.List;
import java.util.Map;

import com.entity.Guonongxinxi;

public interface GuonongxinxiMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Guonongxinxi record);

    int insertSelective(Guonongxinxi record);

    Guonongxinxi selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(Guonongxinxi record);
	
    int updateByPrimaryKey(Guonongxinxi record);
	public Guonongxinxi quchongGuonongxinxi(Map<String, Object> yonghuming);
	public List<Guonongxinxi> getAll(Map<String, Object> map);
	public List<Guonongxinxi> getsyguonongxinxi1(Map<String, Object> map);
	public List<Guonongxinxi> getsyguonongxinxi3(Map<String, Object> map);
	public List<Guonongxinxi> getsyguonongxinxi2(Map<String, Object> map);
	public int getCount(Map<String, Object> po);
	public List<Guonongxinxi> getByPage(Map<String, Object> map);
	public List<Guonongxinxi> select(Map<String, Object> map);
//	所有List
}

