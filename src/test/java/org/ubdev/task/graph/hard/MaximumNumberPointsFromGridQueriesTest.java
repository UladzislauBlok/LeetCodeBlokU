package org.ubdev.task.graph.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumNumberPointsFromGridQueriesTest {

    private MaximumNumberPointsFromGridQueries solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumNumberPointsFromGridQueries();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] grid, int[] queries, int[] expected) {
        // given

        // when
        int[] actual = solution.maxPoints(grid, queries);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2,3},{2,5,7},{3,5,1}}, new int[]{5,6,2}, new int[]{5,8,1}),
                Arguments.of(new int[][]{{5,2,1},{1,1,2}}, new int[]{3}, new int[]{0})
        );
    }
}