package com.lanouette.oddNumbers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> oddNumbersParams() {
        return Stream.of(
                Arguments.of(2, 5, Arrays.asList(3, 5)),
                Arguments.of(1, 5, Arrays.asList(1, 3, 5))
        );
    }

    private static Stream<Arguments> isOddParams() {
        return Stream.of(
                Arguments.of(-1, true),
                Arguments.of(1, true),
                Arguments.of(3, true),
                Arguments.of(2, false),
                Arguments.of(0, false),
                Arguments.of(-2, false)
        );
    }

    @ParameterizedTest(name = "#{index} - [{0}, {1}] -> {2}")
    @MethodSource("oddNumbersParams")
    void oddNumbers(int l, int r, List<Integer> expected) {
        var results = Result.oddNumbers(l, r);
        assertEquals(expected.size(), results.size());
        for (int i = 0; i < expected.size(); i++) {
            assertEquals(expected.get(i), results.get(i));
        }
    }

    @ParameterizedTest(name = "#{index} - {0} -> {1}")
    @MethodSource("isOddParams")
    void isOdd(int i, boolean expected) {
        assertEquals(expected, Result.isOdd(i));

    }
}