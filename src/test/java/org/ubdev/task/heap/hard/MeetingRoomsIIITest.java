package org.ubdev.task.heap.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MeetingRoomsIIITest {

    private MeetingRoomsIII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MeetingRoomsIII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int[][] meetings, int expected) {
        // given

        // when
        int actual = solution.mostBooked(n, meetings);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(2, new int[][]{{0,10},{1,5},{2,7},{3,4}}, 0),
                Arguments.of(3, new int[][]{{1,20},{2,10},{3,5},{4,9},{6,8}}, 1)
        );
    }
}