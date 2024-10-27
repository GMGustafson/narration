package com.language;
import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// import org.json.simple.JSONArray;
// import java.util.List;
// import java.util.Scanner;

public class Course {
    /**
     * attributes to match courses.json
     */
    private UUID courseID;
    private String course;
    private HashMap<String, ArrayList<Phrase>> phrases = new HashMap<>();
    private HashMap<String, ArrayList<Word>> words = new HashMap<>();
    private String category;
    private HashMap<String, Story> stories;

    public Course(UUID courseID, String course, HashMap<String, ArrayList<Phrase>> phrases,  HashMap<String, ArrayList<Word>>words, String category, HashMap<String, Story> stories ){
        this.courseID = courseID;
        this.course = course;
        this.phrases = phrases;
        this.category = category;
        this.words = words;
        this.stories = stories;
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

    public HashMap<String, ArrayList<Phrase>> getPhrases(){
        return phrases;
    }

    public ArrayList<Phrase> getPhrasesByCategory(String category) {
        return phrases.getOrDefault(category, new ArrayList<>());
    }

    public String getCategory(){
        return category;
    }

    public HashMap<String, ArrayList<Word>> getWords(){
        return words;
    }

    public ArrayList<Word> getWordsByCategory(String category2) {
        return words.getOrDefault(category2, new ArrayList<>());
    }

    public HashMap<String, Story> getStories() {
        return stories;
    }

    public Story getStoriesByCategory(String category) {
        return stories.get(category);
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
    }

     public String toString() {
        String result = "";

        result += "title: " + course + "\n";

        result += "Phrases:\n";

        for (Map.Entry<String, ArrayList<Phrase>> entry : phrases.entrySet()) {
            result += entry.getKey() + " = " ;
            for(Phrase phrase : entry.getValue()){
                result += phrase.toString() + "\n";
            }
            }
        
        result += "Words:\n";

        for (Map.Entry<String, ArrayList<Word>> entry : words.entrySet()) {
            result += entry.getKey() + " = " ;
            for(Word Word : entry.getValue()){
                result += words.toString() + "\n";
            }
            }
        
            // for (String category : stories.keySet()) {
            //     Story story = stories.get(category);
            //     System.out.println("Story Title: " + story.getTitle());
            //     System.out.println("Story Text: " + story.getText());
            //     System.out.println("Story Translations: " + story.getTextTranslation());
            // }   

        return result;

            
     }
}
