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
                Arguments.of(new int[][]{{-1,-1,-1,-1,48,5,-1},{12,29,13,9,-1,2,32},{-1,-1,21,7,-1,12,49},{42,37,21,40,-1,22,12},{42,-1,2,-1,-1,-1,6},{39,-1,35,-1,-1,39,-1},{-1,36,-1,-1,-1,-1,5}}, 3),
                Arguments.of(new int[][]{{-1,1,2,-1},{2,13,15,-1},{-1,10,-1,-1},{-1,6,2,8}}, 2),
                Arguments.of(new int[][]{{1,1,-1},{1,1,1},{-1,1,1}}, -1),
                Arguments.of(new int[][]{{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,-1,-1,-1,-1,-1},{-1,35,-1,-1,13,-1},{-1,-1,-1,-1,-1,-1},{-1,15,-1,-1,-1,-1}}, 4),
                Arguments.of(new int[][]{{-1,-1}, {-1,3}}, 1)
        );
    }
}