package org.ubdev.task.dynamic.programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InterleavingStringTest {

    private InterleavingString solution;

    @BeforeEach
    public void setUp() {
        this.solution = new InterleavingString();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String s1, String s2, String s3, boolean expected) {
        // given

        // when
        boolean actual = solution.isInterleave(s1, s2, s3);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("a", "", "a", true),
                Arguments.of("aabccccc", "dbbca", "aadbbcbcacccc", true),
                Arguments.of("aabcc", "dbbca", "aadbbbaccc", false),
                Arguments.of("", "", "", true)
        );
    }
}