package org.ubdev.task.tree.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UniqueBinarySearchTreesTest {

    private UniqueBinarySearchTrees solution;

    @BeforeEach
    public void setUp() {
        this.solution = new UniqueBinarySearchTrees();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, int expected) {
        // given

        // when
        int actual = solution.numTrees(n);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(3, 5),
                Arguments.of(1, 1)
        );
    }
}