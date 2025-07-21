package org.ubdev.task.string.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DeleteCharactersMakeFancyStringTest {

    private DeleteCharactersMakeFancyString solution;

    @BeforeEach
    public void setUp() {
        this.solution = new DeleteCharactersMakeFancyString();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String word, String expected) {
        // given

        // when
        String actual = solution.makeFancyString(word);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("leeetcode", "leetcode"),
                Arguments.of("aaabaaaa", "aabaa"),
                Arguments.of("aab", "aab")
        );
    }
}