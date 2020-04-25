package com.bridgelabz.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//opn prm
public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzerUsingFactory() {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyzer.MoodAnalyzer").getConstructor();
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) constructor.newInstance();
            return moodAnalyzer;
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor getConstructor(String className, Class constructor) {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            return moodAnalyzer.getConstructor(constructor);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static MoodAnalyzer createMoodAnalyzerUsingFactory(String message) {
        try {
            Constructor constructor = Class.forName("com.bridgelabz.moodanalyzer.MoodAnalyzer").getConstructor(String.class);
            MoodAnalyzer reflectionMood = (MoodAnalyzer) constructor.newInstance(message);
            return reflectionMood;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String invokeMethod(MoodAnalyzer moodAnalyzer, String methodName) {
        try {
            return (String) moodAnalyzer.getClass().getDeclaredMethod(methodName).invoke(moodAnalyzer);
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.NO_SUCH_METHOD, e.getMessage());
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }
}
