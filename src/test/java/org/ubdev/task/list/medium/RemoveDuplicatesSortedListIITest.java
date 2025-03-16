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

class RemoveDuplicatesSortedListIITest {

    private RemoveDuplicatesSortedListII solution;

    @BeforeEach
    public void setUp() {
        this.solution = new RemoveDuplicatesSortedListII();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(ListNode head, ListNode expected) {
        // given

        // when
        ListNode actual = solution.deleteDuplicates(head);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildListNode(List.of(1,2,3,3,4,4,5)), buildListNode(List.of(1,2,5))),
                Arguments.of(buildListNode(List.of(1,1,1,2,3)), buildListNode(List.of(2,3)))
        );
    }
}