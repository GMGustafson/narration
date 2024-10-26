package com.language;
import java.util.ArrayList;
/**
 * @author zaniah and grace 
 */
public class Phrase {
    /**
     * attributes for phrase class
     */
    private String phrasewords;
    private String translation;

   public Phrase(String translation, String phrasewords) {
    this.phrasewords = phrasewords;  // Initialize the words list
    this.translation = translation;
}

    
    /**
     * getWords method
     * @return the words that will be in the phrase
     */
    public String getWords(){
        //return "words";
        return phrasewords;
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
        result += phrasewords + ": " + translation;
        return result;
    }
}
