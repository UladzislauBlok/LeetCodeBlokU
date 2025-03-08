package org.ubdev.task.math.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ClosestPrimeNumbersRangeTest {

    private ClosestPrimeNumbersRange solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ClosestPrimeNumbersRange();
    }

    @ParameterizedTest
    @MethodSource
    void closestPrimesReturnsExpectedResult(int left, int right, int[] expected) {
        // given

        // when
        int[] actual = solution.closestPrimes(left, right);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> closestPrimesReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(10, 19, new int[]{11, 13}),
                Arguments.of(4, 6, new int[]{-1, -1})
        );
    }
}