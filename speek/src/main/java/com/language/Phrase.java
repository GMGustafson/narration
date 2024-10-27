package com.language;

/**
 * @author zaniah and grace 
 */
public class Phrase {
    /**
     * attributes for phrase class
     */
    private String phraseWords;
    private String translation;

   public Phrase(String translation, String phraseWords) {
    this.phraseWords = phraseWords;  // Initialize the words list
    this.translation = translation;
}

    
    /**
     * getWords method
     * @return the words that will be in the phrase
     */
    public String getWords(){
        //return "words";
        return phraseWords;
    }

    /**
     * getTranslation method
     * @return the translation of the phrase in diff language
     */
    public String getTranslation(){
        //return "translation";
        return translation;
    }

    public String toString() {
        String result = "";
        result += phraseWords + ": " + translation;
        return result;
    }
}
