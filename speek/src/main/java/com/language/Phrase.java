package com.language;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class Phrase {

    private String phraseWords;
    private String translation;

    /**
     * Constructor of Phrase
     * @param translation
     * @param phraseWords
     */
   public Phrase(String translation, String phraseWords) {
    this.phraseWords = phraseWords;
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
