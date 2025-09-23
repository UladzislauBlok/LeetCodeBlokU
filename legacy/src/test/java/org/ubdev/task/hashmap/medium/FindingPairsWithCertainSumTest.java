package org.ubdev.task.hashmap.medium;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindingPairsWithCertainSumTest {

    @Test
    void test() {
        FindingPairsWithCertainSum uut = new FindingPairsWithCertainSum(new int[]{1, 1, 2, 2, 2, 3}, new int[]{1, 4, 5, 2, 5, 4});

        assertEquals(8, uut.count(7));

        uut.add(3, 2);

        assertEquals(2, uut.count(8));
        assertEquals(1, uut.count(4));

        uut.add(0, 1);
        uut.add(1, 1);

        assertEquals(11, uut.count(7));
    }
}