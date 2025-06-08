package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Shuiguoleibie;

public interface ShuiguoleibieServer {

  public int add(Shuiguoleibie po);

  public int update(Shuiguoleibie po);
  
  
  
  public int delete(int id);

  public List<Shuiguoleibie> getAll(Map<String,Object> map);
  public List<Shuiguoleibie> getsyshuiguoleibie1(Map<String,Object> map);
  public List<Shuiguoleibie> getsyshuiguoleibie2(Map<String,Object> map);
  public List<Shuiguoleibie> getsyshuiguoleibie3(Map<String,Object> map);
  public Shuiguoleibie quchongShuiguoleibie(Map<String, Object> acount);

  public Shuiguoleibie getById( int id);

  public List<Shuiguoleibie> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Shuiguoleibie> select(Map<String, Object> map);
}
//	所有List
