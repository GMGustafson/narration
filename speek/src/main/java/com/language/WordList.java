package com.language;

import java.util.ArrayList;
import java.util.HashMap;

/**
     * @author grace
    */
public class WordList {
    
    private ArrayList<Course> category;
    private ArrayList<Course> words;
    HashMap<Category, ArrayList<Word>> hashMap = new HashMap<>();


    public WordList()
    { 
        words = DataLoader.getCourse(); 
        category = DataLoader.getCourse();
        hashMap = new HashMap<>();
        hashMap.put(category, words); 
    }


    public static void add(Word newWord) {
        WordList.add(newWord);
    }




}
