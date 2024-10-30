package com.language;

import java.util.ArrayList;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class Matching extends Question{


    private static ArrayList<String> translations;
    private static ArrayList<String> wordList;  
    
    public Matching(String question) {
        super(question);
        //TODO Auto-generated constructor stub
            }

    public static ArrayList<String> getTranslations(){
        return translations;
    }

    /**
     * getWordList method
     * Returns list of words
     * @return wordList
     */
    public static ArrayList<String> getWordList()
    {
       return wordList; 

    }

    
    public void setTranslations(ArrayList<String> translations) 
    {
        // check to avoid null-pointer exception
        if(translations != null){
        this.translations = translations;
        }
    }

    /**
     * setWordList method
     * Sets wordList if it is not null
     * @param wordList
     */
    public void setWordList(ArrayList<String> wordList)
    {
        if(wordList != null)
        this.wordList = wordList;
    }
} 

