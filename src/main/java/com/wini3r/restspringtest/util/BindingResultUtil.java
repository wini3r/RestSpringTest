package com.wini3r.restspringtest.util;

import org.springframework.validation.BindingResult;

public class BindingResultUtil {

    public static String getHtmlErrors(BindingResult result) {
        StringBuilder sb = new StringBuilder();
        result.getFieldErrors().forEach(r -> sb.append(r.getField())
                .append(": ")
                .append(r.getDefaultMessage())
                .append("</br>")
        );
        return sb.toString();
    }
}
