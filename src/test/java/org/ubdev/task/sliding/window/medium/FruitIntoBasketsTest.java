package org.ubdev.task.sliding.window.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FruitIntoBasketsTest {

    private FruitIntoBaskets solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FruitIntoBaskets();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expected) {
        // given

        // when
        int actual = solution.totalFruit(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,1}, 3),
                Arguments.of(new int[]{0,1,2,2}, 3),
                Arguments.of(new int[]{1,2,3,2,2}, 4)
        );
    }
}