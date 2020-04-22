package com.bridgelabz.moodanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    @Test
    public void givenHappyMood_ShouldReturnHappy()  {

        MoodAnalyzer moodanalyzer = new MoodAnalyzer();
        String mood = moodanalyzer.analyzeMood("HAPPY");
        Assert.assertEquals("HAPPY", mood);

    }
}
