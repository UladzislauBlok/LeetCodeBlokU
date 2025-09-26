package org.bloku.task._611;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.triangleNumber(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[] {2, 3, 4, 4, 2, 3, 432, 412, 53, 143, 456, 2, 6, 234}, 44),
                Arguments.of(new int[] {0, 0}, 0),
                Arguments.of(new int[] {432, 412, 53, 143, 456, 2}, 7),
                Arguments.of(new int[] {2, 2, 3, 4}, 3));
    }
}
