# Scope Document

### Project Objective:
Develop a Java based command line application that generates all permutations of integers 0 through n−1, runs four sorting algorithms on every permutation, and reports best/worst/average element-to-element comparison counts for n = 4, 6, and 8.

### Functional Requirements:

#### Part 1 – Array Generator:
- Generate all permutations of integers 0 through n−1 using a lexicographic algorithm
- Must produce all n! permutations without duplicates

#### Part 2 – Sorting Algorithms:
Implement all four of the following:
- Mergesort
- Quicksort
- Shaker Sort (bidirectional bubble sort)
- Heapsort

Each algorithm must accept an integer array, return it sorted, and count element-to-element comparisons only (e.g., `a[i] < a[j]`). Loop bounds and index checks are excluded.

#### Part 3 – Test Driver:
- Run all four algorithms on every permutation for a given n
- Record algorithm name, input array, and comparison count per run

#### Part 4 – Data Collection:
For each algorithm at n = 4, 6, 8, output:
- Best 10 cases (fewest comparisons) with input arrays
- Worst 10 cases (most comparisons) with input arrays
- Average comparisons across all permutations

### Technical Specifications:
- Language: Java (IntelliJ IDEA)
- Comparison counting must be consistent across all four algorithms

### Out of Scope:
- User input via Scanner
- GUI
- Additional sorting algorithms or n values

### Success Criteria:
- All four algorithms correctly sort every permutation and report accurate comparison counts
- Output is clearly labeled per algorithm per n with best/worst/average summaries
- Code is pushed to the GitHub repository
- README describes exactly how to run the experiment and reproduce all output
- Video demo under 10 minutes explaining and executing the code