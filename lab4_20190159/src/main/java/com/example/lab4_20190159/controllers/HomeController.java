package com.example.lab4_20190159.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HomeController {

    @RequestMapping(value = "/",method = RequestMethod.GET)
    public String paginaPrincipal(){
        return "index";
    }

    @RequestMapping(value = {"/empleado1","/employee1","/em1"})
    public String empleado(){
        return "pag1";
    }
}
