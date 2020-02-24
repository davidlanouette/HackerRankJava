package com.lanouette.extraLongFactorials;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.stream.Stream;

import static com.lanouette.extraLongFactorials.Solution.calculateFactorial;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SolutionTest {

    private static Stream<Arguments> calculateFactorialsParams() {
        return Stream.of(
                Arguments.of(1, BigInteger.valueOf(1)),
                Arguments.of(2, BigInteger.valueOf(2)),
                Arguments.of(3, BigInteger.valueOf(6)),
                Arguments.of(4, BigInteger.valueOf(24)),
                Arguments.of(5, BigInteger.valueOf(120)),
                Arguments.of(10, BigInteger.valueOf(3_628_800)),
                Arguments.of(12, BigInteger.valueOf(479_001_600)),
                Arguments.of(15, new BigInteger("1307674368000"))
        );
    }

    @ParameterizedTest(name = "#{index} - {0} -> {1}")
    @MethodSource("calculateFactorialsParams")
    void calculateFactorialTest(int n, BigInteger e) {
        BigInteger b = calculateFactorial(n);

        assertEquals(e, b);
    }
}