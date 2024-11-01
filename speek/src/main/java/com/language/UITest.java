package com.language;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class UITest {
    private CategorySystemFacade facade;


    public UITest() {

    }

    public void run() {
        facade = CategorySystemFacade.getFacadeInstance();
        createAccount();
        login();
        chooseLanguage();
        chooseCourse();
        chooseCategory();
        progressLearning();
        logout();

    }

    public void login() {
        if(!facade.login("johndoe73", "IlovemyCat")){
            System.out.println("Couldn't login John");
            return;
        }
        User user = facade.getCurrentUser();
        System.out.println(user.getFirstName() + " " + user.getLastName() + " is now logged in");
    }

    public void logout(){
        if(!facade.logout("johndoe73")){
            System.out.println("User couldnt log out");
            return;
        }
        User user = facade.getCurrentUser();
        if(user != null){
         System.out.println(user.getFirstName() + " " + user.getLastName()+ "is now logged out");
        }
    }

    public void createAccount(){
        User user = new User(null, "john", "Doe", "johndoe@gmail.com", "627-917-2739", LocalDate.of(1998, 10, 7), "Johndoe73", "IlovemyCat");
        facade.setCurrentUser(user);
        if(!facade.addUser()){
            System.out.println("Could not create account");
            return;
        }
        if(user != null){
        System.out.println("Account succesfully created for " + user.getUsername());
        }
        
    }

    public void chooseLanguage(){
        facade.chooseLanguage("Spanish");
    }

     public void chooseCourse() 
     {
         List<String> courses = facade.getCourse(); 
         if (courses.isEmpty()) 
         { 
             System.out.println("No courses available"); 
             return;
         }
        System.out.println("Courses: " + facade.getCourse());
     }


    //  public void chooseCourse(){
    //      if(facade.getCourse().isEmpty()){
    //          System.out.println("Couldnt select course");
    //      }
    //      System.out.println("Youre learning " + Course.getCourse(course));
    //  }

    public void chooseCategory(){
        if(facade.getCategory().isEmpty()){
            System.out.println("Couldnt select category");
        }
        System.out.println("Category: " + Category.NUMBERS);
    }

    
    boolean isCorrectAnswer = true;
    public void progressLearning() {
        // facade.manageProgress(isCorrectAnswer);
        // System.out.print("Tracking the progress of what the user has learned.");
        // //return;

        // int totalQuestionsAnswered = 5;
        // int numCorrectAnswers = 4;
        
        if (facade.getProgress() == null) {
            Progress progress = new Progress(0, 0, "NUMBERS", 0, 0, new ArrayList<>());
            facade.setProgress(progress);
        }
        Progress progress = facade.getProgress();
        
        System.out.println("Total Questions Answered: " + progress.getTotalQuestionsAnswered());
        System.out.println("Number of Correct Answers: " + progress.getNumCorrectAnswers());
        System.out.println("Current Category: " + progress.getCurrentCategory());
        System.out.println("Progress in Category: " + progress.getProgressInCategory());
        System.out.println("Streak: " + progress.getStreak());
        System.out.println("Missed Words: " + progress.getMissedWords());        
    }

    


    public static void main(String[] args){
        UITest tester = new UITest();
        tester.run();
    }
}
