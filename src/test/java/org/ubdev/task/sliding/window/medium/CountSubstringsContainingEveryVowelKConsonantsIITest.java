package org.ubdev.task.sliding.window.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountSubstringsContainingEveryVowelKConsonantsIITest {

    private CountSubstringsContainingEveryVowelKConsonantsII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CountSubstringsContainingEveryVowelKConsonantsII();
    }

    @ParameterizedTest
    @MethodSource
    void minimumRecolorsReturnsExpectedResult(String word, int k, long expected) {
        // given

        // when
        long actual = solution.countOfSubstrings(word, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> minimumRecolorsReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("ieaouqqieaouqq", 1, 3),
                Arguments.of("aadieuoh", 1, 2),
                Arguments.of("iqeaouqi", 2, 3),
                Arguments.of("aeioqq", 1, 0),
                Arguments.of("aeiou", 0, 1)
        );
    }
}