package com.bridgelabz.moodanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {


    @Test
    public void givenHappyMoodShouldReturnHappy() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void givenSadMoodShouldReturnSad() {
        MoodAnalyzer moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }


    @Test
    public void givenNullMood_ShouldReturnMessage1() throws MoodAnalyzerException {
        MoodAnalyzer moodanalyzer = new MoodAnalyzer(null);
        try {
            moodanalyzer.analyzeMood();
        } catch (NullPointerException ex) {
            Assert.assertEquals("This mood is invalid!", ex.getMessage());
        }
    }
    @Test
    public void givenNullMood_ShouldReturnMessage() {

        try {

            MoodAnalyzer moodanalyzer = new MoodAnalyzer();
             moodanalyzer.analyzeMood();
        } catch (MoodAnalyzerException ex) {
            Assert.assertEquals(MoodAnalyzerException.moodException.ENTERED_NULL, ex.type);
        }
    }
}
