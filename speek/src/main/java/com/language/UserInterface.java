package com.language;
/*
 * @author Gracie
 */
import java.time.LocalDate;
import java.util.ArrayList;
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
        Course course = new Course(UUID.randomUUID(), UUID.randomUUID(), null, null, null, null);
        ArrayList<String> availableCourses = course.getAvailableCourse();
        String chosenCourse= course.chooseCourse(availableCourses);
        currentCourse = new Course(UUID.randomUUID(), UUID.randomUUID(), chosenCourse, "Spanish", new ArrayList<>(), "Numbers");
        System.out.println("You have chosen the " + chosenCourse + " course");
    }


    public void chooseCategory() {
        Category category = new Category("", new ArrayList<>());
        ArrayList<String> availableCategories = category.getAvailableCategory();
        String chosenCategory = category.chooseCategory(availableCategories);
        currentCategory = new Category(chosenCategory, new ArrayList<Question>());
        System.out.println("You have chosen the " + chosenCategory + " category");
    }

    /**
     * progressLearning method 
     * tracks what the user has learned
     */
    public void progressLearning() {
        System.out.print("Tracking the progress of what the user has learned.");
    }

    // public void showUsers(){
    //     DataWriter.printUsers();
    // }



    //  // Scenario 1: simple login
    //  public void scenario1() {
    //     System.out.println("Scenario 1");

    //     // Hardcoded username and password for login
    //     String username = "janesmith10";
    //     String password = "IlovemyCat";

    //     if (login(username, password)) {
    //         System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
    //     }

    //     chooseCategory();
    //     askLogout();
    // }

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
        //showUsers();
        // Now have Jim successfully login to the system
        if (login(username, password)) {
            System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
        }
        chooseLangauage();
        chooseCourse();
        chooseCategory();

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
