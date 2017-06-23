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
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    //User methods
    @RequestMapping("/list")
    public String userList(Model model) {
        model.addAttribute("userList", userService.getAllUsers());
        return "user/user-list";
    }

    @RequestMapping("/newUserForm")
    public String showNewUserForm(Model model) {
        model.addAttribute("user", new User());
        model.addAttribute("userRoleList", userService.getAllUserRoles());
        return "user/user-edit-form";
    }

    @RequestMapping("/updateUserForm")
    public String showUpdateUserForm(Model model, @RequestParam("userId") long userId) {
        model.addAttribute("user", userService.findUserById(userId));
        model.addAttribute("userRoleList", userService.getAllUserRoles());
        model.addAttribute("update", true);
        return "user/user-edit-form";
    }

    @RequestMapping("/newUserProcess")
    public String processNewUserForm(@ModelAttribute("user") User user) {
        user.setUserRole(userService.findUserRoleById((long) user.getUserRole().getId()));
        userService.addUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/updateUserProcess")
    public String processUpdateUserForm(@ModelAttribute("user") User user) {
        user.setUserRole(userService.findUserRoleById((long) user.getUserRole().getId()));
        userService.updateUser(user);
        return "redirect:/user/list";
    }

    @RequestMapping("/deleteUser")
    public String processDeleteUser(@RequestParam("userId") long userId) {
        userService.deleteUser(userService.findUserById(userId));
        return "redirect:/user/list";
    }

}
