package com.synowiec.controller;

import com.synowiec.domain.UserRole;
import com.synowiec.service.interfaces.UserService;
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
@RequestMapping("/user")
public class UserRoleController {

    @Autowired
    UserService userService;

    //UserRole methods
    @RequestMapping("/userRoleList")
    public String userRoleList(Model model) {
        model.addAttribute("userRoleList", userService.getAllUserRoles());
        return "user/role/userrole-list";
    }

    @RequestMapping("/newUserRoleForm")
    public String newUserRoleForm(Model model) {
        model.addAttribute("userRole", new UserRole());
        return "user/role/userrole-edit-form";
    }

    @RequestMapping("updateUserRoleForm")
    public String updateUserRoleForm(Model model, @RequestParam("userRoleId") long userRoleId) {
        model.addAttribute("userRole", userService.findUserRoleById(userRoleId));
        model.addAttribute("update", true);
        return "user/role/userrole-edit-form";
    }

    @RequestMapping("newUserRoleProcess")
    public String processNewUserRoleForm(@ModelAttribute("userRole") UserRole userRole) {
        userService.addUserRole(userRole);
        return "redirect:/user/userRoleList";
    }

    @RequestMapping("updateUserRoleProcess")
    public String processUpdateUserRoleForm(@ModelAttribute("userRole") UserRole userRole){
        userService.updateUserRole(userRole);
        return "redirect:/user/userRoleList";
    }

    @RequestMapping("/deleteUserRole")
    public String processDeleteEmployeeType(@RequestParam("userRoleId") long userRoleId, Model model){
        try{
            userService.deleteUserRole(userService.findUserRoleById(userRoleId));
        } catch (DataIntegrityViolationException e) {
            System.out.println("Exception: "+ e);
            System.out.println("getCouse: "+ e.getCause());
            System.out.println("getMessage: "+e.getMessage());
            System.out.println("getClass: "+e.getClass());
        }
        return "redirect:/user/userRoleList";
    }

}
