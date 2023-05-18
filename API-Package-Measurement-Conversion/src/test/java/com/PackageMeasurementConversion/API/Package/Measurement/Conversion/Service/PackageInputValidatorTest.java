package com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Service;

import static org.junit.jupiter.api.Assertions.*;

import com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Model.ValidationResponse;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PackageInputValidatorTest {
    private PackageInputValidator validator;

    @BeforeEach
    public void setUp() {
        validator = new PackageInputValidator();
    }

    @Test
    public void testValidateInput_ValidInput() {
        String input = "abc_def";
        ValidationResponse response = validator.validateInput(input);
        assertTrue(response.isValid());
        assertNull(response.getErrorMessage());
    }

    @Test
    public void testValidateInput_NullInput() {
        String input = null;
        ValidationResponse response = validator.validateInput(input);
        assertFalse(response.isValid());
        assertEquals("Invalid input.", response.getErrorMessage());
    }

    @Test
    public void testValidateInput_SingleCharacterInput() {
        String input = "a";
        ValidationResponse response = validator.validateInput(input);
        assertFalse(response.isValid());
        assertEquals("Invalid input.", response.getErrorMessage());
    }

    @Test
    public void testValidateInput_InvalidCharacterInput() {
        String input = "abc123";
        ValidationResponse response = validator.validateInput(input);
        assertFalse(response.isValid());
        assertEquals("Invalid input.", response.getErrorMessage());
    }
}