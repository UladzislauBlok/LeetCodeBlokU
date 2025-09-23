package org.ubdev.task.tree.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumScoreAfterRemovalsTreeTest {

    private MinimumScoreAfterRemovalsTree solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumScoreAfterRemovalsTree();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int[][] edges, int expected) {
        // given

        // when
        int actual = solution.minimumScore(nums, edges);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,5,5,4,11}, new int[][]{{0,1},{1,2},{1,3},{3,4}}, 9),
                Arguments.of(new int[]{5,5,2,4,4,2}, new int[][]{{0,1},{1,2},{5,2},{4,3},{1,3}}, 0)
        );
    }
}