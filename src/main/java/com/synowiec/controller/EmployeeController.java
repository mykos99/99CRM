package com.synowiec.controller;

import com.synowiec.domain.Employee;
import com.synowiec.domain.EmployeeType;
import com.synowiec.service.interfaces.EmployeeService;
import org.hibernate.HibernateException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikolaj on 01.06.17.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    //Employee methods
    @RequestMapping("/list")
    public String employeeList(Model model) {
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "employee/employee-list";
    }

    @RequestMapping("/newEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("employeeTypeList", employeeService.getAllEmployeeTypes());
        return "employee/employee-edit-form";
    }

    @RequestMapping("/updateEmployeeForm")
    public String showUpdateEmployeeForm(Model model, @RequestParam("empId") long employeeId) {
        model.addAttribute("employee", employeeService.findEmployeeById(employeeId));
        model.addAttribute("employeeTypeList", employeeService.getAllEmployeeTypes());
        model.addAttribute("update", true);
        return "employee/employee-edit-form";
    }

    @RequestMapping("/newEmployeeProcess")
    public String processNewEmployeeForm(@ModelAttribute("employee") Employee employee) {
        employee.setEmpType(employeeService.findEmployeeTypeById((long)employee.getEmpType().getId()));
        employeeService.addEmployee(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("/updateEmployeeProcess")
    public String processUpdateEmployeeForm(@ModelAttribute("employee") Employee employee) {
        employee.setEmpType(employeeService.findEmployeeTypeById((long)employee.getEmpType().getId()));
        employeeService.updateEmployee(employee);
        return "redirect:/employee/list";
    }

    @RequestMapping("/deleteEmployee")
    public String processDeleteEmployee(@RequestParam("empId") long employeeId) {
        employeeService.deleteEmployee(employeeService.findEmployeeById(employeeId));
        return "redirect:/employee/list";
    }

}
