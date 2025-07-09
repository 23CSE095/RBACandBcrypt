package com.example.internship.Service;

import com.example.internship.models.Employee;
import com.example.internship.repository.Employeerepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class employeeService {
    @Autowired
    Employeerepo emprepo;// bean or object is a emprepo


    public List<Employee> getMethod() {
        return  emprepo.findAll();
    }
    public Employee getemployeeId(int empid) {
        return emprepo.findById(empid).orElse(new Employee());
    }

    public List<Employee> getemployeejob(String job) {

        return emprepo.findByJob(job);

    }
    public String addemployee(Employee employee) {
        emprepo.save(employee);
        return " employee added successfully";
    }

    public String updateemployee(Employee employee) {
        emprepo.save(employee);
        return " Employee updated  successfully";
    }

    public String deleteemployee(int empid) {
        emprepo.deleteById(empid);
        return "employee deleted successfully";
    }


//    public String deleteemployees() {
//        emprepo.deleteAll();
//        return "deleted all employees detail";
//    }




//    public List<Employee> getMethod() {
//        return emp;
//    }
//
//    public Employee getemployeeId(int empid) {
//        int index = 0;
//        boolean flag = false;
//        for (int i = 0; i < emp.size(); i++) {
//            if (empid == emp.get(i).getEmpid()) {
//                System.out.println("Emp_Id" + emp.get(i).getEmpid() + emp.get(i));
//                index = i;
//                flag = true;
//                break;
//            }
//        }
//        if (flag) {
//            return emp.get(index);
//        } else {
//            return new Employee();
//        }
//    }
//
//    public String postMethod(Employee employee) {
//        emp.add(employee);
//        String s = "created successfully";
//        return s;
//    }
//
////    public String putMethod() {
////        return "This is Put Method";
////    }
//
//    //
//    public String deleteemployeeId(int empid) {
//        int index = 0;
//        boolean flag = false;
//        for (int i = 0; i < emp.size(); i++) {
//            if (empid == emp.get(i).getEmpid()) {
//                System.out.println("Emp_Id" + emp.get(i).getEmpid() + emp.get(i));
//                index = i;
//                flag = true;
//                break;
//            }
//        }
//        if (flag) {
//            emp.remove(index);
//            return "employeeid deleted";
//        } else {
//            return "not found id";
//        }
//    }
//
//    public String updateemployee(Employee employee) {
//        int index = 0;
//        boolean flag = false;
//        for (int i = 0; i < emp.size(); i++) {
//            if (employee.getEmpid() == emp.get(i).getEmpid()) {
//                System.out.println("Emp_Id" + emp.get(i).getEmpid() + emp.get(i));
//                index = i;
//                flag = true;
//                break;
//            }
//        }
//        if (flag) {
//            emp.set(index,employee);
//            return "successfully updated";
//        } else {
//            return "not found id";
//        }
//    }
    }





