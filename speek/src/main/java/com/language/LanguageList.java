package com.language;

import java.util.ArrayList;

/** @author grace 
 * 
**/

public class LanguageList {
    private ArrayList<Language> languages; 
    private static LanguageList languageList;

    //load content from json
    private LanguageList()
    { 
        languages = DataLoader.getLanguages(); 
    }

    public static LanguageList getInstance()
    { 
        if (languageList == null)
        { 
            languageList = new LanguageList();
        }
        return languageList;
    }

    public ArrayList<Language> getLanguages() 
    { 
        return languages;
    }
}
