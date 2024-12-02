package com.develogical;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class QueryProcessor {

    public static final String SHAKESPEARE_RESPONSE = "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
    public static final String NAME = "SD";


    public String process(String query) {

        String processedQuery = query.toLowerCase();




        if (processedQuery.contains("shakespeare")) {
            return SHAKESPEARE_RESPONSE;
        }

        if (processedQuery.equals("what is your name?")) {
            return NAME;
        }

        if (processedQuery.contains("your name")) {
            return NAME;
        }

        if (processedQuery.contains("prime")) {
            List<Integer> primes = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(query);
        while (matcher.find()) {
            int number = Integer.parseInt(matcher.group());
            if (isPrime(number)) {
                primes.add(number);
                }
            }
            return primes.toString();
        }


        String[] parts = processedQuery.split("[^0-9]+");
        int largest = Integer.MIN_VALUE; 
        // Initialize with the smallest possible value
        // Loop through the parts to find numbers and determine the largest
        for (String part : parts) { 
            if (!part.isEmpty()) { 
            // Ignore empty strings
            int number = Integer.parseInt(part); 
            if (number > largest) { largest = number; } 
        } 
    }
        if(processedQuery.contains("minus")) {
            Pattern pattern = Pattern.compile("What is (\\d+) minus (\\d+)\\?");
            Matcher matcher = pattern.matcher(processedQuery);
            if (matcher.find()) {
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));
                return String.valueOf(num1 - num2);
            }
        }

        if(processedQuery.contains("multiplied")) {
            Pattern pattern = Pattern.compile("(\\d+)\\s*multiplied by\\s*(\\d+)");
            Matcher matcher = pattern.matcher(processedQuery);
            if (matcher.find()) {
                int num1 = Integer.parseInt(matcher.group(1));
                int num2 = Integer.parseInt(matcher.group(2));
            return String.valueOf(num1 * num2);
        }
        }


        if (processedQuery.startsWith("which of the following numbers is the largest")) {
            List<Integer> numbers = new ArrayList<>();
            Pattern pattern = Pattern.compile("\\d+");
            Matcher matcher = pattern.matcher(processedQuery);
            while (matcher.find()) {
                numbers.add(Integer.parseInt(matcher.group()));
            }
            return String.valueOf(Collections.max(numbers));        
        }

        return "extra";
    }

private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }
}