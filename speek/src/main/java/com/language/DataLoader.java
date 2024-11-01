package com.language;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

/**
 * @author zaniah, sri, gracie, and grace
 */

/**
 * The DataLoader class is responsible for loading data from the JSON files.
 * It parses the JSON data and converts it into a list of objects.
 */
public class DataLoader extends DataConstants{
    /**
     * Loads the attributes related to the user and parses them
     * Returns them as userList
     * @return userList
     */
    public static ArrayList<User> getUsers() {
        ArrayList<User> userList = new ArrayList<User>();
        BufferedReader reader = getReaderFromFile(FILE_NAME_USER, FILE_NAME_USER_JUNIT );
    try {
        //InputStream inputStream = DataLoader.class.getResourceAsStream(FILE_NAME_USER); 
        //InputStreamReader inputStreamReader = new InputStreamReader(inputStream); 
        //BufferedReader reader = new BufferedReader(inputStreamReader); 
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
            
            HashMap<Course, Progress> courseProgresses = new HashMap<>();
            JSONArray CoursesJSON = (JSONArray) userJSON.get(USER_COURSES);
            for (int j = 0; j < CoursesJSON.size(); j++) {
                JSONObject courseJSON = (JSONObject) CoursesJSON.get(j);
                UUID courseID = UUID.fromString((String)courseJSON.get(COURSE_ID));

                CourseList courseList = CourseList.getInstance();
                Course course = courseList.getCourseByUUID(courseID);

                JSONObject progressJSON = (JSONObject)courseJSON.get(PROGRESS);
                
                int totalQuestionsAnswered = ((Long) progressJSON.get(TOT_QUESTIONS_ANSWERED)).intValue();
                int numCorrectAnswers = ((Long) progressJSON.get(NUM_CORRECT_ANSWERS)).intValue();
                String currentCategory = (String)progressJSON.get(CURRENT_CATEGORY);
                int progressInCategory = ((Long) progressJSON.get(PROGRESS_IN_CATEGORY)).intValue();
                int streak = ((Long) progressJSON.get(USER_STREAK)).intValue();
                JSONArray missedWordsJSON = (JSONArray)progressJSON.get(MISSED_WORDS);
                ArrayList<String> missedWords = new ArrayList<>();
                for (Object word : missedWordsJSON) {
                    missedWords.add((String) word);
                }
                Progress progress = new Progress(totalQuestionsAnswered, numCorrectAnswers,currentCategory,progressInCategory,streak,missedWords);
                courseProgresses.put(course, progress);
            }
            User newUser = new User(userID, firstName, lastName, email, phoneNumber, dateOfBirth, username, password, courseProgresses);
            
            userList.add(newUser);
        }
            return userList;
        }
        catch (Exception e) {
        e.printStackTrace();
        }
    return null;
    }
            
    /**
     * Loads the attributes related to the Course and parses them
     * Returns them as courseList
     * @return courseList
     */
public static ArrayList<Course> getCourse() {
    ArrayList<Course> courseList = new ArrayList<Course>();
    BufferedReader reader = getReaderFromFile(FILE_NAME_COURSES, FILE_NAME_COURSE_JUNIT );
    
    try {
        //InputStream inputStream = DataLoader.class.getResourceAsStream(FILE_NAME_COURSES); 
        //InputStreamReader inputStreamReader = new InputStreamReader(inputStream); 
        //BufferedReader reader = new BufferedReader(inputStreamReader); 
        JSONArray CoursesJSON = (JSONArray)new JSONParser().parse(reader);

        for (int i=0; i < CoursesJSON.size(); i++) {
            JSONObject CourseJSON = (JSONObject)CoursesJSON.get(i);
            UUID courseID = UUID.fromString(String.valueOf(CourseJSON.get(COURSE_ID)));
            String course = (String)CourseJSON.get(COURSE);
            String category = (String)CourseJSON.get(CURRENT_CATEGORY_TITLE);
            HashMap<String, ArrayList<Phrase>> catPhrases = new HashMap<>();
            HashMap<String, ArrayList<Word>> catWords = new HashMap<>();
            HashMap<String, Story> catStories = new HashMap<>();

            JSONArray categories = (JSONArray)CourseJSON.get(CATEGORIES);
            for (int j=0; j < categories.size(); j++) 
            {
                JSONObject catJSON = (JSONObject)categories.get(j);
                String title = (String)catJSON.get(CATEGORY_TITLE); 
                ArrayList<Word> words = new ArrayList<>();
                JSONArray wordsJSON = (JSONArray)catJSON.get(WORDS); 
                   for (int w=0; w < wordsJSON.size(); w++) 
                    {
                        JSONObject wordJSON = (JSONObject)wordsJSON.get(w);
                        words.add(getWord(wordJSON));
                   }
                catWords.put(title, words);

                
                JSONArray phrasesJSON = (JSONArray)catJSON.get(PHRASES); 
                ArrayList<Phrase> phrases = new ArrayList<Phrase>();
                    for (int w=0; w < phrasesJSON.size(); w++) 
                    {
                        JSONObject phraseJSON = (JSONObject)phrasesJSON.get(w);
                        phrases.add(getPhrase(phraseJSON)); 
                    }
                
                    catPhrases.put(title, phrases);

                JSONObject storyJSON = (JSONObject)catJSON.get(STORY);
                Story story = getStory(storyJSON);
                catStories.put(title, story);
            }
            Course newCourse = new Course(courseID, course, catPhrases, catWords, category, catStories);
            courseList.add(newCourse);
        }
        return courseList;
    }
    catch (Exception e) {
        System.out.println("File not found: " + e.getMessage());
    }
return null;
}

    /**
    * Loads the attributes related to the Phrase and parses them
    * Returns them as newPhrase
    * @return newPhrase
    */
public static Phrase getPhrase(JSONObject phraseJSON) {
    String translation = (String)phraseJSON.get(WORD_TRANSLATION);
    String phraseWords = (String)phraseJSON.get(WORDS);

    Phrase newPhrase = new Phrase (translation, phraseWords);
    return newPhrase;
}

     /**
     * Loads the attributes related to Word and parses them
     * Returns them as newWord
     * @return wordList
     */
public static Word getWord(JSONObject wordJSON) {
    String word = (String)wordJSON.get(WORD);
    String pronunciation = (String)wordJSON.get(WORD_PRONUNCIATION);
    String translation = (String)wordJSON.get(WORD_TRANSLATION);
    JSONArray alternativesJSON = (JSONArray)wordJSON.get(WORD_ALTERNATIVES);
        ArrayList<String> alternatives = new ArrayList<String>();
            for (int w=0; w < alternativesJSON.size(); w++) 
            {
                String alternative = (String)alternativesJSON.get(w);
                alternatives.add(alternative); 
            }
    Word newWord = new Word(word,pronunciation,translation,alternatives); 
    return newWord;  
}

    /**
    * Loads the attributes related to Story and parses them
    * Returns them as newStory
    * @return newStory
    */
public static Story getStory(JSONObject storyJSON) {
    String title = (String)storyJSON.get(TITLE);
    JSONArray textListJSON = (JSONArray)storyJSON.get(TEXT);
    JSONArray textTranslationsJSON = (JSONArray)storyJSON.get(STORY_TRANSLATION);
    String category = (String)storyJSON.get(STORY_CATEGORY);
    
    ArrayList<String> textList = new ArrayList<>();
    ArrayList<String> textTranslations = new ArrayList<>(); 

    for (int j=0; j < textListJSON.size(); j++) 
    { 
        String text = (String)textListJSON.get(j);
        textList.add(text);  
    }
    for (int j=0; j < textTranslationsJSON.size(); j++) 
    { 
        String textTranslation = (String)textTranslationsJSON.get(j); 
        textTranslations.add(textTranslation); 
    }
    
    Story newStory = new Story(title,textList,textTranslations,category);
    return newStory;

}

private static BufferedReader getReaderFromFile(String fileName, String junitFileName){
		try {
			if(isJUnitTest()){
				InputStream inputStream = DataLoader.class.getResourceAsStream(junitFileName);
				InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
				return new BufferedReader(inputStreamReader);
			} else {
				FileReader reader = new FileReader(fileName);
				return new BufferedReader(reader);
			}
		} catch(Exception e){
			System.out.println("Can't load");
			return null;
		}
}



// Main method to test getUsers and other methods

public static void main(String[] args) {
    ArrayList<Course> courseList = getCourse();
    ArrayList<User> users = getUsers();

    if (courseList != null) {
        for (Course course : courseList) {
            System.out.println(course);
        }
    } else {
        System.out.println("Course list is null, possibly due to loading error.");
    }

    if (users != null) {
        for (User user : users) {
            System.out.println(user);
        }
    } else {
        System.out.println("Course list is null, possibly due to loading error.");
    }

  }
}


