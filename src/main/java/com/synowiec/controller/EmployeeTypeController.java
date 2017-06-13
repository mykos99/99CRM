package com.synowiec.controller;

import com.synowiec.domain.EmployeeType;
import com.synowiec.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mikolaj on 07.06.17.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeTypeController {

    @Autowired
    EmployeeService employeeService;

    //EmployeeType methods
    @RequestMapping("/employeeTypeList")
    public String employeeTypeList(Model model) {
        model.addAttribute("employeeTypeList", employeeService.getAllEmployeeTypes());
        return "employee/type/emptype-list";
    }

    @RequestMapping("/newEmployeeTypeForm")
    public String newEmployeeTypeForm(Model model) {
        model.addAttribute("employeeType", new EmployeeType());
        return "employee/type/emptype-edit-form";
    }

    @RequestMapping("updateEmployeeTypeForm")
    public String updateEmployeeTypeForm(Model model, @RequestParam("empTypeId") long empTypeId) {
        model.addAttribute("employeeType", employeeService.findEmployeeTypeById(empTypeId));
        model.addAttribute("update", true);
        return "employee/type/emptype-edit-form";
    }

    @RequestMapping("newEmployeeTypeProcess")
    public String processNewEmployeeTypeForm(@ModelAttribute("employeeType") EmployeeType employeeType) {
        employeeService.addEmployeeType(employeeType);
        return "redirect:/employee/employeeTypeList";
    }

    @RequestMapping("updateEmployeeTypeProcess")
    public String processUpdateEmployeeTypeForm(@ModelAttribute("employeeType") EmployeeType employeeType){
        employeeService.updateEmployeeType(employeeType);
        return "redirect:/employee/employeeTypeList";
    }

    @RequestMapping("/deleteEmployeeType")
    public String processDeleteEmployeeType(@RequestParam("empTypeId") long employeeTypeId, Model model){
        try{
            employeeService.deleteEmployeeType(employeeService.findEmployeeTypeById(employeeTypeId));
        } catch (DataIntegrityViolationException e) {
            System.out.println("Exception: "+ e);
            System.out.println("getCouse: "+ e.getCause());
            System.out.println("getMessage: "+e.getMessage());
            System.out.println("getClass: "+e.getClass());
        }
        return "redirect:/employee/employeeTypeList";
    }

}
