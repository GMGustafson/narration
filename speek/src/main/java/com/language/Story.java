package com.language;
/**
 * @author sri
 */
import java.util.ArrayList;
public class Story {
    /**
     * attributes for story class
    */
    private String title;
    private ArrayList<String> text;
    private ArrayList<String> textTranslation;

    public Story (String title, ArrayList<String> text, ArrayList<String> textTranslation) 
    { 
        this.title = title; 
        this.text = text; 
        this.textTranslation = textTranslation; 
    }

    public String getTitle() 
    { 
        return title; 
    }
    
    public ArrayList<String> getText() 
    { 
        return text; 
    }
	
    public  ArrayList<String> getTextTranslation() 
    { 
        return textTranslation; 
    }

    public String toString() {
        String result = "";
        result += title + "--" + text + "--" + textTranslation;
        return result;
    }
    
    
}
