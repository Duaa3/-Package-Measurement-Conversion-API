package com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Service;

import com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Model.ValidationResponse;
import org.springframework.stereotype.Component;

@Component
public class PackageInputValidator {

    public ValidationResponse validateInput(String input) {
        // Check if the input is null, empty, or contains invalid characters
        if (input == null || input.length() == 1 || !input.matches("[a-z_]+")) {
            return new ValidationResponse(false, "Invalid input."); // Return a new ValidationResponse object with false validity and an error message
        }
        return new ValidationResponse(true, null); // Return a new ValidationResponse object with true validity and no error message
    }
}


