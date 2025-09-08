#!/bin/bash

# Check if a directory name was provided.
if [ "$#" -ne 1 ]; then
  echo "Error: You must provide exactly one argument, the project directory name."
  echo "Usage: ./create_files_with_templates.sh <project_directory>"
  exit 1
fi

# Store the project directory name.
SOL_DIR="$1"
SRC_DIR="src/main/java/org/ubdev/task/$SOL_DIR"
TEST_DIR="src/test/java/org/ubdev/task/$SOL_DIR"

# Create the main project directory and subdirectories.
mkdir -p "$SRC_DIR"
if [ $? -ne 0 ]; then
  echo "Error: Failed to create source directory '$SRC_DIR'."
  exit 1
fi
mkdir -p "$TEST_DIR"
if [ $? -ne 0 ]; then
  echo "Error: Failed to create test directory '$TEST_DIR'."
  exit 1
fi

# Define the source and test file names.
SRC_FILE_NAME="Solution.java"
TEST_FILE_NAME="SolutionTest.java"

# --- Create the source file (Solution.java) ---
SRC_PATH="$SRC_DIR/$SRC_FILE_NAME"
if [ -f "$SRC_PATH" ]; then
  echo "Warning: The file '$SRC_PATH' already exists. Skipping."
else
  cat << 'EOF' > "$SRC_PATH"
package org.ubdev.task.TODO;

import org.ubdev.util.LeetCodeName;
import org.ubdev.util.Topics;

@LeetCodeName("") // TODO
@Topics({}) // TODO
class Solution {

    public int f() {
        return -1;
    }
}

EOF
  if [ $? -eq 0 ]; then
    echo "Successfully created '$SRC_PATH' with the template content."
  else
    echo "An error occurred while creating the file '$SRC_PATH'."
  fi
fi

# --- Create the test file (SolutionTest.java) ---
TEST_PATH="$TEST_DIR/$TEST_FILE_NAME"
if [ -f "$TEST_PATH" ]; then
  echo "Warning: The file '$TEST_PATH' already exists. Skipping."
else
  cat << 'EOF' > "$TEST_PATH"
package org.ubdev.task.TODO;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;

class SolutionTest {

    private Solution solution;

    @BeforeEach
    public void setUp() {
        this.solution = new Solution();
    }

    @ParameterizedTest
    @MethodSource
    void solutionReturnsExpectedResult(int expected) {
        // given

        // when
        int actual = solution.f();

        // then
        assertThat(actual).isEqualTo(expected);
    }

    static Stream<Arguments> solutionReturnsExpectedResult() {
        return Stream.of(
                Arguments.of(10),
                Arguments.of(4)
        );
    }
}

EOF
  if [ $? -eq 0 ]; then
    echo "Successfully created '$TEST_PATH' with the template content."
  else
    echo "An error occurred while creating the file '$TEST_PATH'."
  fi
fi

echo "Done."
