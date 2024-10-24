package com.language;

import java.util.ArrayList;
import java.util.HashMap;

/**
     * @author grace
    */
public class WordList {
    
    private Category category;
    private ArrayList<Word> words;
    HashMap<Category, ArrayList<Word>> hashMap = new HashMap<>();


    public WordList()
    { 
        words = DataLoader.getWords(); 
        category = DataLoader.getCategory();
        hashMap = new HashMap<>();
        hashMap.put(category, words); 
    }


    public static void add(Word newWord) {
        WordList.add(newWord);
    }


    //hashmap category to arraylistwords 


}
