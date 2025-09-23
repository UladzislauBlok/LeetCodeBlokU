package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumHeightTreesTest {

    private MinimumHeightTrees solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumHeightTrees();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int[][] edges, List<Integer> expected) {
        // given

        // when
        List<Integer> actual = solution.findMinHeightTrees(n, edges);

        // then
        assertThat(actual).containsExactlyInAnyOrderElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(4, new int[][]{{1,0},{1,2},{1,3}}, List.of(1)),
                Arguments.of(6, new int[][]{{3,0},{3,1},{3,2},{3,4},{5,4}}, List.of(3,4))
        );
    }
}