package org.ubdev.task.two.pointer.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindIndexFirstOccurrenceStringTest {

    private FindIndexFirstOccurrenceString solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindIndexFirstOccurrenceString();
    }

    @ParameterizedTest
    @MethodSource
    void strStrReturnsExpectedResult(String haystack, String needle, int expected) {
        // given

        // when
        int actual = solution.strStr(haystack, needle);

        // then
        assertEquals(expected, actual);
    }

    static Stream<Arguments> strStrReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("a", "a", 0),
                Arguments.of("hello", "ll", 2),
                Arguments.of("sadbutsad", "sad", 0),
                Arguments.of("leetcode", "leeto", -1)
        );
    }
}