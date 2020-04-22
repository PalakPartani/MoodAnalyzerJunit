package com.bridgelabz.moodanalyzer;

public class MoodAnalyzer {
    private String message;
    public MoodAnalyzer() {

    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }



    public String analyzeMood() throws MoodAnalyzerException {

        try {
            if (message.contains("")) {
                throw new MoodAnalyzerException(MoodAnalyzerException.moodException.ENTERED_EMPTY, "This is empty");
            } else if (message.contains("Happy")) {
                return "HAPPY";
            }
            return "SAD";
        } catch (NullPointerException ex) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.ENTERED_NULL, "This mood is invalid!");
        }
    }
}

