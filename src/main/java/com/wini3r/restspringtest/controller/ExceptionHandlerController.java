/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wini3r.restspringtest.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

/**
 *
 * @author wini3r
 */
@ControllerAdvice
public class ExceptionHandlerController {

//    @ExceptionHandler(RuntimeException.class)
//    protected ResponseEntity<String> handleConflict(RuntimeException ex, WebRequest request) {
//        return ResponseEntity.status(HttpStatus.CONFLICT)
//                .body(getExceptionWithBr(ex));
//    }

    @ExceptionHandler(Exception.class)
    @Order(Ordered.LOWEST_PRECEDENCE)
    public ModelAndView defaultErrorHandler(HttpServletRequest request, Exception e) throws Exception {
        // не перенаправляет на страницу с ошибкой при обработке ajax запроса
        ModelAndView mav = new ModelAndView("exception/exception");
        mav.addObject("exception", e);
        mav.addObject("exceptionMessage", getExceptionWithBr(e)); 
        return mav;
    }

    private String getExceptionWithBr(Exception e) {
        return e.getMessage().replace("\n", "</br>");
    }
}
