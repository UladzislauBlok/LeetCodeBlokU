package org.ubdev.task.math.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FactorialTrailingZeroesTest {

    private FactorialTrailingZeroes solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FactorialTrailingZeroes();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int expected) {
        // given

        // when
        int actual = solution.trailingZeroes(n);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(13, 2),
                Arguments.of(3, 0),
                Arguments.of(5, 1),
                Arguments.of(0, 0)
        );
    }
}