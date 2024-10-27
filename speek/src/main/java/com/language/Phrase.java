package com.language;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class Phrase {
<<<<<<< HEAD
    /**
     * attributes for phrase class
     */
    private String phraseWords;
    private String translation;

   public Phrase(String translation, String phraseWords) {
    this.phraseWords = phraseWords;  // Initialize the words list
=======

    private String phrasewords;
    private String translation;

    /**
     * Constructor of Phrase
     * @param translation
     * @param phrasewords
     */
   public Phrase(String translation, String phrasewords) {
    this.phrasewords = phrasewords;
>>>>>>> ebf6383187d35a2c554d32adc15ff4b28b4dc7b8
    this.translation = translation;
    }

    /**
     * getWords method
     * Returns words in phrase
     * @return phraseWords
     */
    public String getWords(){
        //return "words";
        return phraseWords;
    }

    /**
     * getTranslation method
     * Returns translation in the different language
     * @return translation
     */
    public String getTranslation(){
        return translation;
    }

    /**
     * toString method
     * Returns phraseWords and translation in toString format
     * @return result
     */
    public String toString() {
        String result = "";
        result += phraseWords + ": " + translation;
        return result;
    }
}
