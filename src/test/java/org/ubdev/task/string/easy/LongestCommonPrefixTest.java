package org.ubdev.task.string.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestCommonPrefixTest {

    private LongestCommonPrefix solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LongestCommonPrefix();
    }

    @ParameterizedTest
    @MethodSource
    void strStrReturnsExpectedResult(String[] input, String expected) {
        // given

        // when
        String actual = solution.longestCommonPrefix(input);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> strStrReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new String[]{"flower","flow","flight"}, "fl"),
                Arguments.of(new String[]{"dog","racecar","car"}, "")
        );
    }
}