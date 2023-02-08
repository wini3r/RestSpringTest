package com.wini3r.restspringtest.controller;

import com.wini3r.restspringtest.dao.CarrierDao;
import com.wini3r.restspringtest.model.Carrier;
import com.wini3r.restspringtest.util.BindingResultUtil;
import com.wini3r.restspringtest.validator.CarrierValidator;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/carriers", produces = MediaType.APPLICATION_JSON_VALUE)
public class CarrierController {

    private final CarrierDao carrierDao;
    private final CarrierValidator carrierValidator;

    @Autowired
    public CarrierController(CarrierDao carrierDao, CarrierValidator carrierValidator) {
        this.carrierDao = carrierDao;
        this.carrierValidator = carrierValidator;
    }

    @GetMapping
    public List<Carrier> selectAll() {
        return carrierDao.selectAll();
    }

    @GetMapping(value = "/{id}")
    public Carrier select(@PathVariable long id) {
        return carrierDao.select(id);
    }

    @PostMapping
    public ResponseEntity<String> insertOrUpdate(@Valid Carrier carrier, BindingResult result) {
        carrierValidator.validate(carrier, result);
        // валидацию с "javax.validation.constraints" не удалось натсроить 
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

    /**
     * Не разобрался с методом PATCH. При вызове через ajax в контроллер
     * приходит объект Carrier, где заполнен только ID, а остальные поля null.
     */
    @PatchMapping(value = "/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void update(Carrier carrier, @PathVariable long id) {
        carrierDao.update(carrier);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(value = HttpStatus.NO_CONTENT)
    public void delete(@PathVariable long id) {
        carrierDao.delete(id);
    } 

}
