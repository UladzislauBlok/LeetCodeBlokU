package org.ubdev.task.linked.list.easy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.ubdev.domain.ListNode;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.ubdev.util.ListUtil.buildListNode;

class ConvertBinaryNumberLinkedListIntegerTest {

    private ConvertBinaryNumberLinkedListInteger solution;

    @BeforeEach
    public void setUp() {
        this.solution = new ConvertBinaryNumberLinkedListInteger();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(ListNode head, int expected) {
        // given

        // when
        int actual = solution.getDecimalValue(head);

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(buildListNode(List.of(1,0,1)), 5),
                Arguments.of(buildListNode(List.of(0)), 0)
        );
    }
}