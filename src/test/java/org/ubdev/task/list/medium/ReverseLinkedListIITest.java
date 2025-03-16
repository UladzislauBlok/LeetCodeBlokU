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

class ReverseLinkedListIITest {

    private ReverseLinkedListII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ReverseLinkedListII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(ListNode head, int left, int right, ListNode expected) {
        // given

        // when
        ListNode actual = solution.reverseBetween(head, left, right);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildListNode(List.of(1,2,3)), 1 , 3, buildListNode(List.of(3, 2, 1))),
                Arguments.of(buildListNode(List.of(3,5)), 1 , 2, buildListNode(List.of(5,3))),
                Arguments.of(buildListNode(List.of(1,2,3,4,5)), 2 , 4, buildListNode(List.of(1,4,3,2,5))),
                Arguments.of(buildListNode(List.of(5)), 1, 1, buildListNode(List.of(5)))
        );
    }
}