package com.wang.ssh.dao;

import com.wang.ssh.entities.Department;

import java.util.List;

public class DepartmentDao extends BaseDao {
    public List<Department> getAll(){
        String hql="FROM Department";
        return getSession().createQuery(hql).list();
    }

}
