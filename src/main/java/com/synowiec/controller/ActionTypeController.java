package com.synowiec.controller;

import com.synowiec.domain.ActionType;
import com.synowiec.service.interfaces.ActionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * Created by mikolaj on 18.06.17.
 */
@Controller
@RequestMapping("/action")
public class ActionTypeController {

    @Autowired
    ActionService actionService;

    @RequestMapping("actionTypeList")
    public String actionTypeList(Model model) {
        model.addAttribute("actionTypeList", actionService.getAllActionTypes());
        return "action/type/action-type-list";
    }

    @RequestMapping("newActionTypeForm")
    public String showNewActionTypeForm(Model model) {
        model.addAttribute("actionType", new ActionType());
        return "action/type/action-type-edit-form";
    }

    @RequestMapping("updateActionTypeForm")
    public String showUpdateActionTypeForm(Model model, @RequestParam("actionTypeId") long actionTypeId){
        model.addAttribute("actionType", actionService.findActionTypeById(actionTypeId));
        model.addAttribute("update", true);
        return "action/type/action-type-edit-form";
    }

    @RequestMapping("deleteActionType")
    public String processDeleteActionType(@RequestParam("actionTypeId") long actionTypeId){
        actionService.deleteActionType(actionService.findActionTypeById(actionTypeId));
        return "redirect:/action/actionTypeList";
    }

    @RequestMapping("newActionTypeProcess")
    public String processNewActionTypeForm(@ModelAttribute("actionType") ActionType actionType) {
        actionService.addActionType(actionType);
        return "redirect:/action/actionTypeList";
    }

    @RequestMapping("updateActionTypeProcess")
    public String processUpdateActionTypeForm(@ModelAttribute("actionType") ActionType actionType){
        actionService.updateActionType(actionType);
        return "redirect:/action/actionTypeList";
    }
}
