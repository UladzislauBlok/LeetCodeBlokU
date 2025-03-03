package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PartitionArrayAccordingGivenPivotTest {

    private PartitionArrayAccordingGivenPivot solution;

    @BeforeEach
    public void setUp() {
        this.solution = new PartitionArrayAccordingGivenPivot();
    }

    @ParameterizedTest
    @MethodSource
    void pivotArrayReturnsExpectedResult(int[] nums, int pivot, int[] expected) {
        // given

        // when
        int[] actual = solution.pivotArray(nums, pivot);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> pivotArrayReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{9,12,5,10,14,3,10}, 10, new int[]{9,5,3,10,10,12,14}),
                Arguments.of(new int[]{-3,4,3,2}, 2, new int[]{-3,2,4,3})
        );
    }
}