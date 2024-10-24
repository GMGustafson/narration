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
            


// public static ArrayList<Language> getLanguages() {
//     ArrayList<Language> languageList = new ArrayList<Language>();
//     try {
//         FileReader reader = new FileReader(FILE_NAME_CATEGORY);
//         JSONParser parser = new JSONParser();
//         JSONArray languagesJSON = (JSONArray)new JSONParser().parse(reader);

//         for (int i=0; i < languagesJSON.size(); i++) {
//             JSONObject languageJSON = (JSONObject)languagesJSON.get(i);
//             UUID languageID = UUID.fromString(String.valueOf(languageJSON.get(LANGUAGE_ID)));
//             String language = (String)languageJSON.get(LANGUAGE);
//             String title = (String)languageJSON.get(CATEGORY_TITLE);
//             String question = (String)languageJSON.get(CATEGORY_QUESTION);
//             String currentCategory = (String)languageJSON.get(CURRENT_CATEGORY);
//             int totalQuestionsAnswered = ((Long)languageJSON.get(TOT_QUESTIONS_ANSWERED)).intValue();
//             int progressInCategory = ((Long)languageJSON.get(PROGRESS_IN_CATEGORY)).intValue();
//             int numCorrectAnswers = ((Long)languageJSON.get(NUM_CORRECT_ANSWERS)).intValue();
//             JSONArray missedWordsJSON = (JSONArray)languageJSON.get(MISSED_WORDS);
//             ArrayList<String> missedWords = new ArrayList<>();
//             for (Object word : missedWordsJSON) {
//                 missedWords.add((String) word);
//             }

//            Category newCategory = new Category(currentCategory, totalQuestionsAnswered, progressInCategory, numCorrectAnswers, missedWords);
//            Language newLanguage = new Language(languageID, language, title, question, newCategory);
//            languageList.add(newLanguage);

//         }
//         return languageList;
//     }
//     catch (Exception e) {
//     e.printStackTrace();
//     }
// return null;
// }


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
            for (int j=0; i < categories.size(); j++) 
            {
                String title = (String)CourseJSON.get(CATEGORY_TITLE); 
                JSONArray words = (JSONArray)CourseJSON.get(WORDS); 
                   for (int w=0; i < words.size(); w++) 
                    {
                        String word = (String)CourseJSON.get(WORD);
                        String pronunciation = (String)CourseJSON.get(WORD_PRONUNCIATION);
                        String translation = (String)CourseJSON.get(WORD_TRANSLATION);
                        String alternatives = (String)CourseJSON.get(WORD_ALTERNATIVES);

                        Word newWord = new Word(word,pronunciation,translation,alternatives);
                        WordList.add(newWord); 
                   }

                
                JSONArray phrases = (JSONArray)CourseJSON.get(PHRASES); 
                    for (int w=0; i < phrases.size(); w++) 
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


// // Loads the list of flashcards
//     public static List<Flashcards> loadFlashcards() {
//         List<Flashcards> flashcards = new ArrayList<>();

//         // Try to read and parse the JSON file
//         try (FileReader reader = new FileReader(FILE_NAME_FLASHCARDS)) {
//             JSONParser jsonParser = new JSONParser();
            
//             // Parse the JSON array from the file
//             Object obj = jsonParser.parse(reader);
//             JSONArray flashcardList = (JSONArray) obj;

//             // Iterate through each JSON object in the array and convert it to a Flashcard
//             for (Object flashcardObject : flashcardList) {
//                 JSONObject flashcardJSON = (JSONObject) flashcardObject;

//                 String word = (String) flashcardJSON.get("word");
//                 String translation = (String) flashcardJSON.get("translation");
//                 String phrase = (String) flashcardJSON.get("phrase");
                
//                 // Create a new Flashcard object and add it to the list
//                 Flashcard flashcard = new Flashcard(word, translation, phrase);
//                 flashcards.add(flashcard);
//             }
//         }  catch (IOException | ParseException e) {
//             e.printStackTrace();  // Handle errors in reading or parsing the file
//         }

//         return flashcards;  // Return the list of flashcards
//     }

    // // loads the list of questions
    // public static List<Question> loadQuestions() {
    //     List<Question> questionsList = new ArrayList<>();

    //     // Try to read and parse the JSON file
    //     try (FileReader reader = new FileReader(FILE_NAME_QUESTIONS)) {
    //         JSONParser jsonParser = new JSONParser();
            
    //         // Parse the JSON array from the file
    //         Object obj = jsonParser.parse(reader);
    //         JSONArray flashcardList = (JSONArray) obj;

    //         // Iterate through each JSON object in the array and convert it to a Flashcard
    //         for (Object flashcardObject : flashcardList) {
    //             JSONObject flashcardJSON = (JSONObject) flashcardObject;

    //             String questionFromJson = (String) flashcardJSON.get("Question");
                
                
    //             // Create a new Flashcard object and add it to the list
    //             Question question = new Question(questionFromJson);
    //             questionsList.add(question);
    //         }
    //     }  catch (IOException | ParseException e) {
    //         e.printStackTrace();  // Handle errors in reading or parsing the file
    //     }

    //     return questionsList;  // Return the list of questions
    // }

    
/**
 * Loads the progress data for the user from a JSON file and returns it as a list of Progress objects.
 * This method reads the JSON file, parses the data, and converts it into a list of Progress objects
 * representing the user's progress in different categories.
 *
 * @return A list of Progress objects parsed from the JSON file.
 */
public static List<Progress> loadProgress() {
    List<Progress> progressList = new ArrayList<>();

    // Try to read and parse the JSON file
    try (FileReader reader = new FileReader(FILE_NAME_PROGRESS)) {
        JSONParser jsonParser = new JSONParser();
        
        // Parse the JSON array from the file
        Object obj = jsonParser.parse(reader);
        JSONArray flashcardList = (JSONArray) obj;

        // Iterate through each JSON object in the array and convert it to a Progress object
        for (Object flashcardObject : flashcardList) {
            JSONObject flashcardJSON = (JSONObject) flashcardObject;

            // Extract progress data from the JSON object
            int totalQuestionsAnswered = (Integer) flashcardJSON.get("TotalQuestionAnswered");
            int numCorrectAnswers = (Integer) flashcardJSON.get("NumCorrectAnswers");
            Category currentCategory = (Category) flashcardJSON.get("CurrentCategory");
            int progressInCategory = (Integer) flashcardJSON.get("ProgressinCategory");
            JSONArray missedWords = (JSONArray) flashcardJSON.get("MissedWords");

            // Convert the missed words JSON array into an ArrayList of Strings
            ArrayList<String> result = convertJsonArrayToStringArray(missedWords);

            // Create a new Progress object and populate its fields
            Progress progress = new Progress();
            progress.setTotalQuestionsAnswered(totalQuestionsAnswered);
            progress.setNumCorrectAnswers(numCorrectAnswers);
            progress.setCurrentCategory(currentCategory);
            progress.setProgressInCategory(progressInCategory);
            progress.setMissedWords(result);

            // Add the Progress object to the progress list
            progressList.add(progress);
        }

    } catch (IOException | ParseException e) {
        e.printStackTrace();  // Handle errors in reading or parsing the file
    }

    return progressList;  // Return the list of Progress objects
}


    public static List<Flashcard> loadCategorySystem() {
        List<Flashcard> flashcards = new ArrayList<>();

        // Try to read and parse the JSON file
        try (FileReader reader = new FileReader(FILE_NAME_CATEGORY_SYSTEM)) {
            JSONParser jsonParser = new JSONParser();
            
            // Parse the JSON array from the file
            Object obj = jsonParser.parse(reader);
            JSONArray flashcardList = (JSONArray) obj;

            // Iterate through each JSON object in the array and convert it to a Flashcard
            for (Object flashcardObject : flashcardList) {
                JSONObject flashcardJSON = (JSONObject) flashcardObject;

                String word = (String) flashcardJSON.get("word");
                String translation = (String) flashcardJSON.get("translation");
                String phrase = (String) flashcardJSON.get("phrase");
                
                // Create a new Flashcard object and add it to the list
                Flashcard flashcard = new Flashcard(word, translation, phrase);
                flashcards.add(flashcard);
            }
        }  catch (IOException | ParseException e) {
            e.printStackTrace();  // Handle errors in reading or parsing the file
        }

        return flashcards;  // Return the list of flashcards
    }

    // Method to convert JSONArray to a String array
     private static ArrayList<String> convertJsonArrayToStringArray(JSONArray jsonArray) {
        // Create a String array with the same size as the JSONArray
        ArrayList<String> missedWords = new ArrayList<>();

        // Loop through the JSONArray and extract each element as a String
        for (int i = 0; i < jsonArray.size(); i++) {
            missedWords.add((String) jsonArray.get(i)); // Cast each object to a String
        }

        // Return the String array
        return missedWords;
    }
        
}

    // public static ArrayList<Word> getWords() {
    //     ArrayList<Word> words = new ArrayList<>(); 

    //       // Try to read and parse the JSON file
    //       try (FileReader reader = new FileReader(FILE_NAME_WORDS)) {
    //         JSONParser jsonParser = new JSONParser();
            
    //         // Parse the JSON array from the file
    //         Object obj = jsonParser.parse(reader);
    //         JSONArray wordsList = (JSONArray) obj;

    //         // Iterate through each JSON object in the array and convert it to a Flashcard
    //         for (Object wordObject : wordsList) {
    //             JSONObject wordsJSON = (JSONObject) wordObject;

    //             String category = (String) wordsJSON.get("category"); 
    //             String word = (String) wordsJSON.get("word");
    //             String pronunciation = (String) wordsJSON.get("pronunciation");
    //             String translation = (String) wordsJSON.get("translation");
                
    //             // Create a new Word object (assuming you have a Word constructor defined)
    //             Word newWord = new Word(category, word, pronunciation, translation);
    //             words.add(newWord); 
    //         }
    //     }  catch (IOException | ParseException e) {
    //         e.printStackTrace();  // Handle errors in reading or parsing the file
    //     }

    //     return words;  // Return the list of words
    // }

//     public static ArrayList<Phrase> getPhrases() {

//         ArrayList<Phrase> phrases = new ArrayList<>(); 
    
//               // Try to read and parse the JSON file
//               try (FileReader reader = new FileReader(FILE_NAME_PHRASES)) {
//                 JSONParser jsonParser = new JSONParser();
                
//                 // Parse the JSON array from the file
//                 Object obj = jsonParser.parse(reader);
//                 JSONArray phrasesList = (JSONArray) obj;
    
//                 // Iterate through each JSON object in the array and convert it to a Flashcard
//                 for (Object phraseObject : phrasesList) {
//                     JSONObject phrasesJSON = (JSONObject) phraseObject;
    
//                     String category = (String) phrasesJSON.get("category"); 
//                     String wordsArray= (JSONArray) phrasesJSON.get("words");
//                     String translation = (String) phrasesJSON.get("translation");
                    
//                     Phrase newPhrase = new Phrase(category, wordsArray, translation);
//                     Phrase.add(newPhrase); 
//                 }
//             }  catch (IOException | ParseException e) {
//                 e.printStackTrace();  // Handle errors in reading or parsing the file
//             }
    
//             return phrases;  // Return the list of phrases
//     }


// },



}
}
