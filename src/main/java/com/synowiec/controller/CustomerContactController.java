package com.synowiec.controller;

import com.synowiec.domain.Contact;
import com.synowiec.service.interfaces.CustomerService;
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
public class CustomerContactController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("contactList")
    public String contactList(Model model) {
        model.addAttribute("contactList", customerService.getAllContacts());
        return "customer/contact/contact-list";
    }

    @RequestMapping("customerContactList")
    public String customerContactList(Model model, @RequestParam("customerId") long customerId) {
        System.out.println("Customer id: "+customerId);
        model.addAttribute("contactList", customerService.getCustomerContacts(customerService.findCustomerById(customerId)));
        model.addAttribute("customer", customerService.findCustomerById(customerId));
        return "customer/contact/contact-list";
    }

    @RequestMapping("newContactForm")
    public String showNewContactForm(Model model) {
        model.addAttribute("contact", new Contact());
        model.addAttribute("customers", customerService.getAllCustomers());
        return "customer/contact/contact-edit-form";
    }

    @RequestMapping("updateContactForm")
    public String showUpdateContactForm(Model model, @RequestParam("contactId") long contactId) {
        model.addAttribute("contact", customerService.findContactById(contactId));
        model.addAttribute("customers", customerService.getAllCustomers());
        model.addAttribute("update", true);
        return "customer/contact/contact-edit-form";
    }

    @RequestMapping("newContactProcess")
    public String processNewContactForm(@ModelAttribute("contact") Contact contact) {
        contact.setCustomer(customerService.findCustomerById((long)contact.getCustomer().getId()));
        customerService.addContact(contact);
        return "redirect:/customer/contactList";
    }

    @RequestMapping("updateContactProcess")
    public String processUpdateContactForm(@ModelAttribute("contact") Contact contact) {
        contact.setCustomer(customerService.findCustomerById((long)contact.getCustomer().getId()));
        customerService.updateContact(contact);
        return "redirect:/customer/contactList";
    }

    @RequestMapping("deleteContact")
    public String processDeleteContact(@RequestParam("contactId") long contactId) {
        customerService.deleteContact(customerService.findContactById(contactId));
        return "redirect:/customer/contactList";
    }




}
