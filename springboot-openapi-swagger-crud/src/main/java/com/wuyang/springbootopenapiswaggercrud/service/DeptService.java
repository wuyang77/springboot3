package com.wuyang.springbootopenapiswaggercrud.service;

import com.wuyang.springbootopenapiswaggercrud.entity.Dept;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class DeptService {
  Map<Long, Dept> data = new ConcurrentHashMap();

  public void deleteDept(Long id) {
    data.remove(id);
  }
  public void saveDept(Dept dept) {

    data.put(dept.getId(), dept);
  }
  public List<Dept> getDepts() {
    return data.values().stream().toList();
  }
  public Dept getDeptById(Long id) {return data.get(id);}
}
