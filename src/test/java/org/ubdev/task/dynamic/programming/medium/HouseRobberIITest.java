package org.ubdev.task.dynamic.programming.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobberIITest {

    private HouseRobberII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new HouseRobberII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.rob(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,3,2}, 3),
                Arguments.of(new int[]{1,2,3,1}, 4),
                Arguments.of(new int[]{1,2,3}, 3)
        );
    }
}