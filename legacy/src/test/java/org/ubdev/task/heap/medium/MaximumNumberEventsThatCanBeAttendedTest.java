package org.ubdev.task.heap.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumNumberEventsThatCanBeAttendedTest {

    private MaximumNumberEventsThatCanBeAttended solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumNumberEventsThatCanBeAttended();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] events, int expected) {
        // given

        // when
        int actual = solution.maxEvents(events);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{1,2},{2,3},{3,4}}, 3),
                Arguments.of(new int[][]{{1,2},{2,3},{3,4},{1,2}}, 4)
        );
    }
}