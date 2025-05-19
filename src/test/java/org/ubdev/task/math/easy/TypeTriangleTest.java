package org.ubdev.task.math.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TypeTriangleTest {

    private TypeTriangle solution;

    @BeforeEach
    public void setUp() {
        this.solution = new TypeTriangle();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, String expected) {
        // given

        // when
        String actual = solution.triangleType(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{3,3,3}, "equilateral"),
                Arguments.of(new int[]{3,4,5}, "scalene")
        );
    }
}