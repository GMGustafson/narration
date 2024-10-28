package com.language;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.UUID;

// import org.json.simple.JSONArray;
// import org.json.simple.parser.JSONParser;

import com.narration.Narriator;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class UserInterface{
    /**
    * UI attributes
    */
    private Category currentCategory;
    private Course currentCourse;
    private Progress progress;
    private User currentUser;
    private ArrayList<User> userList; 
    private DataWriter dataWriter;
    private DataLoader dataLoader;
    private Flashcard flashcards;
    private Story story;
    private CategorySystemFacade facade;

    /**
     * Constructor for UI
     */
    public UserInterface() {
        this.userList = new ArrayList<>();
        this.dataWriter = new DataWriter();
        this.dataLoader = new DataLoader();
        facade = CategorySystemFacade.getFacadeInstance();
        }

    /**
     * login method
     * @param username The username
     * @param password The password
     * @return true (placeholder)
     */
    public boolean login(String username, String password) {
        for (User user : userList) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                currentUser = user;
                System.out.println("Login successful for: " + username);
                return true;
            }
        }
        System.out.println("Incorrect username or password!");
        return false;
    }

    /**
     * Logout method
     * logs the user out
     */
    public void logout ()
    { 
        if (currentUser != null) {
            System.out.println("User " + currentUser.getUsername() + " has been logged out.");
            currentUser = null;
          } else {
              System.out.println("No user is currently logged in.");
         }
    }

     /**
     * createAccount method 
     * asks user for information then creates a User object
     */
    @SuppressWarnings("static-access")
    public void createAccount(String firstName, String lastName, String email, String phoneNumber, LocalDate dateOfBirth, String username, String password) {
        System.out.println("Account creation.");

        User newUser = new User(UUID.randomUUID(), firstName, lastName, email, phoneNumber, dateOfBirth, username, password);
        userList.add(newUser);
        System.out.println("Account has been successfully created for: " + username);
        dataWriter.writeUsers(userList); 
    }
    
    /**
     * chooseLanguage method
     * chooses language
     */
    public void chooseLangauage(){
        System.out.println("You have chosen to learn Spanish");
    }

    /**
     * chooseCourse method
     * chooses course and informs the user
     */
    public void chooseCourse(){
        currentCourse = new Course(UUID.randomUUID(), "words", new HashMap<>(), new HashMap<>(), Category.COLORS.label, new HashMap<>());
        //currentCourse = new Course(UUID.randomUUID(), "Words", "Spanish", new HashMap<>(), new HashMap<>(), Category.COLORS.label, new HashMap<>());
        System.out.println("You have chosen the 'Words' course.");        
    }

    /**
     * chooseCategory method
     * chooses category and informs the user
     */
    public void chooseCategory() {
        currentCategory = Category.NUMBERS;
        System.out.println("You have chosen the 'Numbers' category.");
    }
    public void choseStory() {
        story.getTitle();
        story.getText();
        story.getStoryTranslation();

    }

    public void chooseLearning() {
        int answerLearning = 2;
        if (answerLearning == 1) {
            for (int i = 0; i < 5; i++) {
                flashcards.showFlashcard();
            }
        }
        if (answerLearning == 2) {
           // choseStory();
            
        }
        // answerLearning = 2;
    }
       /**
     * progressLearning method 
     * tracks what the user has learned
     */
    public void progressLearning() {
        System.out.print("Tracking the progress of what the user has learned.");
    }

    // Scenario 
    public void scenarioJim() {
        System.out.println("Scenario: Jim Smith");
        //Prior to this scenario, show that Jim Smith is not in the users.json
        //showUsers();
        String username = "jimsmith44";
        String password = "smithj1";
        createAccount("Jim", "Smith", "jimsmith@gmail.com", "643-917-1800", LocalDate.of(2005, 1, 1), "jimsmith44", "smithj1");
        //Jim logs out of the system.
        logout();
        //Show the users.json -> illustrating that Jim is now in the file.
        //showUsers(); 
        // Now have Jim successfully login to the system
        if (login(username, password)) {
            System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
            chooseLangauage();
            chooseCourse();
            chooseCategory();
            //chooseLearning();

            Narriator.playSound("Lesson One: Numbers");
            //jim answers questions. gets 4/5

            // Fill in the blank
            String [] fibques ={
                "Diez menos cuatro es igual a ___", 
                "Dos más ___ es igual a nueve ",
                "___ por dos es igual a ocho",
                "¿Cuál es el número cuatro en español?",
                "____ is five in spanish.",
                "____ is eight in spanish"
            } ;

            String[] fibans = {
                "seis",
                "seite",
                "Cuatro",
                "cinco", 
                "uno"
            } ;
    


            // Numbers story 
            // "title" : "Let's go grocery shopping!",
            //                     "text" : [
            //                         "At the store, Tom buys one red apple.",
            //                         "He also looks for two ripe oranges.",
            //                         "He finally buys three yellow bananas."
            //                     ],
            //                     "storyTranslation" : [
            //                         "En la tienda, Tom compra una manzana roja.",
            //                         "También busca dos naranjas maduras.",
            //                         "Finalmente compra tres plátanos amarillos."
            //                     ]
            

               
            int correctAnswers1 = 0;

            //jim got 4 right and 1 wrong
            for (int i = 0; i < fibques.length; i++) {
                System.out.println(fibques[i]);
                if (i != 4) { 
                    correctAnswers1++;
                }
            }
            
            for (int i = 0; i < fibans.length; i++) {
                System.out.println(fibans[i]);
                if (i != 4) { 
                    correctAnswers1++;
                }
            }
            ArrayList<String> missedWord = new ArrayList<>();
            progress = new Progress(5, 4, currentCategory.label, 80, 0, missedWord);      
            progress.addMissedWords("Ocho");
            Narriator.playSound("Missed word: Ocho");
            System.out.println("Jim's Progress: " + progress.getProgress());
            progress.trackPercentCorrect();
            Narriator.playSound("You scored an eighty percent");

            Narriator.playSound("Lesson Two: Colors");
            //jim answers questions. gets 3/5
            String[] questions2 = {
                "What is the Spanish word for red?", 
                "What is the Spanish word for blue?", 
                "What is the Spanish word for green?", 
                "What is the Spanish word for yellow?", 
                "What is the Spanish word for orange?"  
            };            
            int correctAnswers2 = 0;

            // colors story 
            // "title" : "Let's decorate a cake!",
            // "text" : [
            //     "Emily frosts the cake pink .",
            //     "She adds yellow, purple, and blue sprinkles.",
            //     "She tops the cake with five green candles."
            // ],
            // "storyTranslation" : [
            //     "Emily glasea el pastel de rosa.",
            //     "Agrega chispas amarillas, moradas y azules.",
            //     "Ella cubre el pastel con cinco velas verdes."
            // ]
            //jim got 3 right and 2 wrong
            for (int i = 0; i < questions2.length; i++) {
                System.out.println(questions2[i]);
                if (i != 3) { 
                    correctAnswers2++;
                }
            }
            ArrayList<String> missedWords = new ArrayList<>();
            progress = new Progress(5, 3, currentCategory.label, 60, 0, missedWords);            
            progress.addMissedWords("azul");
            progress.addMissedWords("amarillo");
            Narriator.playSound("Missed words: Azul and Amarillo"); 
            System.out.println("Jim's Progress: " + progress.getProgress());
            progress.trackPercentCorrect();
            Narriator.playSound("You scored a sixty percent. You have to start over");
            logout();
            //showUser()
            if (login("jimsmith44", "smithj1")){
                System.out.println("Welcome back " + currentUser.getFirstName() + " " + currentUser.getLastName());
                //learnStory();
                chooseLangauage();
                chooseCourse();
                //chooseCategory();
                //System.out.println("You scored below 80% You have to restart the Numbers category");
                
                progress.resetCategoryProgress();
                for (String question : questions2) {
                    System.out.println(question);
                    correctAnswers2++;
                }
                progress = new Progress(5, 5, currentCategory.label, 100, 0, missedWords);            
                System.out.println("Jim's Progress: " + progress.getProgress());
                progress.trackPercentCorrect();
                Narriator.playSound("You scored a hundred percent on second attempt");
            }
        }
    }
     /**
      * Main method to run Good Version
      * @param args
      */
     public static void main(String[] args) {
        UserInterface langUI = new UserInterface();
        langUI.userList.add(new User(UUID.randomUUID(), "Jane", "Smith", "jsmith@gmail.com", "817-902-3201", LocalDate.of(1998, 10, 7), "janesmith10", "IlovemyCat"));
        langUI.userList.add(new User(UUID.randomUUID(), "John", "Doe", "johndoe@gmail.com", "627-917-2739", LocalDate.of(2005, 1, 1), "johndoe73", "IlovemyCat"));

        // run scenarios
        System.out.println("Testing scenarios.");
        langUI.scenarioJim(); 
    }


}
