package com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Controller;

import com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Model.PackageMeasureResponse;
import com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Model.ValidationResponse;
import com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Service.PackageInputValidator;
import com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Service.PackageMeasurementConversion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "/api/measurePackage")
public class PackageController {
    @Autowired
    private PackageMeasurementConversion packageMeasurementConversion; // Autowired package measurement conversion bean

    @Autowired
    private PackageInputValidator packageInputValidator; // Autowired package input validator bean

    @GetMapping("/convert-measurements")
    public ResponseEntity<?> measurePackage(@RequestParam("input") String input) {
        // Validate the input
        ValidationResponse validationResponse = packageInputValidator.validateInput(input); // Validate the input using the package input validator
        if (!validationResponse.isValid()) {
            return ResponseEntity.badRequest().body(validationResponse.getErrorMessage()); // Return a bad request response with the validation error message if the input is invalid
        }

        int[] convertedNumbers = packageMeasurementConversion.convertString(input); // Convert the input string to an array of numbers using the package measurement conversion
        List<Integer> packageMeasured = packageMeasurementConversion.packageMeasured(convertedNumbers); // Measure the package using the converted numbers

        PackageMeasureResponse response = new PackageMeasureResponse(); // Create a package measure response object
        response.setPackageMeasured(packageMeasured); // Set the measured package in the response object

        return ResponseEntity.ok().body(response); // Return a successful response with the package measure response object
    }
}



