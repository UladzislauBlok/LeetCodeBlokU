package org.ubdev.task.dynamic.programming;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximalSquareTest {

    private MaximalSquare solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximalSquare();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(char[][] board, int expected) {
        // given

        // when
        int actual = solution.maximalSquare(board);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new char[][]{{'1','0','1','0','0'},{'1','0','1','1','1'},{'1','1','1','1','1'},{'1','0','0','1','0'}}, 4),
                Arguments.of(new char[][]{{'0','1'}, {'1','0'}}, 1)
        );
    }
}