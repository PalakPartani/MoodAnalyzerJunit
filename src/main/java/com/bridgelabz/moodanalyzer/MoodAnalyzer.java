package com.bridgelabz.moodanalyzer;

public class MoodAnalyzer {
    private String message;

    public MoodAnalyzer() {
        message = "default";
    }

    public MoodAnalyzer(String message) {
        this.message = message;
    }

    public String analyzeMood(String message) {

        try {
            if (message.equals("")) {
                throw new MoodAnalyzerException(MoodAnalyzerException.moodException.ENTERED_EMPTY, "This is empty");
            } else if (message.contains("Sad")) {
                return "SAD";
            }
            return "HAPPY";
        } catch (NullPointerException ex) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.ENTERED_NULL, "This mood is invalid!");
        }
    }

    public String analyzeMood() {
        return analyzeMood(this.message);
    }

    @Override
    public boolean equals(Object that) {
        if (this.message.equals(((MoodAnalyzer) that).message))
            return true;
        return false;
    }
}