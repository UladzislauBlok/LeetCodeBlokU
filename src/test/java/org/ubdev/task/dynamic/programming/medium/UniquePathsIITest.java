package org.ubdev.task.dynamic.programming.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UniquePathsIITest {

    private UniquePathsII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new UniquePathsII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] grid, int expected) {
        // given

        // when
        int actual = solution.uniquePathsWithObstacles(grid);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{0,0,0},{0,1,0},{0,0,0}}, 2)
        );
    }
}