package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MaximumScoreFromRemovingSubstringsTest {

    private MaximumScoreFromRemovingSubstrings solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MaximumScoreFromRemovingSubstrings();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String s, int x, int y, int expected) {
        // given

        // when
        int actual = solution.maximumGain(s, x, y);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("cdbcbbaaabab", 4, 5 ,19),
                Arguments.of("aabbaaxybbaabb", 5, 4 , 20)
        );
    }
    /*
Input: s = "aabbaaxybbaabb", x = 5, y = 4
Output: 20

     */
}