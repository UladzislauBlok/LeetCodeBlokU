package org.ubdev.task.tree.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class LexicographicalNumbersTest {

    private LexicographicalNumbers solution;

    @BeforeEach
    public void setUp() {
        this.solution = new LexicographicalNumbers();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int n, List<Integer> expected) {
        // given

        // when
        List<Integer> actual = solution.lexicalOrder(n);

        // then
        assertThat(actual).containsExactlyElementsOf(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(13, List.of(1,10,11,12,13,2,3,4,5,6,7,8,9)),
                Arguments.of(2, List.of(1,2))
        );
    }
}