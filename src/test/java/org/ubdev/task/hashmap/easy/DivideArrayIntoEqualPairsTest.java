package org.ubdev.task.hashmap.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DivideArrayIntoEqualPairsTest {

    private DivideArrayIntoEqualPairs solution;

    @BeforeEach
    public void setUp() {
        this.solution = new DivideArrayIntoEqualPairs();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, boolean expected) {
        // given

        // when
        boolean actual = solution.divideArray(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{3,2,3,2,2,2}, true),
                Arguments.of(new int[]{1,2,3,4}, false)
        );
    }
}