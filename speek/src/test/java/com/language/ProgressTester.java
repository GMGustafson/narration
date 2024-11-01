package com.language;

import com.language.CategorySystemFacade;
import com.language.User;
import static org.junit.Assert.*;
import org.junit.Before;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.junit.Test;

public class ProgressTester {
    private Progress progress;

    @Before
    public void setup(){
        progress = new Progress();
    }

    // resetCategoryProgress method

    /**
     * reset totalQuestionsAnswered to 0
     */
    @Test
    public void resetCategoryTotalQuestionsTest() {
        progress.setTotalQuestionsAnswered(10);
        progress.resetCategoryProgress();
        assertEquals(0, progress.getTotalQuestionsAnswered());
    }

    /**
     * reset numCorrectAnswers to 0
     */
    @Test
    public void ResetCategoryCorrectAnswersTest() {
        progress.setNumCorrectAnswers(5);
        progress.resetCategoryProgress();
        assertEquals(0, progress.getNumCorrectAnswers());
    }

    /**
     * clear missed words when category resets
     */
    @Test
    public void resetCategoryMissedWordsTest() {
        progress.addMissedWords("apple");
        progress.resetCategoryProgress();
        assertTrue(progress.getMissedWords().isEmpty());
    }

    // setTotalQuestionsAnswered
    @Test
    public void setTotalQuestionsAnsweredTest() {
        progress.setTotalQuestionsAnswered(5);
        assertEquals(5, progress.getTotalQuestionsAnswered());
    }

    public void setTotalQuestionsAnsweredZeroTest() {
        progress.setTotalQuestionsAnswered(0);
        assertEquals(0, progress.getTotalQuestionsAnswered());
    }

    // setNumCorrectAnswers/getNumCorrectAnswers
    @Test
    public void setNumCorrectAnswersTest() {
        progress.setNumCorrectAnswers(7);
        assertEquals(7, progress.getNumCorrectAnswers());
    }

    //setCurrentCategory/getCurrentCategory

    /**
     * CurrentCategory returns current category user is on
     */
    @Test
    public void setAndGetCategoryTest() {
        progress.setCurrentCategory("colors");
        assertEquals("colors", progress.getCurrentCategory());
    }

    
    @Test
    public void setWrongCategoryTest() {
        progress.setCurrentCategory("Animals");
        assertEquals("Not a valid category", progress.getCurrentCategory());
    }

    // addMissedWords/getMissedWords 

    /**
     * add one word to missedWords 
     */
    @Test
    public void addMissedWordTest() {
        progress.addMissedWords("cinco");
        assertTrue(progress.getMissedWords().contains("cinco"));
    }

    /**
     * add multiple words to missedWords 
     */
    @Test
    public void addMultipleMissedWordsTest() {
        progress.addMissedWords("rojo");
        progress.addMissedWords("azul");
        progress.addMissedWords("verde");
        assertEquals(3, progress.getMissedWords().size());
    }

    //trackQuestion 

    /**
     *  totalQuestionsAnswered increase by 1
     */
    @Test
    public void trackQuestionIncreaseTest() {
        progress.trackQuestion();
        assertEquals(1, progress.getTotalQuestionsAnswered());
    }

    // trackCorrectAnswer

    /**
     *  numCorrectAnswers increase by 1
     */
    @Test
    public void trackCorrectAnswerIncreaseTest() {
        progress.trackCorrectAnswer();
        assertEquals(1, progress.getNumCorrectAnswers());
    }

    // trackPercentCorrect 

    /**
     * stay on same category if score < 80%.
     */
    @Test
    public void trackPercentCorrectLowScoreTest() {
        progress.setNumCorrectAnswers(6);
        progress.setTotalQuestionsAnswered(10);
        progress.trackPercentCorrect();
        assertEquals(6, progress.getNumCorrectAnswers());
    }

    /**
     * go to next category if score >= 80%.
     */
    @Test
    public void trackPercentCorrectHighScoreTest() {
        progress.setNumCorrectAnswers(8);
        progress.setTotalQuestionsAnswered(10);
        progress.trackPercentCorrect();
    }

    // Tests for goToNextCategory method
    @Test
    public void goToNextCategoryTest() {
        progress.setCurrentCategory("colors");
        progress.goToNextCategory();
        assertEquals("people", progress.getCurrentCategory()); 
    }


}
