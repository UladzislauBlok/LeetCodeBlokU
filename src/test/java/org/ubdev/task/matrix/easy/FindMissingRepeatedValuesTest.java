package org.ubdev.task.matrix.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindMissingRepeatedValuesTest {

    private FindMissingRepeatedValues solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindMissingRepeatedValues();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[][] input, int[] expected) {
        // given

        // when
        int[] actual = solution.findMissingAndRepeatedValues(input);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[][]{{1,3}, {2,2}}, new int[]{2,4}),
                Arguments.of(new int[][]{{9,1,7}, {8,9,2}, {3,4,6}}, new int[]{9,5})
        );
    }
}