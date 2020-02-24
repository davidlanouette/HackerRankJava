package com.lanouette.timeConversion;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static com.lanouette.timeConversion.Solution.timeConversion;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> timeConversionParams() {
        return Stream.of(
                Arguments.of("1:02:03AM", "01:02:03"),
                Arguments.of("1:02:03PM", "13:02:03"),
                Arguments.of("10:02:03PM", "22:02:03"),
                Arguments.of("10:02:03AM", "10:02:03")
        );
    }

    @ParameterizedTest(name = "#{index} - {0} -> {1}")
    @MethodSource("timeConversionParams")
    void testTimeConversion(String input, String expected) {
        assertEquals(expected, timeConversion(input));
    }

}