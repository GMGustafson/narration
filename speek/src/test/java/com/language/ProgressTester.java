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

    @Test
    public void resetCatProTotalTest(){
        progress.setTotalQuestionsAnswered(5);
        progress.resetCategoryProgress();
        assertEquals(5, progress.getTotalQuestionsAnswered());
    }
    @Test
    public void resetCatProCorrectTest(){
        progress.setNumCorrectAnswers(10);
        progress.resetCategoryProgress();
        assertEquals(0, progress.getNumCorrectAnswers());
    }
    @Test
    public void resetCatProMissedTest(){
        progress.addMissedWords("cinco");
        progress.resetCategoryProgress();
        assertTrue(progress.getMissedWords().isEmpty());
    }
}
