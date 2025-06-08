package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shuiguoxinxi;

public interface ShuiguoxinxiServer {

  public int add(Shuiguoxinxi po);

  public int update(Shuiguoxinxi po);
  
  
  
  public int delete(int id);

  public List<Shuiguoxinxi> getAll(Map<String,Object> map);
  public List<Shuiguoxinxi> getsyshuiguoxinxi1(Map<String,Object> map);
  public List<Shuiguoxinxi> getsyshuiguoxinxi2(Map<String,Object> map);
  public List<Shuiguoxinxi> getsyshuiguoxinxi3(Map<String,Object> map);
  public Shuiguoxinxi quchongShuiguoxinxi(Map<String, Object> acount);

  public Shuiguoxinxi getById( int id);

  public List<Shuiguoxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shuiguoxinxi> select(Map<String, Object> map);
}
//	所有List
