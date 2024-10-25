package com.language;

import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

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
        JSONParser parser = new JSONParser();
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
            
            JSONArray course = (JSONArray) userJSON.get(USER_LANGUAGES);
            for (int j = 0; j < course.size(); j++) {
                JSONObject courses = (JSONObject) course.get(j);
                UUID courseID = UUID.fromString(String.valueOf(courses.get(LANGUAGE_ID)));

                //Language languageAt = new Language(languageID, language);
                LanguageList languageAt = LanguageList.getInstance();

                JSONObject progressJSON = (JSONObject)courses.get(PROGRESS);
                int totalQuestionsAnswered = ((Long) progressJSON.get(TOT_QUESTIONS_ANSWERED)).intValue();
                int numCorrectAnswers = ((Long) progressJSON.get(NUM_CORRECT_ANSWERS)).intValue();
                String currentCategory = (String)progressJSON.get(CURRENT_CATEGORY);
                int progressInCategory = ((Long) progressJSON.get(PROGRESS_IN_CATEGORY)).intValue();
                int streak = ((Long) progressJSON.get(USER_STREAK)).intValue();
                JSONArray missedWordsJSON = (JSONArray)courses.get(MISSED_WORDS);
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
            UUID userID = UUID.fromString(String.valueOf(CourseJSON.get(USER_ID)));
            UUID courseID = UUID.fromString(String.valueOf(CourseJSON.get(COURSE_ID)));
            String course = (String)CourseJSON.get(COURSE);
            String language = (String)CourseJSON.get(LANGUAGE);
            String category = (String)CourseJSON.get(CURRENT_CATEGORY_TITLE);
            

            JSONArray categories = (JSONArray)new JSONParser().parse(reader);
            for (int j=0; j < categories.size(); j++) 
            {
                String title = (String)CourseJSON.get(CATEGORY_TITLE); 
                JSONArray words = (JSONArray)CourseJSON.get(WORDS); 
                   for (int w=0; w < words.size(); w++) 
                    {
                        String word = (String)CourseJSON.get(WORD);
                        String pronunciation = (String)CourseJSON.get(WORD_PRONUNCIATION);
                        String translation = (String)CourseJSON.get(WORD_TRANSLATION);
                        String alternatives = (String)CourseJSON.get(WORD_ALTERNATIVES);

                        Word newWord = new Word(word,pronunciation,translation,alternatives);
                        WordList.add(newWord); 
                   }

                
                JSONArray phrases = (JSONArray)CourseJSON.get(PHRASES); 
                    for (int w=0; w < phrases.size(); w++) 
                    {
                        String translation = (String)CourseJSON.get(WORD_TRANSLATION);
                        String phrasewords = (String)CourseJSON.get(WORDS);

                        Phrase newPhrase = new Phrase (translation, phrasewords);
                        PhraseList.add(newPhrase); 
                    }
            }
            Course newCourse = new Course(userID, courseID, course, language, categories, category);
            courseList.add(newCourse);
        }
        return courseList;
    }
    catch (Exception e) {
    e.printStackTrace();
    }
return null;
}


// Main method to test getUsers

public static void main(String[] args) {
    ArrayList<User> users = getUsers();
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
