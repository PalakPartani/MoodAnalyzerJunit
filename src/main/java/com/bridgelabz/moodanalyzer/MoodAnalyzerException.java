package com.bridgelabz.moodanalyzer;

public class MoodAnalyzerException extends RuntimeException {
    public enum moodException{
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD;
    }
    public moodException type;
    public MoodAnalyzerException(moodException type, String message) {
        super(message);
        this.type=type;
    }
}
