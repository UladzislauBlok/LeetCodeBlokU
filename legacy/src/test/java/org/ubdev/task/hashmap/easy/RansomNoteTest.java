package org.ubdev.task.hashmap.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RansomNoteTest {

    private RansomNote solution;

    @BeforeEach
    public void setUp() {
        this.solution = new RansomNote();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String ransomNote, String magazine, boolean expected) {
        // given

        // when
        boolean actual = solution.canConstruct(ransomNote, magazine);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("a", "b", false),
                Arguments.of("aa", "ab", false),
                Arguments.of("aa", "aab", true)
        );
    }
}