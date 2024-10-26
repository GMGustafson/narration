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
        this.missedWords = missedWords;
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

    public int getProgressInCategory() {
        return progressInCategory;
    }

    public int getStreak() {
        return streak;
    }

    public void setStreak(int streak) {
        this.streak = streak;
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

        // Check if current category is complete
        if (progressInCategory >= currentCourse.getPhrasesByCategory(currentCategory.label).size()) {
            categoryIndex++;
            progressInCategory = 0; // Reset category progress

            // Check if all categories in the current course are completed
            if (categoryIndex >= categories.size()) {
                categoryIndex = 0; // Reset to the first category
                switchToNextCourse(); // Switch to the next course after completing all categories
            } else {
                currentCategory = Category.values()[categoryIndex];
                //currentCategory = new Category(categories.get(categoryIndex), new ArrayList<>());
                System.out.println("Advanced to the next category: " + currentCategory.label);
            }
        }
    }

    
    
    

    /**
     * currentCategory method
     * tracks the currentCategory the user is learning
     */

    public void setCurrentCategory(Category currentCategory){
        this.currentCategory = currentCategory;
    }

    public void setCurrentCourse(Course currentCourse) {
        this.currentCourse = currentCourse;
    }


    public void setProgressInCategory(int progressInCategory){
        this.progressInCategory = progressInCategory;
    }

     //the progress in the category keeps going up//
    //  public void progressInCourse() {  
    //     // how many catergories they complete 
    //     //progressInCourse++; 

    //     if (progressInCourse < 5) {
    //         progressInCourse++;
    //     }
    //     else if (progressInCourse >= 5) {
    //         if (currentCourse.equals("Phrase")) {
    //             currentCourse.setCourse("Word");
    //         }
    //         if (currentCourse.equals("Word")) {
    //             currentCourse.setCourse("Phrase");
    //         }
    //     }
    //     else {
    //         progressInCourse = 0;
    //     }
    //  }

     //@SuppressWarnings("static-access")
    public void switchToNextCourse() {
        // courseIndex = (courseIndex == 0) ? 1 : 0;
        // currentCourse = new Course(null, null, courses[courseIndex],language.toString(), categories, categories.get(courseIndex));
        // categories = currentCourse.getCategories();
        // currentCategory = new Category(categories.get(categoryIndex), new ArrayList<>());
        // System.out.print("Switched to the the otherCourse: "+ getCurrentCourse());
        String[] availableCourses = {"Words", "Phrases"};
        int nextIndex = (currentCourse.getCourse().equals("Words")) ? 1 : 0;
        HashMap<String, ArrayList<Phrase>> phrases = currentCourse.getPhrases();
        HashMap<String, ArrayList<Word>> words = currentCourse.getWords();
        HashMap<String, Story> stories = currentCourse.getStories();
        currentCourse = new Course(null, availableCourses[nextIndex], language.toString(), phrases, words, null, stories);        
        System.out.println("Switched to the next course: " + currentCourse.getCourse());
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



