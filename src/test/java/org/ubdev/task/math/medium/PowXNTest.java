package org.ubdev.task.math.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PowXNTest {

    private PowXN solution;

    @BeforeEach
    public void setUp() {
        this.solution = new PowXN();
    }

    @ParameterizedTest
    @MethodSource
    void coloredCellsOfThreeReturnsExpectedResult(double x, int n, double expected) {
        // given

        // when
        double actual = solution.myPow(x, n);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> coloredCellsOfThreeReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(2.00000, 10, 1024.00000),
                Arguments.of(2.1, 3, 9.261),
                Arguments.of(2.0, -2, 0.25)
        );
    }
}