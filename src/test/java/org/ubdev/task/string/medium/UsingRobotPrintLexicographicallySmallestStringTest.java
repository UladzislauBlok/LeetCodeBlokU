package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class UsingRobotPrintLexicographicallySmallestStringTest {

    private UsingRobotPrintLexicographicallySmallestString solution;

    @BeforeEach
    public void setUp() {
        this.solution = new UsingRobotPrintLexicographicallySmallestString();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String str, String expected) {
        // given

        // when
        String actual = solution.robotWithString(str);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("zza", "azz"),
                Arguments.of("bac", "abc"),
                Arguments.of("bdda", "addb")
        );
    }
}