package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ReverseWordsInStringTest {

    private ReverseWordsInString solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ReverseWordsInString();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String input, String expected) {
        // given

        // when
        String actual = solution.reverseWords(input);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("the sky is blue", "blue is sky the"),
                Arguments.of("  hello world  ", "world hello"),
                Arguments.of("a good   example", "example good a")
        );
    }
}