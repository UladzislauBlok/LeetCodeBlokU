package org.ubdev.task.array.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindLuckyIntegerArrayTest {

    private FindLuckyIntegerArray solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindLuckyIntegerArray();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.findLucky(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,2,3,4}, 2),
                Arguments.of(new int[]{1,2,2,3,3,3}, 3),
                Arguments.of(new int[]{2,2,2,3,3}, -1)
        );
    }
}