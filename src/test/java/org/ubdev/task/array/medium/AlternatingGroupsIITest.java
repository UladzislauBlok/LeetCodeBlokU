package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class AlternatingGroupsIITest {

    private AlternatingGroupsII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new AlternatingGroupsII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] colors, int k, int expected) {
        // given

        // when
        int actual = solution.numberOfAlternatingGroups(colors, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{0,1,0,0,1,0,1}, 6, 2),
                Arguments.of(new int[]{0,1,0,1,0}, 3, 3),
                Arguments.of(new int[]{1,1,0,1}, 4, 0)
        );
    }
}