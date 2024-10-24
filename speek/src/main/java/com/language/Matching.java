package com.language;
/* @author grace */
import java.util.ArrayList;
import java.util.List;

public class Matching extends Question{

    public Matching(String question) {
        super(question);
        //TODO Auto-generated constructor stub
            }

    private static ArrayList<String> imageList;
    private static ArrayList<String> wordList;  
    

    public static ArrayList<String> getImageList(){
        return imageList;
    }

    public static ArrayList<String> getWordList()
    {
       return wordList; 

    }

    public void setImageList(ArrayList<String> imageList) 
    {
        // check to avoid null-pointer exception
        if(imageList != null){
        this.imageList = imageList;
        }
    }

    public void setWordList(ArrayList<String> wordList)
    {
        if(wordList != null)
        this.wordList = wordList;
    }
} 

