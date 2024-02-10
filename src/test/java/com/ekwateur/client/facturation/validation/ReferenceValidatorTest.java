package com.ekwateur.client.facturation.validation;

import jakarta.validation.ConstraintValidatorContext;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ReferenceValidatorTest {
    private final ReferenceValidator referenceValidator = new ReferenceValidator();
    private final ConstraintValidatorContext constraintValidatorContext = mock(ConstraintValidatorContext.class);

    public static Stream<String> isNotValid_when_reference_incorrect() {
        return Stream.of(null, "", "dummy", "EKW123456789");
    }
    @ParameterizedTest
    @MethodSource
    void isNotValid_when_reference_incorrect(String reference) {

        assertFalse(referenceValidator.isValid(reference, constraintValidatorContext));
    }

    @Test
    void isValid_when_reference_correct() {
        String reference = "EKW12345678";

        assertTrue(referenceValidator.isValid(reference, constraintValidatorContext));
    }
}