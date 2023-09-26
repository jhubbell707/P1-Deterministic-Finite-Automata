# Project 1: Deterministic Finite Automata

* Authors: Jimmy Hubbell
* Class: CS361
* Semester: Fall 2023

## Overview

This Java program using object oriented programming patterns to model Deterministic Finite Automaton.

## Compiling and Running

* To compile the program, execute the command:
```
$ ./gradew
```
* Now to use the dfa in other classes to create your own logic
```java
DFA dfa = new DFA();
dfa.addSigma('0');
dfa.addSigma('1');

dfa.addState("a");
dfa.addState("b");
dfa.setStart("a");
dfa.setFinal("b");

dfa.addTransition("a", "a", '0');
dfa.addTransition("a", "b", '1');
dfa.addTransition("b", "a", '0');
dfa.addTransition("b", "b", '1');
```

