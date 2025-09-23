package org.ubdev.task.dynamic.programming.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class TriangleTest {

    private Triangle solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Triangle();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(List<List<Integer>> triangle, int expected) {
        // given

        // when
        int actual = solution.minimumTotal(triangle);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(List.of(List.of(2), List.of(3,4), List.of(6,5,7), List.of(4,1,8,3)), 11),
                Arguments.of(List.of(List.of(-10)), -10)
        );
    }
}