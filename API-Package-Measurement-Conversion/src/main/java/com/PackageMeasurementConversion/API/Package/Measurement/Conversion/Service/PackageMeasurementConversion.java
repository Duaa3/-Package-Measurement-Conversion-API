package com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@Service
public class PackageMeasurementConversion {
    @Autowired
    private PackageInputValidator packageInputValidator; // Autowired package input validator bean
    private static final Logger logger = LoggerFactory.getLogger(PackageMeasurementConversion.class); // Logger for logging information

    public static void main(String[] args) {
        logger.info("Starting the application");
        String input = "dz_a_aazzaaa";

        List<Integer> packageMeasured = packageMeasured(convertString(input)); // Measure the package using the converted string
        logger.info("Package measured: {}", packageMeasured); // Log the measured package
    }

    public static int[] convertString(String input) {
        logger.debug("Converting string: {}", input);
        List<Integer> resultList = new ArrayList<>(); // List to hold the converted numbers
        int valueOfCount = 0; // Counter value for 'z' character

        for (int i = 0; i < input.length(); i++) {
            char currentChar = input.charAt(i);
            if (currentChar == 'z') {
                valueOfCount++;
                continue;
            }

            if (valueOfCount > 0) {
                int value = valueOfCount * 26;
                if (currentChar == '_') {
                    resultList.add(value);
                } else {
                    resultList.add(value + (currentChar - 'a' + 1));
                }
                valueOfCount = 0;
            } else {
                if (currentChar == '_') {
                    resultList.add(0);
                } else {
                    resultList.add(currentChar - 'a' + 1);
                }
            }
        }

        int[] numbers = new int[resultList.size()];
        for (int i = 0; i < resultList.size(); i++) {
            numbers[i] = resultList.get(i);
        }

        logger.debug("Converted string: {}", numbers); // Log the converted numbers
        return numbers; // Return the array of converted numbers
    }

    public static List<Integer> packageMeasured(int[] result) {
        logger.debug("Calculating package measurements");
        List<Integer> packageMeasured = new ArrayList<>(); // List to hold the package measurements
        if (result.length == 0) {
            return packageMeasured;
        }

        int counterValue = result[0];
        if (counterValue == 0) {
            packageMeasured.add(0);
            return packageMeasured;
        }

        for (int i = 1; i < result.length; i++) {
            int sum = 0;
            while (counterValue > 0 && i < result.length) {
                sum += result[i];
                counterValue--;
                i++;
            }
            packageMeasured.add(sum);
            if (i < result.length) {
                counterValue = result[i];
            }
        }

        logger.debug("Package measurements: {}", packageMeasured); // Log the package measurements
        return packageMeasured; // Return the list of package measurements
    }
}
