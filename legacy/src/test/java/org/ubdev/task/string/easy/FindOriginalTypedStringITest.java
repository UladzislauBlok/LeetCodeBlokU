package org.ubdev.task.string.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindOriginalTypedStringITest {

    private FindOriginalTypedStringI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindOriginalTypedStringI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String word, int expected) {
        // given

        // when
        int actual = solution.possibleStringCount(word);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("abbcccc", 5),
                Arguments.of("abcd", 1),
                Arguments.of("aaaa", 4)
        );
    }
}