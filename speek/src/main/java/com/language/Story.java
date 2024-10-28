package com.language;

/**
 * @author zaniah, sri, gracie, and grace
 */

import java.util.ArrayList;
public class Story {
    private String category;
    private String title; 
    private ArrayList<String> text;
    private ArrayList<String> storyTranslation;

    /**
     * Story constructor method
     * @param title 
     * @param text
     * @param storyTranslation
     * @param category
     */
    public Story (String title, ArrayList<String> text, ArrayList<String> storyTranslation, String category) 
    { 
        this.category = category;
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
     * getCategory method
     * gets the story category
     * @return category
     */
    public String getCategory() {
        return category;
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
