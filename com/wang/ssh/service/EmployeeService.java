package com.wang.ssh.service;

import com.wang.ssh.dao.EmployeeDao;
import com.wang.ssh.entities.Employee;

import java.util.List;

public class EmployeeService {

    private EmployeeDao employeeDao;

    public void setEmployeeDao(EmployeeDao employeeDao) {
        this.employeeDao = employeeDao;
    }
    public List<Employee> getAll(){
        return employeeDao.getAll();
    }
    public void delete(Integer id){
        employeeDao.delete(id);
    }
    public  void SaveOrUpdate(Employee employee){
        employeeDao.SaveOrUpdate(employee);
    }
    public boolean lastNameIsValid(String lastName){
        return employeeDao.getEmployeevalidateLastName(lastName)==null;
    }
    public Employee getid(Integer id){
      return   employeeDao.get(id);
    }
}
