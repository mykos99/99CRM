package com.synowiec.controller;

import com.synowiec.domain.Address;
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
public class CustomerAddressController {

    @Autowired
    CustomerService customerService;

    @RequestMapping("/addressList")
    public String addressList(Model model){
        model.addAttribute("addressList", customerService.getAllAddresses());
        return "customer/address/address-list";
    }

    @RequestMapping("/newAddressForm")
    public String showNewAddressForm(Model model) {
        model.addAttribute("address", new Address());
        return "customer/address/address-edit-form";
    }

    @RequestMapping("updateAddressForm")
    public String showUpdateAddressForm(Model model, @RequestParam("addressId") long addressId) {
        model.addAttribute("address", customerService.findAddressById(addressId));
        model.addAttribute("update", true);
        return "customer/address/address-edit-form";
    }

    @RequestMapping("newAddressProcess")
    public String processNewAddressForm(@ModelAttribute("address") Address address) {
        customerService.addAddress(address);
        return "redirect:/customer/addressList";
    }

    @RequestMapping("updateAddressProcess")
    public String processUpdateAddressForm(@ModelAttribute("address") Address address) {
        customerService.updateAddress(address);
        return "redirect:/customer/addressList";
    }

    @RequestMapping("deleteAddress")
    public String processDeleteAddress(@RequestParam("addressId") long addressId) {
        customerService.deleteAddress(customerService.findAddressById(addressId));
        return "redirect:/customer/addressList";
    }
}
