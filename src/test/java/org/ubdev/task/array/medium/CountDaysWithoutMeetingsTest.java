package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CountDaysWithoutMeetingsTest {

    private CountDaysWithoutMeetings solution;

    @BeforeEach
    public void setUp() {
        this.solution = new CountDaysWithoutMeetings();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int days, int[][] meetings, int expected) {
        // given

        // when
        int actual = solution.countDays(days, meetings);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(10, new int[][]{{5,7}, {1,3}, {9,10}}, 2),
                Arguments.of(5, new int[][]{{2,4}, {1,3}}, 1),
                Arguments.of(6, new int[][]{{1,6}}, 0)
        );
    }
}