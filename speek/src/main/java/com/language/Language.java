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
    public Language(UUID userID, UUID courseID, String language2, String question) {
        //TODO Auto-generated constructor stub
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
