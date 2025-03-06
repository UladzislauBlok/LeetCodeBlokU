package org.ubdev.task.math.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class PlusOneTest {

    private PlusOne solution;

    @BeforeEach
    public void setUp() {
        this.solution = new PlusOne();
    }

    @ParameterizedTest
    @MethodSource
    void plusOneReturnsExpectedResult(int[] input, int[] expected) {
        // given

        // when
        int[] actual = solution.plusOne(input);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> plusOneReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3}, new int[]{1,2,4}),
                Arguments.of(new int[]{4,3,2,1}, new int[]{4,3,2,2}),
                Arguments.of(new int[]{9}, new int[]{1,0})
        );
    }
}