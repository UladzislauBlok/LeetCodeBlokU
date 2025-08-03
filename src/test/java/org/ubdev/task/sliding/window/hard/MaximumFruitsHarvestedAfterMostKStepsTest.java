package org.ubdev.task.sliding.window.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumFruitsHarvestedAfterMostKStepsTest {

    private MaximumFruitsHarvestedAfterMostKSteps solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumFruitsHarvestedAfterMostKSteps();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] fruits, int startPos, int k, int expected) {
        // given

        // when
        int actual = solution.maxTotalFruits(fruits, startPos, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{2,8},{6,3},{8,6}}, 5, 4, 9),
                Arguments.of(new int[][]{{0,9},{4,1},{5,7},{6,2},{7,4},{10,9}},5, 4, 14),
                Arguments.of(new int[][]{{0,3},{6,4},{8,5}}, 3, 2, 0)
        );
    }
}