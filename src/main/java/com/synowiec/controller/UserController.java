package com.synowiec.controller;

import com.synowiec.domain.User;
import com.synowiec.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mikolaj on 01.06.17.
 */
@Controller
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    UserService userService;

    //User methods
    @RequestMapping("/list")
    public String employeeList(Model model) {
        model.addAttribute("employeeList", userService.getAllUsers());
        return "employee/employee-list";
    }

    @RequestMapping("/newEmployeeForm")
    public String showNewEmployeeForm(Model model) {
        model.addAttribute("employee", new User());
        model.addAttribute("employeeTypeList", userService.getAllUserRoles());
        return "employee/employee-edit-form";
    }

    @RequestMapping("/updateEmployeeForm")
    public String showUpdateEmployeeForm(Model model, @RequestParam("empId") long employeeId) {
        model.addAttribute("employee", userService.findUserById(employeeId));
        model.addAttribute("employeeTypeList", userService.getAllUserRoles());
        model.addAttribute("update", true);
        return "employee/employee-edit-form";
    }

    @RequestMapping("/newEmployeeProcess")
    public String processNewEmployeeForm(@ModelAttribute("employee") User user) {
        user.setUserRole(userService.findUserRoleById((long) user.getUserRole().getId()));
        userService.addUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/updateEmployeeProcess")
    public String processUpdateEmployeeForm(@ModelAttribute("employee") User user) {
        user.setUserRole(userService.findUserRoleById((long) user.getUserRole().getId()));
        userService.updateUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/deleteEmployee")
    public String processDeleteEmployee(@RequestParam("empId") long employeeId) {
        userService.deleteUser(userService.findUserById(employeeId));
        return "redirect:/user/list";
    }

}
