package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumCandiesYouCanGetBoxesTest {

    private MaximumCandiesYouCanGetBoxes solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumCandiesYouCanGetBoxes();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] status, int[] candies, int[][] keys, int[][] containedBoxes, int[] initialBoxes, int expected) {
        // given

        // when
        int actual = solution.maxCandies(status, candies, keys, containedBoxes, initialBoxes);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,0,1,0}, new int[]{7,5,4,100}, new int[][]{{},{},{1},{}}, new int[][]{{1,2},{3},{},{}}, new int[]{0}, 16),
                Arguments.of(new int[]{1,0,0,0,0,0}, new int[]{1,1,1,1,1,1}, new int[][]{{1,2,3,4,5},{},{},{},{},{}}, new int[][]{{1,2,3,4,5},{},{},{},{},{}}, new int[]{0}, 6)
        );
    }
}