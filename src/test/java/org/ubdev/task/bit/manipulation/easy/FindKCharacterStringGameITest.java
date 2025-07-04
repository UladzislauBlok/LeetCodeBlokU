package org.ubdev.task.bit.manipulation.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindKCharacterStringGameITest {

    private FindKCharacterStringGameI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindKCharacterStringGameI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int k, char expected) {
        // given

        // when
        char actual = solution.kthCharacter(k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(5, 'b'),
                Arguments.of(10, 'c')
        );
    }
}