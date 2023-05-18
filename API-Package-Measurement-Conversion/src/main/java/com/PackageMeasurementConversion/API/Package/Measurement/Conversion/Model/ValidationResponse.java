package com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Model;

public class ValidationResponse {
    private boolean valid; // Flag indicating if the validation is valid
    private String errorMessage; // Error message if the validation is invalid

    public ValidationResponse(boolean valid, String errorMessage) {
        this.valid = valid; // Constructor to create a new ValidationResponse object with the given validity and error message
        this.errorMessage = errorMessage;
    }

    public boolean isValid() {
        return valid; // Getter method to check if the validation is valid
    }

    public String getErrorMessage() {
        return errorMessage; // Getter method to retrieve the error message
    }
}

