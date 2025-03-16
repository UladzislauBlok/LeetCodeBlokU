package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZeroArrayTransformationIITest {

    private ZeroArrayTransformationII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ZeroArrayTransformationII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int[][] queries, int expected) {
        // given

        // when
        int actual = solution.minZeroArray(nums,queries);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,0,2}, new int[][]{{0,2,1}, {0,2,1}, {1,1,3}}, 2),
                Arguments.of(new int[]{4,3,2,1}, new int[][]{{1,3,2}, {0,2,1}}, -1)
        );
    }
}