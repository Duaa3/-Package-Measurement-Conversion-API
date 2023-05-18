package com.PackageMeasurementConversion.API.Package.Measurement.Conversion.Service;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PackageMeasurementConversionTest {
    private PackageMeasurementConversion conversion;

    @BeforeEach
    public void setUp() {
        conversion = new PackageMeasurementConversion();
    }

    @Test
    public void testConvertString() {
        int[] result = conversion.convertString("dz_a_aazzaaa");
        int[] expected = {4, 26, 1, 0, 1, 1, 53, 1, 1};
        assertEquals(Arrays.toString(expected), Arrays.toString(result));
    }

}
