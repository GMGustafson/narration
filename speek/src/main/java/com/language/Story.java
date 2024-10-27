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

    /**
     * Story constructor method
     * @param title
     * @param text
     * @param storyTranslation
     */
    public Story (String title, ArrayList<String> text, ArrayList<String> storyTranslation) 
    { 
        this.title = title; 
        this.text = text; 
        this.storyTranslation = storyTranslation; 
    }

    /**
     * getTitle method
     * gets the title
     * @return title
     */
    public String getTitle() 
    { 
        return title; 
    }

    /**
     * getText method
     * gets the text
     * @return text
     */
    public ArrayList<String> getText() 
    { 
        return text; 
    }
	
    /**
     * getStoryTranslation method
     * gets the story translation
     * @return storyTranslation
     */
    public  ArrayList<String> getStoryTranslation() 
    { 
        return storyTranslation; 
    }

    /**
     * toString 
     * returns title, text, and storyTranslation in format
     * @return result
     */
    public String toString() {
        String result = "";
        result += title + "--" + text + "--" + storyTranslation;
        return result;
    }
    
    
}
