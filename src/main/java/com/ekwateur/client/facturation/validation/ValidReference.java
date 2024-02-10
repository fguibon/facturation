package com.ekwateur.client.facturation.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.*;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target({ FIELD, ANNOTATION_TYPE, TYPE_USE })
@Retention(RUNTIME)
@Constraint(validatedBy = ReferenceValidator.class)
@Documented
public @interface ValidReference {
    String message() default "{validation.validReference}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
