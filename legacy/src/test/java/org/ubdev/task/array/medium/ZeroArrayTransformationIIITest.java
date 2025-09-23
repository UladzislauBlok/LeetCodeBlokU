package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ZeroArrayTransformationIIITest {

    private ZeroArrayTransformationIII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ZeroArrayTransformationIII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int[][] queries, int expected) {
        // given

        // when
        int actual = solution.maxRemoval(nums, queries);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,0,2}, new int[][]{{0,2}, {0,2}, {1,1}}, 1),
                Arguments.of(new int[]{1,2,3,4}, new int[][]{{0,3}}, -1)
        );
    }
}