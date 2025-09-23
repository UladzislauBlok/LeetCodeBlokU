package org.ubdev.task.dynamic.programming.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindOriginalTypedStringIITest {

    private FindOriginalTypedStringII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindOriginalTypedStringII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String word, int k, int expected) {
        // given

        // when
        int actual = solution.possibleStringCount(word, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("aabbccdd", 7, 5),
                Arguments.of("aabbccdd", 8, 1),
                Arguments.of("aaabbb", 3, 8)
        );
    }
}