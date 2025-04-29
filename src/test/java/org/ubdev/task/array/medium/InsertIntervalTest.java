package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class InsertIntervalTest {

    private InsertInterval solution;

    @BeforeEach
    public void setUp() {
        this.solution = new InsertInterval();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] intervals, int[] newInterval, int[][] expected) {
        // given

        // when
        int[][] actual = solution.insert(intervals, newInterval);

        // then
        assertThat(actual).isDeepEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3}, {6,9}}, new int[]{2,5}, new int[][]{{1,5}, {6,9}}),
                Arguments.of(new int[][]{{1,2}, {3,5}, {6,7}, {8,10}, {12,16}}, new int[]{4,8}, new int[][]{{1,2}, {3,10}, {12,16}})
        );
    }
}