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
    
	public void start(){
        System.out.println("Let's read " + title);
    }

    public void end(){
        read = true;
        System.out.println("you finished reading " + title);
    }

    public boolean isFinished()
    {
        return read;
    }

    public double getTimeSpent(){
        return 0;
    }

    public static void add(Story newStory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }

    
}
