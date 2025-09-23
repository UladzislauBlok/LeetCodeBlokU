package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumOperationsMakeBinaryArrayElementsEqualOneITest {

    private MinimumOperationsMakeBinaryArrayElementsEqualOneI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumOperationsMakeBinaryArrayElementsEqualOneI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.minOperations(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{0,1,1,1,0,0}, 3),
                Arguments.of(new int[]{0,1,1,1}, -1)
        );
    }
}