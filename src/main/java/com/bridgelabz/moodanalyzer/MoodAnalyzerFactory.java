package com.bridgelabz.moodanalyzer;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class MoodAnalyzerFactory {
    public static MoodAnalyzer createMoodAnalyzerUsingFactory() {
        try {
            Constructor constructor = getConstructor("com.bridgelabz.moodanalyzer.MoodAnalyzer");
            MoodAnalyzer moodAnalyzer = (MoodAnalyzer) constructor.newInstance();
            return moodAnalyzer;
        } catch (InvocationTargetException | InstantiationException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static Constructor getConstructor(String className, Class... constructor) {
        try {
            Class<?> moodAnalyzer = Class.forName(className);
            if (constructor.length == 0)
                return moodAnalyzer.getConstructor();
            return moodAnalyzer.getConstructor(constructor[0]);
        } catch (ClassNotFoundException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.NO_SUCH_CLASS, e.getMessage());
        } catch (NoSuchMethodException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.NO_SUCH_METHOD, e.getMessage());
        }
    }

    public static MoodAnalyzer createMoodAnalyzerUsingFactory(String message) {
        try {
            Constructor constructor = getConstructor("com.bridgelabz.moodanalyzer.MoodAnalyzer", String.class);
            MoodAnalyzer reflectionMood = (MoodAnalyzer) constructor.newInstance(message);
            return reflectionMood;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public static String invokingMethod(Object moodAnalyzer, String methodName) {
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

    public static Object invokingField(Object moodAnalyzer, String message, String fieldName, String methodName) {
        try {

            Field field = moodAnalyzer.getClass().getDeclaredField(fieldName);
            field.setAccessible(true);
            field.set(moodAnalyzer, message);
            return moodAnalyzer.getClass().getDeclaredMethod(methodName).invoke(moodAnalyzer);
        } catch (NoSuchFieldException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.NO_SUCH_FIELD, e.getMessage());
        } catch (IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            throw new MoodAnalyzerException(MoodAnalyzerException.moodException.FIELD_INVOCATION_ISSUE, e.getMessage());
        }
        return null;
    }
}


