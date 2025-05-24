package org.ubdev.task.graph.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMaximumSumNodeValuesTest {

    private FindMaximumSumNodeValues solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindMaximumSumNodeValues();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int k, int[][] edges, long expected) {
        // given

        // when
        long actual = solution.maximumValueSum(nums, k, edges);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,1}, 3, new int[][]{{0,1},{0,2}}, 6),
                Arguments.of(new int[]{7,7,7,7,7,7}, 3, new int[][]{{0,1},{0,2},{0,3},{0,4},{0,5}}, 42)
        );
    }
}