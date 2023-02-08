package com.wini3r.restspringtest.controller;

import com.wini3r.restspringtest.dao.CarrierDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    @Autowired
    private CarrierDao carrierDao;

    @GetMapping("/")
    public String home() {
        return "redirect:/journal";
    }

    @GetMapping("/journal")
    public String journal(Model model) {
        // Оставил в качестве примера использования JSP. Таблица обновляется через ajax
        model.addAttribute("carriers", carrierDao.selectAll());
        return "index";
    }

}
