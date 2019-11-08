package com.wang.ssh.actions;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.Preparable;
import com.wang.ssh.entities.Employee;
import com.wang.ssh.service.DepartmentService;
import com.wang.ssh.service.EmployeeService;
import org.apache.struts2.interceptor.RequestAware;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Date;
import java.util.Map;

public class EmployeeAction extends ActionSupport implements RequestAware, ModelDriven<Employee>, Preparable {
    private EmployeeService employeeService;
    private DepartmentService departmentService;

    public void setDepartmentService(DepartmentService departmentService) {
        this.departmentService = departmentService;
    }

    public void setEmployeeService(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    public String list() {
        request.put("employees", employeeService.getAll());
        return "list";
    }

    private Map<String, Object> request;

    @Override
    public void setRequest(Map<String, Object> map) {
        this.request = map;
    }

    private Integer id;

    public void setId(Integer id) {
        this.id = id;
    }

    private InputStream inputStream;

    public InputStream getInputStream() {
        return inputStream;
    }

    public String delete() {
        try {
            employeeService.delete(id);
            inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
        } catch (Exception e) {
            e.printStackTrace();
            try {

                inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
        return "ajax-success";
    }

    public String input() {
        request.put("departments", departmentService.getAll());
        return INPUT;
    }

    public void prepareInput() {
        if (id != null) {
            model = employeeService.getid(id);
        }
    }

    public String save() {
        if (id == null) {

            model.setCreateTime(new Date());
        }
        System.out.println(model);
        employeeService.SaveOrUpdate(model);
        return "success";
    }

    public void prepareSave() {
        if(id == null){
            model = new Employee();
        }else{
            model = employeeService.getid(id);
        }
    }

    private String lastName;

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String validateLastName() throws Exception {
        if (employeeService.lastNameIsValid(lastName)) {
            inputStream = new ByteArrayInputStream("1".getBytes("UTF-8"));
        } else {
            inputStream = new ByteArrayInputStream("0".getBytes("UTF-8"));
        }
        return "ajax-success";
    }

    private Employee model;

    @Override
    public Employee getModel() {

        return model;
    }

    @Override
    public void prepare() throws Exception {

    }
}
