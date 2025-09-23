package org.ubdev.task.matrix.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SetMatrixZeroesTest {

    private SetMatrixZeroes solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SetMatrixZeroes();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] input, int[][] expected) {
        // given

        // when
        solution.setZeroes(input);

        // then
        assertThat(input).isDeepEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][] {{0,1,2,0},{3,4,5,2},{1,3,1,5}}, new int[][]{{0,0,0,0},{0,4,5,0},{0,3,1,0}})
        );
    }
}