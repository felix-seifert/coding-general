package com.felixseifert.codinggeneral;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {

    public static void main(String[] args) {

        // Generate a list of 1000 integers in the interval [0,100]
        List<Integer> list = generateList(1000, 0, 100);

        // Invoke two different algorithms to calculate how many pairs
        // all numbers could form with the others to sum up to 100
        System.out.println("Result of possibilitiesToCombine: " +
                PossibilitiesToCombine.possibilitiesToCombine(list, 100));
        System.out.println("Result of possibilitiesToCombineImproved: " +
                PossibilitiesToCombine.possibilitiesToCombineImproved(list, 100));
    }

    /**
     * Generates a list of random integers
     * @param length Length of the list
     * @param min Lower bound of the list
     * @param max Upper bound of the list
     * @return A list of integers
     */
    private static List<Integer> generateList(long length, int min, int max) {
        List<Integer> list = new LinkedList<>();
        new Random().ints(length, min, max + 1).forEach(number -> list.add(number));
        return list;
    }
}
