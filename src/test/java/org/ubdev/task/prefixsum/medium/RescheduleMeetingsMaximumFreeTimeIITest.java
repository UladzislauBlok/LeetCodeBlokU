package org.ubdev.task.prefixsum.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RescheduleMeetingsMaximumFreeTimeIITest {

    private RescheduleMeetingsMaximumFreeTimeII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new RescheduleMeetingsMaximumFreeTimeII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int eventTime, int[] startTime, int[] endTime, int expected) {
        // given

        // when
        int actual = solution.maxFreeTime(eventTime, startTime, endTime);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(5, new int[]{1,3}, new int[]{2,5}, 2),
                Arguments.of(10, new int[]{0,7,9}, new int[]{1,8,10}, 7),
                Arguments.of(10, new int[]{0,3,7,9}, new int[]{1,4,8,10}, 6)
        );
    }
}