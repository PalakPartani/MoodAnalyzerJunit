package com.bridgelabz.moodanalyzer;

public class MoodAnalyzer {
    public String analyzeMood(String message) {
        if (message.contains("HAPPY")) {
            return "HAPPY";
        }
        return "SAD";
    }
}
