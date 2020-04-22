package com.bridgelabz.moodanalyzer;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood() {
        try {
            if (message.contains("happy")) {
                return "HAPPY";
            }
            return "SAD";
        } catch (NullPointerException e) {
            throw new NullPointerException(e.getMessage());
        }
    }
}

