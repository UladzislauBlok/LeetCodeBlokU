package org.ubdev.task.graph.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LargestColorValueDirectedGraphTest {

    private LargestColorValueDirectedGraph solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LargestColorValueDirectedGraph();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String colors, int[][] edges, int expected) {
        // given

        // when
        int actual = solution.largestPathValue(colors, edges);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("abaca", new int[][]{{0,1},{0,2},{2,3},{3,4}}, 3),
                Arguments.of("a", new int[][]{{0,0}}, -1)
        );
    }
}