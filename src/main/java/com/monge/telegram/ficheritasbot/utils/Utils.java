/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.monge.telegram.ficheritasbot.utils;

/**
 *
 * @author DeliveryExpress
 */
public class Utils {


    /**
     * Checks if a given string is a positive answer.
     *
     * @param input The string to validate.
     * @return true if the string represents a positive answer, false otherwise.
     */
    public static boolean isPositiveAnswer(String input) {
        if (input == null || input.trim().isEmpty()) {
            return false; // Null or empty strings are not positive answers
        }

        // Define positive answers
        String[] positiveAnswers = {"yes", "y", "si", "ok", "yeah", "sure", "of course"};

        // Normalize the input by trimming and converting to lowercase
        String normalizedInput = input.trim().toLowerCase();

        // Check if the normalized input is in the list of positive answers
        for (String answer : positiveAnswers) {
            if (normalizedInput.equals(answer)) {
                return true;
            }
        }

        return false;
    }

    
}
