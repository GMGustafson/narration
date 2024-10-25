package com.language;
/*
 * @author Gracie
 */
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Scanner;
import java.util.UUID;

public class UserInterface {

/*
 * UI attributes
 */
private String sentenceStructure;
    private Category currentCategory;
    private Course currentCourse;
    private Language currentLanguage;
    private Progress progress;
    private int missedWords;
    private int progressInLanguage;
    private HashMap<Word, String> translation;
    private ArrayList<Category> categories;
    private ArrayList<String> languages;
    private ArrayList<Word> wordList;
    private ArrayList<Phrase> phraseList;
    private int languageID;
    private User currentUser;
    private ArrayList<User> userList; 
    private DataWriter dataWriter;

    /**
     * Constructor for UI
     */
    public UserInterface() {
        this.languages = new ArrayList<>();
        this.categories = new ArrayList<>();
        this.userList = new ArrayList<>();
        this.dataWriter = new DataWriter();
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
    
    public void chooseLangauage(){
        System.out.println("You have chosen to learn Spanish");
    }

    public void chooseCourse(){
        currentCourse = new Course(UUID.randomUUID(), "Words", "Spanish", new HashMap<>(), new HashMap<>(), Category.COLORS.label, new HashMap<>());
        System.out.println("You have chosen the 'Words' course in Spanish.");        
        //  Course course = new Course(UUID.randomUUID(), UUID.randomUUID(), null, null, null, null);
        //  ArrayList<String> availableCourses = course.getAvailableCourse();
        //  String chosenCourse= course.chooseCourse(availableCourses);
        //  currentCourse = new Course(UUID.randomUUID(), UUID.randomUUID(), chosenCourse, "Spanish", new ArrayList<>(), "Numbers");
        //  System.out.println("you have chosen the " + chosenCourse + " course");
    }


    public void chooseCategory() {
        currentCategory = Category.COLORS;
        System.out.println("You have chosen the 'Colors' category.");
        // Category category = new Category("", new ArrayList<>());
        // ArrayList<String> availableCategories = category.getAvailableCategory();
        // String chosenCategory = category.chooseCategory(availableCategories);
        // currentCategory = new Category(chosenCategory, new ArrayList<Question>());
        // System.out.println("You have chosen the " + chosenCategory + " category");
    }

       /**
     * progressLearning method 
     * tracks what the user has learned
     */
    public void progressLearning() {
        System.out.print("Tracking the progress of what the user has learned.");
    }

    // Scenario 2: create account
    public void scenarioJim() {
        System.out.println("Scenario: Jim Smith");
        //Prior to this scenario, show that Jim Smith is not in the users.json
        //showUsers();
        //Jim creates a new user account with his specified information.
        String firstName = "Jim";
        String lastName = "Smith";
        String email = "jimsmith@gmail.com";
        String phoneNumber = "643-917-1800";
        LocalDate dateOfBirth = LocalDate.of(2005, 1, 1); 
        String username = "jimsmith44";
        String password = "smithj1";
        createAccount(firstName, lastName, email, phoneNumber, dateOfBirth, username, password);
        //Jim logs out of the system.
        logout();
        //Show the users.json -> illustrating that Jim is now in the file.
        //showUsers(); Do we need a showUsers method in data writer??
        // Now have Jim successfully login to the system
        if (login(username, password)) {
            System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
            chooseLangauage();
            chooseCourse();
            chooseCategory();

            //jim answers questions. gets 4/5
            String[] questions = {
                "What is the Spanish word for red?", // right
                "What is the Spanish word for blue?", // right
                "What is the Spanish word for green?", // right
                "What is the Spanish word for yellow?", // right
                "What is the Spanish word for orange?" // wrong
            };
            String[] answers = {"rojo", "azul", "verde", "amarillo", "naranja"};
            
            int correctAnswers = 0;

            //jim got 4 right and 1 wrong
            for (int i = 0; i < questions.length; i++) {
                System.out.println(questions[i]);
                if (i != 4) { 
                    correctAnswers++;
                }
            }
            progress = new Progress(5, 4, currentCategory, currentCourse, 0, 0, currentLanguage);            System.out.println("Jim's Progress: " + progress.getProgress());
            progress.trackPercentCorrect();

        }
    }
        

     // Main method to test the scenarios
     public static void main(String[] args) {
        UserInterface langUI = new UserInterface();

        langUI.userList.add(new User(UUID.randomUUID(), "Jane", "Smith", "jsmith@gmail.com", "817-902-3201", LocalDate.of(1998, 10, 7), "janesmith10", "IlovemyCat"));
        langUI.userList.add(new User(UUID.randomUUID(), "John", "Doe", "johndoe@gmail.com", "627-917-2739", LocalDate.of(2005, 1, 1), "johndoe73", "IlovemyCat"));

        // run scenarios
        System.out.println("Testing scenarios.");
        //langUI.scenario1(); // login scenario
        langUI.scenarioJim(); // create account
    }

}
