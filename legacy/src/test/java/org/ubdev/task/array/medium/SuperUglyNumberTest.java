package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SuperUglyNumberTest {

    private SuperUglyNumber solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SuperUglyNumber();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int[] primes, int expected) {
        // given

        // when
        int actual = solution.nthSuperUglyNumber(n, primes);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(12, new int[]{2,7,13,19}, 32),
                Arguments.of(1, new int[]{2,3,5}, 1)
        );
    }
}