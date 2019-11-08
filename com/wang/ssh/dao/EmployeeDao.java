package com.wang.ssh.dao;

import com.wang.ssh.entities.Employee;
import org.hibernate.Query;

import java.util.List;

public class EmployeeDao extends BaseDao {

    public List<Employee> getAll(){


String hql="From Employee e left outer join fetch e.department";

        return getSession().createQuery(hql).list();
    }
    public void delete(Integer id){
        String hql="delete from Employee e where e.id=?";
        getSession().createQuery(hql).setInteger(0,id).executeUpdate();
    }
    public void SaveOrUpdate(Employee employee){
        getSession().saveOrUpdate(employee);
    }
    public Employee getEmployeevalidateLastName(String lastName){
        String hql="from Employee e where e.lastName=?";
       Query query= getSession().createQuery(hql).setString(0,lastName);
        return (Employee) query.uniqueResult();
    }
    public Employee get(Integer id){
        return (Employee) getSession().get(Employee.class,id);
    }
}
