package com.language;

import java.util.ArrayList;

/**
 * @author zaniah and grace 
 */

 //what is the difference by changing String to word

public class Word {
    /**
     * attributes for word class
     */
    private String word;
    private String pronunciation;
    private String translation;
    private ArrayList<String> alternatives; 

    public Word(String word, String pronunciation, String translation, ArrayList<String> alternatives) {
       this.word = word;
       this.pronunciation = pronunciation;
       this.translation = translation;
        this.alternatives =alternatives;
    }


    /**
     * getword method
     * @return the letters in the word
     */
    public String getWord(){
        return word;
    }

    /**
     * getPronunciation method
     * @return pronunciation of the word
     */
    public String getPronunciation(){

        return pronunciation;
    }

    /**
     * getTranslation method
     * @return translation of the word
     */
    public String getTranslation(){
        return translation;
    }

    public ArrayList<String> getAlternatives() {
        return new ArrayList<>(alternatives); 
    }

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
