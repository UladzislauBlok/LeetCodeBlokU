package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;


class ZigzagConversionTest {

    private ZigzagConversion solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ZigzagConversion();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String str, int numRow, String expected) {
        // given

        // when
        String actual = solution.convert(str, numRow);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("PAYPALISHIRING", 3, "PAHNAPLSIIGYIR"),
                Arguments.of("A", 1, "A"),
                Arguments.of("PAYPALISHIRING", 4, "PINALSIGYAHRPI")
        );
    }
}