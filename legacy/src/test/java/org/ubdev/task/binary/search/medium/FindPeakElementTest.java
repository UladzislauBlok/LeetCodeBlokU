package org.ubdev.task.binary.search.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Set;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class FindPeakElementTest {

    private FindPeakElement solution;

    @BeforeEach
    public void setUp() {
        this.solution = new FindPeakElement();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, Set<Integer> oneOf) {
        // given

        // when
        int actual = solution.findPeakElement(nums);

        // then
        assertThat(actual).matches(oneOf::contains);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2}, Set.of(1)),
                Arguments.of(new int[]{1,2,3,1}, Set.of(2)),
                Arguments.of(new int[]{1,2,1,3,5,6,4}, Set.of(1,5))
        );
    }
}