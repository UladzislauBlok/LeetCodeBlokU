package org.ubdev.task.math.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDifferenceRemappingDigitTest {

    private MaximumDifferenceRemappingDigit solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumDifferenceRemappingDigit();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int nun, int expected) {
        // given

        // when
        int actual = solution.minMaxDifference(nun);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(11891, 99009),
                Arguments.of(90, 99)
        );
    }
}