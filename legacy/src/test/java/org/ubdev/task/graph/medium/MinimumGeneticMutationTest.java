package org.ubdev.task.graph.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class MinimumGeneticMutationTest {

    private MinimumGeneticMutation solution;

    @BeforeEach
    public void setUp() {
        this.solution = new MinimumGeneticMutation();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(String startGene, String endGene, String[] bank, int expected) {
        // given

        // when
        int actual = solution.minMutation(startGene, endGene, bank);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of("AACCGGTT", "AAACGGTA", new String[]{"AACCGATT","AACCGATA","AAACGATA","AAACGGTA"}, 4),
                Arguments.of("AACCTTGG", "AATTCCGG", new String[]{"AATTCCGG","AACCTGGG","AACCCCGG","AACCTACC"}, -1),
                Arguments.of("AACCGGTT", "AACCGGTA", new String[]{"AACCGGTA"}, 1),
                Arguments.of("AACCGGTT", "AAACGGTA", new String[]{"AACCGGTA","AACCGCTA","AAACGGTA"}, 2)
        );
    }
}