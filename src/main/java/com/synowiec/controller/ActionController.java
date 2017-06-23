package com.synowiec.controller;

import com.synowiec.domain.Action;
import com.synowiec.service.interfaces.ActionService;
import com.synowiec.service.interfaces.CustomerService;
import com.synowiec.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by mikolaj on 19.06.17.
 */
@Controller
@SessionAttributes("yourAction")
@RequestMapping("/action")
public class ActionController {

    @Autowired
    ActionService actionService;
    @Autowired
    UserService userService;
    @Autowired
    CustomerService customerService;

    Action action;

    @RequestMapping("actionList")
    public String actionList(Model model) {
        model.addAttribute("actionList", actionService.getAllActions());
        return "action/action-list";
    }

    @RequestMapping("actionUpdateFormStart")
    public String actionUpdateFormStart(Model model) {
        this.action = new Action();
        model.addAttribute("action", this.action);
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("actionTypeList", actionService.getAllActionTypes());
        return "action/action-edit-form";
    }

    @RequestMapping("actionUpdateFormContinue")
    public String actionUpdateFormContinue(Model model) {
        model.addAttribute("action", this.action);
        model.addAttribute("userList", userService.getAllUsers());
        model.addAttribute("actionTypeList", actionService.getAllActionTypes());
        return "action/action-edit-form";
    }

    @RequestMapping("newActionFormCustomer")
    public String newActionFormCustomer(Model model) {
        model.addAttribute("customerList", customerService.getAllCustomers());
        return "action/action-form-customer";
    }

    @RequestMapping("customerSelected")
    public String customerSelected(@RequestParam("customerId") long customerId) {
        this.action.setCustomer(customerService.findCustomerById(customerId));

        //Checking if contact was already selected. If yes checking if it is associated
        //with selected customer - if not, contact need to be selected again
        if ((action.getContact().getId()>0) && (action.getCustomer().getId() != action.getContact().getCustomer().getId())) {
            return "redirect:/action/newActionFormContact?customerId="+action.getCustomer().getId();
        }
        return "redirect:/action/actionUpdateFormContinue";
    }

    @RequestMapping("newActionFormContact")
    public String newActionFormContact(Model model, @RequestParam("customerId") long customerId) {
        model.addAttribute("contactList", customerService.getCustomerContacts(customerService.findCustomerById(customerId)));
        model.addAttribute("action", this.action);
        return "action/action-form-contact";
    }

    @RequestMapping("contactSelected")
    public String contactSelected(@RequestParam("contactId") long contactId) {
        this.action.setContact(customerService.findContactById(contactId));
        return "redirect:/action/actionUpdateFormContinue";
    }

    @RequestMapping("newActionProcess")
    public String newActionProcess(@ModelAttribute("action") Action action) {
        action.setCustomer(customerService.findCustomerById(action.getCustomer().getId()));
        action.setContact(customerService.findContactById(action.getContact().getId()));
        action.setFromUser(userService.findUserById(action.getFromUser().getId()));
        action.setToUser(userService.findUserById(action.getToUser().getId()));
        action.setActionType(actionService.findActionTypeById(action.getActionType().getId()));
        actionService.addAction(action);
        return "redirect:/action/actionList";
    }

    @RequestMapping("updateAction")
    public String updateAction(@RequestParam("actionId") long actionId) {
        this.action = new Action();
        this.action = actionService.findActionById(actionId);
        return "redirect:/action/actionUpdateFormContinue";
    }

    @RequestMapping("deleteAction")
    public String deleteAction(@RequestParam("actionId") long actionId) {
        actionService.deleteAction(actionService.findActionById(actionId));
        return "redirect:/action/actionList";
    }
}
