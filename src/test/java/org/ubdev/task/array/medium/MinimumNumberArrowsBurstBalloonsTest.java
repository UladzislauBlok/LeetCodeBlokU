package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumNumberArrowsBurstBalloonsTest {

    private MinimumNumberArrowsBurstBalloons solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumNumberArrowsBurstBalloons();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] points, int expected) {
        // given

        // when
        int actual = solution.findMinArrowShots(points);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{3,9}, {7,12}, {3,8}, {6,8}, {9,10}, {2,9}, {0,9}, {3,9}, {0,6}, {2,8}}, 2),
                Arguments.of(new int[][]{{9,12}, {1,10}, {4,11}, {8,12}, {3,9}, {6,9}, {6,7}}, 2),
                Arguments.of(new int[][]{{-2147483646,-2147483645}, {2147483646,2147483647}}, 2),
                Arguments.of(new int[][]{{10,16}, {2,8}, {1,6}, {7,12}}, 2),
                Arguments.of(new int[][]{{1,2}, {3,4}, {5,6}, {7,8}}, 4),
                Arguments.of(new int[][]{{1,2}, {2,3}, {3,4}, {4,5}}, 2)
        );
    }
}