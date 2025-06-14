package org.ubdev.task.binary.search.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimizeMaximumDifferencePairsTest {

    private MinimizeMaximumDifferencePairs solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimizeMaximumDifferencePairs();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int p, int expected) {
        // given

        // when
        int actual = solution.minimizeMax(nums, p);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{10,1,2,7,1,3}, 2, 1),
                Arguments.of(new int[]{4,2,1,2}, 1, 0)
        );
    }
}