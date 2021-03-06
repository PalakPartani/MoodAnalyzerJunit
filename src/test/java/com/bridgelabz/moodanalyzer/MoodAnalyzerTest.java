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
    public void givenClassNameInParameterizedConstructor_WhenImproper_ShouldThrowMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.getConstructor("com.brigdelabz.moodanalyzer.MoodAnalyzer1", String.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.moodException.NO_SUCH_CLASS, e.type);
        }
    }

    //tc 5.3
    @Test
    public void givenConstructorNameInParameterizedConstructor_WhenImproper_ShouldReturnMoodAnalyzerException() {
        try {
            MoodAnalyzerFactory.getConstructor("com.bridgelabz.moodanalyzer.MoodAnalyzer", int.class);
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.moodException.NO_SUCH_METHOD, e.type);
        }
    }

    //tc 6.1

    @Test
    public void givenHappyMessageUsingReflection_WhenProper_ShouldReturnHappyMood() {
        try {
            MoodAnalyzer moodObject = MoodAnalyzerFactory.createMoodAnalyzerUsingFactory("I am in Happy mood");
            String mood = MoodAnalyzerFactory.invokingMethod(moodObject, "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    //tc 6.2

    @Test
    public void givenHappyMessageUsingReflection_WhenImProper_ShouldThrowException() {
        try {
            MoodAnalyzer moodObject = MoodAnalyzerFactory.createMoodAnalyzerUsingFactory("I am in Happy mood");
            MoodAnalyzerFactory.invokingMethod(moodObject, "analyseMood");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.moodException.NO_SUCH_METHOD, e.type);
        }
    }

    //tc7.1
    @Test
    public void givenFieldValueReflection_WhenProper_ShouldReturnValue() {
        MoodAnalyzer moodAnalyzer = MoodAnalyzerFactory.createMoodAnalyzerUsingFactory();
        try {
            String mood = (String) MoodAnalyzerFactory.invokingField(moodAnalyzer, "I am in Happy Mood", "message", "analyzeMood");
            Assert.assertEquals("HAPPY", mood);
        } catch (MoodAnalyzerException e) {
            e.printStackTrace();
        }
    }

    //tc7.2
    @Test
    public void givenFieldValueReflection_WhenImproper_ShouldThrowException() {

        MoodAnalyzer moodAnalyzerUsingFactory = MoodAnalyzerFactory.createMoodAnalyzerUsingFactory();
        try {
            MoodAnalyzerFactory.invokingField(moodAnalyzerUsingFactory, "I am in Happy mood", "msg", "analyzeMood");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.moodException.NO_SUCH_FIELD, e.type);
        }
    }

    //tc7.3

    @Test
    public void givenNullValueUsingReflection_WhenProper_ShouldThrowException() {
        MoodAnalyzer moodAnalyzerUsingFactory = MoodAnalyzerFactory.createMoodAnalyzerUsingFactory();

        try {
            MoodAnalyzerFactory.invokingField(moodAnalyzerUsingFactory, null, "message", "analyzeMood");
        } catch (MoodAnalyzerException e) {
            Assert.assertEquals(MoodAnalyzerException.moodException.FIELD_INVOCATION_ISSUE, e.type);
        }

    }
}
