package com.bridgelabz.moodanalyzer;

public class MoodAnalyzerException extends RuntimeException {
    public enum moodException{
        ENTERED_NULL,ENTERED_EMPTY,NO_SUCH_CLASS,NO_SUCH_METHOD, FIELD_INVOCATION_ISSUE, NO_SUCH_FIELD;
    }
    public moodException type;
    public MoodAnalyzerException(moodException type, String message) {
        super(message);
        this.type=type;
    }
}
