# CS-2430 Project 2

## Project Overview
This project implements and compares multiple sorting algorithms by running them on systematically generated input data. Performance is measured using the number of element-to-element comparisons, allowing for analysis of best, worst, and average cases.

---

## Features
- Implements multiple sorting algorithms:
  - Merge Sort
  - Quick Sort
  - Heap Sort
  - Shaker Sort
- Generates all permutations of integer arrays
- Counts comparisons performed by each algorithm
- Runs automated experiments for multiple input sizes
- Reports best, worst, and average performance

---

## Project Structure
```
CS-2430-Project-2/
├── src/algorithmPerformance/
│   ├── AlgorithmPerformance.java
│   ├── GeneratePermutations.java
│   ├── HeapSort.java
│   ├── MergeSort.java
│   ├── QuickSort.java
│   ├── ShakerSort.java
│   ├── SortResult.java
│   ├── SortingAlgorithm.java
│   └── TestDriver.java
├── test/algorithmPerformance/
│   ├── ArrayGeneratorTest.java
│   ├── HeapSortTest.java
│   ├── MergeSortTest.java
│   ├── QuickSortTest.java
│   ├── ShakerSortTest.java
│   └── TestDriverTest.java
├── lib/
│   └── junit-platform-console-standalone-1.11.4.jar
├── docs/
│   ├── Project2Plan.xlsx
│   ├── Project2_Pseudo.txt
│   ├── ScopeDocument.md
│   └── cs2430_AwesomeSauce_p2_Report.pdf
├── .idea/
│   └── IDE configuration files
└── README.md
```

---

## Getting Started

### Prerequisites
- Java Development Kit (JDK)
- IntelliJ IDEA or any Java-compatible IDE
- JUnit (included in the lib folder)

---

## How It Works
The program is executed through TestDriver.java, which:
- Generates all permutations of integer arrays
- Runs each sorting algorithm on every permutation
- Counts the number of comparisons performed
- Outputs performance results including best, worst, and average cases

---

## Project Details
- Course: CS 2430
- Team: Awesome Sauce
- Verification Lead: Nelson Long
- Implementation Lead: Ben Paul
- Communications Lead: Noah Kolling

---

## Files
- AlgorithmPerformance.java - Handles performance tracking and experiment logic
- GeneratePermutations.java - Generates permutations of input arrays
- SortingAlgorithm.java - Interface for sorting implementations
- HeapSort.java, MergeSort.java, QuickSort.java, ShakerSort.java - Sorting algorithm implementations
- SortResult.java - Stores and reports results
- TestDriver.java - Main entry point for running experiments
- cs2430_AwesomeSauce_p2_Report.pdf - Final report conatining analysis
- test/ - Unit tests for all major components
- lib/ - JUnit library for testing
- docs/ - Project documentation and planning materials

---

## Notes
- Only element-to-element comparisons are counted for performance analysis
- Results are reproducible by running TestDriver
