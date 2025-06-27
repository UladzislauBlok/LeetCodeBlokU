package org.ubdev.task.backtracking.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestSubsequenceRepeatedKTimesTest {

    private LongestSubsequenceRepeatedKTimes solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LongestSubsequenceRepeatedKTimes();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String s, int k, String expected) {
        // given

        // when
        String actual = solution.longestSubsequenceRepeatedK(s, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("letsleetcode", 2, "let"),
                Arguments.of("bb", 2, "b"),
                Arguments.of("ab", 2, "")
        );
    }
}