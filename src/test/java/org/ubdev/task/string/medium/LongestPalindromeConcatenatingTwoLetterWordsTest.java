package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestPalindromeConcatenatingTwoLetterWordsTest {

    private LongestPalindromeConcatenatingTwoLetterWords solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LongestPalindromeConcatenatingTwoLetterWords();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String[] words, int expected) {
        // given

        // when
        int actual = solution.longestPalindrome(words);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new String[]{"lc","cl","gg"}, 6),
                Arguments.of(new String[]{"ab","ty","yt","lc","cl","ab"}, 8),
                Arguments.of(new String[]{"cc","ll","xx"}, 2)
        );
    }
}