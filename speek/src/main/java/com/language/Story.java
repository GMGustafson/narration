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
    private ArrayList<String> texttranslation;

    public Story (String title, ArrayList<String> text, ArrayList<String> texttranslation) 
    { 
        this.title = title; 
        this.text = text; 
        this.texttranslation = texttranslation; 
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
        return texttranslation; 
    }

    public String toString() {
        String result = "";
        result += title + "--" + text + "--" + texttranslation;
        return result;
    }
    
}
