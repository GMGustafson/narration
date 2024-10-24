package com.language;
/**
 * @author sri
 */
import java.util.ArrayList;
import java.util.Scanner;
public class Category{
    /**
     * attributes for story class
    */
    private String course;
    private ArrayList<Question> questions;

    public Category(String course, ArrayList<Question> questions){
        this.course = course;
        this.questions = questions;
    }

    
    // Getters and setters
    public String getCourse() {
        return course;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public ArrayList<Question> getQuestions() {
        return questions;
    }

    public void setQuestions(ArrayList<Question> questions) {
        this.questions = questions;
    }


    public String toString(){
        return "";
    }

     /**
     * Method to return available category names
     */
    public ArrayList<String> getAvailableCategory() {
        ArrayList<String> categories = new ArrayList<>();
        categories.add("Numbers");
        categories.add("Colors");
        categories.add("People");
        categories.add("Weather");
        categories.add("Places");
        return categories;
    }

    public String chooseCategory(ArrayList<String> categoryNames){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a category");

        for (int i = 0; i < categoryNames.size(); i++) {
            System.out.println((i + 1) + ". " + categoryNames.get(i));
        }

        // would all of this go into the data loader? 
        // checks the user entered a valid number
        int choice = 0;
        while (choice < 1 || choice > categoryNames.size()) {
            System.out.print("You have chosen 1.) Numbers");
            if (scanner.hasNextInt()) {
                choice = scanner.nextInt();
                if (choice < 1 || choice > categoryNames.size()) {
                    System.out.println("Invalid choice. Please select a valid category number.");
                }
            } else {
                System.out.println("Please enter a number.");
                scanner.next(); 
            }
        }
        // show which category the user chose
        String selectedCategory = categoryNames.get(choice - 1);
        System.out.println("Curreny Category: " + selectedCategory);
        return selectedCategory;
    }

    public void saveCategory(){
        System.out.println( course + " saved successfully!");
    }


}

