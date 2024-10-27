package com.language;

import java.util.ArrayList;

/**
 * @author zaniah, sri, gracie, and grace
 */

public class Matching extends Question{
<<<<<<< HEAD


    private static ArrayList<String> imageList;
    private static ArrayList<String> wordList;  
    
=======
    private static ArrayList<String> imageList;
    private static ArrayList<String> wordList;  
    
    /**
     *  Constructor for matching
     * @param question
     */
>>>>>>> ebf6383187d35a2c554d32adc15ff4b28b4dc7b8
    public Matching(String question) {
        super(question);
        //TODO Auto-generated constructor stub
            }

<<<<<<< HEAD

=======
    /**
     * getImageList method
     * Returns list of "images"
     * @return imageList
     */
>>>>>>> ebf6383187d35a2c554d32adc15ff4b28b4dc7b8
    public static ArrayList<String> getImageList(){
        return imageList;
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

    /**
     * setImageList method
     * Sets imageList if it is not null
     * @param imageList
     */
    public void setImageList(ArrayList<String> imageList) 
    {
        // check to avoid null-pointer exception
        if(imageList != null){
        this.imageList = imageList;
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

