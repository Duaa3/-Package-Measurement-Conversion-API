package com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Model;
import java.util.List;

public class PackageMeasureResponse {
    private List<Integer> packageMeasured; // List to hold the measured package

    public List<Integer> getPackageMeasured() {
        return packageMeasured; // Getter method to retrieve the measured package
    }

    public void setPackageMeasured(List<Integer> packageMeasured) {
        this.packageMeasured = packageMeasured; // Setter method to set the measured package
    }
}

