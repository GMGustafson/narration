package com.language;

import java.util.ArrayList;
import java.util.UUID;

public class Language {
    private UUID languageID;
    private ArrayList<Category> categories;
    private Language language;

    public Language(UUID languageID) {
        this.languageID = UUID.randomUUID();
        this.categories = new ArrayList<>();
    }
    //language ID is a random UUID
    public UUID getLanguageID() 
    {
        return languageID;
    }
    public ArrayList<Category> getCategories() 
    {
        return new ArrayList<>(categories);
        
    }
    public Language getLanguage() {
        return language;
    }


}