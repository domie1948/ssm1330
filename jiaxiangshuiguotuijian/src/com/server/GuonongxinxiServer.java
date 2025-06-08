package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Guonongxinxi;

public interface GuonongxinxiServer {

  public int add(Guonongxinxi po);

  public int update(Guonongxinxi po);
  
  
  
  public int delete(int id);

  public List<Guonongxinxi> getAll(Map<String,Object> map);
  public List<Guonongxinxi> getsyguonongxinxi1(Map<String,Object> map);
  public List<Guonongxinxi> getsyguonongxinxi2(Map<String,Object> map);
  public List<Guonongxinxi> getsyguonongxinxi3(Map<String,Object> map);
  public Guonongxinxi quchongGuonongxinxi(Map<String, Object> acount);

  public Guonongxinxi getById( int id);

  public List<Guonongxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Guonongxinxi> select(Map<String, Object> map);
}
//	所有List
