package com.bridgelabz.moodanalyzer;

import org.junit.Assert;
import org.junit.Test;

public class MoodAnalyzerTest {

    private MoodAnalyzer moodAnalyzer;

    //tc1.1
    @Test
    public void givenHappyMoodInMethod_ShouldReturnHappy() {
        moodAnalyzer = new MoodAnalyzer();
        try {
            String mood = moodAnalyzer.analyzeMood("I am in Happy Mood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    //tc1.2
    @Test
    public void givenSadMoodInMethod_ShouldReturnSad() {
        moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    //refactored tc1.1
    @Test
    public void givenHappyMoodInConstructor_ShouldReturnHappy() {
        moodAnalyzer = new MoodAnalyzer("I am in Happy Mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    //tc1.2
    @Test
    public void givenSadMoodInConstructor_ShouldReturnSad() {
        moodAnalyzer = new MoodAnalyzer("I am in Sad Mood");
        try {
            String mood = moodAnalyzer.analyzeMood();
            Assert.assertEquals("SAD", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    //tc2.1
    @Test
    public void givenMood_whenNull_shouldReturnHappy() {
        moodAnalyzer = new MoodAnalyzer(null);
        try {
            Assert.assertEquals("HAPPY", moodAnalyzer.analyzeMood());
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    //tc3.1
    @Test
    public void givenNullMood_ShouldReturnMessage() {

        try {

            moodAnalyzer = new MoodAnalyzer(null);
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException ex) {
            Assert.assertEquals(MoodAnalyzerException.moodException.ENTERED_NULL, ex.type);
        }
    }

    //tc3.2
    @Test
    public void givenEmptyMood_ShouldReturnMessage() {

        try {
            moodAnalyzer = new MoodAnalyzer("");
            moodAnalyzer.analyzeMood();
        } catch (MoodAnalyzerException ex) {
            Assert.assertEquals(MoodAnalyzerException.moodException.ENTERED_EMPTY, ex.type);
        }
    }

    //tc4.1
    @Test
    public void givenMoodAnalyzerClassWithDefaultConstructor_WhenProper_ShouldReturnObjectEqual() {
        MoodAnalyzer moodAnalyzerFactory = MoodAnalyzerFactory.createMoodAnalyzerUsingFactory();
        Assert.assertEquals(new MoodAnalyzer(), moodAnalyzerFactory);
    }

    //tc4.2
    @Test
    public void givenClassName_WhenImproper_ShouldThrowMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.getConstructor("com.brigdelabz.moodanalyzer.MoodAnalyzer1", String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.moodException.NO_SUCH_CLASS, e.type);
        }
    }

    //tc 4.3
    @Test
    public void givenConstructorName_WhenImproper_ShouldReturnMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyzer.MoodAnalyzer", Integer.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.moodException.NO_SUCH_METHOD, e.type);
        }
    }

    //tc5.1
    @Test
    public void givenMoodAnalyzerClassWithParameterizedConstructor_WhenProper_ShouldReturnObjectEqual() {
        MoodAnalyzer mood = MoodAnalyzerFactory.createMoodAnalyzerUsingFactory("I am in Happy mood");
        Assert.assertEquals(new MoodAnalyzer("I am in Happy mood"), mood);
    }

    //tc5.2
    @Test
    public void givenClassNameInParameterized_WhenImproper_ShouldThrowMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.getConstructor("com.brigdelabz.moodanalyzer.MoodAnalyzer1", String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.moodException.NO_SUCH_CLASS, e.type);
        }
    }

}