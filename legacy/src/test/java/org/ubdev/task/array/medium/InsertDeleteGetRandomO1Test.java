package org.ubdev.task.array.medium;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.ubdev.task.array.medium.InsertDeleteGetRandomO1.RandomizedSet;

import static org.assertj.core.api.Assertions.assertThat;

class InsertDeleteGetRandomO1Test {

    private RandomizedSet randomizedSet;

    @BeforeEach
    void setUp() {
        randomizedSet = new RandomizedSet();
    }

    @Test
    void tc1() {
        assertThat(randomizedSet.insert(1)).isTrue(); // Inserts 1 to the set. Returns true as 1 was inserted successfully.
        assertThat(randomizedSet.remove(2)).isFalse(); // Returns false as 2 does not exist in the set.
        assertThat(randomizedSet.insert(2)).isTrue(); // Inserts 2 to the set, returns true. Set now contains [1,2].
        assertThat(randomizedSet.getRandom()).satisfiesAnyOf(
                num -> assertThat(num).isEqualTo(1),
                num -> assertThat(num).isEqualTo(2)
        ); // getRandom() should return either 1 or 2 randomly.
        assertThat(randomizedSet.remove(1)).isTrue(); // Removes 1 from the set, returns true. Set now contains [2].
        assertThat(randomizedSet.insert(2)).isFalse(); // 2 was already in the set, so return false.
        assertThat(randomizedSet.getRandom()).isEqualTo(2); // Since 2 is the only number in the set, getRandom() will always return 2.
    }

    @Test
    void tc2() {
        assertThat(randomizedSet.insert(0)).isTrue();
        assertThat(randomizedSet.insert(1)).isTrue();
        assertThat(randomizedSet.remove(0)).isTrue();
        assertThat(randomizedSet.insert(2)).isTrue();
        assertThat(randomizedSet.remove(1)).isTrue();
        assertThat(randomizedSet.getRandom()).isEqualTo(2);
    }
}