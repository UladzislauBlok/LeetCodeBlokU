package org.ubdev.task.list.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.ubdev.domain.ListNode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ubdev.util.ListUtil.buildListNode;

class RotateListTest {

    private RotateList solution;

    @BeforeEach
    public void setUp() {
        this.solution = new RotateList();
    }

    @ParameterizedTest
    @MethodSource
    void rotateRightReturnsExpectedResult(ListNode list, int k, ListNode expected) {
        // given

        // when
        ListNode actual = solution.rotateRight(list, k);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> rotateRightReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildListNode(List.of(1,2,3,4,5)), 2, buildListNode(List.of(4,5,1,2,3))),
                Arguments.of(buildListNode(List.of(0,1,2)), 4, buildListNode(List.of(2,0,1)))
        );
    }
}