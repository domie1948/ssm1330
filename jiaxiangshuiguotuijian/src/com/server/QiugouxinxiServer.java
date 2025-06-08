package com.server;

import java.util.List;

import java.util.Map;

import com.entity.Qiugouxinxi;

public interface QiugouxinxiServer {

  public int add(Qiugouxinxi po);

  public int update(Qiugouxinxi po);
  
  
  
  public int delete(int id);

  public List<Qiugouxinxi> getAll(Map<String,Object> map);
  public List<Qiugouxinxi> getsyqiugouxinxi1(Map<String,Object> map);
  public List<Qiugouxinxi> getsyqiugouxinxi2(Map<String,Object> map);
  public List<Qiugouxinxi> getsyqiugouxinxi3(Map<String,Object> map);
  public Qiugouxinxi quchongQiugouxinxi(Map<String, Object> acount);

  public Qiugouxinxi getById( int id);

  public List<Qiugouxinxi> getByPage(Map<String, Object> map);

  public int getCount(Map<String,Object> map);

  public List<Qiugouxinxi> select(Map<String, Object> map);
}
//	所有List
