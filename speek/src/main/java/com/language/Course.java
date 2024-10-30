package com.language;
import java.util.UUID;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zaniah, sri, gracie, and grace
 */

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

    /**
     * Course constructor
     * @param courseID
     * @param course
     * @param phrases
     * @param words
     * @param category
     * @param stories 
     */
    public Course(UUID courseID, String course, HashMap<String, ArrayList<Phrase>> phrases,  HashMap<String, ArrayList<Word>>words, String category, HashMap<String, Story> stories ){
        this.courseID = courseID;
        this.course = course;
        this.phrases = phrases;
        this.category = category;
        this.words = words;
        this.stories = stories;
    }

    /**
     * getCourseID method
     * gets courseID
     * @return courseID
     */
    public UUID getCourseID(){
        return courseID;
    }

    /**
    * setCourseID method
    * sets courseID
    * @param courseID
    */
    public void setCourseID(UUID courseID){
        this.courseID = courseID;
    }

    /**
     * getCourse method
     * gets course
     * @return course
     */
    public String getCourse(){
        return course;
    }

    /**
    * setCourse method
    * sets course
    * @param course
    */
    public void setCourse(String course){
        this.course = course;
    }

    /**
     * getPhrases method
     * gets phrases list
     * @return phrases
     */
    public HashMap<String, ArrayList<Phrase>> getPhrases(){
        return phrases;
    }

    /**
     * getPhrasesByCategory
     * gets phrases based on category
     * @param category
     * @return phrases.getOrDefault(category, new ArrayList<>())
     */
    public ArrayList<Phrase> getPhrasesByCategory(String category) {
        return phrases.getOrDefault(category, new ArrayList<>());
    }

    /**
     * getCategory method
     * gets category
     * @return category
     */
    public String getCategory(){
        return category;
    }

    /**
     * getWords method
     * gets list of words
     * @return words
     */
    public HashMap<String, ArrayList<Word>> getWords(){
        return words;
    }

     /**
     * getWordsByCategory method
     * gets words based on category
     * @param category2
     * @return words.getOrDefault(category2, new ArrayList<>())
     */
    public ArrayList<Word> getWordsByCategory(String category2) {
        return words.getOrDefault(category2, new ArrayList<>());
    }

    /**
     * getStories method
     * gets list of stories
     * @return stories
     */
    public HashMap<String, Story> getStories() {
        return stories;
    }

    /**
    * getStoriesByCategory method
    * gets stories based on category
    * @param category
    * @return stories.get(category)
    */
    public Story getStoriesByCategory(String category) {
        return stories.get(category);
    }
    
    /**
    * setCategory method
    * sets category
    * @param category
    */
    public void setCategory(String category){
        this.category = category;
    }

    /**
     * getAvailableCourses method
     * gets available courses
     * @return courses
     */
    public ArrayList<String> getAvailableCourse() {
        ArrayList<String> courses = new ArrayList<>();
        courses.add("Phrases");
        courses.add("Words");
        return courses;
    }

     /**
    * chooseCourse method
    * chooses course from list
    * @param courseNames
    * @return selectedCourse
    */
    public String chooseCourse(ArrayList<String> courseNames){
        String selectedCourse = "Phrases";
        return selectedCourse;
    }

     /**
    * toString method
    * prints out phrases and words in courses
    * @return result
    */
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
        return result;
     }
}
