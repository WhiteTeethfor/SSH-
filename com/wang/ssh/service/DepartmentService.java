package com.wang.ssh.service;

import com.wang.ssh.dao.DepartmentDao;
import com.wang.ssh.entities.Department;

import java.util.List;

public class DepartmentService {
    private DepartmentDao departmentDao;

    public void setDepartmentDao(DepartmentDao departmentDao) {
        this.departmentDao = departmentDao;
    }

    public List<Department> getAll(){
        return departmentDao.getAll();
    }
}
