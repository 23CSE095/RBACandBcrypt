package com.example.internship.Service;

import com.example.internship.models.Employee;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class HelloWorldService {
    List<Employee> emp;

    public HelloWorldService() {
        emp = new ArrayList<>(
                Arrays.asList(new Employee(1, "Prasath", "Trainer"),
                        new Employee(2, "Sheeran", "Singer")
                )
        );
    }


    public List<Employee> getMethod() {
        return emp;
    }

    public Employee getemployeeId(int empid) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < emp.size(); i++) {
            if (empid == emp.get(i).getEmpid()) {
                System.out.println("Emp_Id" + emp.get(i).getEmpid() + emp.get(i));
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            return emp.get(index);
        } else {
            return new Employee();
        }
    }

    public String postMethod(Employee employee) {
        emp.add(employee);
        String s = "created successfully";
        return s;
    }

//    public String putMethod() {
//        return "This is Put Method";
//    }

    //
    public String deleteemployeeId(int empid) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < emp.size(); i++) {
            if (empid == emp.get(i).getEmpid()) {
                System.out.println("Emp_Id" + emp.get(i).getEmpid() + emp.get(i));
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            emp.remove(index);
            return "employeeid deleted";
        } else {
            return "not found id";
        }
    }

    public String updateemployee(Employee employee) {
        int index = 0;
        boolean flag = false;
        for (int i = 0; i < emp.size(); i++) {
            if (employee.getEmpid() == emp.get(i).getEmpid()) {
                System.out.println("Emp_Id" + emp.get(i).getEmpid() + emp.get(i));
                index = i;
                flag = true;
                break;
            }
        }
        if (flag) {
            emp.set(index,employee);
            return "successfully updated";
        } else {
            return "not found id";
        }
    }
    }





