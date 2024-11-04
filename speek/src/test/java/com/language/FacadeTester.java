package com.language;

// import com.language.CategorySystemFacade;
// import com.language.User;
// import com.language.UserList;
// import com.language.Course;
// import com.language.CourseList;
// import com.language.Phrase;
// import com.language.Progress;
// import com.language.Word;
// import com.language.Story;
// import com.language.Question;
import static org.junit.Assert.*;

import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import org.junit.Before;
import org.junit.Test;

public class FacadeTester {
    private CategorySystemFacade facade = CategorySystemFacade.getFacadeInstance();

    @Test
    public void loginValidTest() {
        if(!facade.login("johndoe73", "IlovemyCat")){
            System.out.println("Couldn't login John");
            return;
        }
        User user = facade.getCurrentUser();
        assertEquals(user.getUsername(), "johndoe73");
    }

    @Test
    public void testLoadCourses(){

        ArrayList<Course> courses = DataLoader.getCourse();
        assertEquals("There sould be two courses loaded.", 2, courses.size());
        
    }

    @Test
    public void testCreateAccountValid() {
        boolean created = facade.createAccount("John", "Doe", "john@example.com", "johndoe", "password123");
        assertTrue("Expected account to be created successfully", created);
        
        User newUser = UserList.getInstance().getUser("johndoe");
        assertNotNull("New user should be present in UserList", newUser);
        assertEquals("Username should match", "johndoe", newUser.getUsername());
    }

    @Test
    public void testCreateAccountDuplicateUsername() {
        facade.createAccount("Jane", "Doe", "jane@example.com", "janedoe", "password123");
        
        boolean createdDuplicate = facade.createAccount("Janet", "Doe", "janet@example.com", "janedoe", "password456");
        assertFalse( "Account with duplicate username should not be created", createdDuplicate);
    }

    @Test
    public void testCreateSaved() {
        facade.createAccount("Frank", "Marks", "frank.marks@gmail.com", "fmarks", "password123");
        facade.logout("fmarks");

        facade = CategorySystemFacade.getFacadeInstance();
        facade.login("fmarks", "password123");
        User currentUser = facade.getCurrentUser();
        assertEquals("Expected to retrieve username 'fmarks'", "fmarks", currentUser.getUsername());
    }

    @Test
    public void testCreateEmptyUserName() {
        boolean isCreated = facade.createAccount("", "", "invalid@gmail.com", "", "pass");
        assertFalse("Account creation should fail for empty username.", isCreated);
    }

    @Test
    public void testLogout() {
        facade.login ("johndoe73", "IlovemyCat");
        facade.logout("johndoe73");
        assertNull("User should be null after logout", facade.getCurrentUser());
    }

    @Test
    public void testGetCourse() {
        List<String> courseTitles = facade.getCourse();
        assertNotNull("Course titles should not be null", courseTitles);
        assertFalse("Course titles should not be empty", courseTitles.isEmpty());
    }

   

    @Test
    public void testGetCategory() {
        List<String> categories = facade.getCategory();
        List<String> expectedCategories = List.of("Numbers", "Colors", "Places", "Weather", "People");
        assertEquals("Categories should match expected list", expectedCategories, categories);
    }


    @Test
    public void testManageProgressCorrectAnswer() {
        Progress progress = new Progress();
        facade.setProgress(progress);
        facade.manageProgress(true);
        
        assertEquals("Number of correct answers should be 1", 1, progress.getNumCorrectAnswers());
        assertEquals("Total questions answered should be 1",1, progress.getTotalQuestionsAnswered());
    }

    @Test
    public void testManageProgressIncorrectAnswer() {
        Progress progress = new Progress();
        facade.setProgress(progress);
        facade.manageProgress(false);
        
        assertEquals("Number of correct answers should be 0",0, progress.getNumCorrectAnswers());
        assertEquals("Total questions answered should be 1", 1, progress.getTotalQuestionsAnswered());
    }

    @Test
    public void testGetPhrase() {
        List<Phrase> phrases = facade.getPhrase();
        assertNotNull("Phrases should not be null", phrases);
        assertFalse("Phrases list should not be empty", phrases.isEmpty());
    }

    @Test
    public void testGetWord() {
        List<Word> words = facade.getWord();
        assertNotNull("Words should not be null", words);
        assertFalse("Words list should not be empty", words.isEmpty());
    }

    @Test
    public void testGetQuestion() {
        Question question = facade.getQuestion();
        assertNotNull("Question should not be null", question);
        assertTrue("Question text should not be empty", question.getQuestion().length() > 0);
    }

    @Test
    public void testGetMockConversation() {
        MockConversations mockConversation = new MockConversations();
        String topic = mockConversation.getTopic();
        String script = mockConversation.getScript();
        String roles = mockConversation.getRoles();
        String answers = mockConversation.getAnswers();

        assertNotNull("Mock conversation topic should not be null", topic);
        assertNotNull("Mock conversation script should not be null", script);
        assertNotNull("Mock conversation roles should not be null", roles);
        assertNotNull("Mock conversation answers should not be null", answers);
    }

@Test
public void testGetFillintheBlankEmpty() {
    // Create a valid Phrase object (make sure it has a meaningful translation)
    Phrase samplePhrase = new Phrase("Where is the library", "Donde esta la biblioteca?"); // Adjust as necessary
    ArrayList<String> wordBank = new ArrayList<>();
    // Add some words to the wordBank if necessary
    wordBank.add("missing");
    wordBank.add("sample");

    // Instantiate the FillInTheBlank object
    FillInTheBlank fillInBlank = new FillInTheBlank("What is missing?", samplePhrase, wordBank, null);
    String sentence = fillInBlank.getSampleSentence();
    String missingWord = fillInBlank.getMissingWord();

    assertNotNull("Sample sentence should not be null", sentence);
    assertNotNull("Missing word should not be null", missingWord);
    assertTrue("Sentence should contain the missing word", sentence.contains(missingWord));
}


    @Test
public void testGetFillInTheBlankLibrary() {
    // Create a Phrase object
    Phrase phrase = new Phrase("Where is the library?", "Donde esta la biblioteca?");
    
    // Create an empty word bank (can be filled with relevant words if needed)
    ArrayList<String> wordBank = new ArrayList<>();
    wordBank.add("library"); // Adding the expected word for testing
    
    // Create a FillInTheBlank object
    FillInTheBlank fillInBlank = new FillInTheBlank("Where is the library?", phrase, wordBank, null);
    
    // Generate the sample sentence with a missing word
    String sentence = fillInBlank.getSampleSentence();
    
    // Get the missing word for comparison
    String missingWord = fillInBlank.getMissingWord();
    
    // Output the results for debugging
    System.out.println("Generated Sentence: " + sentence);
    System.out.println("Missing Word: " + missingWord);
    
    // Assert that the sentence contains a blank for the missing word
    assertTrue("The sentence should contain a placeholder for the missing word.", sentence.contains("___"));

    // Replace the missing word in the sentence to validate it
    String expectedSentence = sentence.replace(missingWord, "___");
    assertEquals("The generated sentence should match the expected format.", expectedSentence, sentence);
    
    // Example user input for testing
    String userInput = "library"; // This should match the missing word for testing
    
    // Check the answer
    String result = fillInBlank.checkAnswer(userInput);
    
    // Assert the result of the answer check
    assertEquals("Correct!", result); // Assuming that "Correct!" is the expected response for a correct answer
}

    @Test
    public void testGetFlashcards() {
        List<Flashcard> flashcards = facade.getFlashcards();
        assertNotNull("Flashcards should not be null", flashcards);
        assertFalse("Flashcards list should not be empty", flashcards.isEmpty());

        for (Flashcard flashcard : flashcards) {
            assertNotNull("Flashcard word text should not be null", flashcard.getWord());
            assertNotNull("Flashcard translation should not be null", flashcard.getTranslation());
            assertNotNull("Flashcard phrase should not be null", flashcard.getPhrase());
        }
    }

    @Test
    public void testGetMatching() {
        List<String> wordList = Matching.getWordList();
        List<String> translations = Matching.getTranslations();

        assertNotNull("Word list should not be null", wordList);
        assertNotNull("Translations should not be null", translations);
        assertEquals("Word list and translations should be the same size", wordList.size(), translations.size());
    }

    @Test
    public void testGetStory() {
        Story story = facade.getStory();
        assertNotNull("Story should not be null", story);
        assertNotNull("Story text should not be empty", story.getText());
    }


        public static void main(String[] args) {
            org.junit.runner.JUnitCore.main("com.language.FacadeTester");
        }
    }

