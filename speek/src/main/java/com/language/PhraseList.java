package com.language;

import java.util.ArrayList;
import java.util.HashMap;

/**
     * @author grace
    */
public class PhraseList {
    
    private Category category;
    private ArrayList<Phrase> phrases;
    HashMap<Category, ArrayList<Phrase>> hashMap = new HashMap<>();


    public PhraseList()
    { 
        phrases = DataLoader.getCourse(); 
        category = DataLoader.getCourse();
        hashMap.put(category, phrases); 
    }


    public static void add(Phrase newPhrase) {
        PhraseList.add(newPhrase);
    }


    //hashmap category to arraylistwords 


}
