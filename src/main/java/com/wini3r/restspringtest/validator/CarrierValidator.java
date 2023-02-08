package com.wini3r.restspringtest.validator;

import com.wini3r.restspringtest.model.Carrier;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CarrierValidator implements Validator {
 
    @Override
    public boolean supports(Class<?> clazz) {
        return clazz == Carrier.class;
    }

    @Override
    public void validate(Object target, Errors errors) {
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "name", "carrier.name.empty", "Поле НАЗВАНИЕ не должно быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "inn", "carrier.inn.empty", "Поле ИНН не должно быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "regAddress", "carrier.regAddress.empty", "Поле АДРЕС не должно быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "country", "carrier.country.empty", "Поле СТРАНА не должно быть пустым");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors, "taxSystem", "carrier.taxSystem.empty", "Поле НАЛОГООБЛОЖЕНИЕ не должно быть пустым");

        Carrier carrier = (Carrier) target;
        textSize(errors, carrier.getName(), "name", "НАЗВАНИЕ", 0, 90);
        textSize(errors, carrier.getInn(), "inn", "ИНН", 0, 12);
        textSize(errors, carrier.getRegAddress(), "regAddress", "АДРЕС", 0, 255);
        // textSize(errors, carrier.getCountry(), "country", "СТРАНА", 0, 90); 
    }

    private void textSize(Errors errors, String value, String field, String name, int min, int max) {
        if (testSize(value, min, max)) {
            errors.rejectValue(
                    field,
                    String.format("carrier.%s.size", name),
                    String.format("Размер поля %s должен быть от %d до %d символов", name, min, max)
            );
        }
    }

    private boolean testSize(String value, int min, int max) {
        return value != null && (value.length() < min || value.length() > max);
    }

}
