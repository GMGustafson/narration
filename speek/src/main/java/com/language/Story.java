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
    private ArrayList<String> storyTranslation;

    public Story (String title, ArrayList<String> text, ArrayList<String> storyTranslation) 
    { 
        this.title = title; 
        this.text = text; 
        this.storyTranslation = storyTranslation; 
    }

    public String getTitle() 
    { 
        return title; 
    }
    
    public ArrayList<String> getText() 
    { 
        return text; 
    }
	
    public  ArrayList<String> getStoryTranslation() 
    { 
        return storyTranslation; 
    }

    public String toString() {
        String result = "";
        result += title + "--" + text + "--" + storyTranslation;
        return result;
    }
    
    
}
