package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SortColorsTest {

    private SortColors solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SortColors();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int[] expectedArray) {
        // given

        // when
        solution.sortColors(nums);

        // then
        assertThat(nums).containsExactly(expectedArray);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,0,2,1,1,0}, new int[]{0,0,1,1,2,2}),
                Arguments.of(new int[]{2,0,1}, new int[]{0,1,2})
        );
    }

}