package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZeroArrayTransformationITest {

    private ZeroArrayTransformationI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ZeroArrayTransformationI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int[][] queries, boolean expected) {
        // given

        // when
        boolean actual = solution.isZeroArray(nums,queries);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,0,1}, new int[][]{{0,2}}, true),
                Arguments.of(new int[]{4,3,2,1}, new int[][]{{1,3},{0,2}}, false)
        );
    }
}