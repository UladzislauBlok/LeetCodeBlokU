package org.ubdev.task.graph;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SurroundedRegionsTest {

    private SurroundedRegions solution;

    @BeforeEach
    public void setUp() {
        this.solution = new SurroundedRegions();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(char[][] board, char[][] expected) {
        // given

        // when
        solution.solve(board);

        // then
        assertThat(board).isDeepEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new char[][]{{'X','O','X','O','X','O'},{'O','X','O','X','O','X'},{'X','O','X','O','X','O'},{'O','X','O','X','O','X'}}, new char[][]{{'X','O','X','O','X','O'},{'O','X','X','X','X','X'},{'X','X','X','X','X','O'},{'O','X','O','X','O','X'}}),
                Arguments.of(new char[][]{{'X','O','X'},{'O','X','O'},{'X','O','X'}}, new char[][]{{'X','O','X'},{'O','X','O'},{'X','O','X'}}),
                Arguments.of(new char[][]{{'X','X','X','X'},{'X','O','O','X'},{'X','X','O','X'},{'X','O','X','X'}}, new char[][]{{'X','X','X','X'},{'X','X','X','X'},{'X','X','X','X'},{'X','O','X','X'}}),
                Arguments.of(new char[][]{{'X'}}, new char[][]{{'X'}})
        );
    }
}