package com.language;
    
import java.util.ArrayList;
import java.time.LocalDate;
/**
 * @author gracie
 */
public class Progress {
     /**
     * attributes for progress class
     */
    private int totalQuestionsAnswered;
    private int numCorrectAnswers;
    private Category currentCategory;
    private int progressInCategory;
    private int streak;
    private LocalDate loginDate;
    private ArrayList<String> missedWords;
    private Language language;

    public Progress(int totalQuestionsAnswered, int numCorrectAnswers, String currentCategory2, int progressInCategory, int streak2, ArrayList<String> missedWords, Language language) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
        this.numCorrectAnswers = numCorrectAnswers;
        this.currentCategory = currentCategory;
        this.progressInCategory = progressInCategory;
        this.streak = streak;
        this.missedWords = new ArrayList<String>();
        this.language = language;
    }


    public int getTotalQuestionsAnswered() {    
        return totalQuestionsAnswered;
    }

    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;

    }

    public int getNumCorrectAnswers() {
        return numCorrectAnswers;
    }

    public void setNumCorrectAnswers(int numCorrectAnswers){
        this.numCorrectAnswers = numCorrectAnswers;
    }

     /**
     * trackQuestion method
     * tracks the question and related information
     */

    public void trackQuestion() {
        totalQuestionsAnswered++;
        System.out.print("Tracking answers to the questions.");
    }

    /**
     * trackQuestion method
     * tracks the progress of the lesson
     */
    public void trackLesson() {
        progressInCategory++;
        System.out.print("Tracking the progress of the lesson");
    }

    /**
     * trackDaily method
     * tracks the user's daily participation
     */
    public void trackDaily() {
        LocalDate today = LocalDate.now();
        if (loginDate != null) {
            long daysSinceLogin = java.time.temporal.ChronoUnit.DAYS.between(loginDate, today);
            if (daysSinceLogin == 1) {
                streak++;
            }
            else if (daysSinceLogin > 1 ) {
                streak = 0;
            }
        }
        loginDate = today;
        System.out.print("Tracking the user's daily progress. Current streak: streak");
    }
    

    /**
     * trackPercentCorrect method
     * tracks the percentage of correct answers out of the total answers
     */
    public void trackPercentCorrect() {
        if (totalQuestionsAnswered == 0) {
            System.out.print("The user has not answered any questions yet.");
        }
        int perCorrect = (numCorrectAnswers / totalQuestionsAnswered) * 100;
        System.out.print("Tracking the percentage of correct answers. : The percentage of correct answers is: " + perCorrect + "%");
    }

    /**
     * trackCorrectAnswer method
     * tracks the amount of questions that have been answered correctly
     */
    public void trackCorrectAnswer() {
        numCorrectAnswers++;
        System.out.print("Tracking the number of correct answers. Total correct answers: " + numCorrectAnswers);
    }

    /**
     * currentCategory method
     * tracks the currentCategory the user is learning
     */
    public Category getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(Category currentCategory){
        this.currentCategory = currentCategory;
    }

     /**
     * progressInCategory method
     * @return the user's progress in the category
     * 
     */
    public int getProgressInCategory() {
        return progressInCategory;
    }

    public void setProgressInCategory(int progressInCategory){
        this.progressInCategory = progressInCategory;
    }

     //the progress in the category keeps going up//
     public void progressInLanguage()
     { 
         // how many catergories they complete 
        progressInCategory++; 
     }

     public Language getLanguage(){
        return language;
     }

     public void setLanguage(Language language){
        this.language = language;
     }
     /**
     * getMissedWords method
     * @return the list of missed words
     */
    public ArrayList<String> getMissedWords() {
        return missedWords;
    }

    public ArrayList<String> getProgress() {
        ArrayList<String> progressInfo = new ArrayList<>();
        progressInfo.add("Total Questions Answered: " + totalQuestionsAnswered);
        progressInfo.add("Number of Correct Answers: " + numCorrectAnswers);
        progressInfo.add("Progress in Category: " + progressInCategory);
        progressInfo.add("Missed Words: " + missedWords.toString());
        return progressInfo;
    }

     /**
     * saveProgress method
     * saves the user's progress in the language and category
     */
    public void saveProgress() {
       // boolean savedProgress = DataWriter.saveProgress(this);
       DataWriter.saveProgress(this);
        
    }  
    
    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak){
        this.streak = streak;
    }


}
