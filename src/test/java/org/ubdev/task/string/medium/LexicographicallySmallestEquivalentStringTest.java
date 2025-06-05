package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LexicographicallySmallestEquivalentStringTest {

    private LexicographicallySmallestEquivalentString solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LexicographicallySmallestEquivalentString();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String s1,String s2, String baseStr, String expected) {
        // given

        // when
        String actual = solution.smallestEquivalentString(s1, s2, baseStr);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("parker", "morris", "parser", "makkek"),
                Arguments.of("hello", "world", "hold", "hdld"),
                Arguments.of("leetcode", "programs", "sourcecode", "aauaaaaada")
        );
    }
}