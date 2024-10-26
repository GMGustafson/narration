package com.language;
   
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
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
    private Course currentCourse;
    private int progressInCategory;
    private int progressInCourse;
    private int streak;
    private LocalDate loginDate;
    private ArrayList<String> missedWords;
    private Language language;
    private String[] courses = {"Word" , "Phrase"};
    private int courseIndex;
    private int categoryIndex;
    private ArrayList<Category> completedCategories;
    private ArrayList<UUID> completedCourses;
  


    public Progress(int totalQuestionsAnswered, int numCorrectAnswers, Category currentCategory,
    Course currentCourse, int progressInCategory, int streak, Language language) {
        this.totalQuestionsAnswered = totalQuestionsAnswered;
        this.numCorrectAnswers = numCorrectAnswers;
        this.currentCategory = currentCategory;
        this.currentCourse = currentCourse;
        this.progressInCategory = progressInCategory;
        this.streak = streak;
        this.missedWords = new ArrayList<>();
        this.language = language;
        this.completedCategories = new ArrayList<>();
        this.completedCourses = new ArrayList<>();
        // this.categories = currentCourse.getAvailableCourse();
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


    public Category getCurrentCategory() {
        return currentCategory;
    }


    public String getCurrentCourse() {
        return courses[courseIndex];
    }


    public int getProgressInCategory() {
        return progressInCategory;
    }


    public Language getLanguage() {
        return language;
    }


    public void setLanguage(Language language) {
        this.language = language;
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
   
    public void completeCurrentCategory() {
        if (!completedCategories.contains(currentCategory) && progressInCategory >= 5) {
            completedCategories.add(currentCategory);
            goToNextCategory();
        }
        else {
            System.out.println("Current category is not fully complete yet.");
        }
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
            System.out.println("Moving to next category!");
            completeCurrentCategory();
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
        //progressInCategory = 0;


        // Check if current category is complete
        // if (progressInCategory >= currentCourse.getPhrasesByCategory(currentCategory.label).size()) {
        //     categoryIndex++;
        //     progressInCategory = 0; // Reset category progress


        //     // Check if all categories in the current course are completed
        //     if (categoryIndex >= categories.size()) {
        //         categoryIndex = 0; // Reset to the first category
        //         switchToNextCourse(); // Switch to the next course after completing all categories
        //     } else {
        //         currentCategory = Category.values()[categoryIndex];
        //         //currentCategory = new Category(categories.get(categoryIndex), new ArrayList<>());
        //         System.out.println("Advanced to the next category: " + categories.get(categoryIndex));
        //     }
        // }


        progressInCategory = 0;
        while (categoryIndex < Category.values().length - 1 ) {
            categoryIndex++;
            currentCategory = Category.values()[categoryIndex];
        

        if (!completedCategories.contains(currentCategory)) {
            System.out.println("Advanced to the next category: " + currentCategory);
        }
    }
        // if (categoryIndex < Category.values().length - 1) {
        //     categoryIndex++;
        //     currentCategory = Category.values()[categoryIndex];
        //     System.out.println("Advanced to the next category: " + currentCategory);
        // } else {
        //     System.out.println("All categories in this course completed!");
        //     switchToNextCourse();
        // }
        System.out.println("All categories in the course completed!");
        switchToNextCourse();
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

    public void switchToNextCourse() {
        if (!completedCourses.contains(currentCourse.getCourseID())) {
            completedCourses.add(currentCourse.getCourseID());
        }
        String nextCourseName = currentCourse.getCourse().equals("Words") ? "Phrases" : "Words";
        ArrayList<String> availableCourses = currentCourse.getAvailableCourse();

        if (availableCourses.contains(nextCourseName) && !completedCourses.contains(currentCourse.getCourseID())) {
            setCurrentCourse(new Course(UUID.randomUUID(), nextCourseName, currentCourse.getLanguage(),
                                        new HashMap<>(), new HashMap<>(), "beginner", new HashMap<>()));
            System.out.println("Switched to the next course: " + nextCourseName);
        } else {
            System.out.println("No further courses available.");
        }
    }

     //@SuppressWarnings("static-access")
    // public void switchToNextCourse() {
    //     // courseIndex = (courseIndex == 0) ? 1 : 0;
    //     // currentCourse = new Course(null, null, courses[courseIndex],language.toString(), categories, categories.get(courseIndex));
    //     // categories = currentCourse.getCategories();
    //     // currentCategory = new Category(categories.get(categoryIndex), new ArrayList<>());
    //     // System.out.print("Switched to the the otherCourse: "+ getCurrentCourse());
    //     // String[] availableCourses = {"Words", "Phrases"};
    //     // int nextIndex = (currentCourse.getCourse().equals("Words")) ? 1 : 0;
    //     // HashMap<String, ArrayList<Phrase>> phrases = currentCourse.getPhrases();
    //     // HashMap<String, ArrayList<Word>> words = currentCourse.getWords();
    //     // HashMap<String, Story> stories = currentCourse.getStories();
    //     // currentCourse = new Course(null, availableCourses[nextIndex], language.toString(), phrases, words, null, stories);        
    //     // System.out.println("Switched to the next course: " + currentCourse.getCourse());
    //     String nextCourseName = currentCourse.getCourse().equals("Words") ? "Phrases" : "Words";
    //     ArrayList<String> availableCourses = currentCourse.getAvailableCourse();
       
    //     if (availableCourses.contains(nextCourseName)) {
    //         setCurrentCourse(new Course(UUID.randomUUID(), nextCourseName, currentCourse.getLanguage(),
    //                                     new HashMap<>(), new HashMap<>(), "beginner", new HashMap<>()));
    //         System.out.println("Switched to the next course: " + nextCourseName);
    //     } else {
    //         System.out.println("No further courses available.");
    //     }
    // }


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



