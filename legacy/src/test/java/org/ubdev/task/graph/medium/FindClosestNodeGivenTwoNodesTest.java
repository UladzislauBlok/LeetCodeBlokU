package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindClosestNodeGivenTwoNodesTest {

    private FindClosestNodeGivenTwoNodes solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindClosestNodeGivenTwoNodes();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] edges, int node1, int node2,  int expected) {
        // given

        // when
        int actual = solution.closestMeetingNode(edges, node1, node2);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,2,3,-1}, 0, 1, 2),
                Arguments.of(new int[]{1,2,-1}, 0, 2, 2)
        );
    }
}