package org.ubdev.task.backtracking.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class CombinationsTest {

    private Combinations solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Combinations();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int k, List<List<Integer>> expectedResult) {
        // given

        // when
        List<List<Integer>> actual = solution.combine(n, k);

        // then
        assertThat(actual).isEqualTo(expectedResult);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(4, 2, List.of(List.of(1, 2), List.of(1, 3), List.of(1, 4), List.of(2, 3), List.of(2, 4), List.of(3,4))),
                Arguments.of(1, 1, List.of(List.of(1)))
        );
    }
}