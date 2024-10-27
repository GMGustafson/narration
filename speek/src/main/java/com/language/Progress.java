package com.language;
    
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.time.LocalDate;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class Progress {
     /**
     * attributes for progress class
     */
    private int totalQuestionsAnswered;
    private int numCorrectAnswers;
    private String currentCategory;
    private int progressInCategory;
    private int streak;
    private ArrayList<String> missedWords;

    private static final String[] categories = {"numbers", "colors", "places", "weather", "people"};


    public Progress() {
        missedWords = new ArrayList<>();
    }

    public Progress(int totalQuestionsAnswered, int numCorrectAnswers, String currentCategory, 
    int progressInCategory, int streak, ArrayList<String> missedWords) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
        this.numCorrectAnswers = numCorrectAnswers;
        this.currentCategory = currentCategory;
        this.progressInCategory = progressInCategory;
        this.streak = streak;
        this. missedWords = missedWords;
    }

    /**
    * resetCategoryProgress method
    * resets progres in category to 0
    */
    public void resetCategoryProgress() {
        this.totalQuestionsAnswered = 0;
        this.numCorrectAnswers = 0;
        this.progressInCategory = 0;
        this.missedWords.clear();
        System.out.println("Category progress has been reset.");
    }

    /**
    * getTotalQuestionsAnswered method
    * gets totalQuestionsAnswered
    * @return  totalQuestionsAnswered
    */
    public int getTotalQuestionsAnswered() {    
        return totalQuestionsAnswered;
    }

    /**
    * setTotalQuestionsAnswered method
    * sets totalQuestionsAnswered
    */
    public void setTotalQuestionsAnswered(int totalQuestionsAnswered) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;

    }

    /**
    * getNumCorrectAnswers method
    * gets numCorrectAnswers
    * @return  numCorrectAnswers
    */
    public int getNumCorrectAnswers() {
        return numCorrectAnswers;
    }

    /**
    * setNumCorrectAnswers method
    * sets numCorrectAnswers
    */
    public void setNumCorrectAnswers(int numCorrectAnswers){
        this.numCorrectAnswers = numCorrectAnswers;
    }

    /**
    * getCurrentCategorymethod
    * get currentCategory
    * @return currentCategory
    */
    public String getCurrentCategory() {
        return currentCategory;
    }

    /**
    * setCurrentCategory method
    * sets currentCategory
    */
    public void setCurrentCategory(String currentCategory){
        this.currentCategory = currentCategory;
    }

    /**
    * getProgressInCategory method
    * gets progressInCategory
    */
    public int getProgressInCategory() {
        return progressInCategory;
    }

    /**
    * getStreak method
    * gets streak
    * @return streak
    */
    public int getStreak() {
        return streak;
    }

    /**
    * setStreak method
    * sets streak
    */
    public void setStreak(int streak) {
        this.streak = streak;
    }

    /**
    * setProgressInCategory method
    * sets progressInCategory
    */
    public void setProgressInCategory(int progressInCategory){
        this.progressInCategory = progressInCategory;
    }

    /**
    * getMissedWords method
    * adds missed words to the missedWords list
    * @return missedWords
    */
    public ArrayList<String> getMissedWords() {
        return missedWords;
    }

    /**
    * addMissedWords method
    * adds missed words to the missedWords list
    */
    public void addMissedWords(String word) {
        missedWords.add(word);
    }

    /**
     * trackQuestion method
     * tracks the question and related information
     */
    public void trackQuestion() {
        totalQuestionsAnswered++;
        System.out.println("Question tracked. Total questions answered: " + totalQuestionsAnswered);
    }

     /**
     * trackLesson method
     * tracks the progress in lesson and related information
     */
    public void trackLesson() {
        progressInCategory++;
        // if (progressInCategory == 1) {
        //     List<String> categories = categories.getCategories();
        //     Category currentCategory.setCurrentCategory();
        // }
        System.out.print("Tracking the progress of the lesson");
    }
    

    /**
     * trackPercentCorrect method
     * tracks the percentage of correct answers out of the total answers
     */
    public void trackPercentCorrect() {

        if (totalQuestionsAnswered == 0) {
            System.out.println("No questions have been answered yet.");
            return;
        }

        double percentCorrect = ((double) numCorrectAnswers / totalQuestionsAnswered) * 100;
        System.out.println("Percentage of correct answers: " + percentCorrect + "%");

        if (percentCorrect >= 80) {
            System.out.println("Moving to next Category!");
            goToNextCategory();
        } else {
            System.out.println("Score too low to advance. Must achieve at least 80%.");
        }
    }

    /**
     * trackCorrectAnswer method
     * tracks the amount of questions that have been answered correctly
     */
    public void trackCorrectAnswer() {
        numCorrectAnswers++;
        totalQuestionsAnswered++;
        System.out.print("Tracking the number of correct answers. Total correct answers: " + numCorrectAnswers);
    }

    /**
    * goToNextCategory method
    * switches the user to the next possible category once the user has passed it
    */
    public void goToNextCategory() {
        // progressInCategory++;
        // if (progressInCategory == 1){
        //     currentCategory = "numbers";
        // }
        // if (progressInCategory == 2){
        //     currentCategory = "colors";
        // }
        // if (progressInCategory == 3){
        //     currentCategory = "places";
        // }
        // if (progressInCategory == 4) {
        //     currentCategory = "weather";
        // }
        // if (progressInCategory == 5) {
        //     currentCategory = "people";
        // }
        // if (progressInCategory == 6) {
        //     switchToNextCourse();
        // }
        if (progressInCategory < categories.length) {
            currentCategory = categories[progressInCategory];
            trackLesson();
        } 
        else {
            switchToNextCourse();
        }    
    }

    /**
    * switchToNextCourse method
    * switches the user to the next possible course once the categories are finished
    */
    public void switchToNextCourse() {
        CourseList courseList = CourseList.getInstance();
        ArrayList<Course> courses = courseList.getCourses();
        int courseIndex = courses.indexOf(currentCategory);
        int nextIndex = (courseIndex + 1) % courses.size();
        Course nextCourse = courses.get(nextIndex);

        System.out.println("Switched to the next course: " + nextCourse.getCourse());
        resetCategoryProgress();

     }

     /**
     * getProgress method
     * a list of attributes about the user's progress
     * @return progressInfo
     */
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
}



