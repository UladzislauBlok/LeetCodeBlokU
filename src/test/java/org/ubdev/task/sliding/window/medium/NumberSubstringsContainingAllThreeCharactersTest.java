package org.ubdev.task.sliding.window.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class NumberSubstringsContainingAllThreeCharactersTest {

    private NumberSubstringsContainingAllThreeCharacters solution;

    @BeforeEach
    public void setUp() {
        this.solution = new NumberSubstringsContainingAllThreeCharacters();
    }

    @ParameterizedTest
    @MethodSource
    void minimumRecolorsReturnsExpectedResult(String s, int expected) {
        // given

        // when
        int actual = solution.numberOfSubstringsLookingRight(s);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> minimumRecolorsReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("acbbcac", 11),
                Arguments.of("abcabc", 10),
                Arguments.of("aaacb", 3),
                Arguments.of("abc", 1),
                Arguments.of("aaabb", 0)

        );
    }
}