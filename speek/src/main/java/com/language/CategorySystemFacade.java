package language;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
/**
 * @author zaniah and sri
 */
public class CategorySystemFacade {
    /**
     * attributes for the facade
     */
    private User user;
    private Category category;
    private Question question;
    private Phrase phrases;
    private Word words;
    private Language language;
    private Progress progress;

    /**
     * constructor 
     * @param user the user 
     * @param category option for the user to choose how they want to study
     * @param question the question that will be asked to the user when studying
     * @param phrases gives the user option to study phrases in diff language
     * @param words gives the user option to study words in diff language
     * @param language the language the user is studying
     * @param progress how far along the user is in their studies/how active they are
     */
    public CategorySystemFacade(User user, Category category, Question question, Phrase phrases, 
    Word words, Language language, Progress progress){

        this.user = user;
        this.category = category;
        this.question = question;
        this.phrases = phrases;
        this.words = words;
        this.language = language;
        this.progress = progress;
    }

    /**
     * addUser method
     * add user to the system
     * @return true or false if they were successfully added
     */
    public boolean addUser(){
        UserList userList = UserList.getInstance();
        String username = user.getUsername();
        //check if user already exists
        if(userList.getUser(username) != null){
            return false;
        }
        return userList.addUser(user.getFirstName(), user.getLastName(), user.getEmail(), user.getUsername(), user.getPassword());
    }

    /** 
     * login method
     * user can login if they already have an account
     * @return true or false if login is successful
     */
    public boolean login(String username, String password){
        UserList userList = UserList.getInstance();
        User user = userList.getUser(username);
        if (user != null && user.getPassword().equals(password)) {
        this.user = user;
        return true;
        }
        return false; 
    }

    /**
     * getCategory method 
     * list of categories for the user to choose from
     * @return the category that the user chose
     */
    public List<String> getCategory(){
        List<String> categoryNames = new ArrayList<>();
        List<Language> languages = (List<Language>) LanguageList.getInstance().getLanguages();
        for (Language language : languages) {
                for (Category category : language.getCategories()) { 
            if (category != null) {
                categoryNames.add(category.toString());
            }
        }
        }
        return categoryNames;
    }

    /**
     * getProgress method
     * @return the user progress
     */

    public Progress getProgress(){
        if (this.progress == null) {
            System.out.println("No progress has been made yet.");
        }
        return this.progress;
    }

    /**
     * getLanguage method
     * @return the language the user wants to study
     */
    public Language getLanguage(){
        return this.language;
    }

    /**
     * getPhrase method
     * list of phrases for the user to learn/study
     * @return phrase for the user to learn in diff language
     */
    public List<Phrase> getPhraseList(){
        PhraseList phraselist = new PhraseList();
        List<Phrase> phraseList = phraselist.hashMap.get(category);
        return phraseList;
    }

    /**
     * getWord method
     * a list of words for the user to learn/study
     * @return
     */
    public List<Word> getWordList(){
        WordList wordList = new WordList();
        List<Word> words = wordList.hashMap.get(category);
     return words;
    }

    /**
     * getLanguage method
     * @return languages
     */
    public ArrayList getLanguageList(){
        return LanguageList.getInstance().getLanguages();
    }

    /**
     * getQuestion method
     * string representation of questions that could be 
     * asked to user to help vthem learn/study
     * @return a question for the user
     */
    public String getQuestion(){
        //rewrite this shorter
    }

    /**
     * MockConvo method
     * a way for the user to study by having mock conversations
     */
    public void getMockConversation(){
        
        MockConversations mockConversation = new MockConversations();

        String topic = mockConversation.getTopic();
        System.out.println("Mock Conversation Topic: " + topic);

        String script = mockConversation.getScript();
        System.out.println("Conversation Script: " + script);

        String roles = mockConversation.getRoles();
        System.out.println("Mock Conversation Roles: " + roles);

        String answers = mockConversation.getAnswers();
        System.out.println("Possible Answers: " + answers);

    }

    /**
     * getFillBlank method
     * a way for the user to study by answering fill in the blank questions
     */
    public void getFillintheBlank(){
        FillInTheBlank fillInBlank = new FillInTheBlank(null, phrases, null);

        String sentence = fillInBlank.getSampleSentence();
        String missingWord = fillInBlank.getMissingWord();

        System.out.println("Fill in the blank:");
        System.out.println(sentence.replace(missingWord, " "));  
    }

    /**
     * getFlashcard method
     * a way for the user to study with flashcards
     */
    public List<Flashcard> getFlashcards(){

        //need help here- load data from flashcard ask user question
        Category currentCategory = progress.getCurrentCategory();
        List<Flashcard> flashcards = new ArrayList<>();
        return flashcards;
    }

    /**
     * getMatch method
     * a way for the user to study by matching words with an image
     */
    public void getMatching(){
        //fix the static/nonstatic in mathcing class
        List<String> wordList = Matching.getImageList(); //how do i fix this
        List<String> imageList = Matching.getWordList(); 

        System.out.println("Match the words correctly with the corresponding images:");
        for (int i = 0; i < wordList.size(); i++) {
            System.out.println("Word: " + wordList.get(i) + " - Image: " + imageList.get(i));
        }

    }
}
