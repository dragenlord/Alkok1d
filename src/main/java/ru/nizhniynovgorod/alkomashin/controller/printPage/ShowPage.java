package ru.nizhniynovgorod.alkomashin.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;


@RequestMapping("/Alkoshnik")
@Controller
public class ShowPage {

    @GetMapping("/main")
    public String MainPageController(){
        return "main";
    }



}
