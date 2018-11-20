package com.felixseifert.codinggeneral;

import java.time.Duration;
import java.time.Instant;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

public class PossibilitiesToCombine {

    private final static Logger LOGGER = Logger.getLogger(PossibilitiesToCombine.class.getName());

    /**
     * Calculates how often each number could be combined with another one to sum up to the target.
     * Stores how often a value could be combined to avoid loops.
     *
     * @param list List of integers to be checked
     * @param targetValue Target value which the summation of to numbers should reach
     * @return The number how often each integer could be combined with another one
     */
    public static long possibilitiesToCombineImproved(List<Integer> list, long targetValue) {

        // Duration of the algorithm will be logged
        Instant start = Instant.now();

        long result = 0, listSize = list.size(), tempForChecked;
        int number;

        // Map for storing already checked values
        Map<Integer, Long> checked = new HashMap<>();

        for(int i = 0; i < listSize; i++) {

            number = list.get(i);

            // Check whether the currently looped value was already checked
            if(checked.containsKey(number)) {
                result += checked.get(number);
            }
            // If the current value was not checked, compare it to all the other numbers.
            else {
                tempForChecked = 0;
                for(int j = 0; j < listSize; j++) {
                    if(number + list.get(j) == targetValue && i != j) {
                        tempForChecked++;
                    }
                }
                result += tempForChecked;
                checked.put(number, tempForChecked);
            }
        }

        Instant end = Instant.now();

        LOGGER.info(String.format("possibilitiesToCombineImproved() needed %d milliseconds.",
                Duration.between(start, end).toMillis()));

        return result/2;
    }

    /**
     * Calculates how often each number could be combined with another one to sum up to the target.
     *
     * @param list List of integers to be checked
     * @param targetValue Target value which the summation of the numbers should reach
     * @return The number how often each integer could be combined with another one
     */
    public static long possibilitiesToCombine(List<Integer> list, long targetValue) {

        // Duration of the algorithm will be logged
        Instant start = Instant.now();

        long result = 0, listSize = list.size();
        int number;

        for(int i = 0; i < listSize; i++) {

            number = list.get(i);

            // Try whether the current number sums up to the target value with every other number
            for(int j = 0; j < listSize; j++) {
                if (number + list.get(j) == targetValue && i != j) {
                    result++;
                }
            }
        }

        Instant end = Instant.now();

        LOGGER.info(String.format("possibilitiesToCombine() needed %d milliseconds.",
                Duration.between(start, end).toMillis()));

        return result/2;
    }
}