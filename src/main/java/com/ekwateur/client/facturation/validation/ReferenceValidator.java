package com.ekwateur.client.facturation.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ReferenceValidator implements ConstraintValidator<ValidReference, String> {
    private static final Pattern pattern = Pattern.compile("^EKW(\\d){8}$");
    @Override
    public boolean isValid(String reference, ConstraintValidatorContext context) {
        if(reference == null || reference.isBlank()) {
            return false;
        }
        Matcher matcher = pattern.matcher(reference);
        return matcher.matches();
    }
}
