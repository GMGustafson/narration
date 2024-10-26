package com.language;

import java.io.FileReader;
//import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
//import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
//import java.time.format.DateTimeParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
//import org.json.simple.parser.ParseException;

/**
 * The DataLoader class is responsible for loading data from the JSON files.
 * It parses the JSON data and converts it into a list of objects.
 */
public class DataLoader extends DataConstants{
    // Loads the lists of Users
    public static ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<User>();
    try {
        FileReader reader = new FileReader(FILE_NAME_USER);
        //JSONParser parser = new JSONParser();
        JSONArray usersJSON = (JSONArray)new JSONParser().parse(reader);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");

        for (int i=0; i < usersJSON.size(); i++) {
            JSONObject userJSON = (JSONObject)usersJSON.get(i);
            UUID userID = UUID.fromString(String.valueOf(userJSON.get(USER_ID)));
            String firstName = (String)userJSON.get(USER_FIRST_NAME);
            String lastName = (String)userJSON.get(USER_LAST_NAME);
            String email = (String)userJSON.get(USER_EMAIL);
            String phoneNumber = (String)userJSON.get(USER_PHONE_NUMBER);
            String dobString = (String) userJSON.get(USER_DATE_OF_BIRTH);
            LocalDate dateOfBirth = null;
            dateOfBirth = LocalDate.parse(dobString, formatter);
            String username = (String)userJSON.get(USER_USERNAME);
            String password = (String)userJSON.get(USER_PASSWORD);
            
        
            JSONArray CourseJSON = (JSONArray) userJSON.get(USER_COURSES);
            for (int j = 0; j < CourseJSON.size(); j++) {
                JSONObject user = (JSONObject) CourseJSON.get(j);
                UUID course = UUID.fromString(String.valueOf(user.get(USER_ID)));

                //Language languageAt = new Language(languageID, language);
                LanguageList languageAt = LanguageList.getInstance();

                JSONObject progressJSON = (JSONObject)User.get(PROGRESS);
                int totalQuestionsAnswered = ((Long) progressJSON.get(TOT_QUESTIONS_ANSWERED)).intValue();
                int numCorrectAnswers = ((Long) progressJSON.get(NUM_CORRECT_ANSWERS)).intValue();
                String currentCategory = (String)progressJSON.get(CURRENT_CATEGORY);
                int progressInCategory = ((Long) progressJSON.get(PROGRESS_IN_CATEGORY)).intValue();
                int streak = ((Long) progressJSON.get(USER_STREAK)).intValue();
                JSONArray missedWordsJSON = (JSONArray)user.get(MISSED_WORDS);
                ArrayList<String> missedWords = new ArrayList<>();
                for (Object word : missedWordsJSON) {
                    missedWords.add((String) word);
                }

            }
            User newUser = new User(userID, firstName, lastName, email, phoneNumber, dateOfBirth, username, password);
            userList.add(newUser);
        }
            return userList;
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    return null;
    }
            

public static ArrayList<Course> getCourse() {
    ArrayList<Course> courseList = new ArrayList<Course>();
    try {
        FileReader reader = new FileReader(FILE_NAME_COURSES);
        JSONParser parser = new JSONParser();
        JSONArray CoursesJSON = (JSONArray)new JSONParser().parse(reader);

        for (int i=0; i < CoursesJSON.size(); i++) {
            JSONObject CourseJSON = (JSONObject)CoursesJSON.get(i);
            UUID courseID = UUID.fromString(String.valueOf(CourseJSON.get(COURSE_ID)));
            String course = (String)CourseJSON.get(COURSE);
            String language = (String)CourseJSON.get(LANGUAGE);
            String category = (String)CourseJSON.get(CURRENT_CATEGORY_TITLE);
            HashMap<String, ArrayList<Phrase>> catPhrases = new HashMap<>();
            HashMap<String, ArrayList<Word>> catWords = new HashMap<>();
            HashMap<String, Story> catStories = new HashMap<>();

          //  JSONArray categories = (JSONArray) parser.parse(reader); 
            for (int j=0; j < CourseJSON.size(); j++) 
            {
                String title = (String)CourseJSON.get(CATEGORY_TITLE); 
                ArrayList<Word> words = new ArrayList<>();
                JSONArray wordsJSON = (JSONArray)CourseJSON.get(WORDS); 
                   for (int w=0; w < wordsJSON.size(); w++) 
                    {
                        JSONObject wordJSON = (JSONObject)wordsJSON.get(w);
                        words.add(getWord(wordJSON));
                   }
                catWords.put(category, words);

                
                JSONArray phrasesJSON = (JSONArray)CourseJSON.get(PHRASES); 
                ArrayList<Phrase> phrases = new ArrayList<Phrase>();
                    for (int w=0; w < phrasesJSON.size(); w++) 
                    {
                        JSONObject phraseJSON = (JSONObject)phrasesJSON.get(w);
                        phrases.add(getPhrase(phraseJSON)); 
                    }
                
                    catPhrases.put(category, phrases);

                JSONObject storyJSON = (JSONObject)CourseJSON.get(STORY);
                Story story = getStory(storyJSON);
                catStories.put(category, story);
            }
            Course newCourse = new Course(courseID, course, language, catPhrases, catWords, category, catStories);
            courseList.add(newCourse);
        }
        return courseList;
    }
    catch (Exception e) {
    e.printStackTrace();
    }
return null;
}

public static Phrase getPhrase(JSONObject phraseJSON) {
    String translation = (String)phraseJSON.get(WORD_TRANSLATION);
    String phrasewords = (String)phraseJSON.get(WORDS);

    Phrase newPhrase = new Phrase (translation, phrasewords);
    return newPhrase;
}

public static Word getWord(JSONObject wordJSON) {
    String word = (String)wordJSON.get(WORD);
    String pronunciation = (String)wordJSON.get(WORD_PRONUNCIATION);
    String translation = (String)wordJSON.get(WORD_TRANSLATION);
    String alternatives = (String)wordJSON.get(WORD_ALTERNATIVES);

    Word newWord = new Word(word,pronunciation,translation,alternatives); 
    return newWord;  
}


public static Story getStory(JSONObject storyJSON) {
    String title = (String)storyJSON.get(TITLE);
    String text = (String)storyJSON.get(TEXT);
    String storyTranslation = (String)storyJSON.get(STORY_TRANSLATION);
    
    Story newStory = new Story(title,text,storyTranslation);
    return newStory;

}



// Main method to test getUsers

public static void main(String[] args) {
    ArrayList<User> users = getUsers();
    ArrayList<Course> courseList = getCourse();

    if (courseList != null) {
        for (Course course : courseList) {
            System.out.println(course);
        }
    } else {
        System.out.println("Course list is null, possibly due to loading error.");
    }


    if (users != null) {
        if (users.isEmpty()) {
            System.out.println("No users found in the data.");
        } else {
            for (User user : users) {
                System.out.println("User: " + user.getFirstName() + " " + user.getLastName() + ", Email: " + user.getEmail() + " Date of Birth: " + user.getDateOfBirth());
            }
        }
    } else {
        System.out.println("Failed to load user data.");
    }
}
}


