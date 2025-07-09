package org.ubdev.task.sliding.window.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RescheduleMeetingsMaximumFreeTimeITest {

    private RescheduleMeetingsMaximumFreeTimeI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new RescheduleMeetingsMaximumFreeTimeI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int eventTime, int k, int[] startTime, int[] endTime, int expected) {
        // given

        // when
        int actual = solution.maxFreeTime(eventTime, k, startTime, endTime);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(5, 1, new int[]{1,3}, new int[]{2,5}, 2),
                Arguments.of(10, 1, new int[]{0,2,9}, new int[]{1,4,10}, 6),
                Arguments.of(5, 2, new int[]{0,1,2,3,4}, new int[]{1,2,3,4,5}, 0)
        );
    }
}