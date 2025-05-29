package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximizeNumberTargetNodesAfterConnectingTreesITest {

    private MaximizeNumberTargetNodesAfterConnectingTreesI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximizeNumberTargetNodesAfterConnectingTreesI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] edges1, int[][] edges2, int k, int[] expected) {
        // given

        // when
        int[] actual = solution.maxTargetNodes(edges1, edges2, k);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}},
                        new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}}, 2, new int[]{9, 7, 9, 8, 8})
        );
    }
}