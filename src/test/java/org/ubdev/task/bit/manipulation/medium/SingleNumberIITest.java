package org.ubdev.task.bit.manipulation.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SingleNumberIITest {

    private SingleNumberII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SingleNumberII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.singleNumber(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,2,3,2}, 3),
                Arguments.of(new int[]{0,1,0,1,0,1,99}, 99)
        );
    }
}