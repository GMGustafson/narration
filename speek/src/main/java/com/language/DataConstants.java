package com.language;

/**
 * @author zaniah, sri, gracie, and grace
 */

/**
 *  Holds the constant attributes for the DataLoader and DataWriter
 */
public abstract class DataConstants {
 
    //JSON FILES
    //protected static final String FILE_NAME_USER_INTERFACE = "user.json";
    
    protected static final String FILE_NAME_COURSES = "speek/src/main/json/Course.json";
    protected static final String FILE_NAME_COURSE_JUNIT = "/json/Course.json";
    
    protected static final String FILE_NAME_USER = "speek/src/main/json/User.json";
    protected static final String FILE_NAME_USER_JUNIT = "/json/User.json";
    
    //USER JSON 
    protected static final String USER_ID = "userID";
    protected static final String USER_FIRST_NAME = "firstName";
    protected static final String USER_LAST_NAME = "lastName";
    protected static final String USER_EMAIL = "email";
    protected static final String USER_PHONE_NUMBER = "phoneNumber";
    protected static final String USER_DATE_OF_BIRTH = "dateOfBirth";
    protected static final String USER_USERNAME = "username";
    protected static final String USER_PASSWORD = "password";
    protected static final String USER_COURSES = "courses"; 
    protected static final String CURRENT_CATEGORY_TITLE = "title";

    //COURSES - USER JSON 
    protected static final String COURSES = "courses";
    protected static final String COURSE_ID = "courseID";
    protected static final String PROGRESS = "Progress";
    
    //PROGRESS
    protected static final String TOT_QUESTIONS_ANSWERED = "totalQuestionsAnswered";
    protected static final String NUM_CORRECT_ANSWERS = "numCorrectAnswers";
    protected static final String CURRENT_CATEGORY = "currentCategory";
    protected static final String PROGRESS_IN_CATEGORY = "progressInCategory";
    protected static final String USER_STREAK = "streak";
    protected static final String MISSED_WORDS = "missedWords";
    
    //COURSE JSON
    protected static final String LANGUAGE_ID = "courseID";
    protected static final String COURSE = "course";
    protected static final String CATEGORIES = "categories";

    //CATEGORIES
    protected static final String CATEGORY_TITLE = "title";

    //WORDS
    protected static final String WORDS= "words";
    protected static final String NEW_CATEGORY = "category";
    protected static final String WORD = "word";
    protected static final String WORD_PRONUNCIATION = "pronunciation"; 
    protected static final String WORD_TRANSLATION = "translation";
    protected static final String WORD_ALTERNATIVES = "alternatives";
    
    //PHRASES
    protected static final String PHRASES= "phrases";
    protected static final String PHRASE_CATEGORY = "category";
    protected static final String PHRASE_TRANSLATION = "translation";
    protected static final String PHRASE_WORDS = "words";
    
    //STORY
    protected static final String STORY = "story"; 
    protected static final String TITLE = "title"; 
    protected static final String TEXT = "text"; 
    protected static final String STORY_TRANSLATION = "storyTranslation"; 
    protected static final String STORY_CATEGORY = "category";


    public static boolean isJUnitTest() {  
		for (StackTraceElement element : Thread.currentThread().getStackTrace()) {
		  if (element.getClassName().startsWith("org.junit.")) {
			return true;
		  }           
		}
		return false;
	  }
}
