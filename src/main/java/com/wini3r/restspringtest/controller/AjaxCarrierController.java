package com.wini3r.restspringtest.controller;

import com.wini3r.restspringtest.dao.CarrierDao;
import com.wini3r.restspringtest.dto.CarrierTo;
import com.wini3r.restspringtest.model.Carrier;
import com.wini3r.restspringtest.util.BindingResultUtil;
import com.wini3r.restspringtest.validator.CarrierValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/ajax/carriers", produces = MediaType.APPLICATION_JSON_VALUE)
public class AjaxCarrierController {

    private final CarrierDao carrierDao;
    private final CarrierValidator carrierValidator;

    @Autowired
    public AjaxCarrierController(CarrierDao carrierDao, CarrierValidator carrierValidator) {
        this.carrierDao = carrierDao;
        this.carrierValidator = carrierValidator;
    }

    @PostMapping
    public ResponseEntity<String> insertOrUpdate(CarrierTo carrierTo, BindingResult result) {
        Carrier carrier = carrierTo.getAsCarrier();
        carrierValidator.validate(carrier, result);
        if (result.hasErrors()) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(BindingResultUtil.getHtmlErrors(result));
        } else {
            if (carrier.getId() == null) {
                carrierDao.insert(carrier);
            } else {
                carrierDao.update(carrier);
            }
            return ResponseEntity.ok().build();
        }
    } 

}
