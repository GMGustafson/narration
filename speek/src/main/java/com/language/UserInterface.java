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
     * asks if user wants to logout
     */
    public void askLogout() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Do you want to logout? Enter yes or no: ");
        String response = scanner.nextLine().toLowerCase();

        if (response.equals("yes")) {
            logout();
        } else {
            System.out.println("You are still logged in as " + currentUser.getUsername());
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
         Course course = new Course("", new ArrayList<>());
         ArrayList<String> availableCourses = course.getAvailableCourse();
 
         String chosenCourse= course.chooseCourse(availableCourses);
 
         currentCourse = new Course(chosenCourse, new ArrayList<Question>());
    }


    public void chooseCategory() {
        // Create an instance of Category and use it to list and choose categories
        Category category = new Category("", new ArrayList<>());
        ArrayList<String> availableCategories = category.getAvailableCategory();

        // Use the Category class's chooseCategory method
        String chosenCategory = category.chooseCategory(availableCategories);

        // Store the chosen category
        currentCategory = new Category(chosenCategory, new ArrayList<Question>());
    }

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

        String firstName = "Jim";
        String lastName = "Smith";
        String email = "jimsmith@gmail.com";
        String phoneNumber = "643-917-1800";
        LocalDate dateOfBirth = LocalDate.of(2005, 1, 1); 
        String username = "jimsmith44";
        String password = "smithj1";

        createAccount(firstName, lastName, email, phoneNumber, dateOfBirth, username, password);

        // After creating the account, try to log in with the new account
        if (login(username, password)) {
            System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
        }
        

        chooseLangauage();
        chooseCourse();
        chooseCategory();
        askLogout();
    }


     /**
     * progressLearning method 
     * tracks what the user has learned
     */
    public void progressLearning() {
        System.out.print("Tracking the progress of what the user has learned.");
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
