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


    public void printStoryNum() {
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
        //System.out.println("You have chosen to learn Spanish");
        facade.chooseLanguage("Spanish");
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

       /**
     * progressLearning method 
     * tracks what the user has learned
     */
    public void progressLearning() {
        facade.manageProgress(isCorrectAnswer);
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
        facade.logout();
        //Show the users.json -> illustrating that Jim is now in the file.
        //showUsers(); 
        // Now have Jim successfully login to the system
        if (facade.login(username, password)) {
            System.out.println("Welcome, " + currentUser.getFirstName() + " " + currentUser.getLastName() + "!");
            chooseLangauage();
            chooseCourse();
            chooseCategory();
            

            Narriator.playSound("Lesson One: Numbers");
            System.out.println("Lets learn some numbers!");
            Narriator.playSound("Title: Lets go grocery Shopping.");
            Narriator.playSound("Text: At the store, Tom buys one red apple. He also looks for two ripe oranges. He finally buys three yellow bannanas.");
            Narriator.playSound("Story Translation: En la tienda, Tom compra una manzana roja. También busca dos naranjas maduras. Finalmente compra tres plátanos amarillos.");
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

             //Flashcards 
             String [] front ={
                "How do you say seven in spanish?", 
                "How do you say eight in spanish?",
                "How do you say ten in spanish?",
               "How do you say four in spanish?",
                "How do you say three in spanish?",
            } ;
                Narriator.playSound("see-yet-eh");
                Narriator.playSound("och-o");
                Narriator.playSound("dee-ace");
                Narriator.playSound("kwat-ro");
                Narriator.playSound("saze"); 
                String [] matching ={
                    "seven", 
                    "three",
                    "ten",
                    "nine",
                    "two",
                } ;
    
                String[] matchingAns = {
                    "siete",
                    "tres",
                    "diez",
                    "uno", 
                    "dos"
                } ;
    
                int correctAnswers2 = 0;
                System.out.println("Matching!");
                for (int i = 0; i < matching.length; i++) {
                    System.out.println(matching[i]);
                    if (i != 4) { 
                        correctAnswers2++;
                    }
                }
                System.out.println("Match the English with Spanish!");
                for (int i = 0; i < matchingAns.length; i++) {
                    System.out.println(matchingAns[i]);
                    if (i != 4) { 
                        correctAnswers2++;
                    }
                }

               
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
            for (int i = 0; i < front.length; i++) {
                System.out.println(front[i]);
                if (i != 4) { 
                    correctAnswers1++;
                }
            }
            ArrayList<String> missedWord = new ArrayList<>();
            progress = new Progress(5, 4, currentCategory.label, 80, 0, missedWord);      
            progress.addMissedWords("Ocho");
            Narriator.playSound("Missed words: Ocho, tres");
            System.out.println("Jim's Progress: " + progress.getProgress());
            progress.trackPercentCorrect();
            Narriator.playSound("You scored an eighty percent");

            Narriator.playSound("Lesson Two: Colors");
            System.out.println("Lets learn some colors!");
            Narriator.playSound("Title: Lets decorate a cake");
            Narriator.playSound("Text: Emily frosts the cake pink. She adds yellow, purple, and blue sprinkles. She tops the cake with five green candles");
            Narriator.playSound("Translation: Emily glasea el pastel de rosa. Agrega chispas amarillas, moradas y azules. Ella cubre el pastel con cinco velas verdes");
            //jim answers questions. gets 3/5
             // Fill in the blank
             String [] fibques2 ={
                "Las fresas son _____", 
                "Los autobuses escolares son ______ ",
                "El ______ y el negro hacen gris",
                "¿Cuál es el número cuatro en español?",
                "____ is pink in spanish.",
                "____ is blue in spanish"
            } ;

            String[] fibans2 = {
                "rojos",
                "amarillos",
                "blanco",
                "naranja", 
                "morado"
            } ;

             //Flashcards 
             String [] front2 ={
                "How do you say blue in spanish?", 
                "How do you say blanco in spanish?",
                "How do you say black in spanish?",
               "How do you say gray in spanish?",
                "How do you say orange in spanish?",
            } ;
                Narriator.playSound("ah-sool");
                Narriator.playSound("ah-mah-ree-yo");
                Narriator.playSound("new-eh-veh");
                Narriator.playSound("roh-ho");
                Narriator.playSound("nah-rahn-ha"); 

            String [] matching2 ={
                "purple", 
                "blue",
                "green",
                "yellow",
                "pink",
            } ;

            String[] matchingAns2 = {
                "rojo",
                "azule",
                "verde",
                "ocho", 
                "rosado"
            } ;
            System.out.println("Matching!");
            for (int i = 0; i < matching2.length; i++) {
                System.out.println(matching2[i]);
                if (i != 4) { 
                    correctAnswers2++;
                }
            }
            System.out.println("Match the English with Spanish!");
            for (int i = 0; i < matchingAns2.length; i++) {
                System.out.println(matchingAns2[i]);
                if (i != 4) { 
                    correctAnswers2++;
                }
            }

            //jim got 3 right and 2 wrong
            for (int i = 0; i < fibques2.length; i++) {
                System.out.println(fibques2[i]);
                if (i != 4) { 
                    correctAnswers1++;
                }
            }
            
            for (int i = 0; i < fibans2.length; i++) {
            //     System.out.println(fibans2[i]);
                if (i != 4) { 
                    correctAnswers1++;
                }
            }
            for (int i = 0; i < front2.length; i++) {
                System.out.println(front2[i]);
                if (i != 4) { 
                    correctAnswers1++;
                }
            }      
        
            ArrayList<String> missedWords = new ArrayList<>();
            progress = new Progress(5, 3, currentCategory.label, 60, 0, missedWords);            
            progress.addMissedWords("rosa");
            progress.addMissedWords("azule");
            progress.addMissedWords("blanco");
            progress.addMissedWords("gray");
            Narriator.playSound("Missed words: rosa, azule, blanco, and gray "); 
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
                System.out.println("You scored below 80% You have to restart the Colors category");


                //chooseCategory();
                
                
                // progress.resetCategoryProgress();
                // for (String question : questions2) {
                //     System.out.println(question);
                //     correctAnswers2++;
                // }
                // progress = new Progress(5, 5, currentCategory.label, 100, 0, missedWords);            
                // System.out.println("Jim's Progress: " + progress.getProgress());
                // progress.trackPercentCorrect();
                // Narriator.playSound("You scored a hundred percent on second attempt");
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

