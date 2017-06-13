package com.synowiec.controller;

import com.synowiec.domain.CustomerType;
import com.synowiec.service.interfaces.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mikolaj on 07.06.17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerTypeController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("customerTypeList")
    public String CustomerTypeList(Model model){
        model.addAttribute("customerTypeList", customerService.getAllCustomerTypes());
        return "customer/type/customerType-list";
    }

    @RequestMapping("newCustomerTypeForm")
    public String showNewCustomerTypeForm(Model model) {
        model.addAttribute("customerType", new CustomerType());
        return "customer/type/customerType-edit-form";
    }

    @RequestMapping("updateCustomerTypeForm")
    public String showUpdateCustomerTypeForm(Model model, @RequestParam("customerTypeId") long customerTypeId) {
        model.addAttribute("customerType", customerService.findCustomerTypeById(customerTypeId));
        model.addAttribute("update", true);
        return "customer/type/customerType-edit-form";
    }

    @RequestMapping("newCustomerTypeProcess")
    public String processNewCustomerTypeForm(@ModelAttribute("customerType") CustomerType customerType) {
        customerService.addCustomerType(customerType);
        return "redirect:/customer/customerTypeList";
    }

    @RequestMapping("updateCustomerTypeProcess")
    public String processUpdateCustomerTypeForm(@ModelAttribute("customerType") CustomerType customerType) {
        customerService.updateCustomerType(customerType);
        return "redirect:/customer/customerTypeList";
    }

    @RequestMapping("deleteCustomerType")
    public String processDeleteCustomerType(@RequestParam("customerTypeId") long customerTypeId) {
        customerService.deleteCustomerType(customerService.findCustomerTypeById(customerTypeId));
        return "redirect:/customer/customerTypeList";
    }
    
}
