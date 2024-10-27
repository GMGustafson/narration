package com.language;
    
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    private String currentCategory;
    private int progressInCategory;
    private int streak;
    private ArrayList<String> missedWords;

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

    public void resetCategoryProgress() {
        this.totalQuestionsAnswered = 0;
        this.numCorrectAnswers = 0;
        this.progressInCategory = 0;
        this.missedWords.clear();
        System.out.println("Category progress has been reset.");
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

    public String getCurrentCategory() {
        return currentCategory;
    }

    public void setCurrentCategory(String currentCategory){
        this.currentCategory = currentCategory;
    }

    public int getProgressInCategory() {
        return progressInCategory;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
    }

    public void setProgressInCategory(int progressInCategory){
        this.progressInCategory = progressInCategory;
    }

    public ArrayList<String> getMissedWords() {
        return missedWords;
    }

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
        // if (totalQuestionsAnswered == 0) {
        //     System.out.print("The user has not answered any questions yet.");
        // }
        // double perCorrect = (numCorrectAnswers / totalQuestionsAnswered) * 100;
        // if (perCorrect >= 80) {
        //     trackLesson();
        //     progressInCourse();
        // }
        // System.out.print("Tracking the percentage of correct answers. : The percentage of correct answers is: " + perCorrect + "%");

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

    public void goToNextCategory() {
        progressInCategory++;
        if (progressInCategory == 1){
            currentCategory = "numbers";
        }
        if (progressInCategory == 2){
            currentCategory = "colors";
        }
        if (progressInCategory == 3){
            currentCategory = "places";
        }
        if (progressInCategory == 4) {
            currentCategory = "weather";
        }
        if (progressInCategory == 5) {
            currentCategory = "people";
        }
        if (progressInCategory == 6) {
            switchToNextCourse();
        }
        
}


     //@SuppressWarnings("static-access")
    public void switchToNextCourse() {
        String[] availableCourses = {"Words", "Phrases"};
<<<<<<< HEAD
        // if (availableCourses)
=======
        //if (available)
>>>>>>> 6c5b3363886213e46fdf1181ed25dddd7e5507eb
        // int nextIndex = (currentCourse.getCourse().equals("Words")) ? 1 : 0;
        // HashMap<String, ArrayList<Phrase>> phrases = currentCourse.getPhrases();
        // HashMap<String, ArrayList<Word>> words = currentCourse.getWords();
        // HashMap<String, Story> stories = currentCourse.getStories();
        // currentCourse = new Course(null, availableCourses[nextIndex], null, phrases, words, null, stories);        
        // System.out.println("Switched to the next course: " + currentCourse.getCourse());
        // resetCategoryProgress();
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
}



