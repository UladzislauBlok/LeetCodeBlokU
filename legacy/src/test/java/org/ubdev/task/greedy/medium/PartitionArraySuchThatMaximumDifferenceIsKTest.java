package org.ubdev.task.greedy.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PartitionArraySuchThatMaximumDifferenceIsKTest {

    private PartitionArraySuchThatMaximumDifferenceIsK solution;

    @BeforeEach
    public void setUp() {
        this.solution = new PartitionArraySuchThatMaximumDifferenceIsK();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int k, int expected) {
        // given

        // when
        int actual = solution.partitionArray(nums, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{3,6,1,2,5}, 2, 2),
                Arguments.of(new int[]{1,2,3}, 1, 2),
                Arguments.of(new int[]{2,2,4,5}, 0, 3)
        );
    }
}