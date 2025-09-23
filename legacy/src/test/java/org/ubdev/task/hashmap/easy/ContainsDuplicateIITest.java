package org.ubdev.task.hashmap.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class ContainsDuplicateIITest {

    private ContainsDuplicateII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ContainsDuplicateII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int k, boolean expected) {
        // given

        // when
        boolean actual = solution.containsNearbyDuplicate(nums, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,2,3,1,2,3}, 2, false),
                Arguments.of(new int[]{1,2,3,1}, 3, true),
                Arguments.of(new int[]{1,0,1,1}, 1, true)
        );
    }
}