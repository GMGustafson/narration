package com.language;

import java.time.LocalDate;
import java.util.ArrayList;

public class UITest {
    private CategorySystemFacade facade;


    public UITest() {

    }

    public void run() {
        facade = CategorySystemFacade.getFacadeInstance();
        createAccount();
        login();
        chooseLangauage();
        //chooseCourse();
        chooseCategory();
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

    public void chooseLangauage(){
        facade.chooseLanguage("Spanish");
    }

    //  public void chooseCourse() 
    //  {
    //      Course course = facade.getCourse(); 
    //      if (course != null) 
    //      { 
    //          System.out.println("User is now learing" + Course.getCourse()); 
    //      }
    //  }
     public void chooseCourse(){
         if(facade.getCourse().isEmpty()){
             System.out.println("Couldnt select course");
         }
         System.out.println("Youre learning " + Course.getAvailableCourse());
     }

    public void chooseCategory(){
        if(facade.getCategory().isEmpty()){
            System.out.println("Couldnt select category");
        }
        System.out.println("You're learning " + Category.NUMBERS);
    }

    
    // boolean isCorrectAnswer = true;
    // public void progressLearning() {
    //     facade.manageProgress(isCorrectAnswer);
    //     System.out.print("Tracking the progress of what the user has learned.");

    //     int totalQuestionsAnswered = 5;
    //     int numCorrectAnswers = 4;
        
    // }

    


    public static void main(String[] args){
        UITest tester = new UITest();
        tester.run();
    }
}
