package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class RemoveDuplicatesSortedArrayIITest {

    private RemoveDuplicatesSortedArrayII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new RemoveDuplicatesSortedArrayII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int[] nums, int expectedK, int[] expectedArray) {
        // given

        // when
        int actual = solution.removeDuplicates(nums);

        // then
        assertThat(actual).isEqualTo(expectedK);
        for (int i = 0; i < expectedK; i++) {
            assertThat(nums[i]).isEqualTo(expectedArray[i]);
        }
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(new int[]{1,1,1,2,2,3}, 5, new int[]{1,1,2,2,3,-1}),
                Arguments.of(new int[]{0,0,1,1,1,1,2,3,3}, 7, new int[]{0,0,1,1,2,3,3,-1,-1})
        );
    }
}