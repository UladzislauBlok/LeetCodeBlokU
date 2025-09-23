package org.ubdev.task.bit.manipulation.hard;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class BitwiseORsSubarraysTest {

    private BitwiseORsSubarrays solution;

    @BeforeEach
    public void setUp() {
        this.solution = new BitwiseORsSubarrays();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums,  int expected) {
        // given

        // when
        int actual = solution.subarrayBitwiseORs(nums);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{0}, 1),
                Arguments.of(new int[]{1,1,2}, 3),
                Arguments.of(new int[]{1,2,4}, 6)
        );
    }
}