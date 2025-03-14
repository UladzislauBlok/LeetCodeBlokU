package org.ubdev.task.binary.search.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumCandiesAllocatedKChildrenTest {

    private MaximumCandiesAllocatedKChildren solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumCandiesAllocatedKChildren();
    }

    @ParameterizedTest
    @MethodSource
    void pivotArrayReturnsExpectedResult(int[] candies, long k, int expected) {
        // given

        // when
        int actual = solution.maximumCandies(candies, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> pivotArrayReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{5,8,6}, 3, 5),
                Arguments.of(new int[]{2,5}, 11, 0)
        );
    }
}