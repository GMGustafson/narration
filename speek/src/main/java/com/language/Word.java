package com.language;

import java.util.ArrayList;
// Hello
/**
 * @author zaniah, sri, gracie, and grace
 */

public class Word {
    private String word;
    private String pronunciation;
    private String translation;
    private ArrayList<String> alternatives; 

    /**
     * Constructor for Word
     * @param word
     * @param pronunciation
     * @param translation
     * @param alternatives
     */
    public Word(String word, String pronunciation, String translation, ArrayList<String> alternatives) {
       this.word = word;
       this.pronunciation = pronunciation;
       this.translation = translation;
        this.alternatives =alternatives;
    }

    /**
     * getword method
     * Returns the letters in the word
     * @return word
     */
    public String getWord(){
        return word;
    }

    /**
     * getPronunciation method
     * Returns pronunciation of the word
     * @return pronunciation
     */
    public String getPronunciation(){

        return pronunciation;
    }

    /**
     * getTranslation method
     * Returns the translation of the word
     * @return translation
     */
    public String getTranslation(){
        return translation;
    }

    /**
     * getAlternatives method
     * Returns new list of alternatives for a word
     * @return alternatives
     */
    public ArrayList<String> getAlternatives() {
        return new ArrayList<>(alternatives); 
    }

    /**
     * toString method
     * Returns attributes of words in a toString format
     * @return result
     */
    public String toString() {
        String result = "";
        result += word + "--" + pronunciation + "--" + translation;
        for (int j = 0; j < alternatives.size(); j++) 
        {
            result += alternatives.get(j) + " "; 
        }
        return result;

}
}