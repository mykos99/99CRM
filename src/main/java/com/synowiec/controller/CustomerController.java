package com.synowiec.controller;

import com.synowiec.domain.Address;
import com.synowiec.domain.Customer;
import com.synowiec.service.interfaces.CustomerService;
import com.synowiec.service.interfaces.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mikolaj on 08.06.17.
 */
@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;
    @Autowired
    EmployeeService employeeService;

    @RequestMapping("list")
    public String customerList(Model model) {
        model.addAttribute("customerList", customerService.getAllCustomers());
        return "customer/customer-list";
    }

    @RequestMapping("newCustomerForm")
    public String showNewCustomerForm(Model model) {
        model.addAttribute("customer", new Customer());
        model.addAttribute("customerTypeList", customerService.getAllCustomerTypes());
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        return "customer/customer-edit-form";
    }

    @RequestMapping("updateCustomerForm")
    public String showUpdateCustomerForm(Model model, @RequestParam("customerId") long customerId) {
        model.addAttribute("customer", customerService.findCustomerById(customerId));
        model.addAttribute("customerTypeList", customerService.getAllCustomerTypes());
        model.addAttribute("employeeList", employeeService.getAllEmployees());
        model.addAttribute("update", true);
        return "customer/customer-edit-form";
    }

    @RequestMapping("newCustomerProcess")
    public String processNewCustomerForm(@ModelAttribute("customer") Customer customer) {
//        System.out.println(customer);
        //I have added customer.setSalesman to the customerService, should look for them later
        // and check if all instructions are working correctly (look for addCustomer method)
        //maybe it is neccesary to check if for ex. salesman, cutomerType are in the databese first, if not
        //should add them and finally persist the customer.
        customerService.addCustomer(customer);
        return "redirect:/customer/list";
    }

    @RequestMapping("updateCustomerProcess")
    public String processUpdateCustomerForm(@ModelAttribute("customer") Customer customer) {
//        System.out.println(customer);
        customerService.updateCustomer(customer);
        return "redirect:/customer/list";
    }

    @RequestMapping("deleteCustomer")
    public String processDeleteCustomer(@RequestParam("customerId") long customerId) {
        customerService.deleteCustomer(customerService.findCustomerById(customerId));
        return "redirect:/customer/list";
    }

}
