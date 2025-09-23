package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindEventualSafeStatesTest {

    private FindEventualSafeStates solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindEventualSafeStates();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] graph, List<Integer> expected) {
        // given

        // when
        List<Integer> actual = solution.eventualSafeNodes(graph);

        // then
        assertThat(actual).containsAnyElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2},{2,3},{5},{0},{5},{},{}}, List.of(2, 4, 5, 6)),
                Arguments.of(new int[][]{{1,2,3,4},{1,2},{3,4},{0,4},{}}, List.of(4))
        );
    }
}