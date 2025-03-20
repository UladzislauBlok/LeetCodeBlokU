package org.ubdev.task.graph.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumCostWalkWeightedGraphTest {

    private MinimumCostWalkWeightedGraph solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumCostWalkWeightedGraph();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int[][] edges, int[][] query, int[] expected) {
        // given

        // when
        int[] actual = solution.minimumCost(n, edges, query);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(5, new int[][]{{0,1,7},{1,3,7},{1,2,1}}, new int[][]{{0,3},{3,4}}, new int[]{1,-1}),
                Arguments.of(3, new int[][]{{0,2,7},{0,1,15},{1,2,6},{1,2,1}}, new int[][]{{1,2}}, new int[]{0})
        );
    }
}