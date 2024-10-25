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
    private ArrayList<String> pictures;
    private ArrayList<String> text;
    private boolean read; //for done reading

    public Story(String title2, String text2, String storyTranslation) {
		//TODO Auto-generated constructor stub
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
