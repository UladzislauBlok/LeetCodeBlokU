package org.ubdev.task.dynamic.programming.hard;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class PaintingGridWithThreeDifferentColors {
    private int gridHeight;

    public int colorTheGrid(int m, int n) {
        this.gridHeight = m;
        final int MOD = (int) 1e9 + 7; // Define the modulus for taking modulo
        int maxStateValue = (int) Math.pow(3, m); // Total possible states given m rows and 3 colors
        Set<Integer> validStates = new HashSet<>(); // To keep track of all valid configurations
        int[] dpStateCounts = new int[maxStateValue]; // Dynamic programming array to count configurations
        // Populate the valid states and their count
        for (int state = 0; state < maxStateValue; ++state) {
            if (isValidState(state)) {
                validStates.add(state);
                dpStateCounts[state] = 1;
            }
        }

        // Map to hold the valid transitions between states
        Map<Integer, List<Integer>> validTransitions = new HashMap<>();

        // Find all valid transitions between valid states
        for (int i : validStates) {
            for (int j : validStates) {
                if (isTransitionValid(i, j)) {
                    validTransitions.computeIfAbsent(i, k -> new ArrayList<>()).add(j);
                }
            }
        }


        // Build up the answer column by column
        for (int column = 1; column < n; ++column) {
            int[] nextStateCounts = new int[maxStateValue]; // Temp array for the next state counts
            for (int currentState : validStates) {
                for (int nextState : validTransitions.getOrDefault(currentState, List.of())) {
                    nextStateCounts[currentState] = (nextStateCounts[currentState] + dpStateCounts[nextState]) % MOD;
                }
            }
            dpStateCounts = nextStateCounts; // Move to the next column
        }

        // Sum up all possible configurations
        int answer = 0;
        for (int count : dpStateCounts) {
            answer = (answer + count) % MOD;
        }
        return answer;
    }

    // Check if a state is valid: no two adjacent cells in the same row have the same color
    private boolean isValidState(int state) {
        int lastColor = -1;
        for (int i = 0; i < gridHeight; ++i) {
            int currentColor = state % 3;
            if (currentColor == lastColor) {
                return false;
            }
            lastColor = currentColor;
            state /= 3;
        }
        return true;
    }

    // Check if transitioning from one state to another is valid across columns
    private boolean isTransitionValid(int stateOne, int stateTwo) {
        for (int i = 0; i < gridHeight; ++i) {
            if (stateOne % 3 == stateTwo % 3) {
                return false;
            }
            stateOne /= 3;
            stateTwo /= 3;
        }
        return true;
    }
}
