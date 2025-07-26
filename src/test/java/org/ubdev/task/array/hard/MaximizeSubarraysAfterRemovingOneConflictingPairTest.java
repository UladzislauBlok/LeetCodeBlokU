package org.ubdev.task.array.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximizeSubarraysAfterRemovingOneConflictingPairTest {

    private MaximizeSubarraysAfterRemovingOneConflictingPair solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximizeSubarraysAfterRemovingOneConflictingPair();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int[][] conflictingPairs, int expected) {
        // given

        // when
        long actual = solution.maxSubarrays(n,conflictingPairs);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(4, new int[][]{{2,3}, {1,4}}, 9),
                Arguments.of(5, new int[][]{{1,2},{2,5},{3,5}}, 12)
        );
    }
}