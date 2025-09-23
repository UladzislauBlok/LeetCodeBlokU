package org.ubdev.task.string.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindLexicographicallyLargestStringFromBoxITest {

    private FindLexicographicallyLargestStringFromBoxI solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindLexicographicallyLargestStringFromBoxI();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String word, int numFriends, String expected) {
        // given

        // when
        String actual = solution.answerString(word, numFriends);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("dbca", 2, "dbc"),
                Arguments.of("gggg", 4, "g"),
                Arguments.of("dbca", 1, "dbca")
        );
    }
}