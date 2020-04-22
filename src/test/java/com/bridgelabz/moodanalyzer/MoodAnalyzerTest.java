package com.bridgelabz.moodanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenHappyMood_ShouldReturnHappy() {

        MoodAnalyzer moodanalyzer = new MoodAnalyzer("I am in happy mood ");
        String mood = moodanalyzer.analyzeMood();
        Assert.assertEquals("HAPPY", mood);

    }

    @Test
    public void givenSadMood_Should_ReturnSad() {
        MoodAnalyzer moodanalyzer = new MoodAnalyzer("I am in sad mood ");
        String mood = moodanalyzer.analyzeMood();
        Assert.assertEquals("SAD", mood);
    }

    @Test
    public void givenNullMood_ShouldReturnMessage() {
        MoodAnalyzer moodanalyzer = new MoodAnalyzer(null);

        try {

            moodanalyzer.analyzeMood();

        } catch (NullPointerException ex) {
            Assert.assertEquals("HAPPY", ex.getMessage());

        }
    }
}
