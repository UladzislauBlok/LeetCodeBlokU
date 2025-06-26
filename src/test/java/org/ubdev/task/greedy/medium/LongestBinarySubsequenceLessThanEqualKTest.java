package org.ubdev.task.greedy.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestBinarySubsequenceLessThanEqualKTest {

    private LongestBinarySubsequenceLessThanEqualK solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LongestBinarySubsequenceLessThanEqualK();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String input, int k, int expected) {
        // given

        // when
        int actual = solution.longestSubsequence(input, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("1001010", 5, 5),
                Arguments.of("00101001", 1, 6)
        );
    }
}