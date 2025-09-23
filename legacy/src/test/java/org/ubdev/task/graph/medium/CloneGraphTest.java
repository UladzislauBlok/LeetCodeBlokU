package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.ubdev.domain.Node;

import java.util.stream.Stream;

import static java.util.List.of;
import static org.assertj.core.api.Assertions.assertThat;
import static org.ubdev.util.GraphUtil.buildGraph;

class CloneGraphTest {

    private CloneGraph solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CloneGraph();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(Node graph, Node expectedResult) {
        // given

        // when
        Node actual = solution.cloneGraph(graph);

        // then
        assertThat(actual).isEqualTo(expectedResult);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildGraph(of(of())), buildGraph(of(of()))),
                Arguments.of(buildGraph(of()), buildGraph(of())),
                Arguments.of(buildGraph(of(of(2,4),of(1,3),of(2,4),of(1,3))), buildGraph(of(of(2,4),of(1,3),of(2,4),of(1,3))))
        );
    }
}