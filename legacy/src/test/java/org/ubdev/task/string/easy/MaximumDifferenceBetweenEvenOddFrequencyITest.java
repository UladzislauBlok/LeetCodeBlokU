package org.ubdev.task.string.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDifferenceBetweenEvenOddFrequencyITest {

    private MaximumDifferenceBetweenEvenOddFrequencyI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumDifferenceBetweenEvenOddFrequencyI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String input, int expected) {
        // given

        // when
        int actual = solution.maxDifference(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("aaaaabbc", 3),
                Arguments.of("abcabcab", 1)
        );
    }
}