package org.ubdev.task.bit.manipulation.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindKCharacterStringGameIITest {

    private FindKCharacterStringGameII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindKCharacterStringGameII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(long k, int[] operations,  char expected) {
        // given

        // when
        char actual = solution.kthCharacter(k, operations);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(5, new int[]{0,0,0}, 'a'),
                Arguments.of(10, new int[]{0,1,0,1}, 'b')
        );
    }
}