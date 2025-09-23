package org.ubdev.task.hashmap.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class IsomorphicStringsTest {

    private IsomorphicStrings solution;

    @BeforeEach
    public void setUp() {
        this.solution = new IsomorphicStrings();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String s, String t, boolean expected) {
        // given

        // when
        boolean actual = solution.isIsomorphic(s, t);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("badc", "baba", false),
                Arguments.of("egg", "add", true),
                Arguments.of("foo", "bar", false),
                Arguments.of("paper", "title", true)
        );
    }
}