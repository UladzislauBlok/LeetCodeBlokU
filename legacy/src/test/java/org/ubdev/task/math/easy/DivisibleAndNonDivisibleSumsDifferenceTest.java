package org.ubdev.task.math.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DivisibleAndNonDivisibleSumsDifferenceTest {

    private DivisibleAndNonDivisibleSumsDifference solution;

    @BeforeEach
    public void setUp() {
        this.solution = new DivisibleAndNonDivisibleSumsDifference();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int m, int expected) {
        // given

        // when
        int actual = solution.differenceOfSums(n, m);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(10, 3, 19),
                Arguments.of(5, 6, 15),
                Arguments.of(5, 1, -15)
        );
    }
}