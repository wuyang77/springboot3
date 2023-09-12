package com.wuyang.springbootopenapiswaggercrud.service;

import com.wuyang.springbootopenapiswaggercrud.entity.Dept;
import com.wuyang.springbootopenapiswaggercrud.entity.Employee;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {
  Map<Long, Employee> data = new ConcurrentHashMap<Long, Employee>();

  public void deleteEmployee(Long id) {
    data.remove(id);
  }
  public void saveEmployee(Employee employee) {
    data.put(employee.getId(), employee);
  }
  public List<Employee> getEmployees() {
    return data.values().stream().toList();
  }
  public Employee getEmployeeById(Long id) {return data.get(id);}
}
