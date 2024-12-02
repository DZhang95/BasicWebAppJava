package com.develogical;

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

        // Split the string by spaces and punctuation to isolate numbers 
        String[] parts = processedQuery.split("[^0-9]+"); int largest = Integer.MIN_VALUE; 
        // Initialize with the smallest possible value
        // Loop through the parts to find numbers and determine the largest
        for (String part : parts) { if (!part.isEmpty()) { 
            // Ignore empty strings
            int number = Integer.parseInt(part);
             if (number > largest) { largest = number; 
            } 
        } 
        return String.valueOf(largest);
    }

        parts = processedQuery.split("[^0-9]+");
        largest = Integer.MIN_VALUE; 
        // Initialize with the smallest possible value
        // Loop through the parts to find numbers and determine the largest
        for (String part : parts) { if (!part.isEmpty()) { 
            // Ignore empty strings
            int number = Integer.parseInt(part); 
            if (number > largest) { largest = number; } 
        } 
    }


        if (processedQuery.startsWith("which of the following numbers is the largest")) {
            String[] splitString = processedQuery.split(" ");
            int a = Integer.parseInt(splitString[splitString.length - 1]);
            int b = Integer.parseInt(splitString[splitString.length - 2]);
            String temp = splitString[splitString.length - 3].split("?")[0];
            int c = Integer.parseInt(temp);
            return String.valueOf( Math.max(a, Math.max(b, c)));             
        }

        return "extra";
    }

}