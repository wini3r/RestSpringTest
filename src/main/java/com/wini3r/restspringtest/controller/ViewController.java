package com.wini3r.restspringtest.controller;

import com.wini3r.restspringtest.dao.CarrierDao;
import com.wini3r.restspringtest.dao.CountryDao;
import com.wini3r.restspringtest.dao.TaxSystemDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {

    private final CarrierDao carrierDao;
    private final CountryDao countryDao;
    private final TaxSystemDao taxSystemDao;

    @Autowired
    public ViewController(CarrierDao carrierDao, CountryDao countryDao, TaxSystemDao taxSystemDao) {
        this.carrierDao = carrierDao;
        this.countryDao = countryDao;
        this.taxSystemDao = taxSystemDao;
    }

    @GetMapping("/")
    public String home() {
        return "redirect:/journal";
    }

    @GetMapping("/journal")
    public String journal(Model model) { 
        model.addAttribute("carriers", carrierDao.selectAll());
        model.addAttribute("countries", countryDao.selectAll());
        model.addAttribute("taxSystems", taxSystemDao.selectAll());
        return "carriers";
    }
    
    @GetMapping("/countries")
    public String countries(Model model) {  
        model.addAttribute("countries", countryDao.selectAll()); 
        return "countries";
    }
    
    @GetMapping("/taxSystems")
    public String taxSystems(Model model) {  
        model.addAttribute("taxSystems", taxSystemDao.selectAll()); 
        return "taxSystems";
    }

}
