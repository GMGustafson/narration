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

    public Story(String title2, String text2, String storyTranslation) {
		//TODO Auto-generated constructor stub
	}

	public void start(){

    }

    public void end(){

    }

    public boolean isFinished()
    {
        return true;
    }

    public double getTimeSpent(){
        return 0;
    }

    public static void add(Story newStory) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'add'");
    }
}
