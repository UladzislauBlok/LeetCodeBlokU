package org.ubdev.task.dynamic.programming.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LongestUnequalAdjacentGroupsSubsequenceIITest {

    private LongestUnequalAdjacentGroupsSubsequenceII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LongestUnequalAdjacentGroupsSubsequenceII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String[] words, int[] groups, List<String> expected) {
        // given

        // when
        List<String> actual = solution.getWordsInLongestSubsequence(words, groups);

        // then
        assertThat(actual).containsAnyElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new String[]{"a","b","c","d"}, new int[]{1,2,3,4}, List.of("a","b","c","d"))
        );
    }
}