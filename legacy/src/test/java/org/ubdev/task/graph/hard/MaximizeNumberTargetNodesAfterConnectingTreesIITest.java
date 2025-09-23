package org.ubdev.task.graph.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximizeNumberTargetNodesAfterConnectingTreesIITest {

    private MaximizeNumberTargetNodesAfterConnectingTreesII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximizeNumberTargetNodesAfterConnectingTreesII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] edges1, int[][] edges2, int[] expected) {
        // given

        // when
        int[] actual = solution.maxTargetNodes(edges1, edges2);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{0, 1}, {0, 2}, {2, 3}, {2, 4}},
                        new int[][]{{0, 1}, {0, 2}, {0, 3}, {2, 7}, {1, 4}, {4, 5}, {4, 6}}, new int[]{8, 7, 7, 8, 8})
        );
    }
}