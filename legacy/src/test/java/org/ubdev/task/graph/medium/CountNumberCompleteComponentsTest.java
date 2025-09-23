package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountNumberCompleteComponentsTest {

    private CountNumberCompleteComponents solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CountNumberCompleteComponents();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int[][] edges, int expected) {
        // given

        // when
        int actual = solution.countCompleteComponents(n, edges);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(6, new int[][]{{0,1},{0,2},{1,2},{3,4}}, 3),
                Arguments.of(3, new int[][]{{1,0},{2,1}}, 0),
                Arguments.of(6, new int[][]{{0,1},{0,2},{1,2},{3,4},{3,5}}, 1)
        );
    }
}