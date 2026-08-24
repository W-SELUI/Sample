# Algorithm Grand Prix

## Overview

This project was developed for CS214: Design & Analysis of Algorithms.

The system analyses and compares the performance of multiple sorting algorithms using the World University Rankings 2023 dataset. The project includes benchmarking, operation counting, statistical analysis, graphical visualisation and an interactive Algorithm Grand Prix race simulation.

## Features

- Insertion Sort
- Bubble Sort
- Merge Sort
- Java Built-In Sort
- ArrayList and LinkedList support
- Runtime benchmarking
- Operation counting
- Best, Mean, Median and Worst-case analysis
- CSV export functionality
- MATLAB graph generation
- Interactive Algorithm Grand Prix GUI
- Algorithm race animation
- Comparator selection

## Dataset

Dataset used:

World University Rankings 2023-Cleaned.csv

Each university record contains information such as:

- Name
- Rank
- Score
- Location

## Sorting Algorithms Implemented

### Insertion Sort

Custom implementation supporting generic List collections.

### Bubble Sort

Custom implementation supporting generic List collections.

### Merge Sort

Custom implementation supporting generic List collections.

### Built-In Sort

Implemented using Java Collections.sort().

## Comparators

The following comparators were implemented:

- NameComparator
- RankComparator
- ScoreComparator
- LocationComparator

Users can dynamically select the sorting criterion during the Algorithm Grand Prix race.

## Benchmarking

Each algorithm was executed:

- 30 times
- Using randomized datasets
- Across multiple dataset sizes

The following statistics were collected:

- Best
- Mean
- Median
- Worst

Generated file:

- StatisticsResults.csv

## Operation Analysis

Operation counting was implemented to analyse algorithm complexity.

Metrics collected include:

- Comparisons
- Swaps
- Movements

Generated file:

- CounterStatistics.csv

## Data Structure Analysis

Sorting performance was compared using:

- ArrayList
- LinkedList

Generated file:

- StructureStatistics.csv

## Algorithm Grand Prix

The Algorithm Grand Prix is a GUI simulation where:

1. Users select a comparator
2. A countdown begins
3. Sorting algorithms race simultaneously
4. Results are displayed after the race completes

Available sort fields:

- Name
- Rank
- Score
- Location

## Graphs Generated

### Runtime Analysis

- Mean Runtime vs Dataset Size
- Best Runtime vs Dataset Size
- Median Runtime vs Dataset Size
- Worst Runtime vs Dataset Size
- Log Runtime Graph

### Operation Analysis

- Mean Operations vs Dataset Size
- Log Mean Operations vs Dataset Size
- Best Operations vs Dataset Size
- Worst Operations vs Dataset Size

### Data Structure Analysis

- Impact of ArrayList vs LinkedList on Sorting Performance

## How to Run

### Run the Application

Execute:

Main.java

This launches the Algorithm Grand Prix GUI.

### Generate Runtime Statistics

Execute:

StatisticsExporter.java

Output:

StatisticsResults.csv

### Generate Operation Statistics

Execute:

CounterStatisticsExporter.java

Output:

CounterStatistics.csv

### Generate Data Structure Statistics

Execute:

StructureStatisticsExporter.java

Output:

StructureStatistics.csv

## Project Structure

- Main.java
- RaceAnimationDemo.java
- RaceGUI.java
- SortRaceThread.java
- RaceResult.java

Algorithms:

- InsertionSort.java
- BubbleSort.java
- MergeSort.java
- BuiltInSort.java

Comparators:

- NameComparator.java
- RankComparator.java
- ScoreComparator.java
- LocationComparator.java

Analysis:

- Benchmark.java
- BenchmarkStatistics.java
- StatisticsExporter.java
- CounterBenchmark.java
- CounterStatisticsExporter.java
- StructureStatisticsExporter.java

## Authors

CS214 Assignment 1

Algorithm Grand Prix Project

Root | Knox | Tom
