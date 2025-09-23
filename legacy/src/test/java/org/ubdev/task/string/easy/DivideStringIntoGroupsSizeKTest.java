package org.ubdev.task.string.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class DivideStringIntoGroupsSizeKTest {

    private DivideStringIntoGroupsSizeK solution;

    @BeforeEach
    public void setUp() {
        this.solution = new DivideStringIntoGroupsSizeK();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String s, int k, char fill, String[] expected) {
        // given

        // when
        String[] actual = solution.divideString(s, k, fill);

        // then
        assertThat(actual).containsExactly(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("abcdefghi", 3, 'x', new String[]{"abc","def","ghi"}),
                Arguments.of("abcdefghij", 3, 'x', new String[]{"abc","def","ghi","jxx"})
        );
    }
}