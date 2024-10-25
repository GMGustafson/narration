package com.language;
import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;

import org.json.simple.JSONArray;
import java.util.List;
import java.util.Scanner;

public class Course {
    /**
     * attributes to match courses.json
     */
    private UUID userID; 
    private UUID courseID;
    private String course;
    private String language;
    private HashMap<String, ArrayList<Phrase>> phrases = new HashMap<>();
    private HashMap<String, ArrayList<Word>> words = new HashMap<>();
    private String category;
    private HashMap<String, Story> stories;

    public Course(UUID userID, UUID courseID, String course, String language, HashMap<String, ArrayList<Phrase>> phrases,  HashMap<String, ArrayList<Word>>words, String category, HashMap<String, Story> stories ){
        this.userID = userID;
        this.courseID = courseID;
        this.course = course;
        this.language = language;
        this.phrases = phrases;
        this.category = category;
        this.words = words;
        this.stories = stories;
    }

    // public Course(UUID userID, UUID courseID2, String course2, String language2, String category2,
    //         JSONArray categories2) {
    //     //TODO Auto-generated constructor stub
    // }

    public UUID getID(){
        return userID;
    }

    public void setId(UUID ID){
        this.userID = ID;
    }
    
    public UUID getCourseID(){
        return courseID;
    }

    public void setCourseID(UUID courseID){
        this.courseID = courseID;
    }

    public String getCourse(){
        return course;
    }

    public void setCourse(String course){
        this.course = course;
    }

    public String getLanguage(){
        return language;
    }

    public void setLanguage(String language){
        this.language = language;
    }

    public HashMap<String, ArrayList<Phrase>> getPhrases(){
        return phrases;
    }

    public ArrayList<Phrase> getPhrasesByCategory(String category){
        return phrases.get(category);
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String category){
        this.category = category;
    }

     public ArrayList<String> getAvailableCourse() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Phrases");
        courses.add("Words");
        return courses;
    }

    public String chooseCourse(ArrayList<String> courseNames){
        String selectedCourse = "Phrases";
        return selectedCourse;

        //     Scanner scanner = new Scanner(System.in);
    //     System.out.println("Choose a course");
    //     for(int i = 0; i < courseNames.size(); i++){
    //         System.out.println((i + 1) + ". " + courseNames.get(i));
    //     }
    //     int choice = 0;
    //     while (choice < 1 || choice > courseNames.size()) {
    //         System.out.print("You have chosen 1.) Phrases");
    //         if (scanner.hasNextInt()) {
    //             choice = scanner.nextInt();
    //             if (choice < 1 || choice > courseNames.size()) {
    //                 System.out.println("Invalid choice. Please select a valid category number.");
    //             }
    //         } else {
    //             System.out.println("Please enter a number.");
    //             scanner.next(); 
    //         }
    //     }
    //     // show which category the user chose
    //     String selectedCourse = courseNames.get(choice - 1);
    //     System.out.println("Current Course: " + selectedCourse);
    //     return selectedCourse;
     }

}
