package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumDeletionsMakeStringKSpecialTest {

    private MinimumDeletionsMakeStringKSpecial solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumDeletionsMakeStringKSpecial();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String word, int k, int expected) {
        // given

        // when
        int actual = solution.minimumDeletions(word, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("aabcaba", 0, 3),
                Arguments.of("dabdcbdcdcd", 2, 2),
                Arguments.of("aaabaaa", 2, 1)
        );
    }
}