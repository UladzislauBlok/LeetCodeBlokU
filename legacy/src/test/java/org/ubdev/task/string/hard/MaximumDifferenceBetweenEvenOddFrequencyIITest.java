package org.ubdev.task.string.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumDifferenceBetweenEvenOddFrequencyIITest {

    private MaximumDifferenceBetweenEvenOddFrequencyII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumDifferenceBetweenEvenOddFrequencyII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String s, int k, int expected) {
        // given

        // when
        int actual = solution.maxDifference(s, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("12233", 4, -1),
                Arguments.of("1122211", 3, 1),
                Arguments.of("110", 3, -1)
        );
    }
}