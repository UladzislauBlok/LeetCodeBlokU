package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SnakesLaddersTest {

    private SnakesLadders solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SnakesLadders();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] board, int expected) {
        // given

        // when
        int actual = solution.snakesAndLadders(board);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}, 4),
                Arguments.of(new int[][]{{-1,-1}, {-1,3}}, 1)
        );
    }
}