package com.language;
    
/**
 * @author zaniah, sri, gracie, and grace
 */

public class Question {

    protected String question;
    /**
     * Constructor for Question
     */
    public Question() {

    }

    public Question(String question) {
        this.question = question;
    }

    /**
     * getQuestion method
     * Returns the question 
     * @return question
     */
    public String getQuestion() {

        return question;
    }

    /**
     * setQuestion method
     * Sets the question 
     * @param question
     */
    public void setQuestion(String question) {
        this.question = question;
    }

    /**
     * makeFlashcards method
     * Returns the questions for the flashcards
     * @return question for flashcards
     */
    public String makeFlashCards() {
        return "Question for flashcard" + question;
    }

    
}
