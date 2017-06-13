package com.synowiec.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by mikolaj on 06.06.17.
 */
@Controller
public class MainController {

    @RequestMapping("/")
    public String mainPage() {
        return "main-menu";
    }

}
