package org.ubdev.task.binary.search.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class HouseRobberIVTest {

    private HouseRobberIV solution;

    @BeforeEach
    public void setUp() {
        this.solution = new HouseRobberIV();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int k, int expected) {
        // given

        // when
        int actual = solution.minCapability(nums, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{2,3,5,9}, 2, 5),
                Arguments.of(new int[]{2,7,9,3,1}, 2, 2)
        );
    }
}