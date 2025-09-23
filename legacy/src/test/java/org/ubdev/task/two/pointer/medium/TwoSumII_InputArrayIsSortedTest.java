package org.ubdev.task.two.pointer.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TwoSumIIInputArrayIsSortedTest {

    private TwoSumII_InputArrayIsSorted solution;

    @BeforeEach
    public void setUp() {
        this.solution = new TwoSumII_InputArrayIsSorted();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] numbers, int target, int[] expected) {
        // given

        // when
        int[] actual = solution.twoSum(numbers, target);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2, 7, 11, 15}, 9, new int[]{1, 2}),
                Arguments.of(new int[]{2, 3, 4}, 6, new int[]{1, 3}),
                Arguments.of(new int[]{-1, 0}, -1, new int[]{1, 2})
        );
    }
}